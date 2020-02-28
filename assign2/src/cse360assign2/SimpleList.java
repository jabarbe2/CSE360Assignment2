/**
 * Jaya Barber
	* Class ID: 358
	* Assignment 1
	* This program creates a list and has various manipulations
 */

package cse360assign2;

public class SimpleList 
{
	private int list[];
	private int count;
	
	public SimpleList()
	{
		this.count = 0;
		this.list = new int[10];
	}
	
/**
 * This method adds the parameter to the beginning of the list.
 * When a new integer is added, all of the other integers move to over.
 * When there is not more room, the last element is removed 
 * @param num
 */
	
	public void add (int num)
	{
		int i;
		if (count == list.length) //if array is full
		{
			int half = count/2;
			increase_size(count+half); // increase size by half
		}
		for (i = count; i > 0; i--)
		{
			list[i]= list[i-1]; // shift remaining elements
		}
		list[0] = num; // add element at index 0
		count ++; // increment count
		System.out.println("Number added successfully"); // print message
	}
	
/**
 * 	This method removes an integer from the list. The other values are shifted down.
 *  If the list has more than 25% empty places, the size of the list is decreased.
 * @param num
 */
	
	public void remove (int num)
	{
		int i;
		int  index = search(num);
		if (index != -1)
		{
			for (i = index; i < count; i++)
			{
				list[i] = list[i+1]; //shift array down 
			}
			count--; //decrement count
			System.out.println("Element removed successfully"); //print message
		}
		else
		{
			System.out.println("element not found"); //print error message
		}
		
		int capacity = (3*list.length)/4; // calculate 75% capacity
		if (count < capacity) // if count is less than 75% capacity
		{
			decrease_size(count); // decrease size of list
		}
	}
	
	public void increase_size(int newSize) 
	{
		int i;
		int bigger_array[] = new int [newSize]; //create new array 
		for (i = 0; i < newSize && i < count; i++)
		{
			bigger_array[i] = list[i]; //copy elements into new bigger array
		}
		list = bigger_array; //replace list with new bigger array
		if (newSize < count)
		{
			count = newSize;
		}
	}
	
	public void decrease_size(int newSize)
	{
		int i;
		int smaller_array[] = new int [newSize]; //create new array
		for (i = 0; i < newSize && i < count; i++)
		{
			smaller_array[i] = list[i]; //copy elements into new smaller array
		}
		list = smaller_array; //replace list with new smaller array
		if (newSize < count)
		{
			count = newSize;
		}
	}
	
/**
 * 	This method returns the number of elements stored in the list.
 * @return
 */
	
	public int count()
	{
		return this.count;
	}
	
/**
 * 	This method returns the list as a string with each element separated by a space
 */
	
	public String toString()
	{
		String string = "";
		for (int i = 0; i < list.length; i++)
		{
			string += list[i] + " ";
		}
		return string;
	}
	
/**
 * 	This method find the location of the parameter in the list and returns the index
 * @param num
 * @return
 */
	
	public int search(int num)
	{
		int i;
		int n = list.length;
		int index = -1;
		for (i = 0; i < n; i++)
		{
			if (list[i] == num)
			{
				index = i;
			}
		}
		return index;
	}
	
	public void append(int value)
	{
		if (list.length == count) //if array is full
		{
			int half_size = count/2;
			increase_size(count + half_size); //increase size by half
		}
		list[count] = value; //append value to end of list
		count++; //increment count
	}
	
	public int first()
	{
		if (count == 0) //if array is empty
		{
			return -1;
		}
		else
		{
			return list[0]; //return value at index 0
		}
	}
	
	public int last()
	{
		if (count == 0) //if array is empty
		{
			return -1;
		}
		else
		{
			return list[count]; //return value in the max index
		}
	}
	
	public int size()
	{
		return list.length; //return length of list
	}
}
