package Model;
/*@author Like
 *@version 1.0
 * 对sellGoodsList表进行操作的类
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.sellGoodsList;
public class sellGoodsListModel extends jdbc{
	
	//增加记录
	public void add(sellGoodsList god){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into sellGoodsList(sell_id,warh_id,goods_id,goods_name,goods_quantity,goods_price) values ("
			+"'"+god.getSell_id()
			+"','"+god.getWarh_id()
			+"','"+god.getGoods_id()
			+"','"+god.getGoods_name()
			+"','"+god.getGoods_quantity()
			+"','"+god.getGoods_price()+"')";
			
			// 执行SQL语句
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

	//通过商品号、出货单号来查找某条出货商品记录
	public sellGoodsList findOneRecord(String sell_id, String goods_id)
	{
		goods_id.trim();
		sell_id.trim();
		sellGoodsList god = new sellGoodsList();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellGoodsList where sell_id="+sell_id+" and goods_id='"+goods_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			god.setSell_id(rs.getString("purchase_id"));
			god.setWarh_id(rs.getString("warh_id"));
			god.setGoods_id(rs.getString("goods_id"));
			god.setGoods_name(rs.getString("goods_name"));
			god.setGoods_quantity(rs.getInt("goods_quantity"));
			god.setGoods_price(rs.getFloat("goods_price"));
			
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
		
		return god;
	}
	
	//通过出货单号来查找某次出货的所有商品
	public ArrayList<sellGoodsList> findBySell (String sell_id)
	{
		sell_id.trim();
		sellGoodsList god;
		ArrayList<sellGoodsList> sellGoodsList = new ArrayList<sellGoodsList>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellGoodsList where purchase_id='"+sell_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new sellGoodsList();
				god.setSell_id(rs.getString("sell_id"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_price(rs.getFloat("goods_price"));
				
				sellGoodsList.add(god);
				god = null;
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
		
		return sellGoodsList;			
	}
	
	//返回商品单所有记录
	public ArrayList<sellGoodsList> select()
	{
		sellGoodsList god;
		ArrayList<sellGoodsList> sellGoodsList = new ArrayList<sellGoodsList>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from sellGoodsList";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				god = new sellGoodsList();
				god.setSell_id(rs.getString("sell_id"));
				god.setGoods_id(rs.getString("goods_id"));
				god.setWarh_id(rs.getString("warh_id"));
				god.setGoods_name(rs.getString("goods_name"));
				god.setGoods_quantity(rs.getInt("goods_quantity"));
				god.setGoods_price(rs.getFloat("goods_price"));
				
				sellGoodsList.add(god);
				god = null;
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
		
		return sellGoodsList;			
	}

	//删除一条特定记录
	public void deleteOneRecord(String sell_id,String goods_id)
	{
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from sellGoodsList where sell_id='"+sell_id+"' and goods_id='"+goods_id+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("删除数据失败！");
			e.printStackTrace();			
		}
	}

	//删除一次进货的多条商品记录
	public void deleteRecords(String sell_id)
	{
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from sellGoodsList where sell_id='"+sell_id+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("删除数据失败！");
			e.printStackTrace();			
		}
	}

}
