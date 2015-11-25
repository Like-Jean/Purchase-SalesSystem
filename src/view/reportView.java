package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import view.capitalReportView;
public class reportView {

	private JFrame frame;
	


	/**
	 * Create the application.
	 */
	public reportView(String employee,String account,String initialAmount,String endAmount,String totalIncome,String totalExpend,String startDate,String endDate,String capital) {
		
		initialize(employee,account,initialAmount,endAmount,totalIncome,totalExpend,startDate,endDate,capital);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String employee,String account,String initialAmount,String endAmount,String totalIncome,String totalExpend,String startDate,String endDate,String capital) {
		frame = new JFrame();
		frame.setBounds(100, 100, 344, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(10, 107, 308, 326);
		frame.getContentPane().add(textPane_1);
		textPane_1.setText("具体明细：\n"+capital);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBounds(10, 10, 195, 21);
		frame.getContentPane().add(textPane);
		textPane.setText("操作员："+employee);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEnabled(false);
		textPane_2.setEditable(false);
		textPane_2.setBounds(10, 41, 195, 21);
		frame.getContentPane().add(textPane_2);
		textPane_2.setText("银行账户："+account);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setEnabled(false);
		textPane_3.setBounds(10, 429, 129, 21);
		frame.getContentPane().add(textPane_3);
		textPane_3.setText("期初金额："+initialAmount);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setEnabled(false);
		textPane_4.setBounds(189, 429, 129, 21);
		frame.getContentPane().add(textPane_4);
		textPane_4.setText("期末金额："+endAmount);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setEditable(false);
		textPane_5.setEnabled(false);
		textPane_5.setBounds(10, 470, 117, 21);
		frame.getContentPane().add(textPane_5);
		textPane_5.setText("总收入："+totalIncome);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setEditable(false);
		textPane_6.setEnabled(false);
		textPane_6.setBounds(201, 470, 117, 21);
		frame.getContentPane().add(textPane_6);
		textPane_6.setText("总支出："+totalExpend);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setEnabled(false);
		textPane_7.setEditable(false);
		textPane_7.setBounds(10, 72, 143, 21);
		frame.getContentPane().add(textPane_7);
		textPane_7.setText("起始日期："+startDate);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setEnabled(false);
		textPane_8.setEditable(false);
		textPane_8.setBounds(175, 72, 143, 21);
		frame.getContentPane().add(textPane_8);
		textPane_8.setText("截止日期："+endDate);
	}
}
