package com.itwill05.service.account;

//10, 11 다시하기

/*
 * 1.계좌객체들(Account[]) 을멤버변수로가진다.
 * 2.계좌객체들을 사용해서 업무실행
 */
public class AccountServiceReturn {

	public static final int SORT_BY_NO = 1;//
	public static final int SORT_BY_OWNER = 2;
	public static final int SORT_BY_BALANCE = 3;
	public static final int SORT_BY_IYUL = 4;

	public static final int SORT_ASC = 1;
	public static final int SORT_DESC = 2;

	private Account[] accounts = { new Account(1111, "KIM", 85000, 5.9), new Account(2222, "JIM", 77000, 4.2),
			new Account(3333, "FIM", 56000, 1.2), new Account(4444, "SIM", 77000, 0.2),
			new Account(5555, "GIM", 94000, 3.2), new Account(6666, "AIM", 56000, 6.2),
			new Account(7777, "XIM", 33000, 7.2), new Account(8888, "QIM", 77000, 5.2),
			new Account(9999, "AIM", 80000, 1.2) };

	/*
	 * 0.계좌객체를 인자로받아서 Account[]에추가[OPTION]
	 */
	public void addAccount(Account newAccount) {
		/*
		 * 1.배열크기증가 - 기존배열보다큰배열생성 - 기존데이타 옮김
		 */
		Account[] newAccounts = new Account[accounts.length + 1]; //  새로운 배열객체 생성 (배열크기 1 증가)
		for (int i = 0; i < accounts.length; i++) { // 기존의 배열크기 기준 for문
			newAccounts[i] = accounts[i]; //기존 배열에 있는 객체를 크기가 1큰 새로운 배열로 옮긴다.
		}
		newAccounts[accounts.length] = newAccount; //매개변수로 받은 객체를 새 배열객체의 마지막인덱스에 추가한다.
		this.accounts = newAccounts;  //새 배열객체를  AccountServiceReturn클래스의 멤버필드(Account배열타입)에 대입한다. 
	}

	/*
	 * 0.계좌데이타를 인자로받아서 Account[]에추가[OPTION]
	 */
	public void addAccount(int no, String owner, int balance, double iyul) { // 이번에는 객체가 아니라  인자를 받아서 
		Account newAccount = new Account(no, owner, balance, iyul);
		/*
		 * 1.배열크기증가 - 기존배열보다큰배열생성 - 기존데이타 옮김
		 */
		Account[] newAccounts = new Account[accounts.length + 1];//  새로운 배열객체 생성 (배열크기 1 증가)
		for (int i = 0; i < accounts.length; i++) {// 기존의 배열크기 기준 for문
			newAccounts[i] = accounts[i];//기존 배열에 있는 객체를 크기가 1큰 새로운 배열로 옮긴다.
		}
		newAccounts[accounts.length] = newAccount;//매개변수로 받은 객체를 새 배열객체의 마지막인덱스에 추가한다.
		this.accounts = newAccounts;//새 배열객체를  AccountServiceReturn클래스의 멤버필드(Account배열타입)에 대입한다. 

	}

	/*
	 * 1.은행계좌들 총계좌수 반환메써드
	 */
	public int getTotAccountNumber() {
	
	/*
	  	int i = 0;
		for (int j = 0; j < accounts.length; j++) {
			i++;
		}
		*/
		
		return accounts.length; // 그냥 accounts 배열객체의 길이를 바로 반환하면 됌
	}

	/*
	 * 2.은행계좌들 전체출력메쏘드 정의
	 */
	public void print() {
		Account.headerPrint();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
	}

	/*
	 * 3.은행계좌들 총잔고를 반환하는 메쏘드
	 */
	int totBalance = 0; // for문 돌리면서 잔고가 들어갈 변수(마지막에 총잔고가 될 변수)

	public int getAccountTotBalance() {
		for (int i = 0; i < accounts.length; i++) {
			totBalance += accounts[i].getBalance();
		}
		return totBalance;
	}

	/*
	 * 4.계좌번호를 인자로받아서 계좌객체주소 한개반환
	 */

	public Account findByNo(int no) {
		Account accountOne = null; // 일단 Account객체 생성하는데 일단 초기화는 안함 null임
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getNo() == no) { // for문 돌려서 accounts배열객체의 인자인 객체의 계좌번호가 매개변수로 들어온 계좌번호와 같은지 확인 
				accountOne = accounts[i];    //같으면 그 객체를  참조변수가 accountOne인 객체에 대입
				break;
			}
		}
		return accountOne;// Account타입인 accountOne을 리턴하면 된다.
	}

	/*
	 * 5.계좌잔고 인자로받아서 잔고이상인 계좌배열객체 참조변수반환
	 */
	public Account[] findByBalance(int balance) {
		/*
		 * A. 만족하는 객체의갯수구하기 - 예를들어 3개라면
		 */
		Account[] findAccount = null;// 조건충족 계좌배열

		int count = 0;// 배열의 크기가 될 변수를 먼저 초기화함
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getBalance() >= balance) {
				count++; //  accounts의 인자 객체의 잔고가 매개변수로 들어온 잔고 이상일 때 count값이 1씩 증가
			}
		}
		/*
		 * B. Account객체배열생성 - findAccounts=new Account[3];
		 */
		findAccount = new Account[count]; // for문으로 만든 count를 Account배열의 크기에 대입, 객체배열을 생성함

		/*
		 * C. 만족하는Account객체들 Account배열에담기
		 */
		for (int i = 0; i < findAccount.length; i++) {
			if (accounts[i].getBalance() >= balance) { // 기존의 배열 인자(객체)의 잔고가 매개변수의 잔고이상이면 
				findAccount[i] = accounts[i]; //  기존의 accounts 배열의 인자들을 새로운 배열객체에 대입

			}
		}
		return findAccount;
	}

	/*
	 * 6.계좌이율인자로받아서 인자이상인 계좌들배열객체 참조변수반환
	 */
	public Account[] findByIyul(double iyul) {
		int count = 0; // 배열의 크기
		Account[] findAccount = null;// 배열객체임
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getIyul() >= iyul) {
				count++;
			}
		}
		findAccount = new Account[count]; // 일단 배열객체 크기까지 만들었다.

		for (int i = 0; i < findAccount.length; i++) {
			if (accounts[i].getIyul() >= iyul) {
				findAccount[i] = accounts[i];

			}
		}

		return findAccount;
	}

	/*
	 * 7.계좌주이름 인자로받아서 이름과일치하는계좌들배열객체 참조변수반환
	 */
	public Account[] findByName(String name) {
		/*
		 * A. 만족하는 객체의갯수구하기 - 예를들어 3개라면
		 */
		/*
		 * B. Account객체배열생성 - findAccounts=new Account[3];
		 */
		/*
		 * C. 만족하는Account객체들 Account배열에담기
		 */

		int a = 0; // 이름과 일치하는 계좌들의 배열객체 크기를 정하기 위해 일단 기본값으로 초기화한 변수
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getOwner() == name) {
				a++;
			}
		}
		Account[] accountArray = new Account[a]; // for문으로 완성된 integer형 변수 a를 새로운 배열객체의 크기에 대입

		for (int i = 0; i < accountArray.length; i++) {
			if (accounts[i].getOwner() == name) {
				accountArray[i] = accounts[i];

			}
		}

		return accountArray;
	}

	/*
	 * 8.계좌번호,입금할돈 인자로 받아서 입금한후 입금계좌 참조변수반환
	 */
	public Account ipGum(int no, int m) {
		Account acc = null; // 입금한 후의 상태를 나타낼 계좌객체
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getNo() == no) { // 기존배열의 인자의 계좌번호가 매개변수의 계좌번호와 일치한다면 
				accounts[i].deposit(m);      // 매개변수의m값을 입금해라
				acc = accounts[i];				// 입금한 계좌객체를 새로만든 계좌객체에 대입
			}
		}

		return acc;

	}

	/*
	 * 9.계좌번호,출금할돈 인자로 받아서 출금
	 */
	public Account chulGum(int no, int m) {
		Account acc = null; // 출금한 후의 상태를 나타낼 계좌객체를 초기화
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getNo() == no) {
				accounts[i].withDraw(m);
				acc = accounts[i];
			}
		}

		return acc;
	}

	
	/*
	 * 10,11 정렬 standard --> 1:번호,2:이름,3:잔고,4:이율 order --> 1:오름차순,2:내림차순
	 */
	public void sort(int standard, int order) {
		if (standard == 1 && order ==1) {// 이 경우에 계좌를 번호순으로 오름차순
				for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
					for (int j = 0; j < accounts.length-i-1; j++) { // 
						if (accounts[i].getNo() < accounts[j].getNo()) {//i의번호가 j의 번호보다 작으면(오름차순이니까
							Account accountEx = accounts[j];
							accounts[j] = accounts[i];
							accounts[i] = accountEx;
						}
					}
				}
		} else if (standard == 1 && order ==2) {// 이 경우에 계좌를 번호순으로 내림
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getNo() > accounts[j].getNo()) {//i의번호가 j의 번호보다 크면(내림차순이니까
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}
		} else if (standard == 2 && order ==1) {// 이 경우에 계좌을 이름순으로 오름차순	
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getOwner().compareTo( accounts[j].getOwner())<0) {//i의이름이 j의 이름보다작으면(오름차순이니까
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}
		} else if (standard == 2 && order ==2) {// 이 경우에 계좌를 이름순으로 오름차순	
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getOwner().compareTo( accounts[j].getOwner())>0) {//i의이름이 j의 이름보다 크면(내림차순이라
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}
			
		} else if(standard == 3 && order ==1) {// 이 경우에 계좌를 잔고순으로 오름차순	
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getBalance() < accounts[j].getBalance()) {//i의잔고가 j의 잔고보다 작으면(오름차순이니까
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}

		} else if(standard == 3 && order ==2) {// 이 경우에 계좌를 잔고순으로 오름차순	
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getBalance() > accounts[j].getBalance()) {//i의잔고가 j의 잔고보다 크면(내림차순이니까
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}
		} else if(standard == 4 && order ==1) {// 이 경우에 계좌를 이율순으로 오름차순	
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getIyul() < accounts[j].getIyul()) {//i의이율이 j의 이율보다 작으면(오름차순이니까
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}
		} else if(standard == 4 && order ==2) {// 이 경우에 계좌를 이율순으로 	
			for (int i = 0; i < accounts.length-1; i++) { // for문 두번돌려서 버블정렬시도   
				for (int j = 0; j < accounts.length-i-1; j++) { // 
					if (accounts[i].getIyul() > accounts[j].getIyul()) {//i의이율이 j의 이율보다 크면(내림차순이니까
						Account accountEx = accounts[j];
						accounts[j] = accounts[i];
						accounts[i] = accountEx;
					}
				}
			}
		}
		
	}
	/*
	 * 12.계좌객체를 인자로 받아서 이름,잔고,이율 수정(update)[OPTION]
	 */
	public Account updateAccount(Account updateAccount) {// 

		Account account5 = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getNo() == updateAccount.getNo()) {
				accounts[i]= updateAccount;
				account5 = accounts[i];
				break;
			}
		}

		return account5;
	}

	/*
	 * 13.번호,이름,잔고,이율 인자로받아서 계좌객체수정(update)[OPTION]
	 */
	public Account updateAccount(int no, String owner, int balance, double iyul) {
		Account account5 = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getNo() == no) {
				accounts[i].setOwner(owner);
				accounts[i].setBalance(balance);
				accounts[i].setIyul(iyul);

				account5 = accounts[i];

			}
		}

		return account5;
	}

	/*
	 * 14.계좌번호 인자로받아서 삭제해줘[OPTION] A. 배열에서 Account객체삭제       B. 배열사이즈감소            C. 삭제한계좌객체반환
	 */
	public Account deleteByNo(int no) {
		Account accountEx1 = null;
		Account[] accountEx2 = {};
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == no) {// 일단 번호 일치하면 일치하는 객체 지우기
				accountEx1 = accounts[i];
				accounts[i] =null;
			}
		
		}
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
					accounts[i] = accounts[i+1]; // 배열빈곳 왼쪽에서 오른쪽으로 옮기기
			}	 
		}
		//그다음에 accounts가 6인 크기인데 일단 다른 새로운 배열(크기 하나 줄인)로 다 옮긴다음에 새로운 배열의 이름 다시 원래대로 바꿔
		for (int i = 0; i < accountEx2.length; i++) {
			 accountEx2[i]= accounts[i];
			 accounts = accountEx2;
		}
		return accountEx1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}