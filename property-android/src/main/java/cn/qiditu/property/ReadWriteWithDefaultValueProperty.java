package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@SuppressWarnings("unused")
public class ReadWriteWithDefaultValueProperty<T> extends ReadWriteProperty<T> {

    @SuppressWarnings("unused")
    public ReadWriteWithDefaultValueProperty(@NonNull T valueAndDefaultValue) {
        this(valueAndDefaultValue, valueAndDefaultValue);
    }

    @SuppressWarnings("WeakerAccess")
    public ReadWriteWithDefaultValueProperty(@Nullable T value, @NonNull T defaultValue) {
        super(value);
        this.defaultValue = defaultValue;
    }

    private final T defaultValue;

    @NonNull
    @Override
    public T get() {
        return super.get(defaultValue);
    }

    @Override
    public void set(@Nullable T value) {
        super.set(value == null ? defaultValue : value);
    }

    @SuppressWarnings("unused")
    @NonNull
    public T getDefaultValue() {
        return defaultValue;
    }

}
