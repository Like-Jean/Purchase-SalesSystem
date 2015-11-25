package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import Entity.quotationGoodsList;
public class quotationGoodsListModel extends jdbc {
	
	
	public void add(quotationGoodsList quoList){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "insert into quotationGoodsList(quoId,goods_id,goods_quantity,quotedPrice,otherCost) values ("
			+"'"+quoList.getQuoId()
			+"','"+quoList.getGoods_id()
			+"','"+quoList.getGoods_quantity()
			+"','"+quoList.getQuotedPrice()
			+"','"+quoList.getOtherCost()+"')";
			
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
	
	//ͨ����Ʒ�š����۵���������ĳ����Ʒ��¼
			public quotationGoodsList findOneRecord(String quoId, String goods_id)
			{
				goods_id.trim();
				quoId.trim();
				quotationGoodsList quolist = new quotationGoodsList();
				
				try{
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from quotationGoodsList where quoId="+quoId+" and goods_id='"+goods_id+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					quolist.setQuoId(rs.getString("quoId"));
					quolist.setGoods_id(rs.getString("goods_id"));
					quolist.setGoods_quantity(rs.getInt("goods_quantity"));
					quolist.setQuotedPrice(rs.getFloat("quotedPrice"));
					quolist.setOtherCost(rs.getFloat("otherCost"));

					
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
				
				return quolist;
			}
			
			public ArrayList<quotationGoodsList> findByQuo (String quoId)
			{
				quoId.trim();
				quotationGoodsList quo;
				ArrayList<quotationGoodsList> quoList = new ArrayList<quotationGoodsList>();
				
				try{
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from quotationGoodsList where quoId='"+quoId+"'";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						quo = new quotationGoodsList();
						quo.setQuoId(rs.getString("quoId"));
						quo.setGoods_id(rs.getString("goods_id"));
						quo.setGoods_quantity(rs.getInt("goods_quantity"));
						quo.setQuotedPrice(rs.getFloat("quotedPrice"));
						quo.setOtherCost(rs.getFloat("otherCost"));

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
			
			
			//�������м�¼
			public ArrayList<quotationGoodsList> select()
			{
				quotationGoodsList quo;
				ArrayList<quotationGoodsList> quoList = new ArrayList<quotationGoodsList>();
				
				try{
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "select * from quotationGoodsList";
					
					// ִ��SQL���
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						quo = new quotationGoodsList();
						quo.setQuoId(rs.getString("quoId"));
						quo.setGoods_id(rs.getString("goods_id"));
						quo.setGoods_quantity(rs.getInt("goods_quantity"));
						quo.setQuotedPrice(rs.getFloat("quotedPrice"));
						quo.setOtherCost(rs.getFloat("otherCost"));

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
			
			//ɾ��һ���ض���¼
			public void deleteOneRecord(String quoId,String goods_id)
			{
				try{
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "delete from quotationGoodsList where quoId='"+quoId+"' and goods_id='"+goods_id+"'";
					
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
	
			
			//ɾ��һ�����۵��Ķ�����Ʒ��¼
			public void deleteRecords(String quoId)
			{
				try{
					Connection con = initDB();
					// ����SQL�������
					Statement stmt = con.createStatement();
					// ����SQL�����ַ���
					String query = "delete from quotationGoodsList where quoId='"+quoId+"'";
					
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
