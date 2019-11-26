/**
 * @author 620121863 and 620118070
 * @version 1.0
 * @since 1.0
 */

package Model;

import java.util.*;

public class Order implements Comparable<Order>{
	//attributes
	private String garment;
	private int quantity;
	private int size;
	private String colour;
	private int refNum;
	private Calendar recDate;
	private Calendar dueDate;
	private double payment;
	private Status paymentStatus;
	private int skillRequired;
	
	//constructors
	/**
     * Constructor that initializes the attributes of an address
     * @param street
     * @param parish
     * @param country
     */
	public Order(String garment, int quantity, int size, String colour, int refNum, int rec_year, int rec_month, int rec_day,int due_year, int due_month, int due_day, double payment, String status, int skill) {
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
		setPaymentStatus(status);
		setSkillRequired(skill);
	}
	public Order(String garment, int quantity) {
		setGarment(garment);
	}
	
	//methods
	/**
     * setter method for setting or changing the name/type of garment
     * @param garment
     */
	public void setGarment(String garment) {
		this.garment = garment;
	}
	/**
     * setter method for setting or changing the number of garments to be made
     * @param quantity
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
     * setter method for setting or changing the size of the garment to be made
     * @param size
     */
	public void setSize(int size) {
		this.size = size;
	}
	/**
     * setter method for setting or changing the colour of the garments to be made
     * @param colour
     */
	public void setColour(String colour) {
		this.colour= colour;
	}
	/**
     * setter method for setting or changing the reference number of the order
     * @param refNum
     */
	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}
	/**
     * setter method for setting or changing the day the order was made
     * @param garment
     */
	public void setRecDate(int year, int month, int day) {
		this.recDate.set(year,month,day);
	}
	/**
     * setter method for setting or changing the day the order is due
     * @param garment
     */
	public void setDueDate(int year, int month, int day) {
		this.dueDate.set(year,month,day);
	}
	/**
     * setter method for setting or changing the amount of money the client has paid towards the order
     * @param garment
     */
	public void setPayment(double payment) {
		this.payment = payment;
	}
	/**
     * setter method for setting or changing the payment status of the order
     * @param garment
     */
	public void setPaymentStatus(String status) {
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
	/**
     * setter method for setting or changing the skill required to complete the order
     * @param garment
     */
	public void setSkillRequired(int skill) {
		this.skillRequired = skill;
	}
	/**
     * getter method for retrieving the name/type of garment associated with the order
     */
	public String getGarment() {
		return this.garment;
	}
	/**
     * getter method for retrieving the number of garments to be made for the order
     */
	public int getQuantity() {
		return this.quantity;
	}
	/**
     * getter method for retrieving the size of the garments to be made
     */
	public int getSize() {
		return this.size;
	}
	/**
     * getter method for retrieving the colour of the garments to be made
     */
	public String getColour() {
		return this.colour;
	}
	/**
     * getter method for retrieving the reference number of the order
     */
	public int getRefNum() {
		return this.refNum;
	}
	/**
     * getter method for retrieving the day the order was made as a Calendar object
     */
	public Calendar getRecDate() {
		return this.recDate;
	}
	/**
     * getter method for retrieving the day the order was made as a String
     */
	public String getRecDateInfo() {
		return (recDate.get(Calendar.YEAR) + "/" + recDate.get(Calendar.MONTH) + "/" + recDate.get(Calendar.DAY_OF_MONTH));
	}
	/**
     * getter method for retrieving the due date for the order as a Calendar object
     */
	public Calendar getDueDate() {
		return this.dueDate;
	}
	/**
     * getter method for retrieving the due date for the order as a String
     */
	public String getDueDateInfo() {
		return (dueDate.get(Calendar.YEAR) + "/" + dueDate.get(Calendar.MONTH) + "/" + dueDate.get(Calendar.DAY_OF_MONTH));
	}
	/**
     * getter method for retrieving the amount of money paid by the client towards the order
     */
	public double getPayment() {
		return this.payment;
	}
	/**
     * getter method for retrieving the payment status of the order as an Enum value
     */
	public Status getPaymentStatus() {
		return this.paymentStatus;
	}
	/**
     * getter method for retrieving the payment status of the order as a String
     */
	public String getPaymentStatusInfo() {
		return this.paymentStatus.name();
	}
	/**
     * getter method for retrieving the skill required to complete the order
     */
	public int getSkillRequired() {
		return this.skillRequired;
	}
	/**
     * Method used to get display values of Order as a String
     */
	public String toString() {
		return ("Garment: " + getGarment() + "\nQuantity: " + getQuantity() + "\nSize: " + getSize() + "\nColour: " + getColour() + "\nReference Number: " + getRefNum() + "\nDate Ordered requested: " + getRecDate() + "\nOrder Deadline: " + getDueDate() + "\nPayment Status: " + getPaymentStatus() + "\nPayment: " + getPayment() + "\nSkill Required to Accomplish Order: " + getSkillRequired());
	}
	/**
     * Methos to compare two orders by their paymnt status
     */
	@Override
	public int compareTo(Order other) {
		Status status1 = this.paymentStatus;
		Status status2 = other.getPaymentStatus();
		return status1.compareTo(status2);
	}
	
}
