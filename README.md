# PropertyAndroid
Porting [Property](https://github.com/chen3/Property) to Android

# Usage
On moudle build.gradle, add depend
```
compile 'cn.qiditu:property-android:2.2.1'
```

```
public class User {
    private final ReadWriteProperty<Integer> age = new ReadWriteProperty<>(20);
    @NonNull
    public ReadProperty<Integer> age() {
        return age;
    }
}
```
