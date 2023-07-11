package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalendarMain {

	public static void main(String[] args) throws Exception{
		long currentTime = System.currentTimeMillis();
		System.out.println("System.currentTimeMillis() ==>"+ currentTime);
		long startTime = System.currentTimeMillis();
		Thread.sleep(12);
		long endTime = System.currentTimeMillis();
		long duration = endTime-startTime;
		System.out.println("duration:"+duration+" ms");
		
		/*
		 * java.util.Date
		 *    - The class Date represents a specific instantin time, with millisecond precision. 
		 */
		Date now=new Date();
		String nowString = now.toLocaleString();
		System.out.println(nowString);
		long currentTimeMillis1=now.getTime();
		System.out.println("Date.getTime()==>"+currentTimeMillis1);
		
		System.out.println("-------------SimpleDateFormat[Date --> String]-----------------");
		/*
		 * SimpleDateFormat:Date객체의 시간을 문자열로 변경해주는 클래스
		 */
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		sdf1.applyPattern("yyyy 년 MM 월 dd 일");
		String formatStr1 = sdf1.format(now);
		System.out.println(formatStr1);
		
		sdf1.applyPattern("yyyy/MM/dd HH:mm:ss.SSSS");
		String formatStr2=sdf1.format(now);
		System.out.println(formatStr2);
		
		sdf1.applyPattern("yyyy");
		String formatStr3=sdf1.format(now);		
		System.out.println("String-->"+formatStr3);
		System.out.println("int   -->"+Integer.parseInt(formatStr3));
		System.out.println("-------------SimpleDateFormat[String --> Date]-----------------");
		SimpleDateFormat sdf2=new SimpleDateFormat();
		sdf2.applyPattern("yyyy-MM-dd");
		Date myBirthDay = sdf2.parse("2000-06-30");
		System.out.println(myBirthDay.toString());
		System.out.println(myBirthDay.toLocaleString());
		System.out.println(myBirthDay.getTime());
		
		sdf2.applyPattern("yyyy/MM/dd HH:mm:ss");
		Date yourBirthDay=sdf2.parse("1998/05/12 17:45:23");
		System.out.println(yourBirthDay.toString());
		System.out.println(yourBirthDay.toLocaleString());
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
		
		
		
		
		
		
	}

}









