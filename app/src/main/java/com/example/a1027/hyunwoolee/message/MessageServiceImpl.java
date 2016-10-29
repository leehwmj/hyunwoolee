package com.example.a1027.hyunwoolee.message;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-29.
 */

public class MessageServiceImpl implements MessageService{

    MessageDAO dao;
    public MessageServiceImpl(Context context) {
        this.dao = new MessageDAO(context);
    }

    @Override
    public void write(MessageDTO member) {

    }

    @Override
    public ArrayList<MessageDTO> getList() {
        return null;
    }

    @Override
    public ArrayList<MessageDTO> getListById(MessageDTO member) {
        return null;
    }

    @Override
    public MessageDTO getOne(MessageDTO member) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void deleteMessage(String id) {

    }
}
