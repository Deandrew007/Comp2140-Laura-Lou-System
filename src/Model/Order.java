package Model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.*;

public class Order{
	//attributes
	private String garment;
	private int quantity;
	private int size;
	private String colour;
	private int refNum;
	private Calendar recDate;
	private Calendar dueDate;
	private LocalDate dateRec;
	private LocalDate dateDue;
	private double payment;
	//private file template;
	private Status paymentStatus;
	private int skillRequired;
	private String clientName;

	//constructors
	public Order(String garment, int quantity, int size, String colour, int refNum, int rec_year, int rec_month, int rec_day,int due_year, int due_month, int due_day, double payment, String status, int skill, String clientName) {
		setGarment(garment);
		setQuantity(quantity);
		setSize(size);
		setColour(colour);
		setRefNum(refNum);
		this.recDate = Calendar.getInstance();
		setRecDate(rec_year, rec_month, rec_day);
		this.dueDate = Calendar.getInstance();
		setDueDate(due_year, due_month, due_day);
		setPayment(payment);
		setSkillRequired(skill);

	}
	public Order(String garment, int quantity) {
		setGarment(garment);
	}

	public Order(String clientName, Integer refNum, double payment, LocalDate dateDue, LocalDate dateRec, String colour, Integer size, Integer quantity, String garment) {
		this.clientName = clientName;
		this.dateDue = dateDue;
		this.dateRec = dateRec;
		this.refNum = refNum;
		this.colour = colour;
		this.payment = payment;
		this.size = size;
		this.quantity = quantity;
		this.garment = garment;
	}

	//methods
	public void setGarment(String garment) {
		this.garment = garment;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setColour(String colour) {
		this.colour= colour;
	}
	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}
	public void setRecDate(int year, int month, int day) {
		this.recDate.set(year,month,day);
	}
	public void setDueDate(int year, int month, int day) {
		this.dueDate.set(year,month,day);
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	/**public void setPaymentStatus(String status) {
		if (status.equals("Paid")){
			this.paymentStatus = Status.Paid;
		} else if (status.equals("Deposit")){
			this.paymentStatus = Status.Deposit;
		} else if (status.equals("Paying")){
			this.paymentStatus = Status.Paying;
		} else if (status.equals("Null")){
			this.paymentStatus = Status.Null;
		}
	}
	 */
	public void setSkillRequired(int skill) {
		this.skillRequired = skill;
	}
	public String getGarment() {
		return this.garment;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public int getSize() {
		return this.size;
	}
	public String getColour() {
		return this.colour;
	}
	public int getRefNum() {
		return this.refNum;
	}
	public Calendar getRecDate() {
		return this.recDate;
	}
	public String getRecDateInfo() {
		return (recDate.get(Calendar.YEAR) + "/" + recDate.get(Calendar.MONTH) + "/" + recDate.get(Calendar.DAY_OF_MONTH));
	}
	public Calendar getDueDate() {
		return this.dueDate;
	}
	public String getDueDateInfo() {
		return (dueDate.get(Calendar.YEAR) + "/" + dueDate.get(Calendar.MONTH) + "/" + dueDate.get(Calendar.DAY_OF_MONTH));
	}
	public double getPayment() {
		return this.payment;
	}
	public int getSkillRequired() {
		return this.skillRequired;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	public String toString() {
		return ("Garment: " + getGarment() + "\nQuantity: " + getQuantity() + "\nSize: " + getSize() + "\nColour: " + getColour() + "\nReference Number: " + getRefNum() + "\nDate Ordered requested: " + getRecDate() + "\nOrder Deadline: " + getDueDate() + "\nPayment Status: " + getPaymentStatus() + "\nPayment: " + getPayment() + "\nSkill Required to Accomplish Order: " + getSkillRequired());
	}
	 */

}
