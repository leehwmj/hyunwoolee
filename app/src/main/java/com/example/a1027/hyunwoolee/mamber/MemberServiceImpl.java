package com.example.a1027.hyunwoolee.mamber;

import android.content.Context;
import android.util.Log;

import com.example.a1027.hyunwoolee.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService{
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public MemberDTO login(MemberDTO param) {
        Log.i("==== SERVICE에서 받은 ID값 :",param.getId());
        Log.i("==== SERVICE에서 받은 pw값 :",param.getPw());

        MemberDTO member = new MemberDTO();
        member = dao.select(param);
        if(member==null){
            member.setId("NONE");

            return member;
        }else if(member.getPw().equals(param.getPw())){
            member.setId("NO_MATCH");
            return member;
        }else{
            return member;
        }

    }

    @Override
    public Retval join(MemberDTO param) {
        Log.i(" SERVICE에서 받은 ID값 :",param.getId());
        Log.i(" SERVICE에서 받은 pw값 :",param.getPw());
        Log.i(" SERVICE에서 받은 name :",param.getName());
        Log.i(" SERVICE에서 받은 addr :",param.getAddr());
        Log.i(" SERVICE에서 받은 phone :",param.getPhone());
        Log.i(" SERVICE에서 받은 email :",param.getEmail());
        return dao.insert(param);
    }
}
