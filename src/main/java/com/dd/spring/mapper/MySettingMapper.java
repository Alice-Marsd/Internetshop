package com.dd.spring.mapper;

import com.dd.spring.bean.User_addr;
import com.dd.spring.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MySettingMapper {

    @Select("select * from users where user_id=#{user_id}")
    public Users getUserById(Integer user_id);

    @Select("select *from user_addr where user_id=#{user_id}")
    public User_addr getAddrById(Integer user_id);

    @Update("update user_addr SET " +
            "receive_addr=#{receive_addr},receive_phone=#{receive_phone}," +
            "detail_addr=#{detail_addr},default_addr=#{default_addr} " +
            "where user_addrid=#{user_addrid}")
    public void updateUserAddrMsg(User_addr user);

    @Update("update users SET " +
            "user_name=#{user_name},user_password=#{user_password}," +
            "user_head=#{user_head},user_email=#{user_email}," +
            "user_sex=#{user_sex},user_phone=#{user_phone}," +
            "user_birthday=#{user_birthday},user_idcard=#{user_idcard}," +
            "user_realname=#{user_realname}" +
            "where user_id=#{user_id}")
    public void updateUserMsg(Users user);



}
