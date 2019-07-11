package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibiriumPointInAnArray {
	
	private static int findEquilibiriumIndex(String[] input)
	{
		int lastIndex = input.length-1;
		int forwardSum = 0;
		int backwardSum = 0;
		int equilibirium = 0;
		
		for(int i=0;i<input.length;i++)
		{
			forwardSum += Integer.parseInt(input[i]);
			backwardSum += Integer.parseInt(input[lastIndex]);
			
			if(forwardSum==backwardSum) {
				if(Math.abs(i-lastIndex)==2)
				{
					equilibirium = i+2;
					break;
				}
			}
			
			if(i>=input.length/2)
			{
				break;
			}
			lastIndex--;
		}
		
		return equilibirium;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader buf = new BufferedReader(new InputStreamReader((System.in)));
		int numOfTx = Integer.parseInt(buf.readLine());
		
		for(int i=0;i<numOfTx;i++)
		{
			buf.readLine();
			String[] input = buf.readLine().split(" ");
			System.out.println(findEquilibiriumIndex(input));
				
		}

	}

}
