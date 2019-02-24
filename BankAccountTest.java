package bankaccount;

public class BankAccountTest {

	public static void main(String[] args) throws InterruptedException {
		int initialBalance = 100000;
		//BankAccount ba = new BankAccountAI(initialBalance); // Atomic integer
		// BankAccount ba = new BankAccountNTS(initialBalance); // no thread safe
		
		//BankAccount ba = new BankAccountSemaphore(initialBalance);
		BankAccount ba = new BankAccountMonitor(initialBalance); 
		int numHolders = 20;
		int amount = 100;
		int numTransactions = 6;
		
		AccountHolder holders[] = new AccountHolder[numHolders];
		for (int i = 0; i < numHolders; i++) {
			holders[i] = new AccountHolder(ba, i, amount, numTransactions);
		}
		
		Thread threadHolders[] = new Thread[numHolders];
		for (int i = 0; i < numHolders; i++) {
			threadHolders[i] = new Thread(holders[i]);
			threadHolders[i].start();
		}
		
		for (int i = 0; i < numHolders; i++) {
			threadHolders[i].join();
		}
		
		if (ba.getBalance() == initialBalance) {
			System.out.format("Correct. The final balance is %s%n", ba.getBalance());
		} else {
			System.out.format("Error! The initial balance is %s, the final balance is %s%n", initialBalance, ba.getBalance());
		}

	} // main

} // end class
