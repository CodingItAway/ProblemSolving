package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CountOfIncreasingSubArrays {
	
	/*
	 * Given an array of N integers A1, A2, ….AN, count number of subarrays of A which are strictly increasing. 
A subarray Ai, j is the array where 1 <= i <= j <= N is a sequence of integers of Ai, Ai+1, ….Aj.
A subarray Ai, j is strictly increasing if Ai < Ai+1 < Ai+2 < …….

Input :
The first line contains an integer T denoting the total number of test cases.
For each test case, the first line contain an integer N denoting the number of elements in an array, and second line contains N elements of the array.

Output :
For each test case, output total number of strictly increasing subarrays.

Constraints:
1 <= T <= 200
1 <= N <= 107
1 <= Ai <= 107

Example:
Input:
2
6
1 3 3 2 3 5
2
1 5

Output:
4
1

Explanation:
Testcase 1: (1,3), (2, 3), (3, 5) and (2, 3, 5) are the only increasing subarrays.

** For More Input/Output Examples Use 'Expected Output' option **
	 * 
	 * */
	
	private static int calculateSubArrays(String[] input)
	{
		int countBuffer = 0;
		int finalCount = 0;
				
		for(int i=0;i<input.length-1;i++)
		{
			if(Integer.parseInt(input[i+1]) > Integer.parseInt(input[i]))
			{
				finalCount = finalCount + (countBuffer=countBuffer+1);
			}
			else
			{
				countBuffer = 0;
			}
		}
		
		return finalCount;
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {		
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int numOfTc = Integer.parseInt(buf.readLine());
		
		for(int i=0;i<numOfTc;i++)
		{
			buf.readLine();
			String[] input = buf.readLine().split(" ");
			System.out.println(calculateSubArrays(input));
		}

	}

}
