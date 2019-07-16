package com.java.io.problems;

import java.io.File;
import java.io.FilenameFilter;

public class FilterFilesFromADirectoryBasedOnExtension {
	
	
	public static void main(String args[])
	{
		String inputBase = "dir";
		File dirBase = new File(inputBase);
		String[] listOfFiles = dirBase.list();
		
		//List down directories one by one
		for(String  a: listOfFiles)
		{
		System.out.println("Folder Name:" + a);
		System.out.println("\n");
		StringBuilder buildNewPath = new StringBuilder(inputBase);
		buildNewPath.append("\\"+a);
		File dirBase1 = new File(buildNewPath.toString());
		
		//List down the files, which are filtered.
		String[] listOfFiles1 = dirBase1.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.toLowerCase().endsWith(".txt");
			}
			
		}); 
		System.out.println("Files List:");
		for(String  a1: listOfFiles1)
		{
			System.out.println(a1);
			System.out.println("\n");
		}
		}
		
	}

}
