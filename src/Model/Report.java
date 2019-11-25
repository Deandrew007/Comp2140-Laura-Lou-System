package Model;

import java.util.Calendar;

public class Report implements Comparable<Report>{
	//attributes
	private Calendar dateGenerated;
	
	//constructors
	public Report() {
		this.dateGenerated = Calendar.getInstance();
		
	}
	
	//methods
	public Calendar getGenDate() {
		return this.dateGenerated;
	}
	public String getGenDateInfo() {
		return (dateGenerated.get(Calendar.YEAR)+ "/" + dateGenerated.get(Calendar.MONTH) + "/" + dateGenerated.get(Calendar.DAY_OF_MONTH));
	}
	public String toString() {
		return ("Date Generated: " + getGenDateInfo());
	};
	@Override
	public int compareTo(Report other) {
		Calendar date1 = this.dateGenerated;
		Calendar date2 = other.getGenDate();
		return date1.compareTo(date2);
	}
	
}
