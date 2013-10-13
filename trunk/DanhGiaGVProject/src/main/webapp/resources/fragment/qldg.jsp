<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="com.nvh.giangvien.model.BangDanhGia"%>
<%@page import="org.springframework.ui.Model,java.util.List"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script>
	$(document).ready(function() {
		$("#them").click(function() {
			$("#content").load("${pageContext.request.contextPath}/resources/fragment/ThemForm.jsp");
		});
	});
</script>
<div>
<c:if test="${not empty danhsachdg}">
	<h1 id="titleFrame">Danh Sách Bảng Đánh Giá</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>TÊN BẢNG</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bang" items="${danhsachdg}">
				<tr>
					<td>${bang.id}</td>
					<td>${bang.tenbang}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<input id="them" type="button" value="Thêm">
<input type="button" value="Xóa">
</c:if>
</div>