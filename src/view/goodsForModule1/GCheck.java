package view.goodsForModule1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import Controller.goodsControl;
import Entity.goods;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GCheck {

	public JFrame frame;
    
    private goodsControl gc = new goodsControl();


	public GCheck() {
		initialize();
	}
	//判断一个字符串是否都为数字  
	boolean isDigit(String strNum) {  
		    return strNum.matches("[0-9]{1,}");  
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5546\u54C1ID");
		label.setBounds(10, 27, 54, 15);
		frame.getContentPane().add(label);
		
		String[] IDChoose = new String[gc.getGoodsId().size()];
		IDChoose = gc.getGoodsId().toArray(IDChoose);		
		final JComboBox comboBox_2 = new JComboBox(IDChoose);//商品ID		
		
		JLabel lblNewLabel = new JLabel("\u4ED3\u5E93ID");//仓库ID
		lblNewLabel.setBounds(181, 27, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0");//名称
		label_1.setBounds(10, 62, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(67, 58, 87, 19);
		frame.getContentPane().add(textPane_2);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u7C7B\u522B");//类别
		label_2.setBounds(181, 62, 54, 15);
		frame.getContentPane().add(label_2);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(250, 56, 104, 21);
		frame.getContentPane().add(textPane);			
		
		JLabel label_3 = new JLabel("\u5E93\u5B58\u4E0A\u9650");//上限
		label_3.setBounds(10, 97, 54, 15);
		frame.getContentPane().add(label_3);
		
		final JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(67, 91, 87, 21);
		frame.getContentPane().add(textPane_4);
		
		JLabel label_4 = new JLabel("\u5E93\u5B58\u4E0B\u9650");//下限
		label_4.setBounds(181, 97, 54, 15);
		frame.getContentPane().add(label_4);
		
		final JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(250, 87, 104, 25);
		frame.getContentPane().add(textPane_5);
		
		JLabel label_5 = new JLabel("\u6210\u672C\u4EF7");//成本
		label_5.setBounds(10, 128, 41, 15);
		frame.getContentPane().add(label_5);
		
		final JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(67, 122, 87, 21);
		frame.getContentPane().add(textPane_6);
		
		JLabel label_6 = new JLabel("\u9884\u552E\u4EF7");//预售价
		label_6.setBounds(181, 125, 54, 15);
		frame.getContentPane().add(label_6);
		
		final JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(250, 122, 104, 21);
		frame.getContentPane().add(textPane_7);
		
		JLabel label_7 = new JLabel("\u751F\u4EA7\u5382\u5BB6");//厂家
		label_7.setBounds(10, 152, 54, 15);
		frame.getContentPane().add(label_7);
		
		final JTextPane textPane_8 = new JTextPane();
		textPane_8.setBounds(67, 153, 87, 21);
		frame.getContentPane().add(textPane_8);
		
		JLabel label_8 = new JLabel("\u5546\u54C1\u578B\u53F7");//型号
		label_8.setBounds(181, 152, 54, 15);
		frame.getContentPane().add(label_8);
		
		final JTextPane textPane_9 = new JTextPane();
		textPane_9.setBounds(250, 153, 104, 21);
		frame.getContentPane().add(textPane_9);
		
		//通过商品号和仓库号来显示商品信息
		//仓库ID下拉框
		String[] WIDChoose = new String[gc.getWareHouseId((String)comboBox_2.getSelectedItem()).size()];
		WIDChoose = gc.getWareHouseId((String)comboBox_2.getSelectedItem()).toArray(WIDChoose);		
		final JComboBox comboBox = new JComboBox(WIDChoose);//仓库ＩＤ
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		
				goods good = new goods();
				good = gc.findByGoodsIdandWareId((String)comboBox_2.getSelectedItem(), (String)comboBox.getSelectedItem());
				
				textPane_2.setText(good.getGoods_name());
				textPane.setText(good.getGoods_category());
				textPane_4.setText(String.valueOf(good.getGoods_up()));
				textPane_5.setText(String.valueOf(good.getGoods_down()));
				textPane_6.setText(String.valueOf(good.getGoods_cost()));
				textPane_7.setText(String.valueOf(good.getGoods_prprice()));
				textPane_8.setText(good.getGoods_factory());
				textPane_9.setText(good.getGoods_version());
			}
		});		
		comboBox.setBounds(248, 24, 106, 21);
		frame.getContentPane().add(comboBox);
	
		goods good = new goods();
		good = gc.findByGoodsIdandWareId((String)comboBox_2.getSelectedItem(), (String)comboBox.getSelectedItem());
		
		textPane_2.setText(good.getGoods_name());
		textPane.setText(good.getGoods_category());
		textPane_4.setText(String.valueOf(good.getGoods_up()));
		textPane_5.setText(String.valueOf(good.getGoods_down()));
		textPane_6.setText(String.valueOf(good.getGoods_cost()));
		textPane_7.setText(String.valueOf(good.getGoods_prprice()));
		textPane_8.setText(good.getGoods_factory());
		textPane_9.setText(good.getGoods_version());		
		
	    
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				goods good = new goods();
				good = gc.findByGoodsIdandWareId((String)comboBox_2.getSelectedItem(), (String)comboBox.getSelectedItem());
				
				textPane_2.setText(good.getGoods_name());
				textPane.setText(good.getGoods_category());
				textPane_4.setText(String.valueOf(good.getGoods_up()));
				textPane_5.setText(String.valueOf(good.getGoods_down()));
				textPane_6.setText(String.valueOf(good.getGoods_cost()));
				textPane_7.setText(String.valueOf(good.getGoods_prprice()));
				textPane_8.setText(good.getGoods_factory());
				textPane_9.setText(good.getGoods_version());
			}
		});
		comboBox_2.setBounds(67, 24, 87, 21);
		frame.getContentPane().add(comboBox_2);
		//显示截止到此
	


	}
	

}

