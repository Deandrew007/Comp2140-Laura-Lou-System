package Model;

import java.util.ArrayList;

package Model;

import java.util.ArrayList;

public class Client {
	//attributes
	private ArrayList<Order> orders;
	private String name;
	private Type type;
	private String address;
	
	//constructors
	public Client(String name, Type type, String address){
		this.name=name;
		this.type=type;
		this.address=address;
	}
	public setName(String name){
		this.name=name;
	}
	public setType(Type type){
		this.tye=type;
	}
	public setAddress(String address){
		this.address=address;
	}
	public getName(){
		return name;
	}
	public getType(){
		return type;
	}
	public getAddress(){
		return address;
	}
	public getClientInfo(String name){
		
	}
	//methods
	public compareTo() {};
	public String toString() {};

// Updating a client
// Printing client information based on their name
// Returning prior order information (if any) of a specific client
// Printing the full list of all clients.

}

