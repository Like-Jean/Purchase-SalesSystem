package Model;
/*@author Like
 *@version 1.0
 *��sellList����в�������
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.sellList;

public class sellListModel extends jdbc {

	//���ӳ�����
		public void add(sellList list){
			
			try{
				Connection con = initDB();
				
				Statement stmt = con.createStatement();
				
				String query = "insert into sellList(sell_id,sell_date,sell_totalPrice,unitId,acc_id) values ('"
						+list.getSell_id()+"','"
						+list.getSell_date()+"','"
						+list.getSell_totalPrice()+"','"
						+list.getUnit_id()+"','"
						+list.getAcc_id()+"')";
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
	
		public void update(sellList list){
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "update sellList set sell_date='"
				+list.getSell_date()+"',purch_totalPrice='"+list.getSell_totalPrice()+
				"',unitId='"+list.getUnit_id()+
				"',acc_id='"+list.getAcc_id()+"' where purch_id ='"+list.getSell_id()+"'";
				
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
		
		public sellList findBySell_id(String sell_id){
			sell_id.trim();
			sellList sell = new sellList();
			
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellList where sell_id ='"+sell_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				sell.setSell_id(rs.getString("sell_id"));
				sell.setSell_date(rs.getString("sell_date"));
				sell.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
				sell.setUnit_id(rs.getString("unitId"));
				sell.setAcc_id(rs.getString("acc_id"));		

				
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
			
			return sell;
		}
		//������Ʒ�����м�¼
		public ArrayList<sellList> select()
		{
			sellList sel;
			ArrayList<sellList> sellLists = new ArrayList<sellList>();
			
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellList";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					sel = new sellList();
                    sel.setSell_id(rs.getString("sell_id"));
					sel.setSell_date(rs.getString("sell_date"));
					sel.setAcc_id(rs.getString("acc_id"));
					sel.setUnit_id(rs.getString("unitid"));
					sel.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
					
					sellLists.add(sel);
					sel = null;
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
			
			return sellLists;			
		}

		
		
		//����ʱ���������,���س�����
		//ע�����
		/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			
			Date date1 = new Date(2014-1900,6-1,25);

			String day1=sdf.format(date1);
			����������ȡ*/
		public ArrayList<sellList> findBySell_dates(String day1,String day2 ){
			
			sellList list;
			ArrayList<sellList> showList = new ArrayList<sellList>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellList where sell_date between'"+day1+"'and'"+day2+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new sellList();
					list.setSell_id(rs.getString("sell_id"));
					list.setSell_date(rs.getString("sell_date"));
					list.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
					list.setUnit_id(rs.getString("unitId"));
					list.setAcc_id(rs.getString("acc_id"));				
					showList.add(list);
					list = null;
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
			
			return showList;
		}
		
		//���ݾ���ʱ�������ң���������������
		public ArrayList<sellList> findBySell_date(String sell_date ){
			
			    sellList list;
				ArrayList<sellList> showList = new ArrayList<sellList>();
				try{
					
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from sellList where sell_date='"+sell_date+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						list = new sellList();
						list.setSell_id(rs.getString("sell_id"));
						list.setSell_date(rs.getString("sell_date"));
						list.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
						list.setUnit_id(rs.getString("unitId"));
						list.setAcc_id(rs.getString("acc_id"));					
						showList.add(list);
						list = null;
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
				
				return showList;
			}

		//���ݽ����̣�������λ��������
		public ArrayList<sellList> findByUnit_id(String unit_id ){
			sellList list;
			ArrayList<sellList> showList = new ArrayList<sellList>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellList where unitId='"+unit_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new sellList();
					list.setSell_id(rs.getString("sell_id"));
					list.setSell_date(rs.getString("sell_date"));
					list.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
					list.setUnit_id(rs.getString("unitId"));
					list.setAcc_id(rs.getString("acc_id"));
					
					showList.add(list);
					list = null;
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
			
			return showList;		
		}
		
		//���������˺�������
		public ArrayList<sellList> findByAcc_id(String acc_id ){
			sellList list;
			ArrayList<sellList> showList = new ArrayList<sellList>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellList where acc_id='"+acc_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new sellList();
					list.setSell_id(rs.getString("sell_id"));
					list.setSell_date(rs.getString("sell_date"));
					list.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
					list.setUnit_id(rs.getString("unitId"));
					list.setAcc_id(rs.getString("acc_id"));
					
					showList.add(list);
					list = null;
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
			
			return showList;		
		}	
}
