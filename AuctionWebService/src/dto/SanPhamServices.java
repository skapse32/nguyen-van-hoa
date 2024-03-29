package dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Sanpham;

import com.sun.jersey.spi.container.ResourceFilters;

import dao.EntityManagerHelper;
import dao.Hinhthucthanhtoan;
import dao.HinhthucthanhtoanDAO;
import dao.Loaisp;
import dao.LoaispDAO;
import dao.SanphamDAO;
import dao.Tinhtrangsp;
import dao.TinhtrangspDAO;
import filter.FilterAdmin;
import filter.FilterUser;

@Path("sanpham")
public class SanPhamServices {
	@Context
	HttpServletRequest request;

	@POST
	@Path("/findAll")
	@Produces("application/json; charset=utf-8")
	public List<model.Sanpham> findAll() {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		// EntityManagerHelper.beginTransaction();
		List<dao.Sanpham> daodssp = sanphamdao.findAll();
		// EntityManagerHelper.commit();
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findByTinhTrang")
	@Produces("application/json; charset=utf-8")
	public List<model.Sanpham> findByTinhTrang(
			@FormParam("tinhtrangdaugia") int tinhtrangdaugia) {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findByProperty(
				"tinhtrangdaugia", tinhtrangdaugia);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/ketThucDauGia")
	@Produces("application/json; charset=utf-8")
	public String findByKetThucDauGia() {
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		return String.valueOf(sanphamdao.ketThucDauGia1());
	}

	@POST
	@Path("/findSoSanPhamDangDau")
	@Produces("application/json; charset=utf-8")
	public String findSoSanPhamDangDau(@FormParam("maloaisp") long maloaisp) {
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		int x = sanphamdao.findSoSanPhamDangDau(maloaisp);
		return String.valueOf(x);
	}

	@POST
	@Path("/findSanPhamDangDauTheoLoai")
	@Produces("application/json; charset=utf-8")
	public List<model.Sanpham> findSanPhamDangDauTheoLoai(
			@FormParam("size") int size, @FormParam("page") int page,
			@FormParam("maloaisp") long maloaisp) {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findSanPhamDangDauTheoLoai(size,
				page, maloaisp);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findSoSanPhamSapDau")
	@Produces("application/json; charset=utf-8")
	public String findSoSanPhamSapDau(@FormParam("maloaisp") long maloaisp) {
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		int x = sanphamdao.findSoSanPhamSapDau(maloaisp);
		return String.valueOf(x);
	}

	@POST
	@Path("/findSanPhamSapDauTheoLoai")
	@Produces("application/json; charset=utf-8")
	public List<model.Sanpham> findSanPhamSapDauTheoLoai(
			@FormParam("size") int size, @FormParam("page") int page,
			@FormParam("maloaisp") long maloaisp) {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findSanPhamSapDauTheoLoai(size,
				page, maloaisp);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findSoSanPhamDaDau")
	@Produces("application/json; charset=utf-8")
	public String findSoSanPhamDaDau(@FormParam("maloaisp") long maloaisp) {
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		int x = sanphamdao.findSoSanPhamDaDau(maloaisp);
		return String.valueOf(x);
	}

	@POST
	@Path("/findSanPhamDaDauTheoLoai")
	@Produces("application/json; charset=utf-8")
	public List<model.Sanpham> findSanPhamDaDauTheoLoai(
			@FormParam("size") int size, @FormParam("page") int page,
			@FormParam("maloaisp") long maloaisp) {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findSanPhamDaDauTheoLoai(size,
				page, maloaisp);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	// findSoSPByTenSP
	@POST
	@Path("/findSoSPByTenSP")
	@Produces("application/json; charset=utf-8")
	public String findSoSPByTenSP(@FormParam("tensp") String tensp,
			@FormParam("loaiphien") int loaiphien) {
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		int x = sanphamdao.findSoSPByTenSP(tensp, loaiphien);
		return String.valueOf(x);
	}

	@POST
	@Path("/findByTenSP")
	@Produces("application/json; charset=utf-8")
	public List<model.Sanpham> findByTenSP(@FormParam("tensp") String tensp,
			@FormParam("loaiphien") int loaiphien, @FormParam("size") int size,
			@FormParam("page") int page) {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findByTenSP(tensp, loaiphien,
				size, page);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findById")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public model.Sanpham findById(@FormParam("masp") long masp) {
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		dao.Sanpham daosp = sanphamdao.findById(masp);
		model.Sanpham pojosp = new Sanpham(daosp.getMasp(), daosp.getTensp(),
				daosp.getTinhtrangsp().getTentinhtrangsp(), daosp.getSoluong(),
				daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
						.getTenloaisp(), daosp.getNguoidang(),
				daosp.getGiakhoidiem(), daosp.getGiahientai(),
				daosp.getNguoidat(), daosp.getBuocgia(), daosp
						.getThoigianbatdau().getTime(), daosp
						.getThoigianketthuc().getTime(),
				daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
						.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
				daosp.getTinhtrangdaugia(), daosp.getGhichu());
		return pojosp;
	}

	@POST
	@Path("/save")
	@Produces("application/json; charset=utf-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@ResourceFilters({ FilterUser.class })
	public String save(@FormParam("tensp") String tensp,
			@FormParam("matinhtrangsp") Long matinhtrangsp,
			@FormParam("maloaisp") Long maloaisp,
			@FormParam("mahttt") Long mahttt,
			@FormParam("soluong") Integer soluong,
			@FormParam("xuatxu") String xuatxu,
			@FormParam("thuonghieu") String thuonghieu,
			@FormParam("nguoidang") String nguoidang,
			@FormParam("giakhoidiem") Double giakhoidiem,
			@FormParam("giahientai") Double giahientai,
			@FormParam("buocgia") Double buocgia,
			@FormParam("thoigianbatdau") Timestamp thoigianbatdau,
			@FormParam("thoigianketthuc") Timestamp thoigianketthuc,
			@FormParam("thongtinlienhe") String thongtinlienhe,
			@FormParam("hinhanh") String hinhanh, @FormParam("mota") String mota) {
		SanphamDAO spdao = new SanphamDAO();
		LoaispDAO loaispdao = new LoaispDAO();
		TinhtrangspDAO ttspdao = new TinhtrangspDAO();
		HinhthucthanhtoanDAO htttdao = new HinhthucthanhtoanDAO();
		EntityManagerHelper.beginTransaction();
		Tinhtrangsp ttsp = ttspdao.findById(matinhtrangsp);
		Loaisp loaisp = loaispdao.findById(maloaisp);
		Hinhthucthanhtoan httt = htttdao.findById(mahttt);
		EntityManagerHelper.commit();
		dao.Sanpham sp = new dao.Sanpham(loaisp, ttsp, httt, tensp, soluong,
				xuatxu, thuonghieu, nguoidang, giakhoidiem, giakhoidiem, "",
				buocgia, thoigianbatdau, thoigianketthuc, thongtinlienhe,
				hinhanh, mota, 0, "");
		EntityManagerHelper.beginTransaction();
		spdao.save(sp);
		EntityManagerHelper.commit();
		return "Thêm thành công";
	}

	@POST
	@Path("/update")
	@Produces("application/json; charset=utf-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@ResourceFilters({ FilterUser.class })
	public String update(@FormParam("masp") Long masp,
			@FormParam("tensp") String tensp,
			@FormParam("matinhtrangsp") Long matinhtrangsp,
			@FormParam("maloaisp") Long maloaisp,
			@FormParam("mahttt") Long mahttt,
			@FormParam("soluong") Integer soluong,
			@FormParam("xuatxu") String xuatxu,
			@FormParam("thuonghieu") String thuonghieu,
			@FormParam("nguoidang") String nguoidang,
			@FormParam("giakhoidiem") Double giakhoidiem,
			@FormParam("buocgia") Double buocgia,
			@FormParam("thoigianbatdau") Timestamp thoigianbatdau,
			@FormParam("thoigianketthuc") Timestamp thoigianketthuc,
			@FormParam("thongtinlienhe") String thongtinlienhe,
			@FormParam("hinhanh") String hinhanh, @FormParam("mota") String mota) {
		SanphamDAO spdao = new SanphamDAO();
		LoaispDAO loaispdao = new LoaispDAO();
		TinhtrangspDAO ttspdao = new TinhtrangspDAO();
		HinhthucthanhtoanDAO htttdao = new HinhthucthanhtoanDAO();
		EntityManagerHelper.beginTransaction();
		Tinhtrangsp ttsp = ttspdao.findById(matinhtrangsp);
		Loaisp loaisp = loaispdao.findById(maloaisp);
		Hinhthucthanhtoan httt = htttdao.findById(mahttt);
		EntityManagerHelper.commit();
		dao.Sanpham sp = spdao.findById(masp);
		sp.setLoaisp(loaisp);
		sp.setTinhtrangsp(ttsp);
		sp.setHinhthucthanhtoan(httt);
		sp.setTensp(tensp);
		sp.setSoluong(soluong);
		sp.setXuatxu(xuatxu);
		sp.setThuonghieu(thuonghieu);
		sp.setGiakhoidiem(giakhoidiem);
		sp.setGiahientai(0.0);
		sp.setBuocgia(buocgia);
		sp.setNguoidat("");
		sp.setThoigianbatdau(thoigianbatdau);
		sp.setThoigianketthuc(thoigianketthuc);
		sp.setThongtinlienhe(thongtinlienhe);
		if (!hinhanh.equals("null")) {
			sp.setHinhanh(hinhanh);
		}
		sp.setMota(mota);
		if (sp.getTinhtrangdaugia() == 2)
			sp.setTinhtrangdaugia(4);
		EntityManagerHelper.beginTransaction();
		spdao.update(sp);
		EntityManagerHelper.commit();
		return "Cập nhật thành công";
	}

	@POST
	@Path("/findBySanPhamThamGiaKetThuc")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamThamGiaKetThuc() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamThamGiaKetThuc(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamThamGiaDangDau")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamThamGiaDangDau() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamThamGiaDangDau(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamChienThangAll")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamChienThangAll() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamChienThangAll(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamChienThangChuaThanhToan")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamChienThangChuaThanhToan() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamChienThangChuaThanhToan(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamChienThangDaThanhToan")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamChienThangDaThanhToan() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamChienThangDaThanhToan(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamCuaToiDangDau")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamCuaToiDangDau() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamCuaToiDangDau(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamCuaToiBiHuy")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamCuaToiBiHuy() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamCuaToiBiHuy(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamCuaToiSapDau")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamCuaToiSapDau() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamCuaToiSapDau(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamCuaToiDaDauXong")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public List<model.Sanpham> findBySanPhamCuaToiDaDauXong() {
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao
				.findBySanPhamCuaToiDaDauXong(username);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/xoaSanPham")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterUser.class })
	public String xoaSanPham(@FormParam("masp") Long masp) {
		SanphamDAO spdao = new SanphamDAO();
		dao.Sanpham daosp = spdao.findById(masp);
		if (daosp.getThoigianbatdau().getTime() < (new Date()).getTime()
				|| daosp.getTinhtrangdaugia() != 0) {
			return "Sản phẩm này không thể xóa";
		}
		EntityManagerHelper.beginTransaction();
		spdao.delete(daosp);
		EntityManagerHelper.commit();
		return "ok";
	}

	@POST
	@Path("/huyDauGia")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterAdmin.class })
	public String huyDauGia(@FormParam("masp") Long masp,
			@FormParam("ghichu") String ghichu) {
		SanphamDAO spdao = new SanphamDAO();
		dao.Sanpham daosp = spdao.findById(masp);
		if (daosp.getTinhtrangdaugia() != 0)
			return "Không thể hủy đấu giá sản phẩm này";// dieu kien
		daosp.setTinhtrangdaugia(2);
		daosp.setGhichu(ghichu);
		EntityManagerHelper.beginTransaction();
		spdao.update(daosp);
		EntityManagerHelper.commit();
		return "ok";
	}

	@POST
	@Path("/choPhepDauGia")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterAdmin.class })
	public String choPhepDauGia(@FormParam("masp") Long masp) {
		SanphamDAO spdao = new SanphamDAO();
		dao.Sanpham daosp = spdao.findById(masp);
		if (daosp.getTinhtrangdaugia() != 4)
			return "Sản phẩm không đúng";
		daosp.setTinhtrangdaugia(0);
		daosp.setGhichu("");
		EntityManagerHelper.beginTransaction();
		spdao.update(daosp);
		EntityManagerHelper.commit();
		return "ok";
	}

	@POST
	@Path("/findBySanPhamHuyAdmin")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterAdmin.class })
	public List<model.Sanpham> findBySanPhamHuyAdmin(
			@FormParam("tinhtrang") int tinhtrang) {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findBySanPhamHuyAdmin(tinhtrang);
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

	@POST
	@Path("/findBySanPhamChoPhepDauAdmin")
	@Produces("application/json; charset=utf-8")
	@ResourceFilters({ FilterAdmin.class })
	public List<model.Sanpham> findBySanPhamChoPhepDauAdmin() {
		List<model.Sanpham> pojodssp = new ArrayList<model.Sanpham>();
		dao.SanphamDAO sanphamdao = new dao.SanphamDAO();
		List<dao.Sanpham> daodssp = sanphamdao.findBySanPhamChoPhepDauAdmin();
		for (dao.Sanpham daosp : daodssp) {
			model.Sanpham pojosp = new model.Sanpham(daosp.getMasp(),
					daosp.getTensp(), daosp.getTinhtrangsp()
							.getTentinhtrangsp(), daosp.getSoluong(),
					daosp.getXuatxu(), daosp.getThuonghieu(), daosp.getLoaisp()
							.getTenloaisp(), daosp.getNguoidang(),
					daosp.getGiakhoidiem(), daosp.getGiahientai(),
					daosp.getNguoidat(), daosp.getBuocgia(), daosp
							.getThoigianbatdau().getTime(), daosp
							.getThoigianketthuc().getTime(),
					daosp.getThongtinlienhe(), daosp.getHinhthucthanhtoan()
							.getTenhttt(), daosp.getHinhanh(), daosp.getMota(),
					daosp.getTinhtrangdaugia(), daosp.getGhichu());
			pojodssp.add(pojosp);
		}
		return pojodssp;
	}

}