package com.example.a1027.hyunwoolee.message;

/**
 * Created by 1027 on 2016-10-29.
 */

public class MessageDTO {
    private String receiver, content, writer, sendDate, seq;
    //seq로 자동으로 유니크한 값을 정해준다. 이걸 만드는 문법을 배우는 과정

    @Override
    public String toString() {
        return "메시지{" +
                "받는이 : '" + receiver + '\'' +
                ", 내용 : '" + content + '\'' +
                ", 글쓴이 : '" + writer + '\'' +
                ", 보낸시간 : '" + sendDate + '\'' +
                ", 일련번호 : '" + seq + '\'' +
                '}';
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
