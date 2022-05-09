package com.accenture.web.controller;

//import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.business.bean.UserBean;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		UserBean user=new UserBean();
		ModelAndView modelAndview=new ModelAndView("Login","user",user);//url,attributeName,object
		return modelAndview;	
	}
	@RequestMapping(value="/validateLogin.htm",method=RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("user") UserBean user) {
		ModelAndView modelAndview=new ModelAndView();
		if("System".equalsIgnoreCase(user.getUserName()) && "System@123".equals(user.getPassword())) {
			modelAndview.setViewName("Dashboard");
			modelAndview.addObject("message","Welcome"+user.getUserName());
		}
		else {
			modelAndview.setViewName("Failure");
			modelAndview.addObject("errormessage","Please check the credentials "+user.getUserName());
		}
		return modelAndview;
	}
	
}
