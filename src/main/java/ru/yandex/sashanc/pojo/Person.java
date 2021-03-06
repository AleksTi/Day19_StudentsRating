package ru.yandex.sashanc.pojo;

import java.sql.Date;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private Date regDate;
    private Date lastLogdate;
    private Date confirmDate;

    public Person(String name, String surname, String email, String password, String role, Date regDate, Date lastLogdate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.regDate = regDate;
        this.lastLogdate = lastLogdate;
    }

    public Person(int id, String name, String surname, String email, String password, String role, Date regDate, Date lastLogdate, Date confirmDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.regDate = regDate;
        this.lastLogdate = lastLogdate;
        this.confirmDate = confirmDate;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastLogdate() {
        return lastLogdate;
    }

    public void setLastLogdate(Date lastLogdate) {
        this.lastLogdate = lastLogdate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
}
