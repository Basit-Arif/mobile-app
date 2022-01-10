package com.example.tictactoe;

import static java.lang.Integer.getInteger;
import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    private Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String currentplayer="X";
//    TextView box = findViewById(R.id.current_value);
@SuppressLint("SetTextI18n")
public void DoTurn(View v){
//        TextView box = findViewById(R.id.current_value);
    Button currentbtn=(Button)v;
    log.i("activity_status","AD");
    if(currentbtn.getText().equals("")) {
        currentbtn.setText(currentplayer);
        String gameStatus=checkgamestatus();

        boolean gameended=false;
        String message="";
        if(gameStatus.equals("win")){
            gameended=true;
            if(currentplayer.equals("X")){
                message="player 1 won";

            }
            else{
                message="player 2 won";

            }
        }
        else if(gameStatus.equals("draw")){
            gameended=true;
            message="Game draw";
        }
        else {
            toggleplayyer();
        }

        if(gameended){
            TextView messagebox=findViewById(R.id.currentState);
            messagebox.setText(message);
            messagebox.setVisibility(View.VISIBLE);
            TextView currentplayerpointtextview;
            if(currentplayer.equals("X")){
                currentplayerpointtextview=findViewById(R.id.tvplayer);
            }
            else{
                currentplayerpointtextview=findViewById(R.id.tvplayer2);
            }
            int currentpoints = Integer.parseInt(currentplayerpointtextview.getText().toString());
            currentpoints++;
            currentplayerpointtextview.setText(Integer.toString(currentpoints));
            resetboard();
            currentplayer="X";
        }
    }
}


    private String checkgamestatus()  {
        //to do check if diagnol with same element win
        Button btn00=findViewById(R.id.btn00);
        Button btn11=findViewById(R.id.btn11);
        Button btn22=findViewById(R.id.btn22);
        Button btn01=findViewById(R.id.btn01);
        Button btn02=findViewById(R.id.btn02);
        Button btn10=findViewById(R.id.btn10);
        Button btn12=findViewById(R.id.btn12);
        Button btn20=findViewById(R.id.btn20);
        Button btn21=findViewById(R.id.btn21);
        if(btn00.getText().toString().equals(btn11.getText().toString()) && btn00.getText().toString().equals(btn22.getText().toString()) && btn11.getText().toString().equals(btn22.getText().toString())&& !btn00.getText().toString().equals("")){
            //diagonal(00-11-22)
            return "win";
            }
        else if(btn00.getText().toString().equals(btn01.getText().toString()) && btn00.getText().toString().equals(btn02.getText().toString()) && !btn00.getText().toString().equals("")){
            // row(00-01-02)
            return "win";
        }
        else if(btn00.getText().toString().equals(btn10.getText().toString()) && btn00.getText().toString().equals(btn20.getText().toString()) && btn10.getText().toString().equals(btn20.getText().toString())&& !btn00.getText().toString().equals("")){
            // columns(00-10-20)
            return "win";
        }
        else if(btn20.getText().toString().equals(btn21.getText().toString()) && btn20.getText().toString().equals(btn22.getText().toString()) && btn21.getText().toString().equals(btn22.getText().toString())&& !btn20.getText().toString().equals("")){
            // row(20-21-22)
            return "win";
        }
        else if(btn02.getText().toString().equals(btn12.getText().toString()) && btn02.getText().toString().equals(btn22.getText().toString()) && btn12.getText().toString().equals(btn22.getText().toString())&& !btn02.getText().toString().equals("")){
            // column(02-12-22)
            return "win";
        }
        else if(btn02.getText().toString().equals(btn11.getText().toString()) && btn02.getText().toString().equals(btn20.getText().toString()) && btn11.getText().toString().equals(btn20.getText().toString())&& !btn02.getText().toString().equals("")){
            //diagonal(02-11-20)
            return "win";
        }
        else if(btn01.getText().toString().equals(btn11.getText().toString()) && btn01.getText().toString().equals(btn21.getText().toString()) && btn11.getText().toString().equals(btn21.getText().toString())&& !btn01.getText().toString().equals("")){
            // column(02-12-22)
            return "win";
        }
        else if(btn10.getText().toString().equals(btn11.getText().toString()) && btn10.getText().toString().equals(btn12.getText().toString()) && btn11.getText().toString().equals(btn12.getText().toString())&& !btn10.getText().toString().equals("")){
            return "win";
        }
        else if(!btn00.getText().toString().equals("") && !btn01.getText().toString().equals("") && !btn02.getText().toString().equals("") && !btn10.getText().toString().equals("") &&!btn11.getText().toString().equals("") && !btn12.getText().toString().equals("") && !btn20.getText().toString().equals("") && !btn21.getText().toString().equals("") && !btn22.getText().toString().equals("")){
            resetboard();
            return "draw";
        }
        else {
            return "";
        }
    }
    private void toggleplayyer(){
       if(currentplayer.equals("X")){
           currentplayer = "O";
       }
       else if(currentplayer.equals("O")){
           currentplayer = "X";
       }
    }
    private void resetboard(){
        Button btn00=findViewById(R.id.btn00);
        Button btn11=findViewById(R.id.btn11);
        Button btn22=findViewById(R.id.btn22);
        Button btn01=findViewById(R.id.btn01);
        Button btn02=findViewById(R.id.btn02);
        Button btn10=findViewById(R.id.btn10);
        Button btn12=findViewById(R.id.btn12);
        Button btn20=findViewById(R.id.btn20);
        Button btn21=findViewById(R.id.btn21);
        btn00.setText("");
        btn11.setText("");
        btn22.setText("");
        btn01.setText("");
        btn02.setText("");
        btn10.setText("");
        btn12.setText("");
        btn20.setText("");
        btn21.setText("");
    }
}
