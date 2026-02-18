package Project_01.com.demo;

public class MonthData {
	
	private String month;
	private Double amount;
	
	MonthData(String month,Double amount){
		this.month=month;
		this.amount=amount;
	}
	
	public String getMonth() {
		return month;
	}
	
	public Double getAmount() {
		return amount;
	}

}
