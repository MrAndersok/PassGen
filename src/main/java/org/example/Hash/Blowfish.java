package org.example.Hash;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Blowfish {
    private static SecretKey secretKey ;

    public Blowfish(String key){
        try {
            String salt = "@$#baelDunG@#^$*";
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(key.toCharArray(),salt.getBytes(),65536,256);
            secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(),"Blowfish");
            System.out.println(secretKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
     public static void encrypt(InputStream is, OutputStream os)  {
         try {
             Cipher cipher = Cipher.getInstance("Blowfish");
             cipher.init(Cipher.ENCRYPT_MODE, secretKey);
             CipherInputStream cis = new CipherInputStream(is, cipher);
             doCopy(cis,os);
         } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
             throw new RuntimeException(e);
         }
     }
     public static void decrypt(InputStream is,OutputStream os){
         try {
             Cipher cipher = Cipher.getInstance("Blowfish");

             cipher.init(Cipher.DECRYPT_MODE, secretKey);
             System.out.println("OK");
             CipherOutputStream cos = new CipherOutputStream(os, cipher);
             doCopy(is,cos);
         } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
             throw new RuntimeException(e);
         }
     }
     public static void doCopy(InputStream is, OutputStream os){
         try {
            byte[ ] bytes = new byte[64];
            int numBytes;
            while ((numBytes = is.read(bytes))!=-1) {
                os.write(bytes,0,numBytes);
             }
            os.flush();
            os.close();
            is.close();
             }catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
}
