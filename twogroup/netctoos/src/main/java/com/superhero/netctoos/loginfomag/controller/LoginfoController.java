package com.superhero.netctoos.loginfomag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.superhero.netctoos.loginfomag.queryservice.ILoginfoQueryService;

@RequestMapping(value="/loginfo")
@Controller
public class LoginfoController {
	@Resource
	private ILoginfoQueryService loginfoQueryServiceImpl;
	
}
