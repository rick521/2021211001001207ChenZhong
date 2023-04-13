package com.chenzhong.model;

import java.util.Date;

public class User {
    int id;
    String usermane;
    String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usermane='" + usermane + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    String email;
    String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsermane() {
        return usermane;
    }

    public void setUsermane(String usermane) {
        this.usermane = usermane;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public User(int id, String usermane, String password, String email, String gender, Date birthDate) {
        this.id = id;
        this.usermane = usermane;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    Date birthDate;
}
