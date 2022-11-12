package controller;

import java.io.UnsupportedEncodingException;
import org.apache.commons.io.FilenameUtils;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
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
import algorithm.BlowfishCipher;

public class BlowfishController {
	BlowfishCipher blowfishCipher;
	SecretKey key;
	boolean isCipherText;
	byte[] inputBytes;
	String extention;
	boolean isChooseTypeKey;
	String algorithnm;
	boolean isKeySize;

	public BlowfishController() {
		this.isCipherText = true;
		this.isChooseTypeKey = false;
		this.algorithnm = "BLowfish";
		this.isKeySize = true;
		this.blowfishCipher = new BlowfishCipher();
	}

	public int getKeySize() {
		return this.blowfishCipher.getKeySize();
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

	public void checkKey(final JTextField fieldKey, final JFrame jFrame, final String keySize) {
		final String keyInput = fieldKey.getText();
		try {
			final Integer keySizeInteger = Integer.parseInt(keySize);
			if (keySizeInteger >= 32 && keySizeInteger <= 448 && keySizeInteger % 8 == 0) {
				if (this.isChooseTypeKey) {
					if (StringUtils.lastChar(keyInput, "=")) {
						final byte[] keyByte = Base64.getDecoder().decode(keyInput);
						this.key = new SecretKeySpec(keyByte, this.algorithnm);
						this.blowfishCipher.setKey(this.key);
					} else {
						this.key = new SecretKeySpec(keyInput.getBytes(), this.algorithnm);
						this.blowfishCipher.setKey(this.key);
					}
				}
			} else {
				this.isKeySize = false;
			}
		} catch (NumberFormatException e) {
			this.isKeySize = false;
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
				this.key = (SecretKey) ReadFile.readObject(path);
				this.blowfishCipher.setKey(this.key);
				this.isChooseTypeKey = false;
				final String keyString = Base64.getEncoder().encodeToString(this.key.getEncoded());
				final byte[] keyByte = Base64.getDecoder().decode(keyString);
				fieldKey.setText(new String(keyString));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
			} catch (ClassNotFoundException e2) {
				JOptionPane.showMessageDialog(jFrame, "Kh\u00f4ng t\u00ecm th\u1ea7y file");
			} catch (ClassCastException e3) {
				JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
			}
		}
	}

	public void handleCreateKey(final JTextField fieldKey, final JFrame jFrame, final String keySize) {
		try {
			this.checkKey(fieldKey, jFrame, keySize);
			if (this.isKeySize) {
				this.isKeySize = true;
				this.isChooseTypeKey = false;
				this.blowfishCipher.setKeySize(Integer.parseInt(keySize));
				this.key = this.blowfishCipher.createKey();
				final String keyString = Base64.getEncoder().encodeToString(this.key.getEncoded());
				final byte[] keyByte = Base64.getDecoder().decode(keyString);
				fieldKey.setText(new String(keyString));
				this.blowfishCipher.setKey(this.key);
				System.out.println("1.LB " + fieldKey.getText());
				System.out.println("2 Sys " + fieldKey.getText());
			} else {
				JOptionPane.showMessageDialog(jFrame, "Key size kh\u00f4ng h\u1ee3p l\u1ec7");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public void hanldeEncryptText(final JTextField fieldKey, final String input, final JTextArea areaResult,
			final JFrame jFrame, final String keySize) {
		try {
			this.checkKey(fieldKey, jFrame, keySize);
			final String result = this.blowfishCipher.encryptText(input);
			areaResult.setText(result);
		} catch (IllegalBlockSizeException | NoSuchAlgorithmException | NoSuchPaddingException ex3) {
			ex3.printStackTrace();
		} catch (InvalidKeyException | IllegalArgumentException | BadPaddingException ex4) {

			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public void hanldeEncryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult,
			final JFrame jFrame, final String keySize) {
		try {
			this.checkKey(fieldKey, jFrame, keySize);
			final byte[] encryptBytes = this.blowfishCipher.cryptoFile(sourceFile, 1);
			final File file = new File(sourceFile);
			this.extention = FilenameUtils.getExtension(file.getName());
			this.inputBytes = encryptBytes;
			if (encryptBytes != null) {
				final String resultStr = StringUtils.printBytes(encryptBytes);
				areaResult.setText(resultStr);
			} else {
				MessageDialog.showMessageNotFoundFile(jFrame);
			}
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | IOException ex3) {

			ex3.printStackTrace();
		} catch (InvalidKeyException | IllegalArgumentException | BadPaddingException ex4) {

			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public void hanldeDecryptFile(final JTextField fieldKey, final String sourceFile, final JTextArea areaResult,
			final JFrame jFrame, final String keySize) {
		try {
			this.checkKey(fieldKey, jFrame, keySize);
			final byte[] decryptBytes = this.blowfishCipher.cryptoFile(sourceFile, 2);
			final File file = new File(sourceFile);
			this.extention = FilenameUtils.getExtension(file.getName());
			this.inputBytes = decryptBytes;
			if (decryptBytes != null) {
				final String resultStr = StringUtils.printBytes(decryptBytes);
				areaResult.setText(resultStr);
			} else {
				MessageDialog.showMessageNotFoundFile(jFrame);
			}
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IOException ex4) {
			ex4.printStackTrace();
		} catch (IllegalArgumentException | IllegalBlockSizeException ex5) {

			MessageDialog.showMessageCannotDecrypt(jFrame);
		} catch (InvalidKeyException | BadPaddingException ex6) {

			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public void hanldeDecryptText(final JTextField fieldKey, final String input, final JTextArea areaResult,
			final JFrame jFrame, final String keySize) {
		try {
			this.checkKey(fieldKey, jFrame, keySize);
			final String result = this.blowfishCipher.decryptText(input);
			areaResult.setText(result);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException ex4) {

			ex4.printStackTrace();
		} catch (InvalidKeyException | BadPaddingException ex5) {

			MessageDialog.showMessageKeyInvalid(jFrame);
		} catch (IllegalArgumentException | IllegalBlockSizeException ex6) {

			MessageDialog.showMessageCannotDecrypt(jFrame);
		}
	}
}