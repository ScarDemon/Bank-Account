package bankaccount;

public class BankAccountNTS extends BankAccount {

	public BankAccountNTS(int initialBalance) {
		super(initialBalance);
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withdraw(int amount) {
		this.balance -= amount;
	}
	
}
