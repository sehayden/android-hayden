package com.example.layoutdemo;

import android.app.Activity;
import android.os.Bundle;

public class DemoApplication extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_application);
    }
}
