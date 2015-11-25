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

import Entity.account;
public class accountModel extends jdbc {
	public void add(account acc){
		try{
		Connection con = initDB();
		Statement stmt = con.createStatement();
		String query = "insert into account(acc_id,acc_balance,acc_bank,acc_remark) values ('"
		+acc.getAcc_id()+"','"+acc.getAcc_balance()+"','"+acc.getAcc_bank()+"','"
				+acc.getAcc_remark()+"')";
		stmt.execute(query);
		stmt.close();
		con.close();
		}catch(SQLException e){
			System.out.println("添加数据失败！");
			e.printStackTrace();
		}
	}

	public void delete(String acc_id){
		acc_id.trim();
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "delete from account where acc_id="+acc_id;
			stmt.execute(query);
			stmt.close();
			con.close();			
		   }catch(SQLException e){
			System.out.println("删除数据失败！");
			e.printStackTrace();			
		}
	}

	public void update(account acc){
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "update account set acc_balance='"
			+acc.getAcc_balance()+"',acc_bank='"+acc.getAcc_bank()+"',acc_remark='"+acc.getAcc_remark()+"'where acc_id='"
			+acc.getAcc_id()+"'";
			stmt.execute(query);
			stmt.close();
			con.close();			
		    }catch(SQLException e){
			System.out.println("更新数据失败！");
			e.printStackTrace();			
		}
	}
	
	public ArrayList <account> select(){
		account acc;
		ArrayList<account> accList = new ArrayList<account>();
		
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "select * from account";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				acc = new account();
				acc.setAcc_id(rs.getString("acc_id"));
				acc.setAcc_balance(rs.getFloat("acc_balance"));
				acc.setAcc_bank(rs.getString("acc_bank"));
				acc.setAcc_remark(rs.getString("acc_remark"));
				
				accList.add(acc);
				acc = null;
			}
			rs.close();
			stmt.close();
			con.close();	
		}catch(SQLException e){
			System.out.println("删除数据失败！");
			e.printStackTrace();	
	}
		return accList;
		}

	public account findById(String acc_id){
		acc_id.trim();
		account acc = new account();
		
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "select * from account where acc_id="+acc_id;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			acc.setAcc_id(rs.getString("acc_id"));
			acc.setAcc_balance(rs.getFloat("acc_balance"));
			acc.setAcc_bank(rs.getString("acc_bank"));
			acc.setAcc_remark(rs.getString("acc_remark"));
			rs.close();
			stmt.close();
			con.close();	
		}catch(SQLException e){
			System.out.println("查找数据失败！");
			e.printStackTrace();			
		}
		
		return acc;		
	}
	
	public ArrayList<account> findByBank(String acc_bank){
		acc_bank.trim();
		account acc;
		ArrayList<account> accList = new ArrayList<account>();
		
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "select * from account where acc_bank='"+acc_bank+"'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				acc = new account();
				acc.setAcc_id(rs.getString("acc_id"));
				acc.setAcc_balance(rs.getFloat("acc_balance"));
				acc.setAcc_bank(rs.getString("acc_bank"));
				acc.setAcc_remark(rs.getString("acc_remark"));
				
				accList.add(acc);
				acc = null;
			}
			rs.close();
			stmt.close();
			con.close();	
		}catch(SQLException e){
			System.out.println("查找数据失败！");
			e.printStackTrace();			
		}
		
		return accList;		
	}

	public ArrayList<account> findByBalance(float acc_balance){
		
		account acc;
		ArrayList<account> accList = new ArrayList<account>();
		
		try{
			Connection con = initDB();
			Statement stmt = con.createStatement();
			String query = "select * from account where acc_balance='"+acc_balance+"'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				acc = new account();
				acc.setAcc_id(rs.getString("acc_id"));
				acc.setAcc_balance(rs.getFloat("acc_balance"));
				acc.setAcc_bank(rs.getString("acc_bank"));
				acc.setAcc_remark(rs.getString("acc_remark"));
				
				accList.add(acc);
				acc = null;
			}
			rs.close();
			stmt.close();
			con.close();	
		}catch(SQLException e){
			System.out.println("查找数据失败！");
			e.printStackTrace();			
		}
		
		return accList;		
	}
}