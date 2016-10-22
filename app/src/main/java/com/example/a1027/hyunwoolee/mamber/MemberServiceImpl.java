package com.example.a1027.hyunwoolee.mamber;

import android.content.Context;
import android.util.Log;

import com.example.a1027.hyunwoolee.util.Retval;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService{
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public void regist(MemberDTO member) {
        dao.insert(member);
    }

    @Override
    public ArrayList<MemberDTO> getList() {
        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDTO> getListByName(MemberDTO member) {
        return null;
    }

    @Override
    public MemberDTO getOne(MemberDTO member) {
        return dao.selectOne(member);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void update(MemberDTO member) {
        dao.update(member);
    }

    @Override
    public void unregist(String id) {
        dao.delete(id);
    }
}
