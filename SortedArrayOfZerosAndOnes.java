package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SortedArrayOfZerosAndOnes {
	
	/*
	 * The program takes in input in the below format
	 *  2 -> Number of test cases
		5 -> length of first input
		0 2 1 2 0 -> input 1
		3 -> Length of second input
		0 1 0 -> input 2
	 * 
	 * The program gives a sorted array as an output. No java apis used.
	 * 
	 * Output : 00122 and 001
	 * */
	
	public static String[] orderArray(String[] input)
	{
		int zeroCount = 0;
		int oneCount = 0;
		int twoCount = 0;
		
		for(int i=0;i<input.length;i++)
		{
			if(input[i].equalsIgnoreCase("0"))
			{
				zeroCount++;
			}
			else if(input[i].equalsIgnoreCase("1"))
			{
				oneCount++;
			}
			else
			{
				twoCount++;
			}
		}
		
		for(int i=0;i<zeroCount;i++)
		{
			input[i] = "0";
		}
		for(int i=zeroCount;i<zeroCount+oneCount;i++)
		{
			input[i] = "1";
		}
		for(int i=zeroCount+oneCount;i<zeroCount+oneCount+twoCount;i++)
		{
			input[i] = "2";
		}
		
		return input;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader((System.in)));
		int numOfTx = Integer.parseInt(buf.readLine());
		
		for(int i=0;i<numOfTx;i++)
		{
			buf.readLine();
			String[] input = buf.readLine().split(" ");
			for(String op : orderArray(input))
			{
				System.out.println(op);
			}
				
		}

	}

}
