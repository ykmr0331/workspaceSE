package generic;

import java.util.HashSet;

public class HashSetStringWrapperMain {

	public static void main(String[] args) {
		System.out.println("-------------------String---------------------");
		HashSet<String> nameSet = new HashSet<String>();
		System.out.println(nameSet);
		System.out.println("-------------------1.add---------------------");
		System.out.println("# set size: " + nameSet.size());
		nameSet.add(new String("KIM"));
		nameSet.add("JIM");
		nameSet.add("GIM");
		nameSet.add("SIM");
		System.out.println("# set size: " + nameSet.size());
		System.out.println(nameSet);
		boolean isAdd = nameSet.add("KIM");
		System.out.println("추가여부: " + isAdd);//추가여부
		
		System.out.println("-------------------Wrapper(Integer)---------------------");
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		while(lottoSet.size() < 6) { 
			lottoSet.add((int)(Math.random()*45 + 1));//Set은 중복되지 않으니까 그냥 이대로 끝.
			System.out.println();		
		}
		System.out.println(lottoSet);

	}

}
