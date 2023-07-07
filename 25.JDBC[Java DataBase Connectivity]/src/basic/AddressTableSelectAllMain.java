package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressTableSelectAllMain {

	public static void main(String[] args) throws Exception{

		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		/************************************************/
		String selectSql=
				"select no,name,phone,address from address order by no";
		/*
		 1.Driver class loading
	     2.Connection 객체생성
		 3.Statement객체생성
		 4.SQL문전송(select)
		 5.SQL문전송(select)결과 ResultSet(결과집합)을반환
		 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		/*
		<< Statement >>
		ResultSet executeQuery(String sql) throws SQLException
			- Executes the given SQL statement, which returns a single ResultSet object.

			Parameters:
				sql - an SQL statement to be sent to the database, 
			          typically a static SQL SELECT statement
			Returns:
				a ResultSet object that contains the data produced by the given query; 
				never null
		 */
		ResultSet rs = stmt.executeQuery(selectSql);
		/*
		<<ResultSet>>
		boolean next() throws SQLException
			- Moves the cursor forward one row from its current position.
			- A ResultSet cursor is initially positioned before the first row; 
			  the first call to the method next makes the first row the current row; 
			  the second call makes the second row the current row, and so on.
		    - When a call to the next method returns false, 
		    	the cursor is positioned after the last row.
		*/
		
		/*
		이름      널?       유형           
		------- -------- ------------ 
		NO      NOT NULL NUMBER(10)   
		NAME             VARCHAR2(50) 
		PHONE            VARCHAR2(50) 
		ADDRESS          VARCHAR2(60) 
		 */
		if(rs.next()) {
			do{
				/* --------------------------------
				 * DB타입 		| 자바타입
				 * --------------------------------
				 * number		| int,double(float)
				 * varchar2,char| String
				 * Date			| Date
				 * --------------------------------
				 */
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				System.out.println(no+" "+name+" "+phone+" "+address);
			}while(rs.next());
		}else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		
		
		
		
		rs.close();
		stmt.close();
		con.close();
	}

}