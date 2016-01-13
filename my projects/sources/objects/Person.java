package objects;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	public static int MAX_ALLOWED_BOOKS = 3;
	private boolean male;
	Balance balance; 
	//constructor
	public Person(String firstName, String lastName){
		this.firstName = firstName;
		middleName = "";//default
		this.lastName = lastName;
		//field vs local
		balance = new Balance();
	}
	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	public Person(String firstName, String middleName, String lastName){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		male = isMale();
		balance = new Balance();
	}
	
	public String toString(){
		return firstName + " " + middleName + " " + lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
		this.checkedOutBooks = checkedOutBooks;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
	public void checkOutBook(Book bk){
		bk.setCheckedOut(true);
		bk.setCheckOutDate(System.currentTimeMillis());
		bk.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.add(bk);
	}
	
	public void returnBook(Book bk){
		bk.setCheckedOut(false);
		bk.updateConditions(System.currentTimeMillis());
		balance.subtractLateFees(System.currentTimeMillis()-bk.getDueDate());
		bk.setCheckOutDate(System.currentTimeMillis());
		bk.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.remove(bk);
	}
	
	public void renewBook(Book bk){
		bk.setDueDate(System.currentTimeMillis()+30000);
	}
	
	public String getGenderPosessivePronoun(){
		if(male){
			return "his";
		}
		else {
			return "her";
		}
	}
	public String getLibraryDescription(){
		return firstName + " " + middleName + " " + lastName;
	}
}


