<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="com.nvh.giangvien.model.BangDanhGia"%>
<%@page import="org.springframework.ui.Model,java.util.List"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	$(document).ready(function() {
		$("#save").click(function() {
			var xmlhttp =new XMLHttpRequest();
			alert($("#tenbang").val());
			xmlhttp.onreadystatechange=function()
			  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    {
				  $("#content").load("${pageContext.request.contextPath}/resources/fragment/qldg.jsp");
			    }
			  };
			xmlhttp.open("POST",$("#urlhidden").val(),true);
			xmlhttp.send($("#tenbang").val());
		});
	});
</script>
<input id="urlhidden" type="hidden" value="${pageContext.request.contextPath}/admin?form"/>
<div>
Nhập Tên Bảng Đánh Giá : <input id="tenbang" type="text" name="tenbang"/><br />
<input id="save" type="button" value="Lưu"/>
</div>