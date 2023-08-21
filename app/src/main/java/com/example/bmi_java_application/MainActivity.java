package com.example.bmi_java_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, editHeightFt, editHeightInch;
        Button btnCalculate;
        TextView textResult;
        edtWeight = findViewById(R.id.edtWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightInch = findViewById(R.id.editHeightInch);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
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
                } else if (bmi<18) {
                    textResult.setText("You're UnderWeight.");
                } else {
                    textResult.setText("You're Healthy.");
                }
            }
        });
    }
}