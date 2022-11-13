package controller;
import java.security.GeneralSecurityException;
import org.apache.commons.io.FilenameUtils;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

import java.security.InvalidKeyException;
import utils.MessageDialog;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.swing.JTextArea;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import io.ReadFile;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import utils.StringUtils;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.crypto.SecretKey;
import algorithm.AESCipher;

public class AESController
{
    AESCipher aesCipher;
    SecretKey key;
    boolean isCipherText;
    byte[] inputBytes;
    String extention;
    boolean isChooseTypeKey;
    String algorithnm;
    
    public AESController() {
        this.isCipherText = true;
        this.isChooseTypeKey = false;
        this.algorithnm = "AES";
        this.aesCipher = new AESCipher();
    }
    
    public SecretKey getKey() {
        return this.key;
    }
    
    public void setKeySize(final int keySize) {
        this.aesCipher.setKeySize(keySize);
    }
    
    public boolean isChooseTypeKey() {
        return this.isChooseTypeKey;
    }
    
    public void setChooseTypeKey(final boolean isChooseTypeKey) {
        this.isChooseTypeKey = isChooseTypeKey;
    }
    
    public boolean isCipherText() {
        return this.isCipherText;
    }
    
    public void setIsCipherText(final boolean value) {
        this.isCipherText = value;
    }
    
    public byte[] getInputBytes() {
        return this.inputBytes;
    }
    
    public void setInputBytes(final byte[] bytes) {
        this.inputBytes = bytes;
    }
    
    public String getExtention() {
        return this.extention;
    }
    
    public int[] getKeySizes() {
        return this.aesCipher.getKeySizes();
    }
    
    public String[] keySizeStr() {
        final String[] str = new String[this.aesCipher.getKeySizes().length];
        for (int i = 0; i < str.length; ++i) {
            str[i] = String.valueOf(this.aesCipher.getKeySizes()[i]);
        }
        return str;
    }
    
    public void checkKey(final JTextField fieldKey, final JFrame jFrame, final int keySize) {
        final String keyInput = fieldKey.getText();
        this.aesCipher.setKeySize(keySize);
        if (this.isChooseTypeKey) {
            if (StringUtils.lastChar(keyInput, "=")) {
                final byte[] keyByte = Base64.getDecoder().decode(keyInput);
                this.key = new SecretKeySpec(keyByte, this.algorithnm);
                this.aesCipher.setKey(this.key);
            }
            else {
                this.key = new SecretKeySpec(keyInput.getBytes(), this.algorithnm);
                this.aesCipher.setKey(this.key);
            }
        }
    }
    
    public void hanldeLoadKey(final JTextField fieldKey, final JFrame jFrame) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == 0) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            try {
                this.key = (SecretKey)ReadFile.readObject(path);
                this.aesCipher.setKey(this.key);
                this.isChooseTypeKey = false;
                final String keyString = Base64.getEncoder().encodeToString(this.key.getEncoded());
                final byte[] keyByte = Base64.getDecoder().decode(keyString);
                fieldKey.setText(new String(keyByte));
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
            }
            catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng t\u00ecm th\u1ea7y file");
            }
            catch (ClassCastException e3) {
                JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
            }
        }
    }
    
    public void handleCreateKey(final JTextField fieldKey, final JFrame jFrame, final int keySize) {
        try {
            this.isChooseTypeKey = false;
            this.aesCipher.setKeySize(keySize);
            this.key = this.aesCipher.createKey();
            final String keyString = Base64.getEncoder().encodeToString(this.key.getEncoded());
            final byte[] keyByte = Base64.getDecoder().decode(keyString);
            fieldKey.setText(new String(keyString));
            this.aesCipher.setKey(this.key);
            System.out.println("1.LB " + fieldKey.getText());
            System.out.println("2 Sys " + fieldKey.getText());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public void hanldeEncryptText(final JTextField fieldKey, final String input, final JTextArea areaResult, final JFrame jFrame, final int keySize) {
        try {
            this.checkKey(fieldKey, jFrame, keySize);
            final String result = this.aesCipher.encryptText(input);
            areaResult.setText(result);
        }
        catch (IllegalBlockSizeException | NoSuchAlgorithmException | NoSuchPaddingException ex2) {}
        catch (InvalidKeyException | IllegalArgumentException | BadPaddingException ex3) {
            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeEncryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult, final JFrame jFrame, final int keySize) {
        try {
            this.checkKey(fieldKey, jFrame, keySize);
            final byte[] encryptBytes = this.aesCipher.cryptoFile(sourceFile, Cipher.ENCRYPT_MODE);
            final File file = new File(sourceFile);
            this.extention = FilenameUtils.getExtension(file.getName());
            this.inputBytes = encryptBytes;
            if (encryptBytes != null) {
                areaResult.setText(StringUtils.encodeString(encryptBytes));
            }
            else {
                MessageDialog.showMessageNotFoundFile(jFrame);
            }
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | IOException ex2) {}
        catch (InvalidKeyException | IllegalArgumentException | BadPaddingException ex3) {

            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeDecryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult, final JFrame jFrame, final int keySize) {
        try {
            this.checkKey(fieldKey, jFrame, keySize);
            final byte[] decryptBytes = this.aesCipher.cryptoFile(sourceFile, Cipher.DECRYPT_MODE);
            final File file = new File(sourceFile);
            this.extention = FilenameUtils.getExtension(file.getName());
            this.inputBytes = decryptBytes;
            if (decryptBytes != null) {
            	areaResult.setText(StringUtils.encodeString(decryptBytes));
            }
            else {
                MessageDialog.showMessageNotFoundFile(jFrame);
            }
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | IOException ex3) {}
        catch (IllegalArgumentException | IllegalBlockSizeException ex4) {

            MessageDialog.showMessageCannotDecrypt(jFrame);
        }
        catch (InvalidKeyException | BadPaddingException ex5) {

            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeDecryptText(final JTextField fieldKey, final String input, final JTextArea areaResult, final JFrame jFrame, final int keySize) {
        try {
            this.checkKey(fieldKey, jFrame, keySize);
            final String result = this.aesCipher.decryptText(input);
            areaResult.setText(result);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException ex3) {}
        catch (IllegalArgumentException | IllegalBlockSizeException ex4) {

            MessageDialog.showMessageCannotDecrypt(jFrame);
        }
        catch (InvalidKeyException | BadPaddingException ex5) {

            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
}