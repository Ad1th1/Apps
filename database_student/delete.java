package com.example.dbconnection_concise;



        import androidx.appcompat.app.AppCompatActivity;

        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ListView;
        import androidx.appcompat.app.AppCompatActivity;

public class delete extends AppCompatActivity {
    ListView listViewData;

    SQLiteDatabase database;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        listViewData = findViewById(R.id.listViewData);
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        String tableName = DatabaseHelper.TABLE_NAME;
        String columnName = DatabaseHelper.COLUMN_NAME; //assuming the name column contains the name "aabbcc"

        String whereClause = columnName + "= ?";
        String[] whereArgs = new String[] {"aaabcc"};

        int deletedRows = database.delete(tableName,columnName+" = ?", whereArgs);

        if (deletedRows > 0) {
            Log.d("DELETE", "Row with name aabbcc deleted successfully");
        } else {
            Log.d("DELETE", "No row with name aabbcc found");
        }

    }
}
