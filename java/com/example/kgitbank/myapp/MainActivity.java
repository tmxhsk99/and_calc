package com.example.kgitbank.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx =MainActivity.this;
        final EditText num = findViewById(R.id.num);/*num1과 num2는 유지해야함*/
        final TextView result = findViewById(R.id.result);
        final TextView preview = findViewById(R.id.preview);
        // inner class
        class Calc{
            private double num,res;//인스턴스(의) 변수
            String op;
            public void exe(){
                switch (op){
                    case "+": res += num; break;
                    case "-": res -= num; break;
                    case "*": res *= num ;break;
                    case "/": res /= num; break;
                }
            }
            public void setNum (double num){this.num=num;}
            public  double getNum(){return this.num;}
           /* public void setNum2 (int num2){this.num2=num2;}
            public int getNum2(){return this.num2;}*/
            public void setRes (double res){this.res=res;}
            public double getRes(){return this.res;}
            public void setOp(String op){this.op = op;}
            public String getOp(){return this.op;}
        }
        final Calc calc = new Calc();

        /*이벤트처리를->기능이라고함*/
        findViewById(R.id.plusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 calc.setNum(Double.parseDouble(num.getText().toString()));
                Log.d("입력값1",num.getText().toString());
                calc.setOp("+");
                calc.exe();


            }
        });
        findViewById(R.id.minusBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setNum(Double.parseDouble(num.getText().toString()));
                Log.d("입력값1",num.getText().toString());
                calc.setOp("-");
                calc.exe();
            }
        });
        findViewById(R.id.multiBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                Log.d("입력값1",num.getText().toString());
                calc.setOp("*");
                calc.exe();
            }
        });
        findViewById(R.id.divBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setNum(Double.parseDouble(num.getText().toString()));
                Log.d("입력값1",num.getText().toString());
                calc.setOp("/");
                calc.exe();
            }
        });
        findViewById( R.id.resetBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setRes(0);
                result.setText("결과"+calc.getRes());
                num.setText("");
            }
        });
        findViewById(R.id.equalBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"결과"+calc.getRes(),Toast.LENGTH_LONG).show();
                result.setText("결과"+calc.getRes());
            }
        });
        findViewById(R.id.preview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
