package com.fju.guess;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int min = 0;
    int max = 100;
    Random random = new Random();
    int secret = random.nextInt((100)+1);
    private EditText ednum;
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ser = findViewById(R.id.secret);
        ser.setText(secret+"");
    }

    public void send(View view){
        findView();
        int num = Integer.parseInt(ednum.getText().toString());
        if(num == secret){
            if(correct<4){
                Intent intent = new Intent(this,Excellent.class);
                startActivity(intent);
            }else{
                new AlertDialog.Builder(this).setMessage("Yes, the number is "+secret)
                        .setTitle("答對囉")
                        .setPositiveButton("OK",null)
                        .show();
            }

        }

        if(num > secret){
            max = num;
            correct = correct+1;
            new AlertDialog.Builder(this).setMessage(min+" to "+max)
                    .setTitle("猜錯囉")
                    .setPositiveButton("OK",null)
                    .show();

        }if(num < secret) {
            min = num;
            correct = correct+1;
            new AlertDialog.Builder(this).setMessage(min+" to "+max)
                    .setTitle("猜錯囉")
                    .setPositiveButton("OK",null)
                    .show();

        }



    }

    private void findView() {
        ednum = findViewById(R.id.number);
    }
}
