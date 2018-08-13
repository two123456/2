package com.superhero.netctoos.logInmag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superhero.netctoos.logInmag.queryservice.ILogInQueryService;
import com.superhero.netctoos.loginfomag.queryservice.ILoginfoQueryService;

@RequestMapping(value="/logIn")
@Controller
public class LogInController {
	@Resource
	private ILogInQueryService logInQueryServiceImpl;
	

}
