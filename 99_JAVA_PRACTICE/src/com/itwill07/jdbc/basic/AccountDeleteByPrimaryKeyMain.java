package com.itwill07.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AccountDeleteByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";

		String deleteSql = "delete account where no=13";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		System.out.println(">> delete row count : " + rowCount);
	}
}
