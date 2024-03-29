package controller;

import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.NewCookie;

import model.Sanpham;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import function.Function;
import function.Server;

@Controller
public class SanPhamController {
	@RequestMapping(value = "/sanphamdangdau", method = RequestMethod.GET)
	public String sanphamdangdau(
			@RequestParam(value = "maLoaiSP", required = false, defaultValue = "-1") int maLoaiSP,
			@RequestParam(value = "soLuongSanPhamTrenTrang", required = false, defaultValue = "8") int soLuongSanPhamTrenTrang,
			@RequestParam(value = "trang", required = false, defaultValue = "1") int trang,
			Model model, HttpSession session) {
		String imageDirectory = Server.addressAuctionImage;
		String web = Server.web;
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(Server.addressAuctionWS);
		Form form = null;
		Gson gson = new Gson();
		String json = "";
		List<Sanpham> dssp = new ArrayList<Sanpham>();
		// lay danh sach san pham
		form = new Form();
		form.add("size", soLuongSanPhamTrenTrang);
		form.add("page", trang);
		form.add("maloaisp", maLoaiSP);
		json = webResource
				.path("sanpham/findSanPhamDangDauTheoLoai")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
						"sessionid").toString())).post(String.class,form);
		Type typelist = new TypeToken<ArrayList<Sanpham>>() {
		}.getType();
		dssp = gson.fromJson(json, typelist);
		// lay so luong san pham
		form = new Form();
		form.add("maloaisp", maLoaiSP);
		json = webResource
				.path("sanpham/findSoSanPhamDangDau")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
						"sessionid").toString())).post(String.class,form);
		int soTrang = Function.tinhSoTrangSanPham(soLuongSanPhamTrenTrang,
				Integer.parseInt(json));
		model.addAttribute("tieude", "Sản phẩm đang đấu");
		model.addAttribute("soLuongSanPhamTrenTrang", soLuongSanPhamTrenTrang);
		model.addAttribute("trang", trang);
		model.addAttribute("maLoaiSP", maLoaiSP);
		model.addAttribute("soTrang", soTrang);
		model.addAttribute("dssp", dssp);
		model.addAttribute("imageDirectory", imageDirectory);

		model.addAttribute("web", web);
		return "sanphamdangdau";
	}
	@RequestMapping(value = "/loaddssanphamdangdau", method = RequestMethod.POST)
	public @ResponseBody
	String loaddssanphamcuatoidangdau(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String maloaisp=request.getParameter("maLoaiSP");
		String size=request.getParameter("size");
		String page=request.getParameter("page");
		String json = "";
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(Server.addressAuctionWS);
		Form form = new Form();
		form.add("size", size);
		form.add("page", page);
		form.add("maloaisp", maloaisp);
		ClientResponse response = null;
		response = webResource
				.path("sanpham/findSanPhamDangDauTheoLoai")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute("sessionid").toString()))
				.post(ClientResponse.class, form);
		json = response.getEntity(String.class);	
		return json;
	}
	@RequestMapping(value = "/sanphamsapdau", method = RequestMethod.GET)
	public String sanphamsapdau(
			@RequestParam(value = "maLoaiSP", required = false, defaultValue = "-1") int maLoaiSP,
			@RequestParam(value = "soLuongSanPhamTrenTrang", required = false, defaultValue = "8") int soLuongSanPhamTrenTrang,
			@RequestParam(value = "trang", required = false, defaultValue = "1") int trang,
			Model model, HttpSession session) {
		String imageDirectory = Server.addressAuctionImage;
		String web = Server.web;
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(Server.addressAuctionWS);
		Form form = null;
		Gson gson = new Gson();
		String json = "";
		List<Sanpham> dssp = new ArrayList<Sanpham>();
		// lay danh sach san pham
		form = new Form();
		form.add("size", soLuongSanPhamTrenTrang);
		form.add("page", trang);
		form.add("maloaisp", maLoaiSP);
		json = webResource
				.path("sanpham/findSanPhamSapDauTheoLoai")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
						"sessionid").toString())).post(String.class,form);
		Type typelist = new TypeToken<ArrayList<Sanpham>>() {
		}.getType();
		dssp = gson.fromJson(json, typelist);
		// lay so luong san pham
		form = new Form();
		form.add("maloaisp", maLoaiSP);
		json = webResource
				.path("sanpham/findSoSanPhamSapDau")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
						"sessionid").toString())).post(String.class,form);
		int soTrang = Function.tinhSoTrangSanPham(soLuongSanPhamTrenTrang,
				Integer.parseInt(json));
		model.addAttribute("tieude", "Sản phẩm sắp đấu");
		model.addAttribute("soLuongSanPhamTrenTrang", soLuongSanPhamTrenTrang);
		model.addAttribute("trang", trang);
		model.addAttribute("maLoaiSP", maLoaiSP);
		model.addAttribute("soTrang", soTrang);
		model.addAttribute("dssp", dssp);
		model.addAttribute("imageDirectory", imageDirectory);
		model.addAttribute("web", web);
		return "sanphamsapdau";
	}
	@RequestMapping(value = "/sanphamdadau", method = RequestMethod.GET)
	public String sanphamdadau(
			@RequestParam(value = "maLoaiSP", required = false, defaultValue = "-1") int maLoaiSP,
			@RequestParam(value = "soLuongSanPhamTrenTrang", required = false, defaultValue = "8") int soLuongSanPhamTrenTrang,
			@RequestParam(value = "trang", required = false, defaultValue = "1") int trang,
			Model model, HttpSession session) {
		String imageDirectory = Server.addressAuctionImage;
		String web = Server.web;
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(Server.addressAuctionWS);
		Form form = null;
		Gson gson = new Gson();
		String json = "";
		List<Sanpham> dssp = new ArrayList<Sanpham>();
		// lay danh sach san pham
		form = new Form();
		form.add("size", soLuongSanPhamTrenTrang);
		form.add("page", trang);
		form.add("maloaisp", maLoaiSP);
		json = webResource
				.path("sanpham/findSanPhamDaDauTheoLoai")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
						"sessionid").toString())).post(String.class,form);
		Type typelist = new TypeToken<ArrayList<Sanpham>>() {
		}.getType();
		dssp = gson.fromJson(json, typelist);
		// lay so luong san pham
		form = new Form();
		form.add("maloaisp", maLoaiSP);
		json = webResource
				.path("sanpham/findSoSanPhamDaDau")
				.cookie(new NewCookie("JSESSIONID", session.getAttribute(
						"sessionid").toString())).post(String.class,form);
		int soTrang = Function.tinhSoTrangSanPham(soLuongSanPhamTrenTrang,
				Integer.parseInt(json));
		model.addAttribute("tieude", "Sản phẩm đã đấu");
		model.addAttribute("soLuongSanPhamTrenTrang", soLuongSanPhamTrenTrang);
		model.addAttribute("trang", trang);
		model.addAttribute("maLoaiSP", maLoaiSP);
		model.addAttribute("soTrang", soTrang);
		model.addAttribute("dssp", dssp);
		model.addAttribute("imageDirectory", imageDirectory);
		model.addAttribute("web", web);
		return "sanphamdadau";
	}
}
