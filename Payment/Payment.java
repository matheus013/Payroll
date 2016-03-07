package Payment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import Employees.Commissioned;
import Employees.Employees;
import Employees.Hourly;
import Employees.Salaried;

public class Payment {
	public String print(Employees employees) {
		return employees.getName() + "  -  " + value(employees) + "  -  " + data(employees) + "    -    "
				+ form(employees.getPay());
	}

	private String data(Employees employees) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar date = Calendar.getInstance();
		if (employees instanceof Commissioned) {
			if (date.get(Calendar.DAY_OF_MONTH) > 15)
				date.set(Calendar.DAY_OF_MONTH, 30);
			else
				date.set(Calendar.DAY_OF_MONTH, 15);
		}
		if (employees instanceof Salaried) {
			date.set(Calendar.DAY_OF_MONTH, 30);
		}
		if(employees instanceof Hourly){
			date.set(Calendar.DAY_OF_WEEK,6);
			
		}
		return formatter.format(date.getTime());
	}

	private double value(Employees employees) {
		double result = 0;
		if (employees instanceof Hourly) {
			Hourly hourly = (Hourly) employees;
			result = hourly.getCust() * (hourly.getHours() - hourly.getHours() % 8)
					+ 1.5 * (hourly.getCust() * hourly.getHours() % 8);
		}
		if (employees instanceof Salaried) {
			Salaried salaried = (Salaried) employees;
			result = salaried.getSalary();
		}
		if (employees instanceof Commissioned) {
			Commissioned commissioned = (Commissioned) employees;
			result = commissioned.getSalary() + (commissioned.getVendas() * commissioned.getCust());
		}
		return result - employees.getDebitos() - (employees.isSindicato() ? employees.getSindicalTax() : 0);
	}

	private String form(final PaymentForm form) {
		switch (form) {
		case CHEQUE:
			return "cheque em mão";
		case DEPOSITO:
			return "deposito no banco";
		case CORREIOS:
			return "cheque via correios";
		}
		return "";
	}
}
