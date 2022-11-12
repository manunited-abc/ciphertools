package algorithm;
import io.ReadFile;
import java.util.Base64;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.CipherInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import javax.crypto.NoSuchPaddingException;
import utils.StringUtils;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.security.PrivateKey;

public class RSACipher
{
    int[] keySizes;
    int keySize;
    PrivateKey privateKey;
    PublicKey publicKey;
    SecretKey secretKey;
    String symmetryAlgorithm;
    Cipher cipher;
    
    public RSACipher() {
        this.keySizes = new int[] { 2048, 1024 };
        this.keySize = this.keySizes[0];
        this.symmetryAlgorithm = "DES";
    }
    
    public void createSymmetryKey() throws NoSuchAlgorithmException {
        switch (symmetryAlgorithm) {
            case "Blowfish": {
                this.secretKey = BlowfishCipher.getInstance().createKey();
                break;
            }
            case "AES": {
                this.secretKey = AESCipher.getInstance().createKey();
                break;
            }
            case "DES": {
                this.secretKey = DESCiphers.getInstance().createKey();
                break;
            }
            default:
                break;
        }
    }
    
    public void setSymmetryAlgorithm(final String symmetryAlgorithm) {
        this.symmetryAlgorithm = symmetryAlgorithm;
    }
    
    public String getSymmetryAlgorithm() {
        return this.symmetryAlgorithm;
    }
    
    public void setSecretKey(final SecretKey secretKey) {
        this.secretKey = secretKey;
    }
    
    public SecretKey getSecretKey() {
        return this.secretKey;
    }
    
    public PrivateKey getPrivateKey() {
        return this.privateKey;
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
    
    public void setPrivateKey(final PrivateKey privateKey) {
        this.privateKey = privateKey;
    }
    
    public PublicKey getPublicKey() {
        return this.publicKey;
    }
    
    public void setPublicKey(final PublicKey publicKey) {
        this.publicKey = publicKey;
    }
    
    public void createKey() throws NoSuchAlgorithmException {
        final KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(this.keySize);
        final KeyPair keyPair = generator.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }
    
    public String encryptText(final String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        final byte[] data = input.getBytes();
        (this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(1, this.publicKey);
        final byte[] bytes = this.cipher.doFinal(data);
        return StringUtils.encodeString(bytes);
    }
    
    public void encryptFile(final String sourceFile, final String desFile) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        final DataOutputStream dos = new DataOutputStream(new FileOutputStream(desFile));
        (this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(1, this.publicKey);
        final byte[] byteAlgorithmEncrypt = this.cipher.doFinal(this.symmetryAlgorithm.getBytes());
        dos.writeInt(byteAlgorithmEncrypt.length);
        this.writeByte(dos, byteAlgorithmEncrypt);
        final byte[] byteKeyEncrypt = this.cipher.doFinal(this.secretKey.getEncoded());
        dos.writeInt(byteKeyEncrypt.length);
        this.writeByte(dos, byteKeyEncrypt);
        (this.cipher = Cipher.getInstance(this.symmetryAlgorithm)).init(1, this.secretKey);
        final CipherInputStream cis = new CipherInputStream(new FileInputStream(sourceFile), this.cipher);
        final byte[] data = new byte[1024];
        int byteread;
        while ((byteread = cis.read(data)) != -1) {
            dos.write(data, 0, byteread);
        }
        dos.close();
        cis.close();
    }
    
    public void decryptFile(final String sourceFile, final String desFile) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        (this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(2, this.privateKey);
        final DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
        final int lengthAlgorithm = dis.readInt();
        final byte[] byteAlgorithmEncrypt = this.readByte(dis, lengthAlgorithm);
        final byte[] byteAlgorithmDecrypt = this.cipher.doFinal(byteAlgorithmEncrypt);
        final String algorithm = new String(byteAlgorithmDecrypt);
        final int lengthKey = dis.readInt();
        final byte[] byteKeyEncrypt = this.readByte(dis, lengthKey);
        final byte[] byteKeyDecrypt = this.cipher.doFinal(byteKeyEncrypt);
        final SecretKey secretKey = new SecretKeySpec(byteKeyDecrypt, algorithm);
        (this.cipher = Cipher.getInstance(algorithm)).init(2, secretKey);
        final CipherOutputStream cis = new CipherOutputStream(new FileOutputStream(desFile), this.cipher);
        final byte[] data = new byte[1024];
        int byteread;
        while ((byteread = dis.read(data)) != -1) {
            cis.write(data, 0, byteread);
        }
        dis.close();
        cis.close();
    }
    
    public String decryptText(final String input) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        (this.cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")).init(2, this.privateKey);
        final byte[] decodeByte = Base64.getDecoder().decode(input);
        final byte[] bytes = this.cipher.doFinal(decodeByte);
        return new String(bytes);
    }
    
    public void writeByte(final DataOutputStream out, final byte[] bytes) throws IOException {
        for (final byte b : bytes) {
            out.writeByte(b);
        }
    }
    
    public byte[] readByte(final DataInputStream dis, final int length) throws IOException {
        final byte[] bytes = new byte[length];
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = dis.readByte();
        }
        return bytes;
    }
    
    public static void main(final String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {
        final RSACipher rsaCipher = new RSACipher();
        final DESCiphers desCiphers = DESCiphers.getInstance();
        final PrivateKey privateKey = (PrivateKey)ReadFile.readObject("E:\\Program Files\\An to\u00e0n v\u00e0 b\u1ea3o m\u1eadt\\cipher tcp\\server\\private.txt");
        rsaCipher.setPrivateKey(privateKey);
        final String sourceString = "E:\\Program Files\\An to\u00e0n v\u00e0 b\u1ea3o m\u1eadt\\cipher tcp\\server\\en-dethi.txt";
        final String desString = "E:\\Program Files\\An to\u00e0n v\u00e0 b\u1ea3o m\u1eadt\\cipher tcp\\server\\de-dethi.txt";
        rsaCipher.decryptFile(sourceString, desString);
        System.out.println("OK");
    }
}