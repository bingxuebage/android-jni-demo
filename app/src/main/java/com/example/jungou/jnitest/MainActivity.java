package com.example.jungou.jnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JniApi myAPI=  new JniApi();
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.tv_show)).setText(myAPI.getTitle());
    }
}
