package cn.qiditu.property;

import android.support.annotation.NonNull;

@SuppressWarnings("WeakerAccess")
public interface IBind<T> {

    @SuppressWarnings("unused")
    @NonNull
    IReadProperty<Boolean> isBind();

    @SuppressWarnings("unused")
    void bind(@NonNull IReadProperty<T> property);

    void unBind();

}
