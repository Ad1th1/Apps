package com.example.a;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView groceryListView;
    private String[] groceryItems = {"Milk", "Eggs", "Bread", "Cheese", "Fruits", "Vegetables"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groceryListView = findViewById(R.id.groceryListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, groceryItems);

        groceryListView.setAdapter(adapter);

        groceryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = groceryItems[position];
                Toast.makeText(MainActivity.this, "You selected " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
