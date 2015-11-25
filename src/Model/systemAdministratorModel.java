package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.systemAdministrator;
public class systemAdministratorModel extends jdbc{

    //增操作
	public void add(systemAdministrator sysadm){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into systemAdministrator(sysAdmId,password) values ('"
			+sysadm.getSysAdmId()+"','"+sysadm.getPassword()+"')";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("插入数据失败！");
			e.printStackTrace();			
		}
		
	}
    //删除操作
	public void delete(String sysAdmId){
		//先对输入字符串格式化
		sysAdmId.trim();
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from systemAdministrator where sysAdmId='"+sysAdmId+"'";
			
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
	//再将这些数据重新赋值给systemAdministrator对象，再调用该函数完成更新
	public void update(systemAdministrator sysadm){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update systemAdministrator set password='"
			+sysadm.getPassword()+"'where sysAdmId='"+sysadm.getSysAdmId()+"'";
			
			// 执行SQL语句
			stmt.execute(query);

			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("更新数据失败！");
			e.printStackTrace();			
		}		

	}
    //返回表中所有记录，结果为systemAdministrator类数组
	public ArrayList<systemAdministrator> select(){
		systemAdministrator sysadm;
		ArrayList<systemAdministrator> sysadmList = new ArrayList<systemAdministrator>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from systemAdministrator";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				sysadm = new systemAdministrator();
				sysadm.setSysAdmId(rs.getString("sysAdmId"));
				sysadm.setPassword(rs.getString("password"));
				
				
				sysadmList.add(sysadm);
				sysadm = null;
			}

			// 关闭记录集
			rs.close();
			// 关闭命令对象连接
			stmt.close();

			// 关闭数据库连接
			con.close();			
		}catch(SQLException e){
			System.out.println("删除数据失败！");
			e.printStackTrace();			
		}
		
		return sysadmList;
	} 
    //通过id号来查找
	public systemAdministrator findById(String sysAdmId){
		sysAdmId.trim();
		systemAdministrator sysadm = new systemAdministrator();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from systemAdministrator where sysAdmId='"+sysAdmId+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			sysadm.setSysAdmId(rs.getString("sysAdmId"));
			sysadm.setPassword(rs.getString("password"));
			

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
		
		return sysadm;		
	}
	
}