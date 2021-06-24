package com.example.smsauth;

import net.nurigo.java_sdk.Coolsms;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Random;

@org.springframework.stereotype.Service
public class Service {

    public String randNum(){
        Random rand = new Random();
        String numStr="";

        for(int i=0; i<6;i++){
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        System.out.println("인증번호: "+numStr);
        return numStr;
    }

    public void certifiedPhoneNumber(String phoneNumber, String cerNum){
        String api_key = "NCSFNGQWT6LR7VI3";
        String api_secret = "WNSHSGKRJND0KRVVOIJXPUK2SHNS4ESA";
        Message coolSms = new Message(api_key, api_secret);

        HashMap<String, String> params = new HashMap<>();
        params.put("to",phoneNumber);
        params.put("from","01093313677");
        params.put("type","SMS");
        params.put("text",String.format("테스트 인증메세지 : 인증번호는 [%s] 입니다", cerNum));
        params.put("app_version","test app 1.2");

        try {
            JSONObject obj = coolSms.send(params);
            System.out.println(obj.toString());
        }catch (CoolsmsException e){
//            System.out.println(e.getMessage());
//            System.out.println(e.getCode());
        }
    }
}
