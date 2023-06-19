package charstream;

import java.io.FileWriter;

public class FileWriterReaderMain {
/*
 * Writer와 Reader는 자바의 문자 기반 입출력 스트림을 다루기 위한 추상 클래스입니다.
 *  이들은 문자 데이터를 입출력하기 위한 다양한 메서드를 제공합니다.
 */
	public static void main(String[] args) throws Exception{
		/*
		 * FileWriter 클래스의 생성자와 write() 메서드는 
		 * IOException을 발생시킬 수 있습니다. 
		 * 이러한 입출력 관련 예외는 파일이 존재하지 않거나, 
		 * 파일에 쓰기 권한이 없는 등의 이유로 발생할 수 있습니다. 
		 */
		FileWriter fw = new FileWriter("fileWriter.txt");
		
		fw.write(44356);
		fw.write('A');
		fw.write('김');
		
		for (int i = 0; i < 65536; i++) {
			fw.write(i);
			if(i%100==0) {
				fw.write('\n');
			}
		}
		fw.write("\n");
		fw.write("문자열을 맘대로 막써요");
		fw.write("\n");
		fw.write("한라인\n");
		fw.write("두라인\n");
		fw.write("세라인\n");
		
		
		/*
		 * 채워지지 않은 버퍼에 있는 데이터를 출력스트림에 쓴다.
		
		 * flush() 메서드는 출력 스트림의 버퍼에 있는 데이터를 강제로 출력하는 역할을 합니다. 
		 * 버퍼는 일시적으로 데이터를 모아두는 공간으로,
		 *  데이터를 한 번에 출력함으로써 입출력 성능을 향상시킬 수 있습니다.
		 */
		
		//BufferedInputStream과 BufferedOutputStream은 데이터의 입력과 출력을 버퍼링하여 성능을 향상시키는 데 사용됌

		fw.flush();
		//fw.close();
		System.out.println("FileWriter.write() --> fileWriter.txt");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
