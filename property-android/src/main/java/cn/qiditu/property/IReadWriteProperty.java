package cn.qiditu.property;

@SuppressWarnings("WeakerAccess")
public interface IReadWriteProperty<T> extends IReadProperty<T>, IWriteProperty<T>, IBind<T> {
}
