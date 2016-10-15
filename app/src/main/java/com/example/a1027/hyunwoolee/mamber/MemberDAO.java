package com.example.a1027.hyunwoolee.mamber;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a1027.hyunwoolee.util.Retval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public static final String DB_NAME = "hanbit.db";
    public static final int DB_VERSION = 1;
    public static final String ID = "id";
    public static final String PW ="pw";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";
    public static final String PHONE = "phone";
    public static final String PHOTO = "profileImg";
    public static final String TABLE_NAME = "member";
    public MemberDAO(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        // 위치값, 만들려는 db이름, 팩토리, 버전(1부터 시작)
        this.getWritableDatabase(); //입력가능한 db로 만들어라
        Log.d(DB_VERSION + "버전의 DB 생성","성공!");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists member("
               + "id text primary key,"
               + "pw text,"
               + "name text,"
               + "email text,"
               + "addr text,"
               + "phone text,"
               + "profileImg text)");
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                +"values"
                +"('hong1','1','hongildong','hong1@gmail.com','seoul','010-1234-5678','default.jpg')"
                );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        +"values"
                        +"('hong2','1','hongyeedong','hong2@gmail.com','seoul','010-1234-5678','default.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        +"values"
                        +"('hong3','1','hongsamdong','hong3@gmail.com','seoul','010-1234-5678','default.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        +"values"
                        +"('hong4','1','hongsadong','hong4@gmail.com','seoul','010-1234-5678','default.jpg')"
        );
        db.execSQL(
                "insert into member(id,pw,name,email,addr,phone,profileImg)"
                        +"values"
                        +"('hong5','1','hongohdong','hong5@gmail.com','37.5597680,126.9423080','010-9307-1297','default.jpg')"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Androin values(null, 'android_6.0.0,1);");
        db.execSQL("insert into Androin values(null, 'android_6.0.1,2);");
    }
// DML (CREATE(insert))
public void insert(MemberDTO param){
    String sql = "insert into " + TABLE_NAME
            +String.format("(%s,%s,%s,%s,%s,%s,%s,%s)",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
            +String.format(" values('%s','%s','%s','%s','%s','%s','%s','%s')"
            ,param.getId(), param.getPw(), param.getName(), param.getEmail(), param.getAddr()
            ,param.getPhone(), param.getProfileImg());
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql);
    db.close();
}
// DML (READ(select))
    // 검색 조건 없이 전체 목록 조회
    public ArrayList<MemberDTO> selectList(){
        Log.i("====== DAO 전체조회 :","selectList() 진입");
        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
            +" from member;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        if(cursor != null){
            Log.i("DAO LIST 조회결과","SUCCESS");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));
            list.add(temp);

        }while (cursor.moveToNext());
        return list;
    }
    // 검색조건이 있는 상황에서 목록 조회
    public ArrayList<MemberDTO> selectList(MemberDTO param){
        Log.i("====== DAO 전체조회 :","selectList() 진입");
        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +" from member;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        if(cursor != null){
            Log.i("DAO LIST 조회결과","SUCCESS");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));
            list.add(temp);

        }while (cursor.moveToNext());
        return list;
    }

    public MemberDTO selectOne(MemberDTO param){
            Log.i("====== DAO 전체조회 :","selectList() 진입");
            String sql = "select "
                    + String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                    + String.format(" from %s where %s = '%s';",TABLE_NAME, ID, param.getId());
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(sql,null);
        MemberDTO temp = null;
        if(cursor.moveToNext()){
                Log.i("DAO ID 조회결과","SUCCESS");
                cursor.moveToFirst();
                temp = new MemberDTO();
                temp.setId(cursor.getString(0));
                temp.setPw(cursor.getString(1));
                temp.setName(cursor.getString(2));
                temp.setEmail(cursor.getString(3));
                temp.setAddr(cursor.getString(4));
                temp.setPhone(cursor.getString(5));
                temp.setProfileImg(cursor.getString(6));
            }
            return temp;
    }
    public int count(){
        Log.i("====== DAO count :","진입");
        String sql = "select count(*) as count from member";
        SQLiteDatabase db = this.getReadableDatabase();
        int count = 0;
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToNext()){
            Log.i("DAO ID 조회결과","SUCCESS");
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        return count;
    }
// DML (UPDATE(update))
public void update(MemberDTO param){
    Log.i("====== DAO update :","진입");
    String sql = "update member set "
            + "pw = '2',"
            + "email = '3',"
            + "addr = '4',"
            + "profileimg = '5',"
            + "where id = hong11";
    SQLiteDatabase db = this.getWritableDatabase();
    db.execSQL(sql);
    db.close();
}
// DML (DELETE(delete))
    public void delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
    }

}
