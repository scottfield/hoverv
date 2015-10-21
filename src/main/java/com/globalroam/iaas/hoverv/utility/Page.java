package com.globalroam.iaas.hoverv.utility;

import java.util.List;

/**
 * Copyright (C), 2002-2012, www.globalroam.com.cn
 * 
 * @Author : jiepeng Description :
 * 
 * @Data : 2012-11-6
 * 
 */
public class Page<T> {
	// private String
	/**
	 * 每页记录数
	 */
	public int pagesize = 10;
	/**
	 * 默认开始序列，值为0
	 */
	public int defaultStartIndex = 0; // 
	/**
	 * 总记录数
	 */
	private int totalCounts = 0; // 
	/**
	 * 总页数
	 */
	private int pageCount = 0; // 
	/**
	 * 开始序列，0开始
	 */
	private int startIndex = 0; // 
	/**
	 * 当前页数
	 */
	private int pageNum = 1; // 
	/**
	 * 开始页数
	 */
	private int startPage = 1; //
	/**
	 * 结束页数
	 */
	private int endPage = 1;	//
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	private List<T> datas;

	/**
	 * 初始化分页类
	 */
	public Page() {
	}
	/**
	 * 初始化 分页类
	 * @param pagesize
	 */
	public Page(int pagesize) {
		this.pagesize = pagesize < 1 ? 1 : pagesize;
	}
	
	public Page(int pageNum,int pagesize) {
		this.pagesize = pagesize < 1 ? 1 : pagesize;
		this.pageNum = pageNum < 1?1:pageNum;
	}
	/**
	 * 初始化 分页类
	 * @param pagesize
	 */
	public Page(int pagesize,int totalCounts, int pageNum,List<T> dataList) {
		this.pagesize = pagesize < 1 ? 1 : pagesize;
		processInit(totalCounts,pageNum,dataList,this.pagesize);
	}
	/**
	 * 对分页进行预算
	 * @param totalCounts 总记录数
	 * @param pageNum 当前页数
	 */
	public void execute(int totalCounts, int pageNum,List<T> dataList ) {
		processInit(totalCounts,pageNum,dataList,this.pagesize);
	}
	
	/**
	 * 对分页进行预算
	 * @param totalCounts 总记录数
	 * @param pageNum 当前页数
	 * @param pageCount 每页显示记录条数
	 */
	public void execute(int totalCounts, int pageNum,List<T> dataList,int pagesize ) {
		processInit(totalCounts,pageNum,dataList,pagesize);
	}
	/**
	 * 计算分页过程
	 * @param totalCounts
	 * @param pageNum
	 * @param dataList
	 * @param pagesize
	 */
	private void processInit(int totalCounts, int pageNum,List<T> dataList,int pagesize){
		this.datas = dataList;
		pagesize = pagesize < 1 ? this.pagesize : pagesize;
		this.pagesize = pagesize;
		this.totalCounts = totalCounts;
		int mod = this.totalCounts % this.pagesize;
		int result = this.totalCounts / this.pagesize;
//		System.out.println("pagesize:" + pagesize);
//		System.out.println("totalCounts:" + totalCounts);
//		System.out.println("mod:" + mod);
//		System.out.println("result:" + result);
//		System.out.println(result);
		this.pageCount = mod == 0 ? result : result + 1;
		this.startIndex = getOffset(pageNum);
		if(pageNum > 1) this.pageNum = pageNum;
		
		//calculate startPage and endPage.
		//default show 10 pages.
		if(this.pageCount <= 10) {
			this.startPage = 1;
			this.endPage = this.pageCount;
		}
		if(this.pageCount > 10) {
			this.startPage = this.pageNum - 4;
			this.endPage = this.pageNum + 5;
			if(this.startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if(this.endPage > this.pageCount) {
				this.startPage = this.pageCount -9;
				this.endPage = this.pageCount;
			}
		}
	}
	
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
	}
	public int getCurrentPage() {
		return pageNum;
	}
	public void setCurrentPage(int currentPage) {
		this.pageNum = currentPage;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPageCount() {
		return this.pageCount;
	}

	public int getStartIndex() {
		return this.startIndex;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getOffset(int currentPage) {
		int index = (currentPage - 1) * this.pagesize;
		return index = index < 0 ? 0 : index;
	}

	public int getDefaultStartIndex() {
		return defaultStartIndex;
	}
	public void setDefaultStartIndex(int defaultStartIndex) {
		this.defaultStartIndex = defaultStartIndex;
	}
	/*public static void main(String[] args) {
		Page page = new Page();
		page.execute(30, 1,null);
		System.out.println("page.getPageCount():"+page.getPageCount());
		System.out.println("page.getStartIndex():"+page.getStartIndex());
		System.out.println("Page.perPageCount:"+page.getPagesize());
	}*/
}
