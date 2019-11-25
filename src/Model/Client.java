package Model;

import java.util.*;

public class Client implements Comparable<Client> {
	//attributes
	private ArrayList<Order> orders; //array list of orders 
	private String name; //String attribute for name
	private Type type; //attribute storing enum type
	private String address; //String attribute for address
	
	@SuppressWarnings("unlikely-arg-type")
	public Client(String name, Type type, String address){
		//initializes attributes to user original input
		this.name=name;
		this.address=address;
		if (type.equals("Government"))
			this.type = Type.Government;
		else if (type.equals("School"))
			this.type = Type.School;
		else if (type.equals("Organisation"))
			this.type = Type.Organisation;
		else if (type.equals("Private"))
			this.type = Type.Private;
	}
	public void setName(String name){
		//sets name of client to user input
		this.name=name;
	}
	public void setType(Type type){
		//sets order type of client to user input
		if (type.equals("Government"))
			this.type = Type.Government;
		else if (type.equals("School"))
			this.type = Type.School;
		else if (type.equals("Organisation"))
			this.type = Type.Organisation;
		else if (type.equals("Private"))
			this.type = Type.Private;
	}
	public void setAddress(String address){
		//sets address of client to user input
		this.address=address;
	}
	public String getName(){
		//returns name of client
		return name;
	}
	public String getType(){
		//returns type of order
		String ty;
		if (this.type==Type.Government)
			ty="Government";
		else if (this.type==Type.School)
			ty="School";
		else if (this.type==Type.Organisation)
			ty="Organisation";
		else
			ty="Private";
		return ty;
	}
	public String getAddress(){
		//returns address of client
		return address;
	}
	public String toString(String name){
		//printing client information based on their name
		String result = "Information on Client " + getName() + "Address of Client: " + getAddress() + "Type of Order: " + getType();
		return result;
	}
	public void MakeOrder(String garment, int quantity, int size, String colour, int refNum, int rec_year, int rec_month, int rec_day,int due_year, int due_month, int due_day, double payment, String status, int skill) {
		//adding order information given to an array list of orders
		//eg. arraylist=[[garment, quantity, size],[garment,quantity,size]]
		orders.add(new Order(garment,quantity,size,colour,refNum,rec_year,rec_month,rec_day,due_year,due_month,due_day,payment,status,skill));
	}
	public int compareTo(Client other) {
		// TODO Auto-generated method stub
		String name1=getName();
		String name2=other.getName();
		return (name1.compareTo(name2));
	}
}