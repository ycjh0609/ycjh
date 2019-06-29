package com.ycjh.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;


@Controller
@RequestMapping("/user")
public class UserController {

    private final int KEY_SIZE = 1024;
    /**
     * @desc forwarding login html
     * @param session
     * @param request
     * @param response
     * @exception NoSuchAlgorithmException, InvalidKeySpecException
     * @return
     */
    @GetMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(KEY_SIZE);

        KeyPair keyPair = generator.genKeyPair();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();


        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

        String publicKeyModulus = publicSpec.getModulus().toString(16);
        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

        request.setAttribute("publicKeyModulus", publicKeyModulus);
        request.setAttribute("publicKeyExponent", publicKeyExponent);
        session.setAttribute("_rsaPrivateKey_",privateKey);

        return "user/login";
    }

}
