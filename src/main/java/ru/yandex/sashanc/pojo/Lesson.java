package ru.yandex.sashanc.pojo;

import java.sql.Date;
import java.sql.Time;

public class Lesson {
    private int id;
    private String disName;
    private String theme;
    private String link;
    private String place;
    private Date date;
    private Time time;

    public Lesson(int id, String disName, String theme, String link, String place, Date date, Time time) {
        this.id = id;
        this.disName = disName;
        this.theme = theme;
        this.link = link;
        this.place = place;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
