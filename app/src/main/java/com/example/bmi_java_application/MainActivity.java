package com.example.bmi_java_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

        EditText edtWeight, editHeightFt, editHeightInch;
        Button btnCalculate;
        TextView textResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightInch = findViewById(R.id.editHeightInch);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft =  Integer.parseInt(editHeightFt.getText().toString());
                int inch = Integer.parseInt(editHeightInch.getText().toString());

                int totalInch = ft*12 + inch;
                double totalcm = totalInch*2.53;
                double totalM = totalcm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    textResult.setText("You're OverWeight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colOW));

                } else if (bmi<18) {
                    textResult.setText("You're UnderWeight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colUW));
                } else {
                    textResult.setText("You're Healthy.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colH));
                }
            }
        });
    }
}