package view;
/*添加报价单*/
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

import Entity.quotation;
import Entity.quotationGoodsList;
import Controller.quotationControl;

public class quotationView {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public String []Goods_id=new String[1000];
	public float []quotedprice=new float[1000];
	public int []quantitys=new int[1000];
	public float[]othercost=new float[1000];
	public  int item;
	
	
	quotationControl qc=new quotationControl();
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quotationView window = new quotationView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public quotationView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = kit.getScreenSize();  
		int screenWidth = screenSize.width;  
		int screenHeight = screenSize.height;
		frame = new JFrame();
		//界面的位置起始位置，width,height
		frame.setBounds(screenWidth /3, screenHeight/6, screenWidth /3,screenHeight*4/5 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(12, 0, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel);
		
		JLabel title = new JLabel("添加报价单");
		title.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.add(title);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setVgap(10);
		frame.getContentPane().add(panel_1);
		
		JLabel quoId = new JLabel("单号：");
		quoId.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(quoId);
		
		final JLabel quoId2 = new JLabel("New label");
		quoId2.setText(qc.getThisQuoId());
		quoId2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_1.add(quoId2);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(20);
		flowLayout_3.setVgap(10);
		frame.getContentPane().add(panel_2);
		
		JLabel unitId = new JLabel("客户ID:");
		unitId.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_2.add(unitId);
		
		
		
		String[] BsUnitChoose = new String[qc.checkBsiUnitNum().size()];
		BsUnitChoose = qc.checkBsiUnitNum().toArray(BsUnitChoose);
		final JComboBox comboBox = new JComboBox(BsUnitChoose);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_3.getLayout();
		flowLayout_4.setVgap(10);
		frame.getContentPane().add(panel_3);
		
		JLabel unitName = new JLabel("客户名称：");
		unitName.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_3.add(unitName);
		
		final JLabel unitName2 = new JLabel("");
		unitName2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_3.add(unitName2);
		
		JButton btnNewButton = new JButton("点击获取");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unitName2.setText(qc.getUNameById(comboBox.getSelectedItem().toString().trim()).trim());
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_4.getLayout();
		flowLayout_5.setVgap(10);
		frame.getContentPane().add(panel_4);
		
		JLabel handler = new JLabel("经手人：");
		handler.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_4.add(handler);
		
		
		
       String[] nameChoose = new String[qc.checkSaleName().size()];
		nameChoose = qc.checkSaleName().toArray(nameChoose);
        final JComboBox comboBox_1 = new JComboBox(nameChoose);
         panel_4.add(comboBox_1);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_5.getLayout();
		flowLayout_6.setVgap(10);
		frame.getContentPane().add(panel_5);
		
		JLabel remarks = new JLabel("备注：");
		remarks.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_5.add(remarks);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_6.getLayout();
		flowLayout_7.setVgap(10);
		frame.getContentPane().add(panel_6);
		
		JLabel goodId = new JLabel("商品ID:");
		goodId.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_6.add(goodId);
		
		
	       String[] goodsChoose = new String[qc.checkAllGood().size()];
			goodsChoose = qc.checkAllGood().toArray(goodsChoose);
	        final JComboBox comboBox_2 = new JComboBox(goodsChoose);
		    panel_6.add(comboBox_2);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_7.getLayout();
		flowLayout_8.setVgap(10);
		frame.getContentPane().add(panel_7);
		
		JLabel quantity = new JLabel("商品现有量：");
		quantity.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_7.add(quantity);
		
		final JLabel quantity2 = new JLabel("");
		quantity2.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_7.add(quantity2);
		
		JButton btnNewButton_1 = new JButton("点击获取");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				quantity2.setText( String.valueOf(qc.getQuantitybyId(comboBox_2.getSelectedItem().toString().trim())).trim());
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_7.add(btnNewButton_1);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_8.getLayout();
		flowLayout_9.setVgap(10);
		frame.getContentPane().add(panel_8);
		
		JLabel price = new JLabel("报价：");
		price.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_8.add(price);
		
		textField_1 = new JTextField();
		panel_8.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_9.getLayout();
		flowLayout_10.setVgap(10);
		frame.getContentPane().add(panel_9);
		
		JLabel other = new JLabel("其他金额：");
		other.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_9.add(other);
		
		textField_2 = new JTextField();
		panel_9.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel_10);
		
		JButton btnNewButton_2 = new JButton("添加商品");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Goods_id[item]=comboBox_2.getSelectedItem().toString().trim();
		    	   
	        	
	        		//写入报价
	    			float price1=Float.valueOf((textField_1.getText().toString())).floatValue();
	    			quotedprice[item]=price1;
	    			//写入其他金额
	    			float price2=Float.valueOf((textField_2.getText().toString())).floatValue();
	    			othercost[item]=price2;
	    			 
	              int quantity1=Integer.valueOf(quantity2.getText()).intValue();
	    			quantitys[item]=quantity1;
	item++;
				
			}
		});
		panel_10.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("继续添加");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantity2.setText("");
				textField_2.setText("");
				textField_1.setText("");
			}
		});
		panel_10.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("提交");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int n = JOptionPane.showConfirmDialog(frame.getContentPane(), "确认提交吗？",
			                "确认对话框", JOptionPane.OK_CANCEL_OPTION);
				  if(n==JOptionPane.YES_OPTION)
				  {
					  ArrayList<quotationGoodsList> quoGlistArry=new ArrayList<quotationGoodsList>();
				
				for(int i=0;i<item;i++)
				{	
					quotationGoodsList  a=new quotationGoodsList();
               a.setGoods_id(Goods_id[i]);
               a.setGoods_quantity(quantitys[i]);
               a.setQuotedPrice(quotedprice[i]);
               a.setOtherCost(othercost[i]);
               a.setQuoId(quoId2.getText().toString().trim());

               quoGlistArry.add(a);
				    a=null;
				}
				quotation quo=new quotation();
                  quo.setQuoId(quoId2.getText().toString().trim());
                  quo.setUnitId(comboBox.getSelectedItem().toString().trim());
                  quo.setUnitName(unitName2.getText().toString().trim());
                  quo.setHandler(comboBox_1.getSelectedItem().toString().trim());
                  quo.setRemarks(textField.getText().toString().trim());
				  Date dt=new Date();
				  SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
				  quo.setQuoDate(matter1.format(dt).toString());
              qc.addQuo(quo, quoGlistArry);
				  item=0;
				  }
			
				
				
				
			}
		});
		panel_10.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("取消");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel_10.add(btnNewButton_5);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_11.getLayout();
		flowLayout_11.setVgap(10);
		frame.getContentPane().add(panel_11);
		
		JLabel time = new JLabel("New label");
		 Calendar date = Calendar.getInstance();
			time.setText(""+(date.get(Calendar.YEAR))+"年"+(date.get(Calendar.MONTH)+1)+"月"+date.get(Calendar.DATE)+"日");
		time.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_11.add(time);
	}

}
