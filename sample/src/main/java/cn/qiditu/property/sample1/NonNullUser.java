package cn.qiditu.property.sample1;

import android.support.annotation.NonNull;

import java.util.Random;

import cn.qiditu.property.NonNullReadWriteProperty;

public class NonNullUser {

    private final NonNullReadWriteProperty<Integer> age = new NonNullReadWriteProperty<>(20);

    @NonNull
    public NonNullReadWriteProperty<Integer> age() {
        return age;
    }

    private Random random = new Random();

    public void randomChangeAge() {
        age.set(random.nextInt(90));
    }

}
