package Chapter11;

import java.util.ArrayList;

public class MyStack {
	private ArrayList myList = new ArrayList<>();
	
	public boolean isEmpty(){
		return myList.isEmpty();
	}
	public int getSize(){
		return myList.size();
	}
	public Object peek(){
		return myList.get(getSize() -1);
	}
	public Object pop(){
		Object o = myList.get(getSize() -1 );
		myList.remove(getSize() -1);
		return o;
	}
	public void push(Object o){
		myList.add(o);
	}
	public void search(Object o){
		myList.lastIndexOf(o);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Stack " + myList.toString();
	}
	
}
