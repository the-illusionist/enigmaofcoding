package com.abhi.uncaughtexceptionhandler;

import android.content.Intent;
import android.os.Build;
import android.app.Activity;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.*;

public class ExceptionHandler implements
        java.lang.Thread.UncaughtExceptionHandler {
    Activity myContext;
    String LINE_SEPARATOR = "\n";

    public ExceptionHandler(Activity context) {
        myContext = context;
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        StringWriter stackTrace = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTrace));
        StringBuilder errorReport = new StringBuilder();

        errorReport.append("************ LOCATION OF ERROR ************\n\n");
        errorReport.append(myContext.getClass().getSimpleName());
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("\n************ CAUSE OF ERROR ************\n\n");
        errorReport.append(stackTrace.toString());
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("\n************ DEVICE INFORMATION ***********\n");
        errorReport.append("Brand: ");
        errorReport.append(Build.BRAND);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Device: ");
        errorReport.append(Build.DEVICE);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Model: ");
        errorReport.append(Build.MODEL);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Id: ");
        errorReport.append(Build.ID);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Product: ");
        errorReport.append(Build.PRODUCT);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("\n************ FIRMWARE ************\n");
        errorReport.append("SDK: ");
        errorReport.append(Build.VERSION.SDK);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Release: ");
        errorReport.append(Build.VERSION.RELEASE);
        errorReport.append(LINE_SEPARATOR);
        errorReport.append("Incremental: ");
        errorReport.append(Build.VERSION.INCREMENTAL);
        errorReport.append(LINE_SEPARATOR);

        Log.d("Exception Captured", errorReport.toString());

//      ******************* To display the exception cause & data *******************
        Intent intent = new Intent(myContext, DisplayExceptionDataActivity.class);
        intent.putExtra("error", errorReport.toString());

//      *********************** To restart the same activity ************************
//          Intent intent = new Intent(myContext, myContext.getClass());

//      *************** To display a custom predefined screen to the user ***********
//          Intent intent = new Intent(myContext, GracefulDegradationActivity.class);

        myContext.startActivity(intent);

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

}