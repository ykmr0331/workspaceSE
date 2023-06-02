
public class AccountConstructorMain {

	public static void main(String[] args) {
		Account account1 = new Account();
		account1.setAccountData(1111, "KIM", 7800, 2.3);
		account1.deposit(8000);
		account1.headerPrint();
		account1.print();
		
		Account account2 = new Account(2222, "LEE", 5600, 3.3);
		account2.withDraw(678);
		account2.headerPrint();
		account2.print();
	
		/*
		 * 객체를 재사용
		 */
		
		/*
		account2.setAccountData(3333, "SAM", 3000, 3.3);
		account2.deposit(333);
		account2.headerPrint();
		account2.print();
		*/
	}

}
