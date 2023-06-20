package file;

import java.io.File;

public class FileMain {
	
	public static void main(String[] args) throws Exception {
		System.out.println("escape character는  \\이다. --> \\축\"결혼\"");
		
		/*
		 * 현재파일경로[기준경로]
		 * eclipse --> C:\2023-05-JAVA-DEVELOPER\workspaceSE\20.입출력[IO]
		 * 
		 * - 상대경로(relative path)
		 *    현재 경로를 기준으로 경로를 기술
		 *    sample\a.txt
		 *    .\sample\a.txt
		 *    
		 * - 절대경로(absolute path)
		 *    C:, D: 드라이브를 기준으로 경로를 기술
		 *    ex> C:\2023-05-JAVA-DEVELOPER\workspaceSE\20.입출력[IO]\src\file\FileMain.java
		 */
		
		// 파일 생성
		/*
		 * File 클래스는 Java에서 파일 및 디렉토리를 나타내기 위해 사용되는 클래스입니다.
		 *  이 클래스는 파일 시스템의 파일 경로, 파일 이름, 디렉토리 경로 등을 다룰 수 있습니다.
		 */
		File file1 = new File("C:\\2023_05_java_developer\\workspaceSE\\20.입출력[IO]\\데미안.txt");
		File file2 = new File("죄와벌.txt");// 이 파일은 현재 작업 디렉토리에서 찾아집니다
		File file3 = new File("sample\\tree.jpg");
		File file4 = new File("sample\\subSample1\\dog.jpeg");
		File file5 = new File("sample\\subSample2\\dog2.jpeg");
		
	
		System.out.println("---------------1.file path[relative]----------------");
		// 파일의 상대경로 출력
		System.out.println(file1.getPath());
		System.out.println(file2.getPath());
		System.out.println(file3.getPath());
		System.out.println(file4.getPath());
		System.out.println(file5.getPath());
		System.out.println("---------------2.file path[absolute]----------------");
		// 파일의 절대경로 출력
		System.out.println(file1.getAbsolutePath());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file4.getAbsolutePath());
		System.out.println(file5.getAbsolutePath());
		System.out.println("---------------3.file name----------------");
		// 파일의 이름 출력
		System.out.println(file1.getName());
		System.out.println(file2.getName());
		System.out.println(file3.getName());
		System.out.println(file4.getName());
		System.out.println(file5.getName());

		
/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/		
		// 디렉토리 생성
		File dir0 = new File("C:\\2023_05_java_developer\\workspaceSE\\20.입출력[IO]");
		File dir1 = new File("sample");
		File dir2 = new File("sample/subSample1");
		File dir3 = new File("sample/subSample2");
		
		System.out.println("-------------------------isDirectory,isFile-------------------------");
		// 디렉토리인지 확인!!!!
		System.out.println(dir0.isDirectory());  // true
		System.out.println(dir1.isDirectory());  // true
		
		
		System.out.println(dir2.isDirectory());  //true
		System.out.println(dir3.isDirectory());  //true
		
		
		System.out.println(dir0.isFile());       // false 디렉토리지 파일 아냐
		System.out.println(dir1.isFile());       // false 디렉토리지 파일 아냐
		
		System.out.println(file1.isDirectory());  // false (file1 is a file, not a directory)
		System.out.println(file2.isDirectory());  // false (file2 is a file, not a directory)
		
		System.out.println("-------------------------디렉토리 안에 파일 (디렉토리) 목록-------------------------");
		// 디렉토리 안에 있는 파일(디렉토리) 목록 출력
		String[] fileNameList = dir1.list();//dir1 디렉토리 안에 있는 파일과 하위 디렉토리의 이름을 문자열 배열로 반환
			/** list() 메서드는 File 객체가 나타내는 디렉토리 내의 파일과 하위 디렉토리의 이름을 문자열 배열로 반환하는 메서드입니다.**/
		for(String fileName: fileNameList) {
			System.out.println("\t" + fileName);//각 파일 이름을 출력합니다.
		}
		
		System.out.println("-------------------------디렉토리 안에 파일 (디렉토리) 목록(File[])-------------------------");
		// 디렉토리 안에 있는 파일(디렉토리) 목록을 File 배열로 반환하여 출력
		File[] fileList = dir1.listFiles();
		for (File file : fileList) {
			
			if(file.isDirectory()) {// fileList File배열 안에 있는 file이 디렉토리(폴더)인지 확인
				System.out.println("D:" + file.getName());  // 디렉토리인 경우 "D:" 접두어를 붙여서 출력
				// Directory
				File[] subFileList = file.listFiles();
				// listFiles()는 지정된 디렉토리에 있는 파일과 디렉토리를 나타내는 File 객체의 배열을 반환합니다.
				for (File subFile : fileList) { //subFile"는 디렉토리를 나타내는 File 객체입니다.
												// "subFile"을 통해 하위 디렉토리 안을 반복적으로 탐색합니다
					System.out.println("\t" + subFile.getName());
													//해당 부분은 "subFile"이라는 변수를 사용하여 디렉토리의 이름을 가져와 출력하는 역할을 합니다.
				}
			
			} else {
				System.out.println("F:" + file.getName());  // If it's a file, add "F:" prefix and print the name
			}	
		}// End of for loop
		
		System.out.println("------------------디렉토리(폴더)생성------------------");
		File newDir1 = new File("newDir1"); 
		File newDir2 = new File("newDir2"); 
		File newDir3 = new File("sample", "subSample3");  
		File newDir4 = new File("sample/subSample4"); 
		/* newDir1.mkdir()은 newDir1 객체가 나타내는 디렉토리를 생성합니다.
		해당 디렉토리가 성공적으로 생성되면 true를 반환하고, 
		생성에 실패하거나 디렉토리가 이미 존재하는 경우 false를 반환합니다. */
		
		
		
		
		
		/* 			false인 경우
		 * 디렉토리의 상위 디렉토리가 존재하지 않습니다.
		디렉토리를 생성할 권한이 없습니다.
		디렉토리를 생성할 수 있는 충분한 여유 공간이 없습니다.*/
		
		
		
		
		System.out.println(">>newDir1 디렉토리생성여부: " + newDir1.mkdir()); /*false*/
		/**newDir1 디렉토리를 생성하려고 시도하지만 newDir1디렉토리를 이미 생성했으므로 안된다.. **/						
		
		System.out.println(">>newDir2 디렉토리생성여부: " + newDir2.mkdir()); // false
		/**newDir2 디렉토리를 생성하려고 시도하지만 newDir2디렉토리를 이미 생성했으므로 안된다...**/
		
		System.out.println(">>newDir3 디렉토리생성여부: " + newDir3.mkdir()); // true
		//File객체 newDir3가 만든 건 sample디렉토리 안에 subSample3디렉토리다.
		//한마디로 newDir3라는 디렉토리는 없었기 때문에 생성 가능하다.
				
		System.out.println(">>newDir4 디렉토리생성여부: " + newDir4.mkdir()); // false
		/**sample/subSample4 디렉토리를 생성하려고 시도합니다. 
		 * 그러나 sample 디렉토리 내에 subSample4 디렉토리를 생성하는데 실패하였으므로 false를 반환합니다.**/
		
		System.out.println("------------------디렉토리이름변경------------------");
		newDir2.renameTo(new File("renameDir2"));
		//newDir2 디렉토리의 이름을 "renameDir2"로 변경하는 작업을 수행하는 코드입니다.
		
		/**renameTo() 메서드는 File 객체를 사용하여 파일 또는 디렉토리의 이름을 변경하는 데 사용됩니다.
		 *  이 메서드는 호출된 File 객체의 이름을 지정된 새 이름으로 변경하려고 시도합니다.**/
		
		System.out.println("------------------디렉토리삭제------------------");
		newDir3.deleteOnExit(); //여기서 이거 지워지면서 subSample3이 지워진건가?
		/**deleteOnExit() 메서드는 Java 프로그램이 종료될 때 파일을 자동으로 삭제하기 위해 사용되는 메서드입니다.
		일반적으로 파일을 삭제하려면 delete() 메서드를 호출해야 하지만,
		 deleteOnExit() 메서드를 사용하면 프로그램이 종료될 때 자동으로 파일이 삭제됩니다**/
		
		System.out.println("------------------파일생성, 삭제, 이름변경------------------");
		
		// 파일임 디렉토리 아냐!!!!!!!!!!!!!!!!!!!!!!!!!
		
		File newFile1 = new File("newDir1", "newFile1.txt");
									/* File 클래스의 생성자를 사용하여 새로운 파일 객체를 생성하는 코드입니다.
									newDir1이라는 디렉토리 안에 newFile1.txt 파일을 생성하는 것입니다. */
		
		File newFile2 = new File("newDir1/newFile2.txt");//"newDir1/newFile2.txt" 경로에 해당하는 파일 객체를 생성하는 코드입니다.
		
		File newFile3 = new File("newDir1/newFile3.txt");//"newDir1/newFile2.txt"는 상대 경로를 나타냅니다
		
		File newFile4 = new File("C:\\2023_05_java_developer\\workspaceSE\\20.입출력[IO]\\sample\\subSample4\\newFile4.txt");
											//위에 경로에 해당하는 파일 객체를 생성하는 코드입니다.
	
		
		
		
		
		System.out.println("newFile1.txt 생성여부: " + newFile1.createNewFile());             //false
																	//newFile1.txt 파일 위에서 이미 생성했으니까
		System.out.println("newFile2.txt 생성여부: " + newFile2.createNewFile());				//true
																	
		System.out.println("newFile3.txt 생성여부: " + newFile3.createNewFile());             //false
									// 해당 파일들이 이미 존재하거나 생성에 실패했기 때문입니다.
		System.out.println("newFile4.txt 생성여부: " + newFile4.createNewFile());               //false
									// 해당 파일들이 이미 존재하거나 생성에 실패했기 때문입니다.					
		System.out.println("newFile1.txt 이름변경여부: " + newFile1.renameTo(new File("newDir1", "renameNewFile1.txt")));             //false
								// 이유는 newFile1.txt 파일이 현재 작업 디렉토리에 존재하지 않거나 newDir1 디렉토리가 없기 때문일 수 있습니다.
		System.out.println("newFile2.txt 삭제여부: " + newFile2.delete());           //true
		
		
		
		
	}
}

