package algorithm;
import java.util.Random;
import model.Alphabet;

public class VigenereCipher
{
    String alphabet;
    String key;
    
    public VigenereCipher(final Alphabet alphabet) {
        this.alphabet = alphabet.getAlphabet();
    }
    
    public String getAlphabet() {
        return this.alphabet;
    }
    
    public void setAlphabet(final String alphabet) {
        this.alphabet = alphabet;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public void setKey(final String key) {
        this.key = key;
    }
    
    public void createKey(final int length) {
        this.key = "";
        for (int i = 0; i < length; ++i) {
            final Random random = new Random();
            this.key = String.valueOf(this.key) + this.alphabet.charAt(random.nextInt(this.alphabet.length()));
        }
    }
    
    public String paddingKey(final String input, String key) {
        final int x = input.length();
        if (x > key.length()) {
            int i = 0;
            while (true) {
                if (x == i) {
                    i = 0;
                }
                if (key.length() == input.length()) {
                    break;
                }
                key = String.valueOf(key) + key.charAt(i);
                ++i;
            }
        }
        else {
            key.substring(0, input.length() - 1);
        }
        return key;
    }
    
    public String encryptText(final String input) {
        final int size = this.alphabet.length();
        final String keyPadding = this.paddingKey(input, this.key);
        String result = "";
        for (int i = 0; i < input.length(); ++i) {
            final int index = this.alphabet.indexOf(String.valueOf(input.charAt(i)).toUpperCase());
            final int indexKey = Character.isDigit(keyPadding.charAt(i)) ? Character.getNumericValue(keyPadding.charAt(i)) : this.alphabet.indexOf(String.valueOf(keyPadding.charAt(i)).toUpperCase());
            if (index >= 0) {
                final int cipher = index + indexKey;
                result = String.valueOf(result) + ((cipher >= 0) ? this.alphabet.charAt(cipher % size) : this.alphabet.charAt((size + cipher) % size));
            }
            else {
                result = String.valueOf(result) + input.charAt(i);
            }
        }
        return result;
    }
    
    public String decryptText(final String input) {
        final int size = this.alphabet.length();
        final String keyPadding = this.paddingKey(input, this.key);
        String result = "";
        for (int i = 0; i < input.length(); ++i) {
            final int index = this.alphabet.indexOf(String.valueOf(input.charAt(i)).toUpperCase());
            final int indexKey = Character.isDigit(keyPadding.charAt(i)) ? Character.getNumericValue(keyPadding.charAt(i)) : this.alphabet.indexOf(String.valueOf(keyPadding.charAt(i)).toUpperCase());
            if (index >= 0) {
                final int cipher = index - indexKey;
                result = String.valueOf(result) + ((cipher >= 0) ? this.alphabet.charAt(cipher % size) : this.alphabet.charAt((size + cipher) % size));
            }
            else {
                result = String.valueOf(result) + input.charAt(i);
            }
        }
        return result;
    }
}