package com.swan.my_app2;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.swan.my_app2.db.Task;
import  com.swan.my_app2.db.TaskHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TaskHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new TaskHelper(this);
        mTaskListView = (ListView)findViewById(R.id.list_todo);
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

FloatingActionButton fabButton = (FloatingActionButton)findViewById(R.id.add_task);
   public void onClik_add_taskB(View view)
   {

   }
/*FloatingActionButton fabButton = (FloatingActionButton)findViewById(R.id.add_task);
  fabButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Create a new intent to start an AddTaskActivity
            Intent addTaskIntent = new Intent(MainActivity.this, AddTaskActivity.class);
            startActivity(addTaskIntent);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.action_add_task:
            final EditText taskEditText = new EditText(this);
                AlertDialog dialog =new AlertDialog.Builder(this)
                        .setTitle("Задача")
                        .setMessage("Добавить новую задачу: ")
                        .setView(taskEditText)
                        .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                SQLiteDatabase db = mHelper.getWritableDatabase();
                                ContentValues values = new ContentValues();
                                values.put(Task.TaskEntry.COL_TASK_TITLE, task);
                                db.insertWithOnConflict(Task.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                                db.close();
                                updateUI();

                            }
                        })
                        .setNegativeButton("Отменить", null)
                        .create();
                dialog.show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }*/

    private void updateUI ()
    {
        ArrayList<String> tasklist = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(Task.TaskEntry.TABLE,
                        new String [] {Task.TaskEntry._ID , Task.TaskEntry.COL_TASK_TITLE}, null, null, null, null, null);

        while(cursor.moveToNext()){
             int index = cursor.getColumnIndex(Task.TaskEntry.COL_TASK_TITLE);
             tasklist.add(cursor.getString(index));
        }

        if(mAdapter == null){
            mAdapter = new ArrayAdapter<>(this, R.layout.item_todo, R.id.task_title, tasklist);
            mTaskListView.setAdapter(mAdapter);
        }
        else{
            mAdapter.clear();
            mAdapter.addAll(tasklist);
            mAdapter.notifyDataSetChanged();
        }
         cursor.close();
         db.close();

    }
    public void deleteTask (View view)
    {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.task_title);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(Task.TaskEntry.TABLE, Task.TaskEntry.COL_TASK_TITLE + " = ? ", new String[]{task});
        db.close();
        updateUI();
    }

}
