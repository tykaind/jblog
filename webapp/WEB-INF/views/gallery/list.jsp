<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.js"></script>

</head>


<body>
	<div id="wrap">

		<!-- 해더 네비 -->
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<!-- //해더 네비 -->


		<div id="container" class="clearfix">
			<!-- 게시판 aside -->
			<c:import url="/WEB-INF/views/includes/asidegallery.jsp"></c:import>
			<!-- //게시판 aside -->

			<div id="content">

				<div id="content-head">
					<h3>갤러리</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>갤러리</li>
							<li class="last">갤러리</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->

				<div id="gallery">
					<div id="list">

						<c:if test="${authUser.no != null}">
						<button id="btnImgUpload">이미지올리기</button>
						</c:if>
						<div class="clear"></div>


						<ul id="viewArea">

							<c:forEach items="${galleryList}" var="galleryList">
							<li id="t-${galleryList.no}">
								<div class="view">
									<img data-img="${pageContext.request.contextPath }/upload/${galleryList.saveName}" data-No="${galleryList.no}" data-userNo="${galleryList.userNo}" id="imgitem" class="imgItem" src="${pageContext.request.contextPath }/upload/${galleryList.saveName}">
									<div class="imgWriter">
										작성자: <strong>${galleryList.name}</strong>
									</div>
								</div>
							</li>
							</c:forEach>
							<!-- 이미지반복영역 -->


						</ul>
					</div>
					<!-- //list -->
				</div>
				<!-- //gallery -->


			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<!-- 푸터 -->
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		<!-- //푸터 -->
	</div>
	<!-- //wrap -->









	<!-- 이미지등록 팝업(모달)창 -->
	<div class="modal fade" id="addModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지등록</h4>
				</div>

				<form method="post" action="${pageContext.request.contextPath}/gallery/upload" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="form-group">
							<label class="form-text">글작성</label> <input id="addModalContent" type="text" name="content" value="">
						</div>
						<div class="form-group">
							<label class="form-text">이미지선택</label> <input id="file" type="file" name="file">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn" id="btnUpload">등록</button>
					</div>
						<input type="hidden" name="userNo" value="${authUser.no}">
				</form>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<!-- 이미지보기 팝업(모달)창 -->
	<div class="modal fade" id="viewModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이미지보기</h4>
				</div>
				<div class="modal-body">

					<div class="formgroup">
						<img id="viewModelImg" src="">
						<!-- ajax로 처리 : 이미지출력 위치-->
					</div>

					<div class="formgroup">
						<p id="viewModelContent"></p>
					</div>

				</div>
				<form method="" action="">
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="gg">닫기</button>

						<button type="button" class="btn btn-danger" id="btnDel">삭제</button>
						
						<input type="hidden" id="gno" value="">

					</div>


				</form>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->





	<script type="text/javascript">
	
	
	
	// 이미지등록 버튼 눌렀을때 모달창 띄우기 & 모달창 닫았을때 값초기화.
	$("#gallery").on("click", "#btnImgUpload", function(){

		//hidden no 입력하기
		var no = $(this).data("no");
		$("[name=no]").val(no);
		
		//content입력창 초기화
		$("#addModalContent").val("");
		
		//content입력창 초기화
		$("#file").val("");
		
		//모달창 보이기
		$("#addModal").modal();
	});
	
	//이미지 클릭시 모달창 나오게하기 & 값
	$("#gallery").on("click", "#imgitem", function(){
		
		//모달창 보이기
		$("#viewModal").modal();
		
		var img = $(this).data("img");
		$("#viewModelImg").attr({ src: img });
		
		var no = $(this).data("no");
		$("#gno").val(no);
			

	});
	
	//모델창에서 삭제버튼을 누를때
$("#viewModal").on("click","#btnDel", function(){

		var no = $("#gno").val();
		console.log(no);
		
 		//서버에 삭제요청(no 전달)
		$.ajax({
			url : "${pageContext.request.contextPath }/gallery/delect" ,
			type : "post",
			//contentType : "application/json",
			data : {no: no},
			
			dataType : "json",
			success : function(count){
				if(count === 1){
					$("#viewModal").modal("hide");
					//리스트에 삭제버튼이 있던 테이블 화면에서 지운다.
					$("#t-"+no).remove();
				}else{
					$("#viewModal").modal("hide");
				}
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	
	</script>

</body>

</html>

