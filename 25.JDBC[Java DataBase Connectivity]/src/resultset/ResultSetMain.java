package resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.common.DataSource;

public class ResultSetMain {
	/*
	<< product >>
	이름         널?       유형            
	---------- -------- ------------- 
	NO         NOT NULL NUMBER(7)     
	NAME                VARCHAR2(50)  
	SHORT_DESC          VARCHAR2(255) 
	PRICE               NUMBER(10,3)  
	IPGO_DATE           DATE 
	 */
	public static void main(String[] args)throws Exception {
		String selectSql = "select no,name,short_desc, price,ipgo_date from product";
		Connection con = new DataSource().getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		
	
		
		System.out.println("--------------ResultSet.get타입(컬럼이름)-------------------");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String name = rs.getString("name");
			String shortDesc = rs.getString("short_desc");
			double price = rs.getDouble("price");
			Date ipgoDate = rs.getDate("ipgo_date");
			System.out.println(no+ "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
		

		
		System.out.println("--------------ResultSet.get타입(컬럼index)-------------------");
		rs = pstmt.executeQuery();	
		while(rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			String shortDesc = rs.getString(3);
			double price = rs.getDouble(4);
			Date ipgoDate = rs.getDate(5);
			System.out.println(no+ "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
		
		
		
		System.out.println("--------------ResultSet.getObject(컬럼이름)-------------------");
		rs = pstmt.executeQuery();	
		while(rs.next()) {
			Object no = rs.getObject("no");
			Object name = rs.getObject("name");
			Object shortDesc = rs.getObject("short_desc");
			Object price = rs.getObject("price");
			Object ipgoDate = rs.getObject("ipgo_date");
			System.out.println(no+ "\t" + name + "\t" + shortDesc + "\t" + price + "\t" + ipgoDate);
		}
		rs.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
