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
	<div class="container">
		<div class="row">
			<div class="col">
				<h3>${board.id }번 게시물</h3>				
				<form action="${appRoot }/ex15/board/modify" method="post">
					<input type="hidden" name="id" value="${board.id }"/>
					<div>
						<label class="form-label" for="input1">제목</label>
						<input class="form-control" type="text" name="title" required
							id="input1" value="${board.title }" />
					</div>
					<div>
						<label class="form-label" for="textarea1">본문</label>
						<textarea class="form-control" name="body" id="textarea1"
							cols="30" rows="10" >${board.body }</textarea>
					</div>
					<div>
						<label class="form-label" for="input2">작성일시</label>
						<input class="form-control" type="datetime-local"
							value="${board.inserted }" readonly />
					</div>
					<button id="edit-button" class="btn btn-primary">수정</button>
				</form>
				
				<c:url value="/ex15/board/remove" var="removeLink"></c:url>
				<form action="${removeLink }" method="post">
					<input type="hidden" name="id" value="${board.id }"/>
					<button id="delete-button" class="btn btn-danger">삭제</button>				
				</form>
				
				<hr />
				
				<h3>댓글</h3>
				<c:url value="/ex16/reply/add" var="replyAddLink"></c:url>
				<form action="${replyAddLink }" method="post">
					<input type="hidden" name="boardId" value="${board.id }"/>
					댓글 : <input type="text" name="content" size="50"/>
					
					<button>쓰기</button>
				</form>
				
				<hr />
				
				<div>
					<c:forEach items="${replyList }" var="reply">
						<div style="border : 1px solid black; margin-bottom : 3px">
							${reply.inserted } :
							
							<c:url value="/ex16/reply/modify" var="replyModifyLink"></c:url> 
							<form action="${replyModifyLink }" method="post">
								<input type="hidden" value="${board.id }"/>
								<input type="hidden" value="${reply.id }"/>
								<input type="text" value="${reply.content }"/>
								<button>수정</button>
							</form>							
							<c:url value="/ex16/reply/remove" var="replyRemoveLink"></c:url>
							<form action="${replyRemoveLink }" method="post">
								<input type="hidden" name="id" value="${reply.id }"/>
								<input type="hidden" name="boardId" value="${board.id }"/>
								<button>삭제</button>
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>