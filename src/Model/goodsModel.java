package Model;
/*@author yixiu
 *@version beta
 * 对goods表进行操作的类
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
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into goods(goods_id,warh_id,goods_name,goods_category," +
					"goods_quantity,goods_up,goods_down,goods_cost,goods_prprice,goods_factory," +
					"goods_version) values ("
			+god.getGoods_id()+",'"+god.getWarh_id()+"','"+god.getGoods_name()+"','"+god.getGoods_category()+
			"','"+god.getGoods_quantity()+"','"+god.getGoods_up()+"','"+god.getGoods_down()+"','"+
			god.getGoods_cost()+"','"+god.getGoods_prprice()+"','"+god.getGoods_factory()+"','"+
			god.getGoods_version()+"')";
			
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
    //删除给定商品号和仓库号的全部记录
	public void delete(String goods_id,String warh_id){

		goods_id.trim();
		warh_id.trim();
	
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from goods where warh_id="+warh_id+" and goods_id='"+goods_id+"'";
			
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
	
	//获取给定商品号和仓库号的商品的数量
	public int getQuantity(String goods_id,String warh_id){
		warh_id.trim();
		goods_id.trim();
		int x = 0;
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select goods_quantity from goods where warh_id="
			+warh_id+" and goods_id='"+goods_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			x = rs.getInt("goods_quantity");
				

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
		return x;
	}

	//减少给定商品号和仓库号的商品的数量
	public void reduce(String goods_id,String warh_id,int mount){
		
		goods_id.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_id,warh_id);
	    formalQuantity -= mount;
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_id='"+goods_id+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("减少数据失败！");
			e.printStackTrace();			
		}			
	}

	//增加给定商品号和仓库号的商品的数量
	public void increase(String goods_id,String warh_id,int mount){
		goods_id.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_id,warh_id);
	    formalQuantity += mount;
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_id='"+goods_id+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("减少数据失败！");
			e.printStackTrace();			
		}			
	}	

	//修改给定商品号和仓库号的商品属性
	public void update(goods god){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
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

    //显示数据库中所有元组
	public ArrayList<goods> select(){
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods";
			
			// 执行SQL语句
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

	//通过给定商品号和仓库号获取元组信息
	public goods findById(String goods_id,String warh_id){
		goods_id.trim();
		warh_id.trim();		
		goods god = null;

		try{
			god = new goods();
			
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods where warh_id="+warh_id+" and goods_id='"+goods_id+"'";
			
			// 执行SQL语句
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

	//通过给定商品名字查找元组
	public ArrayList<goods> findByName(String goods_name){
		goods_name.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods where goods_name='"+goods_name+"'";
			
			// 执行SQL语句
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

	//通过给定仓库id查找元组
	public ArrayList<goods> findByWarh_id(String warh_id){
		warh_id.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods where warh_id='"+warh_id+"'";
			
			// 执行SQL语句
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
	
	//通过给定商品种类查找元组
	public ArrayList<goods> findByCategory(String goods_category){
		goods_category.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods where goods_category='"+goods_category+"'";
			
			// 执行SQL语句
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

	//通过给定出产厂商查找元组
	public ArrayList<goods> findByFactory(String goods_factory){
		goods_factory.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods where goods_factory='"+goods_factory+"'";
			
			// 执行SQL语句
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

	//通过给定商品ID查找元组
	public ArrayList<goods> findByGoodId(String goods_id){
		goods_id.trim();
		goods god;
		ArrayList<goods> goodsList = new ArrayList<goods>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from goods where goods_id='"+goods_id+"'";
			
			// 执行SQL语句
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

	//获取给定商品名称和仓库号的商品的数量
	public int getQuantity2(String goods_name,String warh_id){
	
		int x = 0;
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select goods_quantity from goods where warh_id="
			+warh_id+" and goods_name='"+goods_name+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			x = rs.getInt("goods_quantity");
				

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
		return x;
	}
	
	//减少给定商品号和仓库号的商品的数量
	public void reduce2(String goods_name,String warh_id,int mount){
		
		goods_name.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_name,warh_id);
	    formalQuantity -= mount;
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_name='"+goods_name+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("减少数据失败！");
			e.printStackTrace();			
		}			
	}

	//增加给定商品号和仓库号的商品的数量
	public void increase2(String goods_name,String warh_id,int mount){
		goods_name.trim();
		warh_id.trim();
	    int formalQuantity = getQuantity(goods_name,warh_id);
	    formalQuantity += mount;
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update goods set goods_quantity='"+formalQuantity+"' where warh_id='"
			+warh_id+"' and goods_name='"+goods_name+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("减少数据失败！");
			e.printStackTrace();			
		}			
	}		
}
