package com.springboot.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(UserInfo userInfo) {
        userRepository.save(userInfo);
    }

    public List<UserInfo> getUsers(){
        return userRepository.findAll();
    }
}
