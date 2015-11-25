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

public class Add {

	public JFrame frame;
	private Module3Controller m3c = new Module3Controller();

	public Add() {
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
		lblid.setBounds(98, 33, 54, 15);
		frame.getContentPane().add(lblid);
		
		JLabel label = new JLabel("\u5BC6\u7801");//����
		label.setBounds(98, 77, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(161, 25, 104, 23);
		frame.getContentPane().add(textPane);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(162, 69, 103, 23);
		frame.getContentPane().add(textPane_1);		
		
		JLabel label_1 = new JLabel("\u6743\u9650");//Ȩ��
		label_1.setBounds(98, 120, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("������ϢȨ��");
		comboBox.addItem("��ʼ������Ȩ��");
		comboBox.addItem("��������Ȩ��");
		comboBox.addItem("���۹���Ȩ��");
		comboBox.addItem("������Ȩ��");
		comboBox.addItem("�ֽ����Ȩ��");
		//comboBox.addItem("ϵͳ����Ȩ��");
		comboBox.setBounds(162, 117, 103, 21);
		frame.getContentPane().add(comboBox);	
		
		JLabel lblid_1 = new JLabel("\u5458\u5DE5ID");//Ա��
		lblid_1.setBounds(98, 160, 54, 15);
		frame.getContentPane().add(lblid_1);
		
		String[] IDChoose = new String[m3c.getEplId().size()];
		IDChoose = m3c.getEplId().toArray(IDChoose);			
		final JComboBox comboBox_1 = new JComboBox(IDChoose);
		comboBox_1.setBounds(162, 157, 103, 21);
		frame.getContentPane().add(comboBox_1);		
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users us = new users();
				int i = 6;
				
				String select = (String)comboBox.getSelectedItem();
				us.setUsers_id(textPane.getText().trim());
				us.setUsers_psw(textPane_1.getText().trim());
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
				//	i = 6;				
				us.setUsers_authority(i);
				us.setEmpl_id((String)comboBox_1.getSelectedItem());
				
				m3c.add(us);
				
				JOptionPane.showMessageDialog(null,"��ӳɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);	
				frame.dispose();
			}
		});
		button.setBounds(161, 211, 93, 23);
		frame.getContentPane().add(button);
		


	}
}
