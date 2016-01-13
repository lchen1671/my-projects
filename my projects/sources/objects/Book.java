package objects;

import java.awt.Color;

public class Book {

	private String title;
	private int numberOfPages;
	private Person author;//custom class in this package
	private Color jacketColor;//class for java.awt
	private boolean wasLitOnFire;
	private int height;
	private int thickness;
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate;
	String description;
	int accumulatedUse;
	

	
	public Book(String title, int numPages, Person author){
		this.title  = title;
		this.numberOfPages = numPages;
		this.author = author;
		jacketColor = Color.gray;
		wasLitOnFire = false;
		height = (int)(Math.random() *100) + 150;
		thickness = (int)(numberOfPages/10);
		checkedOut = false;
		checkOutDate = 0;
		dueDate = 0; 
	}
	
	public long getSecondsRemaining(){
		long t = (int) ((dueDate - System.currentTimeMillis())/1000);
		return t;	
	}
	
	public Color getColor() {
		return jacketColor;
	}

	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}

	public String toString(){
		if(wasLitOnFire){
			return "\"" + title + "\", by an author you can't make out";
		}
		
		return "\"" + title + "\", by " + author; 
	}
	//getters
	public String getTitle(){
		return title;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public Person getAuthor() {
		return author;
	}
	

	public int getNumberofPages(){
		return numberOfPages;
	}
	public void setOnFire(){
		jacketColor = Color.black;
		title = "The title of this book is too charred to make out";
		wasLitOnFire = true;
	}

	public int getHeight() {
		return height;
	}

	public int getThickness() {
		return thickness;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	public void updateConditions(long timeOfReturn){
		int accumulatedUse = (int) (timeOfReturn - getCheckOutDate());
		
		if(accumulatedUse > 30){
			Object description;
			Object[] conditions = null;
			if(accumulatedUse/30 == 1){
				description = conditions[1];
			}
			if(accumulatedUse/30 == 2){
				description = conditions[2];
			}
			else{
				description = conditions[3];
			}
		}
	}
}
