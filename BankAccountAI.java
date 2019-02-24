package bankaccount;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAI extends BankAccount {

	private AtomicInteger balance;
	
	public BankAccountAI(int initialBalance) {
		super(initialBalance);
		balance = new AtomicInteger(initialBalance);
	}
	
	public void deposit(int amount) {
		balance.addAndGet(amount);
	}
	
	public void withdraw(int amount) {
		balance.addAndGet(-amount);
	}
	
	public int getBalance() { 
		return balance.get();
	
	}
	
}
