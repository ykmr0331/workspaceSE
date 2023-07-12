package dao.member;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao=new MemberDao();
		System.out.println("0.delete   --> ");
		System.out.println(">> row count:"+ memberDao.delete(new Member("cccc","1q2w3e","김덕배","미국마이애미",30,"F",null))); 
		
		System.out.println("1.insert   --> ");
		System.out.println(">>> row count: " + memberDao.insert(new Member("cccc","1q2w3e","김정배","미국보스턴",35,"F",null)));  

		System.out.println("2.update   --> ");
		System.out.println(">>> row count: " + memberDao.update(new Member("aaaa","1e3r3","김역배","미국하와이",40,"T",null)));		
		
		
		
		System.out.println("3.selectById-> ");
		System.out.println(">>> row count: " + memberDao.findByPrimaryKey("bbbb"));
		
		System.out.println("4.selectAll--> ");
		System.out.println(">>>" + memberDao.findAll());
		
		
	}

}