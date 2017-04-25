package cn.qiditu.property;

@SuppressWarnings("WeakerAccess")
public interface INonNullReadWriteProperty<T> extends INonNullReadProperty<T>,
                                                INonNullWriteProperty<T>, INonNullBind<T> {
}
