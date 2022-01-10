package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String[] Maintitle={"Facebook","Instagram","snapchat","Whatsapp"};
    String[] Desc={"For social media","For post","for picture","for messaging"};
    int img[]={R.drawable.facebook, R.drawable.instagram,R.drawable.snapchatpng,R.drawable.whatsapp};
    ListView mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist=findViewById(R.id.mylist);
        adapter mya= new adapter(this,img,Maintitle,Desc);
        mylist.setAdapter(mya);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ttd=((TextView)view.findViewById(R.id.text1)).getText().toString();
//                String s=mylist.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),ttd, Toast.LENGTH_SHORT).show();
            }
        });
    };
}
