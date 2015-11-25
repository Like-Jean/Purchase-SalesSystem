//���۵�
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import Controller.sellingListControl;
import Entity.sellingGoodsList;
import Entity.sellingList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class sellingListView {
	// ��д����
	public JFrame frame;

	// ����Jtext
	// ���۵���
	private JTextField textField_sellingListId;
	// ��Ʒ�۸�
	private JTextField textField_goodsPrice;
	// ��Ʒ����
	private JTextField textField_goodsQuantity;

	// ������¼Jtext��String
	public String[] Goods_id = new String[1000];
	public String[] Goods_name = new String[1000];
	public String[] warh_id = new String[1000];
	public float[] prices = new float[1000];
	public int[] quantitys = new int[1000];
	// item������¼������Ʒ���͵ĸ���
	public int item;

	// �ж�һ���ַ����Ƿ�Ϊ����
	boolean isDigit(String strNum) {
		return strNum.matches("[0-9]{1,}");
	}

	// controller sellingListControl
	private sellingListControl pc = new sellingListControl();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sellingListView window = new sellingListView();
					window.frame.setTitle("���۵�");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public sellingListView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		// ��ȡ������Ļ��С
		Toolkit kit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		frame = new JFrame();
		// �����λ����ʼλ�ã�width,height
		frame.setBounds(0, 0, screenSize.width / 2, screenSize.height * 2 / 3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(11, 0, 0, 0));

		// ��Ʒ�����۵�����
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);

		JLabel title = new JLabel("���۵�");
		title.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(title);

		// �����ŵ�label��text
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_1);

		JLabel purNum = new JLabel("���۵���");
		purNum.setFont(new Font("����", Font.PLAIN, 22));
		panel_1.add(purNum);

		textField_sellingListId = new JTextField();
		textField_sellingListId.setFont(new Font("����", Font.PLAIN, 20));
		panel_1.add(textField_sellingListId);
		textField_sellingListId.setColumns(20);
		
		
		// �����˺�label��combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		frame.getContentPane().add(panel_2);

		
		JLabel account = new JLabel("�����˺�");
		account.setFont(new Font("����", Font.PLAIN, 22));
		panel_2.add(account);

		// �������۵��������˺ŵ�����������Ա����ȴ��������˺ţ�
		if (pc.checkAcctNum().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ��������˺ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] AcctNumChoose = new String[pc.checkAcctNum().size()];
		AcctNumChoose = pc.checkAcctNum().toArray(AcctNumChoose);
		final JComboBox comboBox = new JComboBox(AcctNumChoose);
		comboBox.setEditable(true);
		comboBox.setFont(new Font("����", Font.PLAIN, 18));
		panel_2.add(comboBox);

		// ������λlabel��combox
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setHgap(30);
		flowLayout_3.setVgap(10);
		frame.getContentPane().add(panel_3);

		JLabel unit = new JLabel("������λ��");
		unit.setFont(new Font("����", Font.PLAIN, 22));
		panel_3.add(unit);

		// �������۵���������λ�ŵ�����������Ա�����������λ�ţ�
		if (pc.checkBsiUnitNum().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ���������λ�ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] BsUnitChoose = new String[pc.checkBsiUnitNum().size()];
		BsUnitChoose = pc.checkBsiUnitNum().toArray(BsUnitChoose);
		final JComboBox comboBox_1 = new JComboBox(BsUnitChoose);
		comboBox_1.setEditable(true);
		comboBox_1.setFont(new Font("����", Font.PLAIN, 18));

		panel_3.add(comboBox_1);
		//��ƷID
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setHgap(30);
		flowLayout_5.setVgap(10);
		frame.getContentPane().add(panel_5);

		JLabel productId = new JLabel("��ƷID");
		productId.setFont(new Font("����", Font.PLAIN, 22));
		panel_5.add(productId);
		
		if (pc.findProductId().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ�����Ʒ��", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] productIdChoose = new String[pc.findProductId().size()];
		productIdChoose = pc.findProductId().toArray(productIdChoose);
		final JComboBox comboBox_3 = new JComboBox(productIdChoose);
		comboBox_3.setEditable(true);
		comboBox_3.setFont(new Font("����", Font.PLAIN, 18));

		panel_5.add(comboBox_3);

		// ��Ʒ����
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setHgap(30);
		flowLayout_4.setVgap(10);
		frame.getContentPane().add(panel_4);

		JLabel productName = new JLabel("��Ʒ����");
		productName.setFont(new Font("����", Font.PLAIN, 22));
		panel_4.add(productName);
		
		if (pc.findProductName().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ�����Ʒ��", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] productNameChoose = new String[pc.findProductName().size()];
		productNameChoose = pc.findProductName().toArray(productNameChoose);
		final JComboBox comboBox_2 = new JComboBox(productNameChoose);
		comboBox_2.setEditable(true);
		comboBox_2.setFont(new Font("����", Font.PLAIN, 18));

		panel_4.add(comboBox_2);
		
		//��Ʒ�ֿ��
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setHgap(30);
		flowLayout_6.setVgap(10);
		frame.getContentPane().add(panel_6);

		JLabel productWareHouseId = new JLabel("�ֿ��");
		productWareHouseId.setFont(new Font("����", Font.PLAIN, 22));
		panel_6.add(productWareHouseId);
		
		if (pc.checkWarhId().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ����ֿ�ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] productWareHouseIdChoose = new String[pc.checkWarhId().size()];
		productWareHouseIdChoose = pc.checkWarhId().toArray(productWareHouseIdChoose);
		final JComboBox comboBox_4 = new JComboBox(productWareHouseIdChoose);
		comboBox_4.setEditable(true);
		comboBox_4.setFont(new Font("����", Font.PLAIN, 18));

		panel_6.add(comboBox_4);
		// ��Ʒ�۸�
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(30);
		frame.getContentPane().add(panel_7);

		JLabel price = new JLabel("��Ʒ�۸�");
		price.setFont(new Font("����", Font.PLAIN, 22));
		panel_7.add(price);

		textField_goodsPrice = new JTextField();
		textField_goodsPrice.setFont(new Font("����", Font.PLAIN, 20));
		panel_7.add(textField_goodsPrice);
		textField_goodsPrice.setColumns(20);
		// ��Ʒ����
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_8.getLayout();
		flowLayout_8.setVgap(10);
		flowLayout_8.setHgap(30);
		frame.getContentPane().add(panel_8);

		JLabel quantity = new JLabel("��Ʒ����");
		quantity.setFont(new Font("����", Font.PLAIN, 22));
		panel_8.add(quantity);

		textField_goodsQuantity = new JTextField();
		textField_goodsQuantity.setFont(new Font("����", Font.PLAIN, 20));
		panel_8.add(textField_goodsQuantity);
		textField_goodsQuantity.setColumns(20);

		// ��� ��Ʒ��ť
		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_9.getLayout();
		flowLayout_9.setVgap(10);
		flowLayout_9.setHgap(3);
		frame.getContentPane().add(panel_9);
		
		JButton add = new JButton("�����Ʒ");
		add.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				i = 0;
				// ���۸��Ƿ��������
				if (textField_goodsPrice.getText().trim().length() == 0
						|| !isDigit(textField_goodsPrice.getText().toString())) {
					JOptionPane.showMessageDialog(null, "��Ʒ�۸���д����", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// �����Ʒ�����Ƿ��������
				if (textField_goodsQuantity.getText().trim().length() == 0
						|| !isDigit(textField_goodsQuantity.getText().toString())
						|| Integer.valueOf(textField_goodsQuantity.getText().toString())
								.intValue() <= 0) {
					JOptionPane.showMessageDialog(null, "��Ʒ������д����", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				if (i == 0) {
					// д����ƷID
					Goods_id[item] = comboBox_3.getSelectedItem().toString();

					// д����Ʒ����
					Goods_name[item] = comboBox_2.getSelectedItem().toString();
					// д��ֿ�ID
					warh_id[item] = comboBox_4.getSelectedItem().toString();
					// д��۸�
					if (Float.valueOf((textField_goodsPrice.getText().toString()))
							.floatValue() <= 0)
						JOptionPane.showMessageDialog(null, "��Ʒ�۸���Ϊ����",
								"����ʧ��!", JOptionPane.ERROR_MESSAGE);
					float price1 = Float.valueOf(
							(textField_goodsPrice.getText().toString())).floatValue();
					prices[item] = price1;

					// д����Ʒ����
					int quantity1 = Integer.valueOf(
							textField_goodsQuantity.getText().toString()).intValue();
					quantitys[item] = quantity1;
					item++;

				}

			}
		});
		add.setFont(new Font("����", Font.PLAIN, 15));
		panel_9.add(add);
		// ������Ӱ�ť
		JButton addj = new JButton("���������Ʒ");
		addj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_goodsPrice.setText("");
				textField_goodsQuantity.setText("");

			}
		});
		addj.setFont(new Font("����", Font.PLAIN, 15));
		panel_9.add(addj);
		// �ύ���۵���ť
		JButton submit = new JButton("�ύ���۵�");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int makeConfirm = JOptionPane.showConfirmDialog(null,
						"ȷ���ύ������?", "ȷ��", JOptionPane.YES_NO_OPTION);
				if (makeConfirm == JOptionPane.YES_OPTION) {
					//Ҫʵ��controller��addPurh(sellingList sellingList,ArrayList<sellingGoodsList> gooLstArry)
					// ����ʵ��ArrayList<goodsList> gooLstArry
					ArrayList<sellingGoodsList> goodlist = new ArrayList<sellingGoodsList>();

					for (int i = 0; i < item; i++) {
						// ÿ��newһ��goodlist��ʵ������¼�û��������good����Ϣ,������Ʒid��name���ֿ�id���۸�����
						sellingGoodsList a = new sellingGoodsList();
						a.setGoods_id(Goods_id[i]);
						a.setGoods_name(Goods_name[i]);
						a.setWarh_id(warh_id[i]);
						a.setGoods_price(prices[i]);
						a.setGoods_quantity(quantitys[i]);
						a.setSellingList_id(textField_sellingListId.getText().toString());
						// ����Ʒadd��goodlist����
						goodlist.add(a);
						a = null;
					}
					// ʵ��sellingList slt
					sellingList slt = new sellingList();
					// ��鶩�����Ƿ�Ϊ��
					if (textField_sellingListId.getText().trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "���۵��Ų���Ϊ��", "����ʧ��!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				
					// д�붩����,�����˺ţ�������λ��
					slt.setSelling_id(textField_sellingListId.getText().toString());
					slt.setUnit_id(comboBox_1.getSelectedItem().toString());
					slt.setAcc_id(comboBox.getSelectedItem().toString());
					// д��ʱ��
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					slt.setSelling_date(matter1.format(dt).toString());
					pc.addPurh(slt, goodlist);
					item = 0;
				}
			}
		});
		submit.setFont(new Font("����", Font.PLAIN, 15));
		panel_9.add(submit);
		// ȡ��
		JButton cancel = new JButton("ȡ��");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cancel.setFont(new Font("����", Font.PLAIN, 15));
		panel_9.add(cancel);

		// ��һ��jlabel����ʾʱ��
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_10.getLayout();
		flowLayout_10.setVgap(10);
		frame.getContentPane().add(panel_10);

		JLabel time = new JLabel();
		Calendar date = Calendar.getInstance();
		time.setText("" + (date.get(Calendar.YEAR)) + "��"
				+ (date.get(Calendar.MONTH) + 1) + "��"
				+ date.get(Calendar.DATE) + "��");
		panel_10.add(time);
	}
}