package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * Given an array of N elements, you are required to find the maximum sum of lengths of all non-overlapping subarrays with K as the maximum element in the subarray.
.
Input:
First line of the input contains an integer T, denoting the number of the total test cases. Then T test case follows. First line of the test case contains an integer N, denoting the number of elements in the array. Then next line contains N space separated integers denoting the elements of the array. The last line of each test case contains an integer K.

Output:
For each test case ouptut a single line denoting the sum of the length of all such subarrays.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[] <= 105

Example:
Input:
3
9 
2 1 4 9 2 3 8 3 4
4
7
1 2 3 2 3 4 1
4
10
4 5 7 1 2 9 8 4 3 1
4
Output:
5
7
4
Explanation:
Test Case 1: 
{2, 1, 4} => Length = 3 
{3, 4} => Length = 2 
So, 3 + 2 = 5 is the answer

Test Case 2: {1, 2, 3, 2, 3, 4, 1} => Length = 7

Test Case 3:
{4} => Length = 1 
{4, 3, 1} => Length = 3 
So, 1 + 3 = 4 is the answer.
 * 
 * */

public class MaxSumOfNonOverlapSubArrays {
	
	public static int getLargestSum(String[] input, int kVal)
	{
		int startingPos = 0;
		int finalSum = 0;
		boolean kValExists = false;
		boolean bigValExists = false;
		
		for(int i=0; i<input.length; i++)
		{
			 if(Integer.parseInt(input[i])==kVal)
			 {
				 kValExists = true;
				 if(i==input.length-1)
				 {
					 finalSum = finalSum + Math.abs(i-startingPos)+1; 
				 }
			 }
			 else if(Integer.parseInt(input[i])>kVal)
			 {
				 bigValExists = true;
				 	if(kValExists)
				 	{
				 		finalSum = finalSum + Math.abs(i-startingPos);
				 		kValExists = false;
				 	}
				 	startingPos = i + 1;
			 }
			 else if(!bigValExists && i==input.length-1)
			 {
				 finalSum = input.length;
			 }
			 else if(i==input.length-1)
			 {
				 if(kValExists)
				 {
					 finalSum = finalSum + Math.abs(i-startingPos)+1; 
				 }
			 }
		}
		return finalSum;		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int numOfTc = Integer.parseInt(buf.readLine());
		
		for(int i=0; i<numOfTc; i++)
		{
			buf.readLine();
			String[] input = buf.readLine().split(" ");
			int kVal = Integer.parseInt(buf.readLine());
			int largestSum = getLargestSum(input, kVal);
			System.out.println(largestSum);
		}

	}

}
