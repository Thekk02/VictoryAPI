package com.Victory.VictoryApplicationAPI.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kk
 * @description rsa密钥生成工具类
 * @date 2025-07-04 09:11:07
 */
public class RSAUtil {
    private static Map<String,String> map = new HashMap<>();
    public RSAUtil() throws NoSuchAlgorithmException{
        genKeyPair();
    }

    //对文本进行加密
    private static String Encryption(String content,String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] decodeBase64 = Base64.decodeBase64(publicKey);
        PublicKey rsa = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decodeBase64));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,rsa);
        String outStr = Base64.encodeBase64String(cipher.doFinal(content.getBytes()));
        return outStr;
    }

    //对文本进行解密
    private static String Decryption(String publickey,String privateKe) throws Exception{
        byte[] publicKeyByte = Base64.decodeBase64(publickey.getBytes("UTF-8"));
        byte[] privateKeyByte = Base64.decodeBase64(privateKe.getBytes("UTF-8"));
        RSAPrivateKey generatePublic = (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyByte));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,generatePublic);
        return new String(cipher.doFinal(publicKeyByte));
    }

    //随机生成密钥对
    public static void genKeyPair() throws NoSuchAlgorithmException{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        //私钥
        PrivateKey privateK = keyPair.getPrivate();
        //公钥
        PublicKey publicK = keyPair.getPublic();

        //PrivateKey2String
        String privateKey = new String(Base64.encodeBase64(privateK.getEncoded()));
        //Public Key2String
        String publicKey = new String(Base64.encodeBase64(publicK.getEncoded()));
        map.put("publicKey",publicKey);
        map.put("privateKey",privateKey);
    }

    public String getPublicKey(){
        return this.map.get("publicKey");
    }

    public String getPrivateKey(){
        return this.map.get("privateKey");
    }



}
