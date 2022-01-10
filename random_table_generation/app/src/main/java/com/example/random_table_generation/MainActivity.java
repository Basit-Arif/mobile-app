package com.example.random_table_generation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button StartmainActivity = (Button) findViewById(R.id.navigate_btn);

        StartmainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),multiplication.class);

                String number = ((EditText) findViewById(R.id.number)).getText().toString();
                i.putExtra("data",number);startActivity(i);
            }
        });

    }
}