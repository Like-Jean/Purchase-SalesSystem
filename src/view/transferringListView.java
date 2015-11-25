package view;
//仓库调拨单

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

import Controller.transferringListControl;
import Entity.payment;
import Entity.transferringList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
public class transferringListView {
	JFrame frame;

	// 各种Jtext
	// 仓库调拨单号
	private JTextField textField_transferringListId;
	// 商品数量
	private JTextField textField_goodsQuantity;
	
	// 用来记录Jtext
		public String  transferringListId= new String();
		public int goodsQuantity;
	// 判断一个字符串是否都为数字
		boolean isDigit(String strNum) {
			return strNum.matches("[0-9]{1,}");
		}
	private transferringListControl tc = new transferringListControl();
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transferringListView window = new transferringListView();
					window.frame.setTitle("仓库调拨单");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public transferringListView() {
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
				frame.setBounds(0, 0, screenSize.width / 2,
						screenSize.height * 2 / 3);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(new GridLayout(9, 0, 0, 0));
				
				// 调拨单标题
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setHgap(10);
				flowLayout.setVgap(10);
				frame.getContentPane().add(panel);

				JLabel title = new JLabel("仓库调拨单");
				title.setFont(new Font("宋体", Font.PLAIN, 25));
				panel.add(title);

				// 调拨单号的label和text
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
				flowLayout_1.setHgap(10);
				flowLayout_1.setVgap(10);
				frame.getContentPane().add(panel_1);

				JLabel purNum = new JLabel("调拨单号");
				purNum.setFont(new Font("宋体", Font.PLAIN, 22));
				panel_1.add(purNum);

				textField_transferringListId = new JTextField();
				textField_transferringListId.setFont(new Font("宋体", Font.PLAIN, 20));
				panel_1.add(textField_transferringListId);
				textField_transferringListId.setColumns(20);
				
				//商品名称label和combox
				JPanel panel_2 = new JPanel();
				FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
				flowLayout_2.setVgap(10);
				flowLayout_2.setHgap(10);
				frame.getContentPane().add(panel_2);

				JLabel productName = new JLabel("商品名称");
				productName.setFont(new Font("宋体", Font.PLAIN, 22));
				panel_2.add(productName);

				// 必须先创建商品！
				if (tc.findProductName().size()==0) {
					JOptionPane.showMessageDialog(null, "请先创建商品！", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				String[] productNameChoose = new String[tc.findProductName().size()];
				productNameChoose = tc.findProductName().toArray(productNameChoose);
				final JComboBox comboBox = new JComboBox(productNameChoose);
				comboBox.setEditable(true);
				comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
				panel_2.add(comboBox);
				
				//经手人
				JPanel panel_3 = new JPanel();
				FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
				flowLayout_3.setHgap(30);
				flowLayout_3.setVgap(10);
				frame.getContentPane().add(panel_3);

				JLabel  handler= new JLabel("经手人ID");
				handler.setFont(new Font("宋体", Font.PLAIN, 22));
				panel_3.add(handler);

				// 由于进货单把往来单位号当成外键，所以必须先往来单位号！
				if (tc.findEmployeeId().size() == 0) {
					JOptionPane.showMessageDialog(null, "请先创建经手人！", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				String[] EmployeeIdChoose = new String[tc.findEmployeeId().size()];
				EmployeeIdChoose = tc.findEmployeeId().toArray(EmployeeIdChoose);
				final JComboBox comboBox_2 = new JComboBox(EmployeeIdChoose);
				comboBox_2.setEditable(true);
				comboBox_2.setFont(new Font("宋体", Font.PLAIN, 18));

				panel_3.add(comboBox_2);
				
				//数量
				JPanel panel_4 = new JPanel();
				FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
				flowLayout_4.setVgap(10);
				flowLayout_4.setHgap(30);
				frame.getContentPane().add(panel_4);

				JLabel quantity = new JLabel("商品数量");
				quantity.setFont(new Font("宋体", Font.PLAIN, 22));
				panel_4.add(quantity);

				textField_goodsQuantity = new JTextField();
				textField_goodsQuantity.setFont(new Font("宋体", Font.PLAIN, 20));
				panel_4.add(textField_goodsQuantity);
				textField_goodsQuantity.setColumns(20);
				//调出仓库
				JPanel panel_5 = new JPanel();
				FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
				flowLayout_5.setVgap(10);
				flowLayout_5.setHgap(13);
				frame.getContentPane().add(panel_5);

				JLabel outWareHouse = new JLabel("调出仓库");
				outWareHouse.setFont(new Font("宋体", Font.PLAIN, 22));
				panel_5.add(outWareHouse);

				// 必须先创建仓库！
				if (tc.checkWarhId().size()==0) {
					JOptionPane.showMessageDialog(null, "请先创建仓库！", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				String[] outWareHouseChoose = new String[tc.checkWarhId().size()];
				outWareHouseChoose = tc.checkWarhId().toArray(outWareHouseChoose);
				final JComboBox comboBox_outWareHouse = new JComboBox(outWareHouseChoose);
				comboBox_outWareHouse.setEditable(true);
				comboBox_outWareHouse.setFont(new Font("宋体", Font.PLAIN, 18));
				panel_5.add(comboBox_outWareHouse);
				
				//调入仓库
				JPanel panel_6 = new JPanel();
				FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
				flowLayout_6.setVgap(10);
				flowLayout_6.setHgap(13);
				frame.getContentPane().add(panel_6);

				JLabel inWareHouse = new JLabel("调入仓库");
				inWareHouse.setFont(new Font("宋体", Font.PLAIN, 22));
				panel_6.add(inWareHouse);

				String[] inWareHouseChoose = new String[tc.checkWarhId().size()];
				inWareHouseChoose = tc.checkWarhId().toArray(inWareHouseChoose);
				final JComboBox comboBox_inWareHouse = new JComboBox(inWareHouseChoose);
				comboBox_inWareHouse.setEditable(true);
				comboBox_inWareHouse.setFont(new Font("宋体", Font.PLAIN, 18));
				panel_6.add(comboBox_inWareHouse);
				
				// 提交单据按钮
				JPanel panel_7 = new JPanel();
				FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
				flowLayout_7.setVgap(10);
				flowLayout_7.setHgap(3);
				frame.getContentPane().add(panel_7);
				JButton add = new JButton("提交调拨单");
				add.addActionListener(new ActionListener() {
					int i;

					public void actionPerformed(ActionEvent e) {
						int makeConfirm = JOptionPane.showConfirmDialog(null,
								"确认提交订单吗?", "确认", JOptionPane.YES_NO_OPTION);
						if (makeConfirm == JOptionPane.YES_OPTION) {
						i = 0;
						// 检测单据号是否为空
						if (textField_transferringListId.getText().trim().length() == 0) {
							JOptionPane.showMessageDialog(null, "对应单据不能为空", "操作失败!",
									JOptionPane.ERROR_MESSAGE);
							i++;
						}
						// 检测数量是否输入错误
						if (textField_goodsQuantity.getText().trim().length() == 0
								|| !isDigit(textField_goodsQuantity.getText().toString())) {
							JOptionPane.showMessageDialog(null, "商品数量填写错误", "操作失败!",
									JOptionPane.ERROR_MESSAGE);
							i++;
						}

						if (i == 0) {
							// 写入对应单据
							transferringListId = textField_transferringListId.getText().toString();
							// 写入数量
							if (Float.valueOf((textField_goodsQuantity.getText().toString()))
									.floatValue() <= 0){
								JOptionPane.showMessageDialog(null, "商品数量不能为负数",
										"操作失败!", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							int quantities = Integer.valueOf(
									(textField_goodsQuantity.getText().toString())).intValue();
							goodsQuantity = quantities;
							
							//记录数据
							transferringList list=new transferringList();
							//写入调拨单号
							list.setTransferringListId(transferringListId);
							//写入数量
							list.setQuantities(goodsQuantity);
							//检查改商品名称在改仓库中与用户输入的数量比较是否足够
							if(tc.enoughQuantities(list)==false){
								JOptionPane.showMessageDialog(null, "数量输入过大！！",
										"操作失败!", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							//写入调出仓库，调入仓库
							//如果两者相等，就报错
							if(comboBox_outWareHouse.getSelectedItem().toString()==comboBox_inWareHouse.getSelectedItem().toString()){
								JOptionPane.showMessageDialog(null, "调入仓库不能等于调出仓库",
										"操作失败!", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							list.setOutWarehouseId(comboBox_outWareHouse.getSelectedItem().toString());
							list.setInWarehouseId(comboBox_inWareHouse.getSelectedItem().toString());
							
							//写入经手人编号，商品名称
							list.setHandler(comboBox_2.getSelectedItem().toString());
							list.setGoods_name(comboBox.getSelectedItem().toString());
							// 写入时间
							Date dt = new Date();
							SimpleDateFormat matter1 = new SimpleDateFormat(
									"yyyy-MM-dd");
							list.setTransferringList_date(matter1.format(dt).toString());
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
				frame.getContentPane().add(panel_10);

				JLabel time = new JLabel();
				Calendar date = Calendar.getInstance();
				time.setText("" + (date.get(Calendar.YEAR)) + "年"
						+ (date.get(Calendar.MONTH) + 1) + "月"
						+ date.get(Calendar.DATE) + "日");
				panel_10.add(time);
	}
}
