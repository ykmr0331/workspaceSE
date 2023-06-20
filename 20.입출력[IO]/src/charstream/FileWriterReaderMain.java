package charstream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterReaderMain {
    public static void main(String[] args) throws Exception {
        // FileWriter 객체를 사용하여 "fileWriter.txt" 파일을 생성하고 열기
    	/*
    	 * FileWriter는 Java에서 파일에 문자 데이터를 쓰기 위한 클래스입니다.
			FileWriter는 Writer 클래스의 하위 클래스이며, 문자 단위로 데이터를 파일에 쓰는 기능을 제공합니다
    	 */
        FileWriter fw = new FileWriter("fileWriter.txt");
        
        // 파일에 다양한 데이터를 씁니다.
        
        // 정수 값 44356을 파일에 씁니다.  //Writer는 출력
        fw.write(44356);
        
        // 문자 'A'를 파일에 씁니다.
        fw.write('A');
        
        // 한글 문자 '김'을 파일에 씁니다.
        fw.write('김');
        
        // 0부터 65535까지의 정수 값을 파일에 씁니다.
        for (int i = 0; i < 65536; i++) {
            fw.write(i);
            
            // 100번마다 줄바꿈 문자를 파일에 씁니다.
            if (i % 100 == 0) {
                fw.write('\n');
            }
        }
        
        // 줄바꿈 문자를 파일에 씁니다.
        fw.write("\n");
        
        // 문자열을 파일에 씁니다.
        fw.write("문자열을 맘대로 막써요 !!!!");
        fw.write("\n");
        
        // 여러 줄로 구성된 문자열을 파일에 씁니다.
        fw.write("한라인\n");
        fw.write("두라인\n");
        fw.write("세라인\n");
        fw.write("네라인\n");
        fw.write("다섯라인\n");
        fw.write("여섯라인\n");
        fw.write("일곱라인\n");
        fw.write("여덟라인\n");
        fw.write("아홉라인\n");
        fw.write("열라인\n");
        fw.write("열한라인\n");
        fw.write("열두라인\n");
        
        /*
         * 채워지지 않은 버퍼에 있는 데이터를 출력 스트림에 씁니다.
         */
        fw.flush();
        
        // 파일을 닫습니다.
        fw.close();
        
        System.out.println("FileWriter.write() --> fileWriter.txt");
        
        // FileReader 객체를 사용하여 "fileWriter.txt" 파일을 엽니다.
        FileReader fr = new FileReader("fileWriter.txt");
        
        int charCount = 0;
        int readChar = fr.read();
        charCount++;
        System.out.println("1. readChar: " + (char)readChar);
        
        readChar = fr.read();
        charCount++;
        System.out.println("2. readChar: " + (char)readChar);
        
        readChar = fr.read();
        charCount++;
        System.out.println("3. readChar: " + (char)readChar);
        
        while (true) {
            readChar = fr.read();
            
            // 파일 끝에 도달하면 반복문을 종료합니다.
            if (readChar == -1) {
                break;
            }
            
            charCount++;
            
            // 읽은 문자를 출력합니다.
            System.out.print((char)readChar);
        }
        
        System.out.println();
        System.out.println(charCount + " 문자 읽음");
    }
}
