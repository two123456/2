package com.superhero.netctoos.util;

import java.util.ArrayList;
import java.util.List;

public class SqlCombo {
	private String head;
	private List<String> conditions = new ArrayList<String>();
	private List<String> orders = new ArrayList<String>();
	private String group = "";
	private String having = "";
	private String limit = "";
	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public List<String> getConditions() {
		return conditions;
	}

	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getHaving() {
		return having;
	}

	public void setHaving(String having) {
		this.having = having;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public SqlCombo(String head) {
		this.head = head;
	}

	/**
	 * 
	 * @param judge 判断条件，可以是条件表达式,例如  startDate ！= null,也可以是boolean值，为真时拼接条件
	 * @param column 列名
	 * @param date 传入的日期,可以是Date或者字符串
	 * @param compare 比较方式   >,<,>=,<=
	 */
	public void addDateCondition(boolean judge, String column,Object date, String compare) {
		this.conditions.add(" and " + column + compare +" '" + date +"'");
	}
	/**
	 * 动态拼接条件sql语句
	 * @param judge 条件表达式,例如  userName ！= null,也可以是boolean值，为真时拼接条件
	 * @param column 列名
	 * @param param 参数
	 */
	public void addStringEqualCondition(boolean judge, String column,String param) {
		if(judge) {
			this.conditions.add(" and " + column + "='" + param +"'");
		}		
	}
	/**
	 * 动态拼接like条件sql语句
	 * @param judge 条件表达式,例如  userName ！= null,也可以是boolean值，为真时拼接条件
	 * @param column 列名
	 * @param param 参数
	 * @param position %放置的位置,left/right/all
	 */
	public void addStringLikeCondition(boolean judge, String column,String param, String position) {
		if(judge) {
			if(position != null && position.toUpperCase().equals("LEFT")) {
				this.conditions.add(" and " + column + " like '%" + param +"'");
			}else if(position != null && position.toUpperCase().equals("RIGHT")){
				this.conditions.add(" and " + column + " like '" + param +"%'");
			}else if(position != null && position.toUpperCase().equals("ALL")){
				this.conditions.add(" and " + column + " like '%" + param +"%'");
			}			
		}		
	}

	/**
	 * 添加数字条件
	 * @param judge 判断条件，可以是条件表达式,例如  totalNumber ！= 0,也可以是boolean值，为真时拼接条件
	 * @param column 列名
	 * @param param 传入的参数
	 * @param compare 比较方式   >,<,>=,<=
	 */
	public void addNumberCondition(boolean judge, String column, int param, String compare) {
		if(judge) {
			this.conditions.add(" and " + column + compare + param);
		}		
	}
	/**
	 * 添加排序条件
	 * @param column 需要排序的列名
	 * @param rule 排序规则，desc 或 asc
	 */
	public void addOrder(String column, String rule) {
		orders.add(column + " " + rule);
	}
	/**
	 * 添加分组条件
	 * @param column 分组的列
	 */
	public void addGroup(String column) {	
		group = " group by " + column;
	}
	/**
	 * 添加having语句块
	 * @param sentence 语句 例如:  having class_name='J156'
	 */
	public void addHavingSentence(String sentence) {
		having = " " + sentence;
	}
	/**
	 * 添加limit语句块
	 * @param startResult 起始下标
	 * @param rows 返回列数
	 */
	public void addLimit(int startResult, int rows) {
		limit = " limit " + startResult + "," + rows;
	}
	
}
