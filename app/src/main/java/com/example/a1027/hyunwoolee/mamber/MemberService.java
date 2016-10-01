package com.example.a1027.hyunwoolee.mamber;

import com.example.a1027.hyunwoolee.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    public MemberDTO login(MemberDTO member);
    public Retval join(MemberDTO member);
    //추상메소드들임
}
