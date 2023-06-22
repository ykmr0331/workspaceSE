public class ConCurrentBeepPrintThreadMain {

	public static void main(String[] args) {
		// 1. main thread start
		System.out.println("1. 메인 스레드 시작");

		// 2. main thread ConCurrentBeepThread,ConCurrentPrintThread 객체생성
		System.out.println("2. 메인 스레드 ConCurrentBeepThread,ConCurrentPrintThread 객체 생성");
		ConCurrentBeepThread beepThread = new ConCurrentBeepThread();
		ConCurrentPrintThread printThread = new ConCurrentPrintThread();

		// 3. main thread ConCurrentBeepThread.start(),ConCurrentPrintThread.start() 메쏘드호출
		System.out.println("3. 메인 스레드 ConCurrentBeepThread.start(),ConCurrentPrintThread.start() 메소드 호출");
		beepThread.start();
		printThread.start();

		// 9. main thread end jvm return
		System.out.println("9. 메인 스레드 종료, JVM 종료");
		return;
	}

}
