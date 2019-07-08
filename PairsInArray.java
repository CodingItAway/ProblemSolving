package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array of integers arr[0..n-1], count all pairs (arr[i], arr[j]) in it such that i*arr[i] > j*arr[j], 0 =< i < j < n.

Example:

Input: arr[] = {5, 0, 10, 2, 4, 1, 6}

Output: 5
 * */
public class PairsInArray {
	
	public static int calculateNumberOfPairs(String[] input)
	{
		int[] arr = new int[input.length];
		int finalCount = 0;
		
		for(int i=0; i<input.length; i++)
		{
			arr[i] = (i*(Integer.parseInt(input[i])));
		}
		
		for (int i = 0; i < arr.length; i++)  
        { 
            for (int j = i + 1; j < arr.length; j++)  
            { 
                if (arr[j] < arr[i]) 
                	finalCount++; 
            } 
        } 
		
		return finalCount;
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader r = new BufferedReader(
		        new InputStreamReader(System.in));
		
		Integer numOfTestCases = Integer.parseInt(r.readLine());
		String input;
		String[] inputToCalc;
		
		for(int i=0;i<numOfTestCases;i++)
		{
			r.readLine();
			input = r.readLine();
			inputToCalc = input.split(" ");
			System.out.println(calculateNumberOfPairs(inputToCalc) + "\n");
		}

	}

}
