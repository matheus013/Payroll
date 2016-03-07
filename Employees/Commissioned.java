package Employees;

public class Commissioned extends Employees {
	public Commissioned(int id, String name, String endereço,
			double sindicalTax, boolean sindicato, double salary, double cust) {
		super(id, name, endereço, sindicalTax, sindicato);
		this.salary = salary;
		this.cust = cust;
		this.vendas = 0;
		// TODO Auto-generated constructor stub
	}
	private double salary;
	private int vendas;
	private double cust;

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getVendas() {
		return vendas;
	}
	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
	public double getCust() {
		return cust;
	}
	public void setCust(double cust) {
		this.cust = cust;
	}
	public void addSell(int sell) {
		this.vendas += sell;
	}

}
