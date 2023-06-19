package bytestream;

import java.io.FileInputStream;
/*

<<입력스트림(InputStream)사용방법>>
데이타 source 선정(파일)
입력스트림(InputStream)객체생성(FileInputStream)
3. 입력스트림(InputStream)으로부터 한바이트씩 읽는다(read)
입력스트림(InputStream)닫는다.(close) */
public class FileInputStreamMain {
	
	public static void main(String[] args) throws Exception {
		// 1. 데이타 source 선정(파일)
		FileInputStream fis = new FileInputStream("fileOut.dat");
		// "fileOut.dat" 파일을 읽어올 데이터 소스로 지정합니다.

		// 2. 입력스트림(InputStream)객체생성(FileInputStream)
		// FileInputStream 클래스는 파일에서 데이터를 읽는 데 사용되는 클래스입니다.
		// FileInputStream 클래스의 생성자는 파일의 경로를 매개변수로 받습니다.





		int byteCount = 0;
		// 3. 입력스트림(InputStream)으로부터 한 바이트씩 읽는다(read)
		// read() 메서드는 입력스트림에서 데이터를 읽습니다.
		// read() 메서드는 바이트 단위로 데이터를 읽습니다.
		// read() 메서드의 리턴값은 읽은 데이터의 바이트 값입니다.
		int readByte = fis.read();
		byteCount++;
		System.out.println("1.byte:" + Integer.toBinaryString(readByte));
		// 첫 번째 바이트를 읽고, 이진수 형태로 출력합니다.

		readByte = fis.read();
		byteCount++;
		System.out.println("2.byte:" + Integer.toBinaryString(readByte));
		// 두 번째 바이트를 읽고, 이진수 형태로 출력합니다.

		readByte = fis.read();
		byteCount++;
		System.out.println("3.byte:" + Integer.toBinaryString(readByte));
		// 세 번째 바이트를 읽고, 이진수 형태로 출력합니다.

		readByte = fis.read();
		byteCount++;
		System.out.println("4.byte:" + Integer.toBinaryString(readByte));
		// 네 번째 바이트를 읽고, 이진수 형태로 출력합니다.

		System.out.println();
		
		while (true) {
			readByte = fis.read();
			if (readByte == -1)
				break;
			byteCount++;
			System.out.println(Integer.toBinaryString(readByte));
			// 나머지 바이트들을 읽고, 이진수 형태로 출력합니다.
		}

		fis.close();
		// 4. 입력스트림(InputStream)을 닫는다.(close)
		// close() 메서드는 입력스트림을 닫습니다.
		// close() 메서드는 입력스트림을 닫은 후에는 더 이상 입력스트림을 사용할 수 없습니다.
		System.out.println("FileInputStream.read() <----- fileOut.dat:" + byteCount + " 바이트 읽음");
		// 파일에서 읽은 총 바이트 수를 출력합니다.
	}
}
