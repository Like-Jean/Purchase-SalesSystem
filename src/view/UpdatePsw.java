package view;
/*@auther yixiu
 * 用户修改密码的界面
 */
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
import java.util.ArrayList;

import javax.swing.JPasswordField;

import Controller.Module3Controller;

public class UpdatePsw {

	public JFrame frame;
	private Module3Controller m3c = new Module3Controller();
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePsw window = new UpdatePsw();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
*/
	public UpdatePsw() {
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
		
		JLabel lblid = new JLabel("\u7528\u6237ID");
		lblid.setBounds(79, 35, 54, 15);
		frame.getContentPane().add(lblid);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(159, 29, 107, 21);
		frame.getContentPane().add(textPane);
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801");//原密码
		label.setBounds(79, 77, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(159, 71, 107, 21);
		frame.getContentPane().add(textPane_1);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");//新密码
		label_1.setBounds(79, 120, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(159, 114, 107, 21);
		frame.getContentPane().add(textPane_2);
		
		JLabel label_2 = new JLabel("\u518D\u6B21\u8F93\u5165");//再次输入
		label_2.setBounds(79, 160, 54, 15);
		frame.getContentPane().add(label_2);
		
		final JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(159, 154, 107, 21);
		frame.getContentPane().add(textPane_3);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			int i;
			public void actionPerformed(ActionEvent e) {
				i = 0;
				ArrayList<String> id = new ArrayList<String>();
				id = m3c.getUsId();
				for(int k = 0;k<id.size();k++){
					id.set(k, id.get(k).trim());
				}
				if(textPane.getText().trim().length() == 0||
						textPane_1.getText().trim().length() == 0||
						textPane_2.getText().trim().length() == 0||
						textPane_3.getText().trim().length() == 0){
					 i = 1;
					 JOptionPane.showMessageDialog(null,"任何一项都不能为空","提示",JOptionPane.INFORMATION_MESSAGE);					
				}
				
				if(i == 0 && !id.contains(textPane.getText().trim())){
				 i = 1;
				 System.out.println(id.get(0));
				 JOptionPane.showMessageDialog(null,"ID不存在","提示",JOptionPane.INFORMATION_MESSAGE);				
				}
				if(i == 0 &&
						!m3c.getPsw(textPane.getText().trim()).trim().equals(textPane_1.getText().trim())){
					 i = 1;
					 JOptionPane.showMessageDialog(null,"密码错误","提示",JOptionPane.INFORMATION_MESSAGE);														
				}	
				if(i == 0 && !textPane_2.getText().trim().equals(textPane_3.getText().trim())){
					 i = 1;
					 JOptionPane.showMessageDialog(null,"两次密码输入不同","提示",JOptionPane.INFORMATION_MESSAGE);						
				}
				
				if(i == 0){
					m3c.updatePsw(textPane.getText().trim(), textPane_2.getText().trim());
					JOptionPane.showMessageDialog(null,"修改成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					
					frame.dispose();					
				}
			}
		});
		button.setBounds(150, 206, 93, 23);
		frame.getContentPane().add(button);

	}
}
