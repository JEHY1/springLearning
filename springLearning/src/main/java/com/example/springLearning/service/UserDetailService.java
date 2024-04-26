package com.example.springLearning.service;

import com.example.springLearning.domain.User;
import com.example.springLearning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("not found user"));
    }
}
