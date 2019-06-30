package com.ycjh;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.test.context.ContextConfiguration;


public class JwtTest {


    String jwtString = Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setHeaderParam("issueDate", System.currentTimeMillis())
            .setSubject("내용")
            .signWith(SignatureAlgorithm.HS512, "aaaa")
            .compact();
}
