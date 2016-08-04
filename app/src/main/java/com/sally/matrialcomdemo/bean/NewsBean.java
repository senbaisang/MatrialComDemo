package com.sally.matrialcomdemo.bean;

import java.io.Serializable;

/**
 * Created by sally on 8/4/16.
 */
public class NewsBean implements Serializable {

    private String title;
    private String content;
    private int picture;

    public NewsBean() {
    }

    public NewsBean(String title, String content, int picture) {
        this.title = title;
        this.content = content;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", picture=" + picture +
                '}';
    }
}
