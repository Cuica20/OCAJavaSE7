package Java7.Mistakes;

import java.util.List;

public class WhyConstrutorIsImportant {

	/**
	 * En palabras simples, Constructor es un m�todo como bloque de c�digo que
	 * es llamada por el tiempo de ejecuci�n de Java durante la creaci�n de
	 * objetos mediante new () operador. Constructor son especiales en el
	 * sentido de que tienen el mismo nombre que la clase que forman parte.
	 * Ellos tambi�n son especiales en el sentido de que est�n llamados por JVM
	 * autom�ticamente al crear objeto. �Alguna vez has pensado �Por qu�
	 * necesita constructor? �Qu� ventajas ofrece?
	 * 
	 * - Una de las razones es inicializar el objeto con defecto o estado
	 * inicial, ya que los valores por defecto para las primitivas pueden no ser
	 * lo que usted busca. Una raz�n m�s que crear constructor es informar al
	 * mundo acerca de las dependencias, una clase tiene que hacer su trabajo.
	 * Cualquier persona mirando sus constructores debe ser capaz de entender,
	 * lo que necesita con el fin de utilizar esta clase. Por ejemplo, despu�s
	 * de clase OrderProcessor necesita una cola y de base de datos para que
	 * funcione correctamente.
	 */
	
	
	/**
	 * Algunos datos sobre el Constructor en Java Hay porci�n hechos acerca
	 * constructor como desarrollador Java debe saber, esto le ayudar� a leer y
	 * entender el c�digo Java existente en su organizaci�n o de cualquier
	 * biblioteca de c�digo abierto.
	 * 
	 * 1. Constructor puede sobrecargarse Esto significa que puede tener m�s de
	 * un constructor en la clase (todos con el mismo nombre) hasta que tengan
	 * diferente firma del m�todo, que comprenden el tipo de argumento y el
	 * orden tipo de argumento. Aqu� est� un ejemplo de sobrecarga constructor.
	 * Aqu� tenemos tres constructor pero todos con un conjunto diferente de
	 * par�metros, aseg�rese de seguir estas mejores pr�cticas para evitar la
	 * sobrecarga de introducir errores dif�ciles en su c�digo.
	 * 
	 * 2. Constructor se pueden encadenar Llamar a un constructor de otro es
	 * conocido como Constructor de encadenamiento. Usted puede llamar al
	 * constructor de la misma clase o clase padre. Por defecto cada constructor
	 * llaman a su clase padre "ning�n argumento constructor en primera l�nea
	 * por ejemplo super ().
	 * 
	 * Los constructores pueden llamar a los dem�s de forma autom�tica o de
	 * forma expl�cita el uso de this() y super() palabras clave. this()
	 * denota un constructor sin argumentos de una misma clase y super() denota
	 * un argumento o por defecto ning�n constructor de la clase padre. Tambi�n
	 * tener constructor m�ltiple en una misma clase se conoce como la
	 * sobrecarga de constructor en Java.
	 */
	public static void main(String[] args) {
		//testing constructor encadenado en Java
		Derived sub = new Derived("Test");
		Derived sub2 = new Derived();
		
		/**
		 * 8. Super class constructor es ejecutado antes que la sub class
		 */
		//Son mySon = new Son(); // call Father() first then Son()
	}

}

class Father {

	Father() {
		System.out.println("Hello Father");
	}
}

class Son extends Father{
	Son() {
		System.out.println("Hello Son");
	}
}

class OrderProcessor {
	Database to;
	Queue from;

	public OrderProcessor(Queue source, Database target) {
		this.from = source;
		this.to = target;
	}

	public void process(Message msg) {
		// read from Queue
		// put to database
	}

	/**
	 * Esta importancia propio Estado de Constructor, que a�adir muchas cosas en
	 * la legibilidad y facilidad de uso de la clase. Al crear objetos de
	 * OrderProcessor clase por ejemplo nueva OrderProcessor (myQueue,
	 * MyDatabase), JVM llamar� a este constructor. Si no agrega ning�n
	 * constructor de Java por defecto a�adir un defecto ning�n argumento
	 * constructor en la clase. Los constructores tambi�n hace que sea f�cil de
	 * probar una clase porque en el fondo siguen inyecci�n de dependencias. Es
	 * f�cil crear un MockQueue y MockDatabase para probar nuestra clase
	 * OrderProcessor, considere lo que pasar�a si esta clase est� llamando a un
	 * m�todo de servicio Singleton o conseguirlo es la dependencia. Ser�a
	 * dif�cil probar esa clase. Desde la creaci�n de objetos es un concepto
	 * fundamental, todos los desarrolladores de Java debe saber c�mo funciona
	 * Constructor, c�mo inicializar el objeto, �c�mo se llama un constructor
	 * s�per clase y as� sucesivamente. En siguiente secci�n veremos c�mo sucede
	 * esto.
	 */

	/**
	 * Como trabaja el Constructor en Java
	 * 
	 * Constructor es especial, contienen un bloque de c�digo, que ejecuta al
	 * crear objeto con nuevo operador.
	 * 
	 * - Si su clase tiene una super clase o clases padres entonces del
	 * constructor se ejecutar� antes de su clase. Del mismo modo, si usted
	 * tiene m�s de un constructor en la clase, se puede llamar desde el
	 * constructor. mientras llama constructor siempre recordar que la llamada
	 * debe ser la primera l�nea en el constructor, como se muestra en la
	 * siguiente ejemplo:
	 */
	public OrderProcessor() {
		//this(defaultQueue, defaultDatabase);
	}

	/**
	 * Aqu� hay argumento constructor llama constructor que acepte una Cola y
	 * base de datos. Esto se conoce como el encadenamiento de constructor y
	 * utiliza this() y super() para llamar constructor de una misma clase y
	 * clase padre respectivamente. Puede usar public, private, protected acceso
	 * con el constructor o incluso puede dejarlos sin ning�n par�metro en ese
	 * caso se utilizar� el acceso por defecto, que es a nivel del paquete y el
	 * privado. Constructor privado son especiales, porque si usted hace su
	 * constructor privado, entonces nadie puede llamar desde fuera de esa
	 * clase, lo que significa que no hay manera externa para crear instancia de
	 * esa clase. Esto tambi�n evita que una clase de ser subclases porque por
	 * defecto primera l�nea del constructor tiene una llamada a super (), no
	 * hay argumento del constructor de la clase padre, si usted hace que
	 * privado, no ser� accesible en clase hija y compilador arrojar� error.
	 * Constructor privado tiene otro uso especial, en el patr�n de dise�o
	 * singleton, donde objetivo es mantener s�lo una instancia de esa clase.
	 * Singleton crea instancia por s� mismo, lo almacena en cach� y proporciona
	 * un m�todo getInstance () para que esa instancia a disposici�n de mundo
	 * exterior. A diferencia de C ++ Java no tiene ning�n destructor, sino que
	 * tiene ultimar m�todo, que se llama justo antes del colector de basura
	 * recuperar un objeto elegible. Adem�s, no se puede hacer abstracci�n
	 * constructor, sincronizado o final, esas son palabras clave ilegal
	 * constructor y el uso de ellos habr� error en tiempo de compilaci�n.
	 */


}

class Database {

}

class Queue {

}

class Message {

}

class Base {
	protected String name;
	
	public Base() {
		this(""); // llamando una argumento de la misma clase - llama a Base(String name)
		System.out.println("Inside no arguments constructor of Base class");
	}
	
	public Base(String name) {
		System.out.println("One arg constructor of Base class");
	}
}

class Derived extends Base {
	
	public Derived() {
		System.err.println("Inside no argument constructor of Derived class");
	}
	
	public Derived(String name) {
		super(name);
		System.out.println("Inside one arg constructor from Derived class");
	}
}