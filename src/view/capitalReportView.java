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
	// 填写窗口
	JFrame frame;
	
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();

	// 各种Jtext
	// 起始日期
	private JTextField startingDay;
	// 终止日期
	private JTextField endingDay;
	

	// controller capitalReportControl
	private capitalReportControl crc=new capitalReportControl();
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					capitalReportView window = new capitalReportView();
					window.frame.setTitle("付款单");
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
		// 获取本机屏幕大小
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		frame = new JFrame();
		// 界面的位置起始位置，width,height
		frame.setBounds(0, 0, screenSize.width / 2, screenSize.height * 2 / 3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(6, 0, 0, 0));

		// 付款单标题
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);

		JLabel title = new JLabel("资金报表");
		title.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(title);

		// 财务人员编号label和combox
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(30);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_1);

		JLabel financeWorker = new JLabel("财务人员编号");
		financeWorker.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(financeWorker);

		// 先创建财务人员
		if (crc.checkFinaceWorker().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建财务人员！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ArrayList<String> EmployeeIdChoose = new ArrayList<String>();
		EmployeeIdChoose = crc.checkFinaceWorker();
		comboBox.setEditable(true);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.addItem(EmployeeIdChoose);

		panel_1.add(comboBox);

		// 银行账号label和combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		frame.getContentPane().add(panel_2);

		JLabel account = new JLabel("银行账号");
		account.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_2.add(account);

		// 先创建银行账号！
		if (crc.checkAccount().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建银行账号！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		ArrayList<String> AcctNumChoose = new ArrayList<String>();
		AcctNumChoose = crc.checkAccount();
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox_1.addItem(AcctNumChoose);
		
		panel_2.add(comboBox_1);

		// 起始日期
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3= (FlowLayout) panel_3.getLayout();
		flowLayout_3.setVgap(10);
		flowLayout_3.setHgap(23);
		frame.getContentPane().add(panel_3);

		JLabel sname = new JLabel("起始日期");
		sname.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_3.add(sname);

		startingDay = new JTextField();
		startingDay.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_3.add(startingDay);
		
		
		startingDay.setColumns(20);
		
		
		// 终止日期
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4= (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setHgap(23);
		frame.getContentPane().add(panel_4);

		JLabel sname2 = new JLabel("终止日期");
		sname2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_4.add(sname2);

		endingDay = new JTextField();
		endingDay.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_4.add(endingDay);
		
		
		endingDay.setColumns(20);
		
		//开始查询
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(3);
		frame.getContentPane().add(panel_5);
		JButton add = new JButton("开始查询");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null,"请正确选定财务人员编号","操作失败!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(comboBox_1.getSelectedItem().toString().equals("")){
					JOptionPane.showMessageDialog(null,"请正确选定银行账户","操作失败!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				crc.setWorkerAndPermission(comboBox.getSelectedItem().toString());
				crc.checkAccountCapital(startingDay.getText(), endingDay.getText(), comboBox_1.getSelectedItem().toString());
				
				//报表窗口
				reportView report = new reportView(comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),crc.getInitialAmount(),crc.getEndAmount(),crc.getTotalIncome(),crc.getTotalExpend(),startingDay.getText(), endingDay.getText(),crc.getCapital());//分别将操作员，账户，期初资金，期末资金，总收入，总支出，具体明细等传入报表页
				
			}
		});
		
		add.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_5.add(add);
	}
}
