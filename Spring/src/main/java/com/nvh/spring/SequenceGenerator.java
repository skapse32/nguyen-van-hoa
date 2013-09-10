package com.nvh.spring;

import java.util.Set;

public class SequenceGenerator {
	private PrefixGenerator prefix;
	private String suffix;
	private int initial;
	private int counter;
	
	public SequenceGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setPrefix(PrefixGenerator prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public void setInitial(int initial) {
		this.initial = initial;
	}
	
	public synchronized String getSequence(){
		StringBuffer mBuffer = new StringBuffer();
		mBuffer.append(prefix.getPrefix());
		mBuffer.append(initial + counter++);
		mBuffer.append(suffix);
		return mBuffer.toString();
	}
}
