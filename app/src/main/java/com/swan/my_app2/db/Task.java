package com.swan.my_app2.db;
import android.net.Uri;
import android.provider.BaseColumns;

public class Task {

    // The authority, which is how your code knows which Content accessProvider to
    public static final String AUTHORITY = "com.example.swan.my_app2";

    // The base content URI = "content://" + <authority>
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Define the possible paths for accessing data in this contract
    // This is the path for the "tasks" directory
    public static final String PATH_TASKS = "tasks";


    public static final String DB_NAME = "com.swan.my_app2.db";
    public static final int DB_VERSION = 1;

    public static class TaskEntry implements BaseColumns{

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASKS).build();
       // public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRIORITY = "priority";
        public static final String COLUMN_NAME = "name";
        public static final String TABLE = "tasks";
        //public static final String COL_TASK_TITLE = "title";
    }

}
