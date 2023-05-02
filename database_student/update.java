package com.example.dbconnection_concise;


        import android.content.ContentValues;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;


        import androidx.appcompat.app.AppCompatActivity;

        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
public class update extends AppCompatActivity {
    ListView listViewData;

    SQLiteDatabase database;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        listViewData = findViewById(R.id.listViewData);

        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

// Update the weight of the record where name is "kushal"
        String name1=getIntent().getStringExtra("name1");
        String weight1=getIntent().getStringExtra("weight1");
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_WEIGHT, weight1);
        String selection = DatabaseHelper.COLUMN_NAME + " = ?";
        String[] selectionArgs = {name1};
        database.update(DatabaseHelper.TABLE_NAME, values, selection, selectionArgs);

// Read the data from the database and display it in the ListView
        ArrayList<String> dataArrayList = new ArrayList<>();
        String[] columns = {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_WEIGHT};
        String selection1 = null;
        String[] selectionArgs1 = null;
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, selection1, selectionArgs1, null, null, null);

        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
            int weightIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_WEIGHT);
            do {
                String name = cursor.getString(nameIndex);
                int weight = cursor.getInt(weightIndex);
                dataArrayList.add(name + ": " + weight);
            } while (cursor.moveToNext());
        }

        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataArrayList);
        listViewData.setAdapter(adapter);

    }
}
