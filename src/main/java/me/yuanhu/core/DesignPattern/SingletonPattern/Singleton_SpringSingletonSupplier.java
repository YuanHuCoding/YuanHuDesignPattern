//package me.yuanhu.core.DesignPattern.SingletonPattern;
//
//import org.springframework.lang.Nullable;
//import org.springframework.util.Assert;
//
//import java.util.function.Supplier;
//
////Spring中的单例实现
////https://www.jianshu.com/p/123dfa087d65
//public class Singleton_SpringSingletonSupplier <T> implements Supplier<T> {
//
//    @Nullable
//    private final Supplier<? extends T> instanceSupplier;
//
//    @Nullable
//    private final Supplier<? extends T> defaultSupplier;
//
//    @Nullable
//    private volatile T singletonInstance;
//
//
//    /**
//     * Build a {@code SingletonSupplier} with the given singleton instance
//     * and a default supplier for the case when the instance is {@code null}.
//     * @param instance the singleton instance (potentially {@code null})
//     * @param defaultSupplier the default supplier as a fallback
//     */
//    public Singleton_SpringSingletonSupplier(@Nullable T instance, Supplier<? extends T> defaultSupplier) {
//        this.instanceSupplier = null;
//        this.defaultSupplier = defaultSupplier;
//        this.singletonInstance = instance;
//    }
//
//    /**
//     * Build a {@code SingletonSupplier} with the given instance supplier
//     * and a default supplier for the case when the instance is {@code null}.
//     * @param instanceSupplier the immediate instance supplier
//     * @param defaultSupplier the default supplier as a fallback
//     */
//    public Singleton_SpringSingletonSupplier(@Nullable Supplier<? extends T> instanceSupplier, Supplier<? extends T> defaultSupplier) {
//        this.instanceSupplier = instanceSupplier;
//        this.defaultSupplier = defaultSupplier;
//    }
//
//    private Singleton_SpringSingletonSupplier(Supplier<? extends T> supplier) {
//        this.instanceSupplier = supplier;
//        this.defaultSupplier = null;
//    }
//
//    private Singleton_SpringSingletonSupplier(T singletonInstance) {
//        this.instanceSupplier = null;
//        this.defaultSupplier = null;
//        this.singletonInstance = singletonInstance;
//    }
//
//
//    /**
//     * Get the shared singleton instance for this supplier.
//     * @return the singleton instance (or {@code null} if none)
//     */
//    @Override
//    @Nullable
//    public T get() {
//        T instance = this.singletonInstance;
//        if (instance == null) {
//            synchronized (this) {
//                instance = this.singletonInstance;
//                if (instance == null) {
//                    if (this.instanceSupplier != null) {
//                        instance = this.instanceSupplier.get();
//                    }
//                    if (instance == null && this.defaultSupplier != null) {
//                        instance = this.defaultSupplier.get();
//                    }
//                    this.singletonInstance = instance;
//                }
//            }
//        }
//        return instance;
//    }
//
//    /**
//     * Obtain the shared singleton instance for this supplier.
//     * @return the singleton instance (never {@code null})
//     * @throws IllegalStateException in case of no instance
//     */
//    public T obtain() {
//        T instance = get();
//        Assert.state(instance != null, "No instance from Supplier");
//        return instance;
//    }
//
//
//    /**
//     * Build a {@code SingletonSupplier} with the given singleton instance.
//     * @param instance the singleton instance (never {@code null})
//     * @return the singleton supplier (never {@code null})
//     */
//    public static <T> Singleton_SpringSingletonSupplier<T> of(T instance) {
//        return new Singleton_SpringSingletonSupplier<>(instance);
//    }
//
//    /**
//     * Build a {@code SingletonSupplier} with the given singleton instance.
//     * @param instance the singleton instance (potentially {@code null})
//     * @return the singleton supplier, or {@code null} if the instance was {@code null}
//     */
//    @Nullable
//    public static <T> Singleton_SpringSingletonSupplier<T> ofNullable(@Nullable T instance) {
//        return (instance != null ? new Singleton_SpringSingletonSupplier<>(instance) : null);
//    }
//
//    /**
//     * Build a {@code SingletonSupplier} with the given supplier.
//     * @param supplier the instance supplier (never {@code null})
//     * @return the singleton supplier (never {@code null})
//     */
//    public static <T> Singleton_SpringSingletonSupplier<T> of(Supplier<T> supplier) {
//        return new Singleton_SpringSingletonSupplier<>(supplier);
//    }
//
//    /**
//     * Build a {@code SingletonSupplier} with the given supplier.
//     * @param supplier the instance supplier (potentially {@code null})
//     * @return the singleton supplier, or {@code null} if the instance supplier was {@code null}
//     */
//    @Nullable
//    public static <T> Singleton_SpringSingletonSupplier<T> ofNullable(@Nullable Supplier<T> supplier) {
//        return (supplier != null ? new Singleton_SpringSingletonSupplier<>(supplier) : null);
//    }
//
//}