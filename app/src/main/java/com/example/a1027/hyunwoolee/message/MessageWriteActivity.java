package com.example.a1027.hyunwoolee.message;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a1027.hyunwoolee.R;
import com.example.a1027.hyunwoolee.mamber.MemberDTO;
import com.example.a1027.hyunwoolee.mamber.MemberService;
import com.example.a1027.hyunwoolee.mamber.MemberServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageWriteActivity extends AppCompatActivity implements View.OnClickListener {
    MessageService service;
    MemberDTO member;
    MemberService memberService;
    TextView tv_receiver, tv_id;
    EditText et_wirte;
    Button bt_send,bt_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_write);
        service = new MessageServiceImpl(this.getApplicationContext());
        memberService = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = new MemberDTO();
        member.setId(id);
        member=memberService.getOne(member);

        tv_receiver = (TextView) findViewById(R.id.tv_receiver);
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_receiver.setText(member.getName());
        tv_id.setText(member.getId());
        //tv_id.setVisibility(View.INVISIBLE);
        et_wirte = (EditText) findViewById(R.id.et_wirte);
        bt_send = (Button) findViewById(R.id.bt_send);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_send.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_send :
                String content = et_wirte.getText().toString();
                Log.d("메시지내용", content);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String sendDate = sdf.format(new Date());
                Log.d("보낸 날짜", sendDate);
                String receiver = tv_id.getText().toString();
                Log.d("받는사람", receiver);
                MessageDTO message = new MessageDTO();
                message.setContent(content);
                message.setReceiver(receiver);
                message.setSendDate(sendDate);
                service.write(message);
                break;
            case R.id.bt_cancel : break;
        }
    }
}
