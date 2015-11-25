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

public class GAdd {
	public JFrame frame;
	private String goods_id;//�ǿ�
	private String goods_name;//�ǿ�
	//private String goods_category;//�ǿ�
	private int goods_up;
	private int goods_down;
	private float goods_cost;//�ǿ�
	private float goods_prprice;
	private String goods_factory;//�ǿ�
	private String goods_version;

    private goodsControl gc = new goodsControl();
    private goods good = new goods();

	public GAdd() {
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
		
		JLabel label = new JLabel("\u5546\u54C1ID");//��ƷID
		label.setBounds(10, 27, 54, 15);
		frame.getContentPane().add(label);
		
		final JTextPane textPane = new JTextPane();
		textPane.setBounds(67, 27, 87, 21);
		frame.getContentPane().add(textPane);
		
		JLabel lblNewLabel = new JLabel("\u4ED3\u5E93ID");//�ֿ�ID
		lblNewLabel.setBounds(181, 27, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		//�ֿ�ID������
		String[] IDChoose = new String[gc.getWareHouseId().size()];
		IDChoose = gc.getWareHouseId().toArray(IDChoose);		
		final JComboBox comboBox = new JComboBox(IDChoose);
		comboBox.setBounds(248, 24, 106, 21);
		frame.getContentPane().add(comboBox);		
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0");//��Ʒ����
		label_1.setBounds(10, 62, 54, 15);
		frame.getContentPane().add(label_1);
		
		final JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(67, 58, 87, 19);
		frame.getContentPane().add(textPane_2);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u7C7B\u522B");//��Ʒ���
		label_2.setBounds(181, 62, 54, 15);
		frame.getContentPane().add(label_2);

		//��Ʒ���������
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("ʳƷ");
		comboBox_1.addItem("ҩƷ");
		comboBox_1.addItem("���");
		comboBox_1.addItem("����");
		comboBox_1.addItem("�ľ�");
		comboBox_1.addItem("�˶�����");
		comboBox_1.setBounds(248, 59, 104, 21);
		frame.getContentPane().add(comboBox_1);			
		
		JLabel label_3 = new JLabel("\u5E93\u5B58\u4E0A\u9650");//�������
		label_3.setBounds(10, 97, 54, 15);
		frame.getContentPane().add(label_3);
		
		final JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(67, 91, 87, 21);
		frame.getContentPane().add(textPane_4);
		
		JLabel label_4 = new JLabel("\u5E93\u5B58\u4E0B\u9650");//�������
		label_4.setBounds(181, 97, 54, 15);
		frame.getContentPane().add(label_4);
		
		final JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(250, 87, 104, 25);
		frame.getContentPane().add(textPane_5);
		
		JLabel label_5 = new JLabel("\u6210\u672C\u4EF7");//�ɱ���
		label_5.setBounds(10, 128, 41, 15);
		frame.getContentPane().add(label_5);
		
		final JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(67, 122, 87, 21);
		frame.getContentPane().add(textPane_6);
		
		JLabel label_6 = new JLabel("\u9884\u552E\u4EF7");//Ԥ�ۼ�
		label_6.setBounds(181, 125, 54, 15);
		frame.getContentPane().add(label_6);
		
		final JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(250, 122, 104, 21);
		frame.getContentPane().add(textPane_7);
		
		JLabel label_7 = new JLabel("\u751F\u4EA7\u5382\u5BB6");//��������
		label_7.setBounds(10, 152, 54, 15);
		frame.getContentPane().add(label_7);
		
		final JTextPane textPane_8 = new JTextPane();
		textPane_8.setBounds(67, 153, 87, 21);
		frame.getContentPane().add(textPane_8);
		
		JLabel label_8 = new JLabel("\u5546\u54C1\u578B\u53F7");//��Ʒ�ͺ�
		label_8.setBounds(181, 152, 54, 15);
		frame.getContentPane().add(label_8);
		
		final JTextPane textPane_9 = new JTextPane();
		textPane_9.setBounds(250, 153, 104, 21);
		frame.getContentPane().add(textPane_9);
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");//ȷ�����
		button.addActionListener(new ActionListener() {
			int i;
			public void actionPerformed(ActionEvent e) {
				i = 0;
				goods_id = textPane.getText().trim().toString();
				goods_name = textPane_2.getText().trim().toString();
				goods_up = Integer.parseInt(textPane_4.getText().trim());
				goods_down = Integer.parseInt(textPane_5.getText().trim());
				goods_cost = Float.parseFloat(textPane_6.getText().trim());
				goods_prprice = Float.parseFloat(textPane_7.getText().trim());
				goods_factory = textPane_8.getText().trim().toString();
				goods_version = textPane_9.getText().trim().toString();
				
				if(goods_id.length() == 0||goods_name.length() == 0||goods_up == 0||
						goods_down == 0||goods_cost == 0||goods_prprice == 0||
						goods_factory.length() == 0||goods_version.length() == 0){
					
					JOptionPane.showMessageDialog(null,"�κ�һ����Ŀ����Ϊ�գ�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
			    	i = 1;
				}
				//�������
			    if(!isDigit(textPane_4.getText().trim())&&textPane_4.getText().trim().length()!=0)
		    	{JOptionPane.showMessageDialog(null,"������ޱ���Ϊ���֣�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
		    	i = 1;
		    	}				
				//�������
			    if(!isDigit(textPane_5.getText().trim())&&textPane_5.getText().trim().length()!=0)
		    	{JOptionPane.showMessageDialog(null,"������ޱ���Ϊ���֣�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
		    	i = 1;
		    	}		
				//�ɱ���
			    if(!isDigit(textPane_6.getText().trim())&&textPane_6.getText().trim().length()!=0)
		    	{JOptionPane.showMessageDialog(null,"�ɱ��۱���Ϊ���֣�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
		    	i = 1;
		    	}		
				//Ԥ�ۼ�
			    if(!isDigit(textPane_7.getText().trim())&&textPane_7.getText().trim().length()!=0)
		    	{JOptionPane.showMessageDialog(null,"Ԥ�ۼ۱���Ϊ���֣�","����ʧ��!",JOptionPane.ERROR_MESSAGE);
		    	i = 1;
		    	}		
			    
			    if(i == 0){
			    	
			    	good.setGoods_category((String)comboBox_1.getSelectedItem());
			    	good.setGoods_cost(goods_cost);
			    	good.setGoods_down(goods_down);
			    	good.setGoods_factory(goods_factory);
			    	good.setGoods_id(goods_id);
			    	good.setGoods_name(goods_name);
			    	good.setGoods_prprice(goods_prprice);
			    	good.setGoods_up(goods_up);
			    	good.setGoods_version(goods_version);
			    	good.setWarh_id((String)comboBox.getSelectedItem());
			    	
			    	gc.addGood(good);
			    	
			    	JOptionPane.showMessageDialog(null,"��ӳɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			    }
			}
		});
		button.setBounds(67, 202, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u7EE7\u7EED\u6DFB\u52A0");//�������
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPane.setText("");
				//textPane_1.setText("");
				textPane_2.setText("");
				//textPane_3.setText("");
				textPane_4.setText("");
				textPane_5.setText("");
				textPane_6.setText("");
				textPane_7.setText("");
				textPane_8.setText("");
				textPane_9.setText("");
			}
		});
		button_1.setBounds(250, 202, 93, 23);
		frame.getContentPane().add(button_1);


		
		
	}
}
