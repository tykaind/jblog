package com.javaex.vo;

public class BlogVo {
	
	private String id; //유저아이디
	private String userName; //유저이름
	private String blogTitle; //블로그 타이틀
	private String logoFile; //블로그 로고이미지경로
	private String cateNo; //카테고리 식별번호
	private String cateName; //카테고리 이름
	private String postTitle; //글제목
	private String regDate; //글작성일 
	
	
	public BlogVo() {}
	
	

	public BlogVo(String id, String userName, String blogTitle, String logoFile) {
		this.id = id;
		this.userName = userName;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
	}



	public BlogVo(String id, String userName, String blogTitle, String logoFile, String cateNo, String cateName,
			String postTitle, String regDate) {
		this.id = id;
		this.userName = userName;
		this.blogTitle = blogTitle;
		this.logoFile = logoFile;
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.postTitle = postTitle;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}

	public String getCateNo() {
		return cateNo;
	}

	public void setCateNo(String cateNo) {
		this.cateNo = cateNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", userName=" + userName + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile
				+ ", cateNo=" + cateNo + ", cateName=" + cateName + ", postTitle=" + postTitle + ", regDate=" + regDate
				+ "]";
	}
	
	
	

	
	
	
	
	
	
}
	
	