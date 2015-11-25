package view;
/*������*/
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

import Controller.purchaseControl;
import Entity.goodsList;
import Entity.purchaseList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class purchaseView2 {
	// ��д����
	JFrame frame;

	// ����Jtext
	// ������
	private JTextField textField;
	// ��ƷID
	private JTextField textField_1;
	// ��Ʒ����
	private JTextField textField_2;
	// ��Ʒ�ֿ��
	// private JTextField textField_3;
	// ��Ʒ�۸�
	private JTextField textField_4;
	// ��Ʒ����
	private JTextField textField_5;

	// �������������������Ϊ�鿴������Ϣ����Ĳ���
	public String dingdanhao;

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

	// controller purchaseControll
	private purchaseControl pc = new purchaseControl();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchaseView2 window = new purchaseView2();
					window.frame.setTitle("������");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public purchaseView2() {
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

		// ��Ʒ�Ľ���������
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		frame.getContentPane().add(panel);

		JLabel title = new JLabel("������");
		title.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(title);

		// �����ŵ�label��text
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_1);

		JLabel purNum = new JLabel("������");
		purNum.setFont(new Font("����", Font.PLAIN, 22));
		panel_1.add(purNum);

		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 20));
		panel_1.add(textField);
		textField.setColumns(20);
		
		
		// �����˺�label��combox
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(13);
		frame.getContentPane().add(panel_2);

		
		JLabel account = new JLabel("�����˺�");
		account.setFont(new Font("����", Font.PLAIN, 22));
		panel_2.add(account);

		// ���ڽ������������˺ŵ�����������Ա����ȴ��������˺ţ�
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

		// ���ڽ�������������λ�ŵ�����������Ա�����������λ�ţ�
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

		// ��ƷID
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setHgap(45);
		frame.getContentPane().add(panel_4);

		JLabel sid = new JLabel("��ƷID");
		sid.setHorizontalAlignment(SwingConstants.CENTER);
		sid.setFont(new Font("����", Font.PLAIN, 22));
		panel_4.add(sid);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("����", Font.PLAIN, 20));
		panel_4.add(textField_1);
		textField_1.setColumns(20);

		// ��Ʒ����
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(23);
		frame.getContentPane().add(panel_5);

		JLabel sname = new JLabel("��Ʒ����");
		sname.setFont(new Font("����", Font.PLAIN, 22));
		panel_5.add(sname);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("����", Font.PLAIN, 20));
		panel_5.add(textField_2);
		textField_2.setColumns(20);

		// �ֿ��label��combox
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(10);
		flowLayout_6.setHgap(38);
		frame.getContentPane().add(panel_6);
		JLabel warh = new JLabel("�ֿ��");
		warh.setFont(new Font("����", Font.PLAIN, 22));
		panel_6.add(warh);

		// ���ڲֿ��Ѳֿ�ŵ������������Ա����ȴ����ֿ�ţ�
		if (pc.checkWarhId().size() == 0) {
			JOptionPane.showMessageDialog(null, "���ȴ����ֿ�ţ�", "����ʧ��!",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String[] warh_idChoose = new String[pc.checkWarhId().size()];
		warh_idChoose = pc.checkWarhId().toArray(AcctNumChoose);
		final JComboBox comboBoxwarh = new JComboBox(warh_idChoose);
		comboBoxwarh.setEditable(true);
		comboBoxwarh.setFont(new Font("����", Font.PLAIN, 18));
		panel_6.add(comboBoxwarh);

		// ��Ʒ�۸�
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(30);
		frame.getContentPane().add(panel_7);

		JLabel price = new JLabel("��Ʒ�۸�");
		price.setFont(new Font("����", Font.PLAIN, 22));
		panel_7.add(price);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("����", Font.PLAIN, 20));
		panel_7.add(textField_4);
		textField_4.setColumns(20);
		// ��Ʒ����
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_8.getLayout();
		flowLayout_8.setVgap(10);
		flowLayout_8.setHgap(30);
		frame.getContentPane().add(panel_8);

		JLabel quantity = new JLabel("��Ʒ����");
		quantity.setFont(new Font("����", Font.PLAIN, 22));
		panel_8.add(quantity);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("����", Font.PLAIN, 20));
		panel_8.add(textField_5);
		textField_5.setColumns(20);

		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_9.getLayout();
		flowLayout_9.setVgap(10);
		flowLayout_9.setHgap(3);
		frame.getContentPane().add(panel_9);
		// ��� ��Ʒ��ť
		JButton add = new JButton("�����Ʒ");
		add.addActionListener(new ActionListener() {
			int i;

			public void actionPerformed(ActionEvent e) {
				i = 0;
				// �����ƷID�Ƿ�Ϊ��
				if (textField_1.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "��ƷID����Ϊ��", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// �����Ʒ�����Ƿ�Ϊ��
				if (textField_2.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "��Ʒ���Ʋ���Ϊ��", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// ���۸��Ƿ��������
				if (textField_4.getText().trim().length() == 0
						|| !isDigit(textField_4.getText().toString())) {
					JOptionPane.showMessageDialog(null, "��Ʒ�۸���д����", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				// �����Ʒ�����Ƿ��������
				if (textField_5.getText().trim().length() == 0
						|| !isDigit(textField_5.getText().toString())
						|| Integer.valueOf(textField_5.getText().toString())
								.intValue() <= 0) {
					JOptionPane.showMessageDialog(null, "��Ʒ������д����", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					i++;
				}

				if (i == 0) {// д����ƷID
					Goods_id[item] = textField_1.getText().toString();

					// д����Ʒ����
					Goods_name[item] = textField_2.getText().toString();
					// д��ֿ�ID
					warh_id[item] = comboBoxwarh.getSelectedItem().toString();
					// д��۸�
					if (Float.valueOf((textField_5.getText().toString()))
							.floatValue() <= 0)
						JOptionPane.showMessageDialog(null, "��Ʒ�۸���Ϊ����",
								"����ʧ��!", JOptionPane.ERROR_MESSAGE);
					float price1 = Float.valueOf(
							(textField_4.getText().toString())).floatValue();
					prices[item] = price1;

					// д����Ʒ����
					int quantity1 = Integer.valueOf(
							textField_5.getText().toString()).intValue();
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
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				textField_5.setText("");

			}
		});
		addj.setFont(new Font("����", Font.PLAIN, 15));
		panel_9.add(addj);
		// �ύ��������ť
		JButton submit = new JButton("�ύ������");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int makeConfirm = JOptionPane.showConfirmDialog(null,
						"ȷ���ύ������?", "ȷ��", JOptionPane.YES_NO_OPTION);
				if (makeConfirm == JOptionPane.YES_OPTION) {
					// Ҫʵ��controller��public boolean addPurh(purchaseList
					// prhLst,ArrayList<goodsList> gooLstArry)
					// ����ʵ��ArrayList<goodsList> gooLstArry
					ArrayList<goodsList> goodlist = new ArrayList<goodsList>();

					for (int i = 0; i < item; i++) {
						// ÿ��newһ��goodlist��ʵ������¼�û��������good����Ϣ,������Ʒid��name���ֿ�id���۸�����
						goodsList a = new goodsList();
						a.setGoods_id(Goods_id[i]);
						a.setGoods_name(Goods_name[i]);
						a.setWarh_id(warh_id[i]);
						a.setGoods_price(prices[i]);
						a.setGoods_quantity(quantitys[i]);
						a.setPurchase_id(textField.getText().toString());
						// ����Ʒadd��goodlist����
						goodlist.add(a);
						a = null;
					}
					// ʵ��purchaseList prhLst
					purchaseList purlist = new purchaseList();
					// ��鶩�����Ƿ�Ϊ��
					if (textField.getText().trim().length() == 0) {
						JOptionPane.showMessageDialog(null, "�����Ų���Ϊ��", "����ʧ��!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					dingdanhao = textField.getText().toString();
					// ����˻�����Ƿ��㹻
					if (pc.checkBalance(comboBox.getSelectedItem().toString()) == false) {
						JOptionPane.showMessageDialog(null, "���˺�����", "����ʧ��!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
					// д�붩����,�����˺ţ�������λ��
					purlist.setPurch_id(textField.getText().toString());
					purlist.setUnit_id(comboBox_1.getSelectedItem().toString());
					purlist.setAcc_id(comboBox.getSelectedItem().toString());
					// д��ʱ��
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					purlist.setPurch_date(matter1.format(dt).toString());
					pc.addPurh(purlist, goodlist);
					item = 0;
				}
				int checkPurchase = JOptionPane.showConfirmDialog(null,
						"�����ύ�ɹ�����Ҫ�鿴��?", "ȷ��", JOptionPane.YES_NO_OPTION);
				if (checkPurchase == JOptionPane.YES_OPTION) {
					// �鿴����
					frame.setVisible(false);
					JFrame checkFrame = new JFrame("����������Ϣ");
					checkFrame.setBounds(100, 100, screenSize.width / 2,
							screenSize.height * 2 / 3);

					// layout�Ĵ�С��showGoodsList(dingdanhao).size()��1����Ʒ����˵���������1����Ҫ��Ϣ����+2
					checkFrame.getContentPane().setLayout(
							new GridLayout(
									pc.showGoodsList(dingdanhao).size() + 2, 0,
									0, 0));
					checkFrame
							.setDefaultCloseOperation(checkFrame.EXIT_ON_CLOSE);
					checkFrame.setVisible(true);

					// ������Ҫ��Ϣ

					JPanel MainInformationPanel = new JPanel();
					FlowLayout flowLayout_MainInformation = (FlowLayout) MainInformationPanel
							.getLayout();
					flowLayout_MainInformation.setVgap(10);
					flowLayout_MainInformation.setHgap(10);
					checkFrame.getContentPane().add(MainInformationPanel);

					// ������
					JLabel purchaseIdLabel = new JLabel("������");
					purchaseIdLabel.setFont(new Font("����", Font.PLAIN, 16));
					MainInformationPanel.add(purchaseIdLabel);
					JLabel purchaseIdtext = new JLabel(dingdanhao);
					purchaseIdtext.setFont(new Font("����", Font.PLAIN, 16));
					MainInformationPanel.add(purchaseIdtext);

					// �����ʺ�
					JLabel AccountIdLabel = new JLabel("�����˺�");
					AccountIdLabel.setFont(new Font("����", Font.PLAIN, 16));
					MainInformationPanel.add(AccountIdLabel);
					JLabel AccountIdText = new JLabel(pc.showPurchase(
							dingdanhao).getAcc_id());
					AccountIdText.setFont(new Font("����", Font.PLAIN, 16));
					MainInformationPanel.add(AccountIdText);

					// ������λ��
					JLabel UnitIdLabel = new JLabel("������λ��");
					UnitIdLabel.setFont(new Font("����", Font.PLAIN, 16));
					MainInformationPanel.add(UnitIdLabel);
					JLabel UnitIdText = new JLabel(pc.showPurchase(dingdanhao)
							.getUnit_id());
					UnitIdText.setFont(new Font("����", Font.PLAIN, 16));
					MainInformationPanel.add(UnitIdText);

					// ��Ʒ����˵����

					JPanel AttributeInformationPanel = new JPanel();
					FlowLayout flowLayout_AttributeInformation = (FlowLayout) AttributeInformationPanel
							.getLayout();
					flowLayout_AttributeInformation.setVgap(10);
					flowLayout_AttributeInformation.setHgap(15);
					checkFrame.getContentPane().add(AttributeInformationPanel);

					// һ��5������˵��
					JLabel productIdDescriptLabel = new JLabel("��ƷID");
					productIdDescriptLabel.setFont(new Font("����", Font.PLAIN,
							22));
					AttributeInformationPanel.add(productIdDescriptLabel);

					JLabel productNameDescriptLabel = new JLabel("��Ʒ����");
					productNameDescriptLabel.setFont(new Font("����", Font.PLAIN,
							22));
					AttributeInformationPanel.add(productNameDescriptLabel);

					JLabel warhIdDescriptLabel = new JLabel("�ֿ��");
					warhIdDescriptLabel.setFont(new Font("����", Font.PLAIN, 22));
					AttributeInformationPanel.add(warhIdDescriptLabel);

					JLabel productPriceDescriptLabel = new JLabel("��Ʒ�۸�");
					productPriceDescriptLabel.setFont(new Font("����",
							Font.PLAIN, 22));
					AttributeInformationPanel.add(productPriceDescriptLabel);

					JLabel productQuantityDescriptLabel = new JLabel("��Ʒ����");
					productQuantityDescriptLabel.setFont(new Font("����",
							Font.PLAIN, 22));
					AttributeInformationPanel.add(productQuantityDescriptLabel);

					// ��Ʒ��Ϣ
					JPanel goodsinformationpanel[] = new JPanel[pc
							.showGoodsList(dingdanhao).size()];
					FlowLayout flowlayout_goodsinformation[] = new FlowLayout[pc
							.showGoodsList(dingdanhao).size()];
					// һ����Ʒ��Ϣ�����飬����Ϊ5
					JLabel goodsinformationLabel[] = new JLabel[5];
					for (int i = 0; i < 5; i++)
						goodsinformationLabel[i] = new JLabel("");
					for (int i = 0; i < pc.showGoodsList(dingdanhao).size(); i++) {
						goodsinformationpanel[i] = new JPanel();
						flowlayout_goodsinformation[i] = (FlowLayout) goodsinformationpanel[i]
								.getLayout();
						flowlayout_goodsinformation[i].setVgap(10);
						flowlayout_goodsinformation[i].setHgap(15 + 2 * i);
						checkFrame.getContentPane().add(
								goodsinformationpanel[i]);
						// ��Ʒ5����Ϣ
						for (int j = 0; j < 5; j++) {
							switch (j) {
							case 0: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_id());
								goodsinformationLabel[j].setFont(new Font("����",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 1: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_name());
								goodsinformationLabel[j].setFont(new Font("����",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 2: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getWarh_id());
								goodsinformationLabel[j].setFont(new Font("����",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 3: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_price()
										+ "");
								goodsinformationLabel[j].setFont(new Font("����",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							case 4: {
								goodsinformationLabel[j].setText(pc
										.showGoodsList(dingdanhao).get(j)
										.getGoods_quantity()
										+ "");
								goodsinformationLabel[j].setFont(new Font("����",
										Font.PLAIN, 22));
								goodsinformationpanel[i]
										.add(goodsinformationLabel[j]);
								break;
							}
							}
						}
					}
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
