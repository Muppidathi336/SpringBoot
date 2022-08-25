package com.example.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ControllerDemo 
{
	@Autowired
	UserRepo repo;
	
	@RequestMapping("/")  //url map
	public String home()
	{
		return "home.jsp";   // page to return
	}
	
	@RequestMapping("/addUser")  //url map
	public String addUser(User user)
	{
		repo.save(user);
		return "home.jsp";   // page to return
	}

}

/*
@Controller
public class ControllerDemo 
{
@RequestMapping("home")
public ModelAndView home(User user)
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("obj", user);
	mv.setViewName("home.jsp");
	return mv;
}
}
*/
