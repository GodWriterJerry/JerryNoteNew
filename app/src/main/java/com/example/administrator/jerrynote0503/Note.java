package com.example.administrator.jerrynote0503;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/3.
 */

public class Note extends DataSupport{
    private String title;
    private String content;
    private String date;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
