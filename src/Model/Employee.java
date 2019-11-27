package Model;

import java.util.ArrayList;

public class Employee implements Comparable<Employee>{
	//attributes
	private ArrayList<Order> orders;
	private int id;
	private String name;
	private Position position;
	private int skillLevel;
	private int workHours;
	private double payrate;
	private double pay;
	private String object = "Employee";
	private double overtimeRate;
	private int workedHours = 0;
	private double total;

	//constructors
	public Employee(int id, String name, Position position, int skillLevel, int workHours,
			double payrate, double pay, double overtimeRate) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.skillLevel = skillLevel;
		this.workHours = workHours;
		this.payrate = payrate;
		this.overtimeRate = overtimeRate;
		this.pay = pay;
	}
	
	//methods
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) { 
		this.orders.add(order);
	}

	public void removeOrder(Order order) {
		this.orders.remove(order);
	}

	public int numOfOrders() {
		return getOrders().size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(String position) {
		if (position.equals("FactoryWorker")){
			this.position = Position.FactoryWorker;
		}
		else if (position.equals("OfficeWorker")) {
			this.position = Position.OfficeWorker;
		}
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public double getWorkHours() {
		return workHours;
	}
	public double getWorkedHours() {
		return workedHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	public void updateWorkedHours(int workHours) {
		this.workHours += workHours;
	}
	public double getPayrate() {
		return payrate;
	}
	public double getOvertimeRate() {
		return overtimeRate;
	}
	public void setPayrate(double payrate) {
		this.payrate = payrate;
	}
	public void setOvertimeRate(double overtimeRate) {
		this.overtimeRate = overtimeRate;
	}
	public double calculatePay() {
		if (workedHours > workHours){
			double overtime = workedHours - workHours;
			pay = getPayrate() * workHours;
			double over = overtime *overtimeRate;
			total = pay + over;
		} else {
			total = getPayrate() * getWorkedHours();
		}
		return total;
	}

	public String getObject(){
		return object;
	}

	public String toString() {
		return ("Employee's ID: " + getId() + "\nEmployee's name: " + getName() + "\nPosition: " + getPosition()
		+ "\nSkill Level: " + getSkillLevel() + "\nWork Hours: " + getWorkHours() + "\nRegular Payrate = " + getPayrate() + "\nHours Worked: " + getWorkedHours() + "\nOvertime Payrate = " + getOvertimeRate() + 
		"\nPay: " + calculatePay());
	}
	
	public int compareTo(Employee newEmployee) { 
		String employeeOrders1 = Integer.toString(this.numOfOrders());
		String employeeOrders2 = Integer.toString(newEmployee.numOfOrders());
		return (employeeOrders1.compareTo(employeeOrders2));
	}
}
