package view;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

public class WelcomeGUI extends JFrame implements ActionListener {
	private JPanel contentPane;

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeGUI frame = new WelcomeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WelcomeGUI() {
		this.setTitle("Cipher tools");
		this.setFont(new Font("Arial", 0, 17));
		this.setDefaultCloseOperation(3);
		this.setBounds(100, 100, 1015, 560);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		(this.contentPane = new JPanel()).setFont(new Font("iCielBC DDCHardwareRough Compressed", 0, 26));
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		final JButton btnNewButton = new JButton("B\u1eaft \u0111\u1ea7u");
		btnNewButton.addActionListener(this);

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(12));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("iCielBC DDCHardwareRough Compressed", 0, 30));
		btnNewButton.setBounds(417, 299, 178, 56);
		this.contentPane.add(btnNewButton);
		final JLabel lblNewLabel_2 = new JLabel("Ch\u00e0o m\u1eebng \u0111\u1ebfn");
		lblNewLabel_2.setFont(new Font("iCiel Soup of Justice", 0, 30));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(401, 131, 220, 42);
		this.contentPane.add(lblNewLabel_2);
		final JLabel lblNewLabel_1_1 = new JLabel(
				"C\u00f4ng c\u1ee5 h\u1ed7 tr\u1ee3 m\u00e3 ho\u00e1 v\u00e0 gi\u1ea3i m\u00e3");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1.setFont(new Font("iCiel Soup of Justice", 0, 50));
		lblNewLabel_1_1.setBounds(120, 162, 785, 127);
		this.contentPane.add(lblNewLabel_1_1);
	}

	public void actionPerformed(ActionEvent e) {
		WelcomeGUI.this.dispose();
		 runAlgorithmGUI();
	}

	public void runAlgorithmGUI() {
		final AlgorithmGUI algorithmGUI = new AlgorithmGUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				algorithmGUI.setVisible(true);
			}
		});
	}
}
