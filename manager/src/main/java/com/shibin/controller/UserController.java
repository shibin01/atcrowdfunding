package com.shibin.controller;

import com.shibin.bean.User;
import com.shibin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到用户维护界面
     */
    @RequestMapping("/index")
    public String toUser(@RequestParam(required = false,defaultValue = "1") Integer pageCount,
                         @RequestParam(required = false,defaultValue = "2") Integer pageSize, Model model){

        Map<String, Integer> pageMap = new HashMap<String, Integer>();
        pageMap.put("pageCount", (pageCount - 1) * pageSize);
        pageMap.put("pageSize", pageSize);

        //分页查询用户数据
        List<User> users = userService.findUsers(pageMap);
        //用户总条数
        int totalUsers = userService.findUserCounts();
        //当前页数
        model.addAttribute("currentPage", pageCount);
        //总页数
        int total = 0;
        if(totalUsers % pageSize == 0){
            total = totalUsers/pageSize;
        }else{
            total = totalUsers/pageSize + 1;
        }
        model.addAttribute("totalPage", total);
        model.addAttribute("users", users);
        System.out.println(users);
        return "user/index";
    }

}
