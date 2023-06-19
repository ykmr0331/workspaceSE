package bytestream.filterStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 *  BufferedInputStream과 BufferedOutputStream은 데이터의 입력과 출력을 버퍼링하여 성능을 향상시키는 데 사용되고,
 *  DataInputStream과 DataOutputStream은 이진 형식으로 자바의 기본 데이터 유형을 처리하기 위한 필터 스트림입니다.
 */
public class DataOutputInputStreamMain {

	public static void main(String[] args) throws Exception {
//@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@자바의 기본 데이터를 출력스트림에 쉽게 쓸 수 있도록하는 필터스트림@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// DataOutputStream을 사용하여 데이터를 출력할 파일을 생성합니다.
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("dataOut.dat"));

		int intData = 2147483647;
		dos.writeInt(intData);  // 정수 데이터를 이진 형식으로 출력스트림에 씁니다.
		dos.writeByte(127);  // 바이트 데이터를 출력스트림에 씁니다.
		dos.writeBoolean(true);  // 불리언 데이터를 출력스트림에 씁니다.
		dos.writeChar('가');  // 문자 데이터를 출력스트림에 씁니다.
		dos.writeDouble(3.141592);  // 실수 데이터를 출력스트림에 씁니다.
		dos.writeUTF("오늘은 자바입출력을 공부합니다!!!");  // UTF-8 문자열 데이터를 출력스트림에 씁니다.

		dos.close();  // 출력스트림을 닫습니다.

		System.out.println("DataOutputStream.writeXXX() ---> dataOut.dat");
		// DataOutputStream.writeXXX() ---> dataOut.dat: 출력된 데이터 확인 메시지를 출력합니다.


		// 자바의 기본 데이터를 입력스트림으로부터 쉽게 읽을 수 있도록하는 필터스트림

		// DataInputStream을 사용하여 데이터를 읽을 파일을 생성합니다.
		DataInputStream dis = new DataInputStream(new FileInputStream("dataOut.dat"));

		System.out.println("DataOutputStream.readXXX() <--- dataOut.dat");
		// DataOutputStream.readXXX() <--- dataOut.dat: 읽은 데이터 확인 메시지를 출력합니다.

		int readInt = dis.readInt();  // 이진 형식으로 저장된 정수 데이터를 읽습니다.
		System.out.println("readInt:" + readInt);

		System.out.println("readByte:" + dis.readByte());  // 바이트 데이터를 읽고 출력합니다.
		System.out.println("readBoolean:" + dis.readBoolean());  // 불리언 데이터를 읽고 출력합니다.
		System.out.println("readChar:" + dis.readChar());  // 문자 데이터를 읽고 출력합니다.
		System.out.println("readDouble:" + dis.readDouble());  // 실수 데이터를 읽고 출력합니다.
		System.out.println("readUTF:" + dis.readUTF());  // UTF-8 문자열 데이터를 읽고 출력합니다.

		dis.close();  // 입력스트림을 닫습니다.
	}
}
