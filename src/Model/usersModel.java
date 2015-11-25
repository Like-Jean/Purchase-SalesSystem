package Model;
/*@author yixiu
 *@version beta
 * ��users����в�������
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.goods;
import Entity.users;
public class usersModel extends jdbc{
    //����Ԫ��
	public void add(users user){
		try{
			Connection con = initDB();
			// ����SQL�������
			
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into users(users_id,users_psw,users_authority," +
					"empl_id) values ("
			+user.getUsers_id()+",'"+user.getUsers_psw()+"','"+user.getUsers_authority()+
			"','"+user.getEmpl_id()+"')";
			
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
    //ɾ��ָ��id�ŵ�Ԫ��
	public void delete(String users_id){
		users_id.trim();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from users where users_id='"+users_id+"'";
			
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
    //�޸�ָ��id�ŵ��û�����
	public void update(users user){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update users set users_psw='"
			+user.getUsers_psw()+"',users_authority='"+user.getUsers_authority()+
			"',empl_id='"+user.getEmpl_id()+"'where users_id='"
					+user.getUsers_id()+"'";
			
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
	//�޸�ָ��id�ŵ�����
	public void updatePsw(String users_id,String users_psw){
		users_id.trim();
		users_psw.trim();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update users set users_psw='"
			+users_psw+"'where users_id='"
					+users_id+"'";
			
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
	//��������Ԫ��
	public ArrayList<users> selsct(){
		users user;
		ArrayList<users> usersList = new ArrayList<users>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from users";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				user = new users();
				user.setUsers_id(rs.getString("users_id"));
				user.setUsers_psw(rs.getString("users_psw"));
				user.setUsers_authority(rs.getInt("users_authority"));
				user.setEmpl_id(rs.getString("empl_id"));
				
				usersList.add(user);
				user = null;
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
		
		return usersList;			
	}
	//ͨ��id��������
	public users findById(String users_id){
		users_id.trim();
		users user = new users();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from users where users_id='"+users_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setUsers_id(rs.getString("users_id"));
			user.setUsers_psw(rs.getString("users_psw"));
			user.setUsers_authority(rs.getInt("users_authority"));
			user.setEmpl_id(rs.getString("empl_id"));
			

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
		
		return user;		
	}
	//ͨ��Ա����������
	public users findByEmpl_id(String empl_id){
		empl_id.trim();
		users user = new users();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from users where empl_id='"+empl_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setUsers_id(rs.getString("users_id"));
			user.setUsers_psw(rs.getString("users_psw"));
			user.setUsers_authority(rs.getInt("users_authority"));
			user.setEmpl_id(rs.getString("empl_id"));
			

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
		
		return user;		
	}	
	//ͨ��Ȩ�޲���
	public users findByAuthority(int users_authority){
		users user = new users();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from users where users_authority='"+users_authority+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setUsers_id(rs.getString("users_id"));
			user.setUsers_psw(rs.getString("users_psw"));
			user.setUsers_authority(rs.getInt("users_authority"));
			user.setEmpl_id(rs.getString("empl_id"));
			

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
		
		return user;		
	}	
}
