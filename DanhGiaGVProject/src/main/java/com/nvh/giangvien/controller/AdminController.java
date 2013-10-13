package com.nvh.giangvien.controller;

import java.util.List;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nvh.giangvien.model.BangDanhGia;
import com.nvh.giangvien.service.BangDanhGiaService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private BangDanhGiaService dgService;

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "admin";
	}

	@RequestMapping(params ="qldg", method = RequestMethod.GET)
	public String quanlyDanhGia(HttpSession session) {
		List<BangDanhGia> dgs = dgService.findAll();
		logger.info(dgs.toString() +"");
		session.setAttribute("danhsachdg", dgs);
		return "admin";
	}
	
	@RequestMapping(params ="form" , method = RequestMethod.POST)
	public String themBang(@RequestParam String tenbang, RedirectAttributes redirect){
		BangDanhGia bgd = new BangDanhGia();
		logger.info("Save " + tenbang);
		bgd.setTenbang(tenbang);
		dgService.save(bgd);

		return "admin";
	}
}
