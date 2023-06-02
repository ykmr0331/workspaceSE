
/**
 * 주차장에서 차객체를 생성할 클래스
 * @author KIM    //주석에 작성자 정보를 나타내는 태그입니다
 * @version 0.1    //주석에 클래스의 버전 정보를 나타내는 태그입니다
 * 
 */
public class Car {
	
	private String no;	//차량번호
	private int inTime;	//입차시간
	private int outTime;//출차시간
	private int fee;	//주차요금
	

	/*
	 * 입차시데이타대입메쏘드
	 */
	
	/**
	 * 입차시 데이터 대입메소드
	 * @param no  차량번호
	 * @param inTime  입차시간
	 */
	public void setIpChaData(String no,int inTime) {
		this.no=no;
		this.inTime=inTime;
	}
	/*
	 * 출차시출차시간대입메쏘드
	 */
	public void setOutTime(int outTime) {
		this.outTime=outTime;
	}
	/*
	 * 주차요금계산
	 */
	/**
	 * 주차요금계산
	 */
	public void calculateFee() {
		this.fee = (this.outTime-this.inTime)*1000;
	}
	/**
	 * 차량정보출력
	 */
	public void print() {
		System.out.printf("------------------------------------\n");
		System.out.printf("%s %s %s %s\n","차량번호","입차시간","출차시간","주차요금");
		System.out.printf("------------------------------------\n");
		System.out.printf("%7s %7d %7d %9d\n",
				this.no,
				this.inTime,
				this.outTime,
				this.fee);
	}
	//setter,getter
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	
	public int getInTime() {
		return inTime;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	/**
	 * 
	 * @return 주차요금
	 */
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	public int getOutTime() {
		return outTime;
	}
	
	
	
}






