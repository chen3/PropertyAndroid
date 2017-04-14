package cn.qiditu.property;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

import cn.qiditu.signalslot.slots.Slot1;

@SuppressWarnings("WeakerAccess")
public class WriteProperty<T> {

    Property<T> read;

    public WriteProperty() {
    }

    @SuppressWarnings("unused")
    public void write(@Nullable T value) {
        set(value);
    }
    private Slot1<T> slotSet = new Slot1<T>() {
        @Override
        public void accept(T t) {
            WriteProperty.this.set(t);
        }
    };
    @SuppressWarnings({"WeakerAccess", "null"})
    public void set(@Nullable T value) {
        if(read == null) {
            throw new NullPointerException("not bind a property");
        }
        if((read.value == null && value != null)
                || (read.value != null && !read.value.equals(value))) {
            read.value = value;
            read.changed.emit(value);
        }
    }

    private WeakReference<Property<T>> bindTarget = new WeakReference<>(null);
    @SuppressWarnings("unused")
    public void bind(@Nullable Property<T> property) {
        if(read == null) {
            throw new NullPointerException("not bind a property");
        }
        if(bindTarget.get() != null) {
            unBind(bindTarget.get());
        }
        bindTarget = new WeakReference<>(property);
        if(property != null) {
            set(property.get());
            property.changed.connect(slotSet);
        }
    }
    @SuppressWarnings("WeakerAccess")
    public void unBind(@NonNull Property<T> property) {
        if(read == null) {
            throw new NullPointerException("not bind a property");
        }
        property.changed.disconnect(slotSet);
        bindTarget = new WeakReference<>(null);
    }

}
