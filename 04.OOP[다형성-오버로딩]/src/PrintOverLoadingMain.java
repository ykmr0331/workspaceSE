
public class PrintOverLoadingMain {

	public static void main(String[] args) {
		Print p = new Print();
		p.print(1);
		p.print("김");
		p.print('꿈');
		p.print(23.45);
		p.print(true);
		
		p.print(1);
		p.print(1,2);
		p.print(1,2,3);
	}

}
