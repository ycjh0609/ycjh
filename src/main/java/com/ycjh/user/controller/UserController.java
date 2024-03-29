package com.ycjh.user.controller;


import com.ycjh.common.Model.ResponseAPIModel;
import com.ycjh.jwt.service.JwtService;
import com.ycjh.user.model.UserModel;
import com.ycjh.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
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
    @Autowired
    JwtService jwtService;


    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final int KEY_SIZE = 1024;
    private final String KET_ALG ="RSA";
    private final String KEY_SESSION_NM ="_rsaPrivateKey_";
    /**
     * @desc forwarding rsaModel
     * @param session
     * @exception NoSuchAlgorithmException, InvalidKeySpecException
     * @return rsaMap
     */
    @GetMapping("/login")
    public ResponseAPIModel login(HttpSession session) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance(KET_ALG);
        generator.initialize(KEY_SIZE);
        KeyPair keyPair = generator.genKeyPair();
        KeyFactory keyFactory = KeyFactory.getInstance(KET_ALG);
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);

        String publicKeyModulus = publicSpec.getModulus().toString(16);
        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);

        Map<String,String> rsaMap = new HashMap<>();
        rsaMap.put("publicKeyModulus", publicKeyModulus);
        rsaMap.put("publicKeyExponent", publicKeyExponent);
        session.setAttribute(KEY_SESSION_NM,privateKey);

        ResponseAPIModel responseAPIModel = new ResponseAPIModel(rsaMap);
        return responseAPIModel;
    }
    @PostMapping("/login")
    public ResponseAPIModel login(HttpSession session,UserModel userModel,HttpServletResponse response) throws  Exception{

        PrivateKey privateKey = (PrivateKey) session.getAttribute(KEY_SESSION_NM);
        session.removeAttribute(KEY_SESSION_NM); //
        if (privateKey == null) {
            throw new RuntimeException("암호화 비밀키 정보를 찾을 수 없습니다.");
        }
        String user_id = decryptRsa(privateKey,userModel.getSecured_user_id());
        String user_pwd = decryptRsa(privateKey,userModel.getSecured_user_pwd());
        userModel.setUser_id(user_id);
        userModel.setUser_pwd(user_pwd);

        UserModel userCheckModel =new UserModel();//userService.selectUserOne(userModel);
        userCheckModel.setUser_name("지훈");
        userCheckModel.setUser_email("jihoon@naver.com");


        boolean success = true;//UserCheckModel == null ? false:true;
        String token="";
        if (success){
            token = jwtService.makeJwt(userCheckModel);
            response.setHeader("Authorization",token);
        }
        ResponseAPIModel responseAPIModel = new ResponseAPIModel(userCheckModel,success);
        return responseAPIModel;
    }



    private String decryptRsa(PrivateKey privateKey, String securedValue) throws  Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8");
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
