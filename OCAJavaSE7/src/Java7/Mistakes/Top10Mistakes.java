package Java7.Mistakes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Top10Mistakes {

	// Es lo mismo
	// private static final String[] strArray =
	// new String [] {"AB", "BC", "CD", "EF"};

	private static final String[] strArray = { "AB", "BC", "CD", "EF" };

	/**
	 * Correct Form #1.Convert Array to ArrayList
	 */
	static ArrayList<String> arrayList = new ArrayList<String>(
			Arrays.asList(strArray));

	/**
	 * #2.Convert Array to ArrayList
	 */
	// Using List
	public static boolean useList(String[] arr, String targetValue) {
		return Arrays.asList(strArray).contains(targetValue);
	}

	// Using Set
	public static boolean useSet(String[] arr, String targetValue) {
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		return set.contains(targetValue);
	}

	// Using a simple loop
	public static boolean useLoop(String[] arr, String targetValue) {
		for (String s : arr) {
			if (s.equals(targetValue))
				return true;
		}
		return false;
	}

	// Other Form
	static ArrayList<String> arrayList2 = new ArrayList<String>(
			Arrays.asList(strArray));

	static void ArrayContainsValue() {
		if (arrayList2.contains("AB")) {
			System.out.println("Good");
		}
	}

	public static void main(String[] args) {

		System.out.println("#1: " + arrayList);
		/**
		 * #2 Claramente, el uso de un m�todo simple loop es m�s eficiente que
		 * el uso de cualquier colecci�n. Una gran cantidad de desarrolladores
		 * utilizar el primer m�todo, pero es ineficiente. Empujar la matriz a
		 * otra colecci�n requiere vuelta a trav�s de todos los elementos de
		 * leerlos antes de hacer nada con el tipo de colecci�n.
		 */
		// use List
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useList(strArray, "A");
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("useList: " + duration / 1000000);

		// use set
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useSet(strArray, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useSet:  " + duration / 1000000);

		// use loop
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useLoop(strArray, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useLoop:  " + duration / 1000000);

		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useArrayBinary:  " + duration / 1000000);

		/**
		 * 3. Remove an Element from a List Inside a Loop
		 */
		ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("b", "c",
				"d"));
		for (int i = 0; i < list3.size(); i++) {
			list3.remove(i);
		}
		System.out.println("#3: " + list3);

		/**
		 * #4 Hashtable vs HashMap The differences is that Hashtable is
		 * synchronized
		 */

		/**
		 * #8 Mutable vs Inmutable Los objetos inmutables tienen muchas
		 * ventajas, simplicidad, seguridad, etc, pero que requiere un objeto
		 * independiente para cada valor distinto, y demasiados objetos podr�an
		 * causar alto costo de la recolecci�n de basura. Debe haber un
		 * equilibrio entre la hora de elegir mutable e inmutable.
		 * 
		 * En general, se utilizan los objetos mutables para evitar producir
		 * demasiados objetos intermedios. Un ejemplo cl�sico es concatenando un
		 * gran n�mero de cadenas. Si utiliza una cadena inmutable, debe
		 * producir una gran cantidad de objetos que son elegibles para la
		 * recolecci�n de basura de inmediato. Esta p�rdida de tiempo y de
		 * energ�a de la CPU, el uso de un objeto mutable la soluci�n adecuada
		 * (por ejemplo, StringBuilder).
		 */
		String result = "";
		for (String string : strArray) {
			result = result + string;
			System.out.println("Result: " + result);
		}
		/**
		 * Hay otras situaciones en las que los objetos mutables son deseables.
		 * Por ejemplo pasar objetos mutables en m�todos permite recopilar
		 * m�ltiples resultados sin saltar a trav�s de aros demasiados
		 * sint�cticas. Otro ejemplo es la clasificaci�n y filtrado: por
		 * supuesto, usted podr�a hacer un m�todo que toma la colecci�n
		 * original, y devuelve una ordenada, pero que llegar�a a ser
		 * extremadamente derrochador para las colecciones m�s grandes.
		 */
		
		/**
		 * #9 Constructor of Super and Sub
		 */

	}
	
}
