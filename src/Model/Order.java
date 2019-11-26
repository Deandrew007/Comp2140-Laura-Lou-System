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
	private double charge;
	private double deposit;
	private double payment = 0.0;
	private Status paymentStatus;
	private int[][] skillsRequired = {{1,0},{2,0},{3,0},{4,0}}; //stores the number of employees required of a certain skill level
	private int[][] skillsGiven = {{1,0},{2,0},{3,0},{4,0}}; //stores the number of employees assigned to each skill
	private ArrayList<Employee> assignedEmployees;
	private int skillRequired;
	private double progress = 0.0;
	
	//constructors
	/**
     * Constructor that initializes the attributes of an address
     * @param street
     * @param parish
     * @param country
     */
	public Order(String garment, int quantity, int size, String colour, int refNum, int rec_year, int rec_month, int rec_day,int due_year, int due_month, int due_day, double charge, double deposit, double payment, String status, int skill, int level1, int level2, int level3, int level4) {
		setGarment(garment);
		setQuantity(quantity);
		setSize(size);
		setColour(colour);
		setRefNum(refNum);
		this.recDate = Calendar.getInstance();
		setRecDate(rec_year, rec_month, rec_day);
		this.dueDate = Calendar.getInstance();
		setDueDate(due_year, due_month, due_day);
		setCharge(charge);
		setDeposit(deposit);
		setPayment(payment);
		setPaymentStatus(status);
		setSkillRequired(skill);
		setSkillsRequired(level1, level2, level3, level4);
		assignedEmployees = new ArrayList<Employee>();
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
     * @param year
     * @param month
     * @param day
     */
	public void setRecDate(int year, int month, int day) {
		this.recDate.set(year,month,day);
	}
	/**
     * setter method for setting or changing the day the order is due
     * @param year
     * @param month
     * @param day
     */
	public void setDueDate(int year, int month, int day) {
		this.dueDate.set(year,month,day);
	}
	/**
     * setter method for setting or changing the amount of money the client has to pay in order for work to start
     * @param deposit
     */
	public void setCharge(double charge) {
		this.charge = charge;
	}
	/**
     * setter method for setting or changing the amount of money the client has to pay in order for work to start
     * @param deposit
     */
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	/**
     * setter method for setting or changing the amount of money the client has paid towards the order
     * @param payment
     */
	public void setPayment(double payment) {
		this.payment += payment;
		if (payment == this.deposit) {
			setPaymentStatus("Deposit");
		} else if (payment == 0.0) {
			setPaymentStatus("Null");
		} else if (payment > this.deposit) {
			setPaymentStatus("Paying");
		} else if (payment == this.charge) {
			setPaymentStatus("Paid");
		} else if (payment > 0.0) {
			setPaymentStatus("Some");
		}
	}
	/**
     * setter method for setting or changing the payment status of the order
     * @param status
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
		} else if (status.equals("Some")) {
			this.paymentStatus = Status.Some;
		}
	}
	/**
     * setter method for setting or changing the skill required to complete the order
     * @param skill
     */
	public void setSkillRequired(int skill) {
		this.skillRequired = skill;
	}
	/**
     * setter method for setting the skill required to complete the order
     * @param skill
     */
	public void setSkillsRequired(int level1, int level2, int level3, int level4) {
		this.skillsRequired[0][1] = level1;
		this.skillsRequired[1][1] = level2;
		this.skillsRequired[2][1] = level3;
		this.skillsRequired[3][1] = level4;
	}
	/**
     * setter method for changing the skill required to complete the order
     * @param skill
     */
	public void changeSkillsRequired() {
		this.skillsRequired[0][1] -= skillsGiven[0][1];
		this.skillsRequired[1][1] -= skillsGiven[1][1];
		this.skillsRequired[2][1] -= skillsGiven[2][1];
		this.skillsRequired[3][1] -= skillsGiven[3][1];
	}
	/**
     * setter method for setting or changing the number of employees assigned to an order
     * @param skill
     */
	public void setSkillsGiven(int level1, int level2, int level3, int level4) {
		this.skillsRequired[0][1] += level1;
		this.skillsRequired[1][1] += level2;
		this.skillsRequired[2][1] += level3;
		this.skillsRequired[3][1] += level4;
		changeSkillsRequired();
	}
	/**
     * setter method for setting or changing the progress of work on the order
     * @param progress
     */
	public void setProgress(double progress) {
		this.progress = progress;
	}
	/**
	 * method adds employees assigned to an order
	 * @param employee
	 */
	public void addEmployees(Employee employee) {
		this.assignedEmployees.add(employee);
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
     * getter method for retrieving the amount of money client needs to pay towards the order
     */
	public double getCharge() {
		return this.charge;
	}
	/**
     * getter method for retrieving the amount of money the client needs to pay in order for work to start on order
     */
	public double getDeposit() {
		return this.deposit;
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
     * getter method for retrieving the progress of completion of the order
     */
	public String getProgress() {
		return (this.progress + "%");
	}
	/**
     * getter method for retrieving the number of employees needed for the order for a skill level
     */
	public String getSkillsRequired() {
		return ("Level 1- Cutting: " + skillsRequired[0][1] + "employees" + "\n Level 2- Sewing: " + skillsRequired[1][1] + "employees" + "\n Level 3- Pressing: " + skillsRequired[2][1] + "employees" + "\n Level 4- Packaging: " + skillsRequired[3][1] + "employees");
	}
	/**
     * getter method for retrieving the number of employees assigned for the order for a skill level
     */
	public String getSkillsGiven() {
		return ("Level 1- Cutting: " + skillsGiven[0][1] + "employees" + "\n Level 2- Sewing: " + skillsGiven[1][1] + "employees" + "\n Level 3- Pressing: " + skillsGiven[2][1] + "employees" + "\n Level 4- Packaging: " + skillsGiven[3][1] + "employees");
	}
	/**
     * getter method for retrieving the employees assigned for the order
     */
	public String getEmployees() {
		String result = "";
		Collections.sort(this.assignedEmployees);
		for (Employee employee: assignedEmployees) {
			result += "\n" + employee.getID() + " " + employee.getName();
		}
		return result;
	}
	/**
     * Method used to get display values of Order as a String
     */
	public String toString() {
		return ("Garment: " + getGarment() + "\nQuantity: " + getQuantity() + "\nSize: " + getSize() + "\nColour: " + getColour() + "\nReference Number: " + getRefNum() + "\nDate Ordered requested: " + getRecDate() + "\nOrder Deadline: " + getDueDate() + "\nCharge: " + getCharge() + "\nDeposit: " + getDeposit() + "\nPayment Status: " + getPaymentStatus() + "\nPayment: " + getPayment() + "\nSkills Required to Accomplish Order: " + getSkillsRequired() + "\nNumber of Employees assigned to order: " + getSkillsGiven() + "\nEmployees assigned to order: " +  getEmployees());
	}
	/**
     * Method to compare two orders by their payment status
     */
	@Override
	public int compareTo(Order other) {
		Status status1 = this.paymentStatus;
		Status status2 = other.getPaymentStatus();
		return status1.compareTo(status2);
	}
	
}
