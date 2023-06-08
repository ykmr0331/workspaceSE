package com.itwill04.array.student;

public class StudentArrayMain {

	public static void main(String[] args) {
		/*
		 * 0.학생배열객체초기화
		 */
		Student[] students = {  
								new Student(1, "KIM", 89, 93, 94), 
								new Student(2, "HIM", 88, 77, 98),
								new Student(3, "AIM", 65, 87, 99), 
								new Student(4, "BIM", 75, 97, 60), 
								new Student(5, "XIM", 85, 98, 90),
								new Student(6, "KIM", 95, 88, 77), 
								new Student(7, "ZIM", 99, 93, 95), 
								new Student(8, "LIM", 83, 80, 99),
								new Student(9, "QIM", 73, 90, 80) };
		/*
		 * 1. 전체학생들 개인별 총점,평균,평점계산
		 */
		System.out.println("1. 전체학생총점,평균,평점계산");
		;
		for (int i = 0; i < students.length; i++) {
			students[i].calculateTotal();
			students[i].calculateAvg();
			students[i].calculateGrade();

		}

		System.out.println();

		/*
		 * 2. 전체학생 총점으로 석차계산???????????????????
		 */

		System.out.println("2. 전체학생 총점으로 석차계산");
		System.out.println();
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].getTot() < students[j].getTot()) {
					//i번호배열요소의 총합이  j번호배열요소의 총합보다 작으면
					students[i].setRank(students[i].getRank() + 1);
					//i번호배열요소의 석차에 1을 더함( 석차변경메소드에 석차반환메소드를 넣고 1을 더함)
					// 석차반환메소드에 ++을 할 수는 없다. 변수가 아니기 때문
				}

			}
		}
		

		/*
		 * 3. 전체학생출력
		 */
		System.out.println("3. 전체학생출력 ");

		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		System.out.println();
		System.out.println();

		
		/*
		 * 4. 번호3번 학생한명 출력
		 */
		
		System.out.println("4.번호3번 학생한명 출력  ");
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			if (students[i].getNo() == 3) {
				students[i].print();
				break;  //한명만 출력해야되기 때문에 한명을 찾았으면 여기서 반복 멈춰야한다.
			}
		}
		System.out.println();

		/*
		 * 5. 학점A인 학생들 출력
		 */
		System.out.println("5. 학점A인 학생들 출력");
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			if (students[i].getGrade() == 'A') {
				students[i].print();

			}
		}
		System.out.println();

		/*
		 * 6. 학생총점으로 오름차순정렬
		 */
		System.out.println("6. 학생총점으로 오름차순정렬");
		
		System.out.println("\n\t~~정렬 전~~");
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		
		
		//여기는 오름차순으로 정렬하는 문법
		System.out.println();
		for (int i = 0; i < students.length - 1; i++) {       //0~9까지 있으면 0은 8번만 비교하면 되기때문 
			for (int j = 0; j < students.length - 1-i; j++) {// 어차피 i개수만큼 뒤에 정렬되어있음
				if (students[j].getTot() > students[j + 1].getTot()) {

					Student tempStudent = students[j + 1];  // 총점의 크기로 오름차순으로 바꾸면서 
					students[j + 1] = students[j];			//배열안의 객체의 다른 변수들도 똑같이 바뀐다	
					students[j] = tempStudent;
					  

				}
			}
		}

			System.out.println("\n\t~~정렬 후~~");
			Student.headerPrint();
			for (int i = 0; i < students.length; i++) {
				students[i].print();
			}
			
			
			
		/*
		 * 7. 학생학점순으로 오름차순정렬
		 */
		System.out.println("7. 학생학점순으로 오름차순정렬");
	
		
		/*
		 * 8. 학생이름순으로 오름차순정렬
		 */
		System.out.println("8. 학생이름순으로 오름차순정렬");
	
		
		System.out.println(">>>정렬전");
		Student.headerPrint();
		for (Student student : students) {
			student.print();
		}
		
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length-1; j++) { //-1을 해야 j가 10이되는 일이 없다.
/*           */	if(students[j].getName().compareTo(students[j+1].getName())> 0) { //이름 순서 비교하는거임
					Student tempStudent = students[j];
					students[j] = students[j+1];
					students[j+1] = tempStudent;
					tempStudent = students[j];
					
				} else if(students[j].getName().equals(students[j+1].getName())) {
					System.out.println("---");
				}
			}
		}
		
		
		System.out.println(">>>정렬후");
		Student.headerPrint();
		for (Student student : students) {
			student.print();
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

	}