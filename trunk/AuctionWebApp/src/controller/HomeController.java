package controller;

import java.net.UnknownHostException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import function.Server;


@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Model model)
			throws UnknownHostException {
		String web = Server.web;
//		Gson gson = new Gson();
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource webResource = client.resource(Server.addressAuctionWS);
//		ClientResponse response = null;
//		String json = "";
//		Type typelist = null;
//		// get session id
//		response = webResource.path("user/getSessionID").post(
//				ClientResponse.class);
//		if (response.getStatus() != 200) {
//			model.addAttribute("tieude", "Error");
//			model.addAttribute("noidung", response.getStatus());
//			model.addAttribute("web", web);
//			return "notice";
//		}
//		session.setAttribute("sessionid", response.getEntity(String.class));
//
//		// get loaisp
//		json = webResource
//				.path("loaisanpham/findAll")
//				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
//						"sessionid").toString())).post(String.class);
//		List<Loaisp> dsloaisp = new ArrayList<Loaisp>();
//		typelist = new TypeToken<ArrayList<Loaisp>>() {
//		}.getType();
//		dsloaisp = gson.fromJson(json, typelist);
//		session.setAttribute("dsloaisp", dsloaisp);
//		// get tinhtrangsp
//		json = webResource
//				.path("tinhtrangsanpham/findAll")
//				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
//						"sessionid").toString())).post(String.class);
//		List<Tinhtrangsp> dstinhtrangsp = new ArrayList<Tinhtrangsp>();
//		typelist = new TypeToken<ArrayList<Tinhtrangsp>>() {
//		}.getType();
//		dstinhtrangsp = gson.fromJson(json, typelist);
//		session.setAttribute("dstinhtrangsp", dstinhtrangsp);
//		// get hinhthucthanhtoan
//		json = webResource
//				.path("hinhthucthanhtoan/findAll")
//				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
//						"sessionid").toString())).post(String.class);
//		List<Hinhthucthanhtoan> dshttt = new ArrayList<Hinhthucthanhtoan>();
//		typelist = new TypeToken<ArrayList<Hinhthucthanhtoan>>() {
//		}.getType();
//		dshttt = gson.fromJson(json, typelist);
//		session.setAttribute("dshttt", dshttt);
		
		
		
		
		model.addAttribute("web", web);
		return "home";
	}

}
