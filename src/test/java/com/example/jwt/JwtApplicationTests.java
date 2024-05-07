package com.example.jwt;

import com.example.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate(){
        var claims = new HashMap<String, Object>();
        claims.put("user_id", 923);

        var expiredAt = LocalDateTime.now().plusMinutes(10);

        var jwtToken = jwtService.create(claims, expiredAt);
        System.out.println("token ::" + jwtToken);

    }

    @Test
    void tokenValidation(){

        var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTcxNTA5MjM4Nn0.HZeBxUVcVjDVVLzlR55wC-i2hr-o44AmUEV8q6_Cwvk";

        jwtService.validation(token);

    }

}
