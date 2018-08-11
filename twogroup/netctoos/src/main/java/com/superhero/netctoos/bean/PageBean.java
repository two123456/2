package com.superhero.netctoos.bean;

import java.util.List;

/**
 * 分页实体类
 * @author wangyuren
 *
 */
public class PageBean {
	/**当前页码**/
	private int page;
	/**每页行数**/
	private int limit;
	/**起始位置**/
	private int index;
	private List<?> data;
	/**满足条件的总条数**/
	private int count;
	/**满足条件的总页数**/
	private int totalPage;
	
	private int code=0;
	
	private String msg;
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PageBean(int page, int limit) {
		super();
		this.page = page;
		this.limit = limit;
		index = (page-1)*limit;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getTotalPage() {
		return totalPage;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", limit=" + limit + ", index=" + index + ", data=" + data + ", count="
				+ count + ", totalPage=" + totalPage + ", code=" + code + ", msg=" + msg + "]";
	}



	
}
