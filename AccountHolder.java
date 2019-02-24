package bankaccount;
import java.util.Random;
public class AccountHolder implements Runnable  {

private final static int MIN_WAIT = 1;
private final static int MAX_WAIT = 3;


public Random random = new Random();
private int id;
private BankAccount ba;
private int balance;
private int numTransactions;

public AccountHolder(BankAccount ba, int id, int balance, int numTransactions) {
	this.id = id;
	if (numTransactions % 2 != 0) {
		throw new RuntimeException("Num. of transacations must be even");
	}
	this.ba = ba;
	this.balance = balance;
	this.numTransactions = numTransactions;
	
}

public void run () {
	try {
		for (int i = 0; i < numTransactions; i++) {
			randomWait();
			if (i % 2 == 0) {
				ba.deposit(balance);
			}
			else {
				ba.withdraw(balance);
			}
		}
		
	} catch (InterruptedException e) {
		
	}
	System.out.println("The account holder" + id + " has completed his transacations");
}

private void randomWait() throws InterruptedException {
	Thread.sleep((random.nextInt(MAX_WAIT - MIN_WAIT + 1) + MIN_WAIT));
}
}
