package com.nvh.giangvien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/giangvien")
public class GiangVienController {

	@RequestMapping(method = RequestMethod.GET)
	public String logined() {
		return "giangvien";
	}
	
}
