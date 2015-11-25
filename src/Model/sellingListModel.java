package Model;
//销售单的操作
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.sellingList;
	
public class sellingListModel extends jdbc {
	//增加销售单
	public void add(sellingList list){
		
		try{
			Connection con = initDB();
			
			Statement stmt = con.createStatement();
			
			String query = "insert into sellingList(sellingListId,selling_date,unitId char,handler,totalPayment,acc_id) values ('"
					+list.getSelling_id()+"','"
					+list.getSelling_date()+"','"
					+list.getUnit_id()+"','"
					+list.getSelling_handler()+"','"
					+list.getSelling_totalPrice()+"','"
					+list.getAcc_id()+
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
	//更新销售单
	public void update(sellingList list){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update sellingList set selling_date='"
			+list.getSelling_date()+"',totalPayment='"+list.getSelling_totalPrice()+
			"',unitId='"+list.getUnit_id()+
			"',handler='"+list.getSelling_handler()+"',acc_id='"+list.getAcc_id()+"' where sellingListId ='"+list.getSelling_id()+"'";
			
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
	//通过销售单ID寻找销售单
	public sellingList findBySell_id(String sell_id){
		sell_id.trim();
		sellingList sell = new sellingList();
		
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellingList where selling_id ='"+sell_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			sell.setSelling_id(rs.getString("selling_id"));
			sell.setSelling_date(rs.getString("selling_date"));
			sell.setUnit_id(rs.getString("unitId"));
			sell.setSelling_handler(rs.getString("handler"));		
			sell.setSelling_totalPrice(rs.getFloat("totalPayment"));
			sell.setAcc_id(rs.getString("acc_id"));	
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
		
		return sell;
	}
	//返回销售单所有记录
	public ArrayList<sellingList> select()
	{
		sellingList sel;
		ArrayList<sellingList> sellingLists = new ArrayList<sellingList>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellingList";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				sel = new sellingList();
                sel.setSelling_id(rs.getString("selling_id"));
				sel.setSelling_date(rs.getString("selling_date"));
				sel.setUnit_id(rs.getString("unitid"));
				sel.setSelling_handler(rs.getString("handler"));
				sel.setSelling_totalPrice(rs.getFloat("totalPayment"));
				sel.setAcc_id(rs.getString("acc_id"));
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

	
	
	//根据时间段来查找,返回销售单
	//注意参数
	/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		
		Date date1 = new Date(2014-1900,6-1,25);

		String day1=sdf.format(date1);
		就是这样获取*/
	public ArrayList<sellingList> findBySell_dates(String day1,String day2 ){
		
		sellingList list;
		ArrayList<sellingList> showList = new ArrayList<sellingList>();
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellingList where selling_date between'"+day1+"'and'"+day2+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new sellingList();
				list.setSelling_id(rs.getString("selling_id"));
				list.setSelling_date(rs.getString("selling_date"));
				list.setUnit_id(rs.getString("unitid"));
				list.setSelling_handler(rs.getString("handler"));
				list.setSelling_totalPrice(rs.getFloat("totalPayment"));
				list.setAcc_id(rs.getString("acc_id"));	
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
	
	//根据具体时间来查找，返回整个销售单
	public ArrayList<sellingList> findBySell_date(String sell_date ){
		
		    sellingList list;
			ArrayList<sellingList> showList = new ArrayList<sellingList>();
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from sellingList where selling_date='"+sell_date+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new sellingList();
					list.setSelling_id(rs.getString("selling_id"));
					list.setSelling_date(rs.getString("selling_date"));
					list.setUnit_id(rs.getString("unitid"));
					list.setSelling_handler(rs.getString("handler"));
					list.setSelling_totalPrice(rs.getFloat("totalPayment"));
					list.setAcc_id(rs.getString("acc_id"));	
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

	//根据进货商（往来单位）来查找
	public ArrayList<sellingList> findByUnit_id(String unit_id ){
		sellingList list;
		ArrayList<sellingList> showList = new ArrayList<sellingList>();
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellingList where unitId='"+unit_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new sellingList();
				list.setSelling_id(rs.getString("selling_id"));
				list.setSelling_date(rs.getString("selling_date"));
				list.setUnit_id(rs.getString("unitid"));
				list.setSelling_handler(rs.getString("handler"));
				list.setSelling_totalPrice(rs.getFloat("totalPayment"));		
				list.setAcc_id(rs.getString("acc_id"));
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
