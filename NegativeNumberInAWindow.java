package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains n space separated integers forming the array. The last line contains the window size k.

Output:
Print the space separated negative integer starting from the first till the end for every window size k. If a window does not contain a negative integer , then print 0 for that window.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5
1<=k<=n

Example:
Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0

** For More Input/Output Examples Use 'Expected Output' option **
 * 
 * */

public class NegativeNumberInAWindow {
	
	private static List<Integer> getNegativeNumberList(String[] input, int window)
	{
		List<Integer> outputList = new ArrayList<Integer>();
		boolean noNegative = true;
		
		for(int i=0;i<input.length-window+1;i++)
		{
			for(int j=i; j<i+window; j++)
			{
				noNegative = true;
				if(input[j].contains("-"))
				{
					outputList.add(Integer.parseInt(input[j]));
					noNegative = false;
					break;
				}		
			}	
			if(noNegative)
			{
				outputList.add(0);
			}
			
		}
		
		
		return outputList;
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {	
		
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTc = Integer.parseInt(x.readLine());
		
		for(int i=0;i<numberOfTc;i++)
		{
			x.readLine();
			String[] input = x.readLine().split(" ");
			int window = Integer.parseInt(x.readLine());
			List<Integer> output = getNegativeNumberList(input, window);
			System.out.println(output);
			
		}
		

	}

}
