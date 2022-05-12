<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="path" %>

<nav>
	<ul class="pagination justify-content-center">
		<c:if test="${pageInfo.prev >= 1}">
			<c:url value="${path }" var="link">
				<c:param name="page" value="${pageInfo.prev }"></c:param>
			</c:url>
			<li class="page-item ">
				<a class="page-link" href="${link }"><span>&laquo;</span></a>
			</li>
		</c:if>
		<c:forEach begin="${pageInfo.left }" end="${pageInfo.right }" var="pageNum">
			<c:url value="${path }" var="link">
				<c:param name="page" value="${pageNum }"></c:param>
			</c:url>
			<li class="page-item ${pageInfo.current == pageNum ? 'active' : '' }">
				<a class="page-link" href="${link }">${pageNum }</a>
			</li>
		</c:forEach>
		<c:if test="${pageInfo.current != pageInfo.end}">
			<li class="page-item" >
				<c:url value="${path }" var="link">
					<c:param name="page" value="${pageInfo.next }"></c:param>
				</c:url>
				<a class="page-link" href="${link }"><span>&raquo;</span></a>
			</li>
		</c:if>
	</ul>
</nav>