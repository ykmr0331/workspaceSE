
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReaderWriterCopyMain {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("죄와벌.txt"));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("죄와벌[copy].txt"));
		
		
		int LineCount = 0;
		while(true) {
			String readLine = br.readLine();
			if(readLine ==null)
				break;
			
			LineCount++;
			
			readLine = readLine.replace("해럴드","김경고");
			
			bw.write(readLine);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
		System.out.println("------------ BufferedReaderWriterCopy \" + lineCount + \" line copy ..-------------");
		
		
	}

}
