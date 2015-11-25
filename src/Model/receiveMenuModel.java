package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import Entity.receiveMenu;

public class receiveMenuModel extends jdbc {
	
	//���Ӳ���
	public void add(receiveMenu recm){
		try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "insert into receiveMenu(recm_id,rec_date,unitId,unitName,matchingMenu,handler,sell_totalPrice,acc_id)"
				+ " values ('"
		+recm.getRecm_id()+"','"+recm.getRec_date()+"','"+recm.getUnitId()+"','"
				+recm.getUnitName()+"','"+recm.getMatchingMenu()+"','"+recm.getSell_totalPrice()+"','"+recm.getAcc_id()+"')";
		stmt.execute(query);
		stmt.close();
		con.close();
		}catch(SQLException e){
			System.out.println("����տʧ�ܣ�");
			e.printStackTrace();
		}
	}
	
	//ɾ������
	public void delete(String recm_id){
		recm_id.trim();
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "delete from receiveMenu where recm_id='"+recm_id+"'";
			stmt.execute(query);
			stmt.close();
			con.close();			
		   }catch(SQLException e){
			System.out.println("ɾ���տʧ�ܣ�");
			e.printStackTrace();			
		}
	}
	
	//���²���
	public void update(receiveMenu recm){
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "update receiveMenu set rec_date='"
			+recm.getRec_date()+"',unitId='"+recm.getUnitId()+"',unitName='"+recm.getUnitName()+"',matchingMenu='"+recm.getMatchingMenu()
			+"',handler='"+recm.getHandler()+"',sell_totalPrice='"+recm.getSell_totalPrice()+"',acc_id='"+recm.getAcc_id()+"'where recm_id='"
			+recm.getRecm_id()+"'";
			stmt.execute(query);
			stmt.close();
			con.close();			
		    }catch(SQLException e){
			System.out.println("�����տʧ�ܣ�");
			e.printStackTrace();			
		}
	}
	
	//ͨ��id����
	public receiveMenu findById(String recm_id){
		recm_id.trim();
		 receiveMenu recm=new receiveMenu();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from receiveMenu where recm_id='"+recm_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			        recm.setRecm_id(rs.getString("recm_id"));
                                recm.setRec_date(rs.getString("rec_date"));
                                recm.setUnitId(rs.getString("unitId"));
                                recm.setUnitName(rs.getString("unitName"));
                                recm.setMatchingMenu(rs.getString("matchingMenu"));
                                recm.setHandler(rs.getString("handler"));
                                recm.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
                                recm.setAcc_id(rs.getString("acc_id"));
	
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
		
		return recm;		
	}
	
	//ͨ���ͻ�ID	����
	public ArrayList<receiveMenu> findByUnitId(String unitId){
		unitId.trim();
		receiveMenu recm;
		ArrayList<receiveMenu> recmList = new ArrayList<receiveMenu>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from receiveMenu where unitId='"+unitId+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				recm = new receiveMenu();
		        recm.setRecm_id(rs.getString("recm_id"));
                recm.setRec_date(rs.getString("rec_date"));
                recm.setUnitId(rs.getString("unitId"));
                recm.setUnitName(rs.getString("unitName"));
                recm.setMatchingMenu(rs.getString("matchingMenu"));
                recm.setHandler(rs.getString("handler"));
                recm.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
                recm.setAcc_id(rs.getString("acc_id"));
			        

				
                recmList.add(recm);
				recm=null;
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
		
		return recmList;		
	}
	
	
	//ͨ����Ӧ���ݲ���
	public receiveMenu findByMatchingMenu(String matchingMenu){
		matchingMenu.trim();
		 receiveMenu recm=new receiveMenu();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from receiveMenu where matchingMenu='"+matchingMenu+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			        recm.setRecm_id(rs.getString("recm_id"));
                                recm.setRec_date(rs.getString("rec_date"));
                                recm.setUnitId(rs.getString("unitId"));
                                recm.setUnitName(rs.getString("unitName"));
                                recm.setMatchingMenu(rs.getString("matchingMenu"));
                                recm.setHandler(rs.getString("handler"));
                                recm.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
                                recm.setAcc_id(rs.getString("acc_id"));
	
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
		
		return recm;		
	}
	
	//���������տ
	
	public ArrayList<receiveMenu> select(){
		receiveMenu recm;
		ArrayList<receiveMenu> recmList = new ArrayList<receiveMenu>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from receiveMenu";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				recm = new receiveMenu();
		        recm.setRecm_id(rs.getString("recm_id"));
                recm.setRec_date(rs.getString("rec_date"));
                recm.setUnitId(rs.getString("unitId"));
                recm.setUnitName(rs.getString("unitName"));
                recm.setMatchingMenu(rs.getString("matchingMenu"));
                recm.setHandler(rs.getString("handler"));
                recm.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
                recm.setAcc_id(rs.getString("acc_id"));
			        

				
                recmList.add(recm);
				recm=null;
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
		
		return recmList;		
	}
	
	//����ʱ���������,���ؽ�����
	//ע�����
	/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date1 = new Date(2014-1900,6-1,25);

		String day1=sdf.format(date1);
		����������ȡ*/
	public ArrayList<receiveMenu> findByReceiveDates(String day1,String day2 ){
		
		receiveMenu receive;
		ArrayList<receiveMenu> showReceive = new ArrayList<receiveMenu>();
		try{
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from receiveMenu where rec_date between'"+day1+"'and'"+day2+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				receive = new receiveMenu();
				receive.setRecm_id(rs.getString("recm_id"));
				receive.setRec_date(rs.getString("rec_date"));
				receive.setUnitId(rs.getString("unitId"));
				receive.setUnitName(rs.getString("unitName"));
				receive.setMatchingMenu(rs.getString("matchingMenu"));
				receive.setHandler(rs.getString("handler"));
				receive.setSell_totalPrice(rs.getFloat("sell_totalPrice"));
				receive.setAcc_id(rs.getString("acc_id"));
				showReceive.add(receive);
				receive = null;
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
		
		return showReceive;
	}
	
	
	

}
