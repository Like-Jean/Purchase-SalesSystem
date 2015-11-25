package Model;
//仓库调拨单的操作
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Entity.transferringList;
	
public class transferringListModel extends jdbc {
	//增加调拨单
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
			
			// 关闭命令对象连接
			stmt.close();
			// 关闭数据库连接
			con.close();
		}catch(SQLException e){
			System.out.println("添加数据失败！");
			e.printStackTrace();			
		}
	}
	//更新调拨单
	public void update(transferringList list){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update transferringList set transferringList_date='"
			+list.getTransferringList_date()+"',quantities='"+list.getQuantities()+
			"',outWarehouseId='"+list.getOutWarehouseId()+
			"',inWareHouseId='"+list.getInWarehouseId()+"',handler='"+list.getHandler()+"',goods_name='"+list.getGoods_name()+"' where transferringListId ='"+list.getTransferringListId()+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(Exception e){
			System.out.println("更新数据失败！");
			e.printStackTrace();			
		}			
	}
	//通过调拨单ID寻找调拨单
	public transferringList findBytransferringListId(String transferringListId){
		transferringListId.trim();
		transferringList tsl = new transferringList();
		
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from transferringList where transferringListId ='"+transferringListId+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			tsl.setTransferringListId(rs.getString("transferringListId"));
			tsl.setTransferringList_date(rs.getString("transferringList_date"));
			tsl.setHandler(rs.getString("handler"));
			tsl.setOutWarehouseId(rs.getString("outWarehouseId"));
			tsl.setInWarehouseId(rs.getString("inWarehouseId"));
			tsl.setQuantities(rs.getInt("quantities"));
			tsl.setGoods_name(rs.getString("goods_name"));
			// 关闭记录集
			rs.close();
			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
		    con.close();
		
		}catch(SQLException e){
			System.out.println("查找数据失败！");
			e.printStackTrace();			
		}		
		
		return tsl;
	}
	//返回调拨单所有记录
	public ArrayList<transferringList> select()
	{
		transferringList sel;
		ArrayList<transferringList> sellingLists = new ArrayList<transferringList>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from transferringList";
			
			// 执行SQL语句
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

			// 关闭记录集
			rs.close();
			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("查找数据失败！");
			e.printStackTrace();			
		}
		
		return sellingLists;			
	}

	
	
	//根据时间段来查找,返回调拨单
	//注意参数
	/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date1 = new Date(2014-1900,6-1,25);

		String day1=sdf.format(date1);
		就是这样获取*/
	public ArrayList<transferringList> findBytTransferringList_dates(String day1,String day2 ){
		
		transferringList list;
		ArrayList<transferringList> showList = new ArrayList<transferringList>();
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from transferringList where transferringList_date between'"+day1+"'and'"+day2+"'";
			
			// 执行SQL语句
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
			// 关闭记录集
						rs.close();
						// 关闭命令对象连接
						stmt.close();

						// 关闭数据库连接
						con.close();
		
		}catch(SQLException e){
			System.out.println("查找数据失败！");
			e.printStackTrace();			
		}
		
		return showList;
	}
	
	//根据具体时间来查找，返回整个调拨单
	public ArrayList<transferringList> findByTransferringList_date(String transferringList_date ){
		
		    transferringList list;
			ArrayList<transferringList> showList = new ArrayList<transferringList>();
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from transferringList where transferringListId='"+transferringList_date+"'";
				
				// 执行SQL语句
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
				// 关闭记录集
							rs.close();
							// 关闭命令对象连接
							stmt.close();

							// 关闭数据库连接
							con.close();
			
			}catch(SQLException e){
				System.out.println("查找数据失败！");
				e.printStackTrace();			
			}
			
			return showList;
		}

}