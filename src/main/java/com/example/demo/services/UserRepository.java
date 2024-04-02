package com.example.demo.services;

import com.example.demo.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
    }

