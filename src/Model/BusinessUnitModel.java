package Model;
/*������λ�Ĳ�����*/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.BusinessUnit;
public class BusinessUnitModel extends jdbc{

    //������
	public void add(BusinessUnit busUnit){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into BusinessUnit(unitId,unitName,unitNature,area,trade,"+
"linkman,address,bank,accountNum,phone,mail,mainBusiness) values ('"
+busUnit.getUnitId()+"','"+busUnit.getUnitName()+"','"
+busUnit.getUnitNature()+"','"+busUnit.getArea()+"','"
+busUnit.getTrade()+"','"+busUnit.getLinkman()+"','"
+busUnit.getAddress()+"','"+busUnit.getBank()+"','"
+busUnit.getAccountNum()+"','"+busUnit.getPhone()+"','"+busUnit.getMail()+"','"+busUnit.getMainBusiness()+"')";
			
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
    //ɾ������
	public void delete(String unitId){
		//�ȶ������ַ�����ʽ��
		unitId.trim();
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from BusinessUnit where unitId='"+unitId+"'";
			
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
    //���²�����ע�������ǶԳ���������������ͬʱ���£��趨����������Ҫ���µ��ı���������ʾԭ������Ϣ���޸ĺ�
	//�ٽ���Щ�������¸�ֵ��BusinessUnit�����ٵ��øú�����ɸ���
	public void update(BusinessUnit busUnit){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update BusinessUnit set " +
"unitName='"+busUnit.getUnitName()
+"',unitNature='"+busUnit.getUnitNature()
+"',area='"+busUnit.getArea()
+"',trade='"+busUnit.getTrade()
+"',linkman='"+busUnit.getLinkman()
+"',address='"+busUnit.getAddress()
+"',bank='"+busUnit.getBank()
+"',accountNum='"+busUnit.getAccountNum()
+"',phone='"+busUnit.getPhone()
+"',mail='"+busUnit.getMail()
+"',mainBusiness='"+busUnit.getMainBusiness()
+"'where unitId='"+busUnit.getUnitId()+"'";
			
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
    //���ر������м�¼�����ΪBusinessUnit������
	public ArrayList<BusinessUnit> select(){
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from BusinessUnit";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
                                busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));
				
				busUnitList.add(busUnit);
				busUnit = null;
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
		
		return busUnitList;
	} 
    //ͨ��unitId������
	public BusinessUnit findById(String unitId){
		unitId.trim();
		BusinessUnit busUnit = new BusinessUnit();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from BusinessUnit where unitId='"+unitId+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

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
		
		return busUnit;		
	}
	//ͨ����λ������
	public ArrayList<BusinessUnit> findByName(String unitName){
		unitName.trim();
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from BusinessUnit where unitName='"+unitName+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

				
				busUnitList.add(busUnit);
				busUnit=null;
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
		
		return busUnitList;		
	}
	//ͨ����������
	public ArrayList<BusinessUnit> findByArea(String area){
		area.trim();
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from BusinessUnit where area='"+area+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

				
				busUnitList.add(busUnit);
				busUnit=null;
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
		
		return busUnitList;		
	}
	//ͨ����ҵ����
	public ArrayList<BusinessUnit> findByTrade(String trade){
		trade.trim();
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from BusinessUnit where trade='"+trade+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

				
				busUnitList.add(busUnit);
				busUnit=null;
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
		
		return busUnitList;		
	}
}