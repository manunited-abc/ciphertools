package view;

import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.Icon;
import java.awt.Font;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import model.Alphabet;
import utils.MessageDialog;
import controller.AlphabetController;
import controller.HashController;
import controller.RSAController;
import controller.TwofishController;
import controller.BlowfishController;
import controller.AESController;
import controller.DESController;
import controller.HillController;
import controller.VegenereController;
import controller.GeneralController;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

public class AlgorithmGUI extends JFrame implements ActionListener, MouseListener {
	GeneralController generalController;
	VegenereController vegenereController;
	HillController hillController;
	DESController desController;
	AESController aesController;
	BlowfishController blowfishController;
	TwofishController twofishController;
	RSAController rsaController;
	HashController hashController;
	AlphabetController alphabetController;
	Alphabet alphabet;
	private JPanel contentPane;
	private JTextField textField_key_vegen;
	private JTextField textField_keySize_vegen;
	private JTextField textField_key_hill1;
	private JTextField textField_key_hill2;
	private JTextField textField_key_hill3;
	private JTextField textField_key_hill4;
	private JTextField textField_key_des;
	private JTextField textField_privatekey_rsa;
	private JTextField textField_publickey_rsa;
	private JTextField textField_key_aes;
	private JTextField textField_key_blowfish;
	private JLabel lblNewLabel_result_vegen;
	private JLabel lb_filename_encrypt_des;
	private JLabel lb_filename_decrypt_des;
	private JLabel lb_filename_encrypt_aes;
	private JLabel lb_filename_decrypt_aes;
	private JLabel lb_filename_encrypt_blowfish;
	private JLabel lb_filename_decrypt_blowfish;
	private JLabel lb_filename_encrypt_twofish;
	private JLabel lb_filename_decrypt_twofish;
	private JLabel lb_filename_decrypt_rsa;
	private JLabel lb_filename_encrypt_rsa;
	private JLabel lb_filename_md5;
	private JLabel lb_filename_sha;
	private JTextArea textArea_encrypt_vegen;
	private JTextArea textArea_decrypt_vegen;
	private JTextArea textArea_result_vegen;
	private JTextArea textArea_encrypt_hill;
	private JTextArea textArea_decrypt_hill;
	private JTextArea textArea_result_hill;
	private JTextArea textArea_encrypt_des;
	private JTextArea textArea_decrypt_des;
	private JTextArea textArea_result_des;
	private JTextArea textArea_result_aes;
	private JTextArea textArea_encrypt_aes;
	private JTextArea textArea_decrypt_aes;
	private JTextArea textArea_encrypt_blowfish;
	private JTextArea textArea_decrypt_blowfish;
	private JTextArea textArea_result_blowfish;
	private JTextArea textArea_encrypt_twofish;
	private JTextArea textArea_decrypt_twofish;
	private JTextArea textArea_result_twofish;
	private JTextArea textArea_encrypt_rsa;
	private JTextArea textArea_decrypt_rsa;
	private JTextArea textArea_result_rsa;
	private JTextArea textArea_hash_md5;
	private JTextArea textArea_result_md5;
	private JTextArea textArea_hash_sha;
	private JTextArea textArea_result_sha;
	private JButton btnMHo_vegen;
	private JButton btnGiiM_vegen;
	private JButton btnNewButton__createKey_vegen;
	private JButton btnNewButton_saveKey_vegen;
	private JButton btnNewButton_loadKey_vegen;
	private JButton btnNewButton_result_vegen;
	private JButton btnNewButton_load_decrypt_vigen;
	private JButton btnNewButton_loadEncrypt_vigen;
	private JButton btnNewButton_createKey_hill;
	private JButton btnMHo_encrypt_hill;
	private JButton btnGiiM_decrypt_hill;
	private JButton btn_save_key_hill;
	private JButton btn_load_encrypt_hill;
	private JButton btn_load_decrypt_hill;
	private JButton btn_save_result_hill;
	private JButton btn_createKey_des;
	private JButton btn_decrypt_des;
	private JButton btn_encrypt_des;
	private JButton btn_loadFile_encrypt_des;
	private JButton btn_save_result_des;
	private JButton btn_loadFile_decrypt_des;
	private JButton btn_save_key_des;
	private JButton btn_load_key_des;
	private JButton btn_load_key_hill;
	private JButton btn_createKey_aes;
	private JButton btn_encrypt_aes;
	private JButton btn_decrypt_aes;
	private JButton btn_loadFile_encrypt_aes;
	private JButton btn_loadFile_decrypt_aes;
	private JButton btn_save_result_aes;
	private JButton btn_save_key_aes;
	private JButton btn_load_key_aes;
	private JButton btn_createKey_blowfish;
	private JButton btn_decrypt_blowfish;
	private JButton btn_encrypt_blowfish;
	private JButton btn_load_key_blowfish;
	private JButton btn_save_key_blowfish;
	private JButton btn_save_result_blowfish;
	private JButton btn_loadFile_encrypt_blowfish;
	private JButton btn_loadFile_decrypt_blowfish;
	private JButton btn_createKey_twofish;
	private JButton btn_save_result_twofish;
	private JButton btn_encrypt_twofish;
	private JButton btn_decrypt_twofish;
	private JButton btn_loadFile_encrypt_twofish;
	private JButton btn_loadFile_decrypt_twofish;
	private JButton btn_load_key_twofish;
	private JButton btn_save_key_twofish;
	private JButton btn_createKey_rsa;
	private JButton btn_loadFile_encrypt_rsa;
	private JButton btn_loadFile_decrypt_rsa;
	private JButton btn_encrypt_rsa;
	private JButton btn_decrypt_rsa;
	private JButton btn_save_result_rsa;
	private JButton btn_save_privatekey_rsa;
	private JButton btn_load_privatekey_rsa;
	private JButton btn_save_publickey_rsa;
	private JButton btn_load_publickey_rsa;
	private JButton btn_loadfile_md5;
	private JButton btn_save_result_md5;
	private JButton btn_hash_md5;
	private JButton btn_loadfile_sha;
	private JButton btn_hash_sha;
	private JButton btn_save_result_sha;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_2;
	private JTabbedPane tabbedPane;
	private JRadioButton rabtn_file_des;
	private JRadioButton rabtn_text_des;
	private JRadioButton rd_type_key_des;
	private JRadioButton rd_type_key_aes;
	private JRadioButton rd_type_key_blowfish;
	private JRadioButton rd_type_key_twofish;
	private JRadioButton rabtn_text_md5;
	private JRadioButton rabtn_file_md5;
	private JRadioButton rabtn_text_sha;
	private JRadioButton rabtn_file_sha;
	private JTextField textField_key_twofish;
	private JTextField txtBit;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_rsa;
	private JComboBox<String> comboBox_sha;
	private JComboBox<String> comboBox_private_rsa;
	private JComboBox<String> comboBox_public_rsa;
	private JTextField textField_keySize_blowfish;
	private JTextField textField;
	private JLabel lb_key_vigen;
	private JLabel lb_key_hill;
	private JLabel lb_key_des; 
	private JLabel lb_key_ase;
	private JLabel lb_key_twofish;
	private JLabel lb_key_blowfish;
	private JLabel lb_publickey_rsa;
	private JLabel lb_privatekey_rsa;


	public AlgorithmGUI() {

		this.alphabet = new Alphabet();
		this.alphabetController = new AlphabetController(this.alphabet);
		this.vegenereController = new VegenereController(this.alphabet);
		this.hillController = new HillController(this.alphabet);
		this.generalController = new GeneralController();
		this.desController = new DESController();
		this.aesController = new AESController();
		this.blowfishController = new BlowfishController();
		this.twofishController = new TwofishController();
		this.rsaController = new RSAController();
		this.hashController = new HashController();
		final int alphabetSize = this.alphabet.getAlphabet().length();
		this.setTitle("Cipher tools");
		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 1015, 588);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		final JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		final JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Thoát");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		final JMenu mnNewMenu_1 = new JMenu("C\u00e0i \u0111\u1eb7t");
		menuBar.add(mnNewMenu_1);
		(this.mntmNewMenuItem_1 = new JMenuItem("Thu\u1eadt to\u00e1n \u0111\u1ed1i x\u1ee9ng"))
				.addActionListener(this);
		mnNewMenu_1.add(this.mntmNewMenuItem_1);
		final JMenu mnNewMenu_2 = new JMenu("Tr\u1ee3 gi\u00fap");
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_2 = new JMenuItem("Hướng dẫn");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_2);
		(this.contentPane = new JPanel()).setBackground(new Color(255, 255, 255));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		final String[] sha = { "SHA-1", "SHA-256", "SHA-512" };
		this.comboBox_sha = new JComboBox(sha);
		(this.tabbedPane = new JTabbedPane(2)).addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				AlgorithmGUI.this.hanlderTab();

			}
		});
		this.tabbedPane.setBackground(new Color(255, 255, 255));
		this.tabbedPane.setTabLayoutPolicy(1);
		this.tabbedPane.setFont(new Font("Segoe UI", 1, 20));
		this.contentPane.add(this.tabbedPane, "Center");
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		this.tabbedPane.addTab("Vigenere", null, panel, "");
		panel.setLayout(null);
		(this.btnNewButton_result_vegen = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btnNewButton_result_vegen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnNewButton_result_vegen.setBackground(new Color(0, 191, 255));
		this.btnNewButton_result_vegen.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_result_vegen.setBounds(741, 441, 135, 32);
		panel.add(this.btnNewButton_result_vegen);
		(this.lblNewLabel_result_vegen = new JLabel("K\u1ebft qu\u1ea3")).setFont(new Font("Segoe UI", 1, 20));
		this.lblNewLabel_result_vegen.setBounds(664, 10, 212, 32);
		panel.add(this.lblNewLabel_result_vegen);
		final JLabel lblNewLabel_2_1 = new JLabel("Vigenere");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1.setBounds(10, 10, 102, 32);
		panel.add(lblNewLabel_2_1);
		final JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(10, 49, 644, 102);
		panel.add(panel_10);
		panel_10.setLayout(null);
		final JPanel panel_11 = new JPanel();
		panel_11.setBounds(10, 56, 624, 36);
		panel_10.add(panel_11);
		panel_11.setLayout(null);
		lb_key_vigen = new JLabel("Key ?");
		lb_key_vigen.addMouseListener(this);
		lb_key_vigen.setToolTipText(MessageDialog.messageVigen);
		lb_key_vigen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_key_vigen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_key_vigen.setHorizontalAlignment(0);
		lb_key_vigen.setFont(new Font("Segoe UI", 0, 16));
		lb_key_vigen.setBounds(0, 0, 76, 36);
		panel_11.add(lb_key_vigen);
		(this.textField_key_vegen = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_vegen.setBounds(86, 0, 384, 36);
		panel_11.add(this.textField_key_vegen);
		this.textField_key_vegen.setColumns(10);
		(this.btnNewButton_saveKey_vegen = new JButton("L\u01b0u")).addActionListener(this);
		this.btnNewButton_saveKey_vegen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnNewButton_saveKey_vegen.setBackground(new Color(0, 191, 255));
		this.btnNewButton_saveKey_vegen.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_saveKey_vegen.setBounds(481, 0, 70, 36);
		panel_11.add(this.btnNewButton_saveKey_vegen);
		(this.btnNewButton_loadKey_vegen = new JButton("T\u1ea3i")).addActionListener(this);
		this.btnNewButton_loadKey_vegen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnNewButton_loadKey_vegen.setBackground(new Color(0, 191, 255));
		this.btnNewButton_loadKey_vegen.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_loadKey_vegen.setBounds(554, 0, 70, 36);
		panel_11.add(this.btnNewButton_loadKey_vegen);
		final JLabel lblNewLabel_1_1 = new JLabel("Key size");
		lblNewLabel_1_1.setHorizontalAlignment(0);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1.setBounds(10, 10, 76, 36);
		panel_10.add(lblNewLabel_1_1);
		(this.textField_keySize_vegen = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_keySize_vegen.setColumns(10);
		this.textField_keySize_vegen.setBounds(96, 10, 194, 36);
		panel_10.add(this.textField_keySize_vegen);
		(this.btnNewButton__createKey_vegen = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btnNewButton__createKey_vegen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnNewButton__createKey_vegen.setBackground(new Color(0, 191, 255));
		this.btnNewButton__createKey_vegen.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton__createKey_vegen.setBounds(490, 10, 144, 36);
		panel_10.add(this.btnNewButton__createKey_vegen);
		final JButton btnMHo_vegen_1_3 = new JButton("Xo\u00e1");
		btnMHo_vegen_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_keySize_vegen.setText("");
				textField_key_vegen.setText("");
			}
		});
		// btnMHo_vegen_1_3.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$3(this));
		btnMHo_vegen_1_3.setForeground(Color.WHITE);
		btnMHo_vegen_1_3.setFont(new Font("Segoe UI", 0, 16));
		btnMHo_vegen_1_3.setBackground(Color.RED);
		btnMHo_vegen_1_3.setBounds(412, 10, 67, 32);
		panel_10.add(btnMHo_vegen_1_3);
		final JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBounds(10, 161, 311, 269);
		panel.add(panel_12);
		panel_12.setLayout(null);
		final JLabel lblNewLabel_1_2 = new JLabel("File Name");
		lblNewLabel_1_2.setBounds(0, 0, 241, 33);
		lblNewLabel_1_2.setHorizontalAlignment(0);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.add(lblNewLabel_1_2);
		(this.btnNewButton_loadEncrypt_vigen = new JButton("T\u1ea3i")).addActionListener(this);
		this.btnNewButton_loadEncrypt_vigen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnNewButton_loadEncrypt_vigen.setBackground(new Color(0, 191, 255));
		this.btnNewButton_loadEncrypt_vigen.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_loadEncrypt_vigen.setBounds(241, 0, 70, 33);
		panel_12.add(this.btnNewButton_loadEncrypt_vigen);
		final JPanel panel_13 = new JPanel();
		panel_13.setBounds(0, 32, 311, 237);
		panel_12.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		(this.textArea_encrypt_vegen = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		this.textArea_encrypt_vegen.setRows(10);
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(this.textArea_encrypt_vegen);
		panel_13.add(scrollPane_1);
		panel_13.add(scrollPane_1, "Center");
		final JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_14.setBounds(343, 161, 311, 269);
		panel.add(panel_14);
		panel_14.setLayout(null);
		final JLabel lblNewLabel_1_2_1 = new JLabel("File Name");
		lblNewLabel_1_2_1.setHorizontalAlignment(0);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2_1.setBounds(0, 0, 241, 33);
		panel_14.add(lblNewLabel_1_2_1);
		(this.btnNewButton_load_decrypt_vigen = new JButton("T\u1ea3i")).addActionListener(this);
		this.btnNewButton_load_decrypt_vigen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnNewButton_load_decrypt_vigen.setBackground(new Color(0, 191, 255));
		this.btnNewButton_load_decrypt_vigen.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_load_decrypt_vigen.setBounds(241, 0, 70, 33);
		panel_14.add(this.btnNewButton_load_decrypt_vigen);
		final JPanel panel_15 = new JPanel();
		panel_15.setBounds(0, 32, 311, 237);
		panel_14.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		(this.textArea_decrypt_vegen = new JTextArea()).setFont(new Font("Segoe UI", 1, 16));
		this.textArea_decrypt_vegen.setRows(10);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.textArea_decrypt_vegen);
		panel_15.add(scrollPane, "Center");
		(this.btnGiiM_vegen = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btnGiiM_vegen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnGiiM_vegen.setBackground(new Color(0, 191, 255));
		this.btnGiiM_vegen.setFont(new Font("Segoe UI", 0, 16));
		this.btnGiiM_vegen.setBounds(419, 441, 235, 32);
		panel.add(this.btnGiiM_vegen);
		(this.btnMHo_vegen = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btnMHo_vegen.setCursor(Cursor.getPredefinedCursor(12));
		this.btnMHo_vegen.setBackground(new Color(0, 191, 255));
		this.btnMHo_vegen.setFont(new Font("Segoe UI", 0, 16));
		this.btnMHo_vegen.setBounds(86, 441, 235, 32);
		panel.add(this.btnMHo_vegen);
		final JPanel panel_16 = new JPanel();
		panel_16.setBounds(664, 52, 211, 379);
		panel.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		(this.textArea_result_vegen = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_vegen.setLineWrap(true);
		textArea_result_vegen.setWrapStyleWord(true);
		final JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(this.textArea_result_vegen);
		panel_16.add(scrollPane_2);
		final JButton btnMHo_vegen_1 = new JButton("Xo\u00e1");
		btnMHo_vegen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_encrypt_vegen.setText("");
			}
		});
		// btnMHo_vegen_1.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$4(this));
		btnMHo_vegen_1.setForeground(new Color(255, 255, 255));
		btnMHo_vegen_1.setFont(new Font("Segoe UI", 0, 16));
		btnMHo_vegen_1.setBackground(new Color(255, 0, 0));
		btnMHo_vegen_1.setBounds(10, 441, 67, 32);
		panel.add(btnMHo_vegen_1);
		final JButton btnMHo_vegen_1_4 = new JButton("Xo\u00e1");
		btnMHo_vegen_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_decrypt_vegen.setText("");
			}
		});
		// btnMHo_vegen_1_4.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$5(this));
		btnMHo_vegen_1_4.setForeground(Color.WHITE);
		btnMHo_vegen_1_4.setFont(new Font("Segoe UI", 0, 16));
		btnMHo_vegen_1_4.setBackground(Color.RED);
		btnMHo_vegen_1_4.setBounds(343, 441, 67, 32);
		panel.add(btnMHo_vegen_1_4);
		final JButton btnMHo_vegen_1_5 = new JButton("Xo\u00e1");
		btnMHo_vegen_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_result_vegen.setText("");
			}
		});
		// btnMHo_vegen_1_5.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$6(this));
		btnMHo_vegen_1_5.setForeground(Color.WHITE);
		btnMHo_vegen_1_5.setFont(new Font("Segoe UI", 0, 16));
		btnMHo_vegen_1_5.setBackground(Color.RED);
		btnMHo_vegen_1_5.setBounds(664, 441, 67, 32);
		panel.add(btnMHo_vegen_1_5);
		final JPanel panel_17 = new JPanel();
		this.tabbedPane.addTab("Hill", null, panel_17, null);
		panel_17.setLayout(null);
		(this.btn_save_result_hill = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_hill.setBackground(new Color(0, 191, 255));
		this.btn_save_result_hill.setBounds(741, 441, 135, 32);
		panel_17.add(this.btn_save_result_hill);
		final JLabel lblNewLabel_2_2 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_2.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_2.setBounds(664, 10, 102, 32);
		panel_17.add(lblNewLabel_2_2);
		(this.btnMHo_encrypt_hill = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btnMHo_encrypt_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btnMHo_encrypt_hill.setBackground(new Color(0, 191, 255));
		this.btnMHo_encrypt_hill.setBounds(87, 441, 234, 32);
		panel_17.add(this.btnMHo_encrypt_hill);
		(this.btnGiiM_decrypt_hill = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btnGiiM_decrypt_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btnGiiM_decrypt_hill.setBackground(new Color(0, 191, 255));
		this.btnGiiM_decrypt_hill.setBounds(420, 441, 234, 32);
		panel_17.add(this.btnGiiM_decrypt_hill);
		final JLabel lblNewLabel_2_1_1 = new JLabel("Hill");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_1.setBounds(10, 10, 102, 32);
		panel_17.add(lblNewLabel_2_1_1);
		final JPanel panel_10_1 = new JPanel();
		panel_10_1.setLayout(null);
		panel_10_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10_1.setBounds(10, 52, 644, 102);
		panel_17.add(panel_10_1);
		(this.textField_key_hill1 = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_hill1.setColumns(10);
		this.textField_key_hill1.setBounds(116, 10, 155, 36);
		panel_10_1.add(this.textField_key_hill1);
		(this.btnNewButton_createKey_hill = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btnNewButton_createKey_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_createKey_hill.setBackground(new Color(0, 191, 255));
		this.btnNewButton_createKey_hill.setBounds(519, 12, 115, 34);
		panel_10_1.add(this.btnNewButton_createKey_hill);
		(this.textField_key_hill2 = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_hill2.setColumns(10);
		this.textField_key_hill2.setBounds(279, 10, 155, 36);
		panel_10_1.add(this.textField_key_hill2);
		(this.textField_key_hill3 = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_hill3.setColumns(10);
		this.textField_key_hill3.setBounds(116, 56, 155, 36);
		panel_10_1.add(this.textField_key_hill3);
		(this.textField_key_hill4 = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_hill4.setColumns(10);
		this.textField_key_hill4.setBounds(279, 56, 155, 36);
		panel_10_1.add(this.textField_key_hill4);
		lb_key_hill = new JLabel("Key ?");
		lblNewLabel_1_1.setToolTipText(MessageDialog.messageHill);
		lb_key_hill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_key_hill.addMouseListener(this);
		lb_key_hill.setHorizontalAlignment(0);
		lb_key_hill.setFont(new Font("Segoe UI", 0, 16));
		lb_key_hill.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_key_hill.setBounds(10, 39, 96, 32);
		panel_10_1.add(lb_key_hill);
		final JButton btn_remove_hill_key = new JButton("Xo\u00e1");
		btn_remove_hill_key.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_key_hill1.setText("");
				textField_key_hill2.setText("");
				textField_key_hill3.setText("");
				textField_key_hill4.setText("");

			}
		});
		// btn_remove_hill_key.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$7(this));
		btn_remove_hill_key.setForeground(Color.WHITE);
		btn_remove_hill_key.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key.setBackground(Color.RED);
		btn_remove_hill_key.setBounds(442, 12, 67, 36);
		panel_10_1.add(btn_remove_hill_key);
		(this.btn_save_key_hill = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_key_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_key_hill.setBackground(new Color(0, 191, 255));
		this.btn_save_key_hill.setBounds(444, 56, 96, 36);
		panel_10_1.add(this.btn_save_key_hill);
		(this.btn_load_key_hill = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_key_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_key_hill.setBackground(new Color(0, 191, 255));
		this.btn_load_key_hill.setBounds(549, 54, 85, 38);
		panel_10_1.add(this.btn_load_key_hill);
		final JLabel lblNewLabel_1_2_2 = new JLabel("File Name");
		lblNewLabel_1_2_2.setHorizontalAlignment(0);
		lblNewLabel_1_2_2.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2_2.setBounds(344, 161, 241, 33);
		panel_17.add(lblNewLabel_1_2_2);
		(this.btn_load_decrypt_hill = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_decrypt_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_decrypt_hill.setBackground(new Color(0, 191, 255));
		this.btn_load_decrypt_hill.setBounds(584, 161, 70, 33);
		panel_17.add(this.btn_load_decrypt_hill);
		final JPanel panel_12_7 = new JPanel();
		panel_12_7.setLayout(null);
		panel_12_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_7.setBounds(10, 162, 311, 269);
		panel_17.add(panel_12_7);
		final JLabel lblNewLabel_1_2_3 = new JLabel("File Name");
		lblNewLabel_1_2_3.setHorizontalAlignment(0);
		lblNewLabel_1_2_3.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_2_3.setBounds(0, 0, 241, 33);
		panel_12_7.add(lblNewLabel_1_2_3);
		(this.btn_load_encrypt_hill = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_encrypt_hill.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_encrypt_hill.setBackground(new Color(0, 191, 255));
		this.btn_load_encrypt_hill.setBounds(241, 0, 70, 33);
		panel_12_7.add(this.btn_load_encrypt_hill);
		final JPanel panel_20_1 = new JPanel();
		panel_20_1.setBounds(0, 32, 311, 237);
		panel_12_7.add(panel_20_1);
		panel_20_1.setLayout(new BorderLayout(0, 0));
		(this.textArea_encrypt_hill = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		this.textArea_encrypt_hill.setRows(10);
		final JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setViewportView(this.textArea_encrypt_hill);
		panel_20_1.add(scrollPane_3);
		final JPanel panel_18 = new JPanel();
		panel_18.setBounds(344, 194, 310, 237);
		panel_17.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
		(this.textArea_decrypt_hill = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		this.textArea_decrypt_hill.setRows(10);
		final JScrollPane scrollPane_4 = new JScrollPane(this.textArea_decrypt_hill);
		scrollPane_4.setViewportView(this.textArea_decrypt_hill);
		panel_18.add(scrollPane_4);
		final JButton btn_remove_encrypt_hill = new JButton("Xo\u00e1");
		btn_remove_encrypt_hill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_encrypt_hill.setText("");
			}
		});
		// btn_remove_encrypt_hill.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$8(this));
		btn_remove_encrypt_hill.setForeground(Color.WHITE);
		btn_remove_encrypt_hill.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_encrypt_hill.setBackground(Color.RED);
		btn_remove_encrypt_hill.setBounds(10, 441, 67, 32);
		panel_17.add(btn_remove_encrypt_hill);
		final JButton btn_remove_decrypt_hill = new JButton("Xo\u00e1");
		btn_remove_decrypt_hill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_decrypt_hill.setText("");
			}
		});
		// btn_remove_decrypt_hill.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$9(this));
		btn_remove_decrypt_hill.setForeground(Color.WHITE);
		btn_remove_decrypt_hill.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_decrypt_hill.setBackground(Color.RED);
		btn_remove_decrypt_hill.setBounds(344, 441, 67, 32);
		panel_17.add(btn_remove_decrypt_hill);
		final JPanel panel_19 = new JPanel();
		panel_19.setBounds(664, 52, 212, 379);
		panel_17.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		(this.textArea_result_hill = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_hill.setLineWrap(true);
		textArea_result_hill.setWrapStyleWord(true);
		this.textArea_result_hill.setRows(10);
		final JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setViewportView(this.textArea_result_hill);
		panel_19.add(scrollPane_5);
		final JButton btn_remove_result_key = new JButton("Xo\u00e1");
		btn_remove_result_key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_result_hill.setText("");
			}
		});
		// btn_remove_result_key.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$10(this));
		btn_remove_result_key.setForeground(Color.WHITE);
		btn_remove_result_key.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_result_key.setBackground(Color.RED);
		btn_remove_result_key.setBounds(664, 441, 67, 32);
		panel_17.add(btn_remove_result_key);
		final JLabel lblNewLabel_2 = new JLabel(
				"L\u01b0u \u00fd : Vi\u1ec7c t\u1ea1o key l\u00e0 ng\u1eabu nhi\u00ean n\u00ean m\u1ed9t s\u1ed1 tr\u01b0\u1eddng h\u1ee3p kh\u00f4ng tho\u1ea3 m\u00e3n \u0111i\u1ec1u ki\u1ec7n");
		lblNewLabel_2.setFont(new Font("Segoe UI", 0, 13));
		lblNewLabel_2.setBounds(158, 10, 496, 18);
		panel_17.add(lblNewLabel_2);
		final JLabel lblNewLabel_2_3 = new JLabel(
				" trong thu\u1eadt to\u00e1n Hill, v\u1eady h\u00e3y t\u1ea1o key nhi\u1ec1u l\u1ea7n \u0111\u1ebfn khi tho\u00e3 m\u00e3n !!");
		lblNewLabel_2_3.setFont(new Font("Segoe UI", 0, 13));
		lblNewLabel_2_3.setBounds(201, 28, 454, 18);
		panel_17.add(lblNewLabel_2_3);
		final JPanel panel_20 = new JPanel();
		this.tabbedPane.addTab("DES", null, panel_20, null);
		panel_20.setLayout(null);
		final JPanel panel_21 = new JPanel();
		panel_21.setLayout(null);
		panel_21.setBackground(Color.WHITE);
		panel_21.setBounds(0, 0, 885, 476);
		panel_20.add(panel_21);
		(this.textArea_result_des = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_des.setWrapStyleWord(true);
		textArea_result_des.setLineWrap(true);
		this.textArea_result_des.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.textArea_result_des.setBounds(664, 49, 211, 382);
		(this.btn_save_result_des = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_des.setBackground(new Color(0, 191, 255));
		this.btn_save_result_des.setBounds(741, 441, 135, 32);
		panel_21.add(this.btn_save_result_des);
		final JLabel lblNewLabel_2_4 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_4.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_4.setBounds(664, 10, 102, 32);
		panel_21.add(lblNewLabel_2_4);
		final JLabel lblNewLabel_2_1_2 = new JLabel("DES");
		lblNewLabel_2_1_2.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_2.setBounds(10, 10, 102, 32);
		panel_21.add(lblNewLabel_2_1_2);
		final JPanel panel_10_2 = new JPanel();
		panel_10_2.setLayout(null);
		panel_10_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10_2.setBounds(10, 49, 644, 102);
		panel_21.add(panel_10_2);
		final JPanel panel_11_1 = new JPanel();
		panel_11_1.setLayout(null);
		panel_11_1.setBounds(10, 56, 624, 36);
		panel_10_2.add(panel_11_1);
		lb_key_des = new JLabel("Key ?");
		lb_key_des.setToolTipText(MessageDialog.messageDes);
		lb_key_des.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_key_des.addMouseListener(this);
		lb_key_des.setHorizontalAlignment(0);
		lb_key_des.setFont(new Font("Segoe UI", 0, 16));
		lb_key_des.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_key_des.setBounds(0, 0, 117, 36);
		panel_11_1.add(lb_key_des);
		(this.textField_key_des = new JTextField()).setEnabled(false);
		this.textField_key_des.setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_des.setColumns(10);
		this.textField_key_des.setBounds(127, 0, 344, 36);
		panel_11_1.add(this.textField_key_des);
		(this.btn_save_key_des = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_key_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_key_des.setBackground(new Color(0, 191, 255));
		this.btn_save_key_des.setBounds(481, 0, 70, 36);
		panel_11_1.add(this.btn_save_key_des);
		(this.btn_load_key_des = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_key_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_key_des.setBackground(new Color(0, 191, 255));
		this.btn_load_key_des.setBounds(554, 0, 70, 36);
		panel_11_1.add(this.btn_load_key_des);
		(this.btn_createKey_des = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btn_createKey_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_createKey_des.setBackground(new Color(0, 191, 255));
		this.btn_createKey_des.setBounds(490, 10, 144, 36);
		panel_10_2.add(this.btn_createKey_des);
		this.rd_type_key_des = new JRadioButton("Nh\u1eadp key");
		rd_type_key_des.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rd_type_key_des.isSelected()) {
					textField_key_des.setEnabled(true);
					desController.setChooseTypeKey(true);
				} else {
					textField_key_des.setEnabled(false);
					desController.setChooseTypeKey(false);
				}
			}
		});
		this.rd_type_key_des.setFont(new Font("Segoe UI", 0, 16));
		this.rd_type_key_des.setBounds(306, 18, 101, 21);
		panel_10_2.add(this.rd_type_key_des);
		final JButton btn_remove_hill_key_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_key_des.setText("");
			}
		});
		// btn_remove_hill_key_1.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$12(this));
		btn_remove_hill_key_1.setForeground(Color.WHITE);
		btn_remove_hill_key_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1.setBackground(Color.RED);
		btn_remove_hill_key_1.setBounds(413, 10, 67, 36);
		panel_10_2.add(btn_remove_hill_key_1);
		final JLabel lblNewLabel_1_1_1 = new JLabel("Key size");
		lblNewLabel_1_1_1.setHorizontalAlignment(0);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1_1.setBounds(10, 10, 115, 36);
		panel_10_2.add(lblNewLabel_1_1_1);
		(this.txtBit = new JTextField()).setEnabled(false);
		this.txtBit.setText("56 bit/8 byte");
		this.txtBit.setFont(new Font("Segoe UI", 0, 16));
		this.txtBit.setBounds(135, 10, 101, 36);
		panel_10_2.add(this.txtBit);
		this.txtBit.setColumns(10);
		final ButtonGroup bg = new ButtonGroup();
		final JPanel panel_12_8 = new JPanel();
		panel_12_8.setLayout(null);
		panel_12_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_8.setBounds(10, 161, 311, 270);
		panel_21.add(panel_12_8);
		(this.lb_filename_encrypt_des = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_encrypt_des.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_encrypt_des.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_encrypt_des.setBounds(0, 0, 241, 33);
		panel_12_8.add(this.lb_filename_encrypt_des);
		(this.btn_loadFile_encrypt_des = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_encrypt_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_encrypt_des.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_encrypt_des.setBounds(241, 0, 70, 33);
		panel_12_8.add(this.btn_loadFile_encrypt_des);
		(this.textArea_encrypt_des = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		this.textArea_encrypt_des.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.textArea_encrypt_des.setBounds(0, 32, 311, 238);
		final JScrollPane scrollPane_6_1 = new JScrollPane();
		scrollPane_6_1.setViewportView(this.textArea_encrypt_des);
		final JPanel panel_22 = new JPanel();
		panel_22.setBounds(0, 31, 311, 237);
		panel_12_8.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));
		panel_22.add(scrollPane_6_1, "Center");
		final JPanel panel_13_1 = new JPanel();
		panel_13_1.setLayout(null);
		panel_13_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13_1.setBounds(343, 161, 311, 270);
		panel_21.add(panel_13_1);
		(this.lb_filename_decrypt_des = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_decrypt_des.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_decrypt_des.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_decrypt_des.setBounds(0, 0, 241, 33);
		panel_13_1.add(this.lb_filename_decrypt_des);
		(this.btn_loadFile_decrypt_des = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_decrypt_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_decrypt_des.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_decrypt_des.setBounds(241, 0, 70, 33);
		panel_13_1.add(this.btn_loadFile_decrypt_des);
		(this.textArea_decrypt_des = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		this.textArea_decrypt_des.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.textArea_decrypt_des.setBounds(0, 32, 311, 238);
		final JPanel panel_23 = new JPanel();
		panel_23.setBounds(0, 32, 311, 238);
		panel_13_1.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setViewportView(this.textArea_decrypt_des);
		panel_23.add(scrollPane_6);
		(this.btn_decrypt_des = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btn_decrypt_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_decrypt_des.setBackground(new Color(0, 191, 255));
		this.btn_decrypt_des.setBounds(417, 441, 236, 32);
		panel_21.add(this.btn_decrypt_des);
		(this.btn_encrypt_des = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btn_encrypt_des.setFont(new Font("Segoe UI", 0, 16));
		this.btn_encrypt_des.setBackground(new Color(0, 191, 255));
		this.btn_encrypt_des.setBounds(85, 441, 236, 32);
		panel_21.add(this.btn_encrypt_des);
		final JPanel panel_24 = new JPanel();
		panel_24.setBounds(664, 49, 211, 382);
		panel_21.add(panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setViewportView(this.textArea_result_des);
		panel_24.add(scrollPane_7);
		(this.rabtn_text_des = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text")).setBackground(Color.WHITE);
		rabtn_text_des.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				desController.setIsCipherText(true);
				btn_loadFile_encrypt_des.setEnabled(false);
				btn_loadFile_decrypt_des.setEnabled(false);

			}
		});
		this.rabtn_text_des.setBounds(273, 18, 171, 21);
		panel_21.add(this.rabtn_text_des);
		this.rabtn_text_des.setSelected(true);
		this.rabtn_text_des.addItemListener(null);
		this.rabtn_text_des.setFont(new Font("Segoe UI", 0, 16));
		bg.add(this.rabtn_text_des);
		(this.rabtn_file_des = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file")).setBackground(Color.WHITE);
		rabtn_file_des.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				desController.setIsCipherText(false);
				btn_loadFile_encrypt_des.setEnabled(true);
				btn_loadFile_decrypt_des.setEnabled(true);
			}
		});
		this.rabtn_file_des.setBounds(483, 18, 171, 21);
		panel_21.add(this.rabtn_file_des);
		this.rabtn_file_des.addItemListener(null);
		this.rabtn_file_des.setFont(new Font("Segoe UI", 0, 16));
		bg.add(this.rabtn_file_des);
		final JButton btn_remove_hill_key_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_encrypt_des.setText("");

			}
		});
		btn_remove_hill_key_2.setForeground(Color.WHITE);
		btn_remove_hill_key_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2.setBackground(Color.RED);
		btn_remove_hill_key_2.setBounds(10, 441, 67, 32);
		panel_21.add(btn_remove_hill_key_2);
		final JButton btn_remove_hill_key_2_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_decrypt_des.setText("");

			}
		});
		btn_remove_hill_key_2_1.setForeground(Color.WHITE);
		btn_remove_hill_key_2_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_1.setBackground(Color.RED);
		btn_remove_hill_key_2_1.setBounds(343, 441, 67, 32);
		panel_21.add(btn_remove_hill_key_2_1);
		final JButton btn_remove_hill_key_2_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_result_des.setText("");
			}
		});
		// btn_remove_hill_key_2_2.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$17(this));
		btn_remove_hill_key_2_2.setForeground(Color.WHITE);
		btn_remove_hill_key_2_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_2.setBackground(Color.RED);
		btn_remove_hill_key_2_2.setBounds(664, 441, 67, 32);
		panel_21.add(btn_remove_hill_key_2_2);
		final JPanel panel_25 = new JPanel();
		this.tabbedPane.addTab("AES", null, panel_25, null);
		panel_25.setLayout(null);
		final JPanel panel_14_1 = new JPanel();
		panel_14_1.setLayout(null);
		panel_14_1.setBackground(Color.WHITE);
		panel_14_1.setBounds(0, 0, 885, 476);
		panel_25.add(panel_14_1);
		(this.btn_save_result_aes = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_aes.setBackground(new Color(0, 191, 255));
		this.btn_save_result_aes.setBounds(741, 441, 135, 32);
		panel_14_1.add(this.btn_save_result_aes);
		final JLabel lblNewLabel_2_3_1 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_3_1.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_3_1.setBounds(664, 10, 102, 32);
		panel_14_1.add(lblNewLabel_2_3_1);
		final JLabel lblNewLabel_2_1_2_1 = new JLabel("AES");
		lblNewLabel_2_1_2_1.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_2_1.setBounds(10, 10, 102, 32);
		panel_14_1.add(lblNewLabel_2_1_2_1);
		final JPanel panel_10_2_1 = new JPanel();
		panel_10_2_1.setLayout(null);
		panel_10_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10_2_1.setBounds(10, 49, 644, 102);
		panel_14_1.add(panel_10_2_1);
		final JPanel panel_11_1_1 = new JPanel();
		panel_11_1_1.setLayout(null);
		panel_11_1_1.setBounds(10, 56, 624, 36);
		panel_10_2_1.add(panel_11_1_1);
		lb_key_ase = new JLabel("Key ?");
		lb_key_ase.setToolTipText(MessageDialog.messageAes);
		lb_key_ase.addMouseListener(this);
		lb_key_ase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_key_ase.setHorizontalAlignment(0);
		lb_key_ase.setFont(new Font("Segoe UI", 0, 16));
		lb_key_ase.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_key_ase.setBounds(0, 0, 93, 36);
		panel_11_1_1.add(lb_key_ase);
		(this.textField_key_aes = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_aes.setEnabled(false);
		this.textField_key_aes.setColumns(10);
		this.textField_key_aes.setBounds(103, 0, 368, 36);
		panel_11_1_1.add(this.textField_key_aes);
		(this.btn_save_key_aes = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_key_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_key_aes.setBackground(new Color(0, 191, 255));
		this.btn_save_key_aes.setBounds(481, 0, 70, 36);
		panel_11_1_1.add(this.btn_save_key_aes);
		(this.btn_load_key_aes = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_key_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_key_aes.setBackground(new Color(0, 191, 255));
		this.btn_load_key_aes.setBounds(554, 0, 70, 36);
		panel_11_1_1.add(this.btn_load_key_aes);
		(this.btn_createKey_aes = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btn_createKey_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_createKey_aes.setBackground(new Color(0, 191, 255));
		this.btn_createKey_aes.setBounds(490, 10, 144, 36);
		panel_10_2_1.add(this.btn_createKey_aes);
		this.rd_type_key_aes = new JRadioButton("Nh\u1eadp key");
		rd_type_key_aes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rd_type_key_aes.isSelected()) {
					textField_key_aes.setEnabled(true);
					aesController.setChooseTypeKey(true);
				} else {
					textField_key_aes.setEnabled(false);
					aesController.setChooseTypeKey(false);
				}
			}
		});
		this.rd_type_key_aes.setFont(new Font("Segoe UI", 0, 16));
		this.rd_type_key_aes.setBounds(316, 18, 91, 21);
		panel_10_2_1.add(this.rd_type_key_aes);
		final JButton btn_remove_hill_key_1_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_key_aes.setText("");
			}
		});
		// btn_remove_hill_key_1_1.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$19(this));
		btn_remove_hill_key_1_1.setForeground(Color.WHITE);
		btn_remove_hill_key_1_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_1.setBackground(Color.RED);
		btn_remove_hill_key_1_1.setBounds(413, 10, 67, 36);
		panel_10_2_1.add(btn_remove_hill_key_1_1);
		final JLabel lblNewLabel_1_4_1_3 = new JLabel("Key size");
		lblNewLabel_1_4_1_3.setHorizontalAlignment(0);
		lblNewLabel_1_4_1_3.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_4_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4_1_3.setBounds(10, 10, 93, 36);
		panel_10_2_1.add(lblNewLabel_1_4_1_3);
		(this.comboBox_2 = new JComboBox(this.aesController.keySizeStr())).setFont(new Font("Segoe UI", 0, 16));
		this.comboBox_2.setBounds(113, 10, 77, 36);
		panel_10_2_1.add(this.comboBox_2);
		final JLabel lblNewLabel_3 = new JLabel("bit");
		lblNewLabel_3.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_3.setBounds(200, 18, 45, 21);
		panel_10_2_1.add(lblNewLabel_3);
		final JPanel panel_12_1_1 = new JPanel();
		panel_12_1_1.setLayout(null);
		panel_12_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_1_1.setBounds(10, 161, 311, 270);
		panel_14_1.add(panel_12_1_1);
		(this.lb_filename_encrypt_aes = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_encrypt_aes.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_encrypt_aes.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_encrypt_aes.setBounds(0, 0, 241, 33);
		panel_12_1_1.add(this.lb_filename_encrypt_aes);
		(this.btn_loadFile_encrypt_aes = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_encrypt_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_encrypt_aes.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_encrypt_aes.setBounds(241, 0, 70, 33);
		panel_12_1_1.add(this.btn_loadFile_encrypt_aes);
		final JPanel panel_25_1 = new JPanel();
		panel_25_1.setBounds(0, 31, 311, 237);
		panel_12_1_1.add(panel_25_1);
		panel_25_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_8 = new JScrollPane();
		panel_25_1.add(scrollPane_8, "Center");
		(this.textArea_encrypt_aes = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_8.setViewportView(this.textArea_encrypt_aes);
		final JPanel panel_13_1_1 = new JPanel();
		panel_13_1_1.setLayout(null);
		panel_13_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13_1_1.setBounds(343, 161, 311, 270);
		panel_14_1.add(panel_13_1_1);
		(this.lb_filename_decrypt_aes = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_decrypt_aes.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_decrypt_aes.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_decrypt_aes.setBounds(0, 0, 241, 33);
		panel_13_1_1.add(this.lb_filename_decrypt_aes);
		(this.btn_loadFile_decrypt_aes = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_decrypt_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_decrypt_aes.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_decrypt_aes.setBounds(241, 0, 70, 33);
		panel_13_1_1.add(this.btn_loadFile_decrypt_aes);
		final JPanel panel_26_1 = new JPanel();
		panel_26_1.setBounds(0, 32, 311, 238);
		panel_13_1_1.add(panel_26_1);
		panel_26_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_9 = new JScrollPane();
		panel_26_1.add(scrollPane_9, "Center");
		(this.textArea_decrypt_aes = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_9.setViewportView(this.textArea_decrypt_aes);
		(this.btn_decrypt_aes = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btn_decrypt_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_decrypt_aes.setBackground(new Color(0, 191, 255));
		this.btn_decrypt_aes.setBounds(417, 441, 236, 32);
		panel_14_1.add(this.btn_decrypt_aes);
		(this.btn_encrypt_aes = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btn_encrypt_aes.setFont(new Font("Segoe UI", 0, 16));
		this.btn_encrypt_aes.setBackground(new Color(0, 191, 255));
		this.btn_encrypt_aes.setBounds(85, 441, 236, 32);
		panel_14_1.add(this.btn_encrypt_aes);
		final JPanel panel_27_1 = new JPanel();
		panel_27_1.setBounds(664, 49, 211, 382);
		panel_14_1.add(panel_27_1);
		panel_27_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_10 = new JScrollPane();
		panel_27_1.add(scrollPane_10, "Center");
		(this.textArea_result_aes = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_aes.setLineWrap(true);
		textArea_result_aes.setWrapStyleWord(true);
		scrollPane_10.setViewportView(this.textArea_result_aes);
		final JRadioButton rabtn_text_aes = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text");
		rabtn_text_aes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				aesController.setIsCipherText(true);
				btn_loadFile_encrypt_aes.setEnabled(false);
				btn_loadFile_decrypt_aes.setEnabled(false);
			}
		});
		// rabtn_text_aes.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$20(this));
		rabtn_text_aes.setSelected(true);
		rabtn_text_aes.setFont(new Font("Segoe UI", 0, 16));
		rabtn_text_aes.setBackground(Color.WHITE);
		rabtn_text_aes.setBounds(273, 18, 171, 21);
		panel_14_1.add(rabtn_text_aes);
		final JRadioButton rabtn_file_aes = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file");
		rabtn_file_aes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				aesController.setIsCipherText(false);
				btn_loadFile_encrypt_aes.setEnabled(true);
				btn_loadFile_decrypt_aes.setEnabled(true);
			}
		});
		// rabtn_file_aes.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$21(this));
		rabtn_file_aes.setFont(new Font("Segoe UI", 0, 16));
		rabtn_file_aes.setBackground(Color.WHITE);
		rabtn_file_aes.setBounds(483, 18, 171, 21);
		panel_14_1.add(rabtn_file_aes);
		final ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rabtn_text_aes);
		bg2.add(rabtn_file_aes);
		final JButton btn_remove_hill_key_2_3 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_encrypt_aes.setText("");

			}
		});
		btn_remove_hill_key_2_3.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_3.setBackground(Color.RED);
		btn_remove_hill_key_2_3.setBounds(10, 441, 67, 32);
		panel_14_1.add(btn_remove_hill_key_2_3);
		final JButton btn_remove_hill_key_2_1_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_decrypt_aes.setText("");

			}
		});
		btn_remove_hill_key_2_1_1.setForeground(Color.WHITE);
		btn_remove_hill_key_2_1_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_1_1.setBackground(Color.RED);
		btn_remove_hill_key_2_1_1.setBounds(343, 441, 67, 32);
		panel_14_1.add(btn_remove_hill_key_2_1_1);
		final JButton btn_remove_hill_key_2_2_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_result_aes.setText("");

			}
		});
		btn_remove_hill_key_2_2_1.setForeground(Color.WHITE);
		btn_remove_hill_key_2_2_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_2_1.setBackground(Color.RED);
		btn_remove_hill_key_2_2_1.setBounds(664, 441, 67, 32);
		panel_14_1.add(btn_remove_hill_key_2_2_1);
		final JPanel panel_26 = new JPanel();
		this.tabbedPane.addTab("Towfish", null, panel_26, null);
		panel_26.setLayout(null);
		final JPanel panel_14_1_2 = new JPanel();
		panel_14_1_2.setLayout(null);
		panel_14_1_2.setBackground(Color.WHITE);
		panel_14_1_2.setBounds(0, 0, 885, 476);
		panel_26.add(panel_14_1_2);
		(this.btn_save_result_twofish = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_twofish.setBackground(new Color(0, 191, 255));
		this.btn_save_result_twofish.setBounds(741, 441, 135, 32);
		panel_14_1_2.add(this.btn_save_result_twofish);
		final JLabel lblNewLabel_2_3_1_2 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_3_1_2.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_3_1_2.setBounds(664, 10, 102, 32);
		panel_14_1_2.add(lblNewLabel_2_3_1_2);
		final JLabel lblNewLabel_2_1_2_1_2 = new JLabel("Towfish");
		lblNewLabel_2_1_2_1_2.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_2_1_2.setBounds(10, 10, 102, 32);
		panel_14_1_2.add(lblNewLabel_2_1_2_1_2);
		final JPanel panel_10_2_1_2 = new JPanel();
		panel_10_2_1_2.setLayout(null);
		panel_10_2_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10_2_1_2.setBounds(10, 49, 644, 102);
		panel_14_1_2.add(panel_10_2_1_2);
		final JPanel panel_11_1_1_2 = new JPanel();
		panel_11_1_1_2.setLayout(null);
		panel_11_1_1_2.setBounds(10, 56, 624, 36);
		panel_10_2_1_2.add(panel_11_1_1_2);
		lb_key_twofish = new JLabel("Key ?");
		lb_key_twofish.setToolTipText(MessageDialog.messageTowfish);
		lb_key_twofish.addMouseListener(this);
		lb_key_twofish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_key_twofish.setHorizontalAlignment(0);
		lb_key_twofish.setFont(new Font("Segoe UI", 0, 16));
		lb_key_twofish.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_key_twofish.setBounds(0, 0, 106, 36);
		panel_11_1_1_2.add(lb_key_twofish);
		(this.textField_key_twofish = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_twofish.setEnabled(false);
		this.textField_key_twofish.setColumns(10);
		this.textField_key_twofish.setBounds(116, 0, 355, 36);
		panel_11_1_1_2.add(this.textField_key_twofish);
		(this.btn_save_key_twofish = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_key_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_key_twofish.setBackground(new Color(0, 191, 255));
		this.btn_save_key_twofish.setBounds(481, 0, 70, 36);
		panel_11_1_1_2.add(this.btn_save_key_twofish);
		(this.btn_load_key_twofish = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_key_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_key_twofish.setBackground(new Color(0, 191, 255));
		this.btn_load_key_twofish.setBounds(554, 0, 70, 36);
		panel_11_1_1_2.add(this.btn_load_key_twofish);
		(this.btn_createKey_twofish = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btn_createKey_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_createKey_twofish.setBackground(new Color(0, 191, 255));
		this.btn_createKey_twofish.setBounds(490, 10, 144, 36);
		panel_10_2_1_2.add(this.btn_createKey_twofish);
		this.rd_type_key_twofish = new JRadioButton("Nh\u1eadp key");
		rd_type_key_twofish.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rd_type_key_twofish.isSelected()) {
					textField_key_twofish.setEnabled(true);
					twofishController.setChooseTypeKey(true);
				} else {
					textField_key_twofish.setEnabled(false);
					twofishController.setChooseTypeKey(false);
				}

			}
		});
		this.rd_type_key_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.rd_type_key_twofish.setBounds(303, 18, 104, 21);
		panel_10_2_1_2.add(this.rd_type_key_twofish);
		final JButton btn_remove_hill_key_1_1_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_key_twofish.setText("");
			}
		});
		// btn_remove_hill_key_1_1_2.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$26(this));
		btn_remove_hill_key_1_1_2.setForeground(Color.WHITE);
		btn_remove_hill_key_1_1_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_1_2.setBackground(Color.RED);
		btn_remove_hill_key_1_1_2.setBounds(413, 10, 67, 36);
		panel_10_2_1_2.add(btn_remove_hill_key_1_1_2);
		final JLabel lblNewLabel_1_4_1_2_1 = new JLabel("Key size");
		lblNewLabel_1_4_1_2_1.setHorizontalAlignment(0);
		lblNewLabel_1_4_1_2_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_4_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4_1_2_1.setBounds(10, 10, 104, 36);
		panel_10_2_1_2.add(lblNewLabel_1_4_1_2_1);
		(this.textField = new JTextField()).setEnabled(false);
		this.textField.setText("128");
		this.textField.setFont(new Font("Segoe UI", 0, 16));
		this.textField.setColumns(10);
		this.textField.setBounds(126, 10, 67, 36);
		panel_10_2_1_2.add(this.textField);
		final JLabel lblNewLabel_3_1_1 = new JLabel("bit");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_3_1_1.setBounds(201, 18, 45, 21);
		panel_10_2_1_2.add(lblNewLabel_3_1_1);
		final JPanel panel_12_1_1_2 = new JPanel();
		panel_12_1_1_2.setLayout(null);
		panel_12_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_1_1_2.setBounds(10, 161, 311, 270);
		panel_14_1_2.add(panel_12_1_1_2);
		(this.lb_filename_encrypt_twofish = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_encrypt_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_encrypt_twofish.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_encrypt_twofish.setBounds(0, 0, 241, 33);
		panel_12_1_1_2.add(this.lb_filename_encrypt_twofish);
		(this.btn_loadFile_encrypt_twofish = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_encrypt_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_encrypt_twofish.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_encrypt_twofish.setBounds(241, 0, 70, 33);
		panel_12_1_1_2.add(this.btn_loadFile_encrypt_twofish);
		final JPanel panel_25_1_2 = new JPanel();
		panel_25_1_2.setBounds(0, 31, 311, 237);
		panel_12_1_1_2.add(panel_25_1_2);
		panel_25_1_2.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_11 = new JScrollPane();
		panel_25_1_2.add(scrollPane_11, "Center");
		(this.textArea_encrypt_twofish = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_11.setViewportView(this.textArea_encrypt_twofish);
		final JPanel panel_13_1_1_2 = new JPanel();
		panel_13_1_1_2.setLayout(null);
		panel_13_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13_1_1_2.setBounds(343, 161, 311, 270);
		panel_14_1_2.add(panel_13_1_1_2);
		(this.lb_filename_decrypt_twofish = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_decrypt_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_decrypt_twofish.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_decrypt_twofish.setBounds(0, 0, 241, 33);
		panel_13_1_1_2.add(this.lb_filename_decrypt_twofish);
		(this.btn_loadFile_decrypt_twofish = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_decrypt_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_decrypt_twofish.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_decrypt_twofish.setBounds(241, 0, 70, 33);
		panel_13_1_1_2.add(this.btn_loadFile_decrypt_twofish);
		final JPanel panel_26_1_2 = new JPanel();
		panel_26_1_2.setBounds(0, 32, 311, 238);
		panel_13_1_1_2.add(panel_26_1_2);
		panel_26_1_2.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_12 = new JScrollPane();
		panel_26_1_2.add(scrollPane_12, "Center");
		(this.textArea_decrypt_twofish = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_12.setViewportView(this.textArea_decrypt_twofish);
		(this.btn_decrypt_twofish = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btn_decrypt_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_decrypt_twofish.setBackground(new Color(0, 191, 255));
		this.btn_decrypt_twofish.setBounds(417, 441, 236, 32);
		panel_14_1_2.add(this.btn_decrypt_twofish);
		(this.btn_encrypt_twofish = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btn_encrypt_twofish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_encrypt_twofish.setBackground(new Color(0, 191, 255));
		this.btn_encrypt_twofish.setBounds(85, 441, 236, 32);
		panel_14_1_2.add(this.btn_encrypt_twofish);
		final JPanel panel_27_1_2 = new JPanel();
		panel_27_1_2.setBounds(664, 49, 211, 382);
		panel_14_1_2.add(panel_27_1_2);
		panel_27_1_2.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_13 = new JScrollPane();
		panel_27_1_2.add(scrollPane_13, "Center");
		(this.textArea_result_twofish = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_twofish.setWrapStyleWord(true);
		textArea_result_twofish.setLineWrap(true);
		scrollPane_13.setViewportView(this.textArea_result_twofish);
		final JRadioButton rabtn_text_twofish = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text");
		rabtn_text_twofish.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				twofishController.setIsCipherText(true);
				btn_loadFile_encrypt_twofish.setEnabled(false);
				btn_loadFile_decrypt_twofish.setEnabled(false);
			}
		});
		// rabtn_text_twofish.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$27(this));
		rabtn_text_twofish.setSelected(true);
		rabtn_text_twofish.setFont(new Font("Segoe UI", 0, 16));
		rabtn_text_twofish.setBackground(Color.WHITE);
		rabtn_text_twofish.setBounds(273, 18, 171, 21);
		panel_14_1_2.add(rabtn_text_twofish);
		final JRadioButton rabtn_file_twofish = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file");
		rabtn_file_twofish.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				twofishController.setIsCipherText(false);
				btn_loadFile_encrypt_twofish.setEnabled(true);
				btn_loadFile_decrypt_twofish.setEnabled(true);
			}
		});
		// rabtn_file_twofish.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$28(this));
		rabtn_file_twofish.setFont(new Font("Segoe UI", 0, 16));
		rabtn_file_twofish.setBackground(Color.WHITE);
		rabtn_file_twofish.setBounds(483, 18, 171, 21);
		panel_14_1_2.add(rabtn_file_twofish);
		final ButtonGroup bg_4 = new ButtonGroup();
		bg_4.add(rabtn_file_twofish);
		bg_4.add(rabtn_text_twofish);
		final JButton btn_remove_hill_key_2_3_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_3_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea_encrypt_twofish.setText("");
			}
		});
		btn_remove_hill_key_2_3_2.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_3_2.setBackground(Color.RED);
		btn_remove_hill_key_2_3_2.setBounds(10, 441, 67, 32);
		panel_14_1_2.add(btn_remove_hill_key_2_3_2);
		final JButton btn_remove_hill_key_2_1_1_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_1_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea_decrypt_twofish.setText("");
			}
		});
		btn_remove_hill_key_2_1_1_2.setForeground(Color.WHITE);
		btn_remove_hill_key_2_1_1_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_1_1_2.setBackground(Color.RED);
		btn_remove_hill_key_2_1_1_2.setBounds(343, 441, 67, 32);
		panel_14_1_2.add(btn_remove_hill_key_2_1_1_2);
		final JButton btn_remove_hill_key_2_2_1_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_2_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea_result_twofish.setText("");
			}
		});
		btn_remove_hill_key_2_2_1_2.setForeground(Color.WHITE);
		btn_remove_hill_key_2_2_1_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_2_1_2.setBackground(Color.RED);
		btn_remove_hill_key_2_2_1_2.setBounds(664, 441, 67, 32);
		panel_14_1_2.add(btn_remove_hill_key_2_2_1_2);
		final JPanel panel_27 = new JPanel();
		this.tabbedPane.addTab("Blowfish", null, panel_27, null);
		panel_27.setLayout(null);
		final JPanel panel_14_1_3 = new JPanel();
		panel_14_1_3.setLayout(null);
		panel_14_1_3.setBackground(Color.WHITE);
		panel_14_1_3.setBounds(0, 0, 885, 476);
		panel_27.add(panel_14_1_3);
		(this.btn_save_result_blowfish = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_save_result_blowfish.setBounds(741, 441, 135, 32);
		panel_14_1_3.add(this.btn_save_result_blowfish);
		final JLabel lblNewLabel_2_3_1_3 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_3_1_3.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_3_1_3.setBounds(664, 10, 102, 32);
		panel_14_1_3.add(lblNewLabel_2_3_1_3);
		final JLabel lblNewLabel_2_1_2_1_3 = new JLabel("Blowfish");
		lblNewLabel_2_1_2_1_3.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_2_1_3.setBounds(10, 10, 102, 32);
		panel_14_1_3.add(lblNewLabel_2_1_2_1_3);
		final JPanel panel_10_2_1_3 = new JPanel();
		panel_10_2_1_3.setLayout(null);
		panel_10_2_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10_2_1_3.setBounds(10, 49, 644, 102);
		panel_14_1_3.add(panel_10_2_1_3);
		final JPanel panel_11_1_1_3 = new JPanel();
		panel_11_1_1_3.setLayout(null);
		panel_11_1_1_3.setBounds(10, 56, 624, 36);
		panel_10_2_1_3.add(panel_11_1_1_3);
		lb_key_blowfish = new JLabel("Key ?");
		lb_key_blowfish.setToolTipText(MessageDialog.messageBlowfish);
		lb_key_blowfish.addMouseListener(this);
		lb_key_blowfish.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_key_blowfish.setHorizontalAlignment(0);
		lb_key_blowfish.setFont(new Font("Segoe UI", 0, 16));
		lb_key_blowfish.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_key_blowfish.setBounds(0, 0, 113, 36);
		panel_11_1_1_3.add(lb_key_blowfish);
		(this.textField_key_blowfish = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField_key_blowfish.setEnabled(false);
		this.textField_key_blowfish.setColumns(10);
		this.textField_key_blowfish.setBounds(123, 0, 348, 36);
		panel_11_1_1_3.add(this.textField_key_blowfish);
		(this.btn_save_key_blowfish = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_key_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_key_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_save_key_blowfish.setBounds(481, 0, 70, 36);
		panel_11_1_1_3.add(this.btn_save_key_blowfish);
		(this.btn_load_key_blowfish = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_key_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_key_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_load_key_blowfish.setBounds(554, 0, 70, 36);
		panel_11_1_1_3.add(this.btn_load_key_blowfish);
		(this.btn_createKey_blowfish = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btn_createKey_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_createKey_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_createKey_blowfish.setBounds(490, 10, 144, 36);
		panel_10_2_1_3.add(this.btn_createKey_blowfish);
		this.rd_type_key_blowfish = new JRadioButton("Nh\u1eadp key");
		rd_type_key_blowfish.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rd_type_key_blowfish.isSelected()) {
					textField_key_blowfish.setEnabled(true);
					blowfishController.setChooseTypeKey(true);
				} else {
					textField_key_blowfish.setEnabled(false);
					blowfishController.setChooseTypeKey(false);
				}
			}
		});
		this.rd_type_key_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.rd_type_key_blowfish.setBounds(299, 18, 102, 21);
		panel_10_2_1_3.add(this.rd_type_key_blowfish);
		final JButton btn_remove_hill_key_1_1_3 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_key_blowfish.setText("");
			}
		});
		// btn_remove_hill_key_1_1_3.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$33(this));
		btn_remove_hill_key_1_1_3.setForeground(Color.WHITE);
		btn_remove_hill_key_1_1_3.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_1_3.setBackground(Color.RED);
		btn_remove_hill_key_1_1_3.setBounds(413, 10, 67, 36);
		panel_10_2_1_3.add(btn_remove_hill_key_1_1_3);
		final JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Key Size");
		lblNewLabel_1_4_1_1_1.setHorizontalAlignment(0);
		lblNewLabel_1_4_1_1_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_4_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_4_1_1_1.setBounds(10, 10, 112, 36);
		panel_10_2_1_3.add(lblNewLabel_1_4_1_1_1);
		(this.textField_keySize_blowfish = new JTextField())
				.setText(String.valueOf(this.blowfishController.getKeySize()));
		this.textField_keySize_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.textField_keySize_blowfish.setColumns(10);
		this.textField_keySize_blowfish.setBounds(132, 10, 67, 36);
		panel_10_2_1_3.add(this.textField_keySize_blowfish);
		final JLabel lblNewLabel_3_1 = new JLabel("bit");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_3_1.setBounds(207, 18, 45, 21);
		panel_10_2_1_3.add(lblNewLabel_3_1);
		final JPanel panel_12_1_1_3 = new JPanel();
		panel_12_1_1_3.setLayout(null);
		panel_12_1_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_1_1_3.setBounds(10, 161, 311, 270);
		panel_14_1_3.add(panel_12_1_1_3);
		(this.lb_filename_encrypt_blowfish = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_encrypt_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_encrypt_blowfish.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_encrypt_blowfish.setBounds(0, 0, 241, 33);
		panel_12_1_1_3.add(this.lb_filename_encrypt_blowfish);
		(this.btn_loadFile_encrypt_blowfish = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_encrypt_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_encrypt_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_encrypt_blowfish.setBounds(241, 0, 70, 33);
		panel_12_1_1_3.add(this.btn_loadFile_encrypt_blowfish);
		final JPanel panel_25_1_3 = new JPanel();
		panel_25_1_3.setBounds(0, 31, 311, 237);
		panel_12_1_1_3.add(panel_25_1_3);
		panel_25_1_3.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_14 = new JScrollPane();
		panel_25_1_3.add(scrollPane_14, "Center");
		(this.textArea_encrypt_blowfish = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_14.setViewportView(this.textArea_encrypt_blowfish);
		final JPanel panel_13_1_1_3 = new JPanel();
		panel_13_1_1_3.setLayout(null);
		panel_13_1_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13_1_1_3.setBounds(343, 161, 311, 270);
		panel_14_1_3.add(panel_13_1_1_3);
		(this.lb_filename_decrypt_blowfish = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_decrypt_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_decrypt_blowfish.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_decrypt_blowfish.setBounds(0, 0, 241, 33);
		panel_13_1_1_3.add(this.lb_filename_decrypt_blowfish);
		(this.btn_loadFile_decrypt_blowfish = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadFile_decrypt_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_decrypt_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_decrypt_blowfish.setBounds(241, 0, 70, 33);
		panel_13_1_1_3.add(this.btn_loadFile_decrypt_blowfish);
		final JPanel panel_26_1_3 = new JPanel();
		panel_26_1_3.setBounds(0, 32, 311, 238);
		panel_13_1_1_3.add(panel_26_1_3);
		panel_26_1_3.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_15 = new JScrollPane();
		panel_26_1_3.add(scrollPane_15, "Center");
		(this.textArea_decrypt_blowfish = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_15.setViewportView(this.textArea_decrypt_blowfish);
		(this.btn_decrypt_blowfish = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btn_decrypt_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_decrypt_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_decrypt_blowfish.setBounds(417, 441, 236, 32);
		panel_14_1_3.add(this.btn_decrypt_blowfish);
		(this.btn_encrypt_blowfish = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btn_encrypt_blowfish.setFont(new Font("Segoe UI", 0, 16));
		this.btn_encrypt_blowfish.setBackground(new Color(0, 191, 255));
		this.btn_encrypt_blowfish.setBounds(85, 441, 236, 32);
		panel_14_1_3.add(this.btn_encrypt_blowfish);
		final JPanel panel_27_1_3 = new JPanel();
		panel_27_1_3.setBounds(664, 49, 211, 382);
		panel_14_1_3.add(panel_27_1_3);
		panel_27_1_3.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_16 = new JScrollPane();
		panel_27_1_3.add(scrollPane_16, "Center");
		(this.textArea_result_blowfish = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_blowfish.setLineWrap(true);
		textArea_result_blowfish.setWrapStyleWord(true);
		scrollPane_16.setViewportView(this.textArea_result_blowfish);
		final JRadioButton rabtn_text_blowfish = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text");
		rabtn_text_blowfish.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				blowfishController.setIsCipherText(true);
				btn_loadFile_encrypt_blowfish.setEnabled(false);
				btn_loadFile_decrypt_blowfish.setEnabled(false);
			}
		});
		// rabtn_text_blowfish.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$34(this));
		rabtn_text_blowfish.setSelected(true);
		rabtn_text_blowfish.setFont(new Font("Segoe UI", 0, 16));
		rabtn_text_blowfish.setBackground(Color.WHITE);
		rabtn_text_blowfish.setBounds(273, 18, 171, 21);
		panel_14_1_3.add(rabtn_text_blowfish);
		final JRadioButton rabtn_file_blowfish = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file");
		rabtn_file_blowfish.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				blowfishController.setIsCipherText(false);
				btn_loadFile_encrypt_blowfish.setEnabled(true);
				btn_loadFile_decrypt_blowfish.setEnabled(true);
			}
		});
		// rabtn_file_blowfish.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$35(this));
		final ButtonGroup bg3 = new ButtonGroup();
		bg3.add(rabtn_text_blowfish);
		bg3.add(rabtn_file_blowfish);
		rabtn_file_blowfish.setFont(new Font("Segoe UI", 0, 16));
		rabtn_file_blowfish.setBackground(Color.WHITE);
		rabtn_file_blowfish.setBounds(483, 18, 171, 21);
		panel_14_1_3.add(rabtn_file_blowfish);
		final JButton btn_remove_hill_key_2_3_3 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_3_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_encrypt_blowfish.setText("");

			}
		});
		btn_remove_hill_key_2_3_3.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3_3.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_3_3.setBackground(Color.RED);
		btn_remove_hill_key_2_3_3.setBounds(10, 441, 67, 32);
		panel_14_1_3.add(btn_remove_hill_key_2_3_3);
		final JButton btn_remove_hill_key_2_1_1_3 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_1_1_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_decrypt_blowfish.setText("");

			}
		});
		btn_remove_hill_key_2_1_1_3.setForeground(Color.WHITE);
		btn_remove_hill_key_2_1_1_3.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_1_1_3.setBackground(Color.RED);
		btn_remove_hill_key_2_1_1_3.setBounds(343, 441, 67, 32);
		panel_14_1_3.add(btn_remove_hill_key_2_1_1_3);
		final JButton btn_remove_hill_key_2_2_1_3 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_2_1_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_result_blowfish.setText("");

			}
		});
		btn_remove_hill_key_2_2_1_3.setForeground(Color.WHITE);
		btn_remove_hill_key_2_2_1_3.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_2_1_3.setBackground(Color.RED);
		btn_remove_hill_key_2_2_1_3.setBounds(664, 441, 67, 32);
		panel_14_1_3.add(btn_remove_hill_key_2_2_1_3);
		final JPanel panel_28 = new JPanel();
		this.tabbedPane.addTab("RSA", null, panel_28, null);
		panel_28.setLayout(null);
		final JPanel panel_29 = new JPanel();
		panel_29.setLayout(null);
		panel_29.setBackground(Color.WHITE);
		panel_29.setBounds(0, 0, 885, 476);
		panel_28.add(panel_29);
		(this.btn_save_result_rsa = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		
		this.btn_save_result_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_rsa.setBackground(new Color(0, 191, 255));
		this.btn_save_result_rsa.setBounds(734, 441, 142, 32);
		panel_29.add(this.btn_save_result_rsa);
		final JLabel lblNewLabel_2_5 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_5.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_5.setBounds(664, 10, 102, 32);
		panel_29.add(lblNewLabel_2_5);
		final JLabel lblNewLabel_2_1_3 = new JLabel("RAS");
		lblNewLabel_2_1_3.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_3.setBounds(10, 10, 102, 32);
		panel_29.add(lblNewLabel_2_1_3);
		final JPanel panel_10_3 = new JPanel();
		panel_10_3.setLayout(null);
		panel_10_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10_3.setBounds(10, 49, 644, 119);
		panel_29.add(panel_10_3);
		final JPanel panel_11_2 = new JPanel();
		panel_11_2.setLayout(null);
		panel_11_2.setBounds(10, 46, 624, 28);
		panel_10_3.add(panel_11_2);
		lb_privatekey_rsa = new JLabel("Priavte key ?");
		lb_privatekey_rsa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_privatekey_rsa.setToolTipText(MessageDialog.messageRsa);
		lb_privatekey_rsa.addMouseListener(this);
		lb_privatekey_rsa.setHorizontalAlignment(0);
		lb_privatekey_rsa.setFont(new Font("Segoe UI", 0, 16));
		lb_privatekey_rsa.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_privatekey_rsa.setBounds(0, 0, 90, 28);
		panel_11_2.add(lb_privatekey_rsa);
		(this.textField_privatekey_rsa = new JTextField()).setEnabled(true);
		this.textField_privatekey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.textField_privatekey_rsa.setColumns(10);
		this.textField_privatekey_rsa.setBounds(182, 0, 288, 28);
		panel_11_2.add(this.textField_privatekey_rsa);
		(this.btn_save_privatekey_rsa = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_privatekey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_privatekey_rsa.setBackground(new Color(0, 191, 255));
		this.btn_save_privatekey_rsa.setBounds(481, 0, 70, 28);
		panel_11_2.add(this.btn_save_privatekey_rsa);
		(this.btn_load_privatekey_rsa = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_privatekey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_privatekey_rsa.setBackground(new Color(0, 191, 255));
		this.btn_load_privatekey_rsa.setBounds(554, 0, 70, 28);
		panel_11_2.add(this.btn_load_privatekey_rsa);

		comboBox_private_rsa = new JComboBox(new Object[] { "Decrypt", "Encrypt" });
		comboBox_private_rsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();
				Object o = comboBox.getSelectedItem();
				String choose = (String) o;
				if (choose.equals("Decrypt")) {
					rsaController.setDecryptByPrivateKey(true);
					comboBox_public_rsa.setSelectedIndex(0);
				} else {
					rsaController.setDecryptByPrivateKey(false);
					comboBox_public_rsa.setSelectedIndex(1);
				}
			}
		});
		comboBox_private_rsa.setBounds(100, 0, 79, 28);
		panel_11_2.add(comboBox_private_rsa);
		final JLabel lblNewLabel_1_1_2 = new JLabel("Key size");
		lblNewLabel_1_1_2.setHorizontalAlignment(0);
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1_1_2.setBounds(10, 10, 89, 28);
		panel_10_3.add(lblNewLabel_1_1_2);
		(this.btn_createKey_rsa = new JButton("T\u1ea1o key")).addActionListener(this);
		this.btn_createKey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_createKey_rsa.setBackground(new Color(0, 191, 255));
		this.btn_createKey_rsa.setBounds(490, 10, 144, 28);
		panel_10_3.add(this.btn_createKey_rsa);
		final JPanel panel_11_5_1 = new JPanel();
		panel_11_5_1.setLayout(null);
		panel_11_5_1.setBounds(10, 84, 624, 28);
		panel_10_3.add(panel_11_5_1);
		lb_publickey_rsa = new JLabel("Public key ?");
		lb_publickey_rsa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lb_publickey_rsa.setToolTipText(MessageDialog.messageRsa);
		lb_publickey_rsa.addMouseListener(this);
		lb_publickey_rsa.setHorizontalAlignment(0);
		lb_publickey_rsa.setFont(new Font("Segoe UI", 0, 16));
		lb_publickey_rsa.setBorder(new LineBorder(new Color(0, 0, 0)));
		lb_publickey_rsa.setBounds(0, 0, 90, 28);
		panel_11_5_1.add(lb_publickey_rsa);
		(this.textField_publickey_rsa = new JTextField()).setEnabled(true);
		this.textField_publickey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.textField_publickey_rsa.setColumns(10);
		this.textField_publickey_rsa.setBounds(183, 0, 287, 28);
		panel_11_5_1.add(this.textField_publickey_rsa);
		(this.btn_save_publickey_rsa = new JButton("L\u01b0u")).addActionListener(this);
		this.btn_save_publickey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_publickey_rsa.setBackground(new Color(0, 191, 255));
		this.btn_save_publickey_rsa.setBounds(481, 0, 70, 28);
		panel_11_5_1.add(this.btn_save_publickey_rsa);
		(this.btn_load_publickey_rsa = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_load_publickey_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_load_publickey_rsa.setBackground(new Color(0, 191, 255));
		this.btn_load_publickey_rsa.setBounds(554, 0, 70, 28);
		panel_11_5_1.add(this.btn_load_publickey_rsa);

		comboBox_public_rsa = new JComboBox(new Object[] { "Encrypt", "Decrypt" });
		comboBox_public_rsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();
				Object o = comboBox.getSelectedItem();
				String choose = (String) o;
				if (choose.equals("Encrypt")) {
					rsaController.setEncryptByPublicKey(true);
					comboBox_private_rsa.setSelectedIndex(0);
				} else {
					rsaController.setEncryptByPublicKey(false);
					comboBox_private_rsa.setSelectedIndex(1);
				}
			}
		});
		comboBox_public_rsa.setBounds(100, 0, 79, 28);
		panel_11_5_1.add(comboBox_public_rsa);
		(this.comboBox_rsa = new JComboBox(this.rsaController.keySizeStr())).setFont(new Font("Segoe UI", 0, 16));
		this.comboBox_rsa.setBounds(109, 10, 79, 26);
		panel_10_3.add(this.comboBox_rsa);
		
		JButton btn_remove_hill_key_2_3_1_1_1 = new JButton("Xoá");
		btn_remove_hill_key_2_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_privatekey_rsa.setText("");
				textField_publickey_rsa.setText("");
			}
		});
		btn_remove_hill_key_2_3_1_1_1.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btn_remove_hill_key_2_3_1_1_1.setBackground(Color.RED);
		btn_remove_hill_key_2_3_1_1_1.setBounds(413, 10, 67, 32);
		panel_10_3.add(btn_remove_hill_key_2_3_1_1_1);

		String abc[] = { "Public key", "" };
		final JRadioButton rabtn_text_rsa = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text");
		(this.btn_loadFile_encrypt_rsa = new JButton("T\u1ea3i")).addActionListener(this);
		(this.btn_loadFile_decrypt_rsa = new JButton("T\u1ea3i")).addActionListener(this);
		rabtn_text_rsa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rsaController.setIsCipherText(true);
				btn_loadFile_encrypt_rsa.setEnabled(false);
				btn_loadFile_decrypt_rsa.setEnabled(false);
			}
		});
		// rabtn_text_rsa.addItemListener((ItemListener)new
		// AlgorithmGUI.AlgorithmGUI$39(this));
		rabtn_text_rsa.setSelected(true);
		rabtn_text_rsa.setFont(new Font("Segoe UI", 0, 16));
		rabtn_text_rsa.setBackground(Color.WHITE);
		rabtn_text_rsa.setBounds(277, 21, 171, 21);
		panel_29.add(rabtn_text_rsa);
		final JRadioButton rabtn_file_rsa = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file");
		rabtn_file_rsa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rsaController.setIsCipherText(false);
				btn_loadFile_encrypt_rsa.setEnabled(true);
				btn_loadFile_decrypt_rsa.setEnabled(true);
			}
		});
		// rabtn_file_rsa.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$40(this));
		rabtn_file_rsa.setFont(new Font("Segoe UI", 0, 16));
		rabtn_file_rsa.setBackground(Color.WHITE);
		rabtn_file_rsa.setBounds(487, 21, 171, 21);
		panel_29.add(rabtn_file_rsa);
		final ButtonGroup bg4 = new ButtonGroup();
		bg4.add(rabtn_file_rsa);
		bg4.add(rabtn_text_rsa);
		final JPanel panel_12_1_1_1_1 = new JPanel();
		panel_12_1_1_1_1.setLayout(null);
		panel_12_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_1_1_1_1.setBounds(10, 173, 311, 258);
		panel_29.add(panel_12_1_1_1_1);
		(this.lb_filename_encrypt_rsa = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_encrypt_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_encrypt_rsa.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_encrypt_rsa.setBounds(0, 0, 241, 33);
		panel_12_1_1_1_1.add(this.lb_filename_encrypt_rsa);

		this.btn_loadFile_encrypt_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_encrypt_rsa.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_encrypt_rsa.setBounds(241, 0, 70, 33);
		panel_12_1_1_1_1.add(this.btn_loadFile_encrypt_rsa);
		final JPanel panel_25_1_1_1 = new JPanel();
		panel_25_1_1_1.setBounds(0, 31, 311, 227);
		panel_12_1_1_1_1.add(panel_25_1_1_1);
		panel_25_1_1_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_17 = new JScrollPane();
		panel_25_1_1_1.add(scrollPane_17, "Center");
		(this.textArea_encrypt_rsa = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_encrypt_rsa.setWrapStyleWord(true);
		textArea_encrypt_rsa.setLineWrap(true);
		scrollPane_17.setViewportView(this.textArea_encrypt_rsa);
		final JPanel panel_12_1_1_1_2 = new JPanel();
		panel_12_1_1_1_2.setLayout(null);
		panel_12_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_1_1_1_2.setBounds(343, 173, 311, 258);
		panel_29.add(panel_12_1_1_1_2);
		(this.lb_filename_decrypt_rsa = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_decrypt_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_decrypt_rsa.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_decrypt_rsa.setBounds(0, 0, 241, 33);
		panel_12_1_1_1_2.add(this.lb_filename_decrypt_rsa);

		this.btn_loadFile_decrypt_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadFile_decrypt_rsa.setBackground(new Color(0, 191, 255));
		this.btn_loadFile_decrypt_rsa.setBounds(241, 0, 70, 33);
		panel_12_1_1_1_2.add(this.btn_loadFile_decrypt_rsa);
		final JPanel panel_25_1_1_2 = new JPanel();
		panel_25_1_1_2.setBounds(0, 31, 311, 227);
		panel_12_1_1_1_2.add(panel_25_1_1_2);
		panel_25_1_1_2.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_18 = new JScrollPane();
		panel_25_1_1_2.add(scrollPane_18, "Center");
		(this.textArea_decrypt_rsa = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_decrypt_rsa.setWrapStyleWord(true);
		textArea_decrypt_rsa.setLineWrap(true);
		scrollPane_18.setViewportView(this.textArea_decrypt_rsa);
		final JButton btn_remove_hill_key_2_3_1_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_encrypt_rsa.setText("");
			}
		});
		// btn_remove_hill_key_2_3_1_1.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$41(this));
		btn_remove_hill_key_2_3_1_1.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3_1_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_3_1_1.setBackground(Color.RED);
		btn_remove_hill_key_2_3_1_1.setBounds(10, 441, 67, 32);
		panel_29.add(btn_remove_hill_key_2_3_1_1);
		(this.btn_encrypt_rsa = new JButton("M\u00e3 ho\u00e1")).addActionListener(this);
		this.btn_encrypt_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_encrypt_rsa.setBackground(new Color(0, 191, 255));
		this.btn_encrypt_rsa.setBounds(85, 441, 236, 32);
		panel_29.add(this.btn_encrypt_rsa);
		final JButton btn_remove_hill_key_2_3_1_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_3_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_decrypt_rsa.setText("");

			}
		});
		btn_remove_hill_key_2_3_1_2.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3_1_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_3_1_2.setBackground(Color.RED);
		btn_remove_hill_key_2_3_1_2.setBounds(343, 441, 67, 32);
		panel_29.add(btn_remove_hill_key_2_3_1_2);
		(this.btn_decrypt_rsa = new JButton("Gi\u1ea3i m\u00e3")).addActionListener(this);
		this.btn_decrypt_rsa.setFont(new Font("Segoe UI", 0, 16));
		this.btn_decrypt_rsa.setBackground(new Color(0, 191, 255));
		this.btn_decrypt_rsa.setBounds(418, 441, 236, 32);
		panel_29.add(this.btn_decrypt_rsa);
		final JPanel panel_27_1_1_1 = new JPanel();
		panel_27_1_1_1.setBounds(665, 49, 211, 382);
		panel_29.add(panel_27_1_1_1);
		panel_27_1_1_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_19 = new JScrollPane();
		panel_27_1_1_1.add(scrollPane_19, "Center");
		(this.textArea_result_rsa = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		textArea_result_rsa.setLineWrap(true);
		textArea_result_rsa.setWrapStyleWord(true);
		scrollPane_19.setViewportView(this.textArea_result_rsa);
		final JButton btn_remove_hill_key_2_3_1_2_1 = new JButton("Xo\u00e1");
		btn_remove_hill_key_2_3_1_2_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_result_rsa.setText("");

			}
		});
		btn_remove_hill_key_2_3_1_2_1.setForeground(Color.WHITE);
		btn_remove_hill_key_2_3_1_2_1.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_2_3_1_2_1.setBackground(Color.RED);
		btn_remove_hill_key_2_3_1_2_1.setBounds(664, 441, 67, 32);
		panel_29.add(btn_remove_hill_key_2_3_1_2_1);
		final JPanel panel_30 = new JPanel();
		this.tabbedPane.addTab("SHA", null, panel_30, null);
		panel_30.setLayout(null);
		final JPanel panel_19_1 = new JPanel();
		panel_19_1.setLayout(null);
		panel_19_1.setBackground(Color.WHITE);
		panel_19_1.setBounds(0, 0, 885, 476);
		panel_30.add(panel_19_1);
		(this.btn_save_result_sha = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_sha.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_sha.setBackground(new Color(0, 191, 255));
		this.btn_save_result_sha.setBounds(544, 441, 332, 32);
		panel_19_1.add(this.btn_save_result_sha);
		final JLabel lblNewLabel_2_8_1 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_8_1.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_8_1.setBounds(469, 49, 102, 32);
		panel_19_1.add(lblNewLabel_2_8_1);
		final JLabel lblNewLabel_2_1_7_1 = new JLabel("SHA");
		lblNewLabel_2_1_7_1.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_7_1.setBounds(10, 10, 102, 32);
		panel_19_1.add(lblNewLabel_2_1_7_1);
		final JPanel panel_12_6_1 = new JPanel();
		panel_12_6_1.setLayout(null);
		panel_12_6_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_6_1.setBounds(10, 49, 425, 382);
		panel_19_1.add(panel_12_6_1);
		(this.lb_filename_sha = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_sha.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_sha.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_sha.setBounds(0, 0, 356, 33);
		panel_12_6_1.add(this.lb_filename_sha);
		(this.btn_loadfile_sha = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadfile_sha.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadfile_sha.setBackground(new Color(0, 191, 255));
		this.btn_loadfile_sha.setBounds(355, 0, 70, 33);
		panel_12_6_1.add(this.btn_loadfile_sha);
		final JPanel panel_15_1 = new JPanel();
		panel_15_1.setBounds(0, 32, 425, 350);
		panel_12_6_1.add(panel_15_1);
		panel_15_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_20 = new JScrollPane();
		panel_15_1.add(scrollPane_20, "Center");
		(this.textArea_hash_sha = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_20.setViewportView(this.textArea_hash_sha);
		(this.btn_hash_sha = new JButton("B\u0103m")).addActionListener(this);
		this.btn_hash_sha.setFont(new Font("Segoe UI", 0, 16));
		this.btn_hash_sha.setBackground(new Color(0, 191, 255));
		this.btn_hash_sha.setBounds(87, 441, 348, 32);
		panel_19_1.add(this.btn_hash_sha);
		this.rabtn_text_sha = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text");
		rabtn_text_sha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				hashController.setHashTextSha(true);
				btn_loadfile_sha.setEnabled(false);

			}
		});
		this.rabtn_text_sha.setSelected(true);
		this.rabtn_text_sha.setFont(new Font("Segoe UI", 0, 16));
		this.rabtn_text_sha.setBackground(Color.WHITE);
		this.rabtn_text_sha.setBounds(486, 10, 171, 21);
		panel_19_1.add(this.rabtn_text_sha);
		this.rabtn_file_sha = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file");
		rabtn_file_sha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				hashController.setHashTextSha(false);
				btn_loadfile_sha.setEnabled(true);
			}
		});
		this.rabtn_file_sha.setFont(new Font("Segoe UI", 0, 16));
		this.rabtn_file_sha.setBackground(Color.WHITE);
		this.rabtn_file_sha.setBounds(696, 10, 171, 21);
		panel_19_1.add(this.rabtn_file_sha);
		final ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(this.rabtn_text_sha);
		buttonGroup.add(this.rabtn_file_sha);
		final JPanel panel_16_1 = new JPanel();
		panel_16_1.setBounds(469, 84, 407, 345);
		panel_19_1.add(panel_16_1);
		panel_16_1.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_21 = new JScrollPane();
		panel_16_1.add(scrollPane_21, "Center");
		(this.textArea_result_sha = new JTextArea()).setLineWrap(true);
		this.textArea_result_sha.setWrapStyleWord(true);
		this.textArea_result_sha.setFont(new Font("Segoe UI", 0, 16));
		scrollPane_21.setViewportView(this.textArea_result_sha);
		this.comboBox_sha.setFont(new Font("Segoe UI", 0, 16));
		this.comboBox_sha.setBounds(122, 10, 102, 32);
		panel_19_1.add(this.comboBox_sha);
		final JButton btn_remove_hill_key_1_2 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_result_sha.setText("");
			}
		});
		// btn_remove_hill_key_1_2.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$46(this));
		btn_remove_hill_key_1_2.setForeground(Color.WHITE);
		btn_remove_hill_key_1_2.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_2.setBackground(Color.RED);
		btn_remove_hill_key_1_2.setBounds(469, 439, 67, 36);
		panel_19_1.add(btn_remove_hill_key_1_2);
		final JButton btn_remove_hill_key_1_3 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_hash_sha.setText("");
			}
		});

		btn_remove_hill_key_1_3.setForeground(Color.WHITE);
		btn_remove_hill_key_1_3.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_3.setBackground(Color.RED);
		btn_remove_hill_key_1_3.setBounds(10, 439, 67, 36);
		panel_19_1.add(btn_remove_hill_key_1_3);
		final JPanel panel_31 = new JPanel();
		this.tabbedPane.addTab("MD5", null, panel_31, null);
		panel_31.setLayout(null);
		final JPanel panel_32 = new JPanel();
		panel_32.setLayout(null);
		panel_32.setBackground(Color.WHITE);
		panel_32.setBounds(0, 0, 885, 476);
		panel_31.add(panel_32);
		(this.btn_save_result_md5 = new JButton("L\u01b0u k\u1ebft qu\u1ea3")).addActionListener(this);
		this.btn_save_result_md5.setFont(new Font("Segoe UI", 0, 16));
		this.btn_save_result_md5.setBackground(new Color(0, 191, 255));
		this.btn_save_result_md5.setBounds(545, 441, 331, 32);
		panel_32.add(this.btn_save_result_md5);
		final JLabel lblNewLabel_2_6 = new JLabel("K\u1ebft qu\u1ea3");
		lblNewLabel_2_6.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_6.setBounds(469, 49, 102, 32);
		panel_32.add(lblNewLabel_2_6);
		final JLabel lblNewLabel_2_1_4 = new JLabel("MD5");
		lblNewLabel_2_1_4.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel_2_1_4.setBounds(10, 10, 102, 32);
		panel_32.add(lblNewLabel_2_1_4);
		final JPanel panel_12_9 = new JPanel();
		panel_12_9.setLayout(null);
		panel_12_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12_9.setBounds(10, 49, 425, 382);
		panel_32.add(panel_12_9);
		(this.lb_filename_md5 = new JLabel("File Name")).setHorizontalAlignment(0);
		this.lb_filename_md5.setFont(new Font("Segoe UI", 0, 16));
		this.lb_filename_md5.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.lb_filename_md5.setBounds(0, 0, 356, 33);
		panel_12_9.add(this.lb_filename_md5);
		(this.btn_loadfile_md5 = new JButton("T\u1ea3i")).addActionListener(this);
		this.btn_loadfile_md5.setFont(new Font("Segoe UI", 0, 16));
		this.btn_loadfile_md5.setBackground(new Color(0, 191, 255));
		this.btn_loadfile_md5.setBounds(355, 0, 70, 33);
		panel_12_9.add(this.btn_loadfile_md5);
		final JPanel panel_33 = new JPanel();
		panel_33.setBounds(0, 32, 425, 350);
		panel_12_9.add(panel_33);
		panel_33.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_22 = new JScrollPane();
		panel_33.add(scrollPane_22);
		(this.textArea_hash_md5 = new JTextArea()).setFont(new Font("Segoe UI", 0, 16));
		scrollPane_22.setViewportView(this.textArea_hash_md5);
		(this.btn_hash_md5 = new JButton("B\u0103m")).addActionListener(this);
		this.btn_hash_md5.setFont(new Font("Segoe UI", 0, 16));
		this.btn_hash_md5.setBackground(new Color(0, 191, 255));
		this.btn_hash_md5.setBounds(87, 441, 348, 32);
		panel_32.add(this.btn_hash_md5);
		this.rabtn_text_md5 = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 text");
		rabtn_text_md5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				hashController.setHashTextMd5(true);
				btn_loadfile_md5.setEnabled(false);
			}
		});
		this.rabtn_text_md5.setSelected(true);
		this.rabtn_text_md5.setFont(new Font("Segoe UI", 0, 16));
		this.rabtn_text_md5.setBackground(Color.WHITE);
		this.rabtn_text_md5.setBounds(486, 10, 171, 21);
		panel_32.add(this.rabtn_text_md5);
		this.rabtn_file_md5 = new JRadioButton("M\u00e3 ho\u00e1 /Gi\u1ea3i m\u00e3 file");
		rabtn_file_md5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				hashController.setHashTextMd5(false);
				btn_loadfile_md5.setEnabled(true);
			}
		});
		this.rabtn_file_md5.setFont(new Font("Segoe UI", 0, 16));
		this.rabtn_file_md5.setBackground(Color.WHITE);
		this.rabtn_file_md5.setBounds(696, 10, 171, 21);
		panel_32.add(this.rabtn_file_md5);
		final ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(this.rabtn_text_md5);
		buttonGroup2.add(this.rabtn_file_md5);
		final JPanel panel_34 = new JPanel();
		panel_34.setBounds(469, 84, 407, 345);
		panel_32.add(panel_34);
		panel_34.setLayout(new BorderLayout(0, 0));
		final JScrollPane scrollPane_23 = new JScrollPane();
		panel_34.add(scrollPane_23, "Center");
		(this.textArea_result_md5 = new JTextArea()).setLineWrap(true);
		this.textArea_result_md5.setWrapStyleWord(true);
		this.textArea_result_md5.setFont(new Font("Segoe UI", 0, 16));
		scrollPane_23.setViewportView(this.textArea_result_md5);
		final JButton btn_remove_hill_key_1_4 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_result_md5.setText("");

			}
		});
		btn_remove_hill_key_1_4.setForeground(Color.WHITE);
		btn_remove_hill_key_1_4.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_4.setBackground(Color.RED);
		btn_remove_hill_key_1_4.setBounds(469, 439, 67, 36);
		panel_32.add(btn_remove_hill_key_1_4);
		final JButton btn_remove_hill_key_1_5 = new JButton("Xo\u00e1");
		btn_remove_hill_key_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_hash_md5.setText("");
			}
		});
		// btn_remove_hill_key_1_5.addActionListener((ActionListener)new
		// AlgorithmGUI.AlgorithmGUI$51(this));
		btn_remove_hill_key_1_5.setForeground(Color.WHITE);
		btn_remove_hill_key_1_5.setFont(new Font("Segoe UI", 0, 16));
		btn_remove_hill_key_1_5.setBackground(Color.RED);
		btn_remove_hill_key_1_5.setBounds(10, 437, 67, 36);
		panel_32.add(btn_remove_hill_key_1_5);
		final JPanel panel_35 = new JPanel();
		panel_35.setBackground(new Color(255, 255, 255));
		this.contentPane.add(panel_35, "North");
		panel_35.setLayout(new BoxLayout(panel_35, 0));
		final JLabel lblNewLabel = new JLabel("Gi\u1ea3i thu\u1eadt");
		lblNewLabel.setFont(new Font("Segoe UI", 1, 23));
		panel_35.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.handleVegenere(e);
		this.handleMenu(e);
		this.handleHill(e);
		this.handleDes(e);
		this.handleAes(e);
		this.hanldeBlowfish(e);
		this.hanldeTwofish(e);
		this.handleRSA(e);
		this.handleMd5(e);
		this.hanldSha(e);
	}

	public void handleVegenere(final ActionEvent e) {
		final String key = this.textField_key_vegen.getText();
		this.generalController = new GeneralController();
		if (e.getSource() == this.btnNewButton__createKey_vegen) {
			this.vegenereController.handleCreateKey(this.textField_key_vegen, this.textField_keySize_vegen,
					(JFrame) this);
		}
		if (e.getSource() == this.btnNewButton_saveKey_vegen) {
			this.generalController.handleSaveObject((Object) key, (JFrame) this, "vig");
		}
		if (e.getSource() == this.btnNewButton_loadKey_vegen) {
			this.vegenereController.handleLoadKey((JFrame) this, this.textField_key_vegen);
		}
		if (e.getSource() == this.btnMHo_vegen) {
			this.vegenereController.handleEncrypt(this.textArea_encrypt_vegen.getText(), this.textField_key_vegen,
					this.textArea_result_vegen, (JFrame) this);
			this.lblNewLabel_result_vegen.setText("K\u1ebft qu\u1ea3 m\u00e3 ho\u00e1");
		}
		if (e.getSource() == this.btnGiiM_vegen) {
			this.vegenereController.handleDecrypt(this.textArea_decrypt_vegen.getText(), this.textField_key_vegen,
					this.textArea_result_vegen, (JFrame) this);
			this.lblNewLabel_result_vegen.setText("K\u1ebft qu\u1ea3 gi\u00e3i m\u00e3");
		}
		if (e.getSource() == this.btnNewButton_result_vegen) {
			this.generalController.handleSave(this.textArea_result_vegen.getText(), (JFrame) this, "txt");
		}
		if (e.getSource() == this.btnNewButton_loadEncrypt_vigen) {
			this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_encrypt_vegen);
		}
		if (e.getSource() == this.btnNewButton_load_decrypt_vigen) {
			this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_decrypt_vegen);
		}
	}

	public void handleHill(final ActionEvent e) {
		final JTextField[][] keyFields = new JTextField[2][2];
		keyFields[0][0] = this.textField_key_hill1;
		keyFields[0][1] = this.textField_key_hill2;
		keyFields[1][0] = this.textField_key_hill3;
		keyFields[1][1] = this.textField_key_hill4;
		if (e.getSource() == this.btnNewButton_createKey_hill) {
			this.hillController.handleCreateKey(keyFields, (JFrame) this);
		}
		if (e.getSource() == this.btnMHo_encrypt_hill) {
			this.hillController.hanldeEncrypt(this.textArea_encrypt_hill.getText(), keyFields,
					this.textArea_result_hill, (JFrame) this);
		}
		if (e.getSource() == this.btnGiiM_decrypt_hill) {
			this.hillController.hanldeDecrypt(this.textArea_decrypt_hill.getText(), keyFields,
					this.textArea_result_hill, (JFrame) this);
		}
		if (e.getSource() == this.btn_load_key_hill) {
			this.hillController.handleLoadKey((JFrame) this, keyFields);
		}
		if (e.getSource() == this.btn_save_key_hill && this.hillController.checkKey(keyFields, (JFrame) this)) {
			this.generalController.handleSaveObject((Object) this.hillController.getKey(), (JFrame) this, "hill");
		}
		if (e.getSource() == this.btn_load_encrypt_hill) {
			this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_encrypt_hill);
		}
		if (e.getSource() == this.btn_load_decrypt_hill) {
			this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_decrypt_hill);
		}
		if (e.getSource() == this.btn_save_result_hill) {
			this.generalController.handleSave(this.textArea_result_hill.getText(), (JFrame) this, "txt");
		}
	}

	public void handleDes(final ActionEvent e) {
		if (e.getSource() == this.btn_loadFile_encrypt_des) {
			if (this.desController.isCipherText()) {
				this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_encrypt_des);
			} else {
				this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_encrypt_des);
			}
		}
		if (e.getSource() == this.btn_loadFile_decrypt_des) {
			if (this.desController.isCipherText()) {
				this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_decrypt_des);
			} else {
				this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_decrypt_des);
			}
		}
		if (e.getSource() == this.btn_createKey_des) {
			this.textField_key_des.setEnabled(false);
			this.rd_type_key_des.setSelected(false);
			this.desController.handleCreateKey(this.textField_key_des, (JFrame) this);
		}
		if (e.getSource() == this.btn_encrypt_des) {
			if (this.desController.isCipherText()) {
				this.desController.hanldeEncryptText(this.textField_key_des, this.textArea_encrypt_des.getText(),
						this.textArea_result_des, (JFrame) this);
			} else {
				final String sourceFile = this.lb_filename_encrypt_des.getText();
				this.desController.hanldeEncryptFile(this.textField_key_des, sourceFile, this.textArea_result_des,
						(JFrame) this);
			}
		}
		if (e.getSource() == this.btn_decrypt_des) {
			if (this.desController.isCipherText()) {
				this.desController.hanldeDecryptText(this.textField_key_des, this.textArea_decrypt_des.getText(),
						this.textArea_result_des, (JFrame) this);
			} else {
				final String sourceFile = this.lb_filename_decrypt_des.getText();
				this.desController.hanldeDecryptFile(this.textField_key_des, sourceFile, this.textArea_result_des,
						(JFrame) this);
			}
		}
		if (e.getSource() == this.btn_save_result_des) {
			if (this.desController.isCipherText()) {
				this.generalController.handleSave(this.textArea_result_des.getText(), (JFrame) this, "txt");
			} else {
				this.generalController.hanldeSaveBytes((JFrame) this, this.desController.getInputBytes(),
						this.desController.getExtention());
			}
		}
		if (e.getSource() == this.btn_save_key_des) {
			this.generalController.handleSaveObject((Object) this.desController.getKey(), (JFrame) this, "des");
		}
		if (e.getSource() == this.btn_load_key_des) {
			this.rd_type_key_des.setSelected(false);
			this.textField_key_aes.setEnabled(false);
			this.desController.hanldeLoadKey(this.textField_key_des, (JFrame) this);
		}
	}

	public void handleAes(final ActionEvent e) {
		final int keySize = Integer.parseInt((String) this.comboBox_2.getSelectedItem());
		if (e.getSource() == this.btn_loadFile_encrypt_aes) {
			if (this.aesController.isCipherText()) {
				this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_encrypt_aes);
			} else {
				this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_encrypt_aes);
			}
		}
		if (e.getSource() == this.btn_loadFile_decrypt_aes) {
			if (this.aesController.isCipherText()) {
				this.generalController.handleLoadFileTxt((JFrame) this, this.textArea_decrypt_aes);
			} else {
				this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_decrypt_aes);
			}
		}
		if (e.getSource() == this.btn_createKey_aes) {
			this.textField_key_aes.setEnabled(false);
			this.rd_type_key_aes.setSelected(false);
			this.aesController.handleCreateKey(this.textField_key_aes, (JFrame) this, keySize);
		}
		if (e.getSource() == this.btn_encrypt_aes) {
			if (this.aesController.isCipherText()) {
				this.aesController.hanldeEncryptText(this.textField_key_aes, this.textArea_encrypt_aes.getText(),
						this.textArea_result_aes, (JFrame) this, keySize);
			} else {
				final String sourceFile = this.lb_filename_encrypt_aes.getText();
				this.aesController.hanldeEncryptFile(this.textField_key_aes, sourceFile, this.textArea_result_aes,
						(JFrame) this, keySize);
			}
		}
		if (e.getSource() == this.btn_decrypt_aes) {
			if (this.aesController.isCipherText()) {
				this.aesController.hanldeDecryptText(this.textField_key_aes, this.textArea_decrypt_aes.getText(),
						this.textArea_result_aes, (JFrame) this, keySize);
			} else {
				final String sourceFile = this.lb_filename_decrypt_aes.getText();
				this.aesController.hanldeDecryptFile(this.textField_key_aes, sourceFile, this.textArea_result_aes,
						(JFrame) this, keySize);
			}
		}
		if (e.getSource() == this.btn_save_result_aes) {
			if (this.aesController.isCipherText()) {
				this.generalController.handleSave(this.textArea_result_aes.getText(), (JFrame) this, "txt");
			} else {
				this.generalController.hanldeSaveBytes((JFrame) this, this.aesController.getInputBytes(),
						this.aesController.getExtention());
			}
		}
		if (e.getSource() == this.btn_save_key_aes) {
			this.generalController.handleSaveObject((Object) this.aesController.getKey(), (JFrame) this, "aes");
		}
		if (e.getSource() == this.btn_load_key_aes) {
			this.rd_type_key_aes.setSelected(false);
			this.textField_key_aes.setEnabled(false);
			this.aesController.hanldeLoadKey(this.textField_key_aes, (JFrame) this);
		}
	}

	public void hanldeBlowfish(final ActionEvent e) {
		final String keySize = this.textField_keySize_blowfish.getText();
		if (e.getSource() == this.btn_loadFile_encrypt_blowfish) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_encrypt_blowfish);
		}
		if (e.getSource() == this.btn_loadFile_decrypt_blowfish) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_decrypt_blowfish);
		}
		if (e.getSource() == this.btn_createKey_blowfish) {
			this.textField_key_blowfish.setEnabled(false);
			this.rd_type_key_blowfish.setSelected(false);
			this.blowfishController.handleCreateKey(this.textField_key_blowfish, (JFrame) this,
					this.textField_keySize_blowfish.getText());
		}
		if (e.getSource() == this.btn_encrypt_blowfish) {
			if (this.blowfishController.isCipherText()) {
				this.blowfishController.hanldeEncryptText(this.textField_key_blowfish,
						this.textArea_encrypt_blowfish.getText(), this.textArea_result_blowfish, (JFrame) this,
						keySize);
			} else {
				final String sourceFile = this.lb_filename_encrypt_blowfish.getText();
				this.blowfishController.hanldeEncryptFile(this.textField_key_blowfish, sourceFile,
						this.textArea_result_blowfish, (JFrame) this, keySize);
			}
		}
		if (e.getSource() == this.btn_decrypt_blowfish) {
			if (this.blowfishController.isCipherText()) {
				this.blowfishController.hanldeDecryptText(this.textField_key_blowfish,
						this.textArea_decrypt_blowfish.getText(), this.textArea_result_blowfish, (JFrame) this,
						keySize);
			} else {
				final String sourceFile = this.lb_filename_decrypt_blowfish.getText();
				this.blowfishController.hanldeDecryptFile(this.textField_key_blowfish, sourceFile,
						this.textArea_result_blowfish, (JFrame) this, keySize);
			}
		}
		if (e.getSource() == this.btn_save_result_blowfish) {
			if (this.blowfishController.isCipherText()) {
				this.generalController.handleSave(this.textArea_result_blowfish.getText(), (JFrame) this, "txt");
			} else {
				this.generalController.hanldeSaveBytes((JFrame) this, this.blowfishController.getInputBytes(),
						this.blowfishController.getExtention());
			}
		}
		if (e.getSource() == this.btn_save_key_blowfish) {
			this.generalController.handleSaveObject((Object) this.blowfishController.getKey(), (JFrame) this, "blo");
		}
		if (e.getSource() == this.btn_load_key_blowfish) {
			this.rd_type_key_blowfish.setSelected(false);
			this.blowfishController.hanldeLoadKey(this.textField_key_blowfish, (JFrame) this);
			this.textField_key_blowfish.setEnabled(false);
		}
	}

	public void hanldeTwofish(final ActionEvent e) {
		if (e.getSource() == this.btn_createKey_twofish) {
			this.textField_key_twofish.setEnabled(false);
			this.twofishController.handleCreateKey(this.textField_key_twofish, (JFrame) this);
		}
		if (e.getSource() == this.btn_encrypt_twofish) {
			if (this.twofishController.isCipherText()) {
				this.twofishController.hanldeEncryptText(this.textField_key_twofish,
						this.textArea_encrypt_twofish.getText(), this.textArea_result_twofish, (JFrame) this);
			} else {
				final String sourceFile = this.lb_filename_encrypt_twofish.getText();
				this.twofishController.hanldeEncryptFile(this.textField_key_twofish, sourceFile,
						this.textArea_result_twofish, (JFrame) this);
			}
		}
		if (e.getSource() == this.btn_decrypt_twofish) {
			if (this.twofishController.isCipherText()) {
				this.twofishController.hanldeDecryptText(this.textField_key_twofish,
						this.textArea_decrypt_twofish.getText(), this.textArea_result_twofish, (JFrame) this);
			} else {
				final String sourceFile = this.lb_filename_decrypt_twofish.getText();
				this.twofishController.hanldeDecryptFile(this.textField_key_twofish, sourceFile,
						this.textArea_result_twofish, (JFrame) this);
			}
		}
		if (e.getSource() == this.btn_loadFile_encrypt_twofish) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_encrypt_twofish);
		}
		if (e.getSource() == this.btn_loadFile_decrypt_twofish) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_decrypt_twofish);
		}
		if (e.getSource() == this.btn_save_result_twofish) {
			if (this.twofishController.isCipherText()) {
				this.generalController.handleSave(this.textArea_result_twofish.getText(), (JFrame) this, "txt");
			} else {
				this.generalController.hanldeSaveBytes((JFrame) this, this.twofishController.getInputBytes(),
						this.twofishController.getExtention());
			}
		}
		if (e.getSource() == this.btn_save_key_twofish) {
			this.generalController.handleSaveObject((Object) this.twofishController.getKeyStr(), (JFrame) this, "two");
		}
		if (e.getSource() == this.btn_load_key_twofish) {
			this.twofishController.hanldeLoadKey(this.textField_key_twofish, (JFrame) this);
		}
	}

	public void handleRSA(final ActionEvent e) {
		final int keySize = Integer.parseInt((String) this.comboBox_rsa.getSelectedItem());
		if (e.getSource() == this.btn_createKey_rsa) {
			this.rsaController.handleCreateKey(this.textField_privatekey_rsa, this.textField_publickey_rsa,
					(JFrame) this, keySize);
		}
		if (e.getSource() == this.btn_encrypt_rsa) {
			if (this.rsaController.isCipherText()) {
				this.rsaController.handleEncryptText(this.textArea_result_rsa, this.textArea_encrypt_rsa.getText(),
						textField_publickey_rsa.getText(), textField_privatekey_rsa.getText(), (JFrame) this);
			} else {
				this.rsaController.handleEncryptFile(this.lb_filename_encrypt_rsa.getText(),
						textField_publickey_rsa.getText(), textField_privatekey_rsa.getText(), (JFrame) this);
			}
		}
		if (e.getSource() == this.btn_decrypt_rsa) {
			if (this.rsaController.isCipherText()) {
				this.rsaController.handleDecryptText(this.textArea_result_rsa, this.textArea_decrypt_rsa.getText(),
						textField_publickey_rsa.getText(), textField_privatekey_rsa.getText(), (JFrame) this);
			} else {
				this.rsaController.handleDecryptFile(this.lb_filename_decrypt_rsa.getText(),
						textField_publickey_rsa.getText(), textField_privatekey_rsa.getText(), (JFrame) this);
			}
		}
		if (e.getSource() == this.btn_save_privatekey_rsa) {
			this.generalController.handleSaveObject((Object) this.rsaController.getPrivateKey(), (JFrame) this, "rsa");
		}
		if (e.getSource() == this.btn_save_publickey_rsa) {
			//this.generalController.handleSaveObject((Object) this.rsaController.getPublicKey(), (JFrame) this, "rsa");
			this.generalController.hanldeSaveBytes(this,  this.rsaController.getPublicKey().getEncoded(),"rsa");
		}
		if (e.getSource() == this.btn_load_privatekey_rsa) {
			this.rsaController.handleLoadPrivateKey(this.textField_privatekey_rsa, (JFrame) this);
		}
		if (e.getSource() == this.btn_load_publickey_rsa) {
			this.rsaController.handleLoadPublicKey(this.textField_publickey_rsa, (JFrame) this);
		}
		if (e.getSource() == this.btn_loadFile_encrypt_rsa) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_encrypt_rsa);
		}
		if (e.getSource() == this.btn_loadFile_decrypt_rsa) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_decrypt_rsa);
		}
		if(e.getSource() == this.btn_save_result_rsa) {
			generalController.hanldeSaveBytes(this, rsaController.getByteEncrypt(),"rsa");
		}
	}

	public void handleMd5(final ActionEvent e) {
		if (e.getSource() == this.btn_hash_md5) {
			this.hashController.setHash("MD5");
			if (this.hashController.isHashTextMd5()) {
				this.hashController.handleHashText(this.textArea_hash_md5.getText(), this.textArea_result_md5,
						(JFrame) this);
			} else {
				this.hashController.handleHashFile(this.lb_filename_md5.getText(), this.textArea_result_md5,
						(JFrame) this);
			}
		}
		if (e.getSource() == this.btn_save_result_md5) {
			this.generalController.handleSave(this.textArea_result_md5.getText(), (JFrame) this, "txt");
		}
		if (e.getSource() == this.btn_loadfile_md5) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_md5);
		}
	}

	public void hanldSha(final ActionEvent e) {
		if (e.getSource() == this.btn_hash_sha) {
			this.hashController.setHash((String) this.comboBox_sha.getSelectedItem());
			if (this.hashController.isHashTextSha()) {
				this.hashController.handleHashText(this.textArea_hash_sha.getText(), this.textArea_result_sha,
						(JFrame) this);
			} else {
				this.hashController.handleHashFile(this.lb_filename_sha.getText(), this.textArea_result_sha,
						(JFrame) this);
			}
		}
		if (e.getSource() == this.btn_save_result_sha) {
			this.generalController.handleSave(this.textArea_result_sha.getText(), (JFrame) this, "txt");
		}
		if (e.getSource() == this.btn_loadfile_sha) {
			this.generalController.handleLoadFileName((JFrame) this, this.lb_filename_sha);
		}
	}

	public void handleMenu(final ActionEvent e) {
		if (e.getSource() == this.mntmNewMenuItem_1) {
			new SymmetryCipherChangeGUI(this.rsaController).setVisible(true);
		}
		if (e.getSource() == this.mntmNewMenuItem) {
			this.dispose();
			new WelcomeGUI().setVisible(true);
		}
		if (e.getSource() == this.mntmNewMenuItem_2) {
			new GuideGUI().setVisible(true);
		}
	}

	public void hanlderTab() {
		final int index = this.tabbedPane.getSelectedIndex();
		switch (index) {
		case 7: {
			this.hashController.setHash("MD5");
			break;
		}
		case 8: {
			this.hashController.setHash((String) this.comboBox_sha.getSelectedItem());
			break;
		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lb_key_vigen) {
			MessageDialog.showMessageValidateKeyVigen(this);
		}
		if (e.getSource() == lb_key_hill) {
			MessageDialog.showMessageValidateKeyHill(this);
		}
		if (e.getSource() == lb_key_des) {
			MessageDialog.showMessageValidateKeyDes(this);
		}
		if (e.getSource() == lb_key_ase) {
			MessageDialog.showMessageValidateKeyAes(this);
		}
		if (e.getSource() == lb_key_twofish) {
			MessageDialog.showMessageValidateKeyTwoFish(this);
		}
		if (e.getSource() == lb_key_blowfish) {
			MessageDialog.showMessageValidateKeyBlowfish(this);
		}
		if (e.getSource() == lb_privatekey_rsa) {
			MessageDialog.showMessageValidateKeyRsa(this);
		}
		if (e.getSource() == lb_publickey_rsa) {
			MessageDialog.showMessageValidateKeyRsa(this);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}