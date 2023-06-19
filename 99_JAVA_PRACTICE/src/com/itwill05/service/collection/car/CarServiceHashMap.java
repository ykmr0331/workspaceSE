package com.itwill05.service.collection.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CarServiceHashMap {

	private HashMap<String, Car> carMap;
	private int count;// 주차장 구획수

	public CarServiceHashMap() {
		carMap = new HashMap<String, Car>();
		count = 30;
	}

	public CarServiceHashMap(int count) {
		carMap = new HashMap<String, Car>();
		this.count = count;
	}

	/*
	 * 0. 차객체인자로받아서 입차후 성공실패여부반환 - 주차장이 만차이면 입차실패
	 */
	public boolean ipCha(Car inCar) {
		boolean isSuccess = false;
		if(carMap.size() <30) {
			carMap.put(inCar.getNo(), inCar);
			isSuccess = true;
		}
		return isSuccess;
	}

	/*
	 * 1. 전체차량출력
	 */
	public void print() {
		 Iterator<Entry<String, Car>> carIterator= carMap.entrySet().iterator();
		 while(carIterator.hasNext()) {
			 Entry<String,Car> carEntry = carIterator.next();
			 Car realCar = carEntry.getValue();
			 realCar.print();
		 }
		
	}

	
	/*
	 * 5. 차량번호(4567번) 인자받아서 차객체한대 참조변수반환
	 */
	public Car findByNo(String no) {
		Car findCar = null;
		findCar = carMap.get(no);
		return findCar;
	}

	
	/*
	 * 6. 입차시간(8시이후)인자받아서 ArrayList(차객체배열) 참조변수반환
	 */
	public ArrayList<Car> findByInTime(int inTime) {
		ArrayList<Car> findCars = new ArrayList<Car>(); // 제네릭 타입 Car로해서  List객체 만든다.
		
		Iterator<String> carNoIterator = carMap.keySet().iterator();//carMap을 Set으로 변경하고 Iterator로 변경한다. 
																	//Iterator<String>은 키 집합의 요소를 반복하는 데 사용된다.
																	// String은 Car객체의 String타입인 차넘버와 타입 일치해서			
		while (carNoIterator.hasNext()) {//Iterator객체가 다음 요소가 있는지 확인한다.
			//다음 요소가 있으면
			String carNo = carNoIterator.next();//  Car 객체의 String타입 번호 알아내기위해서
			Car tempCar = carMap.get(carNo);
			if (tempCar.getInTime() >= inTime) {
				findCars.add(tempCar);// findCars는 Car타입의 새로운 Arraylist객체임
			}
		}

		return findCars;
	}

	/*
	 * 7. 차량번호(7891번),출차시간(12시)인자로 받아서 출차";
	 */
	public Car chulCha(String no, int outTime) {
		Car removeCar = null;
		 carMap.get(no).setOutTime(outTime);
		 removeCar = carMap.get(no);

		return removeCar;
	}

	/*
	 * 2. 주차전체구획수반환
	 */
	public int getParkingLotCount() {
		
		
		
		return this.count;
	}	
	/*
	 * 3. 주차가능주차구획수반환
	 */
	public int getAvailableParkingLotCount() {
		return count - carMap.size();
	}

}