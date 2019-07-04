package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MaxDistBetweenSameElements {
	
	public static int calculate(String input)
	{
		int maxDist = 0;
		String[] charSet = input.split(" ");
		Set<String> uniqueSet = new HashSet<String>();

		for(int i=0;i<charSet.length;i++)
		{
			if(!uniqueSet.contains(charSet[i]))
			{
				if (maxDist < Math.abs(input.indexOf(charSet[i])-input.lastIndexOf(charSet[i])))
				maxDist = Math.abs(input.indexOf(charSet[i])-input.lastIndexOf(charSet[i]));
			}
		}
		
		return maxDist/2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(
		        new InputStreamReader(System.in));
		int numOFTC = Integer.parseInt(r.readLine());
		
		for(int i=0;i<numOFTC;i++)
		{
			r.readLine();			
			System.out.println(calculate(r.readLine()) + "\n");
		}

	}

}
