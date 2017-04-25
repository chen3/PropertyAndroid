package cn.qiditu.property;

import android.support.annotation.NonNull;

import cn.qiditu.signalslot.signals.Signal1;

@SuppressWarnings("WeakerAccess")
public interface INonNullReadProperty<T> extends IProperty<T> {

    @NonNull
    Signal1<T> changed();

    @NonNull
    T get();

}
