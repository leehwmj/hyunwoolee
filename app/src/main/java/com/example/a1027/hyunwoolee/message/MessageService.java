package com.example.a1027.hyunwoolee.message;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-29.
 */

public interface MessageService {
    // CREATE
    public void write(MessageDTO member);
    //READ
    public ArrayList<MessageDTO> getList();
    public ArrayList <MessageDTO> getListById(MessageDTO member);
    public MessageDTO getOne(MessageDTO member);
    public int count();
    //DELETE
    public void deleteMessage(String id);
    //추상메소드들임
}
