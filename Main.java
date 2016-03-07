
import java.util.Scanner;

import System.Memento;

public class Main {

	private static Scanner cin;
	private static Memento memento;

	public static void main(String[] args) {
		memento = new Memento();
		boolean execution = true;
		int operator = 0;
		cin = new Scanner(System.in);
		while (execution) {
			System.out.println("1 - Adição de um empregado");
			System.out.println("2 - Remoção de um empregado");
			System.out.println("3 - Lançar um Cartão de Ponto");
			System.out.println("4 - Lançar um Resultado Venda");
			System.out.println("5 - Lançar uma taxa de serviço");
			System.out.println("6 - Alterar detalhes de um empregado");
			System.out.println("7 - Rodar a folha de pagamento para hoje");
			System.out.println("8 - Undo");
			System.out.println("9 - Rendo");
			System.out.println("0 - Finalizar aplicação");
			try {
				operator = cin.nextInt();
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			switch (operator) {
			case 1:
				memento.add();
				break;
			case 2:
				memento.remove();
				break;
			case 3:
				memento.hours();
				break;
			case 4:
				memento.sell();
				break;
			case 5:
				memento.debit();
				break;
			case 6:
				memento.edit();
				break;
			case 7:
				memento.payroll();
				break;
			case 8:
				memento.undo();
				break;
			case 9:
				memento.rendo();
				break;
			case 0:
				execution = false;
				break;

			}

		}
	}

}
