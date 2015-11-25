package view;
/*���*/
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import Controller.paymentControl;
import Controller.purchaseControl;
import Entity.goodsList;
import Entity.payment;
import Entity.purchaseList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class paymentView {
	// ��д����
	public JFrame paymentFrame;

	// ����Jtext
	// �����
	private JTextField paymentID;
	// ��Ӧ����
	private JTextField matchingMenu;
	// ���
	private JTextField totalPayment;
	// ������¼Jtext
	public String matchingMenuText = new String();
	public float totalPaymentText;

	boolean isDigit(String strNum) {
		return strNum.matches("[0-9]{1,}");
	}

	// controller paymentControl
	private paymentControl pc = new paymentControl();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymentView window = new paymentView();
					window.paymentFrame.setTitle("���");
					window.paymentFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public paymentView() {
		initialize();
	}

	private void initialize() {
		// ��ȡ������Ļ��С
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		paymentFrame = new JFrame();
		// �����λ����ʼλ�ã�width,height
		paymentFrame.setBounds(0, 0, screenSize.width / 2,
				screenSize.height * 2 / 3);
		paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paymentFrame.getContentPane().setLayout(new GridLayout(9, 0, 0, 0));

		// �������
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		paymentFrame.getContentPane().add(panel);

		JLabel title = new JLabel("���");
		title.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(title);

		// ����ŵ�label��text
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setVgap(10);
		paymentFrame.getContentPane().add(panel_1);

		JLabel purNum = new JLabel("�����");
		purNum.setFont(new Font("����", Font.PLAIN, 22));
		panel_1.add(purNum);

		paymentID = new JTextField();
		paymentID.setFont(new Font("����", Font.PLAIN, 20));
		panel_1.add(paymentID);
		paymentID.setColumns(20);

		// �����˺�label��combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		paymentFrame.getContentPane().add(panel_2);

		JLabel account = new JLabel("�����˺�");
		account.setFont(new Font("����", Font.PLAIN, 22));
		panel_2.add(account);

		// ���ڽ������������˺ŵ�����������Ա����ȴ��������˺ţ�
		if (pc.checkAcctNum().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ��������˺ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] AcctNumChoose = new String[pc.checkAcctNum().size()];
		AcctNumChoose = pc.checkAcctNum().toArray(AcctNumChoose);
		final JComboBox comboBox = new JComboBox(AcctNumChoose);
		comboBox.setEditable(true);
		comboBox.setFont(new Font("����", Font.PLAIN, 18));
		panel_2.add(comboBox);

		// ������λlabel��combox
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setHgap(30);
		flowLayout_3.setVgap(10);
		paymentFrame.getContentPane().add(panel_3);

		JLabel unit = new JLabel("������λ��");
		unit.setFont(new Font("����", Font.PLAIN, 22));
		panel_3.add(unit);

		// ���ڽ�������������λ�ŵ�����������Ա�����������λ�ţ�
		if (pc.checkBsiUnitNum().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ���������λ�ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] BsUnitChoose = new String[pc.checkBsiUnitNum().size()];
		BsUnitChoose = pc.checkBsiUnitNum().toArray(BsUnitChoose);
		final JComboBox comboBox_1 = new JComboBox(BsUnitChoose);
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("����", Font.PLAIN, 18));

		panel_3.add(comboBox_1);

		// ������Ա���label��combox
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setHgap(30);
		flowLayout_4.setVgap(10);
		paymentFrame.getContentPane().add(panel_4);

		JLabel financeWorker = new JLabel("������Ա���");
		financeWorker.setFont(new Font("����", Font.PLAIN, 22));
		panel_4.add(financeWorker);

		// ���ڽ�������������λ�ŵ�����������Ա�����������λ�ţ�
		if (pc.findEmployeeId().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ���������Ա��ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] EmployeeIdChoose = new String[pc.findEmployeeId().size()];
		EmployeeIdChoose = pc.findEmployeeId().toArray(EmployeeIdChoose);
		final JComboBox comboBox_2 = new JComboBox(EmployeeIdChoose);
		comboBox_2.setEditable(true);
		comboBox_2.setFont(new Font("����", Font.PLAIN, 18));

		panel_4.add(comboBox_2);

		// ��Ӧ����
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(23);
		paymentFrame.getContentPane().add(panel_5);

		JLabel sname = new JLabel("��Ӧ���ݺ�");
		sname.setFont(new Font("����", Font.PLAIN, 22));
		panel_5.add(sname);

		matchingMenu = new JTextField();
		matchingMenu.setFont(new Font("����", Font.PLAIN, 20));
		panel_5.add(matchingMenu);
		matchingMenu.setColumns(20);

		// ���
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(10);
		flowLayout_6.setHgap(23);
		paymentFrame.getContentPane().add(panel_6);

		JLabel paymentAmount = new JLabel("���");
		paymentAmount.setFont(new Font("����", Font.PLAIN, 22));
		panel_6.add(paymentAmount);

		totalPayment = new JTextField();
		totalPayment.setFont(new Font("����", Font.PLAIN, 20));
		panel_6.add(totalPayment);
		totalPayment.setColumns(20);

		// �ύ���ݰ�ť
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(3);
		paymentFrame.getContentPane().add(panel_7);
		JButton add = new JButton("�ύ���");
		add.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				int makeConfirm = JOptionPane.showConfirmDialog(null,
						"ȷ���ύ������?", "ȷ��", JOptionPane.YES_NO_OPTION);
				if (makeConfirm == JOptionPane.YES_OPTION) {
				i = 0;
				// ����Ӧ�����Ƿ�Ϊ��
				if (matchingMenu.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "��Ӧ���ݲ���Ϊ��", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}
				// ������Ƿ��������
				if (totalPayment.getText().trim().length() == 0
						|| !isDigit(totalPayment.getText().toString())) {
					JOptionPane.showMessageDialog(null, "��Ʒ�۸���д����", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				if (i == 0) {
					// д���Ӧ����
					matchingMenuText = matchingMenu.getText().toString();
					// д����
					if (Float.valueOf((totalPayment.getText().toString()))
							.floatValue() <= 0){
						JOptionPane.showMessageDialog(null, "��Ʒ�۸���Ϊ����",
								"����ʧ��!", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					float price1 = Float.valueOf(
							(totalPayment.getText().toString())).floatValue();
					totalPaymentText = price1;
					
					//��¼����
					payment pay=new payment();
					// ��鸶����Ƿ�Ϊ��
					if (paymentID.getText().trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "�����Ų���Ϊ��", "����ʧ��!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					//д�븶���
					pay.setPaymentId(paymentID.toString());
					
					//���븶����
					pc.setTotalPayment(totalPaymentText);
					// ����˻�����Ƿ��㹻	
					if (pc.checkBalance(comboBox.getSelectedItem().toString()) == false) {
						JOptionPane.showMessageDialog(null, "���˺�����", "����ʧ��!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					//д�������˺ţ�������λ��
					pay.setAccId(comboBox.getSelectedItem().toString());
					pay.setUnitId(comboBox_1.getSelectedItem().toString());
					if(pc.checkOutPermissions(comboBox_2.getSelectedItem().toString())==false){
						JOptionPane.showMessageDialog(null, "ֻ�в��񲿵���Ա���ܽ��д˲���", "����ʧ��!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					//д�빤����Ա��ţ���Ӧ���ݺţ����
					pay.setFinanceWorker(comboBox_2.getSelectedItem().toString());
					pay.setMatchingMenu(matchingMenuText);
					pay.setTotalPayment(totalPaymentText);
					// д��ʱ��
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					pay.setPaymentDate(matter1.format(dt).toString());
					pc.pay();
				}

			}
			}
		});
		add.setFont(new Font("����", Font.PLAIN, 15));
		panel_7.add(add);

		// ��һ��jlabel����ʾʱ��
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_10.getLayout();
		flowLayout_10.setVgap(10);
		paymentFrame.getContentPane().add(panel_10);

		JLabel time = new JLabel();
		Calendar date = Calendar.getInstance();
		time.setText("" + (date.get(Calendar.YEAR)) + "��"
				+ (date.get(Calendar.MONTH) + 1) + "��"
				+ date.get(Calendar.DATE) + "��");
		panel_10.add(time);
	}
}