package statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class PreparedStatementMain {

	public static void main(String[] args) throws Exception {
		/*prepareStatement()는 JDBC에서 사용되는 PreparedStatement 객체를 생성하는 메서드입니다.
		 *  PreparedStatement는 SQL 문에 인자(매개변수)를 전달할 수 있는 기능을 제공합니다.*/
		/************데이타베이스 접속정보************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		/*****************************************************/


		/************** [PreparedStatement] ***********************/
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("%%%%%%%%%%%%%%%%% [select] %%%%%%%%%%%%%%%");
		// String selectSql="select empno,ename,job,sal,hiredate from emp where
		// sal>=1000 and sal<=4000 and job='SALESMAN' or job='CLERK'";
		String selectSql = "select empno,ename,job,sal,hiredate from emp where sal>=? and sal<=? and job=? or job=?";
		PreparedStatement pstmt = con.prepareStatement(selectSql);

		int sal1 = 1000;
		int sal2 = 4000;
		String job1 = "SALESMAN";
		String job2 = "CLERK";
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("empno") + "\t" + rs.getString("ename") + "\t" + rs.getInt("sal") + "\t"
					+ rs.getString("job"));
		}
		rs.close();
		System.out.println("----------------------------");
		sal1 = 2000;
		sal2 = 5000;
		job1 = "MANAGER";
		job2 = "ANALYST";
		pstmt.setInt(1, sal1);
		pstmt.setInt(2, sal2);
		pstmt.setString(3, job1);
		pstmt.setString(4, job2);

		rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("empno") + "\t" + rs.getString("ename") + "\t" + rs.getInt("sal") + "\t"
					+ rs.getString("job"));
		}
		rs.close();
		pstmt.close();

		System.out.println("%%%%%%%%%%%%%%%%% [delete] %%%%%%%%%%%%%%%");
		// String deleteSql="delete from emp where empno=9000";
		String deleteSql = "delete from emp where empno=?";
		PreparedStatement pstmt0 = con.prepareStatement(deleteSql);

		pstmt0.setInt(1, 9001);
		int rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9001번삭제:" + rowCount0);

		pstmt0.setInt(1, 9002);
		rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9002번삭제:" + rowCount0);

		pstmt0.setInt(1, 9003);
		rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9003번삭제:" + rowCount0);

		pstmt0.setInt(1, 9004);
		rowCount0 = pstmt0.executeUpdate();
		System.out.println(">>> PreparedStatement 9004번삭제:" + rowCount0);

		pstmt0.close();

		
		
		
		System.out.println("%%%%%%%%%%%%%%%%% [insert] %%%%%%%%%%%%%%%");
		
		
		/********************* 9001 insert ***************************/
		// String insertSql1="insert into emp  values(9000,'JUNG','MANAGER',7369,to_date('2000/01/01','YYYY/MM/DD'),3000.34,30,40)";
		String insertSql1 = "insert into emp values(?,?,?,?,to_date(?,?),?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(insertSql1);
				//PreparedStatement 인터페이스의  setXXX메서드: SQL문의 매개변수에 값을 설정하기 위해 사용됌
		pstmt1.setInt(1, 9001);
		pstmt1.setString(2, "JUNG");
		pstmt1.setString(3, "MAMAGER");
		pstmt1.setInt(4, 7369);
		pstmt1.setString(5, "2000/01/01");
		pstmt1.setString(6, "YYYY/MM/DD");
		pstmt1.setDouble(7, 3000.34);
		pstmt1.setInt(8, 30);
		pstmt1.setInt(9, 40);
		int rowCount1 = pstmt1.executeUpdate();
			// executeUpdate()메소드:
				//INSERT, UPDATE, DELETE와 같은 DML(Data Manipulation Language) 문을 실행하고, 실행 결과로 영향을 받은 행의 수를 반환
		System.out.println(">>> PreParedStatement 9001--> " + rowCount1 + " 행 insert");
		pstmt1.close();

		
		/********************* 9002 insert ***************************/
		// String insertSql2="insert into emp values(9002,'KIM','CLERK',7369,sysdate,6000.34,80,40)";
		String insertSql2 = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(insertSql2);
		pstmt2.setInt(1, 9002);
		pstmt2.setString(2, "KIM");
		pstmt2.setString(3, "CLERK");
		pstmt2.setInt(4, 7369);
		pstmt2.setDouble(5, 6000.34);
		pstmt2.setInt(6, 80);
		pstmt2.setInt(7, 40);
		int rowCount2 = pstmt2.executeUpdate();
		System.out.println(">>> PreparedStatement 9002--> " + rowCount2 + " 행 insert");
		pstmt2.close();
		
		
		/********************* 9003 insert ***************************/
		// String insertSql3="insert into emp values(9003,'DIM','SALESMAN',7369,날짜데이타,8000.99,70,40)";
		String insertSql3 = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt3 = con.prepareStatement(insertSql3);
		pstmt3.setInt(1, 9003);
		pstmt3.setString(2, "DIM");
		pstmt3.setString(3, "SALESMAN");
		pstmt3.setInt(4, 7369);
		pstmt3.setDate(5, new Date(System.currentTimeMillis()));
		pstmt3.setDouble(6, 8000.99);
		pstmt3.setInt(7, 70);
		pstmt3.setInt(8, 40);
		int rowCount3 = pstmt3.executeUpdate();
		System.out.println(">>> PreparedStatement 9003--> " + rowCount3 + " 행 insert");
		pstmt3.close();
		
		
		// String insertSql4 = "insert into emp values(9004,null,null,null,null,null,null,null)";
		String insertSql4 = "insert into emp values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt4 = con.prepareStatement(insertSql4);
			//PreparedStatement 객체를 생성하기 위해 사용되는 메서드
		pstmt4.setInt(1, 9004);
		pstmt4.setNull(2, Types.VARCHAR); //setNull() 메서드는 매개변수의 위치에 NULL 값을 설정하는 데 사용됌
		pstmt4.setNull(3, Types.VARCHAR);
		pstmt4.setNull(4, Types.INTEGER);
		pstmt4.setNull(5, Types.DATE);
		pstmt4.setNull(6, Types.DOUBLE);
		pstmt4.setNull(7, Types.INTEGER);
		pstmt4.setNull(8, Types.INTEGER);
		int rowCount4 = pstmt4.executeUpdate();
			// executeUpdate: INSERT, UPDATE 또는 DELETE와 같은 DML 문을 실행하고, 영향을 받은 행의 수를 반환
		System.out.println(">>> PreparedStatement 9004--> " + rowCount4 + " 행 insert");
		pstmt4.close();
		
		
		
		System.out.println("%%%%%%%%%%%%%%%%% [update] %%%%%%%%%%%%%%%");
		
		//String updateSql = "update emp set sal = sal*1.3 where empno >= 7369 and empno<=7600";
		String updateSql ="update emp set sal = sal*? where empno >= ? and empno <= ?";
		PreparedStatement pstmt5=con.prepareStatement(updateSql);
		pstmt5.setDouble(1, 0.8);
		pstmt5.setInt(2, 7000);
		pstmt5.setInt(3, 8000);
		int rowCount5=pstmt5.executeUpdate();
		System.out.println(">>> PreparedStatement update--> "+ rowCount5+ "행 update");
		
		pstmt5.close();
		con.close();
	}

}











