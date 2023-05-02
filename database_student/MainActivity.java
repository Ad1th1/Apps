

package com.example.dbconnection_concise;

        import android.content.ContentValues;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextWeight;
    Button buttonAdd, buttonView, buttonUpdate, buttonDelete;

    SQLiteDatabase database;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonView = findViewById(R.id.buttonView);

        buttonDelete = findViewById(R.id.buttonDel);
        buttonUpdate = findViewById(R.id.buttonUpd);

        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String weightString = editTextWeight.getText().toString().trim();

                if (name.isEmpty() || weightString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    double weight = Double.parseDouble(weightString);
                    ContentValues values = new ContentValues();
                    values.put(DatabaseHelper.COLUMN_NAME, name);
                    values.put(DatabaseHelper.COLUMN_WEIGHT, weight);
                    database.insert(DatabaseHelper.TABLE_NAME, null, values);

                    Toast.makeText(MainActivity.this, "Data added successfully", Toast.LENGTH_SHORT).show();

                    editTextName.setText("");
                    editTextWeight.setText("");
                }
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, view.class);
                startActivity(intent);
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainActivity.this, update.class);
                intent2.putExtra("name1",editTextName.getText().toString());
                intent2.putExtra("weight1",editTextWeight.getText().toString());
                startActivity(intent2);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, delete.class);
                startActivity(intent3);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseHelper.close();
    }
}
