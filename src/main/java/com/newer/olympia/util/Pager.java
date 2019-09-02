package com.newer.olympia.util;

import com.newer.olympia.domain.SyjBlgos;

import java.util.List;

//封装当前页的所有数据
public class Pager<T> {
	public static int pageSize  ;  //每页的显示大小
	private List<SyjBlgos> result;//当前页的结果集
	private int pageNo; //当前页码
	private int totlaPage; //总页数

	public static void setPageSize(int pageSize) {
		Pager.pageSize = pageSize;
	}
	public List<SyjBlgos> getResult() {
		return result;
	}
	public void setResult(List<SyjBlgos> result) {
		this.result = result;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotlaPage() {
		return totlaPage;
	}
	public void setTotlaPage(int totlaPage) {
		this.totlaPage = totlaPage;
	}

	
}
