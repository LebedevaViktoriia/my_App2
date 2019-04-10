package com.swan.my_app2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class CalendarViewActivity extends AppCompatActivity {
    MaterialCalendarView materialCalendarView;
    List<CalendarDay> events = new ArrayList<CalendarDay>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_calendar_view);


        materialCalendarView = findViewById(R.id.myCalendarView);
        CalendarDay eventDay = CalendarDay.from(2019, 04, 10);
        events.add(eventDay);
        materialCalendarView.addDecorators(new EventDecorator(Color.rgb(66, 92, 244), events));
        // widget.addDecorator(new EventDecorator(Color.RED, events));
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
//                mDate = date;
            }
        });
    }
}
