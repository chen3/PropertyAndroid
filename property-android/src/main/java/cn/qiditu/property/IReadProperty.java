package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import cn.qiditu.signalslot.signals.Signal1;

@SuppressWarnings("WeakerAccess")
public interface IReadProperty<T> extends IProperty<T> {

    @NonNull
    Signal1<T> changed();

    @Nullable
    T get();

    @SuppressWarnings("unused")
    @NonNull
    T get(@NonNull T defaultValue);

}
