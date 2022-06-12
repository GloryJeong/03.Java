package step02.collection;

import java.util.HashSet;
import java.util.Iterator;

public class Ex02HashSet {
	public static void main(String[] args) {
		//HashSet
		HashSet<String> set1 = new HashSet<String>();
		
		set1.add("Java");
		set1.add("Busan");
		set1.add("Study");
		set1.add("Happy");
		set1.add("Lazy");
		set1.add("Lazy");
		
		System.out.println(set1);
		for(String v : set1) {
			System.out.println(v);
		}
		
		System.out.println();
		
		// iterator
		Iterator<String> iterator = set1.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
														
		set1.remove("Lazy");
		System.out.println(set1);
		
		System.out.println(set1.contains("Happy"));
		
	}
}
