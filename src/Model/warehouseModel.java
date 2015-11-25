package Model;
/*@author yixiu
 *@version 1.0
 * 对warehouse表进行操作的类，包括增删改查以及特定的按照id与name进行查找
 * 进行增与改时参数为warehouse实体类，默认仓库名可以重名，关于这点还有待商榷
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.warehouse;
public class warehouseModel extends jdbc{

    //增，id与仓库名
	public void add(warehouse warh){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into warehouse(warh_id,warh_name,warh_remark) values ("
			+warh.getWarh_id()+",'"+warh.getWarh_name()+"','"+warh.getWarh_remark()+"')";
			
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
    //删除操作,会将该仓库下的所有商品也删除
	public void delete(String warh_id){
		//先对输入字符串格式化
		warh_id.trim();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from warehouse where warh_id="+warh_id;
			
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
    //更新操作，注意这里是对除主码外所有属性同时更新，设定是这样的在要更新的文本框中先显示原来的信息，修改后
	//再将这些数据重新赋值给warehouse对象，再调用该函数完成更新
	public void update(warehouse warh){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update warehouse set warh_name='"
			+warh.getWarh_name()+"',warh_remark='"+warh.getWarh_remark()+"'where warh_id='"
					+warh.getWarh_id()+"'";
			
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
    //返回表中所有记录，结果为warehouse类数组
	public ArrayList<warehouse> select(){
		warehouse warh;
		ArrayList<warehouse> warhList = new ArrayList<warehouse>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from warehouse";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				warh = new warehouse();
				warh.setWarh_id(rs.getString("warh_id"));
				warh.setWarh_name(rs.getString("warh_name"));
				warh.setWarh_remark(rs.getString("warh_remark"));
				
				warhList.add(warh);
				warh = null;
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
		
		return warhList;
	} 
    //通过id号来查找
	public warehouse findById(String warh_id){
		warh_id.trim();
		warehouse warh = new warehouse();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from warehouse where warh_id="+warh_id;
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			warh.setWarh_id(rs.getString("warh_id"));
			warh.setWarh_name(rs.getString("warh_name"));
			warh.setWarh_remark(rs.getString("warh_remark"));
				

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
		
		return warh;		
	}
	//通过仓库名查找
	public ArrayList<warehouse> findByName(String warh_name){
		warh_name.trim();
		warehouse warh;
		ArrayList<warehouse> warhList = new ArrayList<warehouse>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from warehouse where warh_name='"+warh_name+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				warh = new warehouse();
				warh.setWarh_id(rs.getString("warh_id"));
				warh.setWarh_name(rs.getString("warh_name"));
				warh.setWarh_remark(rs.getString("warh_remark"));
				
				warhList.add(warh);
				warh = null;
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
		
		return warhList;		
	}
}
