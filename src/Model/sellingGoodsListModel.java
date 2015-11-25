package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.sellingGoodsList;

public class sellingGoodsListModel extends jdbc {
	
	//增加记录
	public void add(sellingGoodsList god){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into sellingGoodsList(sellingListId,warh_id,goods_id,goods_name,goods_quantity,goods_price) values ("
			+"'"+god.getSellingList_id()
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
		
		//通过商品号、销售单号来查找某条进货商品记录
		public sellingGoodsList findOneRecord(String sellingGoodsList_id, String goods_id)
		{
			goods_id.trim();
			sellingGoodsList_id.trim();
			sellingGoodsList god = new sellingGoodsList();
			
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from sellingGoodsList where sellingListId="+sellingGoodsList_id+" and goods_id='"+goods_id+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				god.setSellingList_id(rs.getString("sellingList_id"));
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
		
		//通过销售单号来查找某次进货的所有商品
		public ArrayList<sellingGoodsList> findBysellingList (String sellingList_id)
		{
			sellingList_id.trim();
			sellingGoodsList god;
			ArrayList<sellingGoodsList> goodsList = new ArrayList<sellingGoodsList>();
			
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from sellingGoodsList where sellingListId='"+sellingList_id+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					god = new sellingGoodsList();
					god.setSellingList_id(rs.getString("sellingList_id"));
					god.setGoods_id(rs.getString("goods_id"));
					god.setWarh_id(rs.getString("warh_id"));
					god.setGoods_name(rs.getString("goods_name"));
					god.setGoods_quantity(rs.getInt("goods_quantity"));
					god.setGoods_price(rs.getFloat("goods_price"));
					
					goodsList.add(god);
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
			
			return goodsList;			
		}
		
		
		//删除一条特定记录
		public void deleteOneRecord(String sellingGoodsList_id,String goods_id)
		{
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "delete from sellingGoodsList where sellingListId='"+sellingGoodsList_id+"' and goods_id='"+goods_id+"'";
				
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
		public void deleteRecords(String sellingList_id)
		{
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "delete from sellingGoodsList where sellingListId='"+sellingList_id+"'";
				
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
