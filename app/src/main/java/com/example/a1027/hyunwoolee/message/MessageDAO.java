package com.example.a1027.hyunwoolee.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static com.example.a1027.hyunwoolee.util.Constants.DB_NAME;
import static com.example.a1027.hyunwoolee.util.Constants.DB_VERSION;

/**
 * Created by 1027 on 2016-10-29.
 */

public class MessageDAO extends SQLiteOpenHelper{
    //자동으로 id 값에 1,2 3... 순서대로 넣어준다
    public static final String SEQ = "_id";
    //---------------------------
    public static final String RECEIVER = "reciever";
    public static final String CONTENT = "content";
    public static final String SEND_DATE = "send_date";

    public MessageDAO(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        // 위치값, 만들려는 db이름, 팩토리, 버전(1부터 시작)
        this.getWritableDatabase(); //입력가능한 db로 만들어라
        Log.d(DB_VERSION + "버전의 DB 생성","성공!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists member;");
        this.onCreate(db);
        db.execSQL("drop table if exists message;");
        this.onCreate(db);
    }

    public void write(MessageDTO member) {

    }

    public ArrayList<MessageDTO> getList() {
        return null;
    }

    public ArrayList<MessageDTO> getListByID(String id) {
        String sql = "SELECT receiver, content, id, send_date, seq(s)\n" +
                "FROM message\n" +
                "JOIN member\n" +
                "ON a.id=b.id;";
        String sql2 = "SELECT receiver, content, id, send_date, seq(s)\n" +
                "FROM member\n" +
                "WHERE id \n" +id;

        return null;
    }

    public MessageDTO getMessage(int seq) {


        return null;
    }

    public int count() {
        return 0;
    }

    public void deleteMessage(String id) {

    }

}
