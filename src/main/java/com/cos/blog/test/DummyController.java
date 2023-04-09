package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DummyController {

    @Autowired
    private UserRepository userRepository;


    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            return "삭제에 실패했습니다";
        }
        return "삭제되었습니다 : " + id;
    }

    @PutMapping("/dummy/user/{id}")
    @Transactional
    public User updateUser(@PathVariable int id, @RequestBody User requestUser ) {
        System.out.println("requestUser = " + requestUser.getPassword());
        System.out.println("requestUser = " + requestUser.getEmail());
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("수정 실패"));
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

//        userRepository.save(user);
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        List<User> users = userRepository.findAll(pageable).getContent();
        return users;
    }


    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다 id :" + id));
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("user.getId() = " + user.getId());
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        System.out.println("user.getRole() = " + user.getRole());
        System.out.println("user.getCreateDate() = " + user.getCreateDate());
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }
}
