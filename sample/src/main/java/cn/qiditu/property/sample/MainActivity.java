package cn.qiditu.property.sample;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.qiditu.property.sample1.NonNullUser;
import cn.qiditu.property.sample1.User;
import cn.qiditu.signalslot.slots.Slot0;
import cn.qiditu.signalslot.slots.Slot1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MainActivity() {
        user.age().changed().connect(new Slot1<Integer>() {
            @Override
            public void accept(@Nullable Integer integer) {
                MainActivity.this.tvAge.setText(integer == null ? "0" : integer.toString());
            }
        });
        user1.age().changed().connect(new Slot0() {
            @SuppressLint("SetTextI18n")
            @Override
            public void accept() {
                MainActivity.this.tvAge1.setText(MainActivity.this.user1.age().get().toString());
            }
        });
    }

    private User user = new User();
    private NonNullUser user1 = new NonNullUser();

    private TextView tvAge;
    private TextView tvAge1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAge = (TextView)this.findViewById(R.id.tvAge);
        tvAge1 = (TextView)this.findViewById(R.id.tvAge1);
        Integer integer = user.age().get();
        tvAge.setText(integer == null ? "0" : integer.toString());
        tvAge1.setText(user1.age().get().toString());
        this.findViewById(R.id.btnRandomChangeAge).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        user.randomChangeAge();
        user1.randomChangeAge();
    }
}
