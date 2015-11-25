package Model;
//�ֿ�������Ĳ���
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Entity.transferringList;
	
public class transferringListModel extends jdbc {
	//���ӵ�����
	public void add(transferringList list){
		
		try{
			Connection con = initDB();
			
			Statement stmt = con.createStatement();
			
			String query = "insert into transferringList(transferringListId,transferringList_date,handler,outWarehouseId,inWareHouseId,quantities,goods_name) values ('"
					+list.getTransferringListId()+"','"
					+list.getTransferringList_date()+"','"
					+list.getHandler()+"','"
					+list.getOutWarehouseId()+"','"
					+list.getInWarehouseId()+"','"
					+list.getQuantities()+"','"
					+list.getGoods_name()+
					"')";
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
	//���µ�����
	public void update(transferringList list){
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "update transferringList set transferringList_date='"
			+list.getTransferringList_date()+"',quantities='"+list.getQuantities()+
			"',outWarehouseId='"+list.getOutWarehouseId()+
			"',inWareHouseId='"+list.getInWarehouseId()+"',handler='"+list.getHandler()+"',goods_name='"+list.getGoods_name()+"' where transferringListId ='"+list.getTransferringListId()+"'";
			
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
	//ͨ��������IDѰ�ҵ�����
	public transferringList findBytransferringListId(String transferringListId){
		transferringListId.trim();
		transferringList tsl = new transferringList();
		
		try{
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from transferringList where transferringListId ='"+transferringListId+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			tsl.setTransferringListId(rs.getString("transferringListId"));
			tsl.setTransferringList_date(rs.getString("transferringList_date"));
			tsl.setHandler(rs.getString("handler"));
			tsl.setOutWarehouseId(rs.getString("outWarehouseId"));
			tsl.setInWarehouseId(rs.getString("inWarehouseId"));
			tsl.setQuantities(rs.getInt("quantities"));
			tsl.setGoods_name(rs.getString("goods_name"));
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
		
		return tsl;
	}
	//���ص��������м�¼
	public ArrayList<transferringList> select()
	{
		transferringList sel;
		ArrayList<transferringList> sellingLists = new ArrayList<transferringList>();
		
		try{
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from transferringList";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				sel = new transferringList();
                sel.setTransferringListId(rs.getString("transferringListId"));
    			sel.setTransferringList_date(rs.getString("transferringList_date"));
    			sel.setHandler(rs.getString("handler"));
    			sel.setOutWarehouseId(rs.getString("outWarehouseId"));
    			sel.setInWarehouseId(rs.getString("inWarehouseId"));
    			sel.setQuantities(rs.getInt("quantities"));
    			sel.setGoods_name(rs.getString("goods_name"));
				sellingLists.add(sel);
				sel = null;
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
		
		return sellingLists;			
	}

	
	
	//����ʱ���������,���ص�����
	//ע�����
	/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date1 = new Date(2014-1900,6-1,25);

		String day1=sdf.format(date1);
		����������ȡ*/
	public ArrayList<transferringList> findBytTransferringList_dates(String day1,String day2 ){
		
		transferringList list;
		ArrayList<transferringList> showList = new ArrayList<transferringList>();
		try{
			
			Connection con = initDB();
			// ����SQL�������
			Statement stmt = con.createStatement();
			// ����SQL�����ַ���
			String query = "select * from transferringList where transferringList_date between'"+day1+"'and'"+day2+"'";
			
			// ִ��SQL���
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new transferringList();
				list.setTransferringListId(rs.getString("transferringListId"));
				list.setTransferringList_date(rs.getString("transferringList_date"));
				list.setHandler(rs.getString("handler"));
				list.setOutWarehouseId(rs.getString("outWarehouseId"));
				list.setInWarehouseId(rs.getString("inWarehouseId"));
				list.setQuantities(rs.getInt("quantities"));
				list.setGoods_name(rs.getString("goods_name"));
				showList.add(list);
				list = null;
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
		
		return showList;
	}
	
	//���ݾ���ʱ�������ң���������������
	public ArrayList<transferringList> findByTransferringList_date(String transferringList_date ){
		
		    transferringList list;
			ArrayList<transferringList> showList = new ArrayList<transferringList>();
			try{
				
				Connection con = initDB();
				// ����SQL�������
				Statement stmt = con.createStatement();
				// ����SQL�����ַ���
				String query = "select * from transferringList where transferringListId='"+transferringList_date+"'";
				
				// ִ��SQL���
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new transferringList();
					list.setTransferringListId(rs.getString("transferringListId"));
					list.setTransferringList_date(rs.getString("transferringList_date"));
					list.setHandler(rs.getString("handler"));
					list.setOutWarehouseId(rs.getString("outWarehouseId"));
					list.setInWarehouseId(rs.getString("inWarehouseId"));
					list.setQuantities(rs.getInt("quantities"));
					list.setGoods_name(rs.getString("goods_name"));
					showList.add(list);
					list = null;
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
			
			return showList;
		}

}