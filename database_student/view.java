package com.example.dbconnection_concise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;



        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;

public class view extends AppCompatActivity {

    ListView listViewData;

    SQLiteDatabase database;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listViewData = findViewById(R.id.listViewData);

        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        ArrayList<String> dataArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COLUMN_WEIGHT + ">70", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
                @SuppressLint("Range") double weight = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COLUMN_WEIGHT));
                String data = name + " - " + weight;
                dataArrayList.add(data);
            } while (cursor.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataArrayList);
        listViewData.setAdapter(adapter);

        cursor.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseHelper.close();
    }
}
