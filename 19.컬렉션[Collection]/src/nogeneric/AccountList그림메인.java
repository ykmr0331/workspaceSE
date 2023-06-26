package nogeneric;

import java.util.ArrayList;

public class AccountList그림메인 {
	public static void main(String[] args) {
		Account acc1=new Account(1111,"BING",33000,0.3);
		Account acc2=new Account(2222,"KING",12000,1.2);
		Account acc3=new Account(3333,"KING",89000,5.6);
		Account acc4=new Account(4444,"HING",45000,4.8);
		Account acc5=new Account(5555,"PING",99000,2.9);
		
		ArrayList accountList=new ArrayList();
		accountList.add(acc1);
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
	}
}