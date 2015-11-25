package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import Entity.quotation;


public class quotationModel extends jdbc {
	
	//���ӱ��۵�
		public void add(quotation quo){
			
			try{
				Connection con = initDB();
				
				Statement stmt = con.createStatement();
				
				String query = "insert into quotation(quoId,quoDate,unitId,unitName,handler,remarks) values ('"
						+quo.getQuoId()+"','"
						+quo.getQuoDate()+"','"
						+quo.getUnitId()+"','"
						+quo.getUnitName()+"','"
						+quo.getHandler()+"','"
						+quo.getRemarks()+"')";
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
		
		
		public void update(quotation quo){
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "update quotation set quoDate='"
				+quo.getQuoDate()
				+"',unitId='"+quo.getUnitId()
				+"',unitName='"+quo.getUnitName()
				+"',handler='"+quo.getHandler()
				+"',remarks='"+quo.getRemarks()+"' where quoId ='"+quo.getQuoId()+"'";
				
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
		
		
		//ɾ������
		public void delete(String quoId){
			quoId.trim();
			try{
				Connection con = initDB();
				Statement stmt = con.createStatement();
				String query = "delete from quotation where quoId='"+quoId+"'";
				stmt.execute(query);
				stmt.close();
				con.close();			
			   }catch(SQLException e){
				System.out.println("ɾ������ʧ�ܣ�");
				e.printStackTrace();			
			}
		}
		
		public quotation findByQuoId(String quoId){
			quoId.trim();
			quotation quo = new quotation();
			
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from quotation where quoId ='"+quoId+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
	          quo.setQuoId(rs.getString("quoId"));
	          quo.setQuoDate(rs.getString("quoDate"));
	          quo.setUnitId(rs.getString("unitId"));
	          quo.setUnitName(rs.getString("unitName"));
	          quo.setHandler(rs.getString("handler"));
	          quo.setRemarks(rs.getString("remarks"));

				
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
			
			return quo;
		}
		
		//����������λ������
		public ArrayList<quotation> findByUnitId(String unitId ){
			quotation quo;
			ArrayList<quotation> quoList = new ArrayList<quotation>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from quotation where unitId='"+unitId+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					quo = new quotation();
			        quo.setQuoId(rs.getString("quoId"));
			          quo.setQuoDate(rs.getString("quoDate"));
			          quo.setUnitId(rs.getString("unitId"));
			          quo.setUnitName(rs.getString("unitName"));
			          quo.setHandler(rs.getString("handler"));
			          quo.setRemarks(rs.getString("remarks"));
					
					quoList.add(quo);
					quo = null;
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
			
			return quoList;		
		}
		
		
		//���ر��۵����м�¼
		public ArrayList<quotation> select()
		{
			quotation quo;
			ArrayList<quotation> quoList = new ArrayList<quotation>();
			
			try{
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from quotation";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					quo = new quotation();
			        quo.setQuoId(rs.getString("quoId"));
			          quo.setQuoDate(rs.getString("quoDate"));
			          quo.setUnitId(rs.getString("unitId"));
			          quo.setUnitName(rs.getString("unitName"));
			          quo.setHandler(rs.getString("handler"));
			          quo.setRemarks(rs.getString("remarks"));
					
					quoList.add(quo);
					quo = null;
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
			
			return quoList;			
		}
		
		
		


}
