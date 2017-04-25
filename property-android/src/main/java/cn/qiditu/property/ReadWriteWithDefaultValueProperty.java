package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ReadWriteWithDefaultValueProperty<T> extends ReadWriteProperty<T> {

    public ReadWriteWithDefaultValueProperty(@NonNull T valueAndDefaultValue) {
        this(valueAndDefaultValue, valueAndDefaultValue);
    }

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

    @NonNull
    public T getDefaultValue() {
        return defaultValue;
    }

}
