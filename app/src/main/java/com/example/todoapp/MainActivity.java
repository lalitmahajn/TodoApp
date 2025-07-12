package com.example.todoapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText inputTask;
    Button addButton;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> tasks;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTask = findViewById(R.id.inputTask);
        addButton = findViewById(R.id.addButton);
        listView = findViewById(R.id.taskList);

        prefs = getSharedPreferences("TodoApp", MODE_PRIVATE);
        tasks = new ArrayList<>(prefs.getStringSet("tasks", new HashSet<>()));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            String task = inputTask.getText().toString().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                adapter.notifyDataSetChanged();
                inputTask.setText("");
                saveTasks();
            }
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            tasks.remove(position);
            adapter.notifyDataSetChanged();
            saveTasks();
            return true;
        });
    }

    void saveTasks() {
        Set<String> set = new HashSet<>(tasks);
        prefs.edit().putStringSet("tasks", set).apply();
    }
}
