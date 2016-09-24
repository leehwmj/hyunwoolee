package com.example.a1027.hyunwoolee;

/**
 * Created by 1027 on 2016-09-24.
 */

public interface CalcService {
    public CalcDTO plus(CalcDTO cal);
    public CalcDTO minus(CalcDTO cal);
    public CalcDTO multi(CalcDTO cal);
    public CalcDTO divid(CalcDTO cal);
    public CalcDTO remainder(CalcDTO cal);
}
