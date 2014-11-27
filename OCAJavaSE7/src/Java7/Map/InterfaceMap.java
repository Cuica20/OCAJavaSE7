package Java7.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class InterfaceMap {
	
	/**
	 * HashMap se implementa como una tabla hash, y no hay una ordenación de
	 * llaves o valores. 
	 * 
	 * TreeMap se implementa sobre la base de la estructura de
	 * árbol rojo-negro, y se ordena por la clave.
	 * 
	 * LinkedHashMap preserva el orden de inserción
	 * 
	 * Hashtable está sincronizado, en contraste con HashMap.
	 */
	
	
	
	
	public static void main(String[] args) {
		
		/**
		 * HashMap
		 * HashMap no permite dos elementos identicos
		 */
		HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
		
		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");
 
		hashMap.put(d1, 10);
		hashMap.put(d2, 15);
		hashMap.put(d3, 5);
		hashMap.put(d4, 20);
		//print size
		System.out.println(hashMap.size());
		//loop HashMap
		for (Entry<Dog, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey().toString() + " - " + entry.getValue());
		}
		/**
		 * Output
		 * 3
		 * red dog - 10
		 * white dog - 20
		 * black dog - 15
		 * 
		 */
		System.out.println("-------------------------------------");
		/**
		 * TreMap
		 * A TreeMap estan ordenados por llaves, el objeto de la clave debe
		 * ser capaz de comparar uno con el otro, es por eso que tiene que
		 * implementar la interface Comparable.
		 */
		
		Dog2 dd1 = new Dog2("red", 30);
		Dog2 dd2 = new Dog2("black", 20);
		Dog2 dd3 = new Dog2("white", 10);
		Dog2 dd4 = new Dog2("white", 10);
 
		TreeMap<Dog2, Integer> treeMap = new TreeMap<Dog2, Integer>();
		treeMap.put(dd1, 10);
		treeMap.put(dd2, 15);
		treeMap.put(dd3, 5);
		treeMap.put(dd4, 20);
		
		for (Entry<Dog2, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		/**
		 * Output
		 * red dog - 10
		 * black dog - 15
		 * white dog - 20
		 */
		System.out.println("-------------------------------------");
		/**
		 * LinkedHashMap
		 */
		LinkedHashMap<Dog, Integer> linkedHashMap = new LinkedHashMap<Dog, Integer>();
		linkedHashMap.put(d1, 10);
		linkedHashMap.put(d2, 15);
		linkedHashMap.put(d3, 5);
		linkedHashMap.put(d4, 20);
		for (Entry<Dog, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		
	}

}

//HashMap
class Dog {
	String color;
 
	Dog(String c) {
		color = c;
	}
 
	public boolean equals(Object o) {
		return ((Dog) o).color.equals(this.color);
	}
 
	public int hashCode() {
		return color.length();
	}
 
	public String toString(){	
		return color + " dog";
	}
}

//TreeMap
class Dog2 implements Comparable<Dog2>{
	String color;
	int size;
	
	Dog2(String c, int s) {
		color = c;
		size = s;
	}
	
	public boolean equals(Object o){
		return ((Dog2) o).color.equals(this.color);
	}
	
	public int hashCode() {
		return color.length();
	}
	
	public String toString(){
		return color + " dog";
	}
	
	//TreeMap
	@Override
	public int compareTo(Dog2 o) {
		return o.size - this.size;
	}
}