package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import cn.qiditu.signalslot.signals.Signal1;

@SuppressWarnings("WeakerAccess")
public class ReadProperty<T> implements IReadProperty<T> {

    @SuppressWarnings("WeakerAccess")
    protected T value = null;

    @SuppressWarnings({"WeakerAccess", "unused"})
    public ReadProperty(@Nullable T value) {
        this.value = value;
    }

    @SuppressWarnings("WeakerAccess")
    protected final Signal1<T> changed = new Signal1<>(this);

    @NonNull
    @Override
    public final Signal1<T> changed() {
        return changed;
    }

    @SuppressWarnings("WeakerAccess")
    @Nullable
    @Override
    public T get() {
        return value;
    }

    @NonNull
    @Override
    public T get(@NonNull T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public final boolean isReadable() {
        return true;
    }

    @Override
    public boolean isWritable() {
        return false;
    }


    @Override
    public String toString() {
        return value.toString();
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(@Nullable Object obj) {
        return value.equals(obj);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
