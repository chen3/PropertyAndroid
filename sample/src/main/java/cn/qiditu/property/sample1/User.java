package cn.qiditu.property.sample1;

import android.support.annotation.NonNull;

import java.util.Random;

import cn.qiditu.property.ReadProperty;
import cn.qiditu.property.ReadWriteProperty;

public class User {

    private final ReadWriteProperty<Integer> age = new ReadWriteProperty<>(20);
    @NonNull
    public ReadProperty<Integer> age() {
        return age;
    }

    private Random random = new Random();

    public void randomChangeAge() {
        age.set(random.nextInt(90));
    }

}
