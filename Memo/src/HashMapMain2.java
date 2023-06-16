import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain2 {
//Map은 키와 값이 있고 키는 중복 안된다.
	public static void main(String[] args) {

		HashMap carMap = new HashMap();
		System.out.println("#Map size: " + carMap.size());
		System.out.println(carMap);
		
		System.out.println("******************************************* 1.put *******************************************");
		Car c1 = new Car("1111", 12);
		carMap.put("1111",c1);
		carMap.put("2222",new Car("2222",13));
		carMap.put("3333",new Car("3333",15));
		carMap.put("4444",new Car("4444",16));
		carMap.put("5555",new Car("5555",17));
		System.out.println("#map size: " + carMap.size());
		System.out.println(carMap);
		carMap.put("3333",new Car("삼삼삼삼", 20));
		System.out.println("#map size: " + carMap.size());
		System.out.println(carMap);
		
		
		System.out.println("******************************************* 2.get(key)*******************************************");

		Object getObjectCar = carMap.get("3333");
		System.out.println(getObjectCar);
		Car getCar = (Car)getObjectCar; //Object에서 Car로 변경
		getCar.print(); // 배열에서 뽑아낸 객체를 Object로 했다가 다시 Car로 변경
		System.out.println(carMap);
		System.out.println("#map size:" + carMap.size());
		
		System.out.println("******************************************* 2.remove(key)*******************************************");
		Object removeObjectCar = carMap.remove("3333");
		Car removeCar = (Car)removeObjectCar;
		removeCar.print();
		System.out.println("#map size:" + carMap.size());
		System.out.println(carMap);
		
		
		
		System.out.println("******************************************* 전체차량출력*******************************************");
		
		Set carEntrySet = carMap.entrySet();
		
		Object[] carObjectArray = carEntrySet.toArray();
		
		//toArray()메소드는 목록의 요소를 배열로 변환
		//toArray()는 Set인터페이스의 메소드임
		// Set 인터페이스의 toArray() 메서드의 반환값은 Object이기 때문에 이렇게 함
		
		
		
		//Entry인터페이스는 안에 있는 getKey()메서드를 사용하기 위해 사용
		//getKey() 메서드와 getValue()는 Map 인터페이스의 키를 반환합니다.
		for (int i = 0; i < carObjectArray.length; i++) {
			Entry carEntry =(Entry)carObjectArray[i];
			String key = (String)carEntry.getKey();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
