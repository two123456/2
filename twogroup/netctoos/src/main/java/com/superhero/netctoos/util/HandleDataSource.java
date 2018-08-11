package com.superhero.netctoos.util;
/**
 * 利用ThreadLocal解决数据源的线程安全问题
 * @author star
 *
 */
public class HandleDataSource {
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();  
    public static void putDataSource(String datasource) {  
        holder.set(datasource);  
    }  
      
    public static String getDataSource() {  
        return holder.get();  
    }    
}
