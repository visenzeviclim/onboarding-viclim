package com.happy.controller;

import com.happy.service.IntroServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IntroController {

    private IntroServiceImpl introService;

    public IntroController(IntroServiceImpl introService){
        this.introService = introService;
    }

    @RequestMapping("/intro")
    @ResponseBody
    public String giveIntro(){
        return this.introService.greet();
    }
}
