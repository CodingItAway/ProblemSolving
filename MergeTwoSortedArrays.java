package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * Given two sorted arrays, the task is to merge them in a sorted manner.

Examples:

Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
Output: arr3[] = {4, 5, 7, 8, 8, 9}
 * */
public class MergeTwoSortedArrays {
	
	public static void mergeArrays(String[] ip1, String[] ip2)
	{
		int i=0;
		int j=0;
		int k=0;
		int[] result = new int[ip1.length+ip2.length];
		
		while(i<ip1.length && j<ip2.length)
		{
			if(Integer.parseInt(ip1[i])<Integer.parseInt(ip2[j]))
			{
				result[k]=Integer.parseInt(ip1[i]);
				i++;
				k++;
			}
			else
			{
				result[k]=Integer.parseInt(ip2[j]);
				j++;
				k++;
			}
		}
		
		if(i<ip1.length) 
		{
			for(int start = i; start<ip1.length;start++)
			{
				result[k]=Integer.parseInt(ip2[start]);
				k++;
			}
		}
		else
		{
			for(int start = j; start<ip2.length;start++)
			{
				result[k]=Integer.parseInt(ip2[start]);
				k++;
			}			
		}
		
		
		System.out.println(Arrays.toString(result));
	}
	
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int numOfTC = Integer.parseInt(buf.readLine());
		
		for(int i=0; i<numOfTC; i++)
		{
			buf.readLine();
			String[] input1 = buf.readLine().split(" ");
			String[] input2 = buf.readLine().split(" ");
			mergeArrays(input1, input2);
			
		}

	}

}
