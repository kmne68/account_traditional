package business;

public class Main {

	public static void main(String[] args) {
		
		try {
			// declare as interface, implement as class
			AccountDao accountDao = new AccountDaoInMemoryImpl();
			
			AccountServiceImpl accountService = new AccountServiceImpl();
			
			// inject the data store into the account service
			accountService.setAccountDao(accountDao);
			
			accountService.depositMoney(1, 7.0);
			
			System.out.println("Before money transfer: ");
			System.out.println("Account 1 balance: " + accountService.getAccount(1).getBalance());

			System.out.println("Account 2 balance: " + accountService.getAccount(2).getBalance());
			
			accountService.transferMoney(1,  2, 5.0);

			System.out.println("After money transfer: ");
			System.out.println("Account 1 balance: " + accountService.getAccount(1).getBalance());

			System.out.println("Account 2 balance: " + accountService.getAccount(2).getBalance());
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
