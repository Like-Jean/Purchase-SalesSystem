package Model;
/*@author yixiu
 *@version beta
 * 对users表进行操作的类
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.goods;
import Entity.users;
public class usersModel extends jdbc{
    //新增元组
	public void add(users user){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into users(users_id,users_psw,users_authority," +
					"empl_id) values ("
			+user.getUsers_id()+",'"+user.getUsers_psw()+"','"+user.getUsers_authority()+
			"','"+user.getEmpl_id()+"')";
			
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
    //删除指定id号的元组
	public void delete(String users_id){
		users_id.trim();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from users where users_id='"+users_id+"'";
			
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
    //修改指定id号的用户数据
	public void update(users user){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update users set users_psw='"
			+user.getUsers_psw()+"',users_authority='"+user.getUsers_authority()+
			"',empl_id='"+user.getEmpl_id()+"'where users_id='"
					+user.getUsers_id()+"'";
			
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
	//修改指定id号的密码
	public void updatePsw(String users_id,String users_psw){
		users_id.trim();
		users_psw.trim();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update users set users_psw='"
			+users_psw+"'where users_id='"
					+users_id+"'";
			
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
	//查找所有元组
	public ArrayList<users> selsct(){
		users user;
		ArrayList<users> usersList = new ArrayList<users>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from users";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				user = new users();
				user.setUsers_id(rs.getString("users_id"));
				user.setUsers_psw(rs.getString("users_psw"));
				user.setUsers_authority(rs.getInt("users_authority"));
				user.setEmpl_id(rs.getString("empl_id"));
				
				usersList.add(user);
				user = null;
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
		
		return usersList;			
	}
	//通过id号来查找
	public users findById(String users_id){
		users_id.trim();
		users user = new users();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from users where users_id='"+users_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setUsers_id(rs.getString("users_id"));
			user.setUsers_psw(rs.getString("users_psw"));
			user.setUsers_authority(rs.getInt("users_authority"));
			user.setEmpl_id(rs.getString("empl_id"));
			

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
		
		return user;		
	}
	//通过员工号来查找
	public users findByEmpl_id(String empl_id){
		empl_id.trim();
		users user = new users();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from users where empl_id='"+empl_id+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setUsers_id(rs.getString("users_id"));
			user.setUsers_psw(rs.getString("users_psw"));
			user.setUsers_authority(rs.getInt("users_authority"));
			user.setEmpl_id(rs.getString("empl_id"));
			

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
		
		return user;		
	}	
	//通过权限查找
	public users findByAuthority(int users_authority){
		users user = new users();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from users where users_authority='"+users_authority+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			user.setUsers_id(rs.getString("users_id"));
			user.setUsers_psw(rs.getString("users_psw"));
			user.setUsers_authority(rs.getInt("users_authority"));
			user.setEmpl_id(rs.getString("empl_id"));
			

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
		
		return user;		
	}	
}
