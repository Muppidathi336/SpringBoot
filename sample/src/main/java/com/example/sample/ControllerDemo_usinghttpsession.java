package com.example.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@Controller
public class ControllerDemo 
{
@RequestMapping("home")
public String home(String name, HttpSession session)
                  
{
	session.setAttribute("name",name);
	
	return "home.jsp";
}
}
