package model;
import java.util.ArrayList;
import java.util.List;

public class Alphabet
{
    public static final String ALPHABET_VN = "A\u0102\u00c2BCD\u0110E\u00caGHIKLMNO\u00d4\u01a0PQRSTU\u01afVXY";
    public static final String ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ALPHABET_VN_NUM = "A\u0102\u00c2BCD\u0110E\u00caGHIKLMNO\u00d4\u01a0PQRSTU\u01afVXY0123456789";
    public static final String ALPHABET_EN_NUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final String ALPHABET_ALL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789@#^%*()|/\\][{}-=+.<>;:'\",";
    List<String> list;
    public String alphabet;
    
    public Alphabet() {
        this.list = new ArrayList<String>();
        this.alphabet = "";
        this.list.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        this.list.add("A\u0102\u00c2BCD\u0110E\u00caGHIKLMNO\u00d4\u01a0PQRSTU\u01afVXY");
        this.list.add("A\u0102\u00c2BCD\u0110E\u00caGHIKLMNO\u00d4\u01a0PQRSTU\u01afVXY0123456789");
        this.list.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        this.alphabet = this.list.get(0);
    }
    
    public List<String> listAlphabetDefault() {
        return this.list;
    }
    
    public String getAlphabet() {
        return this.alphabet;
    }
    
    public void setAlphabet(final String alphabet) {
        this.alphabet = alphabet;
    }
    
    public void addAlphabet(final String alphabet) {
        this.list.add(alphabet);
    }
}