package com.ycjh.user.controller;


import com.ycjh.user.model.UserModel;
import com.ycjh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    private final int KEY_SIZE = 1024;
    /**
     * @desc forwarding rsaModel
     * @param session
     * @param request
     * @param response
     * @exception NoSuchAlgorithmException, InvalidKeySpecException
     * @return rsaMap
     */
    @GetMapping("/login")
    public Map login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(KEY_SIZE);

        KeyPair keyPair = generator.genKeyPair();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();


        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

        String publicKeyModulus = publicSpec.getModulus().toString(16);
        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
        Map<String,String> rsaMap = new HashMap<>();
        rsaMap.put("publicKeyModulus", publicKeyModulus);
        rsaMap.put("publicKeyExponent", publicKeyExponent);
        session.setAttribute("_rsaPrivateKey_",privateKey);

        return rsaMap;
    }
    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam String test) throws  Exception{

        PrivateKey privateKey = (PrivateKey) session.getAttribute("_rsaPrivateKey_");
        session.removeAttribute("_rsaPrivateKey_"); //
        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        System.out.println(test);
        String reuslt = decryptRsa(privateKey,test);

        return reuslt;
    }
    private String decryptRsa(PrivateKey privateKey, String securedValue) throws  Exception{

        Cipher cipher = Cipher.getInstance("RSA");
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
        return decryptedValue;
    }

    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) {
            return new byte[]{};
        }
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }

}
