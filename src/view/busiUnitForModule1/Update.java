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

public class Update {

	public JFrame frame;
	private String unitId;
	private String unitName;
	private String unitNature;//��λ����
    private String area;
    private String trade;//��ҵ
    private String linkman;//��ϵ��
    private String address;
    private String bank;
    private String accountNum;//�ʺ�
    private String phone;
    private String mail;
    private String mainBusiness;//��Ӫҵ��
    
    private BusinessUnit bu = new BusinessUnit();
	/**
	 * Create the application.
	 */
	public Update() {
		initialize();
	}
	//�ж�һ���ַ����Ƿ�Ϊ����  
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
		
		final bussUnitControl bc = new bussUnitControl();
		
		JLabel label = new JLabel("ID");
		label.setBounds(24, 27, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u540D\u79F0");//����
		lblNewLabel.setBounds(198, 27, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		final JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(250, 27, 104, 21);
		frame.getContentPane().add(textPane_1);
		
		JLabel label_1 = new JLabel("\u6240\u5728\u5730\u533A");//���ڵ�
		label_1.setBounds(10, 62, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(67, 58, 87, 19);
		frame.getContentPane().add(textPane_2);
		
		JLabel label_2 = new JLabel("\u5355\u4F4D\u6027\u8D28");//��λ����
		label_2.setBounds(181, 62, 54, 15);
		frame.getContentPane().add(label_2);
		
		final JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(250, 58, 104, 19);
		frame.getContentPane().add(textPane_3);
		
		JLabel label_3 = new JLabel("\u884C\u4E1A");//��ҵ
		label_3.setBounds(24, 97, 54, 15);
		frame.getContentPane().add(label_3);
		
		final JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(67, 91, 87, 21);
		frame.getContentPane().add(textPane_4);
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u4EBA");//��ϵ��
		label_4.setBounds(181, 97, 54, 15);
		frame.getContentPane().add(label_4);
		
		final JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(250, 87, 104, 25);
		frame.getContentPane().add(textPane_5);
		
		JLabel label_5 = new JLabel("\u5730\u5740");//��ַ
		label_5.setBounds(24, 125, 41, 15);
		frame.getContentPane().add(label_5);
		
		final JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(67, 122, 87, 21);
		frame.getContentPane().add(textPane_6);
		
		JLabel label_6 = new JLabel("\u4E3B\u8425\u4E1A\u52A1");//��Ӫҵ��
		label_6.setBounds(181, 125, 54, 15);
		frame.getContentPane().add(label_6);
		
		final JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(250, 122, 104, 21);
		frame.getContentPane().add(textPane_7);
		
		JLabel label_7 = new JLabel("\u5F00\u6237\u884C");//������
		label_7.setBounds(10, 152, 54, 15);
		frame.getContentPane().add(label_7);
		
		final JTextPane textPane_8 = new JTextPane();
		textPane_8.setBounds(67, 153, 87, 21);
		frame.getContentPane().add(textPane_8);
		
		JLabel label_8 = new JLabel("\u94F6\u884C\u8D26\u53F7");//�����˺�
		label_8.setBounds(181, 152, 54, 15);
		frame.getContentPane().add(label_8);
		
		final JTextPane textPane_9 = new JTextPane();
		textPane_9.setBounds(250, 153, 104, 21);
		frame.getContentPane().add(textPane_9);
		
		JLabel label_9 = new JLabel("\u624B\u673A\u53F7");//�ֻ�
		label_9.setBounds(10, 189, 54, 15);
		frame.getContentPane().add(label_9);
		
		final JTextPane textPane_10 = new JTextPane();
		textPane_10.setBounds(67, 184, 87, 20);
		frame.getContentPane().add(textPane_10);
		
		JLabel label_10 = new JLabel("\u90AE\u4EF6");//�ʼ�
		label_10.setBounds(198, 189, 54, 15);
		frame.getContentPane().add(label_10);
		
		final JTextPane textPane_11 = new JTextPane();
		textPane_11.setBounds(250, 184, 104, 21);
		frame.getContentPane().add(textPane_11);	
		
		
		String[] IDChoose = new String[bc.getBussUnitId().size()];
		IDChoose = bc.getBussUnitId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);	
		
		BusinessUnit bus = new BusinessUnit();
		bus = bc.findById((String)comboBox.getSelectedItem());
		
		textPane_1.setText(bus.getUnitName());
		textPane_2.setText(bus.getArea());
		textPane_3.setText(bus.getUnitNature());
		textPane_4.setText(bus.getTrade());
		textPane_5.setText(bus.getLinkman());
		textPane_6.setText(bus.getAddress());
		textPane_7.setText(bus.getMainBusiness());
		textPane_8.setText(bus.getBank());
		textPane_9.setText(bus.getAccountNum());
		textPane_10.setText(bus.getPhone());
		textPane_11.setText(bus.getMail());		
		
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
		
		JButton button = new JButton("ȷ���޸�");//ɾ����ť
		button.addActionListener(new ActionListener() {
			int i;
			public void actionPerformed(ActionEvent e) {
				i = 0;
				
				//unitId = textPane.getText().trim().toString();
				unitName = textPane_1.getText().trim().toString();
				unitNature = textPane_3.getText().trim().toString();
			    area = textPane_2.getText().trim().toString();
			    trade = textPane_4.getText().trim().toString();
			    linkman = textPane_5.getText().trim().toString();
			    address = textPane_6.getText().trim().toString();
			    bank = textPane_8.getText().trim().toString();
			    accountNum = textPane_9.getText().trim().toString();
			    phone = textPane_10.getText().trim().toString();
			    mail = textPane_11.getText().trim().toString();
			    mainBusiness = textPane_7.getText().trim().toString();		
			    
			    if(unitName.length() == 0||unitNature.length() == 0||
			    		area.length() == 0||trade.length() == 0||linkman.length() == 0||
			    		address.length() == 0||bank.length() == 0||accountNum.length() == 0||
			    		phone.length() == 0||mail.length() == 0||mainBusiness.length() == 0)
			    	{JOptionPane.showMessageDialog(null,"�κ�һ����Ŀ����Ϊ��","����ʧ��!",JOptionPane.ERROR_MESSAGE);
			    	i = 1;
			    	}
			    
			    if(!isDigit(accountNum)&&accountNum.length()!=0)
		    	{JOptionPane.showMessageDialog(null,"�����˻�����Ϊ���֣�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
		    	i = 1;
		    	}
			    if(!isDigit(phone)&&phone.length()!=0)
		    	{JOptionPane.showMessageDialog(null,"�ֻ��ű���Ϊ���֣�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
		    	i = 1;
		    	}			    
			    if(i == 0){
			    	bu.setAccountNum(accountNum);
			    	bu.setAddress(address);
			    	bu.setArea(area);
			    	bu.setBank(bank);
			    	bu.setLinkman(linkman);
			    	bu.setMail(mail);
			    	bu.setMainBusiness(mainBusiness);
			    	bu.setPhone(phone);
			    	bu.setTrade(trade);
			    	bu.setUnitId((String)comboBox.getSelectedItem());
			    	bu.setUnitName(unitName);
			    	bu.setUnitNature(unitNature);				
			    }
				bc.updateBu(bu);
				JOptionPane.showMessageDialog(null,"�޸ĳɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				
				frame.dispose();
			    
			}
		});
		button.setBounds(142, 228, 93, 23);
		frame.getContentPane().add(button);
	}
}
