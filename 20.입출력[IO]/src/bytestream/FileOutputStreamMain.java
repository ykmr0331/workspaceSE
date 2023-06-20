 
package bytestream;

import java.io.FileOutputStream;

/*

<<출력스트림(OutputStream)사용방법>>
데이타 목적지(target,destination) 선정(파일)
출력스트림(OutputStream)객체생성(FileOutputStream)
출력스트림(OutputStream)에 한바이트씩 쓴다(write)
출력스트림(OutputStream)닫는다.(close)
*/
public class FileOutputStreamMain {
	public static void main(String[] args) throws Exception {
// 1. 데이타 목적지(target,destination) 선정(파일)
// 2. 출력스트림(OutputStream)객체생성(FileOutputStream)
// FileOutputStream 클래스는 파일에 데이터를 쓰는 데 사용되는 클래스입니다.
// FileOutputStream 클래스의 생성자는 파일의 경로를 매개변수로 받습니다.
		FileOutputStream fos = new FileOutputStream("fileOut.dat");	


		
// 3. 출력스트림(OutputStream)에 한바이트씩 쓴다(write)
// write() 메서드는 출력스트림에 데이터를 씁니다.
// write() 메서드는 바이트 단위로 데이터를 씁니다.
// write() 메서드의 매개변수는 쓰고자 하는 데이터의 바이트 값입니다.
		fos.write(0b00000000000000000000000000000000);
		// 0b00000000000000000000000000000000은 2진수 0입니다.
		fos.write(1);
		// 1은 10진수 1입니다.
		fos.write(2);
		// 2는 10진수 2입니다.
		fos.write(3);
		// 3는 10진수 3입니다.
		fos.write(4);
		// 4는 10진수 4입니다.
		fos.write(0b00000000000000000000000011111111);
		// 0b00000000000000000000000011111111은 2진수 255입니다.

		for (int i = 0; i < 256; i++) {
			fos.write(i);
		}
// for 루프는 0부터 255까지의 숫자를 출력스트림에 씁니다.

		fos.close();
		// 4. 출력스트림(OutputStream)닫는다.(close)
		// close() 메서드는 출력스트림을 닫습니다.
		// close() 메서드는 출력스트림을 닫은 후에는 더 이상 출력스트림을 사용할 수 없습니다.

		System.out.println("FileOutputStream.write()--> fileOut.dat");
// 출력스트림을 사용하여 파일에 데이터를 썼습니다.
	}
}