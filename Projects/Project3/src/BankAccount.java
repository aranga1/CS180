public class BankAccount {
	private Client client;
	private double balance;
	private AccountType accType;

	public BankAccount(Client client, double amount, AccountType accType) {
		this.client = client;
		this.accType = accType;
		this.balance = amount;
		if (accType == AccountType.CHECKING) {
			this.client.isChecking = true;
		}
	}

	public BankAccount(Client client, AccountType accType) {
		this(client, 0, accType);
	}

	public BankAccount(Client client, double amount) {
		this(client, amount, AccountType.CHECKING);
	}

	public BankAccount(Client client) {
		this(client, 0, AccountType.CHECKING);
	}

	public void addBalance(double amount) {
		this.balance += amount;
	}

	public double getBalance() {
		return this.balance;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public AccountType getAccountType() {
		return this.accType;
	}
}
