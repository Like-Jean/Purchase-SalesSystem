package Model;
/*@author yixiu
 *@version 1.0
 * ��warehouse����в������࣬������ɾ�Ĳ��Լ��ض��İ���id��name���в���
 * ���������ʱ����Ϊwarehouseʵ���࣬Ĭ�ϲֿ�������������������㻹�д���ȶ
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.warehouse;
public class warehouseModel extends jdbc{

    //����id��ֿ���
	public void add(warehouse warh){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into warehouse(warh_id,warh_name,warh_remark) values ("
			+warh.getWarh_id()+",'"+warh.getWarh_name()+"','"+warh.getWarh_remark()+"')";
			
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
    //ɾ������,�Ὣ�òֿ��µ�������ƷҲɾ��
	public void delete(String warh_id){
		//�ȶ������ַ�����ʽ��
		warh_id.trim();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from warehouse where warh_id="+warh_id;
			
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
    //���²�����ע�������ǶԳ���������������ͬʱ���£��趨����������Ҫ���µ��ı���������ʾԭ������Ϣ���޸ĺ�
	//�ٽ���Щ�������¸�ֵ��warehouse�����ٵ��øú�����ɸ���
	public void update(warehouse warh){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update warehouse set warh_name='"
			+warh.getWarh_name()+"',warh_remark='"+warh.getWarh_remark()+"'where warh_id='"
					+warh.getWarh_id()+"'";
			
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
    //���ر������м�¼�����Ϊwarehouse������
	public ArrayList<warehouse> select(){
		warehouse warh;
		ArrayList<warehouse> warhList = new ArrayList<warehouse>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from warehouse";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				warh = new warehouse();
				warh.setWarh_id(rs.getString("warh_id"));
				warh.setWarh_name(rs.getString("warh_name"));
				warh.setWarh_remark(rs.getString("warh_remark"));
				
				warhList.add(warh);
				warh = null;
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
		
		return warhList;
	} 
    //ͨ��id��������
	public warehouse findById(String warh_id){
		warh_id.trim();
		warehouse warh = new warehouse();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from warehouse where warh_id="+warh_id;
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			warh.setWarh_id(rs.getString("warh_id"));
			warh.setWarh_name(rs.getString("warh_name"));
			warh.setWarh_remark(rs.getString("warh_remark"));
				

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
		
		return warh;		
	}
	//ͨ���ֿ�������
	public ArrayList<warehouse> findByName(String warh_name){
		warh_name.trim();
		warehouse warh;
		ArrayList<warehouse> warhList = new ArrayList<warehouse>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from warehouse where warh_name='"+warh_name+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				warh = new warehouse();
				warh.setWarh_id(rs.getString("warh_id"));
				warh.setWarh_name(rs.getString("warh_name"));
				warh.setWarh_remark(rs.getString("warh_remark"));
				
				warhList.add(warh);
				warh = null;
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
		
		return warhList;		
	}
}
