package charstream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterCopyMain {

	public static void main(String[] args) throws Exception {
		// BufferedReader를 사용하여 "죄와벌.txt" 파일을 열고 읽기 위한 BufferedReader 객체를 생성합니다.
		BufferedReader br=new BufferedReader(new FileReader(new File("죄와벌.txt")));

		// BufferedWriter를 사용하여 "죄와벌[copy].txt" 파일을 생성하고 쓰기 위한 BufferedWriter 객체를 생성합니다.
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\2023_05_java_developer","죄와벌[copy].txt")));
		/**        이렇게하면 "C:\\2023_05_java_developer" 여기에 죄와벌[copy].txt 이게 만들어진다!!!!!**/

		int lineCount = 0; // 줄 수를 카운트하기 위한 변수를 선언합니다.

		while (true) {
			String readLine = br.readLine(); // 파일에서 한 줄씩 읽어옵니다.

			if (readLine == null)
				break; // 파일의 끝에 도달하면 반복문을 종료합니다.

			lineCount++; // 줄 수를 증가시킵니다.

			readLine = readLine.replace("해럴드", "김경호"); // 문자열에서 "해럴드"를 "김경호"로 대체합니다.

			bw.write(readLine); // 대체된 내용을 BufferedWriter를 사용하여 파일에 씁니다.
			bw.newLine(); // 줄 바꿈 문자를 삽입합니다.
		}

		bw.flush(); // 버퍼에 남아 있는 데이터를 출력 스트림에 모두 씁니다.
		bw.close(); // 파일을 닫습니다.
		br.close(); // 파일을 닫습니다.

		System.out.println("------------ BufferedReaderWriterCopy " + lineCount + " line copy ..-------------");
	}

}
