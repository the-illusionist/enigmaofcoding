package com.abhi.uncaughtexceptionhandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.EmptyStackException;

public class MainActivity extends Activity {

    Button btn, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      Remember to add this listener/catcher in each of your activity where you want to catch the exception
//      Add it just after the call of super method in your overriden onCreate method.
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                throwParseIntException();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                arrayIndexOutofBoundsException();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                throwEmptyStackException();
            }
        });

    }

    public void throwParseIntException() {
        Integer.parseInt("abhi");
    }

    public void arrayIndexOutofBoundsException(){
        String[] new_array = { "x", "y", "z" };
        String value = new_array[5];
    }

    public void throwEmptyStackException() {
        throw new EmptyStackException();
    }
}
