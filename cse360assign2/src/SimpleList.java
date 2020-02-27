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
		if(count == list.length) {
			int[] list2 = new int[(int) (list.length*1.5)];
			for(int i = 0; i < count; i++)
				list2[i] = list[i];
			list = list2;
		}
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
		if((count/list.length) >= 0.25 && list.length != 1) {
			int[] list2 = new int[list.length-1];
			for(int i = 0; i < count; i++)
				list2[i] = list[i];
			list = list2;
		}
		int index = search(integer); // store index of integer
		
		if(index != -1) {
			for(int i = index; i < list.length-1; i++) {
				list[i] = list[i+1];
			}
		}
		count--; // decrement count
	}
	
	//The append method should append the parameter to the end of the list.  If the list was full, then increase the size by 50% so there will be room.  Increment the count.
	public void append (int integer) {
		if(count == list.length) {
			int[] list2 = new int[(int) (list.length*1.5)];
			for(int i = 0; i < count; i++)
				list2[i] = list[i];
			list = list2;
		}
		list[count] = integer;
		count++;
	}
	
	// Return the current number of possible locations in the list
	public int size() {
		return list.length;
	}
	
	// Return the first element in the list.  If there are no elements n the list, then return -1.
	public int first() {
		int element = -1;
		if(count != 0) {
			element = list[0];
		}
		return element;
	}
	
	// Return the last element in the list.  If there are no elements n the list, then return -1.
	public int last() {
		int element = -1;
		if(count != 0) {
			element = list[count-1];
		}
		return element;
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
