package com.itwill07.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountSelectAllMain {

	public static void main(String[] args) throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		String selectSql = "select * from account";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		
		if (rs.next()) {
			do {
				int no = rs.getInt("no");
				String owner = rs.getString("owner");
				int balance = rs.getInt("balance");
				int iyul= rs.getInt("iyul");
				
				System.out.println(no + "\t" + owner  + "\t" +balance + "\t" +iyul);
			} while (rs.next());
		}else {
			System.out.println(">> 게시글 없음.");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}
