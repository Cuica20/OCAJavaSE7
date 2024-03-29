package Java7.Mistakes;

import java.util.Arrays;

public class ArraysContainsValue {

	public static void main(String[] args) {
		
		Integer[] input = new Integer[]{1, 2, 3, 4, 5};
        System.out.printf("Does array %s has %s?  %b %n", Arrays.toString(input), 5, isExists(input, 5));
        System.out.printf("Does array %s contains %s?  %b %n", Arrays.toString(input), 5, contains(input, 5));
        System.out.printf("Does array %s has %s?  %b %n", Arrays.toString(input), 6, isExists(input, 6));
        System.out.printf("Does Integer array %s contains %s?  %b %n", Arrays.toString(input), 6, contains(input, 6));

        String[] names = new String[]{"JP", "KP", "RP", "OP", "SP"};
        System.out.printf("Does array %s has %s?  %b %n", Arrays.toString(names), "JP", isExists(names, "JP"));
        System.out.printf("Does String array %s contains %s?  %b %n", Arrays.toString(names), "JP", contains(names, "JP"));
        System.out.printf("Does array of names %s has %s?  %b %n", Arrays.toString(names), "MP", isExists(names, "MP"));
        System.out.printf("Does array %s contains %s?  %b %n", Arrays.toString(names), "UP", contains(names, "UP"));
		
	}
	
	/**
     * Function to test if Array contains a certain value or not. This method take advantage of
     * contains() method of ArrayList class, by converting array to ArrayList.
     *
     * @return true if array contains 
     */
	public static <T> boolean isExists(final T[] array, final T object) {
		return Arrays.asList(array).contains(object);
	}
	
	/**
     * Another method to search an item in Java array. This method loop through array and use
     * equals() method to search element. This actually performs a linear search over array in Java
     *
     *@return true if array has provided value.
     */
	public static <T> boolean contains(final T[] array, final T v) {
		
		for (final T e : array) {
			if (e == v || v != null && v.equals(e)) {
				return true;
			}
		}
		
		return false;
		
	}
	
}
