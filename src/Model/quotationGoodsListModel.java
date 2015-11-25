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
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into quotationGoodsList(quoId,goods_id,goods_quantity,quotedPrice,otherCost) values ("
			+"'"+quoList.getQuoId()
			+"','"+quoList.getGoods_id()
			+"','"+quoList.getGoods_quantity()
			+"','"+quoList.getQuotedPrice()
			+"','"+quoList.getOtherCost()+"')";
			
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
	
	//通过商品号、报价单号来查找某条商品记录
			public quotationGoodsList findOneRecord(String quoId, String goods_id)
			{
				goods_id.trim();
				quoId.trim();
				quotationGoodsList quolist = new quotationGoodsList();
				
				try{
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from quotationGoodsList where quoId="+quoId+" and goods_id='"+goods_id+"'";
					
					// 执行SQL语句
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					quolist.setQuoId(rs.getString("quoId"));
					quolist.setGoods_id(rs.getString("goods_id"));
					quolist.setGoods_quantity(rs.getInt("goods_quantity"));
					quolist.setQuotedPrice(rs.getFloat("quotedPrice"));
					quolist.setOtherCost(rs.getFloat("otherCost"));

					
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
				
				return quolist;
			}
			
			public ArrayList<quotationGoodsList> findByQuo (String quoId)
			{
				quoId.trim();
				quotationGoodsList quo;
				ArrayList<quotationGoodsList> quoList = new ArrayList<quotationGoodsList>();
				
				try{
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from quotationGoodsList where quoId='"+quoId+"'";
					
					// 执行SQL语句
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
				
				return quoList;			
			}
			
			
			//返回所有记录
			public ArrayList<quotationGoodsList> select()
			{
				quotationGoodsList quo;
				ArrayList<quotationGoodsList> quoList = new ArrayList<quotationGoodsList>();
				
				try{
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from quotationGoodsList";
					
					// 执行SQL语句
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
				
				return quoList;			
			}
			
			//删除一条特定记录
			public void deleteOneRecord(String quoId,String goods_id)
			{
				try{
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "delete from quotationGoodsList where quoId='"+quoId+"' and goods_id='"+goods_id+"'";
					
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
	
			
			//删除一个报价单的多条商品记录
			public void deleteRecords(String quoId)
			{
				try{
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "delete from quotationGoodsList where quoId='"+quoId+"'";
					
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
