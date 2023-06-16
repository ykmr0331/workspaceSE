import java.util.ArrayList;
//List 중복되고 순서 있다.
public class ArrayListMain2 {
	
	public static void main(String args[]) {
		
	
	Account acc1 = new Account(1111, "BING", 33000, 0.3);
	Account acc2 = new Account(2222, "KING", 12000, 1.3);
	Account acc3 = new Account(3333, "YING", 89000, 5.6);
	Account acc4 = new Account(4444, "SING", 45000, 4.3);
	Account acc5 = new Account(5555, "PING", 99000, 2.9);
	
	ArrayList accountList = new ArrayList();
	
	int size = accountList.size();
	System.out.println("#size: " + size);
	
	System.out.println("----------------1. add[맨마지막 index에 객체 저장]------------------");
	accountList.add(acc1);
	System.out.println("#size: " + accountList.size());
	accountList.add(acc2);
	accountList.add(acc3);
	accountList.add(acc4);
	accountList.add(acc5);
	System.out.println("#size: " + accountList.size());
	System.out.println(accountList);
	
	System.out.println("----------------2. add(index,element)[지정된 index에 객체 저장]------------------");
	accountList.add(1, new Account(1112, "NEW", 30000, 3.3));
	
	System.out.println("#size: " + accountList.size());
	System.out.println(accountList);
	
	
	System.out.println("----------------3. set(index,element)[지정된 index에 객체 저장]------------------");
	accountList.set(accountList.size()-1, new Account(9999, "NINE", 90000, 9.9));
	System.out.println("#size: " + accountList.size());
	System.out.println(accountList);
	System.out.println();
	System.out.println();
	System.out.println();
	
	System.out.println("----------------4. get(index,element)[지정된 index에 객체의 참조변수 반환]------------------");
	Account getAccount = (Account)accountList.get(accountList.size()-1);
	System.out.println(getAccount);
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("----------------5. remove(index)[지정된 index에 객체 삭제]------------------");
	Account removeAccount = (Account)accountList.remove(accountList.size()-1);
	System.out.println(removeAccount);
	System.out.println("#size: " + accountList.size());
	System.out.println(accountList);

	
	System.out.println(
			"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%업무실행%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	
	System.out.println("********************1.계좌 전체출력*******************");
	Account.headerPrint();
	for (int i = 0; i < accountList.size(); i++) {
		Account tempAccount = (Account)accountList.get(i);
		tempAccount.print();
	}
	System.out.println("**************2.계좌번호3333번 한개찾기*****************");

	for (int i = 0; i < accountList.size(); i++) {
		Account tempAccount =(Account)accountList.get(i);
		if(tempAccount.getNo() == 3333) {
			tempAccount.print();
			break;
		}
	}
	System.out.println("**************3.계좌주이름 KING인계좌 여러개찾기********");
	
	for (int i = 0; i < accountList.size(); i++) {
		Account tempAccount = (Account)accountList.get(i);
		if(tempAccount.getOwner().equals("KING")) {
			tempAccount.print();
		}
	}
	System.out.println("**************4.계좌번호 4444번 계좌한개삭제************");
	for (int i = 0; i < accountList.size(); i++) {
		Account tempAccount = (Account)accountList.get(i);
		if(tempAccount.getNo()== 4444) {
			Account removeList=(Account)accountList.remove(i);
			removeList.print();
			break;
			
		}
	}
	System.out.println("**************5.계좌주이름 KING인계좌 여러개삭제[QUIZ]**");
	
	for (int i = 0; i < accountList.size(); i++) {
		Account tempAccount = (Account)accountList.get(i);
		if(tempAccount.getOwner().equals("KING")) {
			Account removeAcc = (Account)accountList.remove(i);
			removeAcc.print();
			i--;
		}  

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}