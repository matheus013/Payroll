package System;

import java.util.ArrayList;
import java.util.Scanner;

import Employees.Commissioned;
import Employees.Employees;
import Employees.Hourly;
import Employees.Salaried;
import Payment.Payment;
import Payment.PaymentForm;

public class MySystem {

	ArrayList<Employees> users = new ArrayList<Employees>();
	Scanner cin = new Scanner(System.in);

	public void addEmployees() throws Exception {
		double taxa = 0;
		System.out.println("Entre com nome");
		String nome = cin.nextLine();
		System.out.println("Entre com endereço");
		String endereço = cin.nextLine();
		int id = users.size();
		System.out.println("Entrem com \"sim\" ou \"não\", se é do sindicato");
		boolean sind = (cin.nextLine().equals("sim")) ? true : false;
		if (sind) {
			System.out.println("Entre com taxa sindical");
			taxa = cin.nextDouble();
		}
		System.out.println("Entre com tipo do empregado:\n1 - Assalariado\n2 - Horista\n3 - Comissionado");
		int op = cin.nextInt();
		Employees pobre = null;
		switch (op) {
		case 1:
			System.out.println("Entre com o salario");
			double salary = cin.nextDouble();
			pobre = new Salaried(id, nome, endereço, taxa, sind, salary);
			break;
		case 2:
			System.out.println("Entre com o cust por hora");
			double cust = cin.nextDouble();
			pobre = new Hourly(id, nome, endereço, taxa, sind, cust);
			break;
		case 3:
			System.out.println("Entre com o salario");
			salary = cin.nextDouble();
			System.out.println("Entre com valor da comissão");
			double com = cin.nextDouble();
			pobre = new Commissioned(id, nome, endereço, taxa, sind, salary, com);
			break;
		}
		System.out.println("Escolha forma de pagamento");
		System.out.println("1 - Cheque em mãos");
		System.out.println("2 - Cheque correios");
		System.out.println("3 - Deposito em conta");
		int key = cin.nextInt();
		switch (key) {
		case 1:
			pobre.setPay(PaymentForm.CHEQUE);
			break;
		case 2:
			pobre.setPay(PaymentForm.CORREIOS);
			break;
		case 3:
			pobre.setPay(PaymentForm.DEPOSITO);
			break;

		}
		try {
			users.add(pobre);
			System.out.println("usuario " + nome + " foi adicionado com sucesso\nSeu id é " + id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void removeEmployees() throws Exception {
		System.out.println("Entre com id do usuario");
		int id = cin.nextInt();
		try {
			users.remove(id);
			System.out.println("Usuario removido com sucesso");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void addHours() throws Exception {
		System.out.println("Entre com id do funcionario");
		int id = cin.nextInt();
		if (users.get(id) instanceof Hourly) {
			Hourly element = (Hourly) users.get(id);
			System.out.println("Entre com horas trabalhadas");
			element.addHours(cin.nextInt());
			users.set(id, element);
		} else {
			System.out.println("funcionario não é horista");
		}
	}

	public void addSell() throws Exception {
		System.out.println("Entre com id do funcionario");
		int id = cin.nextInt();
		if (users.get(id) instanceof Commissioned) {
			Commissioned element = (Commissioned) users.get(id);
			System.out.println("Entre com numero de venda");
			element.addSell(cin.nextInt());
			users.set(id, element);
		} else {
			System.out.println("funcionario não é comissionado");
		}
	}

	public void addDebit() throws Exception {
		System.out.println("Entre com id do funcionario");
		int id = cin.nextInt();
		try {
			System.out.println("Entre com valor do serviço");
			users.get(id).addDebitos(cin.nextDouble());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void editUser() throws Exception {
		System.out.println("Entre com id do funcionario");
		int id = cin.nextInt();
		while (true) {
			Employees curr = users.get(id);
			System.out.println("Escolha qual dado quer alterar");
			System.out.println("1 - nome");
			System.out.println("2 - endereço");
			System.out.println("3 - tipo de funcionario");
			System.out.println("4 - forma de pagamento");
			System.out.println("5 - sindicalizado");
			System.out.println("6 - taxa sindical");
			System.out.println("0 - salvar alterações/sair");
			int op = -1;
			try {
				op = cin.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (op == 0) {
				System.out.println("Alterações salvas com sucesso");
				break;
			}

			switch (op) {
			case 1:
				System.out.println("Insira novo nome");
				curr.setName(cin.nextLine());
				break;
			case 2:
				System.out.println("Insira novo endereço");
				curr.setEndereço(cin.nextLine());
				break;
			case 3:
				System.out.println("Escolha novo tipo");
				System.out.println("1 - comissionado");
				System.out.println("2 - horista");
				System.out.println("3 - assalariado");
				int key = cin.nextInt();
				switch (key) {
				case 1:
					System.out.println("Entre com o salario");
					double salary = cin.nextDouble();
					System.out.println("Entre com valor da comissão");
					double com = cin.nextDouble();
					Commissioned commissioned = (Commissioned) curr;
					commissioned.setSalary(salary);
					commissioned.setCust(com);
					users.set(id, commissioned);
					break;
				case 2:
					System.out.println("Entre com o cust por hora");
					double cust = cin.nextDouble();
					Hourly hourly = (Hourly) curr;
					hourly.setCust(cust);
					users.set(id, hourly);
					break;
				case 3:
					System.out.println("Entre com o salario");
					salary = cin.nextDouble();
					Salaried salaried = (Salaried) curr;
					salaried.setSalary(salary);
					users.set(id, salaried);
					break;
				}
				break;
			case 4:
				System.out.println("Escolha forma de pagamento");
				System.out.println("1 - Cheque em mãos");
				System.out.println("2 - Cheque correios");
				System.out.println("3 - Deposito em conta");
				key = cin.nextInt();
				switch (key) {
				case 1:
					curr.setPay(PaymentForm.CHEQUE);
					break;
				case 2:
					curr.setPay(PaymentForm.CORREIOS);
					break;
				case 3:
					curr.setPay(PaymentForm.DEPOSITO);
					break;
				}
				users.set(id, curr);
				break;
			case 5:
				System.out.println("sindicalizado?");
				System.out.println("1 - sim");
				System.out.println("2 - não");
				boolean sind = (cin.nextLine().equals("sim")) ? true : false;
				curr.setSindicato(sind);
				users.set(id, curr);
				break;
			case 6:
				System.out.println("Entre com taxa sindical");
				double taxa = cin.nextDouble();
				curr.setSindicalTax(taxa);
				users.set(id, curr);
				break;

			}
		}

	}
	public void test() {
		users.add(new Salaried(0, "Matheus", "", 0, false, 10000));
		users.add(new Salaried(0, "Matheus", "", 0, false, 10000));
		users.add(new Hourly(0, "Zé Paulo", "", 0, false,13));
		users.add(new Commissioned(0, "João P", "", 0, false, 10000,12));
		try {
			payroll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void payroll() throws Exception{
		Payment payment = new Payment();
		System.out.println("nome - valor à pagar - data de pagamento - forma de pagamento");
		for (Employees employees : users) {
			System.out.println(payment.print(employees));
		}
	}

}
