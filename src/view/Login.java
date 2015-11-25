package view;
/*@auther yixiu
 * 用户登录界面*/
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

import Controller.Module3Controller;

public class Login {

	public JFrame frame;
	private JPasswordField passwordField;
	private Module3Controller m3c = new Module3Controller();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	
	public Login() {
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
		
		JLabel label = new JLabel("ID");
		label.setBounds(93, 53, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(93, 99, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(157, 53, 96, 21);
		frame.getContentPane().add(textPane);
		
		JButton button = new JButton("用户登录");
		button.setBounds(79, 181, 93, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m3c.login(textPane.getText().trim(), String.valueOf(passwordField.getPassword()).trim()) == true){
					try {
						Main window1 = new Main(m3c.getAuthority(textPane.getText().trim()));
						window1.frame.setVisible(true);
						window1.frame.setDefaultCloseOperation(window1.frame.DISPOSE_ON_CLOSE);
						frame.setVisible(false);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
				else
					JOptionPane.showMessageDialog(null,"输入错误！","操作失败!",JOptionPane.ERROR_MESSAGE);
			}
		});		
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("管理员登录");
		button_1.setBounds(233, 181, 108, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(m3c.login2(textPane.getText().trim(), String.valueOf(passwordField.getPassword()).trim()) == true){
					try {
						Main window1 = new Main(6);
						window1.frame.setVisible(true);
						window1.frame.setDefaultCloseOperation(window1.frame.DISPOSE_ON_CLOSE);
						frame.setVisible(false);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
				else
					JOptionPane.showMessageDialog(null,"输入错误！","操作失败!",JOptionPane.ERROR_MESSAGE);
			}
		});		
		frame.getContentPane().add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 99, 96, 18);
		frame.getContentPane().add(passwordField);
		
		

	}
}

