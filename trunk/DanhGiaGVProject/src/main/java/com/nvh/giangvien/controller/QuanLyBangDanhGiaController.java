package com.nvh.giangvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class QuanLyBangDanhGiaController {

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "admin";
	}
	
}
