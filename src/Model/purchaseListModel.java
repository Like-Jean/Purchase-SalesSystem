package Model;
/*@author beijian 
 * madan wo yao tu cao,xie de zhe shi shen me a */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.purchaseList;

public class purchaseListModel extends jdbc{

    //增加进货单
	public void add(purchaseList list){
		
		try{
			Connection con = initDB();
			
			Statement stmt = con.createStatement();
			
			String query = "insert into purchaseList(purch_id,purch_date,purch_totalPrice,unitId,acc_id) values ('"
					+list.getPurch_id()+"','"
					+list.getPurch_date()+"','"
					+list.getPurch_totalPrice()+"','"
					+list.getUnit_id()+"','"
					+list.getAcc_id()+"')";
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

	public void update(purchaseList list){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update purchaseList set purch_date='"
			+list.getPurch_date()+"',purch_totalPrice='"+list.getPurch_totalPrice()+
			"',unitId='"+list.getUnit_id()+
			"',acc_id='"+list.getAcc_id()+"' where purch_id ='"+list.getPurch_id()+"'";
			
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
	
	public purchaseList findByPurch_id(String purch_id){
		purch_id.trim();
		purchaseList purh = new purchaseList();
		
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from purchaseList where purch_id ='"+purch_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			purh.setPurch_id(rs.getString("purch_id"));
			purh.setPurch_date(rs.getString("purch_date"));
			purh.setPurch_totalPrice(rs.getFloat("purch_totalPrice"));
			purh.setUnit_id(rs.getString("unitId"));
			purh.setAcc_id(rs.getString("acc_id"));		

			
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
		
		return purh;
	}
	
	//根据时间段来查找,返回进货单
	//注意参数
	/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date date1 = new Date(2014-1900,6-1,25);

		String day1=sdf.format(date1);
		就是这样获取*/
	public ArrayList<purchaseList> findByPurch_dates(String day1,String day2 ){
		
		purchaseList list;
		ArrayList<purchaseList> showList = new ArrayList<purchaseList>();
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from purchaseList where purch_date between'"+day1+"'and'"+day2+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new purchaseList();
				list.setPurch_id(rs.getString("purch_id"));
				list.setPurch_date(rs.getString("purch_date"));
				list.setPurch_totalPrice(rs.getFloat("purch_totalPrice"));
				list.setUnit_id(rs.getString("unitId"));
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
	
	//根据具体时间来查找，返回整个进货单
	public ArrayList<purchaseList> findByPurch_date(String purch_date ){
		
			purchaseList list;
			ArrayList<purchaseList> showList = new ArrayList<purchaseList>();
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from purchaseList where purch_date='"+purch_date+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					list = new purchaseList();
					list.setPurch_id(rs.getString("purch_id"));
					list.setPurch_date(rs.getString("purch_date"));
					list.setPurch_totalPrice(rs.getFloat("purch_totalPrice"));
					list.setUnit_id(rs.getString("unitId"));
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
	public ArrayList<purchaseList> findByUnit_id(String unit_id ){
		purchaseList list;
		ArrayList<purchaseList> showList = new ArrayList<purchaseList>();
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from purchaseList where unitId='"+unit_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new purchaseList();
				list.setPurch_id(rs.getString("purch_id"));
				list.setPurch_date(rs.getString("purch_date"));
				list.setPurch_totalPrice(rs.getFloat("purch_totalPrice"));
				list.setUnit_id(rs.getString("unitId"));
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
	
	//根据银行账号来查找
	public ArrayList<purchaseList> findByAcc_id(String acc_id ){
		purchaseList list;
		ArrayList<purchaseList> showList = new ArrayList<purchaseList>();
		try{
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from purchaseList where acc_id='"+acc_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				list = new purchaseList();
				list.setPurch_id(rs.getString("purch_id"));
				list.setPurch_date(rs.getString("purch_date"));
				list.setPurch_totalPrice(rs.getFloat("purch_totalPrice"));
				list.setUnit_id(rs.getString("unitId"));
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


