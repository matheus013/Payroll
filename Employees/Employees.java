package Employees;

import Payment.PaymentForm;

public class Employees {
	
	protected int id;
	protected String name;
	protected String endereço;
	protected double sindicalTax;
	protected boolean sindicato;
	protected double debitos;
	PaymentForm pay;
	
	public Employees(int id, String name, String endereço, double sindicalTax, boolean sindicato) {
		super();
		this.id = id;
		this.name = name;
		this.endereço = endereço;
		this.sindicalTax = sindicalTax;
		this.sindicato = sindicato;
		pay = PaymentForm.DEPOSITO;
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

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public double getSindicalTax() {
		return sindicalTax;
	}

	public void setSindicalTax(double sindicalTax) {
		this.sindicalTax = sindicalTax;
	}

	public boolean isSindicato() {
		return sindicato;
	}

	public void setSindicato(boolean sindicato) {
		this.sindicato = sindicato;
	}

	public double getDebitos() {
		return debitos;
	}

	public void addDebitos(double debitos) {
		this.debitos = debitos;
	}

	public PaymentForm getPay() {
		return pay;
	}

	public void setPay(PaymentForm pay) {
		this.pay = pay;
	}
	
	
	
	
}
