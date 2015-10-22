import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts; 
	private ArrayList<Client> clients;
	private static double interest;
	private static int numSavingAccounts;

	public Bank() {
		interest = 0.3;
		numSavingAccounts = 0;
		this.accounts = new ArrayList<BankAccount>();
		this.clients = new ArrayList<Client>();
	}

	public Client createClient(String name, String address) {
		Client c = new Client(name, address);
		this.clients.add(c);
		return c;
	}

	public BankAccount createAccount(Client client, double amount, AccountType accType) {
		if (client.isChecking == false && accType != AccountType.CHECKING) {
			return null;
		} else {
			if (accType == AccountType.SAVING) {
				numSavingAccounts++;
			}
			interest = 0.30 - 0.02 * (numSavingAccounts / 5);
			if (interest < 0) {
				interest = 0;
			}
			BankAccount b = new BankAccount(client, amount, accType);
			this.accounts.add(b);
			return b;
		}

	}

	public BankAccount createAccount(Client client, AccountType accType) {
		return createAccount(client, 0, accType);
	}

	public BankAccount createAccount(Client client, double amount) {
		return createAccount(client, amount, AccountType.CHECKING);
	}

	public BankAccount createAccount(Client client) {
		return createAccount(client, 0, AccountType.CHECKING);
	}

	public int deposit(BankAccount acc, double amount) {
		if (amount < 0) {
			return -1;
		}
		acc.addBalance(amount);
		return 1;
	}

	public int withdraw(BankAccount acc, double amount) {
		if (acc == null) {
			return -1;
		}
		if (acc.getBalance() >= amount && amount >= 0) {
			acc.withdraw(amount);
			return 1;
		}
		return -1;
	}

	public int transfer(BankAccount source, BankAccount destination, double amount) {
		if (source == null || destination == null) {
			return -1;
		}
		if ((source.getBalance() < amount || amount < 0)) {
			return -1;
		}
		source.withdraw(amount);
		destination.addBalance(amount);
		return 1;
	}

	public int transfer(BankAccount source, BankAccount[] destinations, double amount) {
		if (source == null || destinations == null) {
			return -1;
		}
		if (destinations.length < 1) {
			return -1;
		}
		if ((amount > source.getBalance() || amount < 0)) {
			return -1;
		}
		for (int i = 0; i < destinations.length; i++) {
			if (destinations[i] == null) {
				return -1;
			}
			source.withdraw(amount / destinations.length);
			destinations[i].addBalance(amount / destinations.length);
		}
		return 1;
	}

	public static double getInterest() {
		if (numSavingAccounts >= 150) {
			return 0;
		}
		return interest;
	}

	public int getClientSize() {
		return this.clients.size();
	}

	public int getAccountsSize() {
		return this.accounts.size();
	}

	public static void reset() {
		numSavingAccounts = 0;
		interest = 0.3;
	}

}