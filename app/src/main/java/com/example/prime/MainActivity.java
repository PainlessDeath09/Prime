package com.example.prime;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.util.*;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button c = findViewById(R.id.check);
        c.setOnClickListener(this);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));
    }

    @Override
    public void onClick(View v)
    {
        EditText in = findViewById(R.id.input);
        final TextView o = findViewById(R.id.textView);
        if (in.getText().toString().trim().length() == 0)
        {
            Toast.makeText(this, "Please input a value and try again", Toast.LENGTH_SHORT).show();
            return;
        } else
        {
            double d = Double.parseDouble(in.getText().toString());
            switch(PrimeTest(d))
            {
                case 1:
                {
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#1ed760"));
                    final String s = "Number is Prime!";
                    final String t = "Prime Number Test";
                    o.setText(s);
                    new CountDownTimer(1000, 1000)
                    {
                        @Override
                        public void onTick(long l)
                        {

                        }

                        @Override
                        public void onFinish()
                        {
                            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));
                            o.setText(t);
                        }
                    }.start();
                    break;
                }
                case -1:
                {
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#d91921"));
                    final String s = "Number is NOT Prime!";
                    final String t = "Prime Number Test";
                    o.setText(s);
                    new CountDownTimer(1000, 1000)
                    {
                        public void onTick(long l){}
                        @Override
                        public void onFinish()
                        {
                            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));
                            o.setText(t);
                        }
                    }.start();
                    break;
                }
                case 0:
                {
                    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#4285f4"));
                    final String s = "1 is neither prime nor composite";
                    final String t = "Prime Number Test";
                    o.setText(s);
                    new CountDownTimer(1000, 1000)
                    {
                        public void onTick(long l){}
                        @Override
                        public void onFinish()
                        {
                            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#bebebe"));
                            o.setText(t);
                        }
                    }.start();

                }

            }

        }
    }
    public int PrimeTest(double n)
    {
        int i, flag = 0;
        for (i = 2; i <= n / 2; ++i)
        {
            // condition for nonprime number
            if (n % i == 0)
            {
                flag = 1;
                break;
            }
        }
        if (n == 1)
            return 0;  //composite
        else
            {
            if (flag == 0) //prime
                return 1;
            else           //not prime
                return -1;
            }
    }
}

