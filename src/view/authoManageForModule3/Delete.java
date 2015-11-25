package view.authoManageForModule3;

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
import Entity.goods;
import Entity.users;

public class Delete {

	public JFrame frame;
	private Module3Controller m3c = new Module3Controller();

	public Delete() {
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
		lblid.setBounds(89, 39, 54, 15);
		frame.getContentPane().add(lblid);
		
		String[] IDChoose = new String[m3c.getUsId().size()];
		IDChoose = m3c.getUsId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);
		
		comboBox.setBounds(170, 36, 132, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("\u6743\u9650");
		label.setBounds(89, 86, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(170, 86, 132, 21);
		frame.getContentPane().add(textPane);
		
		JLabel lblid_1 = new JLabel("\u5458\u5DE5ID");
		lblid_1.setBounds(89, 144, 54, 15);
		frame.getContentPane().add(lblid_1);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(170, 144, 132, 21);
		frame.getContentPane().add(textPane_1);
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		
				users us = new users();
				us = m3c.findById((String)comboBox.getSelectedItem());
				textPane_1.setText(us.getEmpl_id());
				int i = us.getUsers_authority();
				if(i == 0)
					textPane.setText("基础信息权限");
				else if(i == 1)
					textPane.setText("初始化管理权限");
				else if(i == 2)
					textPane.setText("进货管理权限");
				else if(i == 3)
					textPane.setText("销售管理权限");
				else if(i == 4)
					textPane.setText("库存管理权限");
				else if(i == 5)
					textPane.setText("现金管理权限");
				//else if(i == 6)
					//textPane.setText("系统管理权限");				
			}
		});			
		
		users us = new users();
		us = m3c.findById((String)comboBox.getSelectedItem());
		textPane_1.setText(us.getEmpl_id());
		int i = us.getUsers_authority();
		if(i == 0)
			textPane.setText("基础信息权限");
		else if(i == 1)
			textPane.setText("初始化管理权限");
		else if(i == 2)
			textPane.setText("进货管理权限");
		else if(i == 3)
			textPane.setText("销售管理权限");
		else if(i == 4)
			textPane.setText("库存管理权限");
		else if(i == 5)
			textPane.setText("现金管理权限");	
		//else if(i == 6)
			//textPane.setText("系统管理权限");		
		
		JButton button = new JButton("\u786E\u8BA4\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m3c.delete((String)comboBox.getSelectedItem());
				
				JOptionPane.showMessageDialog(null,"删除成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				
				frame.dispose();				
			}
		});
		button.setBounds(143, 204, 93, 23);
		frame.getContentPane().add(button);
		
	

	}
}