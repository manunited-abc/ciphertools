package controller;
import utils.MessageDialog;
import javax.swing.JTextArea;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import io.ReadFile;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import algorithm.HillCipher;
import model.Alphabet;

public class HillController
{
    Alphabet alphabet;
    HillCipher hillCipher;
    int[][] key;
    int keySize;
    static String charLast;
    
    static {
        HillController.charLast = "Z";
    }
    
    public HillController(final Alphabet alphabet) {
        this.keySize = 2;
        this.alphabet = alphabet;
        this.hillCipher = new HillCipher(alphabet);
    }
    
    public int[][] getKey() {
        return this.key;
    }
    
    public void handleCreateKey(final JTextField[][] fieldKey, final JFrame jFrame) {
        this.hillCipher.createKey(this.keySize);
        this.key = this.hillCipher.getKey();
        for (int i = 0; i < this.key.length; ++i) {
            for (int j = 0; j < this.key.length; ++j) {
                fieldKey[i][j].setText(String.valueOf(this.key[i][j]));
            }
        }
    }
    
    public void handleLoadKey(final JFrame jFrame, final JTextField[][] fieldKey) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == 0) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            try {
                final int[][] keyLoad = (int[][])ReadFile.readObject(path);
                for (int i = 0; i < fieldKey.length; ++i) {
                    for (int j = 0; j < fieldKey.length; ++j) {
                        fieldKey[i][j].setText(String.valueOf(keyLoad[i][j]));
                    }
                }
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
    
    public boolean checkKey(final JTextField[][] fieldKey, final JFrame jFrame) {
        this.key = new int[this.keySize][this.keySize];
        try {
            for (int i = 0; i < fieldKey.length; ++i) {
                for (int j = 0; j < fieldKey.length; ++j) {
                    final int intput = Integer.parseInt(String.valueOf(fieldKey[i][j].getText()));
                    this.key[i][j] = intput;
                }
            }
            this.hillCipher.setKey(this.key);
            if (!this.hillCipher.checkKey(this.key)) {
                JOptionPane.showMessageDialog(jFrame, "Ma tr\u1eadn ngh\u1ecbch \u0111\u1ea3o c\u1ee7a key kh\u00f4ng h\u1ee3p l\u1ec7, vui l\u00f2ng t\u1ea1o key l\u1ea1i");
                return false;
            }
            return true;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(jFrame, "Key kh\u00f4ng h\u1ee3p l\u1ec7 !!! \nKey ph\u1ea3i l\u00e0 ma tr\u1eadn s\u1ed1 nguy\u00ean} ");
            return false;
        }
    }
    
    public void hanldeEncrypt(final String input, final JTextField[][] fieldKey, final JTextArea areaResult, final JFrame jFrame) {
        if (!input.isEmpty()) {
            if (this.checkKey(fieldKey, jFrame)) {
                final String encrypt = this.hillCipher.encryptText(input);
                areaResult.setText(encrypt);
                HillController.charLast = this.hillCipher.getCharLast();
            }
        }
        else {
            MessageDialog.showMessagePlantextEmpty(jFrame);
        }
    }
    
    public void hanldeDecrypt(final String input, final JTextField[][] fieldKey, final JTextArea areaResult, final JFrame jFrame) {
        if (!input.isEmpty()) {
            if (this.checkKey(fieldKey, jFrame)) {
                this.hillCipher.setCharLast(HillController.charLast);
                final String decrypt = this.hillCipher.decryptText(input);
                areaResult.setText(decrypt);
            }
        }
        else {
            MessageDialog.showMessageCiphertextEmpty(jFrame);
        }
    }
    
    public void hanldeTypeKey(final JTextField[][] fieldKey, final JFrame jFrame) {
    }
}