import br.com.desafio.carManager.Entity.Vehicle;

public class Teste {

	public static void main(String[] args) {
		Vehicle v = new Vehicle("Ford", "Fistea", "2018");
		v.setRotationDay();
		System.out.println(v.isRotationActive());
		

	}

}
