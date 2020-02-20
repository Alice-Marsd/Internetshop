package com.dd.spring.mapper;

import com.dd.spring.bean.Orders;
import com.dd.spring.bean.User_addr;
import com.dd.spring.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

@Mapper
public interface MyWebMapper {

    //ID找用户
    @Select("select * from users where user_id=#{user_id}")
    public Users getUserById(Integer user_id);

    //    通过用户ID来找到他的收藏夹
    @Select("select * from collections where user_id=#{user_id}")
    public Integer getCollectionsId(Integer user_id);

    //找订单状态
    @Select("select * from orders where user_id=#{user_id} and state=#{statue}")
    public Collection<Orders> getOrderStatue(@Param("user_id") Integer user_id,@Param("statue") Integer statue);

    //查询所有订单
    @Select("select * from orders where user_id=#{user_id}")
    public Collection<Orders> getAllOrder(Integer user_id);

    //删除订单
    @Delete("delete from orders where order_id=#{order_id}")
    public void deleteOrder(Integer order_id);

    @Update("update users SET user_head=#{user_head} where user_id=#{user_id}")
    public void updateUserHead(Users user);



}
