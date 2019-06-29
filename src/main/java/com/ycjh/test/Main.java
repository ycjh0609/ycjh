package com.ycjh.test;

import com.ycjh.common.util.RSAUtil;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class Main {

    public static void main(String args []) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAUtil rsa = new RSAUtil();
        System.out.println(rsa.getPublicKey().toString());
        System.out.println(rsa.getPrivateKey());
    }
}
