package com.example.a1027.hyunwoolee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_num_1,et_num_2;
    Button b_plus,b_minus,b_multy,b_divide,b_equal;
    TextView tv_result;
    int result;
    CalcDTO cal = new CalcDTO();
    CalcService service = new CalcServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        et_num_1 = (EditText) findViewById(R.id.et_num_1);
        et_num_2 = (EditText) findViewById(R.id.et_num_2);
        b_plus = (Button) findViewById(R.id.b_plus);
        b_minus = (Button) findViewById(R.id.b_minus);
        b_multy = (Button) findViewById(R.id.b_multy);
        b_divide = (Button) findViewById(R.id.b_divide);
        b_equal = (Button) findViewById(R.id.b_equal);
        tv_result = (TextView) findViewById(R.id.tv_result);
        b_divide.setOnClickListener(this);
        b_equal.setOnClickListener(this);
        b_minus.setOnClickListener(this);
        b_multy.setOnClickListener(this);
        b_plus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(et_num_1.getText().toString());
        int num2 = Integer.parseInt(et_num_2.getText().toString());

        cal.setNum1(num1);
        cal.setNum2(num2);
        switch (v.getId()){
            case R.id.b_divide :

                result = num1/num2;
                break;
            case R.id.b_minus :
                cal = service.minus(cal);
                result = cal.getResult();
                break;
            case R.id.b_multy :
                result = num1*num2;
                break;
            case R.id.b_plus :
                result = num1+num2;
                break;
            case R.id.b_equal :
                tv_result.setText("계산결과 : "+result);
                break;
        }
    }
}
