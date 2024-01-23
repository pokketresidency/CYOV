package com.cyov.marketplace.utils;


import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Utils {

    public static String removeSpecialCharacters(String input) {
        // Define the regular expression pattern to match special characters
        String regex = "[^a-zA-Z0-9\\s]";

        // Remove special characters by replacing them with an empty string
        return input.replaceAll(regex, "");
    }

    public static boolean isValid(String input, ValidationType type) {
        switch (type) {
            case EMAIL:
                // Regular expression pattern for a basic email validation
                String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
                Pattern emailPattern = Pattern.compile(emailRegex);
                Matcher emailMatcher = emailPattern.matcher(input);
                return emailMatcher.matches();

            case EPOCH_TIME:
                String epochTimeRegex = "\\$D_-?\\d+";
                Pattern epochTimePattern = Pattern.compile(epochTimeRegex);
                Matcher epochTimeMatcher = epochTimePattern.matcher(input);
                return epochTimeMatcher.matches();

            case PHONE_NUMBER:
                // Regular expression for +91 followed by 10 digits
                String phoneNumberRegex = "^\\+91\\d{10}$";
                return input.matches(phoneNumberRegex);

            case NUMBER:
                // Regular expression pattern for a valid integer
                String integerRegex = "^[+-]?\\d+$";
                return input.matches(integerRegex);

            case PERCENTAGE:
                // Regular expression pattern for a valid percentage (0-100)
                String percentageRegex = "^\\d{1,3}(\\.\\d{1,2})?%?$";
                return input.matches(percentageRegex);

            case URL:
                // Regular expression pattern for a valid URL
                String urlRegex = "^(http|https|ftp)://[^\\s/$.?#].[^\\s]*$";
                return input.matches(urlRegex);

            case BOOLEAN:
                // Check if the input is a valid boolean value
                return input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false");


            default:
                return false; // Invalid validation type
        }
    }

    public enum ValidationType {
        EMAIL,
        EPOCH_TIME,
        PHONE_NUMBER,
        NUMBER,
        PERCENTAGE,
        URL,
        BOOLEAN
    }


    public static String getLastWord(String sentence) {

        if (sentence == null || sentence.isEmpty()) {
            return null;
        }

        String[] words = sentence.split(" ");

        if (words.length > 0) {
            return words[words.length - 1];
        } else {
            return null;
        }
    }


    public static boolean hasValue(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof String) {
            return !((String) obj).isEmpty();
        }

        if (obj instanceof Collection) {
            return !((Collection<?>) obj).isEmpty();
        }

        if (obj instanceof Map) {
            return !((Map<?, ?>) obj).isEmpty();
        }


        return true;
    }


    public static boolean hasRecords(List<Object> obj) {
        if (obj == null || obj.isEmpty()) {
            return false;
        }

        for (Object item : obj) {
            if (item != null) {
                return true;
            }
        }

        return false;
    }

}


