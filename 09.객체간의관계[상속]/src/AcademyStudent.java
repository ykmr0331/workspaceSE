public class AcademyStudent extends AcademyMember {
	public String ban; //학생 속한 반

	
	//생성자
	public AcademyStudent() {
		
	}
	
	public AcademyStudent(int no , String name, String ban) {		
		this.no = no; // 상속받은거
		this.name= name;// 상속받은거
		this.ban = ban;
	}
	
	//studentPrint 메서드
	public void studentPrint() {
		this.print();//부모의 print메소드 내용이 100줄이 된다고 생각해보면 이게 나음
		/*
		 * 	public void print() {
		System.out.print(this.no +" \t" + this.name + "\t");
	}
		 */
		System.out.println(this.ban);
	}
	
	
	
	
	@Override
	public String toString() {
		return "AcademyStudent [ban=" + ban + ", no=" + no + ", name=" + name + ", getBan()=" + getBan() + ", getNo()="
				+ getNo() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	//getter setter
	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}



	

	
}
