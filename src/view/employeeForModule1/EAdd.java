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

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EAdd {

	public JFrame frame;
	private String empl_id;
	private String empl_name;
	private String empl_department;
	private int empl_position;
	private float empl_salary;
	private String empl_phoneNumber;
	
	private employeeControl ec = new employeeControl();
	private employee epl = new employee();

	public EAdd() {
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
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(70, 36, 99, 26);
		frame.getContentPane().add(textPane);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(28, 47, 54, 15);
		frame.getContentPane().add(lblId);
		
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
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");//确认添加
		button.addActionListener(new ActionListener() {
			int i;
			public void actionPerformed(ActionEvent e) {
				i = 0;
				empl_id = textPane.getText().trim().toString();
				empl_name = textPane_1.getText().trim().toString();
				empl_department = textPane_2.getText().trim().toString();
				empl_position = Integer.parseInt(textPane_3.getText().trim());
				empl_salary = Float.parseFloat(textPane_4.getText().trim());
				empl_phoneNumber = textPane_5.getText().trim().toString();
				
				if(empl_id.length() == 0||empl_name.length() == 0||empl_department.length() == 0||
						textPane_3.getText().trim().length() == 0||textPane_4.getText().trim().length() == 0||
						empl_phoneNumber.length() == 0){
					JOptionPane.showMessageDialog(null,"任何一个条目不能为空！","操作失败!",JOptionPane.ERROR_MESSAGE);
			    	i = 1;			
				}
				if(!isDigit(textPane_3.getText().trim())&&textPane_3.getText().trim().length() != 0){
			    	{JOptionPane.showMessageDialog(null,"职位必须为数字！","操作失败!",JOptionPane.ERROR_MESSAGE);
			    	i = 1;
			    	}						
				}
				
				if(i == 0){
					epl.setEmpl_department(empl_department);
					epl.setEmpl_id(empl_id);
					epl.setEmpl_name(empl_name);
					epl.setEmpl_phoneNumber(empl_phoneNumber);
					epl.setEmpl_position(empl_position);
					epl.setEmpl_salary(empl_salary);
					
					ec.add(epl);
					
			    	JOptionPane.showMessageDialog(null,"添加成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		button.setBounds(86, 201, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u7EE7\u7EED\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textPane_1.setText("");
				textPane_2.setText("");
				textPane_3.setText("");
				textPane_4.setText("");
				textPane_5.setText("");
				
			}
		});
		button_1.setBounds(218, 201, 93, 23);
		frame.getContentPane().add(button_1);
		

	}
}
