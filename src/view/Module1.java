package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import view.accountForModule1.AAdd;
import view.accountForModule1.ACheck;
import view.accountForModule1.ADelete;
import view.accountForModule1.AUpdate;
import view.busiUnitForModule1.Add;
import view.busiUnitForModule1.Check;
import view.busiUnitForModule1.Delete;
import view.busiUnitForModule1.Update;
import view.employeeForModule1.EAdd;
import view.employeeForModule1.ECheck;
import view.employeeForModule1.EDelete;
import view.employeeForModule1.EUpdate;
import view.goodsForModule1.GAdd;
import view.goodsForModule1.GCheck;
import view.goodsForModule1.GDelete;
import view.goodsForModule1.GUpdate;
import view.warehouseForModule1.WAdd;
import view.warehouseForModule1.WCheck;
import view.warehouseForModule1.WDelete;
import view.warehouseForModule1.WUpdate;


public class Module1 {

	public JFrame frame;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Module1 window = new Module1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public Module1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5F80\u6765\u5355\u4F4D\u4FE1\u606F\u7BA1\u7406");//往来单位信息
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u589E\u52A0");//增加
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Add window = new Add();
					window.frame.setVisible(true);
					//子窗口关闭后父窗口不关闭
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
		mnNewMenu.add(menuItem);
        //删除
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Delete window = new Delete();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}					
			}
		});
		mnNewMenu.add(menuItem_1);		
		//修改
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Update window = new Update();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		mnNewMenu.add(menuItem_2);	
		//查看
		JMenuItem menuItem_3 = new JMenuItem("\u67E5\u8BE2");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Check window = new Check();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		mnNewMenu.add(menuItem_3);	
		//
		JMenu menu = new JMenu("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem_4 = new JMenuItem("\u589E\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				GAdd window = new GAdd();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}					
			}
		});
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5220\u9664");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				GDelete window = new GDelete();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u4FEE\u6539");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				GUpdate window = new GUpdate();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}						
			}
		});
		menu.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u67E5\u8BE2");//商品查看
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				GCheck window = new GCheck();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu.add(menuItem_7);		
		
		//仓库
		JMenu menu_1 = new JMenu("\u4ED3\u5E93\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_8 = new JMenuItem("\u589E\u52A0");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				WAdd window = new WAdd();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
				
			}
		});
		menu_1.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("\u5220\u9664");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				WDelete window = new WDelete();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}					
			}
		});
		menu_1.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u4FEE\u6539");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				WUpdate window = new WUpdate();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu_1.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u67E5\u8BE2");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				WCheck window = new WCheck();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu_1.add(menuItem_11);		
		//银行账户
		JMenu menu_2 = new JMenu("\u94F6\u884C\u8D26\u6237\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_12 = new JMenuItem("\u589E\u52A0");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				AAdd window = new AAdd();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}					
				
			}
		});
		menu_2.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("\u5220\u9664");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ADelete window = new ADelete();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu_2.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("\u4FEE\u6539");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				AUpdate window = new AUpdate();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu_2.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("\u67E5\u8BE2");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ACheck window = new ACheck();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}					
			}
		});
		menu_2.add(menuItem_15);
		//员工
		JMenu menu_3 = new JMenu("\u5458\u5DE5\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_16 = new JMenuItem("\u589E\u52A0");
		menuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				EAdd window = new EAdd();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu_3.add(menuItem_16);
		
		JMenuItem menuItem_17 = new JMenuItem("\u5220\u9664");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				EDelete window = new EDelete();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}					
			}
		});
		menu_3.add(menuItem_17);
		
		JMenuItem menuItem_18 = new JMenuItem("\u4FEE\u6539");
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				EUpdate window = new EUpdate();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}					
			}
		});
		menu_3.add(menuItem_18);
		
		JMenuItem menuItem_19 = new JMenuItem("\u67E5\u8BE2");
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ECheck window = new ECheck();
				window.frame.setVisible(true);
				//子窗口关闭后父窗口不关闭
				window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
			} catch (Exception e1) {
				e1.printStackTrace();
			}				
			}
		});
		menu_3.add(menuItem_19);		
	}
}
