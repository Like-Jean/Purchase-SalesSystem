package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.sellingGoodsList;

public class sellingGoodsListModel extends jdbc {
	
	//���Ӽ�¼
	public void add(sellingGoodsList god){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into sellingGoodsList(sellingListId,warh_id,goods_id,goods_name,goods_quantity,goods_price) values ("
			+"'"+god.getSellingList_id()
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
		
		//ͨ����Ʒ�š����۵���������ĳ��������Ʒ��¼
		public sellingGoodsList findOneRecord(String sellingGoodsList_id, String goods_id)
		{
			goods_id.trim();
			sellingGoodsList_id.trim();
			sellingGoodsList god = new sellingGoodsList();
			
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellingGoodsList where sellingListId="+sellingGoodsList_id+" and goods_id='"+goods_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				god.setSellingList_id(rs.getString("sellingList_id"));
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
		
		//ͨ�����۵���������ĳ�ν�����������Ʒ
		public ArrayList<sellingGoodsList> findBysellingList (String sellingList_id)
		{
			sellingList_id.trim();
			sellingGoodsList god;
			ArrayList<sellingGoodsList> goodsList = new ArrayList<sellingGoodsList>();
			
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from sellingGoodsList where sellingListId='"+sellingList_id+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					god = new sellingGoodsList();
					god.setSellingList_id(rs.getString("sellingList_id"));
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
		public void deleteOneRecord(String sellingGoodsList_id,String goods_id)
		{
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "delete from sellingGoodsList where sellingListId='"+sellingGoodsList_id+"' and goods_id='"+goods_id+"'";
				
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
		public void deleteRecords(String sellingList_id)
		{
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "delete from sellingGoodsList where sellingListId='"+sellingList_id+"'";
				
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
