
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterReaderMain {
	public static void main(String[] args) throws Exception {

		FileWriter fw = new FileWriter("fileWriter.txt");
		fw.write(44356);
		fw.write('A');
		fw.write('김');
		for (int i = 0; i < 65536; i++) {
			//Java에서의 65536은 문자 데이터를 표현하기 위한 유니코드(Unicode)의 범위
			fw.write(i);
			
			if(i %100 ==0) {
				fw.write("\n");
			}
		}
		
		fw.write("\n");
		
		fw.write("문자열을 맘대로 막써요!!!");
		fw.write("\n");

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
        
        fw.flush();
        fw.close();
        
        System.out.println("FileWriter.write() --> fileWriter.txt");
        
        FileReader fr = new FileReader("fileWriter.txt");
        
        int charCount = 0;
        int readChar = fr.read();
        charCount++;
        System.out.println("1.readChar: " + (char)readChar);
        
        readChar = fr.read();
        charCount++;
        System.out.println("2.readChar: " + (char)readChar);
        
        readChar = fr.read();
        charCount++;
        System.out.println("3. readChar: " + (char)readChar);
        
        while(true) {
        	readChar = fr.read();
        	
        	if(readChar ==-1) {
        		break;
        	}
        	
        	charCount++;
        	
        	System.out.println((char)readChar);
        }
        
        System.out.println();
        System.out.println(charCount+ "문자 읽음");
        
        
        
        
        
        
        
        
        
        
        
        
        
	}
}
