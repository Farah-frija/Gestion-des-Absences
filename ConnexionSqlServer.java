package page1;

import javax.swing.*;
import java.sql.*;
public class ConnexionSqlServer {
	Connection con=null;
	public static Connection connecterBD()
	{try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String user = "Farah";
		String pwd = "farah";
		String url = "jdbc:sqlserver://LAPTOP-S52K1TAD\\SQLEXPRESS01;databaseName=students;trustServerCertificate=true";
		Connection con = DriverManager.getConnection(url, user, pwd);
  return con;
          }
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, e);
		return null;
	}
}
}
