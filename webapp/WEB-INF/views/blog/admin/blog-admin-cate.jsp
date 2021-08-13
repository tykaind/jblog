<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/cate">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
	 
					</tbody>
				</table>

		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="catename" type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input id="catedesc" type="text" name="desc"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>

			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>


<script type="text/javascript">

$(document).ready(function() {
	console.log("화면 로딩 직전");
	//ajax 요청하기
	fetchList();
});


	
$("#btnAddCate").on("click", function(){
	event.preventDefault();
	console.log("등록버튼 클릭");
	
	var categoryVo = {
			id: "${authUser.id}",
			cateName: $("[name=name]").val(),
			description: $("[name=desc]").val()
		}
	
	//데이터 ajax방식으로 서버에 전송
	$.ajax({
		url : "${pageContext.request.contextPath}/${authUser.id}/admin/cateinsert",
		type : "post",
		//contentType : "application/json",
		data : categoryVo,
		
		dataType : "json",
		success : function(addcategory){
			render(addcategory, "up");
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
});

$("#cateList").on("click", ".btnCateDel", function() {
	console.log("삭제버튼 클릭");
	
	var cateNo = $(this).data("no");
	
	console.log(cateNo);
	
	//ajax로 삭제
	$.ajax({
		url : "${pageContext.request.contextPath }/admin/catedelect",
		type : "post",
		data : {cateNo: cateNo},
		
		dataType : "json",
		success : function(count){
			/*성공시 처리해야될 코드 작성*/
			console.log(count);
			
			if(count === 1) {
				$("#t-"+cateNo).remove();
			} else {
				alert("삭제할 수 없습니다.");
			}
		
		
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
});

//리스트가져오기
function fetchList(){
	
	$.ajax({
		url : "${pageContext.request.contextPath }/${authUser.id}/admin/categoryList",
		type : "post",
		
		success : function(categoryList) {
		
			for (var i = 0; i < categoryList.length; i++) {
				render(categoryList[i], "down");
			}
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	
}






function render(addcategory, type) {
	var str = "";
	str += '<tr id="t-'+ addcategory.cateNo +'">';
	str += '	<td>' + addcategory.cateNo + '</td>';
	str += '	<td>' + addcategory.cateName + '</td>';
	str += '	<td>' + addcategory.cateP + '</td>';
	str += '	<td>' + addcategory.description + '</td>';
	str += '	<td class="text-center">';
	str += '		<img class="btnCateDel" data-no="'+ addcategory.cateNo +'" src="${pageContext.request.contextPath}/assets/images/delete.jpg">';
	str += '	</td>';
	str += '</tr>';


	if (type === 'down') {
		$("#cateList").append(str);
	} else if (type === 'up') {
		$("#cateList").prepend(str);
	} else {
		console.log("방향오류");
	}
	
}
</script>
</html>