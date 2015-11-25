package view.module2;
/*@auther yixiu
 * 初始化商品库存数量
 * */
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

import Controller.Module2Controller;

public class IniGoods {

	public JFrame frame;
	private Module2Controller m2c = new Module2Controller();

	public IniGoods() {
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
		
		JLabel lblid = new JLabel("\u5546\u54C1ID");//商品
		lblid.setBounds(77, 32, 54, 15);
		frame.getContentPane().add(lblid);
		
		String[] IDChoose = new String[m2c.getGoodsId().size()];
		IDChoose = m2c.getGoodsId().toArray(IDChoose);
		final JComboBox comboBox = new JComboBox(IDChoose);
		final JComboBox comboBox_1 = new JComboBox();	
		final JTextPane textPane = new JTextPane();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String[] IDChoose = new String[m2c.getWareHouseId((String)comboBox.getSelectedItem()).size()];
				IDChoose = m2c.getWareHouseId((String)comboBox.getSelectedItem()).toArray(IDChoose);
				comboBox_1.removeAllItems();
				for(int j = 0;j<m2c.getWareHouseId((String)comboBox.getSelectedItem()).size();j++)
					comboBox_1.addItem(IDChoose[j]);
				textPane.setText(m2c.findNameByGoodsIdandWareId((String)comboBox.getSelectedItem(), IDChoose[0]));
			}
		});
		comboBox.setBounds(166, 29, 115, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel lblid_1 = new JLabel("\u4ED3\u5E93ID");//仓库
		lblid_1.setBounds(77, 77, 54, 15);
		frame.getContentPane().add(lblid_1);
		

	/*	comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textPane.setText(m2c.findNameByGoodsIdandWareId((String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem()));
			}
		});*/
		comboBox_1.setBounds(166, 74, 115, 21);
		frame.getContentPane().add(comboBox_1);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D");//名
		label.setBounds(77, 119, 54, 15);
		frame.getContentPane().add(label);
		

		textPane.setBounds(166, 119, 115, 21);
		frame.getContentPane().add(textPane);
		
		JLabel label_1 = new JLabel("\u521D\u59CB\u5316\u5E93\u5B58");//数量
		label_1.setBounds(77, 166, 66, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(166, 166, 115, 21);
		frame.getContentPane().add(textPane_1);
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			int t;
			public void actionPerformed(ActionEvent e) {
				t = 0;
				if(comboBox.getSelectedItem().toString().trim().length() == 0 ||
						comboBox_1.getSelectedItem().toString().trim().length() == 0 ||
						textPane_1.getText().trim().length() == 0){
					t = 1;
					JOptionPane.showMessageDialog(null,"任何条目不能为空！","操作失败!",JOptionPane.ERROR_MESSAGE);
				}
				if(t == 0 && !isDigit(textPane_1.getText().trim())){
					t = 1;
					JOptionPane.showMessageDialog(null,"数量必须为数字！","操作失败!",JOptionPane.ERROR_MESSAGE);
				}
				if(t == 0){
					m2c.increase((String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem(), Integer.parseInt(textPane_1.getText().trim()));
					JOptionPane.showMessageDialog(null,"初始化成功！","提示",JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
			}
		});		
		button.setBounds(135, 213, 93, 23);
		frame.getContentPane().add(button);
		

	}
}
