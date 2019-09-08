package com.newer.olympia.util;

import java.util.List;

//封装当前页的所有数据
public class Pager<T> {
	public  int pageSize  ;  //每页的显示大小
	private List<T> datas;//当前页的结果集
	private int pageNo; //当前页码
	private int totalno; //总页数
	private int totalsize;//数据总条数

	public  int getPageSize() {
		return pageSize;
	}

	public  void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalno() {
		return totalno;
	}

	public void setTotalno(int totalno) {
		this.totalno = totalno;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	@Override
	public String toString() {
		return "Pager{" +
				"datas=" + datas +
				", pageNo=" + pageNo +
				", totalno=" + totalno +
				", totalsize=" + totalsize +
				'}';
	}
}
