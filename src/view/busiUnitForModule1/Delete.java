package view.busiUnitForModule1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.bussUnitControl;
import Entity.BusinessUnit;

public class Delete {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public Delete() {
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
		
		final bussUnitControl bc = new bussUnitControl();
		
		JLabel label = new JLabel("ID");
		label.setBounds(24, 27, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u540D\u79F0");//名称
		lblNewLabel.setBounds(198, 27, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(250, 27, 104, 21);
		frame.getContentPane().add(textPane_1);
		
		JLabel label_1 = new JLabel("\u6240\u5728\u5730\u533A");//所在地
		label_1.setBounds(10, 62, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(67, 58, 87, 19);
		frame.getContentPane().add(textPane_2);
		
		JLabel label_2 = new JLabel("\u5355\u4F4D\u6027\u8D28");//单位性质
		label_2.setBounds(181, 62, 54, 15);
		frame.getContentPane().add(label_2);
		
		final JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(250, 58, 104, 19);
		frame.getContentPane().add(textPane_3);
		
		JLabel label_3 = new JLabel("\u884C\u4E1A");//行业
		label_3.setBounds(24, 97, 54, 15);
		frame.getContentPane().add(label_3);
		
		final JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(67, 91, 87, 21);
		frame.getContentPane().add(textPane_4);
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u4EBA");//联系人
		label_4.setBounds(181, 97, 54, 15);
		frame.getContentPane().add(label_4);
		
		final JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(250, 87, 104, 25);
		frame.getContentPane().add(textPane_5);
		
		JLabel label_5 = new JLabel("\u5730\u5740");//地址
		label_5.setBounds(24, 125, 41, 15);
		frame.getContentPane().add(label_5);
		
		final JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(67, 122, 87, 21);
		frame.getContentPane().add(textPane_6);
		
		JLabel label_6 = new JLabel("\u4E3B\u8425\u4E1A\u52A1");//主营业务
		label_6.setBounds(181, 125, 54, 15);
		frame.getContentPane().add(label_6);
		
		final JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(250, 122, 104, 21);
		frame.getContentPane().add(textPane_7);
		
		JLabel label_7 = new JLabel("\u5F00\u6237\u884C");//开户行
		label_7.setBounds(10, 152, 54, 15);
		frame.getContentPane().add(label_7);
		
		final JTextPane textPane_8 = new JTextPane();
		textPane_8.setBounds(67, 153, 87, 21);
		frame.getContentPane().add(textPane_8);
		
		JLabel label_8 = new JLabel("\u94F6\u884C\u8D26\u53F7");//银行账号
		label_8.setBounds(181, 152, 54, 15);
		frame.getContentPane().add(label_8);
		
		final JTextPane textPane_9 = new JTextPane();
		textPane_9.setBounds(250, 153, 104, 21);
		frame.getContentPane().add(textPane_9);
		
		JLabel label_9 = new JLabel("\u624B\u673A\u53F7");//手机
		label_9.setBounds(10, 189, 54, 15);
		frame.getContentPane().add(label_9);
		
		final JTextPane textPane_10 = new JTextPane();
		textPane_10.setBounds(67, 184, 87, 20);
		frame.getContentPane().add(textPane_10);
		
		JLabel label_10 = new JLabel("\u90AE\u4EF6");//邮件
		label_10.setBounds(198, 189, 54, 15);
		frame.getContentPane().add(label_10);
		
		final JTextPane textPane_11 = new JTextPane();
		textPane_11.setBounds(250, 184, 104, 21);
		frame.getContentPane().add(textPane_11);	
		
		
		String[] IDChoose = new String[bc.getBussUnitId().size()];
		IDChoose = bc.getBussUnitId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);
		
		BusinessUnit bu = new BusinessUnit();
		bu = bc.findById((String)comboBox.getSelectedItem());
		
		textPane_1.setText(bu.getUnitName());
		textPane_2.setText(bu.getArea());
		textPane_3.setText(bu.getUnitNature());
		textPane_4.setText(bu.getTrade());
		textPane_5.setText(bu.getLinkman());
		textPane_6.setText(bu.getAddress());
		textPane_7.setText(bu.getMainBusiness());
		textPane_8.setText(bu.getBank());
		textPane_9.setText(bu.getAccountNum());
		textPane_10.setText(bu.getPhone());
		textPane_11.setText(bu.getMail());		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BusinessUnit bu = new BusinessUnit();
				bu = bc.findById((String)comboBox.getSelectedItem());
				
				textPane_1.setText(bu.getUnitName());
				textPane_2.setText(bu.getArea());
				textPane_3.setText(bu.getUnitNature());
				textPane_4.setText(bu.getTrade());
				textPane_5.setText(bu.getLinkman());
				textPane_6.setText(bu.getAddress());
				textPane_7.setText(bu.getMainBusiness());
				textPane_8.setText(bu.getBank());
				textPane_9.setText(bu.getAccountNum());
				textPane_10.setText(bu.getPhone());
				textPane_11.setText(bu.getMail());
			}
		});		
		comboBox.setBounds(67, 27, 87, 21);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("\u5220\u9664");//删除按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc.delBussUnit((String)comboBox.getSelectedItem());
				
				JOptionPane.showMessageDialog(null,"删除成功！","提示",JOptionPane.INFORMATION_MESSAGE);
				
				frame.dispose();
			}
		});		
		button.setBounds(142, 228, 93, 23);
		frame.getContentPane().add(button);
	}
}

