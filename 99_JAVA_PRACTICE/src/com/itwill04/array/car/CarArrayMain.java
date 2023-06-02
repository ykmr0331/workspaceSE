package com.itwill04.array.car;



public class CarArrayMain {

	public static void main(String[] args) {
		//Car[] carArray=new Car[30];
		
		Car[] carArray= {
				null,null,new Car("5654", 8),null,null,
				new Car("3422", 12),null,null,null,null,
				null,null,null,null,new Car("7789", 11),
				new Car("1120", 10),null,null,null,null,
				null,new Car("2389", 9),null,null,null,
				null,null,null,null,new Car("5555", 6)
		};
		/*
		null.메쏘드() --> NullPointerException
		 */
		
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ			
		System.out.println("1.전체 차량출력");
		Car.headerPrint();
		/*
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
			carArray[i].print();
			}
		}
		*/
		
	 	for ( Car car : carArray) {
			if(car != null) {
				car.print();
			}
		}
		
		
		System.out.println();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
		System.out.println("2.전체주차구획수");

		System.out.println("전체 주차구획수 >>" +carArray.length+"자리");
		System.out.println();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ			
		System.out.println("3.남은주차구획수");
		int restSpace = 0;
		/*
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				restSpace += 1;
			}
		}
		*/
		
		for ( Car car : carArray) {
			if(car != null) {
				restSpace += 1;
			}
		}
		
		System.out.println("남은 주차구획수 >>" +(carArray.length- restSpace)+"자리");
		System.out.println();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ			
		System.out.println("4.입차");
		/*
		 * 1.차량객체생성
		 * 2.빈자리찾아서대입
		 */
		Car car1 = new Car("3534",10);
		/*
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				carArray[i] = car1;

				break;
			}		
		}
		*/	
		
		for (Car car : carArray) {
			if(car == null) {
				car= car1;

				break;
			}
		}
		
		System.out.println();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ			
		System.out.println("5.차량번호 7789번  차한대 정보출력");
		Car.headerPrint();
		/*
		for (int i = 0; i < carArray.length; i++) {
			if((carArray[i] != null) &&((carArray[i].getNo()).equals("7789"))) {
				carArray[i].print();
				break;
			}
		}
		*/
		
	
		for (Car car : carArray) {
			if(car != null) {
				if(car.getNo().equals("7789")) {
					car.print();
					break;
				}
			}
			
		}
	 
		System.out.println();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ		
	
		System.out.println("6.입차시간 10시이후 차량여러대 찾아서 정보출력");
		
		Car.headerPrint();
		/*
		for (int i = 0; i < carArray.length; i++) {	
			if((carArray[i] != null) && (carArray[i].getInTime() > 10)) {
				carArray[i].print();
				
			}
		}
		*/
		
		
		for ( Car car : carArray) {
			if(car != null) {
				if(car.getInTime() >10) {
					car.print();
				}
			}
		}
		
		System.out.println();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ			
		System.out.println("7.2389번차량 12시 출차");
		
		Car.headerPrint();
		/*
		for (int i = 0; i < carArray.length; i++) {
			if((carArray[i] != null) &&(carArray[i].getNo()).equals("2389")) {
				carArray[i].setOutTime(12);
				carArray[i].calculateFee();
				carArray[i].print();
				carArray[i] =null;
				break;
			}
		}
		*/
		
		
		for ( Car car : carArray) {
			if((car!= null) &&(car.getNo()).equals("2389")) {
				car.setOutTime(12);
				car.calculateFee();
				car.print();
				car =null;
				break;
			}
		}
 		

		System.out.println();
		/*
		 * 2. 출차(출차시간12시대입,요금계산)
		 * 3. 영수증출력
		 * 4. 2389번차량 주차장에서 차량삭제(null을대입)
			  carArray[22]=null;
		 */
		
		
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ		
		System.out.println("99. 2389번차량 출차후전체 차량출력");
		
		Car.headerPrint();
		/*
		for (int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
			carArray[i].print();
			}
		}
		*/
		
		
		for ( Car car : carArray) {
			if(car != null) {
				car.print();
			}
		}
		

	}
}








