package dao.guest;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
				
		GuestDao guestDao=new GuestDao();
		System.out.println("1.insert");
		//System.out.println(">>> row count:"+guestDao.insert(new Guest(0, "고소미",null ,"guard@gmail.com", "http://www.naver.com", "타이틀", "컨텐트")));
	
		
		
		System.out.println("2.deleteByGuestNo");
		System.out.println(">> row count:"+guestDao.deleteByGuestNo(1));
		
		
		
		System.out.println("3.updateByGuestNo");
		Guest findGuest = guestDao.findByGuestNo(11);
		findGuest.setGuestName("김변경");
		findGuest.setGuestEmail("change@change.com");
		findGuest.setGuestHomepage("http://www.gmail.com");
		findGuest.setGuestTitle("변경타이틀");
		findGuest.setGuestContent("변경컨텐트");
		System.out.println(">>> row count:"+guestDao.updateByGuestNo(findGuest));
		
		/*update guest set guest_name='name수정',
                 guest_email='email수정',
                 guest_homepage='homepage수정',
                 guest_title='title수정',
                 guest_content='content수정'
				
				where guest_no=1;*/
		
		System.out.println("4.findByGuestNo");
		System.out.println(">>> "+guestDao.findByGuestNo(3));
		
		
		
		System.out.println("5.findAll");
		System.out.println(">>>"+guestDao.findByAll());	
	}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
