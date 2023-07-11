package dao.address;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception {
		AddressDao addressDao=new AddressDao();
		System.out.println("1.insert:"+addressDao.insert(new Address(0, "테스트", "000-0000", "제주도")));
		Address findAddress=addressDao.findByPrimaryKey(1);
		findAddress.setName("change");
		findAddress.setPhone("xxx-uuuu");
		findAddress.setAddress("LA");
		System.out.println("2.update:"+addressDao.updateByPrimaryKey(findAddress));
		System.out.println("3.findByPrimaryKey:"+addressDao.findByPrimaryKey(34));
		System.out.println("4.findAll:"+addressDao.findAll());
	}

}