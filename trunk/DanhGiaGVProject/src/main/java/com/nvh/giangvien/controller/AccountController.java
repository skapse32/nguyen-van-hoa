package com.nvh.giangvien.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nvh.giangvien.model.User;
import com.nvh.giangvien.service.UserService;

@Controller
@RequestMapping("/login")
public class AccountController {
	public static final String ACCOUNT_ATTRIBUTE = "account";
	final Logger logger = LoggerFactory.getLogger(AccountController.class);
	// controller dang nhap va dang xuat
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleLogin(@RequestParam String username,
	@RequestParam String password, HttpServletRequest request,
			HttpSession session) {
		// lay dc password va user
		User user = userService.findById(username);
		if (user == null) {
			logger.info("Khong ton tai userID");
			return "login";
		} else {
			if (user.getId().equals(password)) {
				// dang nhap thanh cong
				logger.info("login Success " + user);
				session.setAttribute(ACCOUNT_ATTRIBUTE, user);
				String weblink = "redirect:/";
				switch (user.getTypeaccount()) {
				case 0:
					weblink += "sinhvien";
					break;
				case 1:
					weblink += "giangvien";
					break;
				case 2:
					weblink += "manager";
					break;
				case 3:
					weblink += "admin";
					break;
				}
				return weblink;
			} else {
				logger.info("login fail password sai " + user.getId() + "| "
						+ password);
				return "login";
			}
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String handlerLogout(HttpSession session){
		session.removeAttribute(ACCOUNT_ATTRIBUTE);
		return "login";
	}
}
