package com.example.a1027.hyunwoolee.mamber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1027.hyunwoolee.MainActivity;
import com.example.a1027.hyunwoolee.R;
import com.example.a1027.hyunwoolee.util.Retval;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_id,et_pw,et_name,et_email,et_addr,et_phone;
    Button bt_submit,bt_cancel;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id = et_id.getText().toString();
        String pw = et_pw.getText().toString();
        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String addr = et_addr.getText().toString();
        String phone = et_phone.getText().toString();
        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);
        member.setAddr(addr);
        member.setPhone(phone);
        switch (v.getId()){
            case R.id.bt_submit:
                service.regist(member);
                startActivity(new Intent(JoinActivity.this,LoginActivity.class));
                break;
            case R.id.bt_cancel:
                startActivity(new Intent(JoinActivity.this,MainActivity.class));
                break;
        }
    }
}
