package com.example.smsauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @ResponseBody
    @GetMapping("/check/sendSMS")
    public String sendSms(String phoneNumber){
        String rNum = service.randNum();
        service.certifiedPhoneNumber(phoneNumber,rNum);
        return rNum;
    }
    @GetMapping("/home")
    public String asd(String phoneNumber){

        return "home";
    }

}
