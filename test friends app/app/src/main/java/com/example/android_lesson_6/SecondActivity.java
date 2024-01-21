package com.example.android_lesson_6;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayList<Object> items = new ArrayList<>();
        items.addAll(Arrays.asList("Pesho", "Goshko", "Ivancho"));
        ArrayAdapter<Object> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Button addButton = findViewById(R.id.button1);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add("TestPleb");
                adapter.notifyDataSetChanged();
            }
        });
        Button removeButton = findViewById(R.id.button2);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!items.isEmpty()) {
                    items.remove(0);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(SecondActivity.this, "List is already empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button logoutButton = findViewById(R.id.button4);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
