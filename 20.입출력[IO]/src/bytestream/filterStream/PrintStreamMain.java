package bytestream.filterStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {
	/*
	 * PrintStream은 Java에서 출력 스트림을 다루는 클래스입니다. 이 클래스는 바이트 기반 출력 스트림인 OutputStream의
	 * 하위 클래스로, 다양한 유형의 데이터를 텍스트 형식으로 출력할 수 있는 기능을 제공합니다
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * throws Exception은 FileOutputStream 객체를 생성하는 과정에서 파일을 생성하거나 열 때 
		 * 	발생할 수 있는 IOException을 호출자에게 전달하기 위해 사용됩니다. 
		 */
        // FileOutputStream을 이용하여 "printStream.txt" 파일에 출력하는 PrintStream 객체 생성
        PrintStream pout = new PrintStream(new FileOutputStream("printStream.txt"));
        
        // PrintStream을 사용하여 다양한 데이터를 파일에 출력
        pout.print(1234); // 
        pout.print('김'); // 
        pout.print(true); // 
        pout.print(3.141592); 
        pout.print("1234"); 
        pout.print('김'); 
        pout.print(true);     
        pout.print(3.141592);    ;
        pout.write('u');
        
        System.out.println("----------------------printStream.print()-----------------------------");
        
        // PrintStream 객체를 닫음
        pout.close();
    }

}
