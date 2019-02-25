package com.swan.my_app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.swan.my_app2.R;
import com.swan.my_app2.db.Task;
import com.swan.my_app2.db.TaskHelper;


public class AddTaskActivity extends AppCompatActivity {

    // Declare a member variable to keep track of a task's selected mPriority
    private int mPriority = 1;
    private Button button;
    private TaskHelper mHelper;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        button = findViewById(R.id.addButton);
        mHelper = new TaskHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAddTask(view);
            }
        });
        // Initialize to highest mPriority by default (mPriority = 1)
        ((RadioButton) findViewById(R.id.radButton1)).setChecked(true);
        mPriority = 1;
    }


    /**
     * onClickAddTask is called when the "ADD" button is clicked.
     * It retrieves user input and inserts that new task data into the underlying database.
     */
    public void onClickAddTask(View view) {
        // Not yet implemented
        // Check if EditText is empty, if not retrieve input and store it in a ContentValues object
        // If the EditText input is empty -> don't create an entry
        String inputName = ((EditText) findViewById(R.id.editTextName)).getText().toString();
        if (inputName.length() == 0) {
            Toast.makeText(getBaseContext(), "Имя задачи не может быть пустым", Toast.LENGTH_LONG).show();
            return;
        }

       /* String inputDescription = ((EditText) findViewById(R.id.editTextDescription)).getText().toString();
        if (inputDescription.length() == 0) {
            Toast.makeText(getBaseContext(), "Описание задачи не может быть пустым", Toast.LENGTH_LONG).show();
            return;
        }*/

        SQLiteDatabase db = mHelper.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Task.TaskEntry.COLUMN_NAME, inputName);
       // contentValues.put(Task.TaskEntry.COLUMN_DESCRIPTION, inputDescription);
        contentValues.put(Task.TaskEntry.COLUMN_PRIORITY, mPriority);
        long id =  db.insert(Task.TaskEntry.TABLE,null, contentValues);
        db.close();

        // Insert new task data via a ContentResolver
        // Create new empty ContentValues object
//        ContentValues contentValues = new ContentValues();
//        // Put the task description and selected mPriority into the ContentValues
//        // contentValues.put(Task.TaskEntry.COLUMN_DESCRIPTION, input);
//        //contentValues.put(Task.TaskEntry.COLUMN_PRIORITY, mPriority);
//        // Insert the content values via a ContentResolver
//        Uri uri = getContentResolver().insert(Task.TaskEntry.CONTENT_URI, contentValues);
//
//        // Display the URI that's returned with a Toast
//        // [Hint] Don't forget to call finish() to return to MainActivity after this insert is complete
//        if (uri != null) {
//            Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
//        }

        // Finish activity (this returns back to MainActivity)
        finish();

    }


    /**
     * onPrioritySelected is called whenever a priority button is clicked.
     * It changes the value of mPriority based on the selected button.
     */
    public void onPrioritySelected(View view) {
        if (((RadioButton) findViewById(R.id.radButton1)).isChecked()) {
            mPriority = 1;
        } else if (((RadioButton) findViewById(R.id.radButton2)).isChecked()) {
            mPriority = 2;
        } else if (((RadioButton) findViewById(R.id.radButton3)).isChecked()) {
            mPriority = 3;
        }
    }
}