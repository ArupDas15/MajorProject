package com.block.logic;

import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import com.block.config.Global;

public class StringUtils {

    public static String generateHashUsingSHA256(String inputString) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Global.DEFAULT_HASH_GEN_ALGO);

            byte[] hash = messageDigest.digest(inputString.getBytes(Global.DEFAULT_ENCODING_SCHEME));

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] applyDigitalSignature(PrivateKey privateKey, String inputString) {
        Signature signature;
        byte[] outputString = new byte[0];
        try {
            signature = Signature.getInstance(Global.DEFAULT_KEY_GEN_ALGORITHM);
            signature.initSign(privateKey);
            byte[] strByte = inputString.getBytes();
            signature.update(strByte);
            byte[] realSig = signature.sign();
            outputString = realSig;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return outputString;
    }

    public static boolean verifySignature(PublicKey publicKey, String data, byte[] byte_signature) {
        try {
            Signature signature = Signature.getInstance(Global.DEFAULT_KEY_GEN_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            return signature.verify(byte_signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDificultyString(int difficultyvalue) {
        return new String(new char[difficultyvalue]).replace('\0', '0');
    }

    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

}
