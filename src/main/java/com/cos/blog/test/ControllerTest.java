package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {

    @GetMapping("/test/hello")
    public String hello() {
        return "index";
    }
}
