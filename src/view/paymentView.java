package view;
/*付款单*/
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
	// 填写窗口
	public JFrame paymentFrame;

	// 各种Jtext
	// 付款单号
	private JTextField paymentID;
	// 对应单据
	private JTextField matchingMenu;
	// 金额
	private JTextField totalPayment;
	// 用来记录Jtext
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
					window.paymentFrame.setTitle("付款单");
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
		// 获取本机屏幕大小
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		paymentFrame = new JFrame();
		// 界面的位置起始位置，width,height
		paymentFrame.setBounds(0, 0, screenSize.width / 2,
				screenSize.height * 2 / 3);
		paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paymentFrame.getContentPane().setLayout(new GridLayout(9, 0, 0, 0));

		// 付款单标题
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		paymentFrame.getContentPane().add(panel);

		JLabel title = new JLabel("付款单");
		title.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(title);

		// 付款单号的label和text
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setVgap(10);
		paymentFrame.getContentPane().add(panel_1);

		JLabel purNum = new JLabel("付款单号");
		purNum.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(purNum);

		paymentID = new JTextField();
		paymentID.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(paymentID);
		paymentID.setColumns(20);

		// 银行账号label和combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		paymentFrame.getContentPane().add(panel_2);

		JLabel account = new JLabel("银行账号");
		account.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_2.add(account);

		// 由于进货单把银行账号当成外键，所以必须先创建银行账号！
		if (pc.checkAcctNum().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建银行账号！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] AcctNumChoose = new String[pc.checkAcctNum().size()];
		AcctNumChoose = pc.checkAcctNum().toArray(AcctNumChoose);
		final JComboBox comboBox = new JComboBox(AcctNumChoose);
		comboBox.setEditable(true);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		panel_2.add(comboBox);

		// 往来单位label和combox
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setHgap(30);
		flowLayout_3.setVgap(10);
		paymentFrame.getContentPane().add(panel_3);

		JLabel unit = new JLabel("往来单位号");
		unit.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_3.add(unit);

		// 由于进货单把往来单位号当成外键，所以必须先往来单位号！
		if (pc.checkBsiUnitNum().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建往来单位号！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] BsUnitChoose = new String[pc.checkBsiUnitNum().size()];
		BsUnitChoose = pc.checkBsiUnitNum().toArray(BsUnitChoose);
		final JComboBox comboBox_1 = new JComboBox(BsUnitChoose);
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("宋体", Font.PLAIN, 18));

		panel_3.add(comboBox_1);

		// 财务人员编号label和combox
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setHgap(30);
		flowLayout_4.setVgap(10);
		paymentFrame.getContentPane().add(panel_4);

		JLabel financeWorker = new JLabel("财务人员编号");
		financeWorker.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_4.add(financeWorker);

		// 由于进货单把往来单位号当成外键，所以必须先往来单位号！
		if (pc.findEmployeeId().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建工作人员编号！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] EmployeeIdChoose = new String[pc.findEmployeeId().size()];
		EmployeeIdChoose = pc.findEmployeeId().toArray(EmployeeIdChoose);
		final JComboBox comboBox_2 = new JComboBox(EmployeeIdChoose);
		comboBox_2.setEditable(true);
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 18));

		panel_4.add(comboBox_2);

		// 对应单据
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(23);
		paymentFrame.getContentPane().add(panel_5);

		JLabel sname = new JLabel("对应单据号");
		sname.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_5.add(sname);

		matchingMenu = new JTextField();
		matchingMenu.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_5.add(matchingMenu);
		matchingMenu.setColumns(20);

		// 金额
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(10);
		flowLayout_6.setHgap(23);
		paymentFrame.getContentPane().add(panel_6);

		JLabel paymentAmount = new JLabel("金额");
		paymentAmount.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_6.add(paymentAmount);

		totalPayment = new JTextField();
		totalPayment.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_6.add(totalPayment);
		totalPayment.setColumns(20);

		// 提交单据按钮
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(3);
		paymentFrame.getContentPane().add(panel_7);
		JButton add = new JButton("提交付款单");
		add.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				int makeConfirm = JOptionPane.showConfirmDialog(null,
						"确认提交订单吗?", "确认", JOptionPane.YES_NO_OPTION);
				if (makeConfirm == JOptionPane.YES_OPTION) {
				i = 0;
				// 检测对应单据是否为空
				if (matchingMenu.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "对应单据不能为空", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}
				// 检测金额是否输入错误
				if (totalPayment.getText().trim().length() == 0
						|| !isDigit(totalPayment.getText().toString())) {
					JOptionPane.showMessageDialog(null, "商品价格填写错误", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				if (i == 0) {
					// 写入对应单据
					matchingMenuText = matchingMenu.getText().toString();
					// 写入金额
					if (Float.valueOf((totalPayment.getText().toString()))
							.floatValue() <= 0){
						JOptionPane.showMessageDialog(null, "商品价格不能为负数",
								"操作失败!", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					float price1 = Float.valueOf(
							(totalPayment.getText().toString())).floatValue();
					totalPaymentText = price1;
					
					//记录数据
					payment pay=new payment();
					// 检查付款单号是否为空
					if (paymentID.getText().trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "订单号不能为空", "操作失败!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					//写入付款单号
					pay.setPaymentId(paymentID.toString());
					
					//输入付款金额
					pc.setTotalPayment(totalPaymentText);
					// 检查账户余额是否足够	
					if (pc.checkBalance(comboBox.getSelectedItem().toString()) == false) {
						JOptionPane.showMessageDialog(null, "此账号余额不足", "操作失败!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					//写入银行账号，往来单位号
					pay.setAccId(comboBox.getSelectedItem().toString());
					pay.setUnitId(comboBox_1.getSelectedItem().toString());
					if(pc.checkOutPermissions(comboBox_2.getSelectedItem().toString())==false){
						JOptionPane.showMessageDialog(null, "只有财务部的人员才能进行此操作", "操作失败!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					//写入工作人员编号，对应单据号，金额
					pay.setFinanceWorker(comboBox_2.getSelectedItem().toString());
					pay.setMatchingMenu(matchingMenuText);
					pay.setTotalPayment(totalPaymentText);
					// 写入时间
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					pay.setPaymentDate(matter1.format(dt).toString());
					pc.pay();
				}

			}
			}
		});
		add.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_7.add(add);

		// 用一个jlabel来显示时间
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_10.getLayout();
		flowLayout_10.setVgap(10);
		paymentFrame.getContentPane().add(panel_10);

		JLabel time = new JLabel();
		Calendar date = Calendar.getInstance();
		time.setText("" + (date.get(Calendar.YEAR)) + "年"
				+ (date.get(Calendar.MONTH) + 1) + "月"
				+ date.get(Calendar.DATE) + "日");
		panel_10.add(time);
	}
}