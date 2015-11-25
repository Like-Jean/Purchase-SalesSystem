package view;
//�ֿ������

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

import Controller.transferringListControl;
import Entity.payment;
import Entity.transferringList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
public class transferringListView {
	JFrame frame;

	// ����Jtext
	// �ֿ��������
	private JTextField textField_transferringListId;
	// ��Ʒ����
	private JTextField textField_goodsQuantity;
	
	// ������¼Jtext
		public String  transferringListId= new String();
		public int goodsQuantity;
	// �ж�һ���ַ����Ƿ�Ϊ����
		boolean isDigit(String strNum) {
			return strNum.matches("[0-9]{1,}");
		}
	private transferringListControl tc = new transferringListControl();
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transferringListView window = new transferringListView();
					window.frame.setTitle("�ֿ������");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public transferringListView() {
		initialize();
	}
	private void initialize() {
		// ��ȡ������Ļ��С
				Toolkit kit = Toolkit.getDefaultToolkit();
				final Dimension screenSize = kit.getScreenSize();
				int screenWidth = screenSize.width;
				int screenHeight = screenSize.height;
				frame = new JFrame();
				// �����λ����ʼλ�ã�width,height
				frame.setBounds(0, 0, screenSize.width / 2,
						screenSize.height * 2 / 3);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(new GridLayout(9, 0, 0, 0));
				
				// ����������
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setHgap(10);
				flowLayout.setVgap(10);
				frame.getContentPane().add(panel);

				JLabel title = new JLabel("�ֿ������");
				title.setFont(new Font("����", Font.PLAIN, 25));
				panel.add(title);

				// �������ŵ�label��text
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
				flowLayout_1.setHgap(10);
				flowLayout_1.setVgap(10);
				frame.getContentPane().add(panel_1);

				JLabel purNum = new JLabel("��������");
				purNum.setFont(new Font("����", Font.PLAIN, 22));
				panel_1.add(purNum);

				textField_transferringListId = new JTextField();
				textField_transferringListId.setFont(new Font("����", Font.PLAIN, 20));
				panel_1.add(textField_transferringListId);
				textField_transferringListId.setColumns(20);
				
				//��Ʒ����label��combox
				JPanel panel_2 = new JPanel();
				FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
				flowLayout_2.setVgap(10);
				flowLayout_2.setHgap(10);
				frame.getContentPane().add(panel_2);

				JLabel productName = new JLabel("��Ʒ����");
				productName.setFont(new Font("����", Font.PLAIN, 22));
				panel_2.add(productName);

				// �����ȴ�����Ʒ��
				if (tc.findProductName().size()==0) {
					JOptionPane.showMessageDialog(null, "���ȴ�����Ʒ��", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				String[] productNameChoose = new String[tc.findProductName().size()];
				productNameChoose = tc.findProductName().toArray(productNameChoose);
				final JComboBox comboBox = new JComboBox(productNameChoose);
				comboBox.setEditable(true);
				comboBox.setFont(new Font("����", Font.PLAIN, 18));
				panel_2.add(comboBox);
				
				//������
				JPanel panel_3 = new JPanel();
				FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
				flowLayout_3.setHgap(30);
				flowLayout_3.setVgap(10);
				frame.getContentPane().add(panel_3);

				JLabel  handler= new JLabel("������ID");
				handler.setFont(new Font("����", Font.PLAIN, 22));
				panel_3.add(handler);

				// ���ڽ�������������λ�ŵ�����������Ա�����������λ�ţ�
				if (tc.findEmployeeId().size() == 0) {
					JOptionPane.showMessageDialog(null, "���ȴ��������ˣ�", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				String[] EmployeeIdChoose = new String[tc.findEmployeeId().size()];
				EmployeeIdChoose = tc.findEmployeeId().toArray(EmployeeIdChoose);
				final JComboBox comboBox_2 = new JComboBox(EmployeeIdChoose);
				comboBox_2.setEditable(true);
				comboBox_2.setFont(new Font("����", Font.PLAIN, 18));

				panel_3.add(comboBox_2);
				
				//����
				JPanel panel_4 = new JPanel();
				FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
				flowLayout_4.setVgap(10);
				flowLayout_4.setHgap(30);
				frame.getContentPane().add(panel_4);

				JLabel quantity = new JLabel("��Ʒ����");
				quantity.setFont(new Font("����", Font.PLAIN, 22));
				panel_4.add(quantity);

				textField_goodsQuantity = new JTextField();
				textField_goodsQuantity.setFont(new Font("����", Font.PLAIN, 20));
				panel_4.add(textField_goodsQuantity);
				textField_goodsQuantity.setColumns(20);
				//�����ֿ�
				JPanel panel_5 = new JPanel();
				FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
				flowLayout_5.setVgap(10);
				flowLayout_5.setHgap(13);
				frame.getContentPane().add(panel_5);

				JLabel outWareHouse = new JLabel("�����ֿ�");
				outWareHouse.setFont(new Font("����", Font.PLAIN, 22));
				panel_5.add(outWareHouse);

				// �����ȴ����ֿ⣡
				if (tc.checkWarhId().size()==0) {
					JOptionPane.showMessageDialog(null, "���ȴ����ֿ⣡", "����ʧ��!",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				String[] outWareHouseChoose = new String[tc.checkWarhId().size()];
				outWareHouseChoose = tc.checkWarhId().toArray(outWareHouseChoose);
				final JComboBox comboBox_outWareHouse = new JComboBox(outWareHouseChoose);
				comboBox_outWareHouse.setEditable(true);
				comboBox_outWareHouse.setFont(new Font("����", Font.PLAIN, 18));
				panel_5.add(comboBox_outWareHouse);
				
				//����ֿ�
				JPanel panel_6 = new JPanel();
				FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
				flowLayout_6.setVgap(10);
				flowLayout_6.setHgap(13);
				frame.getContentPane().add(panel_6);

				JLabel inWareHouse = new JLabel("����ֿ�");
				inWareHouse.setFont(new Font("����", Font.PLAIN, 22));
				panel_6.add(inWareHouse);

				String[] inWareHouseChoose = new String[tc.checkWarhId().size()];
				inWareHouseChoose = tc.checkWarhId().toArray(inWareHouseChoose);
				final JComboBox comboBox_inWareHouse = new JComboBox(inWareHouseChoose);
				comboBox_inWareHouse.setEditable(true);
				comboBox_inWareHouse.setFont(new Font("����", Font.PLAIN, 18));
				panel_6.add(comboBox_inWareHouse);
				
				// �ύ���ݰ�ť
				JPanel panel_7 = new JPanel();
				FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
				flowLayout_7.setVgap(10);
				flowLayout_7.setHgap(3);
				frame.getContentPane().add(panel_7);
				JButton add = new JButton("�ύ������");
				add.addActionListener(new ActionListener() {
					int i;

					public void actionPerformed(ActionEvent e) {
						int makeConfirm = JOptionPane.showConfirmDialog(null,
								"ȷ���ύ������?", "ȷ��", JOptionPane.YES_NO_OPTION);
						if (makeConfirm == JOptionPane.YES_OPTION) {
						i = 0;
						// ��ⵥ�ݺ��Ƿ�Ϊ��
						if (textField_transferringListId.getText().trim().length() == 0) {
							JOptionPane.showMessageDialog(null, "��Ӧ���ݲ���Ϊ��", "����ʧ��!",
									JOptionPane.ERROR_MESSAGE);
							i++;
						}
						// ��������Ƿ��������
						if (textField_goodsQuantity.getText().trim().length() == 0
								|| !isDigit(textField_goodsQuantity.getText().toString())) {
							JOptionPane.showMessageDialog(null, "��Ʒ������д����", "����ʧ��!",
									JOptionPane.ERROR_MESSAGE);
							i++;
						}

						if (i == 0) {
							// д���Ӧ����
							transferringListId = textField_transferringListId.getText().toString();
							// д������
							if (Float.valueOf((textField_goodsQuantity.getText().toString()))
									.floatValue() <= 0){
								JOptionPane.showMessageDialog(null, "��Ʒ��������Ϊ����",
										"����ʧ��!", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							int quantities = Integer.valueOf(
									(textField_goodsQuantity.getText().toString())).intValue();
							goodsQuantity = quantities;
							
							//��¼����
							transferringList list=new transferringList();
							//д���������
							list.setTransferringListId(transferringListId);
							//д������
							list.setQuantities(goodsQuantity);
							//������Ʒ�����ڸĲֿ������û�����������Ƚ��Ƿ��㹻
							if(tc.enoughQuantities(list)==false){
								JOptionPane.showMessageDialog(null, "����������󣡣�",
										"����ʧ��!", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							//д������ֿ⣬����ֿ�
							//���������ȣ��ͱ���
							if(comboBox_outWareHouse.getSelectedItem().toString()==comboBox_inWareHouse.getSelectedItem().toString()){
								JOptionPane.showMessageDialog(null, "����ֿⲻ�ܵ��ڵ����ֿ�",
										"����ʧ��!", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
							list.setOutWarehouseId(comboBox_outWareHouse.getSelectedItem().toString());
							list.setInWarehouseId(comboBox_inWareHouse.getSelectedItem().toString());
							
							//д�뾭���˱�ţ���Ʒ����
							list.setHandler(comboBox_2.getSelectedItem().toString());
							list.setGoods_name(comboBox.getSelectedItem().toString());
							// д��ʱ��
							Date dt = new Date();
							SimpleDateFormat matter1 = new SimpleDateFormat(
									"yyyy-MM-dd");
							list.setTransferringList_date(matter1.format(dt).toString());
						}

					}
					}
				});
				add.setFont(new Font("����", Font.PLAIN, 15));
				panel_7.add(add);
			
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
