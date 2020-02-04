
public class BankCustomer {
	private int accountNumber;
	private String customerName;
	private String customerAddress;
	private int customerDateOfBirth;
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber( int bankAccountNumber)
	{
		accountNumber = bankAccountNumber;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName( String nameOfCustomer)
	{
		customerName = nameOfCustomer;
	}
	public String getCustomerAddress()
	{
		return customerAddress;
	}
	public void setCustomerAddress( String addressOfCustomer)
	{
		customerAddress = addressOfCustomer;
	}
	public int getCustomerDateOfBirth()
	{
		return customerDateOfBirth;
	}
	public void setCustomerDateOfBirth( int CustomerDoB)
	{
		customerDateOfBirth = CustomerDoB;
	}
	public static String findCustomer(int accountNumber, BankCustomer[] bankCustomers) {
		String customerName = "";
		for(int i=0; i<bankCustomers.length; i++) {
			if(accountNumber == bankCustomers[i].getAccountNumber()) {
				customerName = bankCustomers[i].getCustomerName();
			}
		}
		return customerName;
	}
	public static String findCustomer(int dateOfBirth, String address, BankCustomer[] bankCustomers) {
		String customerName = "";
		for(int i=0; i<bankCustomers.length; i++) {
			if(dateOfBirth == bankCustomers[i].getCustomerDateOfBirth() && address == bankCustomers[i].getCustomerAddress()) {
				customerName = bankCustomers[i].getCustomerName();
			}
		}
		return customerName;
	}
	public static void main(String[] args) {
		
		BankCustomer[] bankCustomers = new BankCustomer[10];
		for (int i = 0; i < bankCustomers.length; i++)
			bankCustomers[i] = new BankCustomer();
		bankCustomers[0].setCustomerName("Jimothy");
		bankCustomers[0].setAccountNumber(6785);
		bankCustomers[0].setCustomerAddress("123 Road");
		bankCustomers[0].setCustomerDateOfBirth(05-04-2000);
		System.out.println(findCustomer(6785, bankCustomers));
		System.out.println(findCustomer(05-04-2000, "123 Road", bankCustomers));
		System.out.println("Customer Account Number is " + bankCustomers[0].getAccountNumber());
		//System.out.println("Customer Account Number is " + bankCustomers[0].getAccountNumber());
		//System.out.println("Customer Account Number is " + bankCustomers[0].getAccountNumber());
	}
}
