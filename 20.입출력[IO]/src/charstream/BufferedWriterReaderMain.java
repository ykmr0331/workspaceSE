package charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriterReaderMain {

	public static void main(String[] args) throws Exception {
		// BufferedWriter를 사용하여 파일을 작성합니다.
		BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedWriter.txt"));

		bw.write("첫번째줄\n"); // 첫 번째 줄을 파일에 작성합니다.
		bw.write("두번째줄"); // 두 번째 줄을 파일에 작성합니다.
		bw.newLine(); // 새로운 줄을 생성합니다.
		bw.write("세번째줄\n"); // 세 번째 줄을 파일에 작성합니다.
		bw.newLine(); // 새로운 줄을 생성합니다.
		bw.write("네번째줄\n"); // 네 번째 줄을 파일에 작성합니다.
		bw.newLine(); // 새로운 줄을 생성합니다.
		bw.write("다섯번째줄\n"); // 다섯 번째 줄을 파일에 작성합니다.
		bw.newLine(); // 새로운 줄을 생성합니다.

		bw.flush(); // 버퍼에 남아 있는 데이터를 출력 스트림에 모두 씁니다.
		bw.close(); // 파일을 닫습니다.
		System.out.println("bw.write() --> bufferedWriter.txt");

		// BufferedReader를 사용하여 파일을 읽습니다.
		BufferedReader br = new BufferedReader(new FileReader("bufferedWriter.txt"));
		
		

		String readLine = br.readLine();
		System.out.println("1.readLine: " + readLine); // 첫 번째 줄을 읽고 출력합니다.
		readLine = br.readLine();
		System.out.println("2.readLine: " + readLine); // 두 번째 줄을 읽고 출력합니다.

		// 파일의 끝까지 모든 줄을 읽고 출력합니다.
		while (true) {
			readLine = br.readLine();
			if (readLine == null)
				break;
			System.out.print(readLine);
		}

		br.close();
		System.out.println("BufferedReader.readLine() <-- bufferedWriter.txt");
	}
}
