import java.util.ArrayList;
import java.util.List;

public class Gerencia {

	List<Tabalhador> _trabalhadores;
	
	public Gerencia() {
		_trabalhadores = new ArrayList<Tabalhador>();
		
		Tabalhador t = new Tabalhador(100, 20);
		_trabalhadores.add(t);
	}
}
