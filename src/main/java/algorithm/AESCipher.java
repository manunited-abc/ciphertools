package algorithm;
import java.io.BufferedInputStream;
import java.io.File;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

public class AESCipher
{
    String algorithnm;
    Cipher cipher;
    SecretKey key;
    int[] keySizes;
    int keySize;
    private static AESCipher instance;
    
    public AESCipher() {
        this.algorithnm = "AES";
        this.keySizes = new int[] { 256, 192, 128 };
        this.keySize = this.keySizes[0];
    }
    
    public static AESCipher getInstance() {
        if (AESCipher.instance == null) {
            AESCipher.instance = new AESCipher();
        }
        return AESCipher.instance;
    }
    
    public String getAlgorithnm() {
        return this.algorithnm;
    }
    
    public SecretKey getKey() {
        return this.key;
    }
    
    public int[] getKeySizes() {
        return this.keySizes;
    }
    
    public int getKeySize() {
        return this.keySize;
    }
    
    public void setKeySize(final int keySize) {
        this.keySize = keySize;
    }
    
    public void setKey(final SecretKey secretKey) {
        this.key = secretKey;
    }
    
    public SecretKey typingKey(final String keyString) {
        final byte[] keyByte = Base64.getDecoder().decode(keyString);
        final SecretKey secretKey = new SecretKeySpec(keyByte, this.algorithnm);
        return secretKey;
    }
    
    public SecretKey createKey() throws NoSuchAlgorithmException {
        SecretKey key = null;
        final KeyGenerator keyGenerator = KeyGenerator.getInstance(this.algorithnm);
        keyGenerator.init(this.keySize);
        key = keyGenerator.generateKey();
        return key;
    }
    
    public SecretKey readKey(final String path) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            this.key = (SecretKey)ois.readObject();
            ois.close();
            return this.key;
        }
        catch (IOException e) {
            System.out.println("Key cannot read from file");
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e2) {
            System.out.println("Key not found");
            throw new RuntimeException(e2);
        }
    }
    
    public String encryptText(final String input) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        (this.cipher = Cipher.getInstance(this.algorithnm)).init(1, this.key);
        final byte[] byteEncrypted = this.cipher.doFinal(input.getBytes());
        final String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);
        return encrypted;
    }
    
    public String decryptText(final String input) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        (this.cipher = Cipher.getInstance(this.algorithnm)).init(2, this.key);
        final byte[] byteEncrypted = Base64.getDecoder().decode(input);
        final byte[] byteDecrypted = this.cipher.doFinal(byteEncrypted);
        final String decrypted = new String(byteDecrypted);
        return decrypted;
    }
    
    public byte[] cryptoFile(final String sourceFile, final int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        final File file = new File(sourceFile);
        if (file.isFile()) {
            (this.cipher = Cipher.getInstance(this.algorithnm)).init(mode, this.key);
            final BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            final byte[] inputBytes = new byte[(int)file.length()];
            bis.read(inputBytes);
            final byte[] outputBytes = this.cipher.doFinal(inputBytes);
            bis.close();
            return outputBytes;
        }
        return null;
    }
}