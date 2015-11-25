package Model;
/*@author Like
 *@version 1.0
 * ��sellGoodsList����в�������
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.sellGoodsList;
public class sellGoodsListModel extends jdbc{
	
	//���Ӽ�¼
	public void add(sellGoodsList god){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into sellGoodsList(sell_id,warh_id,goods_id,goods_name,goods_quantity,goods_price) values ("
			+"'"+god.getSell_id()
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

	//ͨ����Ʒ�š���������������ĳ��������Ʒ��¼
	public sellGoodsList findOneRecord(String sell_id, String goods_id)
	{
		goods_id.trim();
		sell_id.trim();
		sellGoodsList god = new sellGoodsList();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellGoodsList where sell_id="+sell_id+" and goods_id='"+goods_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			god.setSell_id(rs.getString("purchase_id"));
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
	
	//ͨ����������������ĳ�γ�����������Ʒ
	public ArrayList<sellGoodsList> findBySell (String sell_id)
	{
		sell_id.trim();
		sellGoodsList god;
		ArrayList<sellGoodsList> sellGoodsList = new ArrayList<sellGoodsList>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellGoodsList where purchase_id='"+sell_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new sellGoodsList();
				god.setSell_id(rs.getString("sell_id"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_price(rs.getFloat("goods_price"));
				
				sellGoodsList.add(god);
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
		
		return sellGoodsList;			
	}
	
	//������Ʒ�����м�¼
	public ArrayList<sellGoodsList> select()
	{
		sellGoodsList god;
		ArrayList<sellGoodsList> sellGoodsList = new ArrayList<sellGoodsList>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from sellGoodsList";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new sellGoodsList();
				god.setSell_id(rs.getString("sell_id"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_price(rs.getFloat("goods_price"));
				
				sellGoodsList.add(god);
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
		
		return sellGoodsList;			
	}

	//ɾ��һ���ض���¼
	public void deleteOneRecord(String sell_id,String goods_id)
	{
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from sellGoodsList where sell_id='"+sell_id+"' and goods_id='"+goods_id+"'";
			
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
	public void deleteRecords(String sell_id)
	{
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from sellGoodsList where sell_id='"+sell_id+"'";
			
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
