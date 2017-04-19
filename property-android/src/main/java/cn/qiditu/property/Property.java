package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import cn.qiditu.signalslot.signals.Signal1;

@SuppressWarnings("WeakerAccess")
public class Property<T> {

    T value = null;

    @SuppressWarnings("unused")
    public Property() {
    }

    @SuppressWarnings("unused")
    public Property(@Nullable T value) {
        this.value = value;
    }

    @SuppressWarnings("unused")
    public Property(@NonNull WriteProperty<T> write) {
        this(write, null);
    }

    @SuppressWarnings("WeakerAccess")
    public Property(@NonNull WriteProperty<T> write, @Nullable T value) {
        write.read = this;
        this.value = value;
    }

    @SuppressWarnings("WeakerAccess")
    public final Signal1<T> changed = new Signal1<>(this);

    @SuppressWarnings("WeakerAccess")
    @Nullable
    public T get() {
        return value;
    }

    @SuppressWarnings("unused")
    @Nullable
    public T read() {
        return get();
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
