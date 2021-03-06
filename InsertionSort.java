/**********************
Programmer: Devin Koehl
Project: CS303 - Insertion Sort
Date: February 21, 2018
**************************/


import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;


public class InsertionSort {
	
	//Insertion sort - pg. 18 Cormen Text
	 static void Insertionsort(int arr[])
	    {
		 
		//Set the length;
	        int length = arr.length;
	        
	        //Loop through the array;
	        for (int i=1; i<length; ++i)
	        {
	        	
	        	
	            //What we are comparing;
	            int key = arr[i];
	            
	            //Go to the next element;
	            int j = i-1;
	 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            
	            //Change to the key
	            arr[j+1] = key;
	        }
	    }
	 
	 
	//Test Insertion Sort
	public static void main(String[] args) throws IOException{
		
		//Have a feel for how long our algorithm takes to run in ns
		final long startTime = System.nanoTime();
		
		//Read in the file;
		 FileReader file = new FileReader("input_100.txt");
		 
		 //Initialize new array list;
	        int[] integers = new int [100];
	        
	       //Initialize to 0;
	        int i=0;
	        
	        //Try function to read it in;
	        try {
	            Scanner input = new Scanner(file);
	            
	            while(input.hasNext())
	            {
	                integers[i] = input.nextInt();
	                i++;
	            }
	            input.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        

	        //Perform Insertion Sort on our input
	       Insertionsort(integers);
		
		//Print our sorted input
	       for(int item: integers) {
        	   System.out.println(item);
        	}
	       
		//Print how long the duration takes
	       final long duration = System.nanoTime() - startTime;
	       System.out.println(duration);
	}
}
