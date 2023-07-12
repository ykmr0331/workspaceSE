package dao.member2;

public class MemberDaoTestMain {

	public static void main(String[] args) throws Exception {
		MemberDao memberDao=new MemberDao();
		
		Member insertTest = new Member("서울대6", "로스쿨", "아닙니다ㅋ", "낙성대학교", 24, 'M', null);
		Member updateTest = new Member("서울대7", "하이스쿨", "맞습니다", "신림동", 34, 'F', null);
		
		System.out.println("0.delete   --> " + memberDao.delete("서울대4"));
		System.out.println("1.insert   --> " + memberDao.insert(insertTest));
		System.out.println("2.update   --> " + memberDao.update(updateTest));
		System.out.println("3.selectById-> " + memberDao.selectById("bbbb"));
		System.out.println("4.selectAll--> " + memberDao.selectAll());
		
	}

}