package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.module2.IniAccount;
import view.module2.IniGoods;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	public JFrame frame;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main(1);
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(window.frame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public Main(int i) {
		initialize(i);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final int i) {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u7840\u4FE1\u606F\u7BA1\u7406");//������Ϣ����
		menuBar.add(menu);
		
		JMenuItem menuItem_12 = new JMenuItem("\u8FDB\u5165");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 0){
					try {
						Module1 mol1 = new Module1();
						mol1.frame.setVisible(true);
						mol1.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);	
				}				
			}
		});
		menu.add(menuItem_12);		
		
		JMenu menu_1 = new JMenu("\u521D\u59CB\u5316\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u521D\u59CB\u5316\u5546\u54C1\u5E93\u5B58");//��ʼ����Ʒ���
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 1){
					try {
						IniGoods mol1 = new IniGoods();
						mol1.frame.setVisible(true);
						mol1.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		menu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u521D\u59CB\u5316\u94F6\u884C\u8D26\u6237");//��ʼ�������˻�
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 1){
					try {
						IniAccount mol1 = new IniAccount();
						mol1.frame.setVisible(true);
						mol1.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);	
				}
			}
		});
		menu_1.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6743\u9650\u7BA1\u7406");//Ȩ�޹���
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 6){
					try {
						AuthoManage win = new AuthoManage();
						win.frame.setVisible(true);
						win.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}					
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);						
				}
			}
		});
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u7528\u6237\u4FEE\u6539\u5BC6\u7801");//�û��޸�����
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					try {
						UpdatePsw window = new UpdatePsw();
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				
				
			}
		});
		menu_2.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u73B0\u91D1\u7BA1\u7406");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u4ED8\u6B3E\u5355\u5F55\u5165");//���¼��
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 5){
					try {
						paymentView window = new paymentView();
						window.paymentFrame.setTitle("���");
						window.paymentFrame.setVisible(true);
						window.paymentFrame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		menu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5BA2\u6237\u5BF9\u8D26\u5355");//�ͻ����˵�
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 5){
					 try {
				            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				        } catch (Throwable e1) {
				            e1.printStackTrace();
				        }
				        EventQueue.invokeLater(new Runnable() {
				            public void run() {
				                try {
				                	checkMenuByCustomer frame = new checkMenuByCustomer();
				                    frame.setVisible(true);
				                    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
				                } catch (Exception e) {
				                    e.printStackTrace();
				                }
				            }
				        });				
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("\u8D44\u91D1\u62A5\u8868\u67E5\u8BE2");//�ʽ𱨱��ѯ
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 5){
					try {
						capitalReportView window = new capitalReportView();
						window.frame.setTitle("���");
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		menu_3.add(menuItem_6);
		
		JMenuItem menuItem_13 = new JMenuItem("\u6536\u6B3E\u5355\u5F55\u5165");//�տ¼��
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 5){
					try {
						receiveMenuView window = new receiveMenuView();
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		menu_3.add(menuItem_13);
		
		JMenu menu_4 = new JMenu("\u8FDB\u8D27\u7BA1\u7406");
		menuBar.add(menu_4);
		
		JMenuItem menuItem_7 = new JMenuItem("\u8FDB\u8D27\u5355\u5F55\u5165");//������¼��
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 2){
					try {
						purchaseView2 window = new purchaseView2();
						window.frame.setTitle("������");
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		menu_4.add(menuItem_7);
		
		JMenu menu_5 = new JMenu("\u9500\u552E\u7BA1\u7406");
		menuBar.add(menu_5);
		
		JMenuItem menuItem_8 = new JMenuItem("\u9500\u552E\u5355\u5F55\u5165");//���۵�¼��
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 3){
					try {
						sellingListView window = new sellingListView();
						window.frame.setTitle("���۵�");
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);				
				}
			}
		});
		menu_5.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("\u51FA\u8D27\u5355");//������
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 3){
					try {
						saleView window = new saleView();
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		menu_5.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u62A5\u4EF7\u5355");//���۵�
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 3){
					try {
						quotationView window = new quotationView();
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		menu_5.add(menuItem_10);
		
		JMenu menu_6 = new JMenu("\u5E93\u5B58\u7BA1\u7406");
		menuBar.add(menu_6);
		
		JMenuItem menuItem_11 = new JMenuItem("\u4ED3\u5E93\u8C03\u62E8");//�ֿ����
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i == 4){
					try {
						transferringListView window = new transferringListView();
						window.frame.setTitle("�ֿ������");
						window.frame.setVisible(true);
						window.frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"�޴�Ȩ�ޣ�","��ʾ",JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		menu_6.add(menuItem_11);
	}

}

