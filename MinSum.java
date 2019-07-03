package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 
 * @author Adit
 * 
 * Given an array of digits (values are from 0 to 9), find the minimum possible sum of two numbers formed from digits of the array. All digits of given array must be used to form the two numbers.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer N denoting the size of the array. Next line of each test contains N space seperated integers denoting the elements of the array.
Output:

For each test case output a single line containing the required sum.
Constraints:

1<=T<=100
1<=N<=50
Example:

Input

2
6
6 8 4 5 2 3
5
5 3 0 7 4

Output

604
82

Explanation:

Test Case 1-

The minimum sum is formed by numbers 
358 and 246
Test Case 2 -

The minimum sum is formed by numbers 
35 and 047
 *
 */

public class MinSum {
	
	static List<String> sortedListOfStringInput(String input)
	{
		List<String> op = new ArrayList<String>();		
		String[] opArray = input.split(" ");
		op = Arrays.asList(opArray);
		Collections.sort(op);
		return op;
		
	}
	
	static int buildNumbersAndSum(List<String> input)
	{
		StringBuilder num1 = new StringBuilder();
		StringBuilder num2 = new StringBuilder();
		
		for(int i=0;i<input.size();i++)
		{
			if(i%2==0)
				num1.append(input.get(i));
			else
				num2.append(input.get(i));
		}			
		return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
		
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int numberOfTests = 0;
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader("D:\\Adit\\Tech_Track\\Problem Solving\\TestInput1.txt"));
			String line = bf.readLine();
			numberOfTests = Integer.parseInt(line);
			
			for(int i=0;i<numberOfTests;i++)
			{
				bf.readLine();
				String input = bf.readLine();
				List<String> op = sortedListOfStringInput(input);
				System.out.println(buildNumbersAndSum(op)+"\n");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			bf.close();
		}

	}

}
