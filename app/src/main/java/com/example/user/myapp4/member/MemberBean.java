package com.example.user.myapp4.member;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberBean {
    private String id;
    private String pwd;
    private String name;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[회원정보]" +
                "ID='" + id + '\'' +
                ", 비번='" + pwd + '\'' +
                ", 이름='" + name + '\'' +
                ", 이메일='" + email + '\'' ;
    }
}
