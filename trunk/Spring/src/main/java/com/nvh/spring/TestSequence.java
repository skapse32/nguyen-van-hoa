package com.nvh.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext mContext = new ClassPathXmlApplicationContext("beans.xml");
		ReverseSequence mGenerator = (ReverseSequence)mContext.getBean("reserveSequence");
		System.out.println(mGenerator.getInitial());
	}

}
