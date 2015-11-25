package Model;
/*@author yixiu
 *@version beta
 * 数据库链接的基类，其他的model都对该类继承
 * 一般情况下只需要修改用户名跟密码就可以，数据库名为apple，我们还要商议一个统一数据库的用户名跟密码
 * */
import java.sql.*;

public class jdbc {
	//这些应该统一使用一个用户名跟密码
    private final String user = "shujuku";//用户名
    private final String pwd = "123456";//密码
    private final String connectUrl = "jdbc:sqlserver://localhost:1433;databaseName=apple";
    //初始化数据库链接
    public Connection initDB() throws SQLException {
		// SQL数据库引擎
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			// 加载数据库引擎，返回给定字符串名的类
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}

		System.out.println("数据库驱动加载成功！");

		Connection con = null;
		try {
			// //连接数据库对象
			con = DriverManager.getConnection(connectUrl, user, pwd);
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
        return con;
    }
}
