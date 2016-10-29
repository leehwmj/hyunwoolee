package com.example.a1027.hyunwoolee.mamber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1027.hyunwoolee.R;
import com.example.a1027.hyunwoolee.homePage.HomePageActivity;
import com.example.a1027.hyunwoolee.message.MessageWriteActivity;
import com.example.a1027.hyunwoolee.util.Phone;

import java.lang.reflect.Member;

public class MemberDetailActivity extends AppCompatActivity implements View.OnClickListener{
    MemberService service;
    TextView tv_id, tv_pw,tv_name ,tv_email, tv_addr, tv_phone;
    Button bt_call,bt_map,bt_update,bt_list, bt_massage, bt_email;
    MemberDTO member;
    Phone phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        phone = new Phone(this,this);
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = new MemberDTO();
        member.setId(id);
        member=service.getOne(member);

        tv_id = (TextView)findViewById(R.id.tv_id);
        tv_pw = (TextView)findViewById(R.id.tv_pw);
        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_email = (TextView)findViewById(R.id.tv_email);
        tv_addr = (TextView)findViewById(R.id.tv_addr);
        tv_phone = (TextView)findViewById(R.id.tv_phone);
        bt_call = (Button)findViewById(R.id.bt_call);
        bt_map = (Button)findViewById(R.id.bt_map);
        bt_update = (Button)findViewById(R.id.bt_update);
        bt_list = (Button)findViewById(R.id.bt_list);
        bt_massage = (Button)findViewById(R.id.bt_message);
        bt_email = (Button)findViewById(R.id.bt_email);

        tv_id.setText(member.getId());
        tv_pw.setText(member.getPw());
        tv_name.setText(member.getName());
        tv_email.setText(member.getEmail());
        tv_addr.setText(member.getAddr());
        tv_phone.setText(member.getPhone());

        bt_call.setOnClickListener(this);
        bt_map.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);
        bt_massage.setOnClickListener(this);
        bt_email.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_call:
                phone.dial(member.getPhone());
                //phone.directCall(member.getPhone());
                break;
            case R.id.bt_map:
                break;
            case R.id.bt_update:
                Intent intent = new Intent(MemberDetailActivity.this,MemberUpdateActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
                break;
            case R.id.bt_list:
                startActivity(new Intent(this,ListActivity.class));
                break;
            case R.id.bt_message:
                Intent intent2 = new Intent(MemberDetailActivity.this,MessageWriteActivity.class);
                intent2.putExtra("id",member.getId());
                startActivity(intent2);
                break;
            case R.id.bt_email:
                startActivity(new Intent(this,HomePageActivity.class));
                break;
        }
    }
}
