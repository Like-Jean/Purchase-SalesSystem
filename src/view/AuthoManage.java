package view;
/*@author yixiu
 *@version 1.0
 * 模块3中的用户权限管理
 * 
 * */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPasswordField;

import view.authoManageForModule3.Add;
import view.authoManageForModule3.Delete;
import view.authoManageForModule3.Update;


public class AuthoManage {

	public JFrame frame;
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthoManage window = new AuthoManage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
*/
	public AuthoManage() {
		initialize();
	}
	
	 /* Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u6DFB\u52A0\u7528\u6237");//增
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add window = new Add();
					window.frame.setVisible(true);
					//子窗口关闭后父窗口不关闭
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		button.setBounds(147, 46, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5220\u9664\u7528\u6237");//删
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete window = new Delete();
					window.frame.setVisible(true);
					//子窗口关闭后父窗口不关闭
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		button_1.setBounds(147, 109, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u6743\u9650");//改
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Update window = new Update();
					window.frame.setVisible(true);
					//子窗口关闭后父窗口不关闭
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}					
			}
		});
		button_2.setBounds(147, 171, 93, 23);
		frame.getContentPane().add(button_2);
		
	

	}
}

