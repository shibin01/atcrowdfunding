package com.shibin.controller;

import com.shibin.bean.User;
import com.shibin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model){
        User dbUser = userService.getUserByMsg(user);
        if(dbUser == null){
            model.addAttribute("msg", "用户名或者密码错误");
            return "redirect:/login";
        }else{
            return "main";
        }
    }

    @RequestMapping("/doAjaxLogin")
    @ResponseBody
    public Map<String, String> doAjaxLogin(User user, HttpSession httpSession){

        Map<String, String> map = new HashMap<>();
        User dbUser = userService.getUserByMsg(user);
        if(dbUser == null){
            map.put("result", "fail");
            map.put("msg", "用户名或者密码错误");
        }else{
            httpSession.setAttribute("user", dbUser);
            map.put("result", "success");
        }
        return map;
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login";
    }
}
