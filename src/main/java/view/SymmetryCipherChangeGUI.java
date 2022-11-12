package view;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import controller.RSAController;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class SymmetryCipherChangeGUI extends JFrame implements ActionListener {
	RSAController rsaController;
	JComboBox<String> comboBox;
	JButton btnNewButton;
	private JPanel contentPane;

	public SymmetryCipherChangeGUI(final RSAController rsaController) {
		this.rsaController = rsaController;
		this.setDefaultCloseOperation(2);
		this.setBounds(100, 100, 617, 319);
		this.setLocationRelativeTo(null);
		(this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		final String[] arr = { "DES", "AES", "Blowfish" };
		(this.comboBox = new JComboBox<String>(arr)).setSelectedItem(rsaController.getSymmetryAlgorithm());
		this.comboBox.setFont(new Font("Segoe UI", 0, 16));
		this.comboBox.setBounds(112, 82, 381, 32);
		this.contentPane.add(this.comboBox);
		(this.btnNewButton = new JButton("C\u1eadp nh\u1eadt")).addActionListener(this);
		this.btnNewButton.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton.setBounds(243, 146, 112, 45);
		this.contentPane.add(this.btnNewButton);
		final JLabel lblNewLabel = new JLabel("Thay \u0111\u1ed5i thu\u1eadt to\u00e1n \u0111\u1ed1i x\u1ee9ng ");
		lblNewLabel.setFont(new Font("Segoe UI", 0, 16));
		lblNewLabel.setBounds(176, 26, 239, 32);
		this.contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == this.btnNewButton) {
			this.rsaController.setSymmetryAlgorithm((String) this.comboBox.getSelectedItem());
			this.comboBox.setSelectedItem(this.rsaController.getSymmetryAlgorithm());
			JOptionPane.showMessageDialog(this, "C\u1eadp nh\u1eadt th\u00e0nh c\u00f4ng");
		}
	}
}