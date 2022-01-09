package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
public class adapter extends ArrayAdapter<String> {
    Context context;
    String[] sMaintitle;
    String[] rDesc;
    int[] rimage;
    adapter(Context c,int[] img,String[] Maintitle,String[] Desc){
        super(c, R.layout.row,R.id.text,Desc);
        context=c;
        this.rimage=img;
        this.sMaintitle=Maintitle;
        this.rDesc=Desc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.row,parent,false);

        ImageView img=row.findViewById(R.id.image);
        TextView ttx=row.findViewById(R.id.text1);
        TextView ttx2=row.findViewById(R.id.text);
        img.setImageResource(rimage[position]);
        ttx.setText(sMaintitle[position]);
        ttx2.setText(rDesc[position]);
        return row;
    }
}