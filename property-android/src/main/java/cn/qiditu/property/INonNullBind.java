package cn.qiditu.property;

import android.support.annotation.NonNull;

@SuppressWarnings("WeakerAccess")
public interface INonNullBind<T> {

    @SuppressWarnings("unused")
    @NonNull
    INonNullReadProperty<Boolean> isBind();

    @SuppressWarnings("unused")
    void bind(@NonNull INonNullReadProperty<T> property);

    void unBind();

}
