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
		$("#quanlydg").click(function() {
			var xmlhttp =new XMLHttpRequest();
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
				  $("#content").load("${pageContext.request.contextPath}/resources/fragment/qldg.jsp");
			    }
			  }
			xmlhttp.open("GET",$("#urlhidden").val(),true);
			xmlhttp.send();
				
		});
	});
</script>
<div class="adminPage">
	<input id="urlhidden" type="hidden"
		value="${pageContext.request.contextPath}/admin?qldg" />
	<div id="content">
		
	</div>
	<ul id="menu">
		<li class="titleList">Admin</li>
		<li><a id="quanlydg">Quản lý bảng đánh giá</a></li>
		<li><a href="">Quản lý User</a>
			<ul>
				<li><a href="#">Quản lý User</a></li>
				<li><a href="#">Gán Quyền User</a></li>
				<li><a href="#">Import User</a></li>
			</ul></li>
		<li><a onclick="caidat()">Cài đặt đánh giá</a></li>
	</ul>

</div>
