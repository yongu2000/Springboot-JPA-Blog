package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpController {
    //http://localhost:8080/http/get
    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청12356 :" + m.getId() + m.getUsername() + m.getPassword();
    }
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
//        return "post 요청 " + text;
        return "post 요청" + m.getId() + m.getUsername() + m.getPassword() + m.getEmail();

    }
    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";

    }
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";

    }
}
