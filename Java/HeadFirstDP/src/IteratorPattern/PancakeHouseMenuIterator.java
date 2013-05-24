package IteratorPattern;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {

	ArrayList<MenuItem> items;
	int position = 0;

	public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.size()) {
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Object Next() {
		MenuItem item = items.get(position);
		position++;
		return item;
	}

}
