package bytestream.filterStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//지금 필터스트림 자식클래스인 버퍼스트림하는거임
public class BufferedOutputInputStreamMain {
/* 버퍼스트림의 특징
	BufferedInputStream과 BufferedOutputStream은 데이터의 입력과 출력을 버퍼링하여 성능을 향상시키는 데 사용됌
 */
	
	public static void main(String[] args) throws Exception{
		/***********************BufferedOutputStream**************************/
		FileOutputStream fis = new FileOutputStream("bufferedOut.dat");//아웃풋스트림
		BufferedOutputStream bos = new BufferedOutputStream(fis); //필터스트림 // 아웃풋 참조 넣어줘야함 
		
		// 3. 출력스트림(OutputStream)에 한바이트씩 쓴다(write)
		// write() 메서드는 출력스트림에 데이터를 씁니다.
		// write() 메서드는 바이트 단위로 데이터를 씁니다.
		// write() 메서드의 매개변수는 쓰고자 하는 데이터의 바이트 값입니다.
		bos.write(0); //Buffer에 담은거다 ㅇㅋ?
		bos.write(1);
		bos.write(2);
		bos.write(3);
		bos.write(4);
		bos.write(2147483647);
		for (int i = 0; i < 256; i++) {
			bos.write(i);
		}
		bos.close();
		System.out.println("BufferedOutputStream.write()-->bufferedOut.dat");
	
		
		
		/***********************BufferedInputStream**************************/
		//InputStream에 필터 달은 스트림  //두개의 스트림을 엮은거임
		//BufferedInputStream는 FilterInputStream의 자식이다.
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bufferedOut.dat"));
		int readByte = bis.read();//한바이트 읽었음
		System.out.println("1.byte " +readByte);
		readByte = bis.read();
		System.out.println("2.byte " +readByte);
		readByte = bis.read();
		System.out.println("3.byte " +readByte);
		readByte = bis.read();
		System.out.println("4.byte " +readByte);
		readByte = bis.read();
		while(true) {
			readByte=bis.read();
			if(readByte == -1 ) break;
			System.out.println(Integer.toBinaryString(readByte));
		}
		bis.close();
		System.out.println();
		System.out.println("BufferedInputStream.read()<-- bufferedOut.dat");

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
