<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js" integrity="sha512-OvBgP9A2JBgiRad/mM36mkzXSXaJE9BEIENnVEmeZdITvwT09xnxLtT4twkCa8m/loMbPHsvPl0T8lRGVBwjlQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Customer LIST</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Customer Name</th>
				<th>Contact Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Country</th>
				<th>Postal Code</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${customerList }" var="cs">
				<tr>
					<th>${cs.id }</th>
					<td>${cs.customerName }</td>
					<td>${cs.contactName }</td>
					<td>${cs.address }</td>
					<td>${cs.city }</td>
					<td>${cs.country }</td>
					<td>${cs.postalCode }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav>
		<ul class="pagination justify-content-center">
			<c:if test="${prevPage >= 1 }">
				<li class="page-item">
					<a href="sub08?page=${prevPage }" class="page-link">
						<span>&laquo;</span>
					</a>
				</li>
			</c:if>
			<c:forEach begin="${startPage }" end="${endPage }" var="page">
				<li class="page-item ${page == currentPage ? 'active' : '' }">
					<a href="sub08?page=${page }" class="page-link">${page }</a>
				</li>
			</c:forEach>
			<c:if test="${endPage != lastPage }">
				<li class="page-item">
					<a href="sub08?page=${nextPage }" class="page-link">
						<span>&raquo;</span>
					</a>
				</li>
			</c:if>
		</ul>
	</nav>
</body>
</html>