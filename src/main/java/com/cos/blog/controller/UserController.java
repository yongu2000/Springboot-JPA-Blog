package com.cos.blog.controller;

import com.cos.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 인증 안된 유저들 허용 경로 /auth 로 시작
// 그냥 주소가 / 이면 index.jsp 허용
@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String join() {
//        model.addAttribute("user", new User());
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String login() {
        return "user/loginForm";
    }
}
