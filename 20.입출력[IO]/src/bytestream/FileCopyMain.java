package bytestream;
//다시  ddfdfdf
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyMain {
//FileCopyMain 클래스는 ChromeSetup.exe 파일의 내용을 ChromeSetup_copy.exe라는 새 파일로 복사하는 Java 프로그램입니다.
	public static void main(String[] args) throws Exception{
		long startTime = System.currentTimeMillis(); // 현재시간 startTime변수에 저장
		
		FileInputStream fis=new FileInputStream("ChromeSetup.exe");
		FileOutputStream fos=new FileOutputStream("ChromeSetup_copy.exe");
		//원본 파일과 새 파일에 대해 각각 fis와 fos라는 두 개의 파일 입력/출력 스트림을 생성합니다
		int byteCount=0;
		int starCount=0;
		while(true) {
			int readByte=fis.read();//원본 파일 fis에서 바이트 단위로 읽은 다음// 새 파일 fos에 씁니다 fos.write(readByte);
			if(readByte==-1)break;//읽은 바이트가 -1이면 루프가 종료됩니다.
			byteCount++;
			if(byteCount%1024==0) {//읽은 바이트 수가 1024의 배수이면 콘솔에 *를 출력합니다.
				System.out.print("*");
				starCount++;
				if(starCount%50==0) {// 출력된 * 수가 50의 배수이면 콘솔에 줄 바꿈 문자를 출력합니다.
					System.out.println();
				}
			}
			fos.write(readByte);
		} 
		fis.close();
		fos.close();//두 개의 파일 입력/출력 스트림을 닫습니다
		System.out.println();
		System.out.println("FileCopy:"+byteCount+" bytes copy!!");//파일 복사가 성공했음을 나타내는 메시지를 콘솔에 출력합니다  
		long endTime = System.currentTimeMillis(); // 현재시간 startTime변수에 저장
		long duration = endTime - startTime;// 걸린시간 알아보려고 하는거
		System.out.println(duration+ "ms...");
		System.out.println(duration+ "ms...");

	}

}