package com.abhi.uncaughtexceptionhandler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GracefulDegradationActivity extends Activity {

    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_graceful_degradation);

        msg = (TextView) findViewById(R.id.msg);
        msg.setText("Uh Oh your app caught a little cold. \n Restart to keep it going");
    }
}
