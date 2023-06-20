package charstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterBufferedReaderMain {

    public static void main(String[] args) throws Exception {
        
        // PrintWriter를 사용하여 "printWriterBufferedReader.txt" 파일을 생성하고 데이터를 출력합니다.
        PrintWriter pw = new PrintWriter(new FileWriter("printWriterBufferedReader.txt"));
        pw.println("첫번째줄"); // "첫번째줄"을 파일에 출력
        pw.println("두번째줄"); // "두번째줄"을 파일에 출력
        pw.println("세번째줄"); // "세번째줄"을 파일에 출력
        pw.println("네번째줄"); // "네번째줄"을 파일에 출력
        pw.println("다섯번째줄"); // "다섯번째줄"을 파일에 출력
        pw.println("여섯번째줄"); // "여섯번째줄"을 파일에 출력
        pw.println("일곱번째줄"); // "일곱번째줄"을 파일에 출력
        pw.flush(); // 출력 버퍼를 비웁니다.
        pw.close(); // 파일을 닫습니다.
        System.out.println("PrintWriter.println() --> printWriterBufferedReader.txt");
        
        // BufferedReader를 사용하여 "printWriterBufferedReader.txt" 파일을 읽어옵니다.
        BufferedReader br = new BufferedReader(new FileReader("printWriterBufferedReader.txt"));
        
		/*
		public String readLine() throws IOException
			Reads a line of text. 
			A line is considered to be terminated by 
				any one of a line feed ('\n'), 
				a carriage return ('\r'),
				or a carriage return followed immediately by a linefeed(\r\n).
		Returns:
			A String containing the contents of the line,
			  not including any line-termination characters, 
		   or null if the end of the stream has been reached
		*/
        
        /*
         * public String readLine() throws IOException
         * 
         * 한 줄의 텍스트를 읽어옵니다.
         * 한 줄은 개행 문자('\n'), 복귀 문자('\r') 또는 복귀 문자 다음에 즉시 나오는 개행 문자('\r\n') 중 하나로 끝납니다.
         * 
         * 반환값:
         *     개행 문자를 제외한 한 줄의 내용을 담은 문자열을 반환합니다.
         *     스트림의 끝에 도달한 경우 null을 반환합니다.
         */
        
        String readLine = br.readLine(); // 첫 번째 줄을 읽어옵니다.
        System.out.println("1. readLine: " + readLine);
        /**BufferedReader에서 다음 줄을 읽어오려면 readLine() 메서드를 다시 호출해야 합니다.**/
        readLine = br.readLine(); // 두 번째 줄을 읽어옵니다.
        System.out.println("2. readLine: " + readLine);
        
        while (true) {
            readLine = br.readLine(); // 한 줄씩 읽어옵니다.
            if (readLine == null) // 스트림의 끝에 도달한 경우 반복을 종료합니다.
                break;
            System.out.print(readLine + "\n"); // 읽어온 줄을 출력합니다.
        }
        
        br.close(); // 파일을 닫습니다.
        System.out.println("BufferedReader.readLine() <-- printWriterBufferedReader.txt");
    }

}
