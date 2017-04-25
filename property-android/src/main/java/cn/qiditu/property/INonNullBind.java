package cn.qiditu.property;

import android.support.annotation.NonNull;

public interface INonNullBind<T> {

    @SuppressWarnings("unused")
    @NonNull
    INonNullReadProperty<Boolean> isBind();

    @SuppressWarnings("unused")
    void bind(@NonNull INonNullReadProperty<T> property);

    void unBind();

}
