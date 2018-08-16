package com.superhero.netctoos.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.superhero.netctoos.enmu.LoginEnum;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLogin {
	/**
	 * operateType 代表操作类型
	 * 0-登陆，1-退出
	 * @return
	 */
	LoginEnum operateType();
}
