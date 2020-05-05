package com.xubin.learn.controller;

import com.xubin.learn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            return "redirect:/login";
        }else{
            return "redirect:/home";
        }
    }
    /**
     * 登陆页
     * @return
     */
    @RequestMapping("/login")
    public String login(Map<String,Object> map){
        return "login";
    }

    /**
     * 用户页
     * @return
     */
    @RequestMapping("/home")
    public String home(Map<String,Object> map,HttpServletRequest request){
        map.put("user",request.getSession().getAttribute("user"));
        return "home";
    }

    /**
     * 登录
     * @param user
     * @param request
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request, RedirectAttributes redirectAttributes){
        if("admin".equals(user.getAccount())&&"admin".equals(user.getPassword())){
            request.getSession().setAttribute("user",user);
            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("msg","帐号或密码错误");
        return "redirect:/login";
    }

}
