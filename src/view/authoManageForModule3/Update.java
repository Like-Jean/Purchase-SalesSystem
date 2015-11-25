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
import Entity.users;

public class Update {

	public JFrame frame;
	private Module3Controller m3c = new Module3Controller();
	

	public Update() {
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
	
		String[] IDChoose = new String[m3c.getUsId().size()];
		IDChoose = m3c.getUsId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);
		comboBox.setBounds(180, 43, 111, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblid = new JLabel("\u7528\u6237ID");
		lblid.setBounds(86, 46, 54, 15);
		frame.getContentPane().add(lblid);
		
		JLabel label = new JLabel("\u6743\u9650");
		label.setBounds(86, 91, 54, 15);
		frame.getContentPane().add(label);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("������ϢȨ��");
		comboBox_1.addItem("��ʼ������Ȩ��");
		comboBox_1.addItem("��������Ȩ��");
		comboBox_1.addItem("���۹���Ȩ��");
		comboBox_1.addItem("������Ȩ��");
		comboBox_1.addItem("�ֽ����Ȩ��");	
		//comboBox_1.addItem("ϵͳ����Ȩ��");
		comboBox_1.setBounds(180, 88, 111, 21);
		frame.getContentPane().add(comboBox_1);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users us = new users();
				int i = 6;
				
				us = m3c.findById((String)comboBox.getSelectedItem());
				String select = (String)comboBox_1.getSelectedItem();				
				if(select.equals("������ϢȨ��"))
					i = 0;
				else if(select.equals("��ʼ������Ȩ��"))
					i = 1;
				else if(select.equals("��������Ȩ��"))
					i = 2;
				else if(select.equals("���۹���Ȩ��"))
					i = 3;
				else if(select.equals("������Ȩ��"))
					i = 4;
				else if(select.equals("�ֽ����Ȩ��"))
					i = 5;		
				//else if(select.equals("ϵͳ����Ȩ��"))
					//i = 6;					
				
				us.setUsers_authority(i);
				
				m3c.update(us);
				JOptionPane.showMessageDialog(null,"�޸ĳɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);	
				frame.dispose();				
			}
		});
		button.setBounds(135, 167, 93, 23);
		frame.getContentPane().add(button);
		
	

	}
}

