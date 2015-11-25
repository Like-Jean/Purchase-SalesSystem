package Model;
/*@author Like
 *@version beta
 * ��goodsList����в�������
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.goodsList;

public class goodsListModel extends jdbc {
	
	//���Ӽ�¼
	public void add(goodsList god){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into goodsList(purchase_id,warh_id,goods_id,goods_name,goods_quantity,goods_price) values ("
			+"'"+god.getPurchase_id()
			+"','"+god.getWarh_id()
			+"','"+god.getGoods_id()
			+"','"+god.getGoods_name()
			+"','"+god.getGoods_quantity()
			+"','"+god.getGoods_price()+"')";
			
			// ִ��SQL���
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
		
		//ͨ����Ʒ�š�������������ĳ��������Ʒ��¼
		public goodsList findOneRecord(String purchase_id, String goods_id)
		{
			goods_id.trim();
			purchase_id.trim();
			goodsList god = new goodsList();
			
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from goodsList where purchase_id="+purchase_id+" and goods_id='"+goods_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				god.setPurchase_id(rs.getString("purchase_id"));
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_price(rs.getFloat("goods_price"));
				
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
			
			return god;
		}
		
		//ͨ��������������ĳ�ν�����������Ʒ
		public ArrayList<goodsList> findByPurchase (String purchase_id)
		{
			purchase_id.trim();
			goodsList god;
			ArrayList<goodsList> goodsList = new ArrayList<goodsList>();
			
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from goodsList where purchase_id='"+purchase_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					god = new goodsList();
					god.setPurchase_id(rs.getString("purchase_id"));
					god.setGoods_id(rs.getString("goods_id"));
					god.setWarh_id(rs.getString("warh_id"));
					god.setGoods_name(rs.getString("goods_name"));
					god.setGoods_quantity(rs.getInt("goods_quantity"));
					god.setGoods_price(rs.getFloat("goods_price"));
					
					goodsList.add(god);
					god = null;
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
			
			return goodsList;			
		}
		
		//������Ʒ�����м�¼
		public ArrayList<goodsList> select()
		{
			goodsList god;
			ArrayList<goodsList> goodsList = new ArrayList<goodsList>();
			
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from goodsList";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					god = new goodsList();
					god.setPurchase_id(rs.getString("purchase_id"));
					god.setGoods_id(rs.getString("goods_id"));
					god.setWarh_id(rs.getString("warh_id"));
					god.setGoods_name(rs.getString("goods_name"));
					god.setGoods_quantity(rs.getInt("goods_quantity"));
					god.setGoods_price(rs.getFloat("goods_price"));
					
					goodsList.add(god);
					god = null;
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
			
			return goodsList;			
		}
	
		//ɾ��һ���ض���¼
		public void deleteOneRecord(String purchase_id,String goods_id)
		{
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "delete from goodsList where purchase_id='"+purchase_id+"' and goods_id='"+goods_id+"'";
				
				// ִ��SQL���
				stmt.execute(query);

				// �ر������������
				stmt.close();

				// �ر����ݿ�����
				con.close();			
			}catch(SQLException e){
				System.out.println("ɾ������ʧ�ܣ�");
				e.printStackTrace();			
			}
		}
	
		//ɾ��һ�ν����Ķ�����Ʒ��¼
		public void deleteRecords(String purchase_id)
		{
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "delete from goodsList where purchase_id='"+purchase_id+"'";
				
				// ִ��SQL���
				stmt.execute(query);

				// �ر������������
				stmt.close();

				// �ر����ݿ�����
				con.close();			
			}catch(SQLException e){
				System.out.println("ɾ������ʧ�ܣ�");
				e.printStackTrace();			
			}
		}

}
