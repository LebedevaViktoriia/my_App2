package com.swan.my_app2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TaskHelper extends SQLiteOpenHelper{

    public TaskHelper(Context context)
    {
        super(context, Task.DB_NAME, null, Task.DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTable = "CREATE TABLE " + Task.TaskEntry.TABLE + " ( " +
                                            Task.TaskEntry._ID + " INTEGER PRIMARY KEY, " +
                                            Task.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);" +
                                            Task.TaskEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                                            Task.TaskEntry.COLUMN_PRIORITY    + " INTEGER NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
          db.execSQL("DROP TABLE IF EXIST" + Task.TaskEntry.TABLE);
          onCreate(db);
    }
}
