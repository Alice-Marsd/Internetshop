package com.dd.spring.bean;

public class User_addr {
   private Integer user_addrid;// 用户地址id
   private Integer user_id ;//  用户id
   private String receive_addr; //  收货地址
   private String receive_phone; // 收货电话
   private String  detail_addr;// 详细地址
   private String default_addr;//默认收货地址

    public User_addr() {

    }

    public User_addr(Integer user_addrid, Integer user_id, String receive_addr, String receive_phone, String detail_addr, String default_addr) {
        this.user_addrid = user_addrid;
        this.user_id = user_id;
        this.receive_addr = receive_addr;
        this.receive_phone = receive_phone;
        this.detail_addr = detail_addr;
        this.default_addr = default_addr;
    }

    public Integer getUser_addrid() {
        return user_addrid;
    }

    public void setUser_addrid(Integer user_addrid) {
        this.user_addrid = user_addrid;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getReceive_addr() {
        return receive_addr;
    }

    public void setReceive_addr(String receive_addr) {
        this.receive_addr = receive_addr;
    }

    public String getReceive_phone() {
        return receive_phone;
    }

    public void setReceive_phone(String receive_phone) {
        this.receive_phone = receive_phone;
    }

    public String getDetail_addr() {
        return detail_addr;
    }

    public void setDetail_addr(String detail_addr) {
        this.detail_addr = detail_addr;
    }

    public String getDefault_addr() {
        return default_addr;
    }

    public void setDefault_addr(String default_addr) {
        this.default_addr = default_addr;
    }
}
