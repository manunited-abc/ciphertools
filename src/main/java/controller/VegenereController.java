package controller;
import java.io.File;
import java.io.IOException;
import io.ReadFile;
import javax.swing.JFileChooser;
import utils.MessageDialog;
import utils.StringUtils;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.Alphabet;
import algorithm.VigenereCipher;

public class VegenereController
{
    VigenereCipher vegenereCipher;
    Alphabet alphabet;
    int maxSizeKey;
    int minSizeKey;
    
    public VegenereController(final Alphabet alphabet) {
        this.maxSizeKey = 100;
        this.minSizeKey = 0;
        this.alphabet = alphabet;
        this.vegenereCipher = new VigenereCipher(alphabet);
    }
    
    public void handleCreateKey(final JTextField fieldKey, final JTextField fieldKeySize, final JFrame jFrame) {
        try {
            final int keySize = Integer.parseInt(fieldKeySize.getText());
            if (keySize < this.maxSizeKey && keySize > this.minSizeKey) {
                this.vegenereCipher.createKey(keySize);
                fieldKey.setText(this.vegenereCipher.getKey());
            }
            else {
                JOptionPane.showMessageDialog(jFrame, "Chi\u1ec1u d\u00e0i key ph\u1ea3i l\u1edbn " + this.minSizeKey + " v\u00e0 nh\u1ecf " + this.maxSizeKey);
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(jFrame, "Chi\u1ec1u d\u00e0i key kh\u00f4ng h\u1ee3p l\u1ec7");
        }
    }
    
    public void handleEncrypt(final String input, final JTextField fieldKey, final JTextArea areaResult, final JFrame jFrame) {
        final String key = fieldKey.getText();
        this.vegenereCipher.setKey(key);
        if (!input.isEmpty()) {
            if (!key.isEmpty()) {
                final String keyNew = StringUtils.notBelongAlphabet(key, this.alphabet.getAlphabet());
                final String inputNew = input.replaceAll("\r\n", "\u2665");
                final String encrypt = this.vegenereCipher.encryptText(inputNew);
                final String encryptFormat = encrypt.replaceAll("\u2665", "\r\n");
                fieldKey.setText(keyNew);
                areaResult.setText(encryptFormat);
            }
            else {
                MessageDialog.showMessageKeyInvalid(jFrame);
            }
        }
        else {
            MessageDialog.showMessagePlantextEmpty(jFrame);
        }
    }
    
    public void handleLoadKey(final JFrame jFrame, final JTextField fieldKey) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == 0) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            try {
                final String keyReaded = (String)ReadFile.readObject(path);
                if (keyReaded.length() < this.maxSizeKey) {
                    fieldKey.setText(keyReaded);
                    JOptionPane.showMessageDialog(jFrame, "T\u1ea3i th\u00e0nh c\u00f4ng");
                }
                else {
                    JOptionPane.showMessageDialog(jFrame, "Chi\u1ec1u d\u00e0i key ph\u1ea3i l\u1edbn " + this.minSizeKey + " v\u00e0 nh\u1ecf " + this.maxSizeKey);
                }
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(jFrame, "T\u00ean file kh\u00f4ng h\u1ee3p l\u1ec7");
            }
            catch (ClassNotFoundException e2) {
                JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng t\u00ecm th\u1ea7y file");
            }
            catch (ClassCastException e3) {
                JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
            }
        }
    }
    
    public void handleDecrypt(final String input, final JTextField fieldKey, final JTextArea areaResult, final JFrame jFrame) {
        final String key = fieldKey.getText();
        this.vegenereCipher.setKey(key);
        if (!input.isEmpty()) {
            if (!key.isEmpty()) {
                final String inputNew = input.replaceAll("\r\n", "\u2665");
                final String dencypt = this.vegenereCipher.decryptText(inputNew);
                final String decryptFormat = dencypt.replaceAll("\u2665", "\r\n");
                areaResult.setText(decryptFormat);
            }
            else {
                MessageDialog.showMessageKeyInvalid(jFrame);
            }
        }
        else {
            MessageDialog.showMessageCiphertextEmpty(jFrame);
        }
    }
}