package Java7.Mistakes;

import java.util.List;

public class WhyConstrutorIsImportant {

	/**
	 * En palabras simples, Constructor es un método como bloque de código que
	 * es llamada por el tiempo de ejecución de Java durante la creación de
	 * objetos mediante new () operador. Constructor son especiales en el
	 * sentido de que tienen el mismo nombre que la clase que forman parte.
	 * Ellos también son especiales en el sentido de que están llamados por JVM
	 * automáticamente al crear objeto. ¿Alguna vez has pensado ¿Por qué
	 * necesita constructor? ¿Qué ventajas ofrece?
	 * 
	 * - Una de las razones es inicializar el objeto con defecto o estado
	 * inicial, ya que los valores por defecto para las primitivas pueden no ser
	 * lo que usted busca. Una razón más que crear constructor es informar al
	 * mundo acerca de las dependencias, una clase tiene que hacer su trabajo.
	 * Cualquier persona mirando sus constructores debe ser capaz de entender,
	 * lo que necesita con el fin de utilizar esta clase. Por ejemplo, después
	 * de clase OrderProcessor necesita una cola y de base de datos para que
	 * funcione correctamente.
	 */
	
	
	/**
	 * Algunos datos sobre el Constructor en Java Hay porción hechos acerca
	 * constructor como desarrollador Java debe saber, esto le ayudará a leer y
	 * entender el código Java existente en su organización o de cualquier
	 * biblioteca de código abierto.
	 * 
	 * 1. Constructor puede sobrecargarse Esto significa que puede tener más de
	 * un constructor en la clase (todos con el mismo nombre) hasta que tengan
	 * diferente firma del método, que comprenden el tipo de argumento y el
	 * orden tipo de argumento. Aquí está un ejemplo de sobrecarga constructor.
	 * Aquí tenemos tres constructor pero todos con un conjunto diferente de
	 * parámetros, asegúrese de seguir estas mejores prácticas para evitar la
	 * sobrecarga de introducir errores difíciles en su código.
	 * 
	 * 2. Constructor se pueden encadenar Llamar a un constructor de otro es
	 * conocido como Constructor de encadenamiento. Usted puede llamar al
	 * constructor de la misma clase o clase padre. Por defecto cada constructor
	 * llaman a su clase padre "ningún argumento constructor en primera línea
	 * por ejemplo super ().
	 * 
	 * Los constructores pueden llamar a los demás de forma automática o de
	 * forma explícita el uso de this() y super() palabras clave. this()
	 * denota un constructor sin argumentos de una misma clase y super() denota
	 * un argumento o por defecto ningún constructor de la clase padre. También
	 * tener constructor múltiple en una misma clase se conoce como la
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
	 * Esta importancia propio Estado de Constructor, que añadir muchas cosas en
	 * la legibilidad y facilidad de uso de la clase. Al crear objetos de
	 * OrderProcessor clase por ejemplo nueva OrderProcessor (myQueue,
	 * MyDatabase), JVM llamará a este constructor. Si no agrega ningún
	 * constructor de Java por defecto añadir un defecto ningún argumento
	 * constructor en la clase. Los constructores también hace que sea fácil de
	 * probar una clase porque en el fondo siguen inyección de dependencias. Es
	 * fácil crear un MockQueue y MockDatabase para probar nuestra clase
	 * OrderProcessor, considere lo que pasaría si esta clase está llamando a un
	 * método de servicio Singleton o conseguirlo es la dependencia. Sería
	 * difícil probar esa clase. Desde la creación de objetos es un concepto
	 * fundamental, todos los desarrolladores de Java debe saber cómo funciona
	 * Constructor, cómo inicializar el objeto, ¿cómo se llama un constructor
	 * súper clase y así sucesivamente. En siguiente sección veremos cómo sucede
	 * esto.
	 */

	/**
	 * Como trabaja el Constructor en Java
	 * 
	 * Constructor es especial, contienen un bloque de código, que ejecuta al
	 * crear objeto con nuevo operador.
	 * 
	 * - Si su clase tiene una super clase o clases padres entonces del
	 * constructor se ejecutará antes de su clase. Del mismo modo, si usted
	 * tiene más de un constructor en la clase, se puede llamar desde el
	 * constructor. mientras llama constructor siempre recordar que la llamada
	 * debe ser la primera línea en el constructor, como se muestra en la
	 * siguiente ejemplo:
	 */
	public OrderProcessor() {
		//this(defaultQueue, defaultDatabase);
	}

	/**
	 * Aquí hay argumento constructor llama constructor que acepte una Cola y
	 * base de datos. Esto se conoce como el encadenamiento de constructor y
	 * utiliza this() y super() para llamar constructor de una misma clase y
	 * clase padre respectivamente. Puede usar public, private, protected acceso
	 * con el constructor o incluso puede dejarlos sin ningún parámetro en ese
	 * caso se utilizará el acceso por defecto, que es a nivel del paquete y el
	 * privado. Constructor privado son especiales, porque si usted hace su
	 * constructor privado, entonces nadie puede llamar desde fuera de esa
	 * clase, lo que significa que no hay manera externa para crear instancia de
	 * esa clase. Esto también evita que una clase de ser subclases porque por
	 * defecto primera línea del constructor tiene una llamada a super (), no
	 * hay argumento del constructor de la clase padre, si usted hace que
	 * privado, no será accesible en clase hija y compilador arrojará error.
	 * Constructor privado tiene otro uso especial, en el patrón de diseño
	 * singleton, donde objetivo es mantener sólo una instancia de esa clase.
	 * Singleton crea instancia por sí mismo, lo almacena en caché y proporciona
	 * un método getInstance () para que esa instancia a disposición de mundo
	 * exterior. A diferencia de C ++ Java no tiene ningún destructor, sino que
	 * tiene ultimar método, que se llama justo antes del colector de basura
	 * recuperar un objeto elegible. Además, no se puede hacer abstracción
	 * constructor, sincronizado o final, esas son palabras clave ilegal
	 * constructor y el uso de ellos habrá error en tiempo de compilación.
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