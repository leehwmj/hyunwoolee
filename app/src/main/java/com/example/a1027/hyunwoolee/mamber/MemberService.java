package com.example.a1027.hyunwoolee.mamber;

import com.example.a1027.hyunwoolee.util.Retval;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    // CREATE
    public void regist(MemberDTO member);
    //READ
    public ArrayList <MemberDTO> getList();
    public ArrayList <MemberDTO> getListByName(MemberDTO member);
    public MemberDTO getOne(MemberDTO member);
    public int count();
    //UPDATE
    public void update(MemberDTO member);
    //DELETE
    public void unregist(String id);
    //추상메소드들임
}
