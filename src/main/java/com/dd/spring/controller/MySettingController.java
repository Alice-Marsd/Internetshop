package com.dd.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.dd.spring.bean.User_addr;
import com.dd.spring.bean.Users;
import com.dd.spring.mapper.MySettingMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MySettingController {

    @Autowired(required = false)
    MySettingMapper mySettingMapper;

    Logger log=Logger.getLogger(MySettingMapper.class);

    @ResponseBody
    @GetMapping("/mySet/{user_id}")
    public Object mySetting(@PathVariable("user_id") Integer user_id, Model model)
    {
        Users user = mySettingMapper.getUserById(user_id);
        User_addr addr = mySettingMapper.getAddrById(user_id);
        model.addAttribute("user_id",user_id);
        model.addAttribute("user",user);
        model.addAttribute("addr",addr);
       // return "set/mySetting";
        return JSONObject.toJSON(mySettingMapper.getUserById(user_id));
    }


    @ResponseBody
    @PostMapping(value = "/mySet")
    public Object updatePersonMsg(@RequestParam("user_id") Integer user_id,@RequestParam("user_name") String user_name,
                                  @RequestParam("user_email") String user_email,
                                  @RequestParam("user_sex") String user_sex,@RequestParam("user_phone") String user_phone,
                                  @RequestParam("user_card") String user_idcard,@RequestParam("real_name") String real_name,
                                  @RequestParam("user_addrid") Integer user_addrid,@RequestParam("receive") String receive,
                                  @RequestParam("receive_phone") String receive_phone,@RequestParam("detail")String detail,
                                  @RequestParam("default") String defaultMsg,
                                  Model model)
    {
        Users user = mySettingMapper.getUserById(user_id);
        Users user1 = new Users(user_id,user_name,user.getUser_password(),user.getUser_head(),user_email,user_sex,user_phone,user.getUser_birthday(),user_idcard,user.getUser_registerday(),real_name);
        User_addr user_addr = new User_addr(user_addrid, user_id, receive, receive_phone, detail, defaultMsg);

        mySettingMapper.updateUserMsg(user1);
        mySettingMapper.updateUserAddrMsg(user_addr);
       // return "redirect:/my/"+user_id;
        return JSONObject.toJSON(mySettingMapper.getUserById(user_id));
    }

    @GetMapping("/mySet/pwd/{user_id}")
    public String updateUserName(@PathVariable("user_id") Integer user_id,Model model)
    {
        Users user = mySettingMapper.getUserById(user_id);
        model.addAttribute("pwd",user.getUser_password());
        return "set/uploadPassword";
    }




}
