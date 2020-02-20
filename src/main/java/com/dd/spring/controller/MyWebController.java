package com.dd.spring.controller;

import com.dd.spring.bean.Orders;
import com.dd.spring.bean.Users;
import com.dd.spring.mapper.MyWebMapper;
import com.dd.spring.util.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


@Controller
public class MyWebController {

    @Autowired(required = false)
    private  MyWebMapper myWebMapper;

    @Autowired
    AliyunOSSUtil aliyunOSSUtil;


    @GetMapping({"/","/index.html"})
    public String index(Model model)
    {
        Integer user_id=new Integer(1);
        model.addAttribute("user_id",user_id);
        return "index";
    }

    @GetMapping("/my/{user_id}")
    public  String getUserById(@PathVariable("user_id") Integer user_id, Model model)
    {
        //昵称 头像
        Users user = myWebMapper.getUserById(user_id);
        model.addAttribute("user", user);
        model.addAttribute("user_id",user_id);
        //所有订单
        Collection<Orders> orders = myWebMapper.getAllOrder(user_id);
        model.addAttribute("orders",orders);
        return "main/myWeb";
    }

    @ResponseBody
    @RequestMapping("/my/head")
    public String uploadpic(HttpServletRequest request,
                            @RequestParam("user_id") Integer user_id,
                            @RequestParam(value = "user_head",required =false) MultipartFile file)
    {

        try {
            String user_head=aliyunOSSUtil.uploadBlog(file);
            System.out.println(user_head);
            System.out.println("user_head---->"+user_head);
            Users user = myWebMapper.getUserById(user_id);
            user.setUser_head(user_head);
            myWebMapper.updateUserHead(user);

        }catch (Exception e)
        {
            System.out.println("上传图片失败"+e.getMessage());
        }

        return "success";
    }

    @GetMapping("/orders/{user_id}")
    public String getAllOrders(@PathVariable("user_id") Integer user_id,Model model)
    {
        Collection<Orders> orders = myWebMapper.getAllOrder(user_id);
        String statueMsg="全部订单";
        model.addAttribute("orders",orders);
        model.addAttribute("statueMsg",statueMsg);
        return "orders/orderList";
    }

    @GetMapping("/orders/{statue}/{user_id}")
    public String unPaid(@PathVariable("user_id") Integer user_id,@PathVariable("statue") Integer statue,Model model)
    {

        Collection<Orders> orders = myWebMapper.getOrderStatue(user_id, statue);
        String statueMsg=null;
        switch (statue)
        {
            case 0:statueMsg="待支付页面";break;
            case 1:statueMsg="待发货页面";break;
            case 2:statueMsg="待收货页面";break;
            case 3:statueMsg="待评价页面";break;
            case 4:statueMsg="已完成页面";break;
            default:statueMsg="全部订单";
        }

        model.addAttribute("statueMsg",statueMsg);
        model.addAttribute("orders",orders);

       return "orders/orderList";
    }



    @GetMapping("/myFoot/{user_id}")
    public String myFoot(@PathVariable("user_id") Integer user_id, Model model)
    {
        model.addAttribute("user_id",user_id);
        return "foot/myFoot";
    }

    @GetMapping("/orders/del/{order_id}/{user_id}")
    public String deleteOrder(@PathVariable("order_id") Integer order_id ,@PathVariable("user_id") Integer user_id)
    {

        myWebMapper.deleteOrder(order_id);
        return "redirect:/orders/"+user_id;

    }
}
