package com.unn.booksrel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBtn = findViewById(R.id.start_btn);

        checkBtn.setOnClickListener((view) ->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        });

    }
}