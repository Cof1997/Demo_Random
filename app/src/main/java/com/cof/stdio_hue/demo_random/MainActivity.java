package com.cof.stdio_hue.demo_random;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    EditText edtMAX, edtMIN;
    TextView txtRANDOM;
    Button btnRANDOM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvent();
    }


    private void initControls() {
        edtMIN = (EditText) findViewById(R.id.editTextMin);
        edtMAX = (EditText) findViewById(R.id.editTextMax);
        txtRANDOM = (TextView) findViewById(R.id.textViewRANDOM);
        btnRANDOM = (Button) findViewById(R.id.buttonRANDOM);
    }

    private void initEvent(){
        btnRANDOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sMIN = edtMIN.getText().toString();
                String sMAX = edtMAX.getText().toString();

                if(sMAX.isEmpty()|| sMIN.isEmpty()){    // isEmpty: Kiem Tra Rong.
                    Toast.makeText(MainActivity.this, "Nhập Chưa Đủ Thông Tin.", Toast.LENGTH_SHORT).show();
                }else{
                    int MIN = Integer.parseInt(sMIN);
                    int MAX = Integer.parseInt(sMAX);

                    if(MAX < MIN){
                        Toast.makeText(MainActivity.this, "Nhập Sai Thông Tin (MAX > MIN).", Toast.LENGTH_SHORT).show();
                    }else{
                        Random rd = new Random();
                        int RANDOM = rd.nextInt(MAX - MIN + 1) + MIN;
                        txtRANDOM.setText(RANDOM + "");
                    }
                }
            }
        });
    }

}