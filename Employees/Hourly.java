package Employees;

public class Hourly extends Employees {
	private int hours;
	private double cust;
	public Hourly(int id, String name, String endereço, double sindicalTax, boolean sindicato, double cust) {
		super(id, name, endereço, sindicalTax, sindicato);
		this.cust = cust;
	}
	public void addHours(int hours) {
		// TODO Auto-generated method stub
		this.hours += hours;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getCust() {
		return cust;
	}
	public void setCust(double cust) {
		this.cust = cust;
	}
}
