package com.ProblemSolving;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbeOfOccurances {
	
	
	public static int detectOccurances(String input)
	{
		String queryToFind = "";
		List<String> inputList = new ArrayList<String>();
		String strArray[] = input.split(" ");
		
		for(int i=0;i<=strArray.length-1;i++)
		{
			if(strArray[i].equalsIgnoreCase("i") || (strArray[i].equalsIgnoreCase("f") && i!=strArray.length-1))
			{
				continue;
			}
			else
			{
				inputList.add(strArray[i]);
			}
			
		}
		queryToFind = inputList.get(inputList.size()-1);
		inputList.remove(inputList.size()-1);
		return  Collections.frequency(inputList, queryToFind);	
		 
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int numberOfTests = 0;
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader("D:\\Adit\\Tech_Track\\Problem Solving\\TestInput.txt"));
			String line = bf.readLine();
			numberOfTests = Integer.parseInt(line);
			
			for(int i=0;i<numberOfTests;i++)
			{
				bf.readLine();
				String input = bf.readLine();
				int numberOfOccurances = detectOccurances(input);
				if(numberOfOccurances>0)
				System.out.println(numberOfOccurances + "\n");
				else
					System.out.println("Not Present");
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
