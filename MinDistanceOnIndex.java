package com.ProblemSolving;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceOnIndex {
	

	public static int solution(int v[], int N)
	{		
		Map<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		int minDist = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++)
		{
			if(!inputMap.containsKey(v[i]))
			inputMap.put(v[i], i);
		}	
		
		Object[] as = inputMap.values().toArray();
		
		for(int i=1;i<=as.length-1;i++)
		{
			if(Math.abs((Integer)(as[i])-(Integer)(as[i-1])) < minDist)
			minDist = Math.abs((Integer)(as[i])-(Integer)(as[i-1]));
		}
		
		return minDist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input= {1,4,7,3,3,5};
		System.out.println(solution(input,6));

	}

}
