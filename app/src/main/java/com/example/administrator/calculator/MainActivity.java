package com.example.administrator.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText et;
    private Button clear;
    private Button bt0;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;
    private Button bt12;
    private Button bt13;
    private Button bt14;
    private Button bt_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        clear.setOnClickListener(this);
        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);
        bt11.setOnClickListener(this);
        bt12.setOnClickListener(this);
        bt13.setOnClickListener(this);
        bt_equal.setOnClickListener(this);

    }

    private void findId() {
        et = (EditText) findViewById(R.id.et);
        clear = (Button) findViewById(R.id.clear);
        bt0 = (Button) findViewById(R.id.bt0);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        bt10 = (Button) findViewById(R.id.bt10);
        bt11 = (Button) findViewById(R.id.bt11);
        bt12 = (Button) findViewById(R.id.bt12);
        bt13 = (Button) findViewById(R.id.bt13);
        bt13 = (Button) findViewById(R.id.bt14);
        bt_equal = (Button) findViewById(R.id.bt_equal);
    }

    public void onClick(View v) {
        String str = et.getText().toString();
        int id = v.getId();
        switch (id) {
            case R.id.clear:                    //点击清除按钮
                if (!(str == "")) {
                    et.setText("");
                }
                break;
            case R.id.bt0:                      //数字按键及小数点
            case R.id.bt1:
            case R.id.bt2:
            case R.id.bt3:
            case R.id.bt4:
            case R.id.bt5:
            case R.id.bt6:
            case R.id.bt7:
            case R.id.bt8:
            case R.id.bt9:
            case R.id.bt14:
                et.setText(str + ((Button) v).getText());
                break;
            case R.id.bt10:                        //运算符
            case R.id.bt11:
            case R.id.bt12:
            case R.id.bt13:
                if (str.contains(" ")) {
                    String s = str.substring(0, str.indexOf(" "));
                    et.setText(s + " " + ((Button) v).getText() + " ");
                } else {
                    et.setText(str + " " + ((Button) v).getText() + " ");
                }
                break;
            case R.id.bt_equal:
                getResult();
                break;
        }
    }

    private void getResult() {                                     //简单的二元运算
        String text = et.getText().toString();
        if (!text.contains("(") && !text.contains(")")) {
            double result = 0;
            if (text.equals("")) {
                return;
            }
            String s1 = text.substring(0, text.indexOf(" "));
            String op = text.substring(text.indexOf(" ") + 1, text.indexOf(" ") + 2);
            String s2 = text.substring(text.indexOf(" ") + 3);
            if (!s1.equals("") && !s2.equals("")) {
                double d1 = Double.valueOf(s1);
                double d2 = Double.valueOf(s2);
                if (op.equals("+")) {
                    result = d1 + d2;
                }
                if (op.equals("-")) {
                    result = d1 - d2;
                }
                if (op.equals("*")) {
                    result = d1 * d2;
                }
                if (op.equals("/")) {
                    if (d2 == 0) {
                        et.setText("");
                        Toast.makeText(getApplicationContext(), "错误，分母为0", Toast.LENGTH_SHORT).show();
                    } else {
                        result = d1 / d2;
                    }
                }
            }
            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {
                int res = (int) result;
                et.setText(res + "");
            } else {
                et.setText(Double.toString(result));
            }
        }
    }
}
