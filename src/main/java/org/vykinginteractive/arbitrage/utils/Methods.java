package org.vykinginteractive.arbitrage.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.vykinginteractive.arbitrage.models.results.PasswordEncryption;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Methods {

    //general date format
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");

    //get month format
    public static SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");

    //get year format
    public static SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    //compare if the string is null or empty
    public static String checkForStringNull(String updateField, String existingField)
    {
        if (isStringEmpty(updateField))
        {
            return existingField;
        }
        return updateField;
    }

    //compare in int is null or empty
    public static int checkForIntNull(int updateField, int existingField)
    {
        if (isStringEmpty(String.valueOf(updateField)))
        {
            return existingField;
        }
        return updateField;
    }

    //compare in double is null or empty
    public static double checkForDoubleNull(double updateField, double existingField)
    {
        if (isStringEmpty(String.valueOf(updateField)))
        {
            return existingField;
        }
        return updateField;
    }

    //compare in long is null or empty
    public static long checkForLongNull(long updateField, long existingField)
    {
        if (isStringEmpty(String.valueOf(updateField)))
        {
            return existingField;
        }
        return updateField;
    }

    //compare in bool is null
    public static boolean checkForBoolNull(boolean updateField, boolean existingField)
    {
        if (isStringEmpty(String.valueOf(updateField)))
        {
            return existingField;
        }
        return updateField;
    }

    //string value validation
    private static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }

    //password encryption
    public static PasswordEncryption encryptPassword(String password) {

        //result
        PasswordEncryption res = new PasswordEncryption();

        //generate salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        res.setSalt(salt);

        //generate hash
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hash = md.digest(password.getBytes());
            res.setHash(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return res;
    }

    //verify password
    public static boolean verifyPassword(String password, byte[] storedHash, byte[] storedSalt) {

        //result
        boolean isVerified = false;

        //generate hash
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(storedSalt);
            byte[] hash = md.digest(password.getBytes());
            isVerified = Arrays.equals(storedHash, hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return isVerified;
    }

    //generate password
    public static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!#$&*";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i < length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

}
