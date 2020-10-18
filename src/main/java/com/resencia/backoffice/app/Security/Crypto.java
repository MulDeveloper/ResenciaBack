/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resencia.backoffice.app.Security;


import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.springframework.stereotype.Component;

@Component
public class Crypto {
    
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static final int iterationCount = 10;
    byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35,
      (byte) 0xE3, (byte) 0x03 };
    
    public Crypto(){
        try {
            String passPhrase = "####";
 
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
 
            // create a secret (symmetric) key using PBE with MD5 and DES 
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
 
            // construct a parameter set for password-based encryption as defined in the PKCS #5 standard
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
 
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
 
            
            
  
            // initialize the ciphers with the given key
 
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String encrypt(String pass){
        try {
            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array. 

            byte[] utf8 = pass.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);
            // encode to base64

            enc = BASE64EncoderStream.encode(enc);
            return new String(enc);

          }
          catch (Exception e) {
            e.printStackTrace();
          }
          return null;
 
    }
    
    public String decrypt(String pass){
        try {
             // decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(pass.getBytes());

            byte[] utf8 = dcipher.doFinal(dec);

            // create new string based on the specified charset
            return new String(utf8, "UTF8");
          }
          catch (Exception e) {
            e.printStackTrace();
          }
          return null;

    }

    

}
