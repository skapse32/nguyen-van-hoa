<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title><tiles:insertAttribute name="title" ignore="true" />
</title>
<link rel="stylesheet" type="text/css"
	href="/${web}/resources/css/001.css">
<link rel="stylesheet" type="text/css"
	href="/${web}/resources/css/reset.css">
<link href="/${web}/resources/css/jquery.countdown.css" rel="stylesheet"
	type="text/css" />
<link href="/${web}/resources/css/SpryValidationTextField.css"
	rel="stylesheet" type="text/css" />
<link href="/${web}/resources/css/SpryValidationPassword.css"
	rel="stylesheet" type="text/css" />
<link href="/${web}/resources/css/SpryValidationConfirm.css"
	rel="stylesheet" type="text/css" />


<script src="/${web}/resources/js/SpryValidationTextField.js"
	type="text/javascript"></script>
<script src="/${web}/resources/js/SpryValidationPassword.js"
	type="text/javascript"></script>
<script src="/${web}/resources/js/SpryValidationConfirm.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="/${web}/resources/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript"
	src="/${web}/resources/js/jquery.countdown.js"></script>
	<script type="text/javascript"
	src="/${web}/resources/js/numeral.min.js"></script>
</head>

<body>
	<div id="Container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="left" />
		<tiles:insertAttribute name="maincontent" />
		<tiles:insertAttribute name="footer" />


	</div>
</body>
</html>
