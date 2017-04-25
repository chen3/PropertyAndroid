package cn.qiditu.property;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import cn.qiditu.signalslot.slots.Slot1;

public class NonNullReadWriteProperty<T> extends NonNullReadProperty<T>
            implements INonNullReadWriteProperty<T> {

    public NonNullReadWriteProperty(@NonNull T value) {
        super(value);
    }

    @Override
    public void set(@NonNull T value) {
        if(!this.value.equals(value)) {
            this.value = value;
            this.changed.emit(value);
        }
    }

    private final Lazy<INonNullReadWriteProperty<Boolean>> isBind =
            new Lazy<>(new Lazy.LazyFunc<INonNullReadWriteProperty<Boolean>>() {
                @NonNull
                @Override
                public INonNullReadWriteProperty<Boolean> init() {
                    return new NonNullReadWriteProperty<>(false);
                }
            });

    @NonNull
    @Override
    public INonNullReadProperty<Boolean> isBind() {
        return isBind.get();
    }

    private WeakReference<INonNullReadProperty<T>> bindTarget = new WeakReference<>(null);

    private Slot1<T> slotSet = new Slot1<T>() {
        @Override
        public void accept(T t) {
            NonNullReadWriteProperty.this.set(t);
        }
    };

    @Override
    public void bind(@NonNull INonNullReadProperty<T> property) {
        unBind();
        bindTarget = new WeakReference<>(property);
        this.set(property.get());
        property.changed().connect(slotSet);
        isBind.get().set(true);
    }

    @Override
    public void unBind() {
        INonNullReadProperty<T> property = bindTarget.get();
        if(property == null) {
            return;
        }
        property.changed().disconnect(slotSet);
        bindTarget = new WeakReference<>(null);
        isBind.get().set(false);
    }
}
