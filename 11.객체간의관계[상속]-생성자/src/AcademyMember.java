
public class AcademyMember extends Object{

	private int no;
	private String name;

	public AcademyMember() {
		super();
	}

	public AcademyMember(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public void print() {
		System.out.print(this.no+"\t"+this.name+"\t");
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}