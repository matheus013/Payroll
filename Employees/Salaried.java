package Employees;

public class Salaried extends Employees{
	private double salary;
	
	public Salaried(int id, String name, String endereço, double sindicalTax, boolean sindicato, double salary) {
		super(id, name, endereço, sindicalTax, sindicato);
		// TODO Auto-generated constructor stub
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
