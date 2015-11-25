//销售单
package view;

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

import Controller.sellingListControl;
import Entity.sellingGoodsList;
import Entity.sellingList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class sellingListView {
	// 填写窗口
	public JFrame frame;

	// 各种Jtext
	// 销售单号
	private JTextField textField_sellingListId;
	// 商品价格
	private JTextField textField_goodsPrice;
	// 商品数量
	private JTextField textField_goodsQuantity;

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

	// controller sellingListControl
	private sellingListControl pc = new sellingListControl();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sellingListView window = new sellingListView();
					window.frame.setTitle("销售单");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public sellingListView() {
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

		// 商品的销售单标题
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);

		JLabel title = new JLabel("销售单");
		title.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(title);

		// 订单号的label和text
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_1);

		JLabel purNum = new JLabel("销售单号");
		purNum.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_1.add(purNum);

		textField_sellingListId = new JTextField();
		textField_sellingListId.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(textField_sellingListId);
		textField_sellingListId.setColumns(20);
		
		
		// 银行账号label和combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		frame.getContentPane().add(panel_2);

		
		JLabel account = new JLabel("银行账号");
		account.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_2.add(account);

		// 由于销售单把银行账号当成外键，所以必须先创建银行账号！
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

		// 由于销售单把往来单位号当成外键，所以必须先往来单位号！
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
		//商品ID
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setHgap(30);
		flowLayout_5.setVgap(10);
		frame.getContentPane().add(panel_5);

		JLabel productId = new JLabel("商品ID");
		productId.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_5.add(productId);
		
		if (pc.findProductId().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建商品！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] productIdChoose = new String[pc.findProductId().size()];
		productIdChoose = pc.findProductId().toArray(productIdChoose);
		final JComboBox comboBox_3 = new JComboBox(productIdChoose);
		comboBox_3.setEditable(true);
		comboBox_3.setFont(new Font("宋体", Font.PLAIN, 18));

		panel_5.add(comboBox_3);

		// 商品名称
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setHgap(30);
		flowLayout_4.setVgap(10);
		frame.getContentPane().add(panel_4);

		JLabel productName = new JLabel("商品名称");
		productName.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_4.add(productName);
		
		if (pc.findProductName().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建商品！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] productNameChoose = new String[pc.findProductName().size()];
		productNameChoose = pc.findProductName().toArray(productNameChoose);
		final JComboBox comboBox_2 = new JComboBox(productNameChoose);
		comboBox_2.setEditable(true);
		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 18));

		panel_4.add(comboBox_2);
		
		//商品仓库号
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setHgap(30);
		flowLayout_6.setVgap(10);
		frame.getContentPane().add(panel_6);

		JLabel productWareHouseId = new JLabel("仓库号");
		productWareHouseId.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_6.add(productWareHouseId);
		
		if (pc.checkWarhId().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建仓库号！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] productWareHouseIdChoose = new String[pc.checkWarhId().size()];
		productWareHouseIdChoose = pc.checkWarhId().toArray(productWareHouseIdChoose);
		final JComboBox comboBox_4 = new JComboBox(productWareHouseIdChoose);
		comboBox_4.setEditable(true);
		comboBox_4.setFont(new Font("宋体", Font.PLAIN, 18));

		panel_6.add(comboBox_4);
		// 商品价格
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(30);
		frame.getContentPane().add(panel_7);

		JLabel price = new JLabel("商品价格");
		price.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_7.add(price);

		textField_goodsPrice = new JTextField();
		textField_goodsPrice.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_7.add(textField_goodsPrice);
		textField_goodsPrice.setColumns(20);
		// 商品数量
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_8.getLayout();
		flowLayout_8.setVgap(10);
		flowLayout_8.setHgap(30);
		frame.getContentPane().add(panel_8);

		JLabel quantity = new JLabel("商品数量");
		quantity.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_8.add(quantity);

		textField_goodsQuantity = new JTextField();
		textField_goodsQuantity.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_8.add(textField_goodsQuantity);
		textField_goodsQuantity.setColumns(20);

		// 添加 商品按钮
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_9.getLayout();
		flowLayout_9.setVgap(10);
		flowLayout_9.setHgap(3);
		frame.getContentPane().add(panel_9);
		
		JButton add = new JButton("添加商品");
		add.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				i = 0;
				// 检测价格是否输入错误
				if (textField_goodsPrice.getText().trim().length() == 0
						|| !isDigit(textField_goodsPrice.getText().toString())) {
					JOptionPane.showMessageDialog(null, "商品价格填写错误", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// 检测商品数量是否输入错误
				if (textField_goodsQuantity.getText().trim().length() == 0
						|| !isDigit(textField_goodsQuantity.getText().toString())
						|| Integer.valueOf(textField_goodsQuantity.getText().toString())
								.intValue() <= 0) {
					JOptionPane.showMessageDialog(null, "商品数量填写错误", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				if (i == 0) {
					// 写入商品ID
					Goods_id[item] = comboBox_3.getSelectedItem().toString();

					// 写入商品名称
					Goods_name[item] = comboBox_2.getSelectedItem().toString();
					// 写入仓库ID
					warh_id[item] = comboBox_4.getSelectedItem().toString();
					// 写入价格
					if (Float.valueOf((textField_goodsPrice.getText().toString()))
							.floatValue() <= 0)
						JOptionPane.showMessageDialog(null, "商品价格不能为负数",
								"操作失败!", JOptionPane.ERROR_MESSAGE);
					float price1 = Float.valueOf(
							(textField_goodsPrice.getText().toString())).floatValue();
					prices[item] = price1;

					// 写入商品数量
					int quantity1 = Integer.valueOf(
							textField_goodsQuantity.getText().toString()).intValue();
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
				textField_goodsPrice.setText("");
				textField_goodsQuantity.setText("");

			}
		});
		addj.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_9.add(addj);
		// 提交销售单按钮
		JButton submit = new JButton("提交销售单");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int makeConfirm = JOptionPane.showConfirmDialog(null,
						"确认提交订单吗?", "确认", JOptionPane.YES_NO_OPTION);
				if (makeConfirm == JOptionPane.YES_OPTION) {
					//要实现controller的addPurh(sellingList sellingList,ArrayList<sellingGoodsList> gooLstArry)
					// 首先实现ArrayList<goodsList> gooLstArry
					ArrayList<sellingGoodsList> goodlist = new ArrayList<sellingGoodsList>();

					for (int i = 0; i < item; i++) {
						// 每次new一个goodlist的实例，记录用户输入关于good的信息,包括商品id，name，仓库id，价格，数量
						sellingGoodsList a = new sellingGoodsList();
						a.setGoods_id(Goods_id[i]);
						a.setGoods_name(Goods_name[i]);
						a.setWarh_id(warh_id[i]);
						a.setGoods_price(prices[i]);
						a.setGoods_quantity(quantitys[i]);
						a.setSellingList_id(textField_sellingListId.getText().toString());
						// 把商品add到goodlist当中
						goodlist.add(a);
						a = null;
					}
					// 实现sellingList slt
					sellingList slt = new sellingList();
					// 检查订单号是否为空
					if (textField_sellingListId.getText().trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "销售单号不能为空", "操作失败!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				
					// 写入订单号,银行账号，往来单位号
					slt.setSelling_id(textField_sellingListId.getText().toString());
					slt.setUnit_id(comboBox_1.getSelectedItem().toString());
					slt.setAcc_id(comboBox.getSelectedItem().toString());
					// 写入时间
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					slt.setSelling_date(matter1.format(dt).toString());
					pc.addPurh(slt, goodlist);
					item = 0;
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