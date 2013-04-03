package Tuan7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	
	public static void main(String args[]){
		List l = new ArrayList();
		l.add("Thu hai");
		l.add(15);
		l.add(4.5);
		
		Iterator it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
