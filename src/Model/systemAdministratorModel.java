package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.systemAdministrator;
public class systemAdministratorModel extends jdbc{

    //������
	public void add(systemAdministrator sysadm){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into systemAdministrator(sysAdmId,password) values ('"
			+sysadm.getSysAdmId()+"','"+sysadm.getPassword()+"')";
			
			// ִ��SQL���
			stmt.execute(query);

			// �ر������������
			stmt.close();

			// �ر����ݿ�����
			con.close();			
		}catch(SQLException e){
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();			
		}
		
	}
    //ɾ������
	public void delete(String sysAdmId){
		//�ȶ������ַ�����ʽ��
		sysAdmId.trim();
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from systemAdministrator where sysAdmId='"+sysAdmId+"'";
			
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
	//�ٽ���Щ�������¸�ֵ��systemAdministrator�����ٵ��øú�����ɸ���
	public void update(systemAdministrator sysadm){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update systemAdministrator set password='"
			+sysadm.getPassword()+"'where sysAdmId='"+sysadm.getSysAdmId()+"'";
			
			// ִ��SQL���
			stmt.execute(query);

			// �ر������������
			stmt.close();

			// �ر����ݿ�����
			con.close();			
		}catch(SQLException e){
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();			
		}		

	}
    //���ر������м�¼�����ΪsystemAdministrator������
	public ArrayList<systemAdministrator> select(){
		systemAdministrator sysadm;
		ArrayList<systemAdministrator> sysadmList = new ArrayList<systemAdministrator>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from systemAdministrator";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				sysadm = new systemAdministrator();
				sysadm.setSysAdmId(rs.getString("sysAdmId"));
				sysadm.setPassword(rs.getString("password"));
				
				
				sysadmList.add(sysadm);
				sysadm = null;
			}

			// �رռ�¼��
			rs.close();
			// �ر������������
			stmt.close();

			// �ر����ݿ�����
			con.close();			
		}catch(SQLException e){
			System.out.println("ɾ������ʧ�ܣ�");
			e.printStackTrace();			
		}
		
		return sysadmList;
	} 
    //ͨ��id��������
	public systemAdministrator findById(String sysAdmId){
		sysAdmId.trim();
		systemAdministrator sysadm = new systemAdministrator();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from systemAdministrator where sysAdmId='"+sysAdmId+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			sysadm.setSysAdmId(rs.getString("sysAdmId"));
			sysadm.setPassword(rs.getString("password"));
			

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
		
		return sysadm;		
	}
	
}