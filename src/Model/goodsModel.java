package Model;
/*@author yixiu
 *@version beta
 * ��goods����в�������
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.goods;

public class goodsModel extends jdbc{
	
	public void add(goods god){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into goods(goods_id,warh_id,goods_name,goods_category," +
					"goods_quantity,goods_up,goods_down,goods_cost,goods_prprice,goods_factory," +
					"goods_version) values ("
			+god.getGoods_id()+",'"+god.getWarh_id()+"','"+god.getGoods_name()+"','"+god.getGoods_category()+
			"','"+god.getGoods_quantity()+"','"+god.getGoods_up()+"','"+god.getGoods_down()+"','"+
			god.getGoods_cost()+"','"+god.getGoods_prprice()+"','"+god.getGoods_factory()+"','"+
			god.getGoods_version()+"')";
			
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
    //ɾ��������Ʒ�źͲֿ�ŵ�ȫ����¼
	public void delete(String goods_id,String warh_id){

		goods_id.trim();
		warh_id.trim();
	
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "delete from goods where warh_id="+warh_id+" and goods_id='"+goods_id+"'";
			
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
	
	//��ȡ������Ʒ�źͲֿ�ŵ���Ʒ������
	public int getQuantity(String goods_id,String warh_id){
		warh_id.trim();
		goods_id.trim();
		int x = 0;
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select goods_quantity from goods where warh_id="
			+warh_id+" and goods_id='"+goods_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			x = rs.getInt("goods_quantity");
				

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
		return x;
	}

	//���ٸ�����Ʒ�źͲֿ�ŵ���Ʒ������
	public void reduce(String goods_id,String warh_id,int mount){
		
		goods_id.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_id,warh_id);
	    formalQuantity -= mount;
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_id='"+goods_id+"'";
			
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

	//���Ӹ�����Ʒ�źͲֿ�ŵ���Ʒ������
	public void increase(String goods_id,String warh_id,int mount){
		goods_id.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_id,warh_id);
	    formalQuantity += mount;
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_id='"+goods_id+"'";
			
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

	//�޸ĸ�����Ʒ�źͲֿ�ŵ���Ʒ����
	public void update(goods god){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update goods set goods_name='"
			+god.getGoods_name()+"',goods_category='"+god.getGoods_category()+
			"',goods_up='"+god.getGoods_up()+
			"',goods_down='"+god.getGoods_down()+
			"',goods_cost='"+god.getGoods_cost()+
			"',goods_prprice='"+god.getGoods_prprice()+
			"',goods_quantity='"+god.getGoods_quantity()+
			"',goods_factory='"+god.getGoods_factory()+
			"',goods_version='"+god.getGoods_version()+"'where goods_id='"
					+god.getGoods_id()+"' and warh_id='"+god.getWarh_id()+"'";
			
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

    //��ʾ���ݿ�������Ԫ��
	public ArrayList<goods> select(){
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new goods();
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_category(rs.getString("goods_category"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_up(rs.getInt("goods_up"));
				god.setGoods_down(rs.getInt("goods_down"));
				god.setGoods_prprice(rs.getInt("goods_prprice"));
				god.setGoods_cost(rs.getInt("goods_cost"));
				god.setGoods_version(rs.getString("goods_version"));
				god.setGoods_factory(rs.getString("goods_factory"));
				
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

	//ͨ��������Ʒ�źͲֿ�Ż�ȡԪ����Ϣ
	public goods findById(String goods_id,String warh_id){
		goods_id.trim();
		warh_id.trim();		
		goods god = null;

		try{
			god = new goods();
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods where warh_id="+warh_id+" and goods_id='"+goods_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			god.setWarh_id(rs.getString("warh_id"));
			god.setGoods_name(rs.getString("goods_name"));
			god.setGoods_id(rs.getString("goods_id"));
			god.setGoods_category(rs.getString("goods_category"));
			god.setGoods_quantity(rs.getInt("goods_quantity"));
			god.setGoods_up(rs.getInt("goods_up"));
			god.setGoods_down(rs.getInt("goods_down"));
			god.setGoods_prprice(rs.getInt("goods_prprice"));
			god.setGoods_cost(rs.getInt("goods_cost"));
			god.setGoods_version(rs.getString("goods_version"));
			god.setGoods_factory(rs.getString("goods_factory"));
				

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

	//ͨ��������Ʒ���ֲ���Ԫ��
	public ArrayList<goods> findByName(String goods_name){
		goods_name.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods where goods_name='"+goods_name+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new goods();
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_category(rs.getString("goods_category"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_up(rs.getInt("goods_up"));
				god.setGoods_down(rs.getInt("goods_down"));
				god.setGoods_prprice(rs.getInt("goods_prprice"));
				god.setGoods_cost(rs.getInt("goods_cost"));
				god.setGoods_version(rs.getString("goods_version"));
				god.setGoods_factory(rs.getString("goods_factory"));
				
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

	//ͨ�������ֿ�id����Ԫ��
	public ArrayList<goods> findByWarh_id(String warh_id){
		warh_id.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods where warh_id='"+warh_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new goods();
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_category(rs.getString("goods_category"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_up(rs.getInt("goods_up"));
				god.setGoods_down(rs.getInt("goods_down"));
				god.setGoods_prprice(rs.getInt("goods_prprice"));
				god.setGoods_cost(rs.getInt("goods_cost"));
				god.setGoods_version(rs.getString("goods_version"));
				god.setGoods_factory(rs.getString("goods_factory"));
				
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
	
	//ͨ��������Ʒ�������Ԫ��
	public ArrayList<goods> findByCategory(String goods_category){
		goods_category.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods where goods_category='"+goods_category+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new goods();
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_category(rs.getString("goods_category"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_up(rs.getInt("goods_up"));
				god.setGoods_down(rs.getInt("goods_down"));
				god.setGoods_prprice(rs.getInt("goods_prprice"));
				god.setGoods_cost(rs.getInt("goods_cost"));
				god.setGoods_version(rs.getString("goods_version"));
				god.setGoods_factory(rs.getString("goods_factory"));
				
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

	//ͨ�������������̲���Ԫ��
	public ArrayList<goods> findByFactory(String goods_factory){
		goods_factory.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods where goods_factory='"+goods_factory+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new goods();
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_category(rs.getString("goods_category"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_up(rs.getInt("goods_up"));
				god.setGoods_down(rs.getInt("goods_down"));
				god.setGoods_prprice(rs.getInt("goods_prprice"));
				god.setGoods_cost(rs.getInt("goods_cost"));
				god.setGoods_version(rs.getString("goods_version"));
				god.setGoods_factory(rs.getString("goods_factory"));
				
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

	//ͨ��������ƷID����Ԫ��
	public ArrayList<goods> findByGoodId(String goods_id){
		goods_id.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from goods where goods_id='"+goods_id+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new goods();
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setGoods_category(rs.getString("goods_category"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_up(rs.getInt("goods_up"));
				god.setGoods_down(rs.getInt("goods_down"));
				god.setGoods_prprice(rs.getInt("goods_prprice"));
				god.setGoods_cost(rs.getInt("goods_cost"));
				god.setGoods_version(rs.getString("goods_version"));
				god.setGoods_factory(rs.getString("goods_factory"));
				
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

	//��ȡ������Ʒ���ƺͲֿ�ŵ���Ʒ������
	public int getQuantity2(String goods_name,String warh_id){
	
		int x = 0;
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select goods_quantity from goods where warh_id="
			+warh_id+" and goods_name='"+goods_name+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			x = rs.getInt("goods_quantity");
				

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
		return x;
	}
	
	//���ٸ�����Ʒ�źͲֿ�ŵ���Ʒ������
	public void reduce2(String goods_name,String warh_id,int mount){
		
		goods_name.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_name,warh_id);
	    formalQuantity -= mount;
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_name='"+goods_name+"'";
			
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

	//���Ӹ�����Ʒ�źͲֿ�ŵ���Ʒ������
	public void increase2(String goods_name,String warh_id,int mount){
		goods_name.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_name,warh_id);
	    formalQuantity += mount;
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_name='"+goods_name+"'";
			
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
}
