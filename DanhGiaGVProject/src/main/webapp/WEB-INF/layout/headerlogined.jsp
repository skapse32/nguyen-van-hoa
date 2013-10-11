<%@page import="com.nvh.giangvien.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<nav>
	<div class="inside nav">
		<ul id="topnav">

			<li><a href="SinhVien.do"> <img src="images/home.png"
					border="0px" />
				<p>Trang Chủ</p>
			</a></li>

			<li><a href="SVKhoaHoc.do"> <img src="images/briefcase.png"
					border="0px" />
				<p>Khóa Học</p>
			</a></li>

			<li><a href="SVThongBao.do"> <img
					src="images/megaphone.png" border="0px" />
				<p>Thông Báo</p>
			</a></li>

			<li><a href="DienDan.do"> <img src="images/comments.png"
					border="0px" />
				<p>Diễn Đàn</p>
			</a></li>

			<li><a href="SVSiteMap.do"> <img src="images/network.png"
					border="0px" />
				<p>SiteMap</p>
			</a></li>

			<li><a href="SVCaNhan.do"> <img src="images/info.png"
					border="0px" />
				<p>Cá Nhân</p>
			</a></li>

			<li><a href="${pageContext.request.contextPath}/login?action=logout"> <br /> Thoát <br />
					<span>(Chào: <%=((User)session.getAttribute("account")).getHoten() %> )</span></a></li>

		</ul>
	</div>
</nav>
