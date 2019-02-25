package com.swan.my_app2;

import android.os.Bundle;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

public class Reminder extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remainder);
        Button button = (Button) findViewById(R.id.add_remainder);
    }
}
