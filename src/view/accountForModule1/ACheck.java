package view.accountForModule1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import Controller.accountControl;
import Entity.account;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ACheck {
	public JFrame frame;

	private accountControl wc = new accountControl();
	public ACheck() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblid = new JLabel("\u4ED3\u5E93ID");
		lblid.setBounds(82, 32, 53, 15);
		frame.getContentPane().add(lblid);
	
		String[] IDChoose = new String[wc.getAccountId().size()];
		IDChoose = wc.getAccountId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);

		comboBox.setBounds(163, 29, 109, 21);
		frame.getContentPane().add(comboBox);		
		
		JLabel label = new JLabel("\u540D\u79F0");//Ãû³Æ
		label.setBounds(82, 78, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(165, 78, 107, 21);
		frame.getContentPane().add(textPane_1);
		
		JLabel label_1 = new JLabel("\u5907\u6CE8");//±¸×¢
		label_1.setBounds(82, 126, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(165, 126, 107, 21);
		frame.getContentPane().add(textPane_2);
		
	
		account wh = new account();
		wh = wc.findById((String)comboBox.getSelectedItem());
		
		textPane_1.setText(wh.getAcc_bank());
		textPane_2.setText(wh.getAcc_remark());		
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				account wh = new account();
				wh = wc.findById((String)comboBox.getSelectedItem());
				
				textPane_1.setText(wh.getAcc_bank());
				textPane_2.setText(wh.getAcc_remark());	
			}
		});		

	}	

}

