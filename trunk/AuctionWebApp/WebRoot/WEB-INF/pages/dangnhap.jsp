<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="Column3">
		<h2 id="CategoryList" class="h2row">DANH MỤC</h2>
		<ul class="CategoriesList">
			<c:choose>
				<c:when test="${sessionScope.dsloaisp != null}">
					<c:forEach var="lsp" items="${sessionScope.dsloaisp}">
						<c:choose>
							<c:when test="${lsp.maloaisp == maLoaiSP}">
								<li class="CategoryList" style="background-color: gainsboro;"><a
									href="${pageContext.request.contextPath}/sanphamdadau?maLoaiSP=${lsp.maloaisp}&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;${lsp.tenloaisp}</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="CategoryList"><a
									href="${pageContext.request.contextPath}/sanphamdadau?maLoaiSP=${lsp.maloaisp}&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;${lsp.tenloaisp}</a>
								</li>
							</c:otherwise>
						</c:choose>

					</c:forEach>
					<c:choose>
						<c:when test="${-1 == maLoaiSP}">
							<li class="CategoryList" style="background-color: gainsboro;"><a
								href="${pageContext.request.contextPath}/sanphamdadau?maLoaiSP=-1&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;Tất
									cả</a></li>
						</c:when>
						<c:otherwise>
							<li class="CategoryList"><a
								href="${pageContext.request.contextPath}/sanphamdadau?maLoaiSP=-1&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;Tất
									cả</a></li>
						</c:otherwise>
					</c:choose>

				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

		</ul>
		<input type="hidden" id="maLoaiSP" name="maLoaiSP" value="${maLoaiSP}">
		<input type="hidden"  id="page" name="trang" value="${trang}"> <input
			type="hidden" id="size" value="${soLuongSanPhamTrenTrang}">
		<h2 id="RegionList" class="h2row">SẢN PHẨM ĐẤU GIÁ</h2>
		<ul class="CategoriesList">
			<li class="CategoryList"><a
				href="${pageContext.request.contextPath}/sanphamdangdau">+&nbsp;
					Sản phẩm đang đấu giá</a></li>
			<li class="CategoryList"><a
				href="${pageContext.request.contextPath}/sanphamsapdau">+&nbsp;
					Sản phẩm sắp đấu giá</a></li>
			<li class="CategoryList" style="background-color: gainsboro;"><a
				href="${pageContext.request.contextPath}/sanphamdadau">+&nbsp;
					Sản phẩm đã đấu giá</a></li>

		</ul>
	</div>
<div class="Column9">
	<div style="text-align: center">
		<div id="SignIn">
			<h2 class="h2row">
				Đăng nhập<br>
			</h2>
			<form
				action="${pageContext.request.contextPath}/dangnhap?action=dangnhap"
				method="post">
				<br />
				<table style="font-size: 11pt">
					<tr>
						<td width="300px" style="text-align: right; vertical-align: middle;">T&ecirc;n 
							đăng nhập&nbsp;&nbsp; <br></td>
						<td width="167"><input id="username" name="username"
							size="25" type="text" value="" /></td>
						<td width="269">&nbsp;</td>
					</tr>
					<tr></tr>
					<tr valign="middle">
						<td style="text-align: right; vertical-align: middle;">Mật
							khẩu&nbsp;&nbsp;</td>
						<td><input id="password" name="password" size="25"
							type="password" value="" /></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td valign="top"><br></td>
						<td colspan="2" valign="top"><label style="color: Red">${error}</label>
						</td>
					</tr>
				</table>
				<div align="center">
					<input type="submit" value="Đăng nhập" id="btnDangNhap" />
				</div>
			</form>
		</div>
		<!-- InstanceEndEditable -->
	</div>
	<div class="DIVclear"></div>
</div>
