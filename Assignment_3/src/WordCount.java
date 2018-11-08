package com.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class WordCount 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
      // read a txt file  
		String file = "lyrics.txt";
        Scanner sc = new Scanner(new File(file));
        
     // count occurrences
        HashMap <String, Integer> wordCounts = new HashMap <String, Integer>();
        while (sc.hasNext()) 
        {
            String next = sc.next().toLowerCase();
            if (!wordCounts.containsKey(next)) 
            {
            	wordCounts.put(next, 1);
            } 
            else 
            {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
        
        System.out.println("Total words = " + wordCounts.size());

        HashMap <String, Integer> sortedMapAsc = sortByValue(wordCounts);

        // Report frequencies
        for (String word : sortedMapAsc.keySet()) 
        {
            int count = sortedMapAsc.get(word);
            System.out.println(count + ":\t" + word);
        }
        
        sc.close();

	}
	
	
	public static HashMap <String, Integer> sortByValue(HashMap <String, Integer> hm) 
	{
		// Create a list from elements of HashMap
	     List <Map.Entry <String, Integer> > list = new LinkedList <Map.Entry <String, Integer> >(hm.entrySet());

	      // Sort the list
	      Collections.sort(list, new Comparator<Map.Entry <String, Integer> >() 
	      {

			public int compare(Entry <String, Integer> o1, Entry <String, Integer> o2) 
			{
				// TODO Auto-generated method stub
				return (o2.getValue()).compareTo(o1.getValue());
			}
	    	  
	      });

	      // put data from sorted list to hashmap
	      HashMap <String, Integer> temp = new LinkedHashMap <String, Integer>();
	      for (Map.Entry <String, Integer> tmp : list) 
	      {
	      	temp.put(tmp.getKey(), tmp.getValue());
	      }
	      
	      return temp;
	}

}
