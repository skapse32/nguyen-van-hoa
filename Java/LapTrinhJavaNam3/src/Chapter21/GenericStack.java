package Chapter21;

import java.util.ArrayList;

public class GenericStack<E> implements Comparable<E>{

	ArrayList<E> list = new ArrayList<E>();
	
	public int getSize(){
		return list.size();
	}
	
	public E peek(){
		return list.get(getSize()-1);
	}
	
	public E pop(){
		E temp = list.get(getSize()-1);
		list.remove(getSize()-1);
		return temp;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void push(E o){
		list.add(o);
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
