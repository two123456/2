package com.superhero.netctoos.util;

import java.util.List;

public class SqlUtil {
	
	public static String createSql(SqlCombo combo) {
		StringBuilder sql = new StringBuilder(combo.getHead());
		sql.append(" where 1=1");
		List<String> conditions = combo.getConditions();
		for (String str : conditions) {
			sql.append(" " + str);
		}
		sql.append(" " + combo.getGroup());
		List<String> orders = combo.getOrders();
		int size = orders.size();
		if(size  > 0) {
			sql.append(" order by ");
		}
		for (int i=0;i<size ;i++) {
			sql.append(orders.get(i));
			if(i<size-1 ) {
				sql.append(",");
			}
		}
		sql.append(" " + combo.getLimit());
		return sql.toString();
	}
	
	public static void main(String[] args) {
		SqlCombo combo = new SqlCombo("select * from t_goods");
		combo.addDateCondition(5>1, "f_proDate", "2016-06-12", ">=");
		combo.addLimit(0, 3);
		combo.addGroup("pk_id");
		combo.addStringLikeCondition(3>=3, "f_proName", "张三", "all");
		System.out.println(SqlUtil.createSql(combo));
	}
	
}
