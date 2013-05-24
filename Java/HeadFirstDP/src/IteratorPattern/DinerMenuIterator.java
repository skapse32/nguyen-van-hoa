package IteratorPattern;


public class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	int position = 0;
	public DinerMenuIterator(MenuItem[] items2) {
		// TODO Auto-generated constructor stub
		items = items2.clone();
	}

	@Override
	public boolean hasNext() {
		if(position >= items.length || items[position] == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Object Next() {
		MenuItem item = items[position];
		position++;
		return item;
	}

}
