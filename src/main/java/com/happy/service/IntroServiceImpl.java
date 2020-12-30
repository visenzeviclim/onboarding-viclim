package com.happy.service;

import org.springframework.stereotype.Service;

@Service
public class IntroServiceImpl implements IntroService{

    @Override
    public String greet() {
        return "Welcome Here !!!!";
    }
}
