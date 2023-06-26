public class AcademyStudent extends AcademyMember {
	
	public String ban;//반
	
	public AcademyStudent() {
		super();
	}
	public AcademyStudent(int no,String name,String ban) {
		super(no,name);
		/*
		<<The field AcademyMember.no is not visible>>
		this.no=no;
		this.name=name;
		*/
		this.ban=ban;
	}
	@Override
	public void print() {
		super.print();
		System.out.println(this.ban);
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	
}