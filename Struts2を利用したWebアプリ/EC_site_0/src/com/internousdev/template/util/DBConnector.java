package com.internousdev.template.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

//	MySQL接続に必要な情報
//	staticはなぜ？
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/template";
	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driverName);
	//		MySQLへ接続する準備
			con = (Connection) DriverManager.getConnection(url, user, password);

		} catch(ClassNotFoundException e) {
			e.printStackTrace();

		} catch(SQLException e) {
			e.printStackTrace();
		}

	//	Mysqlに接続できたか情報を渡します。
		return con;
	}
}
