package Model;
/*@author Like
 *@version beta
 * 对goodsList表进行操作的类
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.goodsList;

public class goodsListModel extends jdbc {
	
	//增加记录
	public void add(goodsList god){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into goodsList(purchase_id,warh_id,goods_id,goods_name,goods_quantity,goods_price) values ("
			+"'"+god.getPurchase_id()
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
		
		//通过商品号、货单号来查找某条进货商品记录
		public goodsList findOneRecord(String purchase_id, String goods_id)
		{
			goods_id.trim();
			purchase_id.trim();
			goodsList god = new goodsList();
			
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from goodsList where purchase_id="+purchase_id+" and goods_id='"+goods_id+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				god.setPurchase_id(rs.getString("purchase_id"));
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
		
		//通过货单号来查找某次进货的所有商品
		public ArrayList<goodsList> findByPurchase (String purchase_id)
		{
			purchase_id.trim();
			goodsList god;
			ArrayList<goodsList> goodsList = new ArrayList<goodsList>();
			
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from goodsList where purchase_id='"+purchase_id+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					god = new goodsList();
					god.setPurchase_id(rs.getString("purchase_id"));
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
		
		//返回商品单所有记录
		public ArrayList<goodsList> select()
		{
			goodsList god;
			ArrayList<goodsList> goodsList = new ArrayList<goodsList>();
			
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from goodsList";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					god = new goodsList();
					god.setPurchase_id(rs.getString("purchase_id"));
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
		public void deleteOneRecord(String purchase_id,String goods_id)
		{
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "delete from goodsList where purchase_id='"+purchase_id+"' and goods_id='"+goods_id+"'";
				
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
		public void deleteRecords(String purchase_id)
		{
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "delete from goodsList where purchase_id='"+purchase_id+"'";
				
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
