package cn.qiditu.property;

import android.support.annotation.Nullable;

@SuppressWarnings("WeakerAccess")
public interface IWriteProperty<T> extends IProperty<T> {

    void set(@Nullable T value);

}
