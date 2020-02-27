/*	#CSE360
 *  Bader Almutairi - 318
 *  
 *  Assignment 1
 *  
 *  SimpleList class
 */

public class SimpleList {
	
	private int[] list;
	private int count;
	
	// SimpleList Construction
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	// add an integer to the list
	public void add(int integer) {
		
		for(int i = count-1; i >= 0; i--) {
			if(count != 10) {
				list[i+1] = list[i]; // move integer
			}
		}
		list[0] = integer; // add integer to the beginning of the list
		count++; // increment count
	}
	// remove an integer from the list
	public void remove(int integer) {
		
		int index = search(integer); // store index of integer
		
		if(index != -1) {
			for(int i = index; i < list.length-1; i++) {
				list[i] = list[i+1];
			}
		}
		count--; // decrement count
	}
	
	// return count of integers in the list
	public int count() {
		return count;
	}
	
	// override toStrign method
	public String toString() {
		String string = "";
		
		for(int i = 0; i < count; i++)
			string += list[i] + " ";
		
		return string.substring(0, string.length()-1); // return string without the space at the end
	}
	
	// search for integer in the list and return its index
	public int search(int integer) {
		
		for(int i = 0; i < count; i++)
			if(list[i] == integer) // if integer is found
				return i; // return index
		
		return -1; // return -1 when integer is not in the list
	}

}
