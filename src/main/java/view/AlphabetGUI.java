package view;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import controller.AlphabetController;
import model.Alphabet;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AlphabetGUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField textField;
	JButton btnNewButton_update;
	JComboBox comboBox;
	Alphabet alphabet;
	AlphabetController alphabetController;
	boolean isDefault;

	public AlphabetGUI(final AlphabetController alphabetController, final Alphabet alphabet) {
		this.isDefault = true;
		this.alphabetController = alphabetController;
		this.alphabet = alphabet;
		this.setDefaultCloseOperation(2);
		this.setBounds(100, 100, 655, 316);
		this.setLocationRelativeTo(null);
		(this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		(this.textField = new JTextField()).setFont(new Font("Segoe UI", 0, 16));
		this.textField.setBounds(145, 81, 460, 36);
		this.contentPane.add(this.textField);
		this.textField.setColumns(10);
		final List<String> list = alphabet.listAlphabetDefault();
		String arrStr[] = new String[list.size()];
		for(int i = 0; i<list.size();i++) {
			arrStr[i] = list.get(i);
		}
		this.comboBox = new JComboBox(arrStr);
		this.comboBox.setSelectedItem(alphabet.getAlphabet());
		this.comboBox.setFont(new Font("Segoe UI", 0, 16));
		this.comboBox.setBounds(145, 144, 460, 36);
		this.contentPane.add(this.comboBox);
		final JRadioButton rdbtnNewRadioButton_Type = new JRadioButton("Nh\u1eadp");
		// rdbtnNewRadioButton_Type.addItemListener((ItemListener)new
		// AlphabetGUI.AlphabetGUI$1(this));
		rdbtnNewRadioButton_Type.setFont(new Font("Segoe UI", 0, 16));
		rdbtnNewRadioButton_Type.setBounds(24, 88, 103, 21);
		this.contentPane.add(rdbtnNewRadioButton_Type);
		final JRadioButton rdbtnNewRadioButton_Default = new JRadioButton("M\u1eb7c \u0111\u1ecbnh");
		// rdbtnNewRadioButton_Default.addItemListener((ItemListener)new
		// AlphabetGUI.AlphabetGUI$2(this));
		rdbtnNewRadioButton_Default.setFont(new Font("Segoe UI", 0, 16));
		rdbtnNewRadioButton_Default.setSelected(true);
		rdbtnNewRadioButton_Default.setBounds(24, 152, 103, 21);
		this.contentPane.add(rdbtnNewRadioButton_Default);
		final ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton_Default);
		bg.add(rdbtnNewRadioButton_Type);
		(this.btnNewButton_update = new JButton("C\u1eadp nh\u1eadt")).addActionListener(this);
		this.btnNewButton_update.setFont(new Font("Segoe UI", 0, 16));
		this.btnNewButton_update.setBounds(258, 212, 124, 36);
		this.contentPane.add(this.btnNewButton_update);
		final JLabel lblNewLabel = new JLabel("CH\u1eccN B\u1ea2NG M\u00c3");
		lblNewLabel.setHorizontalAlignment(0);
		lblNewLabel.setFont(new Font("Segoe UI", 1, 20));
		lblNewLabel.setBounds(217, 19, 224, 38);
		this.contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == this.btnNewButton_update) {
			if (this.isDefault) {
				this.alphabetController.setAlphabet((String) this.comboBox.getSelectedItem());
				JOptionPane.showMessageDialog(this, "Thay \u0111\u1ed5i b\u1ea3ng m\u00e3 th\u00e0nh c\u00f4ng");
			} else {
				final String alphabetType = this.textField.getText();
				if (alphabetType.isEmpty()) {
					JOptionPane.showMessageDialog(this, "B\u1ea3ng m\u00e3 kh\u00f4ng h\u1ee3p l\u1ec7");
				} else {
					this.alphabetController.setAlphabet(alphabetType);
					this.alphabetController.addAphabet(alphabetType);
					this.comboBox.addItem(alphabetType);
					this.comboBox.setSelectedItem(alphabetType);
					JOptionPane.showMessageDialog(this, "Thay \u0111\u1ed5i b\u1ea3ng m\u00e3 th\u00e0nh c\u00f4ng");
				}
			}
		}
	}
}