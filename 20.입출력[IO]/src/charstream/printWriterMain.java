package charstream;

import java.io.FileWriter;
import java.io.PrintWriter;

public class printWriterMain {

    public static void main(String[] args) throws Exception {
        
        // PrintWriter를 사용하여 "printWriter.txt" 파일을 생성합니다.
        PrintWriter pw = new PrintWriter(new FileWriter("printWriter.txt"));
        
        // PrintWriter 객체를 생성하면서 FileWriter를 인자로 전달하여 파일에 쓰기 기능을 제공합니다.
        // "printWriter.txt" 파일은 현재 작업 디렉토리에 생성됩니다.
        
        pw.close(); // PrintWriter 객체를 닫아줍니다.
    }
}
