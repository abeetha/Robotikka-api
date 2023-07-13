package com.bootcamp.robotikka.robotikkaapi.util;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {
    private static String ALPH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
    private static String NUMERIC = "0123456789";

    public String generatePrefix(int min,int max){
        int generatedRand = generateRand(min,max);
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<generatedRand; i++){
            builder.append(ALPH.charAt(new Random().nextInt(ALPH.length()-1)));
        }
        return builder.toString();
    }
    public String generatePrimaryKey(String pointer,String prefix){
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        builder.append("-"+pointer+"-");
        for(int i=0; i< 5; i++){
            builder.append(NUMERIC.charAt(new Random().nextInt(NUMERIC.length()-1)));
        }
        return builder.toString();
    }

    public String generateKey(String pointer){
        StringBuilder builder = new StringBuilder();
        builder.append(pointer+"-");
        for(int i=0; i< 5; i++){
            builder.append(NUMERIC.charAt(new Random().nextInt(NUMERIC.length()-1)));
        }
        return builder.toString();
    }


    private int generateRand(int min,int max){
        return new Random().nextInt((max-min)+min)+min;
    }

    public String createVerificationCode() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(NUMERIC.charAt(new Random().nextInt(NUMERIC.length() - 1)));
        }
        return builder.toString();
    }
}
