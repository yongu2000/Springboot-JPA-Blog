package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {
    private User user;

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    // 계정이 만료됐는 지 리턴 (true: 만료 안됨)

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는 지 리턴 (true: 안잠김)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 비밀번호가 만료되지 않았는 지 리턴 (true: 만료 안됨)

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 인지 리턴 (true: 활성화 됨)
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 계정이 가지고 있는 권한 목록을 리턴.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> "ROLE_"+user.getRole());
        return collectors;
    }
}
