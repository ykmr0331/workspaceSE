package dao.member2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
 * 데이터베이스 설정정보를 이용해서
 * Connection을 생성하고 해지하는 역할을 하는 클래스
 * (Dao객체들이 사용하는 클래스)
 */
public class DataSource {
	private String driverClass;
	private String url;
	private String user;
	private String password;
	
	public DataSource() throws Exception {
		/********jdbc.properties 파일을 읽어서 데이터베이스 접속정보를 멤버필드에 저장 ********/
		Properties properties = new Properties();
		InputStream propertiesInput = DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(propertiesInput);
		
		this.driverClass = properties.getProperty("driverClass");
		this.url = properties.getProperty("url");
		this.user = properties.getProperty("user");
		this.password = properties.getProperty("password");
	}
	
	public Connection getConnection() throws Exception {
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	public void close(Statement stmt,Connection con) throws Exception{
		stmt.close();
		con.close();
	}
	
	public void close(ResultSet rs ,Statement stmt,Connection con) throws Exception{
		rs.close();
		stmt.close();
		con.close();
	}
}