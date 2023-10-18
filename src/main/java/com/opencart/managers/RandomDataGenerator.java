package com.opencart.managers;

import com.github.javafaker.Faker;

public class RandomDataGenerator {
    private static Faker fakerObject = new Faker();

    public static String generateRandomEmail(String prefix, String sufix){
        String randomMiPart= String.valueOf(fakerObject.random().nextInt(1, 999999999));
        //fakerObject.internet().emailAddress();
        return prefix + randomMiPart + sufix;
    }
    public static String generateRandomEmail(){
        return fakerObject.internet().emailAddress();
    }
    public static String generateFirstName(){
        return fakerObject.name().firstName();
    }
    public static String generateLastName(){
        return fakerObject.name().lastName();
    }
    public static String generatePassword(){
        return fakerObject.internet().password();
    }
}
