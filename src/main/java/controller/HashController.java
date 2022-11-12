package controller;
import java.io.IOException;
import utils.MessageDialog;
import java.security.NoSuchAlgorithmException;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import algorithm.Hash;

public class HashController
{
    Hash hash;
    boolean isHashTextSha;
    boolean isHashTextMd5;
    
    public boolean isHashTextSha() {
        return this.isHashTextSha;
    }
    
    public void setHashTextSha(final boolean isHashText) {
        this.isHashTextSha = isHashText;
    }
    
    public boolean isHashTextMd5() {
        return this.isHashTextMd5;
    }
    
    public void setHashTextMd5(final boolean isHashText) {
        this.isHashTextMd5 = isHashText;
    }
    
    public String getHash() {
        return this.hash.getHash();
    }
    
    public void setHash(final String name) {
        this.hash.setHash(name);
    }
    
    public HashController() {
        this.isHashTextSha = true;
        this.isHashTextMd5 = true;
        this.hash = new Hash();
    }
    
    public void handleHashText(final String input, final JTextArea jTextArea, final JFrame jFrame) {
        try {
            final String resultString = this.hash.hashText(input);
            jTextArea.setText(resultString);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng th\u1ec3 b\u0103m !!!");
        }
    }
    
    public void handleHashFile(final String path, final JTextArea jTextArea, final JFrame jFrame) {
        try {
            final String resultString = this.hash.hashFile(path);
            jTextArea.setText(resultString);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng th\u1ec3 b\u0103m !!!");
        }
        catch (IOException e2) {
            MessageDialog.showMessageNotFoundFile(jFrame);
        }
    }
}