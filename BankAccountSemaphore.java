package bankaccount;
import java.util.concurrent.Semaphore;
public class BankAccountSemaphore extends BankAccount {
	private Semaphore mutex;
	
	public BankAccountSemaphore(int initialBalance) {
		super(initialBalance);
		mutex = new Semaphore(1);
	}
	
	public void deposit(int amount) {
	try { 
		mutex.acquire();
	} catch (InterruptedException e) {e.printStackTrace();}
	this.balance += amount;
	mutex.release();
	}
	
	
	public void withdraw(int amount) {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {e.printStackTrace();}
		this.balance -= amount;
		mutex.release();
	}
	
}