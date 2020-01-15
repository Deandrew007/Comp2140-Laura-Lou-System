package Model;

import Model.Position;

import java.util.ArrayList;

public class Employee{
	//attributes
	private int id;
	private String name;
	private Position position;
	private String position1;
	private int skillLevel;
	private int workHours;
	private double payrate;
	private double pay;
	private double overtimeRate;
	private int workedHours = 0;

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

	public Employee(String name, String position1, Integer skillLevel, Integer workHours, double payrate) {
		this.name = name;
		this.position1 = position1;
		this.skillLevel = skillLevel;
		this.workHours = workHours;
		this.payrate = payrate;
	}


	public String getPosition1() {
		return position1;
	}

	public void setPosition1(String position1) {
		this.position1 = position1;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	//methods

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
			double regular = getPayrate() * workHours;
			double over = overtime *overtimeRate;
			this.pay = regular + over;
		} else {
			this.pay = getPayrate() * getWorkedHours();
		}
		return pay;
	}

}