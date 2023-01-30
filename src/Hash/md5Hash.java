package Hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5Hash {
    private String md5Hex;

    public md5Hash(String text){
        md5HashFunc(text);
    }

    public void md5HashFunc(String text){
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try{
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(text.getBytes());
            digest = messageDigest.digest();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        BigInteger bigInteger = new BigInteger(1,digest);
        String md5Hash = bigInteger.toString(16);

        while (md5Hash.length()<32){
            md5Hash = "0"+md5Hash;
        }
        md5Hex = md5Hash;
    }

    public String getMd5Hex(){
        return md5Hex;
    }
}
