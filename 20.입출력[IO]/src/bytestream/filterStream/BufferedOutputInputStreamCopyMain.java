package bytestream.filterStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* 버퍼스트림의 특징
	BufferedInputStream과 BufferedOutputStream은 데이터의 입력과 출력을 버퍼링하여 성능을 향상시키는 데 사용됌
 */
	

public class BufferedOutputInputStreamCopyMain {

	public static void main(String[] args)  throws Exception{
		long startTime = System.currentTimeMillis(); // 현재시간 startTime변수에 저장@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("ChromeSetup.exe"));
		//빨대에 필터까지 장착했다고
		
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("ChromeSetup_copy.exe"));
		
		int byteCount = 0;
		int starCount = 0;
		while(true) {
			int readByte =bis.read();
			if(readByte == -1) break;
			byteCount++;
			if(byteCount%1024==0) {//읽은 바이트 수가 1024의 배수이면 콘솔에 *를 출력합니다.
				System.out.print("*");
				starCount++;
				if(starCount%50==0) {// 출력된 * 수가 50의 배수이면 콘솔에 줄 바꿈 문자를 출력합니다.
					System.out.println();
				}
			}
			bos.write(readByte);
		}
		bis.close();
		bos.close();
		
		System.out.println();		
		System.out.println("BufferedOutputInputStreamFileCopy:" + byteCount + "bytes copy!!");
		long endTime = System.currentTimeMillis(); // 현재시간 startTime변수에 저장
		long duration = endTime - startTime;// 걸린시간 알아보려고 하는거
		System.out.println(duration+ "ms...");
	}
	
}
