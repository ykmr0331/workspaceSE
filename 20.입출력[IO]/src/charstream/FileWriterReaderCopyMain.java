package charstream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterReaderCopyMain {
	public static void main(String[] args) throws Exception {
		// FileReader를 사용하여 "데미안.txt" 파일을 열고 읽기 위한 FileReader 객체를 생성합니다.
		FileReader fr = new FileReader("데미안.txt");

		// FileWriter를 사용하여 "데미안[복사].txt" 파일을 생성하고 쓰기 위한 FileWriter 객체를 생성합니다.
		FileWriter fw = new FileWriter("데미안[복사].txt");

		int lineCount = 0; // 줄 수를 카운트하기 위한 변수를 선언합니다.

		while (true) {
			int readChar = fr.read(); // 파일에서 한 문자씩 읽어옵니다.

			if (readChar == -1)
				break; // 파일의 끝에 도달하면 반복문을 종료합니다.

			// 읽어온 문자에 따라 처리합니다.
			if (readChar == '.') {
				fw.write(readChar); // 마침표는 그대로 복사합니다.
				fw.write("\n"); // 줄 바꿈 문자를 삽입합니다.
			} else if (readChar == '-') {
				fw.write(readChar); // 하이픈은 그대로 복사합니다.
				fw.write(" page"); // " page"를 추가로 씁니다.
			} else if (readChar == '\n') {
				lineCount++; // 줄 바꿈 문자가 나오면 줄 수를 증가시킵니다.
				fw.write(readChar); // 줄 바꿈 문자를 그대로 복사합니다.
			} else {
				fw.write(readChar); // 그 외의 문자는 그대로 복사합니다.
			}
		}

		fw.flush(); // 버퍼에 남아 있는 데이터를 출력 스트림에 모두 씁니다.
		fw.close(); // 파일을 닫습니다.
		fr.close(); // 파일을 닫습니다.

		System.out.println("-------FileWriterReaderCopy[" + lineCount + "]--------");
	}
}
