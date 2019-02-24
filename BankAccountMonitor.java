package bankaccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class BankAccountMonitor extends BankAccount{

	private Lock l = new ReentrantLock();
	
	public BankAccountMonitor(int initialBalance) {
		super(initialBalance);
	}
	
	public void deposit(int amount) {
		l.lock();
		try {
			this.balance +=amount;
			
		} catch (Exception e) {}
		finally {
			l.unlock();
		}
	} // deposit
	
	public void withdraw(int amount) {
		l.lock();
		try {
			this.balance -= amount;
		} catch (Exception e) {}
		finally {
			l.unlock();
		}
	} // withdraw
}
