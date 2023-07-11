package dao.address;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileLoadMain {

	public static void main(String[] args) throws Exception {
	
	/*
	 * .properties파일을 loading해서 Properties객체[Map]를 만들어준다
	 */
		
		Properties properties = new Properties(); 
		/*Properties는 key와 value가 모두 String 타입인 맵 형태의 객체,
		               Hashtable을 상속한 클래스  
					   주로 설정 정보를 관리하고 속성을 로드하고 저장하는 데 사용됩니다.*/
		/*
		 <<절대경로>>
		FileInputStream fis = new FileInputStream("C:\\2023_05_java_developer\\workspaceSE\\25.JDBC[Java DataBase Connectivity]\\src\\application.properties");
		*/
		
		
		/*
		 *<<클래스경로>> 
		 */
		InputStream fis= PropertiesFileLoadMain.class.getResourceAsStream("/application.properties");
		/*PropertiesFileLoadMain 클래스와 동일한 클래스 경로에 있는 application.properties 파일을 읽기 위해 사용되는 코드
		 * getResourceAsStream() 메소드를 호출하여 application.properties 파일에 대한 InputStream 객체를 얻음
		 * getResourceAsStream() 메소드는 클래스 경로에서 지정된 리소스를 가져오는 데 사용됌.
		 * */
		
		properties.load(fis);
		/*
		 * Properties 객체에 파일의 내용을 로드합니다. 
		 * load() 메소드는 InputStream으로부터 파일의 내용을 읽어서 Properties 객체에 로드합니다.
		 */
		
		System.out.println(properties);
		/*
		  << Properties 객체 >>
		 --------------------------
		 key(String) | value(String)
		 -------------------------
		 username    |  guard
		 password	 |  1111
		 contextPath |  /shopping
		 shop.title  |  울트라짱쇼핑몰
		 */
		System.out.println("Properties size:"+properties.size());
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		String contextPath=properties.getProperty("contextPath");
		String shopTitle=properties.getProperty("shop.title");
		System.out.println(username);
		System.out.println(password);
		System.out.println(contextPath);
		System.out.println(shopTitle);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
