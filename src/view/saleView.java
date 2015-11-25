package view;
/*�������۵�*/
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

import Entity.goods;
import Entity.sellGoodsList;
import Entity.sellList;
import Controller.purchaseControl;
import Controller.sellControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class saleView {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public String []Goods_id=new String[10];
	public String []Goods_name=new String[10];
	public String []warh_id=new String[10];
    public float []prices=new float[10];
	public int []quantitys=new int[10];
	public  int item;
	private sellControl sc = new sellControl();


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleView window = new saleView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 /* Create the application.
	 */
	public saleView() {
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
		//�����λ����ʼλ�ã�width,height
		frame.setBounds(screenSize.width/3, screenSize.height/6, screenSize.width/3,screenSize.height*2/3 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(11, 0, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);
		
		JLabel title = new JLabel("�������۵�");
		title.setFont(new Font("����", Font.BOLD, 22));
		panel.add(title);
		
		JPanel panel1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel1.getLayout();
		flowLayout_1.setHgap(60);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel1);
		
		JLabel sidlabel1 = new JLabel("������ID��      ");
		sidlabel1.setFont(new Font("����", Font.PLAIN, 20));
		panel1.add(sidlabel1);
		
		//ͨ����ȡ��ǰ�ĵ��ţ��Զ���ԭ������������1��Ϊ��������
		int ID=0;
		ArrayList<sellList> saleLists = new ArrayList<sellList>();
		saleLists=sc.getAllList();
		String Sid="";
		if(saleLists.size()==0)
		{Sid="S"+"00001";}
		else{
		for (int j=0;j<saleLists.size();j++)
		{
			sellList s=(sellList)saleLists.get(j);
			Sid=s.getSell_id();
			}
		Sid=Sid.trim();
		ID=Integer.parseInt(Sid.substring(Sid.length()-5));
		Sid="S"+String.format("%05d", ID+1);
		}
		
		
		final JLabel sidlabel2 = new JLabel(Sid);
		sidlabel2.setFont(new Font("����", Font.PLAIN, 20));
		panel1.add(sidlabel2);
		
		JPanel panel2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel2.getLayout();
		flowLayout_2.setHgap(60);
		flowLayout_2.setVgap(10);
		frame.getContentPane().add(panel2);
		
		JLabel unitid = new JLabel("������λ�ţ�   ");
		unitid.setFont(new Font("����", Font.PLAIN, 20));
		panel2.add(unitid);
		
		//��ѡ���ȡ������λ��
		String[] BsUnitChoose = new String[sc.checkBsiUnitNum().size()];
		BsUnitChoose = sc.checkBsiUnitNum().toArray(BsUnitChoose);
		final JComboBox comboBox = new JComboBox(BsUnitChoose);
	    panel2.add(comboBox);
		
		JPanel panel3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel3.getLayout();
		flowLayout_3.setHgap(20);
		flowLayout_3.setVgap(10);
		frame.getContentPane().add(panel3);
		
		JLabel account = new JLabel("�տ��ʺţ�         ");
		account.setFont(new Font("����", Font.PLAIN, 20));
		panel3.add(account);
		
		//��ѡ���ȡ�ʺ�
		String[] AcctNumChoose = new String[sc.checkAcctNum().size()];
		AcctNumChoose = sc.checkAcctNum().toArray(AcctNumChoose);
		final JComboBox comboBox_1 = new JComboBox(AcctNumChoose);
        panel3.add(comboBox_1);
		
		JPanel panel4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel4.getLayout();
		flowLayout_4.setHgap(30);
		flowLayout_4.setVgap(10);
		frame.getContentPane().add(panel4);
		
		JPanel panel6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel6.getLayout();
		flowLayout_6.setHgap(70);
		flowLayout_6.setVgap(10);
		frame.getContentPane().add(panel6);
		
		JLabel wid = new JLabel(" �ֿ�ţ�    ");
		wid.setFont(new Font("����", Font.PLAIN, 20));
		panel6.add(wid);
		
		//��ѡ���ȡ�ֿ��
		String[] warhNumChoose = new String[sc.checkWarhId().size()];
		warhNumChoose = sc.checkWarhId().toArray(warhNumChoose);
		final JComboBox comboBox_3 = new JComboBox(warhNumChoose);
		panel6.add(comboBox_3);
		
		JLabel gid = new JLabel("��ƷID:         ");
		gid.setFont(new Font("����", Font.PLAIN, 20));
		panel4.add(gid);
		
		
		String[] gidChoose = new String[sc.findAllId().size()];
		gidChoose = sc.findAllId().toArray(gidChoose);
		final JComboBox comboBox_2 = new JComboBox(gidChoose);
		panel4.add(comboBox_2);
		
		JPanel panel5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel5.getLayout();
		flowLayout_5.setVgap(10);
		frame.getContentPane().add(panel5);
		
		JLabel gnamelabel1 = new JLabel("��Ʒ����:");
		gnamelabel1.setFont(new Font("����", Font.PLAIN, 20));
		panel5.add(gnamelabel1);
		
		
		 final JLabel gnamelabel2 = new JLabel("������ȡ");
		gnamelabel2.setFont(new Font("����", Font.PLAIN, 20));
		panel5.add(gnamelabel2);
		
		//�����ť�Զ���ȡ����ѡ�����ƷID�Ͳֿ������Ӧ����Ʒ��
		JButton getName = new JButton("��ȡ��Ʒ��");
		panel5.add(getName);
		getName.setFont(new Font("����", Font.PLAIN, 15));
		getName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gname2=(sc.findByGidWid(comboBox_2.getSelectedItem().toString().trim(),comboBox_3.getSelectedItem().toString().trim())).getGoods_name();
				gnamelabel2.setText(gname2.trim());
			}
		});
		
		
		
		JPanel panel7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel7.getLayout();
		flowLayout_7.setHgap(20);
		flowLayout_7.setVgap(10);
		frame.getContentPane().add(panel7);
		
		JLabel quantity = new JLabel("��Ʒ������       ");
		quantity.setFont(new Font("����", Font.PLAIN, 20));
		panel7.add(quantity);
		
		textField = new JTextField();
		panel7.add(textField);
		textField.setColumns(10);
		
		JPanel panel8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel8.getLayout();
		flowLayout_8.setHgap(20);
		flowLayout_8.setVgap(10);
		frame.getContentPane().add(panel8);
		
		JLabel saleprice = new JLabel("��Ʒ�ۼۣ�       ");
		saleprice.setFont(new Font("����", Font.PLAIN, 20));
		panel8.add(saleprice);
		
		textField_1 = new JTextField();
		panel8.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel9.getLayout();
		flowLayout_9.setVgap(10);
		frame.getContentPane().add(panel9);
		
		JButton add = new JButton("�����Ʒ");
		add.addActionListener(new ActionListener() {
			int i;
			public void actionPerformed(ActionEvent e) {
				i=0;
				
        		//���۸��Ƿ�Ϊ��
        		if(textField_1.getText().trim().length()==0||Float.valueOf((textField_1.getText().toString())).floatValue()<=0)
        		{
        			JOptionPane.showMessageDialog(null,"��Ʒ�۸���Ϊ���Ҳ���С�ڵ���0","����ʧ��!",JOptionPane.ERROR_MESSAGE);
        			i++;
        		}

        		//�����Ʒ�����Ƿ�Ϊ���Ƿ񳬹����
        		if(textField.getText().trim().length()==0||
        				Integer.valueOf(textField.getText().toString()).intValue()<=0
        				||Integer.valueOf(textField.getText().toString()).intValue()>sc.findByGidWid(comboBox_2.getSelectedItem().toString().trim(),comboBox_3.getSelectedItem().toString().trim()).getGoods_quantity())
        		{
        			
        			JOptionPane.showMessageDialog(null,"��Ʒ��������Ϊ���Ҳ���С�ڵ���0����ڿ��","����ʧ��!",JOptionPane.ERROR_MESSAGE);
        		i++;
        		}
       if(i==0)
         {//д����ƷID
    	   Goods_id[item]=comboBox_2.getSelectedItem().toString().trim();
    	   
        		
    			//д����Ʒ����
    	      Goods_name[item]=(sc.findByGidWid(comboBox_2.getSelectedItem().toString().trim(),comboBox_3.getSelectedItem().toString().trim())).getGoods_name();
    			//д��ֿ�ID
    			warh_id[item]=comboBox_3.getSelectedItem().toString().trim();
        		//д�����ۼ۸�
    			float price1=Float.valueOf((textField_1.getText().toString())).floatValue();
    			prices[item]=price1;
    			
    			

        		//д����Ʒ����
    			int quantity1=Integer.valueOf(textField.getText().toString()).intValue();
    			quantitys[item]=quantity1;
item++;
				
			}
			}
		});
		add.setFont(new Font("����", Font.PLAIN, 15));
		panel9.add(add);
		
		JButton addj = new JButton("�������");
		addj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		addj.setFont(new Font("����", Font.PLAIN, 15));
		panel9.add(addj);
		
		JButton submit = new JButton("�ύ");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int n = JOptionPane.showConfirmDialog(frame.getContentPane(), "ȷ���ύ��",
			                "ȷ�϶Ի���", JOptionPane.OK_CANCEL_OPTION);
				  if(n==JOptionPane.YES_OPTION)
				  {
					  ArrayList<sellGoodsList> selGLstArry=new ArrayList<sellGoodsList>();
				
				for(int i=0;i<item;i++)
				{	
					sellGoodsList  a=new sellGoodsList();
                a.setGoods_id(Goods_id[i]);
				a.setGoods_name(Goods_name[i]);
				a.setWarh_id(warh_id[i]);
				a.setGoods_price(prices[i]);
				a.setGoods_quantity(quantitys[i]);
				a.setSell_id(sidlabel2.getText().toString());
				selGLstArry.add(a);
				    a=null;
				}
				sellList selllist=new sellList();
				selllist.setSell_id(sidlabel2.getText().toString().trim());
				selllist.setUnit_id(comboBox.getSelectedItem().toString().trim());
				selllist.setAcc_id(comboBox_1.getSelectedItem().toString().trim());
				  Date dt=new Date();
				  SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
				  selllist.setSell_date(matter1.format(dt).toString());
                  sc.addPurh(selllist,selGLstArry );
				  item=0;
				  }
			
				
			}
		});
		submit.setFont(new Font("����", Font.PLAIN, 15));
		panel9.add(submit);
		
		JButton cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int n = JOptionPane.showConfirmDialog(frame.getContentPane(), "ȷ��ȡ����",
			                "ȷ�϶Ի���", JOptionPane.OK_CANCEL_OPTION);
				if(n==JOptionPane.YES_OPTION)
					
				{	frame.dispose();}
			}
		});
		cancel.setFont(new Font("����", Font.PLAIN, 15));
		panel9.add(cancel);
		
		JPanel panel10 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel10.getLayout();
		flowLayout_10.setVgap(10);
		frame.getContentPane().add(panel10);
		
		JLabel time = new JLabel("New label");
        Calendar date = Calendar.getInstance();
		time.setText(""+(date.get(Calendar.YEAR))+"��"+(date.get(Calendar.MONTH)+1)+"��"+date.get(Calendar.DATE)+"��");
		time.setFont(new Font("����", Font.PLAIN, 15));
		panel10.add(time);
	}

}
