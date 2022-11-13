package utils;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class MessageDialog
{
	public static String messageVigen = "Key có chiều dài từ 1 - 100 ký tự nằm trong bảng mã \n'ABCDEFGHIJKLMNOPQRSTUVWXYZ'";
	public static String messageHill = "Tạo key nhiều lần để có key thoã mãn điều kiện \n trong thuật toán Hill";
	public static String messageDes = "Key có chiều dài 8 ký tự \nCó thể nhập key ở dạng String(8 ký tự) và Base64";
	public static String messageAes = "Key có chiều dài 16/24/32 ký tự  \nCó thể nhập key ở dạng String(16/24/32 ký tự) hoặc Base64";
	public static String messageTowfish = "Key có chiều dài 16 ký tự  \nCó thể nhập key ở dạng String(16 ký tự)";
	public static String messageBlowfish = "Key có chiều dài  ký tự 1 - 56 ký tự \nKey size là số nguyên dương từ 32 - 448 và là bội của 8 \nCó thể nhập key ở dạng String(16 ký tự) và Base64";
	public static String messageRsa = "Chỉ cho phép dạng Base64";
	
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
    public static void showMessageValidateKeyVigen(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageVigen);
    }
    public static void showMessageValidateKeyHill(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageHill);
    }
    public static void showMessageValidateKeyDes(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageDes);
    }
    public static void showMessageValidateKeyAes(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageAes);
    }
    public static void showMessageValidateKeyTwoFish(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageTowfish);
    }
    public static void showMessageValidateKeyBlowfish(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageBlowfish);
    }
    public static void showMessageValidateKeyRsa(final JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, messageRsa);
    }

}