package utils;
import java.util.Base64;
import java.util.Random;

public class StringUtils
{
    public static String removeAllSpace(final String input) {
        return input.replaceAll("\\s", "");
    }
    
    public static String toUpperAndLower(final String originInput, final String cipherText) {
        String result = "";
        for (int i = 0; i < originInput.length(); ++i) {
            if (Character.isLowerCase(originInput.charAt(i))) {
                result = String.valueOf(result) + Character.toLowerCase(cipherText.charAt(i));
            }
            else {
                result = String.valueOf(result) + Character.toUpperCase(cipherText.charAt(i));
            }
        }
        return result;
    }
    
    public static String notBelongAlphabet(final String input, final String alphabet) {
        String result = "";
        for (int i = 0; i < input.length(); ++i) {
            if (!Character.isDigit(input.charAt(i))) {
                final int index = alphabet.indexOf(String.valueOf(input.charAt(i)).toUpperCase());
                if (index >= 0) {
                    result = String.valueOf(result) + input.charAt(i);
                }
            }
            else {
                result = String.valueOf(result) + input.charAt(i);
            }
        }
        return result;
    }
    
    public static String printBytes(final byte[] bytes) {
        String resultStr = "";
        for (int i = 0; i < bytes.length / 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                resultStr = String.valueOf(resultStr) + bytes[j + i] + " ";
            }
            resultStr = String.valueOf(resultStr) + "\r\n";
        }
        return resultStr;
    }
    
    public static boolean lastChar(final String str, final String chars) {
        return str.substring(str.length() - 1, str.length()).equals(chars);
    }
    
    public static String makeRandomString(final int length, final String letters) {
        final Random rd = new Random();
        String generatedString = "";
        for (int i = 0; i < length; ++i) {
            final int rdInt = rd.nextInt(letters.length());
            generatedString = String.valueOf(generatedString) + letters.charAt(rdInt);
        }
        return generatedString;
    }
    
    public static String encodeString(final byte[] bytes) {
        final String encode = Base64.getEncoder().encodeToString(bytes);
        return encode;
    }
    
    public static String decodeString(final byte[] bytes) {
        final byte[] decode = Base64.getDecoder().decode(bytes);
        return new String(decode);
    }
}