package ru.yandex.sashanc.pojo;

public class Log {
    private int id;
    private String discipline;
    private String theme;
    private String nameStudent;
    private String surnameStudent;
    private String group;
    private int mark;
    private boolean attend;

    public Log(int id, String discipline, String theme, String nameStudent, String surnameStudent, String group, int mark, boolean attend) {
        this.id = id;
        this.discipline = discipline;
        this.theme = theme;
        this.nameStudent = nameStudent;
        this.surnameStudent = surnameStudent;
        this.group = group;
        this.mark = mark;
        this.attend = attend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSurnameStudent() {
        return surnameStudent;
    }

    public void setSurnameStudent(String surnameStudent) {
        this.surnameStudent = surnameStudent;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }
}
