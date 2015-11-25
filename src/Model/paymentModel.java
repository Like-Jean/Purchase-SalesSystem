package Model;
/*@author Like
 * version 1.0
 * �������model
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.payment;
import Entity.purchaseList;

public class paymentModel extends jdbc {
	
	    //���Ӹ��
		public void add(payment pay){
			
			try{
				Connection con = initDB();
				
				Statement stmt = con.createStatement();
				
				String query = "insert into payment(payment_id,payment_date,unitId,financeWorker,matchingMenu,totalPayment,acc_id) values ('"
						+pay.getPaymentId()+"','"
						+pay.getPaymentDate()+"','"
						+pay.getUnitId()+"','"
						+pay.getFinanceWorker()+"','"
						+pay.getMatchingMenu()+"','"
						+pay.getTotalPayment()+"','"
						+pay.getAccId()+"')";
				stmt.execute(query);
				
				// �ر������������
				stmt.close();
				// �ر����ݿ�����
				con.close();
			}catch(SQLException e){
				System.out.println("�������ʧ�ܣ�");
				e.printStackTrace();			
			}
		}
		
		//���¸��
		public void update(payment pay){
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "update payment set payment_date='"+pay.getPaymentDate()+
				"',unitId='"+pay.getUnitId()+"',financeWorker='"+pay.getFinanceWorker()+
				"',matchingMenu='"+pay.getMatchingMenu()+"',totalPayment='"+pay.getTotalPayment()+
				"',acc_id='"+pay.getAccId()+"' where payment_id ='"+pay.getPaymentId()+"'";
				
				// ִ��SQL���
				stmt.execute(query);

				// �ر������������
				stmt.close();

				// �ر����ݿ�����
				con.close();			
			}catch(Exception e){
				System.out.println("��������ʧ�ܣ�");
				e.printStackTrace();			
			}			
		}
		
		//���ݵ�����ɾ�����
		public void delete(String PaymentId){
			PaymentId.trim();
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "delete from payment where payment_id = '"
				+PaymentId+"'";
				
				// ִ��SQL���
				stmt.execute(query);

				// �ر������������
				stmt.close();

				// �ر����ݿ�����
				con.close();			
			}catch(Exception e){
				System.out.println("ɾ������ʧ�ܣ�");
				e.printStackTrace();			
			}			
		}
		
		//���ݵ��Ų���ĳһ�����
		public payment findByPaymentId(String PaymentId){
			PaymentId.trim();
			payment pay = new payment();
			
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from paymentt where payment_id ='"+PaymentId+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				pay.setPaymentId(rs.getString("payment_id"));
				pay.setPaymentDate(rs.getString("payment_date"));
				pay.setFinanceWorker(rs.getString("financeWorker"));
				pay.setUnitId(rs.getString("unitId"));
				pay.setAccId(rs.getString("acc_id"));
				pay.setMatchingMenu(rs.getString("matchingMenu"));
				pay.setTotalPayment(rs.getFloat("totalPayment"));
				
				// �رռ�¼��
				rs.close();
				// �ر������������
				stmt.close();

				// �ر����ݿ�����
			    con.close();
			
			}catch(SQLException e){
				System.out.println("��������ʧ�ܣ�");
				e.printStackTrace();			
			}		
			
			return pay;
		}
		
		//����ʱ���������,���ؽ�����
		//ע�����
		/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			
			Date date1 = new Date(2014-1900,6-1,25);

			String day1=sdf.format(date1);
			����������ȡ*/
		public ArrayList<payment> findByPaymentDates(String day1,String day2 ){
			
			payment pay;
			ArrayList<payment> showPay = new ArrayList<payment>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from payment where payment_date between'"+day1+"'and'"+day2+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					pay = new payment();
					pay.setPaymentId(rs.getString("payment_id"));
					pay.setPaymentDate(rs.getString("payment_date"));
					pay.setUnitId(rs.getString("unitId"));
					pay.setTotalPayment(rs.getFloat("totalPayment"));
					pay.setFinanceWorker(rs.getNString("finaceWorker"));
					pay.setMatchingMenu(rs.getNString("matchingMenu"));
					pay.setAccId(rs.getString("acc_id"));				
					showPay.add(pay);
					pay = null;
				}
				// �رռ�¼��
							rs.close();
							// �ر������������
							stmt.close();

							// �ر����ݿ�����
							con.close();
			
			}catch(SQLException e){
				System.out.println("��������ʧ�ܣ�");
				e.printStackTrace();			
			}
			
			return showPay;
		}
		
		//���ݾ���ʱ�������ң���������������
		public ArrayList<payment> findByPaymentDate(String paymentDate ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from payment where payment_date='"+paymentDate+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
					}
					// �رռ�¼��
								rs.close();
								// �ر������������
								stmt.close();

								// �ر����ݿ�����
								con.close();
				
				}catch(SQLException e){
					System.out.println("��������ʧ�ܣ�");
					e.printStackTrace();			
				}
				
				return showPay;
			}
	
		//����������λ�����ң������������
		public ArrayList<payment> findByUnitId(String unitId ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from payment where unitId='"+unitId+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
					}
					// �رռ�¼��
								rs.close();
								// �ر������������
								stmt.close();

								// �ر����ݿ�����
								con.close();
				
				}catch(SQLException e){
					System.out.println("��������ʧ�ܣ�");
					e.printStackTrace();			
				}
				
				return showPay;
			}
		
		//���������˻������ң������������
		public ArrayList<payment> findByAccId(String accId ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from payment where acc_id='"+accId+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
					}
					// �رռ�¼��
								rs.close();
								// �ر������������
								stmt.close();

								// �ر����ݿ�����
								con.close();
				
				}catch(SQLException e){
					System.out.println("��������ʧ�ܣ�");
					e.printStackTrace();			
				}
				
				return showPay;
			}
		
		//���ݲ�����Ա�����ң������������
		public ArrayList<payment> findByFinaceWorker(String finaceWorker ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from payment where finaceWorker='"+finaceWorker+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
					}
					// �رռ�¼��
								rs.close();
								// �ر������������
								stmt.close();

								// �ر����ݿ�����
								con.close();
				
				}catch(SQLException e){
					System.out.println("��������ʧ�ܣ�");
					e.printStackTrace();			
				}
				
				return showPay;
			}
		
		//���ݶ�Ӧ���������ң������������
		public ArrayList<payment> findByMatchingMenu(String matchingMenu ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from payment where matchingMenu='"+matchingMenu+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
					}
					// �رռ�¼��
								rs.close();
								// �ر������������
								stmt.close();

								// �ر����ݿ�����
								con.close();
				
				}catch(SQLException e){
					System.out.println("��������ʧ�ܣ�");
					e.printStackTrace();			
				}
				
				return showPay;
			}
}
