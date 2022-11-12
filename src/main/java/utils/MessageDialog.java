package utils;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class MessageDialog
{
    public static void showMessagePlantextEmpty(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, "Plantext r\u1ed7ng");
    }
    
    public static void showMessageCiphertextEmpty(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, "CipherText r\u1ed7ng");
    }
    
    public static void showMessageKeyInvalid(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, "Key kh\u00f4ng h\u1ee3p l\u1ec7");
    }
    
    public static void showMessageKeyEmpty(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, "Key r\u1ed7ng");
    }
    
    public static void showMessageNotFoundFile(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng t\u00ecm th\u1ea5y file");
    }
    
    public static void showMessageCannotDecrypt(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng th\u1ec3 gi\u1ea3i m\u00e3");
    }
}