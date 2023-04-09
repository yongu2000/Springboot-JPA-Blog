package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerTest {

    @GetMapping("/test/hello")
    public String hello() {
        return "home";
    }
}
