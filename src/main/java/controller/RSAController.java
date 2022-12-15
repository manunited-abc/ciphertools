package controller;

import org.apache.commons.io.FilenameUtils;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JTextArea;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import utils.MessageDialog;
import java.io.IOException;
import javax.swing.JOptionPane;
import utils.StringUtils;
import io.ReadFile;
import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.security.PrivateKey;
import algorithm.RSACipher;

public class RSAController {
	RSACipher rsaCipher;
	boolean isCipherText;
	boolean isChooseTypeKey;
	byte[] inputBytes;
	String extention;
	String algorithnm;

	public RSAController() {
		this.isCipherText = true;
		this.isChooseTypeKey = false;
		this.algorithnm = "RSA";
		this.rsaCipher = new RSACipher();
	}

	public String[] keySizeStr() {
		final String[] str = new String[this.rsaCipher.getKeySizes().length];
		for (int i = 0; i < str.length; ++i) {
			str[i] = String.valueOf(this.rsaCipher.getKeySizes()[i]);
		}
		return str;
	}

	public boolean isEncryptByPublicKey() {
		return rsaCipher.isEncryptByPublicKey();
	}

	public void setEncryptByPublicKey(boolean encryptByPublicKey) {
		rsaCipher.setEncryptByPublicKey(encryptByPublicKey);
	}

	public boolean isDecryptByPrivateKey() {
		return rsaCipher.isDecryptByPrivateKey();
	}

	public void setDecryptByPrivateKey(boolean decryptByPrivateKey) {
		rsaCipher.setDecryptByPrivateKey(decryptByPrivateKey);
	}

	public void setSymmetryAlgorithm(final String symmetryAlgorithm) {
		this.rsaCipher.setSymmetryAlgorithm(symmetryAlgorithm);
	}

	public String getSymmetryAlgorithm() {
		return this.rsaCipher.getSymmetryAlgorithm();
	}

	public PrivateKey getPrivateKey() {
		return this.rsaCipher.getPrivateKey();
	}

	public PublicKey getPublicKey() {
		return this.rsaCipher.getPublicKey();
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

	public byte[] getByteEncrypt() {
		return rsaCipher.getByteEncrypt();
	}

	public void handleLoadPrivateKey(final JTextField fieldKey, final JFrame jFrame) {
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to load");
		final int userSelection = fileChooser.showSaveDialog(jFrame);
		if (userSelection == 0) {
			final File fileToSave = fileChooser.getSelectedFile();
			final String path = fileToSave.getAbsolutePath();
			try {
				byte[] bytes = ReadFile.readBytes(path);
				PrivateKey privateKey;
				privateKey = priavteKeyByte(bytes);
				this.rsaCipher.setPrivateKey(privateKey);
				fieldKey.setText(StringUtils.encodeString(this.rsaCipher.getPrivateKey().getEncoded()));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
			} catch (ClassCastException e3) {
				JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
			} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
				MessageDialog.showMessageKeyInvalid(jFrame);
			}
		}
	}

	public void handleLoadPublicKey(final JTextField fieldKey, final JFrame jFrame) {
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to load");
		final int userSelection = fileChooser.showSaveDialog(jFrame);
		if (userSelection == 0) {
			final File fileToSave = fileChooser.getSelectedFile();
			final String path = fileToSave.getAbsolutePath();
			try {
				byte[] bytes = ReadFile.readBytes(path);
				final PublicKey publicKey =publicKeyByte(bytes);
				this.rsaCipher.setPublicKey(publicKey);
				fieldKey.setText(StringUtils.encodeString(this.rsaCipher.getPublicKey().getEncoded()));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
			} catch (ClassCastException e3) {
				JOptionPane.showMessageDialog(jFrame, "File kh\u00f4ng h\u1ee3p l\u1ec7");
			}catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
				MessageDialog.showMessageKeyInvalid(jFrame);
			}
		}
	}

	public void handleCreateKey(final JTextField fieldKey1, final JTextField fieldKey2, final JFrame jFrame,
			final int keySize) {
		try {
			this.rsaCipher.setKeySize(keySize);
			this.rsaCipher.createKey();
			final String privateKeyString = StringUtils.encodeString(this.rsaCipher.getPrivateKey().getEncoded());
			final String publicKeyString = StringUtils.encodeString(this.rsaCipher.getPublicKey().getEncoded());
			fieldKey1.setText(privateKeyString);
			fieldKey2.setText(publicKeyString);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public PublicKey publicKeyType(String keyString) throws InvalidKeySpecException, NoSuchAlgorithmException {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(keyString.getBytes()));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;

	}

	public PrivateKey priavteKeyType(String keyString) throws InvalidKeySpecException, NoSuchAlgorithmException {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyString.getBytes()));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	public PublicKey publicKeyByte(byte[] bytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;

	}

	public PrivateKey priavteKeyByte(byte[] bytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	public void handleEncryptText(final JTextArea textArea, final String input, String publicKey, String privateKey,
			final JFrame jFrame) {
		try {
//			PublicKey publicKey2 = publicKeyType(publicKey);
//			PrivateKey privateKey2 = priavteKeyType(privateKey);
//			System.out.println(StringUtils.encodeString(publicKey2.getEncoded()));
			rsaCipher.setPublicKey(publicKeyType(publicKey));
			rsaCipher.setPrivateKey(priavteKeyType(privateKey));
			final String encrypt = this.rsaCipher.encryptText(input);
			textArea.setText(encrypt);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException ex2) {

			ex2.printStackTrace();
		} catch (InvalidKeyException | InvalidKeySpecException | IllegalArgumentException e2) {
			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public void handleDecryptText(final JTextArea textArea, final String input, String publicKey, String privateKey,
			final JFrame jFrame) {
		try {
			rsaCipher.setPublicKey(publicKeyType(publicKey));
			rsaCipher.setPrivateKey(priavteKeyType(privateKey));
			final String decrypt = this.rsaCipher.decryptText(input);
			textArea.setText(decrypt);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException ex3) {

			ex3.printStackTrace();
		} catch (BadPaddingException | IllegalArgumentException ex4) {

			MessageDialog.showMessageCannotDecrypt(jFrame);
		} catch (InvalidKeyException | InvalidKeySpecException e2) {
			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public void handleEncryptFile(final String sourceFile, String publicKey, String privateKey, final JFrame jFrame) {
		try {
			rsaCipher.setPublicKey(publicKeyType(publicKey));
			rsaCipher.setPrivateKey(priavteKeyType(privateKey));
			final File file = new File(sourceFile);
			this.extention = FilenameUtils.getExtension(file.getName());
			this.rsaCipher.createSymmetryKey();
			final String desFile = this.getPath(jFrame);
			if (!desFile.isEmpty()) {
				this.rsaCipher.encryptFile(sourceFile, desFile);
				JOptionPane.showMessageDialog(jFrame, "M\u00e3 ho\u00e1 th\u00e0nh c\u00f4ng");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | IOException ex2) {
			ex2.printStackTrace();
		} catch (InvalidKeyException | InvalidKeySpecException | IllegalArgumentException e2) {
			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public void handleDecryptFile(final String sourceFile, String publicKey, String privateKey, final JFrame jFrame) {
		try {
			rsaCipher.setPublicKey(publicKeyType(publicKey));
			rsaCipher.setPrivateKey(priavteKeyType(privateKey));
			final File file = new File(sourceFile);
			this.extention = FilenameUtils.getExtension(file.getName());
			final String desFile = this.getPath(jFrame);
			if (!desFile.isEmpty()) {
				this.rsaCipher.decryptFile(sourceFile, desFile);
				JOptionPane.showMessageDialog(jFrame, "Gi\u1ea3i m\u00e3 th\u00e0nh c\u00f4ng");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException | IllegalBlockSizeException | IOException ex3) {

			ex3.printStackTrace();
		} catch (BadPaddingException | IllegalArgumentException | NegativeArraySizeException ex4) {
			MessageDialog.showMessageCannotDecrypt(jFrame);
		} catch (InvalidKeyException | InvalidKeySpecException e2) {
			MessageDialog.showMessageKeyInvalid(jFrame);
		}
	}

	public String getPath(final JFrame jFrame) {
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to load");
		final int userSelection = fileChooser.showSaveDialog(jFrame);
		if (userSelection == 0) {
			final File fileToSave = fileChooser.getSelectedFile();
			final String path = String.valueOf(fileToSave.getAbsolutePath()) + "." + this.extention;
			return path;
		}
		return "";
	}
}