package controller;
import org.apache.commons.io.FilenameUtils;
import utils.MessageDialog;
import java.io.UnsupportedEncodingException;
import javax.swing.JTextArea;
import utils.StringUtils;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import io.ReadFile;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.security.InvalidKeyException;
import javax.swing.JTextField;
import algorithm.TwofishCipher;

public class TwofishController
{
    TwofishCipher twofishCipher;
    String keyStr;
    boolean isCipherText;
    byte[] inputBytes;
    String extention;
    boolean isChooseTypeKey;
    String algorithnm;
    boolean isKeySize;
    
    public TwofishController() {
        this.isCipherText = true;
        this.isChooseTypeKey = false;
        this.algorithnm = "Twofish";
        this.isKeySize = true;
        this.twofishCipher = new TwofishCipher();
    }
    
    public int getKeySize() {
        return this.twofishCipher.getKeySize();
    }
    
    public String getKeyStr() {
        return this.keyStr;
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
    
    public boolean checkKey(final JTextField fieldKey) {
        final String keyInput = fieldKey.getText();
        if (this.isChooseTypeKey) {
            try {
                this.twofishCipher.createKey(keyInput);
                return true;
            }
            catch (InvalidKeyException e) {
                return false;
            }
        }
        return this.twofishCipher.getKey() != null;
    }
    
    public void hanldeLoadKey(final JTextField fieldKey, final JFrame jFrame) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == 0) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            try {
                final String key = (String)ReadFile.readObject(path);
                this.isChooseTypeKey = false;
                fieldKey.setText(key);
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
            final String keyRamdom = StringUtils.makeRandomString(16, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789@#^%*()|/\\][{}-=+.<>;:'\",");
            this.twofishCipher.createKey(keyRamdom);
            fieldKey.setText(this.keyStr = keyRamdom);
            System.out.println("1.LB " + fieldKey.getText());
            System.out.println("2 Sys " + fieldKey.getText());
        }
        catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    
    public void hanldeEncryptText(final JTextField fieldKey, final String input, final JTextArea areaResult, final JFrame jFrame) {
        if (this.checkKey(fieldKey)) {
            try {
                final String encrypt = this.twofishCipher.encryptText(input);
                areaResult.setText(encrypt);
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        else {
            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeEncryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult, final JFrame jFrame) {
        if (this.checkKey(fieldKey)) {
            try {
                final byte[] encrypt = this.twofishCipher.cryptFile(sourceFile, 1);
                areaResult.setText(StringUtils.encodeString(encrypt));
                final File file = new File(sourceFile);
                this.extention = FilenameUtils.getExtension(file.getName());
                this.inputBytes = encrypt;
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            catch (IOException e2) {
                MessageDialog.showMessageNotFoundFile(jFrame);
            }
        }
        else {
            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeDecryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult, final JFrame jFrame) {
        if (this.checkKey(fieldKey)) {
            try {
                final byte[] decrypt = this.twofishCipher.cryptFile(sourceFile, 2);
                areaResult.setText(StringUtils.encodeString(decrypt));
                final File file = new File(sourceFile);
                this.extention = FilenameUtils.getExtension(file.getName());
                this.inputBytes = decrypt;
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            catch (IOException e3) {
                MessageDialog.showMessageNotFoundFile(jFrame);
            }
            catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                MessageDialog.showMessageCannotDecrypt(jFrame);
            }
        }
        else {
            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
    
    public void hanldeDecryptText(final JTextField fieldKey, final String input, final JTextArea areaResult, final JFrame jFrame) {
        if (this.checkKey(fieldKey)) {
            try {
                final String encrypt = this.twofishCipher.decryptText(input);
                areaResult.setText(encrypt);
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            catch (IllegalArgumentException ex) {}
        }
        else {
            MessageDialog.showMessageKeyInvalid(jFrame);
        }
    }
}
