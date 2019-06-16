package com.ycjh.common.util;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;

public class RSAUtil {

    private final static int KEY_SIZE = 1024;
    private HashMap<String,String> publicKeyMap;
    private PrivateKey privateKey;

    public RSAUtil () throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(KEY_SIZE, secureRandom);

        KeyPair keyPair = generator.generateKeyPair();
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");


        PublicKey publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();

        RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        String publicKeyModulus = publicSpec.getModulus().toString(16);
        String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
        this.publicKeyMap = new HashMap<String,String>();
        this.publicKeyMap.put("publicKeyModulus", publicKeyModulus);
        this.publicKeyMap.put("publicKeyExponent", publicKeyExponent);

    }
    public HashMap<String,String> getPublicKey(){
        return this.publicKeyMap;
    }
    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

}
