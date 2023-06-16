import java.util.HashSet;

//Set은 중복 없고 순서 없다.
public class HashSetMain2 {
	public static void main(String args[]) {
		
		Car car1 = new Car("1111", 1);
		Car car2 = new Car("2222", 2);
		Car car3 = new Car("3333", 3);
		Car car4 = new Car("4444", 4);
		Car car5 = new Car("5555", 5);
		
		HashSet carSet = new HashSet();
		
		System.out.println("#set size: " + carSet.size());
		System.out.println(carSet);
		
		System.out.println("--------------------1.add-----------------------");
		carSet.add(car1);
		carSet.add(car2);
		carSet.add(car3);
		carSet.add(car4);
		carSet.add(car5);
		System.out.println("#set size: " + carSet.size());
		System.out.println(carSet);

		System.out.println("--------------------2.add[중복객체]-----------------------");
		boolean isAdd= carSet.add(car3);
		System.out.println("추가여부: " + isAdd);
		carSet.add(car3);
		System.out.println("#set size: " + carSet.size());
		System.out.println(carSet);
		
		System.out.println("--------------------전체출력----------------------");
		System.out.println("--------------------toArray()----------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}