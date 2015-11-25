package view.module2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;

import Controller.Module2Controller;

public class IniAccount {

	public JFrame frame;
	private Module2Controller m2c = new Module2Controller();

	public IniAccount() {
		initialize();
	}
	//判断一个字符串是否都为数字  
	boolean isDigit(String strNum) {  
		    return strNum.matches("[0-9]{1,}");  
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u94F6\u884C\u8D26\u6237");
		label.setBounds(95, 44, 54, 15);
		frame.getContentPane().add(label);
		
		String[] IDChoose = new String[m2c.getAccountId().size()];
		IDChoose = m2c.getAccountId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);
		comboBox.setBounds(191, 41, 122, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_1 = new JLabel("\u5B58\u6B3E");
		label_1.setBounds(95, 102, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(194, 102, 105, 21);
		frame.getContentPane().add(textPane);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			int t;
			public void actionPerformed(ActionEvent e) {
				t = 0;
				if(textPane.getText().trim().length() == 0){
					t = 1;
					JOptionPane.showMessageDialog(null,"输入不能为空！","操作失败!",JOptionPane.ERROR_MESSAGE);
				
				}
				if(t == 0 && isDigit(textPane.getText().trim())){
					m2c.updateAccount((String)comboBox.getSelectedItem(), Integer.parseInt(textPane.getText().trim()));
					JOptionPane.showMessageDialog(null,"初始化成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
			}
		});
		button.setBounds(148, 187, 93, 23);
		frame.getContentPane().add(button);
		

	}
}

