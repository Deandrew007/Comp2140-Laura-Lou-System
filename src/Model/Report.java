package Model;

import java.util.Calendar;

public class Report implements Comparable<Report>{
	//attributes
	private Calendar dateGenerated;
	private String type;
	private Client client;
	private Order order;
	private Employee employee;
	
	//constructors
	public Report(Client client, int refNum) {
		this.dateGenerated = Calendar.getInstance();
		this.client = client;
		this.order = client.getOrder(refNum);
		this.type = "Order";
	}
	public Report(Employee employee) {
		this.dateGenerated = Calendar.getInstance();
		this.employee = employee;
		this.type = "Employee";
	}
	
	//methods
	public void setDateGenerated(int year, int month, int date) {
		dateGenerated.set(year, month, date);
	}
	public Calendar getGenDate() {
		return this.dateGenerated;
	}
	public String getGenDateInfo() {
		return (dateGenerated.get(Calendar.YEAR)+ "/" + dateGenerated.get(Calendar.MONTH) + "/" + dateGenerated.get(Calendar.DAY_OF_MONTH));
	}
	public String toString() {
		if (this.type.equals("Order")) {
			return ("Date Generated: " + getGenDateInfo() + "\nOrder Information: \n" + client.toString() + "\n" + order.toString());
		} else if (this.type.equals("Employee")) {
			return ("Date Generated: " + getGenDateInfo() + "\nEmployee Information: \n" + employee.toString());
		}
	}
	@Override
	public int compareTo(Report other) {
		Calendar date1 = this.dateGenerated;
		Calendar date2 = other.getGenDate();
		return date1.compareTo(date2);
	}
	
}
