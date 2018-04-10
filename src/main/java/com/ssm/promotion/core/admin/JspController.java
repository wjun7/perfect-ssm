package com.ssm.promotion.core.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("traffic")
public class JspController {
    @RequestMapping("/zhonghe")
    public String pathZhonghe(){
        return "jsp/news/zhonghe";
    }

    @RequestMapping("/zhuye")
    public String pathZhuye(){
        return "redirect:/articles/list";
    }

    @RequestMapping("/liuyanban")
    public String pathLiuyanban(){
        return "redirect:/messages/list";
    }

    @RequestMapping("/erweima")
    public String pathErweima(){
        return "jsp/news/erweima";
    }

    @RequestMapping("/signup")
    public String pathSignup(){
        return "jsp/news/signup";
    }

    @RequestMapping("/login")
    public String pathLogin(){
        return "jsp/login";
    }

    @RequestMapping("/con")
    public String pathCon(){
        return "jsp/news/con";
    }


}