

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriterReaderMain {

	public static void main(String[] args) throws Exception {
	
		BufferedWriter bw =  new BufferedWriter(new FileWriter("bufferedWriter.txt"));
		bw.write("첫번째줄\n");
		bw.write("첫번째줄\n");
		bw.newLine();
		bw.write("세번째줄\n");
		bw.newLine();
		bw.write("네번째줄\n");
		bw.newLine();
		bw.write("다섯번째줄\n");
		bw.newLine();
		
		bw.flush();
		bw.close();
		System.out.println("bw.write() --> bufferedWriter.txt");
		
		BufferedReader br = new BufferedReader(new FileReader("BufferedWriter.txt"));
		
		String readLine = br.readLine();
		System.out.println("1.readLine: " + readLine);
		readLine = br.readLine();
		System.out.println("2.readLine: " + readLine);
		
		while(true) {
			readLine = br.readLine();
			if(readLine == null) 
				break;
			System.out.println(readLine);
			}
		
		br.close();
		System.out.println();
		
		
	}
}
