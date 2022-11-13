package controller;
import org.apache.commons.io.FilenameUtils;
import java.security.GeneralSecurityException;
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
import algorithm.DESCiphers;

public class DESController
{
    DESCiphers desCipher;
    SecretKey key;
    boolean isCipherText;
    byte[] inputBytes;
    String extention;
    boolean isChooseTypeKey;
    String algorithnm;
    
    public DESController() {
        this.isCipherText = true;
        this.isChooseTypeKey = false;
        this.algorithnm = "DES";
        this.desCipher = DESCiphers.getInstance();
    }
    
    public SecretKey getKey() {
        return this.key;
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
    
    public void checkKey(final JTextField fieldKey, final JFrame jFrame) {
        final String keyInput = fieldKey.getText();
        if (this.isChooseTypeKey) {
            if (StringUtils.lastChar(keyInput, "=")) {
                final byte[] keyByte = Base64.getDecoder().decode(keyInput);
                this.key = new SecretKeySpec(keyByte, this.algorithnm);
                this.desCipher.setKey(this.key);
            }
            else {
                this.key = new SecretKeySpec(keyInput.getBytes(), this.algorithnm);
                this.desCipher.setKey(this.key);
            }
        }
    }
    
    public void hanldeLoadKey(final JTextField fieldKey, final JFrame jFrame) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            try {
                this.key = (SecretKey)ReadFile.readObject(path);
                this.desCipher.setKey(this.key);
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
    
    public void handleCreateKey(final JTextField fieldKey, final JFrame jFrame) {
        try {
            this.isChooseTypeKey = false;
            this.desCipher.createKey();
            this.key = this.desCipher.getKey();
            this.desCipher.setKey(this.key);
            final String keyString = Base64.getEncoder().encodeToString(this.key.getEncoded());
            final byte[] keyByte = Base64.getDecoder().decode(keyString);
            fieldKey.setText(new String(keyString));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    public void hanldeEncryptText(final JTextField fieldKey, final String input, final JTextArea areaResult, final JFrame jFrame) {
        try {
            this.checkKey(fieldKey, jFrame);
            final String result = this.desCipher.encryptText(input);
            areaResult.setText(result);
        }
        catch (IllegalBlockSizeException | NoSuchAlgorithmException | NoSuchPaddingException e) {

            e.printStackTrace();
        }
        catch (InvalidKeyException | IllegalArgumentException | BadPaddingException ex4) {
            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeEncryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult, final JFrame jFrame) {
        try {
            this.checkKey(fieldKey, jFrame);
            final byte[] encryptBytes = this.desCipher.cryptoFile(sourceFile, Cipher.ENCRYPT_MODE);
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
    
    public void hanldeDecryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult, final JFrame jFrame) {
        try {
            this.checkKey(fieldKey, jFrame);
            final byte[] decryptBytes = this.desCipher.cryptoFile(sourceFile, Cipher.DECRYPT_MODE);
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
        catch (NoSuchAlgorithmException | NoSuchPaddingException | IOException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException | IllegalBlockSizeException ex5) {
            MessageDialog.showMessageCannotDecrypt(jFrame);
        }
        catch (InvalidKeyException | BadPaddingException ex6) {

            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeDecryptText(final JTextField fieldKey, final String input, final JTextArea areaResult, final JFrame jFrame) {
        try {
            this.checkKey(fieldKey, jFrame);
            final String result = this.desCipher.decryptText(input);
            areaResult.setText(result);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException e) {

            e.printStackTrace();
        }
        catch (IllegalArgumentException | IllegalBlockSizeException ex5) {

            MessageDialog.showMessageCannotDecrypt(jFrame);
        }
        catch (InvalidKeyException | BadPaddingException ex6) {

            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
}