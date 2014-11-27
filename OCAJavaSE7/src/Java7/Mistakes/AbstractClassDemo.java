package Java7.Mistakes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AbstractClassDemo {

	/**
	 * No se pueden crear instancias y por eso no se pueden usar
	 * directamente.
	 * 
	 * ¿Donde se utiliza la clase abstracta en Java?
	 * - No puede crear el objeto de clase abstracta
	 * 
	 * ¿Por que es importante la clase abstracta en Java?
	 * Ambos proporcionan abstraccion
	 * 
	 * Actualmente hay trabajadores permanentes, pero la empresa empezo
	 * a contratar personas por horas.
	 * Tenía que haber hecho Empleado una clase abstracta y metodos
	 * como salario() abstracto porq eso es lo que varia entre los
	 * diferentes tipos de empleados. Ahora todo lo que necesita hacer
	 * es crear una subclase de Empleado para representar ContractEmployee
	 * 
	 * Cosas para recordar acerca de la clase abstracta y el metodo en Java
	 * 1) No se puede crear una instancia de una clase abstracta en Java.
	 * Por ejemplo, si una clase BAC es abstracta de código ejemplo
	 * Abc = new ABC() dara un error en tiempo de compilacion
	 */
	public static void main(String[] args) {

		Fruit mango = new Mango(Color.YELLOW, true); // mango es primaveral
		Fruit banana = new Banana(Color.YELLOW, false); // banana no es primaveral
		
		List<Fruit> platter = new ArrayList<Fruit>();
		platter.add(mango);
		platter.add(banana);
		serve(platter);
	}
	
	public static void serve(Collection<Fruit> fruits){
		System.out.println("Preparing fruits to server");
		for (Fruit f : fruits) {
			f.prepare();
		}
	}

}

/**
 * Clase abstracta para representar Fruta, definido solo esencialmente las
 * propiedades de la fruta y hacer cosas abstractasque es difeente para frutas
 * diferentes
 */
abstract class Fruit {
	private Color color;
	private boolean seasonal;

	public Fruit(Color color, boolean seasonal) {
		this.color = color;
		this.seasonal = seasonal;
	}

	/**
	 * Este es un metodo abstracto, mira este metodo no tiene un cuerpo, solo
	 * declarado
	 */
	public abstract void prepare();

	public Color getColor() {
		return color;
	}

	public boolean isSeasonal() {
		return seasonal;
	}
}

/**
 * Una clase concreta para extender la fruta, ya que Mango ES-UNA Fruit
 * extendiendo fruta es justificada. que tiene todas las propiedades de la
 * fruta, y define cómo preparar mango para comer.
 */
class Mango extends Fruit {

	public Mango(Color color, boolean seasonal) {
		super(color, seasonal);
	}

	@Override
	public void prepare() {
		System.out.println("Cut the Mango");
	}
	
}
/*
 * Otra clase concreta para extender la Fruta
 */
class Banana extends Fruit {

	public Banana(Color color, boolean seasonal) {
		super(color, seasonal);
	}

	@Override
	public void prepare() {
		System.out.println("Peal the Banana");
	}
	
}
