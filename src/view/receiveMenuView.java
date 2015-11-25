package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Entity.BusinessUnit;
import Entity.receiveMenu;
import Entity.sellList;
import Model.receiveMenuModel;
import Controller.receiveMenuControl;

public class receiveMenuView {

	public JFrame frame;
	private receiveMenuControl rc=new Controller.receiveMenuControl();
	

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receiveMenuView window = new receiveMenuView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public receiveMenuView() {
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
		frame.setBounds(screenSize.width/3,screenSize.height/6 , screenSize.width/3,screenSize.height*2/3 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(10, 0, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		frame.getContentPane().add(panel);
		
		JLabel title = new JLabel("收款单");
		title.setFont(new Font("宋体", Font.BOLD, 22));
		panel.add(title);
		
		JPanel panel1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel1.getLayout();
		flowLayout_1.setHgap(30);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel1);
		
		JLabel pbId = new JLabel("单号：");
		pbId.setFont(new Font("宋体", Font.PLAIN, 20));
		panel1.add(pbId);
		
		int ID=0;
		ArrayList<receiveMenu> M = new ArrayList<receiveMenu>();
		M=rc.getAllMenu();
		String Rid="";
		if(M.size()==0)
		{Rid="R"+"00001";}
		else{
		for (int j=0;j<M.size();j++)
		{
			receiveMenu r=(receiveMenu)M.get(j);
			Rid=r.getRecm_id();
			}
		Rid=Rid.trim();
		ID=Integer.parseInt(Rid.substring(Rid.length()-5));
		Rid="R"+String.format("%05d", ID+1);
		}
		
		final JLabel id = new JLabel(Rid);
		id.setFont(new Font("宋体", Font.PLAIN, 20));
		panel1.add(id);
		
		JPanel panel2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel2.getLayout();
		flowLayout_2.setHgap(10);
		flowLayout_2.setVgap(10);
		frame.getContentPane().add(panel2);
		
		JLabel purchaseId = new JLabel("对应单据：");
		panel2.add(purchaseId);
		purchaseId.setFont(new Font("宋体", Font.PLAIN, 20));
		
		// 对应单据为下拉菜单，所以必须先创建对应单据！
		if (rc.checkMatchingMenu().size() == 0) {
			JOptionPane.showMessageDialog(null, "请先创建对应单据！", "操作失败!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] menuChoose = new String[rc.checkMatchingMenu().size()];
		menuChoose = rc.checkMatchingMenu().toArray(menuChoose);
		final JComboBox comboBox_1 = new JComboBox(menuChoose);
		panel2.add(comboBox_1);
		
		JPanel panel3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel3.getLayout();
		flowLayout_3.setVgap(10);
		frame.getContentPane().add(panel3);
		
		JLabel unitid = new JLabel("客户ID:");
		panel3.add(unitid);
		unitid.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JLabel unitidlabel2 = new JLabel("");
		panel3.add(unitidlabel2);
		unitidlabel2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("点击获取");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellList sl=new sellList();
				sl=rc.showByMatchingMenu(comboBox_1.getSelectedItem().toString().trim());
				unitidlabel2.setText(sl.getUnit_id().trim());
				
			}
		});
		panel3.add(btnNewButton);
		
		JPanel panel4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel4.getLayout();
		flowLayout_4.setHgap(0);
		flowLayout_4.setVgap(10);
		frame.getContentPane().add(panel4);
		
		JLabel unitNamelabel = new JLabel("客户名称：");
		panel4.add(unitNamelabel);
		unitNamelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JLabel unitname = new JLabel("");
		panel4.add(unitname);
		unitname.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_1 = new JButton("点击获取");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellList sl=new sellList();
				BusinessUnit x=new BusinessUnit();
				sl=rc.showByMatchingMenu(comboBox_1.getSelectedItem().toString().trim());
				x=rc.findUnitById(sl.getUnit_id());
				unitname.setText(x.getUnitName().trim()); 
				
			}
		});
		panel4.add(btnNewButton_1);
		
		JPanel panel5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(10);
		frame.getContentPane().add(panel5);
		
		JLabel accountId = new JLabel("收款帐号：");
		panel5.add(accountId);
		accountId.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JLabel accountid2 = new JLabel("");
		panel5.add(accountid2);
		
		JButton btnNewButton_2 = new JButton("点击获取");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sellList sl=new sellList();
				sl=rc.showByMatchingMenu(comboBox_1.getSelectedItem().toString().trim());
				accountid2.setText(sl.getAcc_id().trim());
			}
		});
		panel5.add(btnNewButton_2);
		
		JPanel panel6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel6.getLayout();
		flowLayout_6.setVgap(10);
		frame.getContentPane().add(panel6);
		
		JLabel money = new JLabel("收款金额：");
		panel6.add(money);
		money.setFont(new Font("宋体", Font.PLAIN, 20));
		
		final JLabel money1 = new JLabel("");
		panel6.add(money1);
		
		JButton btnNewButton_3 = new JButton("点击获取");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellList sl=new sellList();
				sl=rc.showByMatchingMenu(comboBox_1.getSelectedItem().toString().trim());
				money1.setText(String.valueOf(sl.getSell_totalPrice()).trim());
			}
		});
		panel6.add(btnNewButton_3);
		
		JPanel panel7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel7.getLayout();
		flowLayout_7.setVgap(10);
		frame.getContentPane().add(panel7);
		
		JLabel handler = new JLabel("经手人：");
		panel7.add(handler);
		handler.setFont(new Font("宋体", Font.PLAIN, 20));
		
		// 经手人为下拉菜单，所以必须先创建对应单据！
				if (rc.checkFinanceName().size() == 0) {
					JOptionPane.showMessageDialog(null, "请先创建对应经手人！", "操作失败!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
		String[] nameChoose = new String[rc.checkFinanceName().size()];
		
		nameChoose = rc.checkFinanceName().toArray(nameChoose);

		final JComboBox comboBox_2 = new JComboBox(nameChoose);
		panel7.add(comboBox_2);
		
		JPanel panel8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel8.getLayout();
		flowLayout_8.setHgap(80);
		flowLayout_8.setVgap(10);
		frame.getContentPane().add(panel8);
		
		JButton submit = new JButton("提交");
		submit.setFont(new Font("宋体", Font.PLAIN, 15));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receiveMenu rec=new receiveMenu();
				sellList sl=new sellList();
				sl=rc.showByMatchingMenu(comboBox_1.getSelectedItem().toString().trim());
				rec.setRecm_id(id.getText().toString().trim());
				rec.setUnitId(sl.getUnit_id().trim());
				rec.setUnitName(unitname.getText().trim());
				rec.setMatchingMenu(comboBox_1.getSelectedItem().toString().trim());
				rec.setHandler(comboBox_2.getSelectedItem().toString().trim());
				rec.setAcc_id(accountid2.getText().trim());
				  Date dt=new Date();
				  SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
				rec.setRec_date(matter1.format(dt).toString());
				float m=Float.valueOf((money1.getText().toString())).floatValue();
				System.out.println(m);
				rec.setSell_totalPrice(m);
				
				rc.addRmenu(rec);
			}
		});
		panel8.add(submit);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancel.setFont(new Font("宋体", Font.PLAIN, 15));
		panel8.add(cancel);
		
		JPanel panel9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel9.getLayout();
		flowLayout_9.setVgap(10);
		frame.getContentPane().add(panel9);
		
		
		JLabel time = new JLabel("New label");
        Calendar date = Calendar.getInstance();
		time.setText(""+(date.get(Calendar.YEAR))+"年"+(date.get(Calendar.MONTH)+1)+"月"+date.get(Calendar.DATE)+"日");
		time.setFont(new Font("宋体", Font.PLAIN, 15));
		panel9.add(time);
		
		
	}

}