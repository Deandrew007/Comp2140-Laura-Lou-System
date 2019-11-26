package Model;

import java.util.ArrayList;

public class ManagerModel {
	//attributes
	private ArrayList<Order> orders;
	private ArrayList<Client> clients;
	private ArrayList<Employee> allEmployees;
	private ArrayList<Employee> availableEmployees;
	private ArrayList<Report> reports;
	private ArrayList<Order> archivedOrders;
	private ArrayList<Client> archivedClients;
	private ArrayList<Employee> archivedEmployees;
	private ArrayList<Report> archivedReports;
	
	//constructors
	public ManagerModel() {
		this.orders = new ArrayList<Order>();
		this.clients = new ArrayList<Client>();
		//make arbitrary values of clients
		this.allEmployees = new ArrayList<Employee>();
		this.availableEmployees = new ArrayList<Employee>();
		this.reports = new ArrayList<Report>();
		this.archivedOrders = new ArrayList<Order>();
		this.archivedClients = new ArrayList<Client>();
		this.archivedEmployees = new ArrayList<Employee>();
		this.archivedReports = new ArrayList<Report>();
	}
	
	//methods
	/**public search()
	public void createOrder() {}
	public void addOrder() {}
	public void removeOrder() {}
	public void archiveOrder() {}
	public void updateOrder() {}
	public void setOrder() {}
	public Order getOrder() {}
	public void createClient() {}
	public void addClient() {}
	public void removeClient() {}
	public void archiveClient() {}
	public void updateClient() {}
	public void setClient() {}
	public Client getClient() {}
	public void createEmployee() {}
	public void addEmployee() {}
	public void removeEmployee() {}
	public void archiveEmployee() {}
	public void updateEmployee() {}
	public void setEmployee() {}
	public Employee getEmployee() {}
	public boolean isAvailable() {}
	public void createInventory() {}
	public void addInventory() {}
	public void removeInventory() {}
	public void archivenventory() {}
	public void updateInventory() {}
	public void setInventory() {}
	public void genrateReport() {}
	public void addReport() {}
	public void removeReport() {}
	public void archiveReport() {}
	public Report getReport() {}
	*/
	public search()
	public void createOrder(String client_name, String garment, int quantity, int size, String colour, int refNum, int rec_year, int rec_month, int rec_day,int due_year, int due_month, int due_day, double charge, double deposit, double payment, String status, int skill, int level1, int level2, int level3, int level4) {
		//find client based on name
		Client client;
		Order order = new Order(garment, quantity, size, colour, refNum, rec_year, rec_month, rec_day, due_year, due_month, due_day, charge, deposit, payment, status, skill, level1, level2, level3, level4);
		client.makeOrder(order);
		addOrder(order, "orders");
	}
	public void addOrder(Order order, String where) {
		if (where.equals("orders")) {
			orders.add(order);
		} else if (where.equals("archives")) {
			archivedOrders.add(order);
		}
	}
	public void removeOrder(Order order, String where) {
		if (where.equals("orders")) {
			orders.remove(order);
		} else if (where.equals("archives")) {
			archivedOrders.remove(order);
		}
	}
	public void archiveOrder(Order order) {
		addOrder(order, "archives");
		removeOrder(order, "orders");
	}
	public void updateOrder(String what, String toWhat, Order order) {
		if (what.equals("garment")) {
			order.setGarment(toWhat);
		} else if (what.equals("quantity")) {
			int to_what = Integer.parseInt(toWhat);
			order.setQuantity(to_what);
		} else if (what.equals("size")) {
			int to_what = Integer.parseInt(toWhat);
			order.setSize(to_what);
		} else if (what.equals("colour")) {
			order.setColour(toWhat);
		} else if (what.equals("refNum")) {
			int to_what = Integer.parseInt(toWhat);
			order.setRefNum(to_what);
		} else if (what.equals("recDate")) {
			String[] numbers = toWhat.split(":");
			int year = Integer.parseInt(numbers[0]);
			int month = Integer.parseInt(numbers[1]);
			int day = Integer.parseInt(numbers[2]);
			order.setRecDate(year, month, day);;
		} else if (what.equals("dueDate")) {
			String[] numbers = toWhat.split(":");
			int year = Integer.parseInt(numbers[0]);
			int month = Integer.parseInt(numbers[1]);
			int day = Integer.parseInt(numbers[2]);
			order.setDueDate(year, month, day);;
		} else if (what.equals("charge")) {
			double to_what = Double.parseDouble(toWhat);
			order.setPayment(to_what);
		} else if (what.equals("deposit")) {
			double to_what = Double.parseDouble(toWhat);
			order.setPayment(to_what);
		} else if (what.equals("payment")) {
			double to_what = Double.parseDouble(toWhat);
			order.setPayment(to_what);
		} else if (what.equals("progress")) {
			double to_what = Double.parseDouble(toWhat);
			order.setProgress(to_what);
		} else if (what.equals("skillRequired")) {
			String[] numbers = toWhat.split(":");
			int level1 = Integer.parseInt(numbers[0]);
			int level2 = Integer.parseInt(numbers[1]);
			int level3 = Integer.parseInt(numbers[2]);
			int level4 = Integer.parseInt(toWhat);
			order.setSkillsRequired(level1, level2, level3, level4);
		}
	}
	public Order getOrder(int refNum, String where) {
		if (where.equals("orders")){
			for (Order order: orders) {
				if (order.getRefNum() == refNum) {
					return order;
				}
			}
			return null;
		} else if (where.equals("archives")){
			for (Order order: archivedOrders) {
				if (order.getRefNum() == refNum) {
					return order;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	public void createClient(String name, String type, String address) {
		Client client = new Client(name, type, address);
		addClient(client, "clients");
	}
	public void addClient(Client client, String where) {
		if (where.contentEquals("clients")) {
			clients.add(client);
		} else if (where.equals("archives")){
			archivedClients.add(client);
		}
	}
	public void removeClient(Client client, String where) {
		if (where.contentEquals("clients")) {
			clients.remove(client);
		} else if (where.equals("archives")){
			archivedClients.remove(client);
		}
	}
	public void archiveClient(Client client) {
		addClient(client, "archives");
		removeClient(client, "clients");
	}
	public void updateClient(String what, String toWhat, Client client) {
		if (what.equals("name")) {
			client.setName(toWhat);
		} else if (what.equals("type")) {
			client.setType(toWhat);
		}else if (what.equals("address")) {
			client.setAddress(toWhat);
		}
	}
	public Client getClient(String name, String where) {
		if (where.equals("clients")){
			for (Client client: clients) {
				if (client.getName() == name) {
					return client;
				}
			}
			return null;
		} else if (where.equals("archives")){
			for (Client client: archivedClients) {
				if (client.getName() == name) {
					return client;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	public void createEmployee() {
		Employee employee = new Employee();
		addEmployee(employee, "allEmployees");
	}
	public void addEmployee(Employee employee, String where) {
		if (where.contentEquals("allEmployees")) {
			allEmployees.add(employee);
		} else if (where.contentEquals("availableEmployees")) {
			availableEmployees.add(employee);
		} else if (where.equals("archives")){
			archivedEmployees.add(employee);
		}
	}
	public void removeEmployee(Employee employee, String where) {
		if (where.contentEquals("allEmployees")) {
			allEmployees.remove(employee);
		} else if (where.contentEquals("availableEmployees")) {
			availableEmployees.remove(employee);
		} else if (where.equals("archives")){
			archivedEmployees.remove(employee);
		}
	}
	public void archiveEmployee(Employee employee) {
		addEmployee(employee, "archives");
		if (isAvailable(employee.getID())) {
			removeEmployee(employee, "allEmployees");
			removeEmployee(employee, "availableEmployees");
		} else {
			removeEmployee(employee, "allEmployees");
		}
		
	}
	public void updateEmployee(String what, String toWhat, Employee employee) {
		if (what.equals("name")) {
			employee.setName(toWhat);
		} else if (what.equals("position")) {
			employee.setPosition(toWhat);
		} else if (what.equals("skillLevel")) {
			employee.setSkillLevel(toWhat);
		} else if (what.equals("workedHours")) {
			employee.setWorkedHours(toWhat);
		} else if (what.equals("payRate")) {
			employee.setPayrate(toWhat);
		} else if (what.equals("overPayRate")) {
			employee.setOverPayrate(toWhat);
		}
	}
	public Employee getEmployee(String id, String where) {
		if (where.equals("availableEmployees")) {
			for (Employee employee: availableEmployees) {
				if (employee.getID().equals(id)) {
					return employee;
				}
			}
		}
		return null;
	}
	public boolean isAvailable(String id) {
		if (availableEmployees.contains(id)){
			return true;
		} else {
			return false;
		}
	}
	public void genrateOrderReport(Client client, int refNum) {
		Report report = new Report(client, refNum);
		addReport(report, "reports");
	}
	public void genrateEmployeeReport(Employee employee) {
		Report report = new Report(employee);
		addReport(report, "reports");
	}
	public void addReport(Report report, String where) {
		if (where.equals("reports")) {
			reports.add(report);
		} else if (where.equals("archives")) {
			archivedReports.add(report);
		}
	}
	public void removeReport(Report report, String where) {
		if (where.equals("reports")) {
			reports.remove(report);
		} else if (where.equals("archives")) {
			archivedReports.remove(report);
		}
	}
	public void archiveReport(Report report) {
		addReport(report, "archives");
		removeReport(report, "reports");
	}
	public Report getReport(int year, int month, int day, String where) {
		if (where.equals("reports")){
			for (Report report: reports) {
				if (report.getGenDateInfo().equals(year+"/"+month+"/"+day)) {
					return report;
				}
			}
			return null;
		} else if (where.equals("archives")){
			for (Report report: archivedReports) {
				if (report.getGenDateInfo().equals(year+"/"+month+"/"+day)) {
					return report;
				}
			}
			return null;
		} else {
			return null;
		}
	}
	
}
