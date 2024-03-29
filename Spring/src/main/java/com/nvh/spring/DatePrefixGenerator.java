package com.nvh.spring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements PrefixGenerator {

	private DateFormat formatter;
  private int x;
  private int x2;

	public void setFormatter(String formatter) {
		this.formatter = new SimpleDateFormat(formatter);
	}		

	@Override
	public String getPrefix() {
		return formatter.format(new Date());
	}

}
