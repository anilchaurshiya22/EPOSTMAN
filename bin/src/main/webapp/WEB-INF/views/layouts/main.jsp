<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-PostMan</title>
<link rel="stylesheet" href="resource/css/foundation.css"></link>
<link rel="stylesheet" href="resource/css/main.css"></link>
</head>
<body>
	<div class="row">
		<div class="small-8 small-centered columns">
			<header>
			<div class="icon-bar five-up">
				<a class="item"> <img src="resource/images/home.png">
					<label>Home</label>
				</a> <a class="item"> <img
					src="../assets/img/images/fi-bookmark.svg"> <label>Bookmark</label>
				</a> <a class="item"> <img src="../assets/img/images/fi-info.svg">
					<label>${abc}</label>
				</a> <a class="item"> <img src="../assets/img/images/fi-mail.svg">
					<label>Mail</label>
				</a> <a class="item"> <img src="../assets/img/images/fi-like.svg">
					<label>Like</label>
				</a>
			</div>
			</header>
			<section>
			<jsp:include page="../partials/${partials}.jsp" />
			</section>
			<footer>
				<div class="small-4 small-centered columns">copyright 2014</div>
			</footer>
		</div>
	</div>
</body>
</html>