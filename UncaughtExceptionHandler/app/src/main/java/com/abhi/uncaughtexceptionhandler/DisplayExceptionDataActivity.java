package com.abhi.uncaughtexceptionhandler;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class DisplayExceptionDataActivity extends Activity{

    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_show_error);

        error = (TextView) findViewById(R.id.error);
        error.setText(getIntent().getStringExtra("error"));
    }
}
