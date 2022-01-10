package com.example.intend_version01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList data = new ArrayList();
        for(int i=0;i<10;i++){
            data.add("item "+ i);
        }
        ListView mylistview=(ListView) findViewById(R.id.mylistview);

        ArrayAdapter adapter=new ArrayAdapter(this , android.R.layout.simple_list_item_1,data);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String textonitem=((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(), textonitem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}