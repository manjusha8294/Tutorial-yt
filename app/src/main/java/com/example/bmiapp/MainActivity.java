package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight , hight_feet, height_Inch;
        Button Calculater;
        TextView Result;
        LinearLayout lnMain;

        weight = findViewById(R.id.editWeight);
        hight_feet = findViewById(R.id.editHeightFeet);
        height_Inch = findViewById(R.id.edit_HeightInch);
        Calculater = findViewById(R.id.Btn);
        Result = findViewById(R.id.Result);
        lnMain = findViewById(R.id.lMain);

        Calculater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int W  = Integer.parseInt(weight.getText().toString());
                int hightFeet = Integer.parseInt(hight_feet.getText().toString());
                int hightInch = Integer.parseInt(height_Inch.getText().toString());

                int totalIn = hightFeet*12 + hightInch;

                double totleCm = totalIn*2.53;

                double totalM = totleCm/100;
                double bmi = W/(totalM*totalM);

                if(bmi>25){
                    Result.setText("you are OverWeight....!");
                    lnMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                } else if (bmi<18) {
                    Result.setText("you are UnderWeight...!");
                    lnMain.setBackgroundColor(getResources().getColor(R.color.colorUn));

                }
                else {
                    Result.setText("You are Healthy...!");
                    lnMain.setBackgroundColor(getResources().getColor(R.color.ColorH));
                }


            }
        });

    }
}