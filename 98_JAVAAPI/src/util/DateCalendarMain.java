package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalendarMain {

	public static void main(String[] args) throws Exception{
		long currentTime = System.currentTimeMillis();
				//currentTimeMillis()를 사용하여 현재 시스템 시간을 밀리초 단위로 표현
		System.out.println("System.currentTimeMillis() ==>"+ currentTime);
		long startTime = System.currentTimeMillis();
		Thread.sleep(12);
			//Thread.sleep()을 사용하여 12밀리초 동안 대기하기 전의 현재 시스템 시간을 저장
		long endTime = System.currentTimeMillis();
		long duration = endTime-startTime;
		System.out.println("duration:"+duration+" ms");
		
		/*
		 * java.util.Date
		 *    - The class Date represents a specific instantin time, with millisecond precision. 
		 */
		Date now=new Date();
		String nowString = now.toLocaleString();
				//now 날짜의 문자열 표현을 저장
		System.out.println(nowString);
		long currentTimeMillis1=now.getTime();
		System.out.println("Date.getTime()==>"+currentTimeMillis1);
		
		System.out.println("-------------SimpleDateFormat[Date --> String]-----------------");
		/*
		 * SimpleDateFormat:Date객체의 시간을 문자열로 변경해주는 클래스
		 */
		SimpleDateFormat sdf1 = new SimpleDateFormat();
			// SimpleDateFormat 클래스는 Date 객체를 형식화하는데 사용됌
		sdf1.applyPattern("yyyy 년 MM 월 dd 일");
			//applyPattern() :형식화할 날짜의 패턴을 설정
		String formatStr1 = sdf1.format(now);
			// format(): 날짜를 원하는 형식으로 포맷팅하여 문자열로 반환
		System.out.println(formatStr1);
		
		sdf1.applyPattern("yyyy/MM/dd HH:mm:ss.SSSS");
			//applyPattern() :형식화할 날짜의 패턴을 설정
		String formatStr2=sdf1.format(now);
			// format(): 날짜를 원하는 형식으로 포맷팅하여 문자열로 반환
		System.out.println(formatStr2);
		
		sdf1.applyPattern("yyyy");
		String formatStr3=sdf1.format(now);		
		System.out.println("String-->"+formatStr3);
		System.out.println("int   -->"+Integer.parseInt(formatStr3));
		System.out.println("-------------SimpleDateFormat[String --> Date]-----------------");
		SimpleDateFormat sdf2=new SimpleDateFormat();
		sdf2.applyPattern("yyyy-MM-dd");
		Date myBirthDay = sdf2.parse("2000-06-30");
		System.out.println("sdf" +myBirthDay.toString());
		System.out.println(myBirthDay.toLocaleString()); 
									//Date 객체를 로케일(지역화)에 맞추어 현지화된 문자열로 변환
		System.out.println(myBirthDay.getTime()); //밀리초 단위의 시간을 출력
		
		sdf2.applyPattern("yyyy/MM/dd HH:mm:ss");
		Date yourBirthDay=sdf2.parse("1998/05/12 17:45:23");
		System.out.println(yourBirthDay.toString());
		System.out.println(yourBirthDay.toLocaleString()); //
		System.out.println(yourBirthDay.getTime());
	    /***************************Calendar*****************************/
		System.out.println("***************************Calendar*****************************");
		Calendar cal1=Calendar.getInstance(); 
		System.out.println(cal1);
		long currentTimeMilil3 = cal1.getTimeInMillis();
		System.out.println("Calendar.getTimeInMillis():"+currentTimeMilil3);
		int y = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH);
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		int hour = cal1.get(Calendar.HOUR);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		int msecond = cal1.get(Calendar.MILLISECOND);
		System.out.println(y+"/"+(month+1)+"/"+day+" "+hour+":"+minute+":"+second+"."+msecond);
		
		System.out.println("---------- Calendar-->Date ------------");
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2021, Calendar.JANUARY, 10, 13, 59, 59);
		Date date2 = cal2.getTime();
		System.out.println("Date date2-->"+date2);
		
		System.out.println("-----------------Date객체메소드----------------");
		Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-03");
		Date date4 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-03");
		Date date5 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-15");
		
		System.out.println("date3.equals(date4): "+date3.equals(date4)); // 날짜가 같으니까 true가 나온다.
		//System.out.println("date3==date4: "+(date3==date4));	//주소비교임 
		System.out.println("date4.equals(date5): "+date4.equals(date5)); // 날짜가 다르니까 false가 나온다.
		System.out.println("date3.compareTo(date4): " + date3.compareTo(date4)); //0 
		System.out.println("date4.compareTo(date5): " + date4.compareTo(date5));//-1 나옴. date4가 더 작으니까
		System.out.println("date5.compareTo(date4): " + date5.compareTo(date4));//1나옴 .  date5가 더 크니까
		
		long gapMiliSec = date5.getTime() - date4.getTime();
		/*Date 객체가 나타내는 날짜와 시간을 1970년 1월 1일 00:00:00 GMT(협정 세계시)부터
		  	 경과한 시간을 밀리초 단위로 반환*/
		System.out.println("gapMiliSec: " + gapMiliSec);
		System.out.println("sec: " + gapMiliSec/1000);
		System.out.println("min: " + gapMiliSec/1000/60);
		System.out.println("hour: " + gapMiliSec/1000/60/60);
		System.out.println("day: " + gapMiliSec/1000/60/60/24);
		
		
		System.out.println("-----------------java.util.Date --> java.sql.Date----------------");
		java.util.Date utilDate1 = new java.util.Date();
		java.util.Date utilDate2 = new java.util.Date(System.currentTimeMillis());
		
		java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime()); //sql Date는 매개변수 0개가 없다. getTime() 넣어줘야 
		java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
		System.out.println(sqlDate1);
		System.out.println(sqlDate2);

		
		System.out.println("-----------------java.sql.Date --> java.util.Date----------------");
		
		java.sql.Date sqlDate3 = new java.sql.Date(System.currentTimeMillis()); //sql Date는 매개변수 0개가 없다. getTime() 넣어줘야 
		java.sql.Date sqlDate4 = new java.sql.Date(new SimpleDateFormat("yyyy/MM/dd").parse("2000/05/05").getTime());
			//new SimpleDateFormat("yyyy/MM/dd")를 사용하여 날짜 형식을 지정하는 SimpleDateFormat 객체를 생성
			//parse() 메서드는 문자열을 Date 객체로 변환
			//getTime() 메서드는 Date 객체의 시간을 밀리초 단위로 반환
		java.util.Date utilDate3 = sqlDate3;
		java.util.Date utilDate4 = sqlDate4;
		System.out.println(utilDate3);
		System.out.println(utilDate4);
	}

}









