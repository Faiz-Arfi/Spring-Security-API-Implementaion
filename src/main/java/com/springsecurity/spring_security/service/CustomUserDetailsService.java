package com.springsecurity.spring_security.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springsecurity.spring_security.CustomUserDetails;
import com.springsecurity.spring_security.Repository.UserRepository;
import com.springsecurity.spring_security.entity.User;

@Component
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User existingUser = userRepository.findByUsername(username);
        
        if(Objects.isNull(existingUser)){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(existingUser);
    }

}
