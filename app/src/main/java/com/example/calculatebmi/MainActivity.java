package com.example.calculatebmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnCalculate;
    private EditText etHeight,etWeight;
    private TextView tvOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculate=findViewById(R.id.btnCompute);
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);
        tvOut=findViewById(R.id.tvOut);

        btnCalculate.setOnClickListener(this);
        etWeight.setOnClickListener(this);
        etHeight.setOnClickListener(this);
        tvOut.setOnClickListener(this);

    }
    public void onClick(View v){

        if(!validate()){
            return;
        }

        float height=Float.parseFloat(etHeight.getText().toString());
        float weight=Float.parseFloat(etWeight.getText().toString());

        Arthemetic ar=new Arthemetic(height,weight);
        float bim=ar.getBIM();
        tvOut.setText(Float.toString(bim));

        if(bim<18.5){
            Toast toastUnderWeight=Toast.makeText(this,"Underweight",Toast.LENGTH_LONG);
            toastUnderWeight.show();
        }
        else if(bim>=18.5 && bim<24.9){
            Toast toastNormalWeight=Toast.makeText(this,"Normal Weight",Toast.LENGTH_LONG);
            toastNormalWeight.show();
        }
        else if(bim>=25 && bim<29.9){
            Toast toastOverWeight=Toast.makeText(this,"Over Weight",Toast.LENGTH_LONG);
            toastOverWeight.show();
        }
        else if(bim>30){
            Toast toastObesity=Toast.makeText(this,"Obesity",Toast.LENGTH_LONG);
            toastObesity.show();
        }

    }
    public boolean validate(){
        boolean isValid=true;
        if(TextUtils.isEmpty(etHeight.getText().toString())){
            etHeight.setError("Please Enter Height");
            etHeight.requestFocus();
            isValid=false;
        }else if(TextUtils.isEmpty(etWeight.getText().toString())){
            etWeight.setError("Please Enter Weight");
            etWeight.requestFocus();
            isValid=false;
        }
        return isValid;
    }


}
