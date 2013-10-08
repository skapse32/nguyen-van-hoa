<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function pad(d) {
		return (d < 10) ? '0' + d.toString() : d.toString();
	}
</script>
<script type="text/javascript">
	//
	var timer;
	$(function() {
		timer = setInterval(vartimertick, 1000);
	});
	function vartimertick() {
		// get the form values
		var maLoaiSP = $('#maLoaiSP').val();
		var size = $('#size').val();
		var page = $('#page').val();
		$.ajax({
			type : "POST",
			url : "/AuctionWebApp/loaddssanphamdangdau",
			data : "maLoaiSP=" + maLoaiSP + "&size=" + size + "&page=" + page,
			success : function(data) {
				// we have the response
				var dsspList = jQuery.parseJSON(data);
				$
						.each(dsspList,
								function(index, element) {
									var x = numeral(element.giahientai).format(
											'0,0');
									x = x.replace(/,/g, ".");

									document.getElementById("giahientai"
											+ element.masp).innerHTML = x
											+ "&nbsp;đ";
								});

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	};
</script>
<form action="${pageContext.request.contextPath}/sanphamdangdau" >
	<div class="Column3">
		<h2 id="CategoryList" class="h2row">DANH MỤC</h2>
		<ul class="CategoriesList">
			<c:choose>
				<c:when test="${sessionScope.dsloaisp != null}">
					<c:forEach var="lsp" items="${sessionScope.dsloaisp}">
						<c:choose>
							<c:when test="${lsp.maloaisp == maLoaiSP}">
								<li class="CategoryList" style="background-color: gainsboro;"><a
									href="${pageContext.request.contextPath}/sanphamdangdau?maLoaiSP=${lsp.maloaisp}&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;${lsp.tenloaisp}</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="CategoryList"><a
									href="${pageContext.request.contextPath}/sanphamdangdau?maLoaiSP=${lsp.maloaisp}&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;${lsp.tenloaisp}</a>
								</li>
							</c:otherwise>
						</c:choose>

					</c:forEach>
					<c:choose>
							<c:when test="${-1 == maLoaiSP}">
								<li class="CategoryList" style="background-color: gainsboro;"><a
						href="${pageContext.request.contextPath}/sanphamdangdau?maLoaiSP=-1&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;Tất
							cả</a></li>
							</c:when>
							<c:otherwise>
								<li class="CategoryList"><a
						href="${pageContext.request.contextPath}/sanphamdangdau?maLoaiSP=-1&trang=${trang}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">+&nbsp;Tất
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
			<li class="CategoryList" style="background-color: gainsboro;"><a
						href="${pageContext.request.contextPath}/sanphamdangdau">+&nbsp; Sản phẩm đang đấu giá</a></li>
			<li class="CategoryList"><a
						href="${pageContext.request.contextPath}/sanphamsapdau">+&nbsp; Sản phẩm sắp đấu giá</a></li>
			<li class="CategoryList"><a
						href="${pageContext.request.contextPath}/sanphamdadau">+&nbsp; Sản phẩm đã đấu giá</a></li>
			
		</ul>
	</div>
	<!-- InstanceBeginEditable name="MainRegion" -->
	<div class="Column9">
		<h2 id="HomepageFeaturedList" class="h2row" style="text-align: center">${tieude}</h2>
		<div id="error" style="color: red;"></div>
		<div>
			<table width="100%">
				<tr>
					<td width="70%" align="center"><label style="">Trang
							&nbsp;</label> <c:forEach var="i" begin="1" end="${soTrang}" step="1">
							<a style="color:#00C"
								href="${pageContext.request.contextPath}/sanphamdangdau?maLoaiSP=${maLoaiSP}&trang=${i}&soLuongSanPhamTrenTrang=${soLuongSanPhamTrenTrang}">

								<c:choose>
									<c:when test="${i==trang}">
										<input type="button" value="${i}"
											style="width: 25px;background-color: inactivecaption" />
									</c:when>
									<c:otherwise>
										<input type="button" value="${i}" style="width: 25px" />
									</c:otherwise>
								</c:choose> </a>
						</c:forEach></td>
					<td width="30%" align="right"><label
						for="soLuongSanPhamTrenTrang">Số lượng</label> <select
						name="soLuongSanPhamTrenTrang" onchange="submit()">
							<c:forEach var="i" begin="1" end="5">
								<option
									<c:if test="${i*8 == soLuongSanPhamTrenTrang}" >
		                                selected="selected"
		                            </c:if>
									value="${i*8}">${i*8}</option>
							</c:forEach>
							<option
								<c:if test="${soLuongSanPhamTrenTrang==-1}" >
		                            selected="selected"
		                        </c:if>
								value="-1">Tất cả</option>
					</select></td>
				</tr>
			</table>
		</div>


		<c:forEach var="sp" items="${dssp}">

			<div class="HomePageFeaturedItem">
				<div style="width: 148px;height: 45px;position: relative;">
					<h1>${sp.tensp}</h1>
				</div>
				<a
					href="${pageContext.request.contextPath}/chitietsanpham?masp=${sp.masp}"><img
					src="${imageDirectory}${sp.hinhanh}" height="150" width="150">
				</a>

				<div id="giahientai${sp.masp}"
					style="color: #2DAB00;font-size: 16px;font-weight: bold;"></div>
				<div align="center" class="HomePageFeaturedItem_time">
					<input type="hidden" id="time${sp.masp}"
						value="${sp.thoigianketthuc}">
					<div id="Countdown${sp.masp}"
						style="color: blue;font-size: 14px;font-weight: bold;"></div>

					<script type="text/javascript">
						$(function() {
							var stringday = $('#time${sp.masp}').val()
									.toString();
							var longday = Number(stringday);
							var BigDay = new Date(longday);
							var msPerDay = 24 * 60 * 60 * 1000;
							window
									.setInterval(
											function() {
												var today = new Date();
												var timeLeft = (BigDay
														.getTime() - today
														.getTime());
												if (Math.floor(timeLeft) > 0) {
													var e_daysLeft = timeLeft
															/ msPerDay;
													var daysLeft = pad(Math
															.floor(e_daysLeft));
													var e_hrsLeft = (e_daysLeft - daysLeft) * 24;
													var hrsLeft = pad(Math
															.floor(e_hrsLeft));
													var e_minsLeft = (e_hrsLeft - hrsLeft) * 60;
													var minsLeft = pad(Math
															.floor(e_minsLeft));
													var e_secsLeft = (e_minsLeft - minsLeft) * 60;
													var secsLeft = pad(Math
															.floor(e_secsLeft));
													var timeString = daysLeft
															+ " ngày "
															+ hrsLeft + ":"
															+ minsLeft + ":"
															+ secsLeft;
													$('#Countdown${sp.masp}')
															.html(timeString);
												} else {
													//var timeString = "00 ngày " + "00:" +  "00:00";
													var timeString = "kết thúc";
													$('#Countdown${sp.masp}')
															.html(timeString);
													document
															.getElementById('Countdown${sp.masp}').style.color = 'red'; //'none';
													document
															.getElementById('bid${sp.masp}').style.visibility = 'hidden';
												}
											}, 1000);
						});
					</script>
				</div>
				<div id="bid${sp.masp}">
					<a
						href="${pageContext.request.contextPath}/chitietsanpham?masp=${sp.masp}">
						<input type="button" value="Đặt giá"
						style="font-size: 14px;font-weight: bold;" /> </a>
				</div>
			</div>

		</c:forEach>

	</div>
	<!-- InstanceEndEditable -->
</form>
<div class="DIVclear"></div>



