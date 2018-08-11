package com.superhero.netctoos.logInmag.handleservice;

import com.superhero.netctoos.bean.LogInBean;

public interface ILogInHandleService {
	/**
	 * 新增登录日志
	 * @param logIn
	 */
	public void saveLogIn(LogInBean logIn);
}
