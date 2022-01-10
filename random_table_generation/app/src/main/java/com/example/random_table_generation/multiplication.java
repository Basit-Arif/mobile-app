package com.example.random_table_generation;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class multiplication extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        ArrayList data= new ArrayList();
        String receivenumber = getIntent().getStringExtra("data");
        int number =Integer.parseInt(receivenumber);
        for(int i=1;i<=10;i++){
            data.add( i*number );
        }
        ListView listview = (ListView) findViewById(R.id.mylistview);
        ArrayAdapter list = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
        listview.setAdapter(list);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sting = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(), sting, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
