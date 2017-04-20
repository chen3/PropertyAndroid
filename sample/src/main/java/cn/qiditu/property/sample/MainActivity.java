package cn.qiditu.property.sample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.qiditu.property.sample1.User;
import cn.qiditu.signalslot.slots.Slot1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MainActivity() {
        user.age().changed().connect(new Slot1<Integer>() {
            @Override
            public void accept(@Nullable Integer integer) {
                MainActivity.this.tvAge.setText(integer == null ? "0" : integer.toString());
            }
        });
    }

    private User user = new User();

    private TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAge = (TextView)this.findViewById(R.id.tvAge);
        Integer integer = user.age().get();
        MainActivity.this.tvAge.setText(integer == null ? "0" : integer.toString());
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
    }
}
