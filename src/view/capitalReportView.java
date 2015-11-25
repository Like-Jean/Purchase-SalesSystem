package view;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import view.reportView;

import Entity.payment;
import Controller.capitalReportControl;
import Controller.paymentControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class capitalReportView {
	// ��д����
	JFrame frame;
	
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();

	// ����Jtext
	// ��ʼ����
	private JTextField startingDay;
	// ��ֹ����
	private JTextField endingDay;
	

	// controller capitalReportControl
	private capitalReportControl crc=new capitalReportControl();
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					capitalReportView window = new capitalReportView();
					window.frame.setTitle("���");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public capitalReportView() {
		initialize();
	}

	private void initialize() {
		// ��ȡ������Ļ��С
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		frame = new JFrame();
		// �����λ����ʼλ�ã�width,height
		frame.setBounds(0, 0, screenSize.width / 2, screenSize.height * 2 / 3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(6, 0, 0, 0));

		// �������
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);

		JLabel title = new JLabel("�ʽ𱨱�");
		title.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(title);

		// ������Ա���label��combox
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(30);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_1);

		JLabel financeWorker = new JLabel("������Ա���");
		financeWorker.setFont(new Font("����", Font.PLAIN, 22));
		panel_1.add(financeWorker);

		// �ȴ���������Ա
		if (crc.checkFinaceWorker().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ���������Ա��", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ArrayList<String> EmployeeIdChoose = new ArrayList<String>();
		EmployeeIdChoose = crc.checkFinaceWorker();
		comboBox.setEditable(true);
		comboBox.setFont(new Font("����", Font.PLAIN, 18));
		comboBox.addItem(EmployeeIdChoose);

		panel_1.add(comboBox);

		// �����˺�label��combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		frame.getContentPane().add(panel_2);

		JLabel account = new JLabel("�����˺�");
		account.setFont(new Font("����", Font.PLAIN, 22));
		panel_2.add(account);

		// �ȴ��������˺ţ�
		if (crc.checkAccount().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ��������˺ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ArrayList<String> AcctNumChoose = new ArrayList<String>();
		AcctNumChoose = crc.checkAccount();
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("����", Font.PLAIN, 18));
		comboBox_1.addItem(AcctNumChoose);
		
		panel_2.add(comboBox_1);

		// ��ʼ����
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3= (FlowLayout) panel_3.getLayout();
		flowLayout_3.setVgap(10);
		flowLayout_3.setHgap(23);
		frame.getContentPane().add(panel_3);

		JLabel sname = new JLabel("��ʼ����");
		sname.setFont(new Font("����", Font.PLAIN, 22));
		panel_3.add(sname);

		startingDay = new JTextField();
		startingDay.setFont(new Font("����", Font.PLAIN, 20));
		panel_3.add(startingDay);
		
		
		startingDay.setColumns(20);
		
		
		// ��ֹ����
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4= (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setHgap(23);
		frame.getContentPane().add(panel_4);

		JLabel sname2 = new JLabel("��ֹ����");
		sname2.setFont(new Font("����", Font.PLAIN, 22));
		panel_4.add(sname2);

		endingDay = new JTextField();
		endingDay.setFont(new Font("����", Font.PLAIN, 20));
		panel_4.add(endingDay);
		
		
		endingDay.setColumns(20);
		
		//��ʼ��ѯ
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(3);
		frame.getContentPane().add(panel_5);
		JButton add = new JButton("��ʼ��ѯ");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null,"����ȷѡ��������Ա���","����ʧ��!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(comboBox_1.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null,"����ȷѡ�������˻�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				crc.setWorkerAndPermission(comboBox.getSelectedItem().toString());
				crc.checkAccountCapital(startingDay.getText(), endingDay.getText(), comboBox_1.getSelectedItem().toString());
				
				//������
				reportView report = new reportView(comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),crc.getInitialAmount(),crc.getEndAmount(),crc.getTotalIncome(),crc.getTotalExpend(),startingDay.getText(), endingDay.getText(),crc.getCapital());//�ֱ𽫲���Ա���˻����ڳ��ʽ���ĩ�ʽ������룬��֧����������ϸ�ȴ��뱨��ҳ
				
			}
		});
		
		add.setFont(new Font("����", Font.PLAIN, 15));
		panel_5.add(add);
	}
}
