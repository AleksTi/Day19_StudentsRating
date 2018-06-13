package ru.yandex.sashanc.pojo;

import java.sql.Date;

public class Group {
    private int id;
    private String name;
    private Date studyStart;

    public Group(int id, String name, Date studyStart) {
        this.id = id;
        this.name = name;
        this.studyStart = studyStart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStudyStart() {
        return studyStart;
    }

    public void setStudyStart(Date studyStart) {
        this.studyStart = studyStart;
    }
}
