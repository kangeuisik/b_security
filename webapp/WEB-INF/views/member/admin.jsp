<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>관리자</h1>		
	</div>
	<form action="${contextPath }/member/updateMemberType" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<table class="table">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>회원등급</th>
				<th>상태</th>
			</tr>
			<c:forEach items="${list }" var="m" varStatus="mst">
				<c:if test="${m.authList[0].memberType!=mType[0] }">
					<tr>
						<td>${m.mno }</td>
						<td>${m.memberId }
							<input type="hidden" name="authList[${mst.index}].memberId" value="${m.memberId }">
						</td>
						<td>${m.email }</td>
						<td>
							<select name="authList[${mst.index}].memberType"><!-- name값이 다 달라야하기 때문에 인덱스번호 지정 -->
								<c:forEach items="${mType }" var="type">
									<option value="${type }"${m.authList[0].memberType==type ? 'selected':'' }>${type.name }</option>
								</c:forEach>
							</select>
						</td>
						<td>${m.enabled }</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<button class="btn btn-info">변경하기</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>
<script>
let updateMember = "${updateMember}";
if(updateMember!='') alert(updateMember)
</script>