package org.example.com.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Utility {

    public static String generateRandomEmail(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString + "@gmail.com";
    }

    public static String generateRandomJordanianNumber() {

        int length = 7;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return "79" + generatedString;
    }
}
