package Model;
/*@author yixiu
 *@version beta
 * ���ݿ����ӵĻ��࣬������model���Ը���̳�
 * һ�������ֻ��Ҫ�޸��û���������Ϳ��ԣ����ݿ���Ϊapple�����ǻ�Ҫ����һ��ͳһ���ݿ���û���������
 * */
import java.sql.*;

public class jdbc {
	//��ЩӦ��ͳһʹ��һ���û���������
    private final String user = "shujuku";//�û���
    private final String pwd = "123456";//����
    private final String connectUrl = "jdbc:sqlserver://localhost:1433;databaseName=apple";
    //��ʼ�����ݿ�����
    public Connection initDB() throws SQLException {
		// SQL���ݿ�����
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			// �������ݿ����棬���ظ����ַ���������
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("�Ҳ������������� ����������ʧ�ܣ�");
			e.printStackTrace();
		}

		System.out.println("���ݿ��������سɹ���");

		Connection con = null;
		try {
			// //�������ݿ����
			con = DriverManager.getConnection(connectUrl, user, pwd);
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
        return con;
    }
}
