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
		if (count == list.length)
		{
			//int half = count/2;
			//bigger_size(count+half);
		}
		for (i = count; i > 0; i--)
		{
			list[i]= list[i-1];
		}
		list[0] = num;
		count ++;
		System.out.println("Number added successfully");
	}
	
/**
 * 	This method removes an integer from the list.
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
				list[i] = list[i+1];
			}
			count--;
			System.out.println("Element removed successfully");
		}
		else
		{
			System.out.println(num + "not found");
		}
		
		int capacity = (3*list.length)/4;
		if (count < capacity)
		{
			//adapt_Size(count);
		}
	}
	
	public void increase_size(int newSize) 
	{
		int i;
		int bigger_array[] = new int [newSize];
		for (i = 0; i < newSize; i++)
		{
			bigger_array[i] = list[i];
		}
		list = bigger_array;
		if (newSize < count)
		{
			count = newSize;
		}
	}
	
	public void decrease_size(int newSize)
	{
		int i;
		int smaller_array[] = new int [newSize];
		for (i = 0; i < newSize; i++)
		{
			smaller_array[i] = list[i];
		}
		list = smaller_array;
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
		if (list.length == count)
		{
			int half_size = count/2;
			increase_size(count + half_size);
		}
		list[count] = value;
		count++;
	}
	
	public int first()
	{
		if (count == 0)
		{
			return -1;
		}
		else
		{
			return list[0];
		}
	}
	
	public int last()
	{
		if (count == 0)
		{
			return -1;
		}
		else
		{
			return list[count];
		}
	}
	
	public int size()
	{
		return list.length;
	}
}
