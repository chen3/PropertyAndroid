package cn.qiditu.property;

import android.support.annotation.NonNull;

final class Lazy<T> {

    @SuppressWarnings("unused")
    Lazy(@NonNull LazyFunc<T> lazyFunc) {
        this.lazyFunc = lazyFunc;
    }

    private T value;
    private LazyFunc<T> lazyFunc;

    @SuppressWarnings("unused")
    @NonNull
    T get() {
        if(lazyFunc != null) {
            return compute();
        }
        else {
            return value;
        }
    }

    @NonNull
    private synchronized T compute() {
        if (lazyFunc != null) {
            value = lazyFunc.init();
            lazyFunc = null;
        }
        return value;
    }

    @SuppressWarnings("WeakerAccess")
    public interface LazyFunc<T> {
        @SuppressWarnings("unused")
        @NonNull
        T init();
    }

}