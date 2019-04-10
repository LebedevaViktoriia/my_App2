package com.swan.my_app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ToDoSomethingActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_something);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button batton4 = (Button) findViewById(R.id.calendar);
    }


    public void onClick(View view){
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);

    }

    public void onClick1(View view)
    {
        Intent intent = new Intent(this, CalendarViewActivity.class);
        startActivity(intent);
    }

}
