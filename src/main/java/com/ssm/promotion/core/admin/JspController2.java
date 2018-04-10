package com.ssm.promotion.core.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class JspController2 {
    @RequestMapping("/main")
    public String pathMain() {
        return "jsp/main";
    }

    @RequestMapping("/article")
    public String pathArticle() {
        return "jsp/admin/articleManage-ke";
    }

    @RequestMapping("/message")
    public String pathMessage() {
        return "jsp/admin/messageManage";
    }

    @RequestMapping("/picture")
    public String pathPicture() {
        return "jsp/admin/pictureManage";
    }

    @RequestMapping("/user")
    public String pathUser() {
        return "jsp/admin/userManage";
    }

    @RequestMapping("/video")
    public String pathVideo() {
        return "jsp/admin/videoManage";
    }


}
