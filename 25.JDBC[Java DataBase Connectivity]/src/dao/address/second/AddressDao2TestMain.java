package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args)throws Exception{
		AddressDao2 addressDao2=new AddressDao2();
		System.out.println("1.insert");
		addressDao2.insert("삼소라","232-6512","서울");
		
		System.out.println("2.updateByPrimaryKey");
		addressDao2.updateByPrimaryKey(10,"수정님","000-0000","수정구");
		addressDao2.updateByPrimaryKey(1,"변경님","111-1111","변경구");
		
		System.out.println("3.deleteByPrimaryKey");
		addressDao2.deleteByPrimaryKey(14);
		addressDao2.deleteByPrimaryKey(15);
		
		System.out.println("3.findByPrimaryKey");
		addressDao2.findByPrimaryKey(3);
		addressDao2.findByPrimaryKey(7);
		
		System.out.println("4.findAll");
		addressDao2.findAll();
		

	}

}