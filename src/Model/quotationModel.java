package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import Entity.quotation;


public class quotationModel extends jdbc {
	
	//增加报价单
		public void add(quotation quo){
			
			try{
				Connection con = initDB();
				
				Statement stmt = con.createStatement();
				
				String query = "insert into quotation(quoId,quoDate,unitId,unitName,handler,remarks) values ('"
						+quo.getQuoId()+"','"
						+quo.getQuoDate()+"','"
						+quo.getUnitId()+"','"
						+quo.getUnitName()+"','"
						+quo.getHandler()+"','"
						+quo.getRemarks()+"')";
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
		
		
		public void update(quotation quo){
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "update quotation set quoDate='"
				+quo.getQuoDate()
				+"',unitId='"+quo.getUnitId()
				+"',unitName='"+quo.getUnitName()
				+"',handler='"+quo.getHandler()
				+"',remarks='"+quo.getRemarks()+"' where quoId ='"+quo.getQuoId()+"'";
				
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
		
		
		//删除操作
		public void delete(String quoId){
			quoId.trim();
			try{
				Connection con = initDB();
				Statement stmt = con.createStatement();
				String query = "delete from quotation where quoId='"+quoId+"'";
				stmt.execute(query);
				stmt.close();
				con.close();			
			   }catch(SQLException e){
				System.out.println("删除数据失败！");
				e.printStackTrace();			
			}
		}
		
		public quotation findByQuoId(String quoId){
			quoId.trim();
			quotation quo = new quotation();
			
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from quotation where quoId ='"+quoId+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
	          quo.setQuoId(rs.getString("quoId"));
	          quo.setQuoDate(rs.getString("quoDate"));
	          quo.setUnitId(rs.getString("unitId"));
	          quo.setUnitName(rs.getString("unitName"));
	          quo.setHandler(rs.getString("handler"));
	          quo.setRemarks(rs.getString("remarks"));

				
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
			
			return quo;
		}
		
		//根据往来单位来查找
		public ArrayList<quotation> findByUnitId(String unitId ){
			quotation quo;
			ArrayList<quotation> quoList = new ArrayList<quotation>();
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from quotation where unitId='"+unitId+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					quo = new quotation();
			        quo.setQuoId(rs.getString("quoId"));
			          quo.setQuoDate(rs.getString("quoDate"));
			          quo.setUnitId(rs.getString("unitId"));
			          quo.setUnitName(rs.getString("unitName"));
			          quo.setHandler(rs.getString("handler"));
			          quo.setRemarks(rs.getString("remarks"));
					
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
		
		
		//返回报价单所有记录
		public ArrayList<quotation> select()
		{
			quotation quo;
			ArrayList<quotation> quoList = new ArrayList<quotation>();
			
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from quotation";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					quo = new quotation();
			        quo.setQuoId(rs.getString("quoId"));
			          quo.setQuoDate(rs.getString("quoDate"));
			          quo.setUnitId(rs.getString("unitId"));
			          quo.setUnitName(rs.getString("unitName"));
			          quo.setHandler(rs.getString("handler"));
			          quo.setRemarks(rs.getString("remarks"));
					
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
		
		
		


}
