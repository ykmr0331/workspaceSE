public class AcademyGangsa extends AcademyMember{

	public String subject;//과목

//생성자	
	public AcademyGangsa() {

	}

	public AcademyGangsa(int no, String name, String subject) {
	
		this.no = no;
		this.name = name;
		this.subject = subject;
	}
	
//print메서드
		
	public void GangsaPrint() {
		this.print();
		System.out.println(this.subject);
	}
	
	
//getter setter


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}

