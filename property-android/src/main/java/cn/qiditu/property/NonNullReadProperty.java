package cn.qiditu.property;

import android.support.annotation.NonNull;

public class NonNullReadProperty<T> extends ReadProperty<T> implements INonNullReadProperty<T> {

    public NonNullReadProperty(@NonNull T value) {
        super(value);
    }

    @NonNull
    @Override
    public T get() {
        final T value = super.get();
        if(value == null) {
            throw new RuntimeException();
        }
        return value;
    }

}
