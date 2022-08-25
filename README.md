# SpringBoot

SpringBoot web appln:

To view a page in web:
=======================
On running the spring boot app, it hit the controller, controller return jsp page(sb knows that jsp would be present under src/main/webapp folder).

@Controller
public class ControllerDemo 
{
@RequestMapping("home")  //url map
public String home()
{
	return "home.jsp";   // page to return
}
}

home.jsp:
<body>
gtftkyfhdtdtdtdtdhthfujhf
</body>

POM for jsp, 
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>
    <version>8.5.31</version>
</dependency>


To accept data from client:
===========================
using httpsession:
======
jsp:
<body>
welcome ${name}
</body>

@Controller
public class ControllerDemo 
{
@RequestMapping("home")
public String home(String name, HttpSession session)
                    -------------------------------
{
	session.setAttribute("name",name);
	-----------------------------------
	return "home.jsp";
}
}

in url : http://localhost:8080/home?name=gafsg


using ModelAndView:
=============
@Controller
public class ControllerDemo 
{
@RequestMapping("home")
public ModelAndView home(@RequestParam("name") String myname)
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("name", myname);
	mv.setViewName("home.jsp");
	return mv;
}
}
in url : http://localhost:8080/home?name=gafsg

why do we go for ModelAndView: we can get multiple data from client

To accept multiple data from client:
=====================================
url: http://localhost:8080/home?id=1&username=bbhj

jsp:
<body>
welcome ${obj.id}, ${obj.username}
</body>

@Controller
public class ControllerDemo 
{
@RequestMapping("home")
public ModelAndView home(User user)
                         -----------------
{
	ModelAndView mv = new ModelAndView();
	mv.addObject("obj", user);
	             ------------
	mv.setViewName("home.jsp");
	return mv;
}
}

Add a user model to group multiple data under a class
