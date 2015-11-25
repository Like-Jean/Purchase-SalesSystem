package Model;
/*往来单位的操作类*/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.BusinessUnit;
public class BusinessUnitModel extends jdbc{

    //增操作
	public void add(BusinessUnit busUnit){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "insert into BusinessUnit(unitId,unitName,unitNature,area,trade,"+
"linkman,address,bank,accountNum,phone,mail,mainBusiness) values ('"
+busUnit.getUnitId()+"','"+busUnit.getUnitName()+"','"
+busUnit.getUnitNature()+"','"+busUnit.getArea()+"','"
+busUnit.getTrade()+"','"+busUnit.getLinkman()+"','"
+busUnit.getAddress()+"','"+busUnit.getBank()+"','"
+busUnit.getAccountNum()+"','"+busUnit.getPhone()+"','"+busUnit.getMail()+"','"+busUnit.getMainBusiness()+"')";
			
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
    //删除操作
	public void delete(String unitId){
		//先对输入字符串格式化
		unitId.trim();
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "delete from BusinessUnit where unitId='"+unitId+"'";
			
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
    //更新操作，注意这里是对除主码外所有属性同时更新，设定是这样的在要更新的文本框中先显示原来的信息，修改后
	//再将这些数据重新赋值给BusinessUnit对象，再调用该函数完成更新
	public void update(BusinessUnit busUnit){
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "update BusinessUnit set " +
"unitName='"+busUnit.getUnitName()
+"',unitNature='"+busUnit.getUnitNature()
+"',area='"+busUnit.getArea()
+"',trade='"+busUnit.getTrade()
+"',linkman='"+busUnit.getLinkman()
+"',address='"+busUnit.getAddress()
+"',bank='"+busUnit.getBank()
+"',accountNum='"+busUnit.getAccountNum()
+"',phone='"+busUnit.getPhone()
+"',mail='"+busUnit.getMail()
+"',mainBusiness='"+busUnit.getMainBusiness()
+"'where unitId='"+busUnit.getUnitId()+"'";
			
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
    //返回表中所有记录，结果为BusinessUnit类数组
	public ArrayList<BusinessUnit> select(){
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from BusinessUnit";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
                                busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));
				
				busUnitList.add(busUnit);
				busUnit = null;
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
		
		return busUnitList;
	} 
    //通过unitId来查找
	public BusinessUnit findById(String unitId){
		unitId.trim();
		BusinessUnit busUnit = new BusinessUnit();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from BusinessUnit where unitId='"+unitId+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

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
		
		return busUnit;		
	}
	//通过单位名查找
	public ArrayList<BusinessUnit> findByName(String unitName){
		unitName.trim();
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from BusinessUnit where unitName='"+unitName+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

				
				busUnitList.add(busUnit);
				busUnit=null;
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
		
		return busUnitList;		
	}
	//通过地区查找
	public ArrayList<BusinessUnit> findByArea(String area){
		area.trim();
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from BusinessUnit where area='"+area+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

				
				busUnitList.add(busUnit);
				busUnit=null;
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
		
		return busUnitList;		
	}
	//通过行业查找
	public ArrayList<BusinessUnit> findByTrade(String trade){
		trade.trim();
		BusinessUnit busUnit;
		ArrayList<BusinessUnit> busUnitList = new ArrayList<BusinessUnit>();
		
		try{
			Connection con = initDB();
			// 创建SQL命令对象
			Statement stmt = con.createStatement();
			// 创建SQL命令字符串
			String query = "select * from BusinessUnit where trade='"+trade+"'";
			
			// 执行SQL语句
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				busUnit = new BusinessUnit();
			        busUnit.setUnitId(rs.getString("unitId"));
                                busUnit.setUnitName(rs.getString("unitName"));
                                busUnit.setUnitNature(rs.getString("unitNature"));
                                busUnit.setArea(rs.getString("area"));
                                busUnit.setTrade(rs.getString("trade"));
                                busUnit.setLinkman(rs.getString("linkman"));
                                busUnit.setAddress(rs.getString("address"));
                                busUnit.setBank(rs.getString("bank"));
				busUnit.setAccountNum(rs.getString("accountNum"));
				busUnit.setPhone(rs.getString("phone"));
				busUnit.setMail(rs.getString("mail"));
                                busUnit.setMainBusiness(rs.getString("mainBusiness"));

				
				busUnitList.add(busUnit);
				busUnit=null;
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
		
		return busUnitList;		
	}
}