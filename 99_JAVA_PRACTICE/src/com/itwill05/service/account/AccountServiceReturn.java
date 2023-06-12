package com.itwill05.service.account;

/*
 * 1.계좌객체들(Account[]) 을멤버변수로가진다.
 * 2.계좌객체들을 사용해서 업무실행
 */
public class AccountServiceReturn {

	public static final int SORT_BY_NO=1;
	public static final int SORT_BY_OWNER=2;
	public static final int SORT_BY_BALANCE=3;
	public static final int SORT_BY_IYUL=4;
	
	public static final int SORT_ASC=1;
	public static final int SORT_DESC=2;

	private Account[] accounts = { 
			new Account(1111, "KIM", 85000, 5.9), 
			new Account(2222, "JIM", 77000, 4.2),
			new Account(3333, "FIM", 56000, 1.2), 
			new Account(4444, "SIM", 77000, 0.2),
			new Account(5555, "GIM", 94000, 3.2), 
			new Account(6666, "AIM", 56000, 6.2),
			new Account(7777, "XIM", 33000, 7.2), 
			new Account(8888, "QIM", 77000, 5.2),
			new Account(9999, "AIM", 80000, 1.2) };
	/*
	 * 0.계좌객체를 인자로받아서 Account[]에추가[OPTION]
	 */
	public void addAccount(Account newAccount) {
		/*
		 * 1.배열크기증가 
		 * 	- 기존배열보다큰배열생성 
		 * 	- 기존데이타 옮김
		 */
		Account[] newAccounts = new Account[accounts.length + 1];
		for (int i = 0; i < accounts.length; i++) {
			newAccounts[i] = accounts[i];
		}
		newAccounts[accounts.length] = newAccount;
		this.accounts = newAccounts;
	}

	/*
	 * 0.계좌데이타를 인자로받아서 Account[]에추가[OPTION]
	 */
	public void addAccount(int no, String owner, int balance, double iyul) {
		Account newAccount = new Account(no, owner, balance, iyul);
		/*
		 * 1.배열크기증가 
		 * 	- 기존배열보다큰배열생성 
		 * 	- 기존데이타 옮김
		 */
		Account[] newAccounts = new Account[accounts.length + 1];
		for (int i = 0; i < accounts.length; i++) {
			newAccounts[i] = accounts[i];
		}
		newAccounts[accounts.length] = newAccount;
		this.accounts = newAccounts;
		
		for (int i = 0; i < newAccounts.length; i++) {
			
		}
	}
	
	
	
	/*
	 * 1.은행계좌들 총계좌수 반환메써드
	 */
	public int getTotAccountNumber() {
		int i = 0;
		for (int j = 0; j < accounts.length; j++) {
			i++;
		}
		return i;
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
	int ae = 0;
	public int getAccountTotBalance() {
		for (int i = 0; i < accounts.length; i++) {
			ae +=accounts[i].getBalance();
		}
		return ae;
	}
	
	/*
	 * 4.계좌번호를 인자로받아서 계좌객체주소 한개반환
	 */
	Account ff = null;
	public Account findByNo(int no) {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo()== no) {
				ff= accounts[i];
			}
		}
		return ff;
	}

	
	
	/*
	 * 5.계좌잔고 인자로받아서 잔고이상인 계좌배열객체 참조변수반환
	 */
	
	/*
	 * A. 만족하는 객체의갯수구하기 - 예를들어 3개라면
	 */
	/*
	 * B. Account객체배열생성 
	 * 	- findAccounts=new Account[3];
	 */
	/*
	 * C. 만족하는Account객체들 Account배열에담기
	 */
	
/*AccountServiceReturn객체야 계좌잔고를 인자로줄께 잔고이상인 계좌객체배열 참조변수반환해줘"*/
	public Account[] findByBalance(int balance) {
		int f = 0;
		Account[] findAccount = null;//조건충족 계좌배열
	
		int count = 0;
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getBalance()>= balance) {
				count++;
			}
			
		}
		findAccount = new Account[count];
		
		for (int i = 0; i < findAccount.length; i++) {
			if(accounts[i].getBalance()>= balance) { //만족하는Account객체들 Account배열에담기
				findAccount[i] = accounts[i];
				findAccount[i] = accounts[i];

			}
		}
		return findAccount;
	}

	
	
	/*
	 * 6.계좌이율인자로받아서 인자이상인 계좌들배열객체 참조변수반환
	 */
	public Account[] findByIyul(double iyul) {
		int x = 0;						//배열의 크기
		Account[] findAccount = null;//배열객체임
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getIyul()>= iyul) {
				x++;
			}
		}
		findAccount = new Account[x]; // 일단 배열객체 크기까지 만들었다.

		for (int i = 0; i < findAccount.length; i++) {
			if(accounts[i].getIyul()>= iyul) {
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
		 * B. Account객체배열생성 
		 * 	- findAccounts=new Account[3];
		 */
		/*
		 * C. 만족하는Account객체들 Account배열에담기
		 */
		
		int a = 0;
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getOwner() == name) {
				a++;
			}
		}
		Account[] accountArray = new Account[a];
		
		for (int i = 0; i < accountArray.length; i++) {
			if(accounts[i].getOwner() == name) {
				accountArray[i] = accounts[i];
				
			}
		}
		
		
		return accountArray;
	}

	
	
	
	/*
	 * 8.계좌번호,입금할돈 인자로 받아서 입금한후 입금계좌 참조변수반환
	 */
	public Account ipGum(int no, int m) {
		Account acc = null;
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == no) {
				accounts[i].deposit(m);
				acc =accounts[i];
			}
		}
		
		return acc ;

	}

	
	
	
	/*
	 * 9.계좌번호,출금할돈 인자로 받아서 출금
	 */
	public Account chulGum(int no, int m) {
		Account acc = null;
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == no) {
				accounts[i].withDraw(m);
				acc =accounts[i];
			}
		}
		
		return acc ;
	}

	
	
	/*
	 * 10,11 정렬  standard --> 1:번호,2:이름,3:잔고,4:이율 
	 *             order    --> 1:오름차순,2:내림차순
	 */
	public Account[] sort(int standard, int order) {
		if(standard ==3) {
			if(order ==1) { //번호 오름차순 정렬
				for (int i = 0; i < accounts.length; i++) {
					for (int j = 0; j < accounts.length; j++) {
						if(accounts[i].getBalance() < accounts[j].getBalance()) {
							Account accountEx = accounts[j];
							accounts[j] = accounts[i];
							accounts[i]  = accountEx;
						}
					}
				}
			} else if(order ==2) {// 번호 내림차순
				for (int i = 0; i < accounts.length; i++) {
					for (int j = 0; j < accounts.length; j++) {
						if(accounts[i].getBalance() > accounts[j].getBalance()) {
							Account accountEx = accounts[j];
							accounts[j] = accounts[i];
							accounts[i]  = accountEx;
						}
					}
				}
			}
		}

		return accounts;
	}
		
	
	
	/*
	 * 12.계좌객체를 인자로 받아서 이름,잔고,이율 수정(update)[OPTION]
	 */
	public Account updateAccount(Account updateAccount) {
 
		Account account5= null;
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == updateAccount.getNo()) {
				accounts[i].setOwner(updateAccount.getOwner());
				accounts[i].setBalance(updateAccount.getBalance());
				accounts[i].setIyul(updateAccount.getIyul());
				
				account5 = accounts[i];
				
			}
		}

		return account5;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 * 13.번호,이름,잔고,이율 인자로받아서 계좌객체수정(update)[OPTION]
	 */
	public void updateAccount(int no, String owner, int balance, double iyul) {
		
	}
	
	
	/*
	 * 14.계좌번호 인자로받아서 삭제해줘[OPTION] 
	 * 	A. 배열에서 Account객체삭제 
	 * 	B. 배열사이즈감소
	 *  C. 삭제한계좌객체반환
	 *  
	 */
	public Account deleteByNo(int no) {
		
		return null;
	}
	
}