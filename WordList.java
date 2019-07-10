package com.java.io.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 * The WordList program from Section 10.3 reads a text file and makes an alphabetical list of all the words in that file. 
 * The list of words is output to another file. Improve the program so that it also keeps track of the number of times that each work occurs in the file. 
 * Write two lists to the output file. 
 * The first list contains the words in alphabetical order. The number of times that the word occurred in the file should be listed along with the word. 
 * Then write a second list to the output file in which the words are sorted according to the number of times that they occurred in the files. 
 * The word that occurred most often should be listed first.
 */

public class WordList {

	public static void main(String[] args) throws IOException  {
		
		String input = "D:\\TestIp.txt";
		String output = "D:\\TestOp.txt";
		String line;
		Pattern p = Pattern.compile("[\\w']+");
		Set<String> sortedListOfWords = new TreeSet<String>();
		Map<String,Integer> firstList = new TreeMap<String,Integer>();
		Map<String,Integer> secondList = new HashMap<String,Integer>();
		
		
		BufferedReader bufR = new BufferedReader(new FileReader(input));
		BufferedWriter bufW = new BufferedWriter(new FileWriter(output));
		
		while((line=bufR.readLine())!=null)
		{
			Matcher m = p.matcher(line);
			while ( m.find() ) {
				if(sortedListOfWords.contains(line.substring(m.start(), m.end())))
				{
					int count = firstList.get(line.substring(m.start(), m.end()));
					firstList.put(line.substring(m.start(), m.end()),count+1);
				}
				else
				{
					firstList.put(line.substring(m.start(), m.end()),1);
				}
				sortedListOfWords.add(line.substring(m.start(), m.end()));
			}
		}
		
		Set<String> firstSet = new HashSet<String>();
		firstSet = firstList.keySet();
		
		bufW.write("First List : ");
		bufW.newLine();
		for(String key : firstSet)
		{
			bufW.write(key + " - "+firstList.get(key));
			bufW.newLine();
		}
		secondList = firstList
		        .entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue())
		        .collect(
		            Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
		                LinkedHashMap::new));
		bufW.newLine();
		bufW.newLine();
		bufW.newLine();
		bufW.write("Second List : ");
		bufW.newLine();
		
		firstList.clear();
		firstSet = secondList.keySet();
		for(String key : firstSet)
		{
			bufW.write(key + " - "+secondList.get(key));
			bufW.newLine();
		}
		
		bufW.close();

	}

}
