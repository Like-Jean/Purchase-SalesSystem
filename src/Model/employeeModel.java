package Model;
/*@author hongyu
 *@version 1.0
 * 
 * */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.employee;
public class employeeModel extends jdbc {
	
public void add(employee empl){
		try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "insert into employee(empl_id,empl_name,empl_department,empl_position," +
				"empl_salary,empl_phoneNumber) values ('"
				+empl.getEmpl_id()+"','"+empl.getEmpl_name()+"','"+empl.getEmpl_department()+"','"
				+empl.getEmpl_position()+"','"+empl.getEmpl_salary()+"','"+empl.getEmpl_phoneNumber()
				+"')";
		stmt.execute(query);
		stmt.close();
		con.close();
		}catch(SQLException e){
			System.out.println("插入数据失败！");
			e.printStackTrace();
		}
	}

public void delete(String empl_id){
	empl_id.trim();
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "delete from employee where empl_id="+empl_id;
		stmt.execute(query);
		stmt.close();
		con.close();			
	   }catch(SQLException e){
		System.out.println("删除数据失败！");
		e.printStackTrace();			
	}
}

public void update(employee empl){
	try{
		Connection con = initDB();
		
		Statement stmt = con.createStatement();
		
		String query = "update employee set empl_name='"
		+empl.getEmpl_name()+"',empl_department='"+empl.getEmpl_department()
		+"',empl_position='"+empl.getEmpl_position()+
		"',empl_salary='"+empl.getEmpl_salary()+"',empl_phoneNumber='"
		+empl.getEmpl_phoneNumber()+"'where empl_id='"
		+empl.getEmpl_id()+"'";
		System.out.println(empl.getEmpl_name());
		stmt.execute(query);
		
		stmt.close();
		con.close();			
	    }catch(SQLException e){
		System.out.println("更新数据失败！");
		e.printStackTrace();			
	}		

}

public ArrayList<employee> select(){
	employee empl;
	ArrayList<employee> emplList = new ArrayList<employee>();
	
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			empl = new employee();
			empl.setEmpl_id(rs.getString("empl_id"));
			empl.setEmpl_name(rs.getString("empl_name"));
			empl.setEmpl_department(rs.getString("empl_department"));
			empl.setEmpl_position(rs.getInt("empl_position"));
			empl.setEmpl_salary(rs.getFloat("empl_salary"));
			empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
			
			emplList.add(empl);
			empl = null;
		}
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("删除数据失败！");
		e.printStackTrace();	
}
	return emplList;
	}

public employee findById(String empl_id){
	empl_id.trim();
	employee empl = new employee();
	
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee where empl_id="+empl_id;
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		empl.setEmpl_id(rs.getString("empl_id"));
		empl.setEmpl_name(rs.getString("empl_name"));
		empl.setEmpl_department(rs.getString("empl_department"));
		empl.setEmpl_position(rs.getInt("empl_position"));
		empl.setEmpl_salary(rs.getFloat("empl_salary"));
		empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("查找数据失败！");
		e.printStackTrace();			
	}
	
	return empl;		
}

public ArrayList<employee> findByName(String empl_name){
	empl_name.trim();
	employee empl;
	ArrayList<employee> emplList = new ArrayList<employee>();
	
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee where empl_name='"+empl_name+"'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			empl = new employee();
			empl.setEmpl_id(rs.getString("empl_id"));
			empl.setEmpl_name(rs.getString("empl_name"));
			empl.setEmpl_department(rs.getString("empl_department"));
			empl.setEmpl_position(rs.getInt("empl_position"));
			empl.setEmpl_salary(rs.getFloat("empl_salary"));
			empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
			
			emplList.add(empl);
			empl = null;
		}
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("查找数据失败！");
		e.printStackTrace();			
	}
	
	return emplList;		
}

public ArrayList<employee> findByDepartment(String empl_department){
	//empl_department.trim();
	employee empl;
	ArrayList<employee> emplList = new ArrayList<employee>();
	//System.out.println(empl_department);
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee where empl_department='"+empl_department+"'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			empl = new employee();
			empl.setEmpl_id(rs.getString("empl_id"));
			empl.setEmpl_name(rs.getString("empl_name"));
			empl.setEmpl_department(rs.getString("empl_department"));
			empl.setEmpl_position(rs.getInt("empl_position"));
			empl.setEmpl_salary(rs.getFloat("empl_salary"));
			empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
			
			emplList.add(empl);
			empl = null;
		}
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("查找数据失败！");
		e.printStackTrace();			
	}
	
	return emplList;		
}

public ArrayList<employee> findByPosition(String empl_position){
	empl_position.trim();
	employee empl;
	ArrayList<employee> emplList = new ArrayList<employee>();
	
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee where empl_position='"+empl_position+"'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			empl = new employee();
			empl.setEmpl_id(rs.getString("empl_id"));
			empl.setEmpl_name(rs.getString("empl_name"));
			empl.setEmpl_department(rs.getString("empl_department"));
			empl.setEmpl_position(rs.getInt("empl_position"));
			empl.setEmpl_salary(rs.getFloat("empl_salary"));
			empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
			
			emplList.add(empl);
			empl = null;
		}
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("查找数据失败！");
		e.printStackTrace();			
	}
	
	return emplList;		
}

public ArrayList<employee> findBySalary(String empl_salary){
	empl_salary.trim();
	employee empl;
	ArrayList<employee> emplList = new ArrayList<employee>();
	
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee where empl_name='"+empl_salary+"'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			empl = new employee();
			empl.setEmpl_id(rs.getString("empl_id"));
			empl.setEmpl_name(rs.getString("empl_name"));
			empl.setEmpl_department(rs.getString("empl_department"));
			empl.setEmpl_position(rs.getInt("empl_position"));
			empl.setEmpl_salary(rs.getFloat("empl_salary"));
			empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
			
			emplList.add(empl);
			empl = null;
		}
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("查找数据失败！");
		e.printStackTrace();			
	}
	
	return emplList;		
}

public ArrayList<employee> findByPhoneNumber(String empl_phoneNumber){
	empl_phoneNumber.trim();
	employee empl;
	ArrayList<employee> emplList = new ArrayList<employee>();
	
	try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "select * from employee where empl_name='"+empl_phoneNumber+"'";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			empl = new employee();
			empl.setEmpl_id(rs.getString("empl_id"));
			empl.setEmpl_name(rs.getString("empl_name"));
			empl.setEmpl_department(rs.getString("empl_department"));
			empl.setEmpl_position(rs.getInt("empl_position"));
			empl.setEmpl_salary(rs.getFloat("empl_salary"));
			empl.setEmpl_phoneNumber(rs.getString("empl_phoneNumber"));
			
			emplList.add(empl);
			empl = null;
		}
		rs.close();
		stmt.close();
		con.close();	
	}catch(SQLException e){
		System.out.println("查找数据失败！");
		e.printStackTrace();			
	}
	
	return emplList;		
}
}
		
