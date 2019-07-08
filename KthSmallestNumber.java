

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Adit
 *
 *Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Expected Time Complexity: O(n)

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:
7
15
 */

public class KthSmallestNumber {
	
	public static int calculate(String[] input, int lookingFor)
	{
		List<Integer> listOfInt = Arrays.asList(input).stream().map(Integer::parseInt).collect(Collectors.toList());
		Collections.sort(listOfInt);
		return listOfInt.get(lookingFor-1);
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
			int lookingFor = Integer.parseInt(r.readLine());			
			System.out.println(calculate(inputToCalc,lookingFor) + "\n");
		}

	}

}
