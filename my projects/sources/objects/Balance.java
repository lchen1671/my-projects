package objects;

public class Balance {
	
	double amount;
	
	long lastWorked;
	
	public Balance(){
		amount = 0;
		
		lastWorked = 0;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getLastWorked() {
		return lastWorked;
	}

	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}
	
	public void subtractLateFees(long timeOverdue){
		long n = timeOverdue;
		amount = amount - n;
		
	}
	
	public boolean canWork(long time){
		if(time - lastWorked > 10){
			return true;
		}
			return false;
	}
	
	public String earnMoney(long time){
		if(canWork(time)){
			amount = amount + 5;
			return "";
		}
			
		return "";
		
	}
}