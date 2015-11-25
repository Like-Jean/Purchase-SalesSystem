package view.employeeForModule1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import Controller.employeeControl;
import Entity.employee;
import Entity.warehouse;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EDelete {

	public JFrame frame;
	
	private employeeControl ec = new employeeControl();
	private employee epl = new employee();

	public EDelete() {
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
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(28, 47, 54, 15);
		frame.getContentPane().add(lblId);
		
		String[] IDChoose = new String[ec.getEplId().size()];
		IDChoose = ec.getEplId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);
		comboBox.setBounds(69, 44, 93, 21);
		frame.getContentPane().add(comboBox);		
		
		JLabel label = new JLabel("\u59D3\u540D");//姓名
		label.setBounds(198, 47, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(246, 36, 99, 26);
		frame.getContentPane().add(textPane_1);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8");//部门
		label_1.setBounds(28, 91, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(70, 80, 93, 26);
		frame.getContentPane().add(textPane_2);
		
		JLabel label_2 = new JLabel("\u804C\u4F4D");//职位
		label_2.setBounds(198, 91, 54, 15);
		frame.getContentPane().add(label_2);
		
		final JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(246, 86, 99, 26);
		frame.getContentPane().add(textPane_3);
		
		JLabel label_3 = new JLabel("\u85AA\u8D44");//薪资
		label_3.setBounds(28, 132, 54, 15);
		frame.getContentPane().add(label_3);
		
		final JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(70, 121, 93, 26);
		frame.getContentPane().add(textPane_4);
		
		JLabel label_4 = new JLabel("\u624B\u673A");//手机
		label_4.setBounds(198, 132, 54, 15);
		frame.getContentPane().add(label_4);
		
		final JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(246, 127, 99, 26);
		frame.getContentPane().add(textPane_5);
		
		JButton button = new JButton("\u786E\u8BA4\u5220\u9664");//确认
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ec.del((String)comboBox.getSelectedItem());
				
				JOptionPane.showMessageDialog(null,"删除成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				
				frame.dispose();				
			}
		});
		button.setBounds(146, 202, 93, 23);
		frame.getContentPane().add(button);
		

		
		employee wh = new employee();
		wh = ec.findById((String)comboBox.getSelectedItem());
		
		textPane_1.setText(wh.getEmpl_name());
		textPane_2.setText(wh.getEmpl_department());
		textPane_3.setText(String.valueOf(wh.getEmpl_position()));
		textPane_4.setText(String.valueOf(wh.getEmpl_salary()));
		textPane_5.setText(wh.getEmpl_phoneNumber());
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				employee wh = new employee();
				wh = ec.findById((String)comboBox.getSelectedItem());
				
				textPane_1.setText(wh.getEmpl_name());
				textPane_2.setText(wh.getEmpl_department());
				textPane_3.setText(String.valueOf(wh.getEmpl_position()));
				textPane_4.setText(String.valueOf(wh.getEmpl_salary()));
				textPane_5.setText(wh.getEmpl_phoneNumber());
				
			}
		});			
		

	}
}

