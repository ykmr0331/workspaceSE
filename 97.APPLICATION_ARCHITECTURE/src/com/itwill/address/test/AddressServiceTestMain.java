package com.itwill.address.test;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

public class AddressServiceTestMain {

	public static void main(String[] args) throws Exception{
		AddressService addressService = new AddressService();//AddressService객체 생성
		
		
		System.out.println("1.주소록쓰기");
		Address newAddress = new Address(0, "내친구","123-4567", "제주도");
		int rowCount = addressService.addressWrite(newAddress);
		System.out.println(">>> insert row: " + rowCount);
		addressService.addressWrite(newAddress);
		
		
		System.out.println("2.주소록번호로검색");
		Address findAddress = addressService.addressDetail(1);
		System.out.println(">>> " +findAddress);
		
		
		System.out.println("3.주소록수정");
		Address updateAddress = addressService.addressDetail(1); 
			// 주소록번호 1개 가져와서 Address 객체에 대입
		updateAddress.setName("일번수정");
		updateAddress.setPhone("333-3333");
		updateAddress.setAddress("청송군");
		rowCount = addressService.AddressUpdate(updateAddress);
				//AddressUpdate()는 int타입 반환하기 때문
		System.out.println(" >>> update row: " + rowCount);
		
		
		System.out.println("4.주소록삭제");
		System.out.println(">>> delete row" +addressService.addressDelete(23));
	
		
		System.out.println("5.주소록리스트");
		System.out.println(addressService.addressList());
		//Thread.sleep(100000000);
		
		
		

	}

}
