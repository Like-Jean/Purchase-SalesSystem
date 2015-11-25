package Model;
/*@author Like
 * version 1.0
 * 付款单控制model
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entity.payment;
import Entity.purchaseList;

public class paymentModel extends jdbc {
	
	    //增加付款单
		public void add(payment pay){
			
			try{
				Connection con = initDB();
				
				Statement stmt = con.createStatement();
				
				String query = "insert into payment(payment_id,payment_date,unitId,financeWorker,matchingMenu,totalPayment,acc_id) values ('"
						+pay.getPaymentId()+"','"
						+pay.getPaymentDate()+"','"
						+pay.getUnitId()+"','"
						+pay.getFinanceWorker()+"','"
						+pay.getMatchingMenu()+"','"
						+pay.getTotalPayment()+"','"
						+pay.getAccId()+"')";
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
		
		//更新付款单
		public void update(payment pay){
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "update payment set payment_date='"+pay.getPaymentDate()+
				"',unitId='"+pay.getUnitId()+"',financeWorker='"+pay.getFinanceWorker()+
				"',matchingMenu='"+pay.getMatchingMenu()+"',totalPayment='"+pay.getTotalPayment()+
				"',acc_id='"+pay.getAccId()+"' where payment_id ='"+pay.getPaymentId()+"'";
				
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
		
		//根据单号来删除付款单
		public void delete(String PaymentId){
			PaymentId.trim();
			try{
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "delete from payment where payment_id = '"
				+PaymentId+"'";
				
				// 执行SQL语句
				stmt.execute(query);

				// 关闭命令对象连接
				stmt.close();

				// 关闭数据库连接
				con.close();			
			}catch(Exception e){
				System.out.println("删除数据失败！");
				e.printStackTrace();			
			}			
		}
		
		//根据单号查找某一条付款单
		public payment findByPaymentId(String PaymentId){
			PaymentId.trim();
			payment pay = new payment();
			
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from paymentt where payment_id ='"+PaymentId+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				rs.next();
				pay.setPaymentId(rs.getString("payment_id"));
				pay.setPaymentDate(rs.getString("payment_date"));
				pay.setFinanceWorker(rs.getString("financeWorker"));
				pay.setUnitId(rs.getString("unitId"));
				pay.setAccId(rs.getString("acc_id"));
				pay.setMatchingMenu(rs.getString("matchingMenu"));
				pay.setTotalPayment(rs.getFloat("totalPayment"));
				
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
			
			return pay;
		}
		
		//根据时间段来查找,返回进货单
		//注意参数
		/* 	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			
			Date date1 = new Date(2014-1900,6-1,25);

			String day1=sdf.format(date1);
			就是这样获取*/
		public ArrayList<payment> findByPaymentDates(String day1,String day2 ){
			
			payment pay;
			ArrayList<payment> showPay = new ArrayList<payment>();
			try{
				
				Connection con = initDB();
				// 创建SQL命令对象
				Statement stmt = con.createStatement();
				// 创建SQL命令字符串
				String query = "select * from payment where payment_date between'"+day1+"'and'"+day2+"'";
				
				// 执行SQL语句
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					pay = new payment();
					pay.setPaymentId(rs.getString("payment_id"));
					pay.setPaymentDate(rs.getString("payment_date"));
					pay.setUnitId(rs.getString("unitId"));
					pay.setTotalPayment(rs.getFloat("totalPayment"));
					pay.setFinanceWorker(rs.getNString("finaceWorker"));
					pay.setMatchingMenu(rs.getNString("matchingMenu"));
					pay.setAccId(rs.getString("acc_id"));				
					showPay.add(pay);
					pay = null;
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
			
			return showPay;
		}
		
		//根据具体时间来查找，返回整个进货单
		public ArrayList<payment> findByPaymentDate(String paymentDate ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from payment where payment_date='"+paymentDate+"'";
					
					// 执行SQL语句
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
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
				
				return showPay;
			}
	
		//根据往来单位来查找，返回整个付款单
		public ArrayList<payment> findByUnitId(String unitId ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from payment where unitId='"+unitId+"'";
					
					// 执行SQL语句
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
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
				
				return showPay;
			}
		
		//根据银行账户来查找，返回整个付款单
		public ArrayList<payment> findByAccId(String accId ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from payment where acc_id='"+accId+"'";
					
					// 执行SQL语句
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
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
				
				return showPay;
			}
		
		//根据财务人员来查找，返回整个付款单
		public ArrayList<payment> findByFinaceWorker(String finaceWorker ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from payment where finaceWorker='"+finaceWorker+"'";
					
					// 执行SQL语句
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
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
				
				return showPay;
			}
		
		//根据对应单据来查找，返回整个付款单
		public ArrayList<payment> findByMatchingMenu(String matchingMenu ){
			
				payment pay;
				ArrayList<payment> showPay = new ArrayList<payment>();
				try{
					
					Connection con = initDB();
					// 创建SQL命令对象
					Statement stmt = con.createStatement();
					// 创建SQL命令字符串
					String query = "select * from payment where matchingMenu='"+matchingMenu+"'";
					
					// 执行SQL语句
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						pay = new payment();
						pay.setPaymentId(rs.getString("payment_id"));
						pay.setPaymentDate(rs.getString("payment_date"));
						pay.setUnitId(rs.getString("unitId"));
						pay.setTotalPayment(rs.getFloat("totalPayment"));
						pay.setFinanceWorker(rs.getNString("finaceWorker"));
						pay.setMatchingMenu(rs.getNString("matchingMenu"));
						pay.setAccId(rs.getString("acc_id"));				
						showPay.add(pay);
						pay = null;
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
				
				return showPay;
			}
}
