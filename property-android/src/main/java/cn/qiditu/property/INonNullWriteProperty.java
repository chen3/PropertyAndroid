package cn.qiditu.property;

import android.support.annotation.NonNull;

public interface INonNullWriteProperty<T> extends IProperty<T> {

    void set(@NonNull T value);

}
