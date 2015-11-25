package Model;
//���۵��Ĳ���
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.sellingList;
	
public class sellingListModel extends jdbc {
	//�������۵�
	public void add(sellingList list){
		
		try{
			Connection con = initDB();
			
			Statement stmt = con.createStatement();
			
			String query = "insert into sellingList(sellingListId,selling_date,unitId char,handler,totalPayment,acc_id) values ('"
					+list.getSelling_id()+"','"
					+list.getSelling_date()+"','"
					+list.getUnit_id()+"','"
					+list.getSelling_handler()+"','"
					+list.getSelling_totalPrice()+"','"
					+list.getAcc_id()+
					"')";
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
	//�������۵�
	public void update(sellingList list){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update sellingList set selling_date='"
			+list.getSelling_date()+"',totalPayment='"+list.getSelling_totalPrice()+
			"',unitId='"+list.getUnit_id()+
			"',handler='"+list.getSelling_handler()+"',acc_id='"+list.getAcc_id()+"' where sellingListId ='"+list.getSelling_id()+"'";
			
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
	//ͨ�����۵�IDѰ�����۵�
	public sellingList findBySell_id(String sell_id){
		sell_id.trim();
		sellingList sell = new sellingList();
		
		try{
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellingList where selling_id ='"+sell_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			sell.setSelling_id(rs.getString("selling_id"));
			sell.setSelling_date(rs.getString("selling_date"));
			sell.setUnit_id(rs.getString("unitId"));
			sell.setSelling_handler(rs.getString("handler"));		
			sell.setSelling_totalPrice(rs.getFloat("totalPayment"));
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
	//�������۵����м�¼
	public ArrayList<sellingList> select()
	{
		sellingList sel;
		ArrayList<sellingList> sellingLists = new ArrayList<sellingList>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellingList";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				sel = new sellingList();
                sel.setSelling_id(rs.getString("selling_id"));
				sel.setSelling_date(rs.getString("selling_date"));
				sel.setUnit_id(rs.getString("unitid"));
				sel.setSelling_handler(rs.getString("handler"));
				sel.setSelling_totalPrice(rs.getFloat("totalPayment"));
				sel.setAcc_id(rs.getString("acc_id"));
				sellingLists.add(sel);
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
		
		return sellingLists;			
	}

	
	
	//����ʱ���������,�������۵�
	//ע�����
	/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date1 = new Date(2014-1900,6-1,25);

		String day1=sdf.format(date1);
		����������ȡ*/
	public ArrayList<sellingList> findBySell_dates(String day1,String day2 ){
		
		sellingList list;
		ArrayList<sellingList> showList = new ArrayList<sellingList>();
		try{
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellingList where selling_date between'"+day1+"'and'"+day2+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new sellingList();
				list.setSelling_id(rs.getString("selling_id"));
				list.setSelling_date(rs.getString("selling_date"));
				list.setUnit_id(rs.getString("unitid"));
				list.setSelling_handler(rs.getString("handler"));
				list.setSelling_totalPrice(rs.getFloat("totalPayment"));
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
	
	//���ݾ���ʱ�������ң������������۵�
	public ArrayList<sellingList> findBySell_date(String sell_date ){
		
		    sellingList list;
			ArrayList<sellingList> showList = new ArrayList<sellingList>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellingList where selling_date='"+sell_date+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new sellingList();
					list.setSelling_id(rs.getString("selling_id"));
					list.setSelling_date(rs.getString("selling_date"));
					list.setUnit_id(rs.getString("unitid"));
					list.setSelling_handler(rs.getString("handler"));
					list.setSelling_totalPrice(rs.getFloat("totalPayment"));
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
	public ArrayList<sellingList> findByUnit_id(String unit_id ){
		sellingList list;
		ArrayList<sellingList> showList = new ArrayList<sellingList>();
		try{
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellingList where unitId='"+unit_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new sellingList();
				list.setSelling_id(rs.getString("selling_id"));
				list.setSelling_date(rs.getString("selling_date"));
				list.setUnit_id(rs.getString("unitid"));
				list.setSelling_handler(rs.getString("handler"));
				list.setSelling_totalPrice(rs.getFloat("totalPayment"));		
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
