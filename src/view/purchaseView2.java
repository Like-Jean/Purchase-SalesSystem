package view;
/*进货单*/
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

import Controller.purchaseControl;
import Entity.goodsList;
import Entity.purchaseList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class purchaseView2 {
	// 填写窗口
	JFrame frame;

	// 各种Jtext
	// 订单号
	private JTextField textField;
	// 商品ID
	private JTextField textField_1;
	// 商品名称
	private JTextField textField_2;
	// 商品仓库号
	// private JTextField textField_3;
	// 商品价格
	private JTextField textField_4;
	// 商品数量
	private JTextField textField_5;

	// 下面这个订单号用来作为查看订单信息传入的参数
	public String dingdanhao;

	// 用来记录Jtext的String
	public String[] Goods_id = new String[1000];
	public String[] Goods_name = new String[1000];
	public String[] warh_id = new String[1000];
	public float[] prices = new float[1000];
	public int[] quantitys = new int[1000];
	// item用来记录增加商品类型的个数
	public int item;

	// 判断一个字符串是否都为数字
	boolean isDigit(String strNum) {
		return strNum.matches("[0-9]{1,}");
	}

	// controller purchaseControll
	private purchaseControl pc = new purchaseControl();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchaseView2 window = new purchaseView2();
					window.frame.setTitle("进货单");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public purchaseView2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	*/
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
		frame.getContentPane().setLayout(new GridLayout(11, 0, 0, 0));

		// 商品的进货单标题
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);

		JLabel title = new JLabel("进货单");
		title.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(title);

		// 订单号的label和text
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_1);

		JLabel purNum = new JLabel("订单号");
		purNum.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(purNum);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(20);
		
		
		// 银行账号label和combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		frame.getContentPane().add(panel_2);

		
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
		frame.getContentPane().add(panel_3);

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

		// 商品ID
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setHgap(45);
		frame.getContentPane().add(panel_4);

		JLabel sid = new JLabel("商品ID");
		sid.setHorizontalAlignment(SwingConstants.CENTER);
		sid.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_4.add(sid);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_4.add(textField_1);
		textField_1.setColumns(20);

		// 商品名称
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(23);
		frame.getContentPane().add(panel_5);

		JLabel sname = new JLabel("商品名称");
		sname.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_5.add(sname);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_5.add(textField_2);
		textField_2.setColumns(20);

		// 仓库号label和combox
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(10);
		flowLayout_6.setHgap(38);
		frame.getContentPane().add(panel_6);
		JLabel warh = new JLabel("仓库号");
		warh.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_6.add(warh);

		// 由于仓库表把仓库号当成主键，所以必须先创建仓库号！
		if (pc.checkWarhId().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建仓库号！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] warh_idChoose = new String[pc.checkWarhId().size()];
		warh_idChoose = pc.checkWarhId().toArray(AcctNumChoose);
		final JComboBox comboBoxwarh = new JComboBox(warh_idChoose);
		comboBoxwarh.setEditable(true);
		comboBoxwarh.setFont(new Font("宋体", Font.PLAIN, 18));
		panel_6.add(comboBoxwarh);

		// 商品价格
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(30);
		frame.getContentPane().add(panel_7);

		JLabel price = new JLabel("商品价格");
		price.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_7.add(price);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_7.add(textField_4);
		textField_4.setColumns(20);
		// 商品数量
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_8.getLayout();
		flowLayout_8.setVgap(10);
		flowLayout_8.setHgap(30);
		frame.getContentPane().add(panel_8);

		JLabel quantity = new JLabel("商品数量");
		quantity.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_8.add(quantity);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_8.add(textField_5);
		textField_5.setColumns(20);

		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_9.getLayout();
		flowLayout_9.setVgap(10);
		flowLayout_9.setHgap(3);
		frame.getContentPane().add(panel_9);
		// 添加 商品按钮
		JButton add = new JButton("添加商品");
		add.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				i = 0;
				// 检测商品ID是否为空
				if (textField_1.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "商品ID不能为空", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// 检测商品名称是否为空
				if (textField_2.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "商品名称不能为空", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// 检测价格是否输入错误
				if (textField_4.getText().trim().length() == 0
						|| !isDigit(textField_4.getText().toString())) {
					JOptionPane.showMessageDialog(null, "商品价格填写错误", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// 检测商品数量是否输入错误
				if (textField_5.getText().trim().length() == 0
						|| !isDigit(textField_5.getText().toString())
						|| Integer.valueOf(textField_5.getText().toString())
								.intValue() <= 0) {
					JOptionPane.showMessageDialog(null, "商品数量填写错误", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				if (i == 0) {// 写入商品ID
					Goods_id[item] = textField_1.getText().toString();

					// 写入商品名称
					Goods_name[item] = textField_2.getText().toString();
					// 写入仓库ID
					warh_id[item] = comboBoxwarh.getSelectedItem().toString();
					// 写入价格
					if (Float.valueOf((textField_5.getText().toString()))
							.floatValue() <= 0)
						JOptionPane.showMessageDialog(null, "商品价格不能为负数",
								"操作失败!", JOptionPane.ERROR_MESSAGE);
					float price1 = Float.valueOf(
							(textField_4.getText().toString())).floatValue();
					prices[item] = price1;

					// 写入商品数量
					int quantity1 = Integer.valueOf(
							textField_5.getText().toString()).intValue();
					quantitys[item] = quantity1;
					item++;

				}

			}
		});
		add.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_9.add(add);
		// 继续添加按钮
		JButton addj = new JButton("继续添加商品");
		addj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				textField_5.setText("");

			}
		});
		addj.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_9.add(addj);
		// 提交进货单按钮
		JButton submit = new JButton("提交进货单");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int makeConfirm = JOptionPane.showConfirmDialog(null,
						"确认提交订单吗?", "确认", JOptionPane.YES_NO_OPTION);
				if (makeConfirm == JOptionPane.YES_OPTION) {
					// 要实现controller的public boolean addPurh(purchaseList
					// prhLst,ArrayList<goodsList> gooLstArry)
					// 首先实现ArrayList<goodsList> gooLstArry
					ArrayList<goodsList> goodlist = new ArrayList<goodsList>();

					for (int i = 0; i < item; i++) {
						// 每次new一个goodlist的实例，记录用户输入关于good的信息,包括商品id，name，仓库id，价格，数量
						goodsList a = new goodsList();
						a.setGoods_id(Goods_id[i]);
						a.setGoods_name(Goods_name[i]);
						a.setWarh_id(warh_id[i]);
						a.setGoods_price(prices[i]);
						a.setGoods_quantity(quantitys[i]);
						a.setPurchase_id(textField.getText().toString());
						// 把商品add到goodlist当中
						goodlist.add(a);
						a = null;
					}
					// 实现purchaseList prhLst
					purchaseList purlist = new purchaseList();
					// 检查订单号是否为空
					if (textField.getText().trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "订单号不能为空", "操作失败!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					dingdanhao = textField.getText().toString();
					// 检查账户余额是否足够
					if (pc.checkBalance(comboBox.getSelectedItem().toString()) == false) {
						JOptionPane.showMessageDialog(null, "此账号余额不足", "操作失败!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					// 写入订单号,银行账号，往来单位号
					purlist.setPurch_id(textField.getText().toString());
					purlist.setUnit_id(comboBox_1.getSelectedItem().toString());
					purlist.setAcc_id(comboBox.getSelectedItem().toString());
					// 写入时间
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					purlist.setPurch_date(matter1.format(dt).toString());
					pc.addPurh(purlist, goodlist);
					item = 0;
				}
				int checkPurchase = JOptionPane.showConfirmDialog(null,
						"订单提交成功，需要查看吗?", "确认", JOptionPane.YES_NO_OPTION);
				if (checkPurchase == JOptionPane.YES_OPTION) {
					// 查看窗口
					frame.setVisible(false);
					JFrame checkFrame = new JFrame("本进货单信息");
					checkFrame.setBounds(100, 100, screenSize.width / 2,
							screenSize.height * 2 / 3);

					// layout的大小是showGoodsList(dingdanhao).size()和1个商品属性说明栏，外加1个主要信息，即+2
					checkFrame.getContentPane().setLayout(
							new GridLayout(
									pc.showGoodsList(dingdanhao).size() + 2, 0,
									0, 0));
					checkFrame
							.setDefaultCloseOperation(checkFrame.EXIT_ON_CLOSE);
					checkFrame.setVisible(true);

					// 订单主要信息

					JPanel MainInformationPanel = new JPanel();
					FlowLayout flowLayout_MainInformation = (FlowLayout) MainInformationPanel
							.getLayout();
					flowLayout_MainInformation.setVgap(10);
					flowLayout_MainInformation.setHgap(10);
					checkFrame.getContentPane().add(MainInformationPanel);

					// 订单号
					JLabel purchaseIdLabel = new JLabel("订单号");
					purchaseIdLabel.setFont(new Font("宋体", Font.PLAIN, 16));
					MainInformationPanel.add(purchaseIdLabel);
					JLabel purchaseIdtext = new JLabel(dingdanhao);
					purchaseIdtext.setFont(new Font("宋体", Font.PLAIN, 16));
					MainInformationPanel.add(purchaseIdtext);

					// 银行帐号
					JLabel AccountIdLabel = new JLabel("银行账号");
					AccountIdLabel.setFont(new Font("宋体", Font.PLAIN, 16));
					MainInformationPanel.add(AccountIdLabel);
					JLabel AccountIdText = new JLabel(pc.showPurchase(
							dingdanhao).getAcc_id());
					AccountIdText.setFont(new Font("宋体", Font.PLAIN, 16));
					MainInformationPanel.add(AccountIdText);

					// 往来单位号
					JLabel UnitIdLabel = new JLabel("往来单位号");
					UnitIdLabel.setFont(new Font("宋体", Font.PLAIN, 16));
					MainInformationPanel.add(UnitIdLabel);
					JLabel UnitIdText = new JLabel(pc.showPurchase(dingdanhao)
							.getUnit_id());
					UnitIdText.setFont(new Font("宋体", Font.PLAIN, 16));
					MainInformationPanel.add(UnitIdText);

					// 商品属性说明栏

					JPanel AttributeInformationPanel = new JPanel();
					FlowLayout flowLayout_AttributeInformation = (FlowLayout) AttributeInformationPanel
							.getLayout();
					flowLayout_AttributeInformation.setVgap(10);
					flowLayout_AttributeInformation.setHgap(15);
					checkFrame.getContentPane().add(AttributeInformationPanel);

					// 一栏5个属性说明
					JLabel productIdDescriptLabel = new JLabel("商品ID");
					productIdDescriptLabel.setFont(new Font("宋体", Font.PLAIN,
							22));
					AttributeInformationPanel.add(productIdDescriptLabel);

					JLabel productNameDescriptLabel = new JLabel("商品名称");
					productNameDescriptLabel.setFont(new Font("宋体", Font.PLAIN,
							22));
					AttributeInformationPanel.add(productNameDescriptLabel);

					JLabel warhIdDescriptLabel = new JLabel("仓库号");
					warhIdDescriptLabel.setFont(new Font("宋体", Font.PLAIN, 22));
					AttributeInformationPanel.add(warhIdDescriptLabel);

					JLabel productPriceDescriptLabel = new JLabel("商品价格");
					productPriceDescriptLabel.setFont(new Font("宋体",
							Font.PLAIN, 22));
					AttributeInformationPanel.add(productPriceDescriptLabel);

					JLabel productQuantityDescriptLabel = new JLabel("商品数量");
					productQuantityDescriptLabel.setFont(new Font("宋体",
							Font.PLAIN, 22));
					AttributeInformationPanel.add(productQuantityDescriptLabel);

					// 商品信息
					JPanel goodsinformationpanel[] = new JPanel[pc
							.showGoodsList(dingdanhao).size()];
					FlowLayout flowlayout_goodsinformation[] = new FlowLayout[pc
							.showGoodsList(dingdanhao).size()];
					// 一个商品信息的数组，长度为5
					JLabel goodsinformationLabel[] = new JLabel[5];
					for (int i = 0; i < 5; i++)
						goodsinformationLabel[i] = new JLabel("");
					for (int i = 0; i < pc.showGoodsList(dingdanhao).size(); i++) {
						goodsinformationpanel[i] = new JPanel();
						flowlayout_goodsinformation[i] = (FlowLayout) goodsinformationpanel[i]
								.getLayout();
						flowlayout_goodsinformation[i].setVgap(10);
						flowlayout_goodsinformation[i].setHgap(15 + 2 * i);
						checkFrame.getContentPane().add(
								goodsinformationpanel[i]);
						// 商品5个信息
						for (int j = 0; j < 5; j++) {
							switch (j) {
							case 0: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_id());
								goodsinformationLabel[j].setFont(new Font("宋体",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 1: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_name());
								goodsinformationLabel[j].setFont(new Font("宋体",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 2: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getWarh_id());
								goodsinformationLabel[j].setFont(new Font("宋体",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 3: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_price()
										+ "");
								goodsinformationLabel[j].setFont(new Font("宋体",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 4: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_quantity()
										+ "");
								goodsinformationLabel[j].setFont(new Font("宋体",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							}
						}
					}
				}
			}
		});
		submit.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_9.add(submit);
		// 取消
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancel.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_9.add(cancel);

		// 用一个jlabel来显示时间
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_10.getLayout();
		flowLayout_10.setVgap(10);
		frame.getContentPane().add(panel_10);

		JLabel time = new JLabel();
		Calendar date = Calendar.getInstance();
		time.setText("" + (date.get(Calendar.YEAR)) + "年"
				+ (date.get(Calendar.MONTH) + 1) + "月"
				+ date.get(Calendar.DATE) + "日");
		panel_10.add(time);
	}

}
