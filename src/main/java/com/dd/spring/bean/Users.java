package com.dd.spring.bean;


import org.springframework.stereotype.Component;

import java.sql.Date;
@Component
public class Users {

    private Integer user_id;

    private String user_name;

    private String user_password;

    private String user_head;

    private String user_email;

    private String user_sex;

    private String user_phone;

    private Date user_birthday;

    private String user_idcard;

    private Date user_registerday;

    private String user_realname;

    public Users() {

    }

    public Users(Integer user_id, String user_name, String user_password, String user_head, String user_email, String user_sex, String user_phone, Date user_birthday, String user_idcard, Date user_registerday, String user_realname) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_head = user_head;
        this.user_email = user_email;
        this.user_sex = user_sex;
        this.user_phone = user_phone;
        this.user_birthday = user_birthday;
        this.user_idcard = user_idcard;
        this.user_registerday = user_registerday;
        this.user_realname = user_realname;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public Date getUser_birthday() {
        System.out.println("getUser_birthday--------->"+user_birthday);
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        System.out.println("setUser_birthday--------->"+user_birthday);
        this.user_birthday = user_birthday;
    }

    public Integer getUser_id() {

        return user_id;
    }

    public void setUser_id(Integer user_id) {

        this.user_id = user_id;
    }

    public String getUser_name() {

        return user_name;
    }

    public void setUser_name(String user_name) {

        this.user_name = user_name;
    }

    public String getUser_password() {

        return user_password;
    }

    public void setUser_password(String user_password) {

        this.user_password = user_password;
    }

    public String getUser_head() {

        return user_head;
    }

    public void setUser_head(String user_head) {

        this.user_head = user_head;
    }

    public String getUser_email() {

        return user_email;
    }

    public void setUser_email(String user_email) {

        this.user_email = user_email;
    }




    public String getUser_phone() {

        return user_phone;
    }

    public void setUser_phone(String user_phone) {

        this.user_phone = user_phone;
    }


    public String getUser_idcard() {

        return user_idcard;
    }

    public void setUser_idcard(String user_idcard) {

        this.user_idcard = user_idcard;
    }

    public Date getUser_registerday() {

        return user_registerday;
    }

    public void setUser_registerday(Date user_registerday) {

        this.user_registerday = user_registerday;
    }

    public String getUser_realname() {

        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }
}
