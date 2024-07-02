package com.example.myremembrall;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setDate();
        createButtons();
        setRecyclerview(getData());

    }

    private ArrayList<String> getData() {
        //ToDo change to database, just for testing right now
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("Test");
        tasks.add("Test2");

        return tasks;
    }

    private void setRecyclerview(ArrayList<String> tasks) {
        TaskRecyclerViewAdapter adapter = new TaskRecyclerViewAdapter(this, tasks);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTask);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void createButtons() {
        Button settings = findViewById(R.id.buttonSettings);
        Button refresh = findViewById(R.id.buttonRefresh);
        Button add = findViewById(R.id.buttonAdd);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setDate() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd-MM-yyyy");
        date = findViewById(R.id.textViewDayDate);
        date.setText(sdf.format(new Date()));
    }
}