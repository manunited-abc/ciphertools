package controller;
import io.WriteFile;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import io.ReadFile;
import org.apache.commons.io.FilenameUtils;
import java.awt.Component;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class GeneralController
{
    int maxSizeKey;
    int minSizeKey;
    long maxSizeFile;
    String maxSizeFileStr;
    
    public GeneralController() {
        this.maxSizeKey = 100;
        this.minSizeKey = 0;
        this.maxSizeFile = 10000L;
        this.maxSizeFileStr = "10KB";
    }

    public void handleLoadFileTxt(final JFrame jFrame, final JTextArea area) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", new String[] { "txt" }));
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            final String extension = FilenameUtils.getExtension(fileToSave.getName());
            final long sizeFile = fileToSave.length();
            if (extension.equals("txt")) {
                if (sizeFile < this.maxSizeFile) {
                    try {
                        final String message = ReadFile.readLine(path);
                        area.setText(message);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(jFrame, "T\u00ean file kh\u00f4ng h\u1ee3p l\u1ec7");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(jFrame, "File c\u00f3 k\u00edch th\u01b0\u1edbc <" + this.maxSizeFileStr);
                }
            }
            else {
                JOptionPane.showMessageDialog(jFrame, "Ch\u1ec9 h\u1ed7 tr\u1ee3 file c\u00f3 \u0111u\u00f4i txt");
            }
        }
    }
    
    public void handleLoadFileName(final JFrame jFrame, final JLabel label) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == 0) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = fileToSave.getAbsolutePath();
            label.setText(path);
        }
    }
    
    public void hanldeSaveBytes(final JFrame jFrame, final byte[] bytes, final String extention) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = String.valueOf(fileToSave.getAbsolutePath()) + "." + extention;
            try {
                WriteFile.writeByte(path, bytes);
                JOptionPane.showMessageDialog(jFrame, "L\u01b0u th\u00e0nh c\u00f4ng");
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(jFrame, "T\u00ean file kh\u00f4ng h\u1ee3p l\u1ec7");
            }
        }
    }
    
    public void handleSaveObject(final Object result, final JFrame jFrame, final String extention) {
        if (result != null) {
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            final int userSelection = fileChooser.showSaveDialog(jFrame);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                final File fileToSave = fileChooser.getSelectedFile();
                final String path = String.valueOf(fileToSave.getAbsolutePath()) + "." + extention;
                try {
                    WriteFile.writeObject(path, result);
                    JOptionPane.showMessageDialog(jFrame, "L\u01b0u th\u00e0nh c\u00f4ng");
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(jFrame, "T\u00ean file kh\u00f4ng h\u1ee3p l\u1ec7");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(jFrame, "N\u1ed9i dung r\u1ed7ng");
        }
    }
    
    public void handleSave(final String result, final JFrame jFrame, final String extention) {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", new String[] { "txt" }));
        final int userSelection = fileChooser.showSaveDialog(jFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            final File fileToSave = fileChooser.getSelectedFile();
            final String path = String.valueOf(fileToSave.getAbsolutePath()) + "." + extention;
            try {
                WriteFile.write(path, result);
                JOptionPane.showMessageDialog(jFrame, "L\u01b0u th\u00e0nh c\u00f4ng");
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(jFrame, "T\u00ean file kh\u00f4ng h\u1ee3p l\u1ec7");
            }
        }
    }
}