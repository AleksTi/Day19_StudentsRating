package ru.yandex.sashanc.pojo;

import java.sql.Date;
import java.sql.Time;

public class Lesson {
    private int id;
    private String disciplineName;
    private String theme;
    private String link;
    private String place;
    private Date date;
    private Time time;
    private String teacherName;
    private String teacherSurname;

    public Lesson() {

    }

    public Lesson(int id, String disciplineName, String theme, String link, String place, Date date, Time time) {
        this.id = id;
        this.disciplineName = disciplineName;
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

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }
}
