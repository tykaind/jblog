package com.javaex.vo;

public class CategoryVo {

	private int cateNo;
	private String id;
	private String cateName;
	private String description;
	private String regDate;
	private int cateP;
	
	public CategoryVo() {}

	public CategoryVo(int cateNo, String id, String cateName, String description, String regDate, int cateP) {
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
		this.cateP = cateP;
	}


	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getCateP() {
		return cateP;
	}


	public void setCateP(int cateP) {
		this.cateP = cateP;
	}


	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + ", cateP=" + cateP + "]";
	}






	
	
	
	
}
