package algorithm;
import java.io.UnsupportedEncodingException;
import biz.source_code.base64Coder.Base64Coder;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.InvalidKeyException;
import gnu.crypto.cipher.Twofish;

public class TwofishCipher
{
    private int keySize;
    private Object key;
    private Twofish twofish;
    
    public TwofishCipher() {
        this.keySize = 16;
        this.twofish = new Twofish();
    }
  
    public static void main(final String[] argv) throws Exception {
        final TwofishCipher twofishCipher = new TwofishCipher();
        final String key = "1234567812345678";
        final String plaintext = "I am text to be hidden away hello";
        final String originFile = "E:\\Program Files\\An to\u00e0n v\u00e0 b\u1ea3o m\u1eadt\\cipher tcp\\server\\dethi.txt";
        final String encryptFile = "E:\\Program Files\\An to\u00e0n v\u00e0 b\u1ea3o m\u1eadt\\cipher tcp\\server\\en-dethi.txt";
        final String decryptFile = "E:\\Program Files\\An to\u00e0n v\u00e0 b\u1ea3o m\u1eadt\\cipher tcp\\server\\de-dethi.txt";
        twofishCipher.createKey(key);
        final byte[] abc = twofishCipher.cryptFile(originFile, 1);
    }
    
    public int getKeySize() {
        return this.keySize;
    }
    
    public void setKeySize(final int keySize) {
        this.keySize = keySize;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public void setKey(final Object key) {
        this.key = key;
    }
    
    public void createKey(final String keyInput) throws InvalidKeyException {
        this.key = this.twofish.makeKey(keyInput.getBytes(), this.keySize);
    }
    
    public byte[] cryptFile(final String sourceFile, final int mode) throws IOException {
        final BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        final byte[] bytesFile = bis.readAllBytes();
        System.out.println(bytesFile.length);
        int length = bytesFile.length;
        if (length % this.keySize != 0) {
            while (length % this.keySize != 0) {
                ++length;
            }
        }
        final byte[] padding = new byte[length];
        for (int i = 0; i < bytesFile.length; ++i) {
            padding[i] = bytesFile[i];
        }
        final byte[] cryptByte = new byte[padding.length];
        if (mode == 1) {
            for (int i = 0; i < Array.getLength(padding); i += this.keySize) {
                this.twofish.encrypt(padding, i, cryptByte, i, this.key, this.keySize);
            }
        }
        if (mode == 2) {
            for (int i = 0; i < Array.getLength(padding); i += this.keySize) {
                this.twofish.decrypt(padding, i, cryptByte, i, this.key, this.keySize);
            }
        }
        bis.close();
        return cryptByte;
    }
    
    public String encryptText(String cookieValue) throws UnsupportedEncodingException {
        System.out.println(cookieValue.getBytes().length);
        if (cookieValue.length() % this.keySize != 0) {
            while (cookieValue.length() % this.keySize != 0) {
                cookieValue = String.valueOf(cookieValue) + " ";
            }
        }
        final byte[] plainText = cookieValue.getBytes("UTF8");
        final byte[] encryptedText = new byte[cookieValue.length()];
        for (int i = 0; i < Array.getLength(plainText); i += this.keySize) {
            this.twofish.encrypt(plainText, i, encryptedText, i, this.key, this.keySize);
        }
        final String encryptedString = Base64Coder.encodeLines(encryptedText);
        return encryptedString;
    }
    
    public String decryptText(String cookieValue) throws UnsupportedEncodingException {
        if (cookieValue.length() % this.keySize != 0) {
            while (cookieValue.length() % this.keySize != 0) {
                cookieValue = String.valueOf(cookieValue) + " ";
            }
        }
        final byte[] encryptedText = Base64Coder.decodeLines(cookieValue);
        final byte[] decryptedText = new byte[cookieValue.length()];
        for (int i = 0; i < Array.getLength(encryptedText); i += this.keySize) {
            this.twofish.decrypt(encryptedText, i, decryptedText, i, this.key, this.keySize);
        }
        final String decryptedString = new String(decryptedText);
        System.out.println(decryptedString.trim());
        return decryptedString.trim();
    }
}