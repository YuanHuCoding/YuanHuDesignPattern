package me.yuanhu.core.DesignPattern.ObserverPattern.JDK;


import java.util.Vector;

/**
 * This class represents an observable object, or "data"
 * in the model-view paradigm. It can be subclassed to represent an
 * object that the application wants to have observed.
 * <p>
 * An observable object can have one or more observers. An observer
 * may be any object that implements interface <tt>Observer</tt>. After an
 * observable instance changes, an application calling the
 * <code>Observable</code>'s <code>notifyObservers</code> method
 * causes all of its observers to be notified of the change by x call
 * to their <code>update</code> method.
 * <p>
 * The order in which notifications will be delivered is unspecified.
 * The default implementation provided in the Observable class will
 * notify Observers in the order in which they registered interest, but
 * subclasses may change this order, use no guaranteed order, deliver
 * notifications on separate threads, or may guarantee that their
 * subclass follows this order, as they choose.
 * <p>
 * Note that this notification mechanism has nothing to do with threads
 * and is completely separate from the <tt>wait</tt> and <tt>notify</tt>
 * mechanism of class <tt>Object</tt>.
 * <p>
 * When an observable object is newly created, its set of observers is
 * isEmpty. Two observers are considered the same if and only if the
 * <tt>equals</tt> method returns true for them.
 *
 * @author  Chris Warth
 * @see     java.util.Observable#notifyObservers()
 * @see     java.util.Observable#notifyObservers(Object)
 * @see     java.util.Observer
 * @see     java.util.Observer#update(java.util.Observable, Object)
 * @since   JDK1.0
 */
public class Observable {
    //该类中含有一个boolean型的变量changed，代表是否发生改变了，Observable类只提供这个boolean值来表明是否发生变化，
    // 而不定义什么叫变化，因为每个业务中对变化的具体定义不一样，因此子类自己来判断是否变化；该变量既提供了一种抽象(变与不变)，
    // 同时提供了一种观察者更新状态的可延迟加载，通过后面的notifyObservers方法分析可知观察者是否会调用update方法，依赖于changed变量，
    // 因此即使被观察者在逻辑上发生改变了，只要不调用setChanged，update是不会被调用的。如果我们在某些业务场景不需要频繁触发update，
    // 则可以适时调用setChanged方法来延迟刷新。
    private boolean changed = false;

    //1.8的jdk源码为Vector，有版本的源码是ArrayList的集合实现；
    //Vector这个类和ArrayList的继承体系是一致，主要有两点不同，一是Vector是线程安全的，ArrayList不是线程安全的，
    // Vector的操作依靠在方法上加了同步关键字来保证线程安全，与此同时ArrayList的性能是要好于Vector的；
    // 二是Vector和ArrayList扩容阀值不太一样，ArrayList较Vector更节省空间；
    private Vector<Observer> obs;//Vector是ArrayList的线程安全版本

    /** Construct an Observable with zero Observers. */

    public Observable() {
        obs = new Vector<>();
    }

    /**
     * Adds an observer to the set of observers for this object, provided
     * that it is not the same as some observer already in the set.
     * The order in which notifications will be delivered to multiple
     * observers is not specified. See the class comment.
     *
     * @param   o   an observer to be added.
     * @throws NullPointerException   if the parameter o is null.
     */
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) { //不能重复添加
            obs.addElement(o);
        }
    }

    /**
     * Deletes an observer from the set of observers of this object.
     * Passing <CODE>null</CODE> to this method will have no effect.
     * @param   o   the observer to be deleted.
     */
    public synchronized void deleteObserver(Observer o) {
        obs.removeElement(o);
    }

    /**
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers
     * and then call the <code>clearChanged</code> method to
     * indicate that this object has no longer changed.
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and <code>null</code>. In other
     * words, this method is equivalent to:
     * <blockquote><tt>
     * notifyObservers(null)</tt></blockquote>
     *
     * @see     java.util.Observable#clearChanged()
     * @see     java.util.Observable#hasChanged()
     * @see     java.util.Observer#update(java.util.Observable, Object)
     */
    public void notifyObservers() {
        notifyObservers(null);
    }

    /**
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers
     * and then call the <code>clearChanged</code> method to indicate
     * that this object has no longer changed.
     * <p>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and the <code>arg</code> argument.
     *
     * @param   arg   any object.
     * @see     java.util.Observable#clearChanged()
     * @see     java.util.Observable#hasChanged()
     * @see     java.util.Observer#update(java.util.Observable, Object)
     */
    public void notifyObservers(Object arg) {
        /*
         * x temporary array buffer, used as x snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;

        synchronized (this) {
            /* We don't want the Observer doing callbacks into
             * arbitrary code while holding its own Monitor.
             * The code where we extract each Observable from
             * the Vector and store the state of the Observer
             * needs synchronization, but notifying observers
             * does not (should not).  The worst result of any
             * potential race-condition here is that:
             * 1) x newly-added Observer will miss x
             *   notification in progress
             * 2) x recently unregistered Observer will be
             *   wrongly notified when it doesn't care
             */
/*
先不看源码，想想应该怎么做呢？通知观察者们进行刷新操作，不就是用for循环一个一个操作集合中的Observer调用update方法嘛，这还不简单，于是版本一产生：

//版本一
public void notifyObservers(Object arg) {
    if(changed){
        for (int i = 0; i<obs.size(); i++)
            obs.get(i).update(this, arg);
    }
}
看看版本一，很容易发现，该方法会出很多问题，首先调用了所有的观察者的update方法，但是没有清除被观察的变化状态，由于changed变量状态没有重置，因此，如果notifyObservers被多次调用，即使Observable没有再发生变化，所有观察者的update方法已经会被执行。因此需要进行修改，如下：

//版本二
public void notifyObservers(Object arg) {
    clearChanged();
    if(changed){
        for (int i = 0; i<obs.size(); i++)
            obs.get(i).update(this, arg);
    }
}
看看版本二，依旧有问题，如果出现并发时，各线程对changed变量的读写操作不安全，可能出现脏读因此产生重复update或者不能update的情况，因此需要进行修改，如下：

//版本三
public synchronized void notifyObservers(Object arg) {
    clearChanged();
    for (int i = 0; i<obs.size(); i++)
        obs.get(i).update(this, arg);
}
看看版本三，不会出现并发造成的变量状态不一致带来的错误操作，但是想一想观察者数量较多时或者update方法执行时间较长时，被观察者变化后，notifyObservers的执行时间大大增加，呈线性增长，比如并发数是20，而此时有10个线程发生changed并且调用了notifyObservers方法，那么10个线程执行该方法将进入同步，粗略计算耗时为10*for循环执行时长，因此需要进行修改，我们只对changed变量的读写部分加锁，不会引起变量状态的不一致性，同时当同步块的代码执行完毕后，该线程可以先去执行耗时的for循环，修改如下：

//版本四
public void notifyObservers(Object arg) {
    synchronized (this) {
        if (!changed)
           return;
        clearChanged();
    }
    for (int i = 0; i<obs.size(); i++)
        obs.get(i).update(this, arg);
}
看看版本四，发现还是存在问题虽然解决了耗，但依旧会有问题，多线程在同步块进行了同步，但是执行for循环的时候，由于调用者可能不断在增删观察者，假如A线程刚执行完i

//源码的方案
public void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.size-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }
源码果然很严谨！！！
            * */

            if (!changed)
                return;
            //　对Observers做了个缓存，为什么要做这个缓存？
            //　　我们考虑下如果不做这个缓存会怎么样，当某个线程遍历到一半时，另一个线程删除了它将要遍历的元素，那就会发生NullPointerException了。而且这样缓存后可以提供更好的并发性，因为多个线程可以同时迭代列表。
            //　　
            //　　不过做了这个缓存后就可能会出现上面代码作者所说的两个问题：
            //　　一方面不该通知的被通知了，比如一个线程已经把某个Observer删除了，表示它不需要被通知了，另一个线程还是会通知它。
            //　　另一方面是该通知的没被通知到，比如如果一个线程加了个Observer，希望它会被通知到，但另一个线程在遍历进行update时，不会通知到它，这个Observer就会错过这次通知。
            arrLocal = obs.toArray();
            clearChanged();
        }

        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }

    /**
     * Clears the observer list so that this object no longer has any observers.
     */
    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    /**
     * Marks this <tt>Observable</tt> object as having been changed; the
     * <tt>hasChanged</tt> method will now return <tt>true</tt>.
     */
    protected synchronized void setChanged() {
        changed = true;
    }

    /**
     * Indicates that this object has no longer changed, or that it has
     * already notified all of its observers of its most recent change,
     * so that the <tt>hasChanged</tt> method will now return <tt>false</tt>.
     * This method is called automatically by the
     * <code>notifyObservers</code> methods.
     *
     * @see     java.util.Observable#notifyObservers()
     * @see     java.util.Observable#notifyObservers(Object)
     */
    protected synchronized void clearChanged() {
        changed = false;
    }

    /**
     * Tests if this object has changed.
     *
     * @return  <code>true</code> if and only if the <code>setChanged</code>
     *          method has been called more recently than the
     *          <code>clearChanged</code> method on this object;
     *          <code>false</code> otherwise.
     * @see     java.util.Observable#clearChanged()
     * @see     java.util.Observable#setChanged()
     */
    public synchronized boolean hasChanged() {
        return changed;
    }

    /**
     * Returns the number of observers of this <tt>Observable</tt> object.
     *
     * @return  the number of observers of this object.
     */
    public synchronized int countObservers() {
        return obs.size();
    }
}
