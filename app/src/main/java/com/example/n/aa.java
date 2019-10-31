package com.example.n;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import static java.util.Base64.getEncoder;


public class aa extends AppCompatActivity {

   TextView text;
String s="a";
    public void main(String[] arg)
    {
        //final String secretKey = "ssshhhhhhhhhhh!!!!";
aaa();
aaaa();
aaaaa();


    }
    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
            @SuppressLint({"NewApi", "LocalSuppress"}) String base64Key = getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println( base64Key );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

   // @TargetApi(Build.VERSION_CODES.O)
    @SuppressLint("NewApi")
    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public String aaa(){
        Intent intent = getIntent();
       // String aa="l";
        String s = intent.getStringExtra("message");
        return s;
    }
    public String aaaa(){
        Intent intent = getIntent();
        // String aa="l";
        String s = intent.getStringExtra("messag");
        return s;
    }
    public String aaaaa(){
        Intent intent = getIntent();
        // String aa="l";
        String s = intent.getStringExtra("messa");
        return s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa);

        text = (TextView)findViewById(R.id.text);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        String bb=aaa();
        String c=aaaa();
        String cc=aaaaa();
       String bbb;
       if(cc.equals("1"))
           bbb= encrypt(bb,c) ;
       else
           bbb= decrypt(bb,c) ;
        text.setText(bbb);
    }


}