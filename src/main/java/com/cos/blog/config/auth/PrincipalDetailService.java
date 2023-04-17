package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    // 로그인 요청 가로챌 때 username, password 변수 처리 할 때, username이 db에 있는지 확인한 후 리턴
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다: "+username));
        return new PrincipalDetail(principal);
    }
}
