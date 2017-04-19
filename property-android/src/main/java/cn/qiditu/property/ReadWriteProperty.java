package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import cn.qiditu.signalslot.slots.Slot1;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ReadWriteProperty<T> extends ReadProperty<T> implements IReadWriteProperty<T> {

    @SuppressWarnings("WeakerAccess")
    public ReadWriteProperty() {
        super(null);
    }

    @SuppressWarnings("unused")
    public ReadWriteProperty(@Nullable T value) {
        super(value);
    }

    @Override
    public void set(@Nullable T value) {
        if((this.value == null && value != null)
            || (this.value != null && !this.value.equals(value))) {
            this.value = value;
            this.changed.emit(value);
        }
    }

    private final IReadWriteProperty<Boolean> isBind = new ReadWriteProperty<>();

    @NonNull
    @Override
    public IReadProperty<Boolean> isBind() {
        return isBind;
    }

    private WeakReference<IReadProperty<T>> bindTarget = new WeakReference<>(null);

    private Slot1<T> slotSet = new Slot1<T>() {
        @Override
        public void accept(T t) {
            ReadWriteProperty.this.set(t);
        }
    };

    @Override
    public void bind(@NonNull IReadProperty<T> property) {
        unBind();
        bindTarget = new WeakReference<>(property);
        this.set(property.get());
        property.changed().connect(slotSet);
        isBind.set(true);
    }

    @Override
    public void unBind() {
        IReadProperty<T> property = bindTarget.get();
        if(property == null) {
            return;
        }
        property.changed().disconnect(slotSet);
        bindTarget = new WeakReference<>(null);
        isBind.set(false);
    }

    @Override
    public final boolean isWritable() {
        return true;
    }

}
