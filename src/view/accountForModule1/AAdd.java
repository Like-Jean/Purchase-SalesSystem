package view.accountForModule1;


import java.awt.EventQueue;

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

public class AAdd {

	public JFrame frame;
	private accountControl wc = new accountControl();
	private account wh = new account();

	public AAdd() {
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
		
		JLabel lblid = new JLabel("ID");
		lblid.setBounds(82, 32, 53, 15);
		frame.getContentPane().add(lblid);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(165, 26, 107, 21);
		frame.getContentPane().add(textPane);
		
		JLabel label = new JLabel("开户行");//名称
		label.setBounds(82, 78, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(165, 78, 107, 21);
		frame.getContentPane().add(textPane_1);
		
		JLabel label_1 = new JLabel("\u5907\u6CE8");//备注
		label_1.setBounds(82, 126, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(165, 126, 107, 21);
		frame.getContentPane().add(textPane_2);
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			int i;
			public void actionPerformed(ActionEvent e) {
				i = 0;
				if(textPane.getText().trim().toString().length() == 0||
						textPane_1.getText().trim().toString().length() == 0){
					JOptionPane.showMessageDialog(null,"Id与开户行不能为空","操作失败!",JOptionPane.ERROR_MESSAGE);
			    	i = 1;					
				}
				if(i == 0){
					wh.setAcc_id(textPane.getText().trim().toString());
					wh.setAcc_bank(textPane_1.getText().trim().toString());
					wh.setAcc_remark(textPane_2.getText().trim().toString());
					
					wc.add(wh);
					JOptionPane.showMessageDialog(null,"添加成功！","提示",JOptionPane.INFORMATION_MESSAGE);					
				}				
			}
		});
		button.setBounds(57, 188, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u7EE7\u7EED\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
			}
		});
		button_1.setBounds(241, 188, 93, 23);
		frame.getContentPane().add(button_1);
	}
}
