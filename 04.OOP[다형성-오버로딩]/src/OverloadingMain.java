
public class OverloadingMain {

	public static void main(String[] args) {
		Overloading overloading = new Overloading();
		overloading.method();
		overloading.method(123);
		overloading.method("김수한무~~");
		overloading.method(100,200);
		overloading.method(100,"이백");
		overloading.method(1, 2, 3);
		overloading.method("일", 2, 3);
	}

}
