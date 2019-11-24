package Model;

import java.util.*;

public class Client implements Comparable<Client> {
	//attributes
	private ArrayList<Order> orders; //array list of orders //when user creates order it is sent into this list of orders (make function)
	private String name; //String attribute for name
	private Type type; //attribute storing enum type
	private String address; //String attribute for address
	HashMap<String, String> client=new HashMap<String, String>(); //storing string (name) to client_info eg. Bob = Address, Type 
	
	public Client(String name, Type type, String address){
		//initializes attributes to user original input
		this.name=name;
		this.type=type;
		this.address=address;
	}
	public void setName(String name){
		//sets name of client to user input
		this.name=name;
	}
	public void setType(Type type){
		//sets order type of client to user input
		this.type=type;
	}
	public void setAddress(String address){
		//sets address of client to user input
		this.address=address;
	}
	public String getName(){
		return name;
	}
	public Type getType(){
		return type;
	}
	public String getAddress(){
		//returns address of client
		return address;
	}
	public String toString(String name){
		//printing client information based on their name
		System.out.println("Information on Client ",getName());
		System.out.println("Address of Client: ",getAddress());
		System.out.println("Type of Order: ",getType());
	}
	public compareTo(Client other) {
		//compares current client to another client by name
		name1=getName();
		name2=other.getName();
		return (name1.compareTo(name2));
	}
	/**public String addClient(){
		//Having HashMap of client information
		client.put(getName(),getAddress(),getType().toString()) //associates name of client to its address and order type
	}**/
	public createOrder(String garment, int quantity, int size, String colour, int refNum, Calendar recDate, double payment, Status paymentStatus, int skillRequired){
		orders.add(order1);
	}
}