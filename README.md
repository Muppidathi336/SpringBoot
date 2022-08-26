# SpringBoot


![image](https://user-images.githubusercontent.com/104143415/186824794-6b493f09-c7e4-44b9-872f-04f19f09a6f6.png)

## Why SpringBoot over Spring Framework:
1. Since having embedded tomcat and jetty, we can create web application with SpringBoot. also can test the web application without deploying WAR file. 
2. Externalized Configuration by YAML/application.properties
3. To develop a simple Spring-based application easiest way to develop web application or RESTful services., micro-services

## Why SpringBoot over Spring MVC:
Both serves different purposes. But SpringBoot, 
1. Can avoid more configuration files
2. no need to build configuration manually.
3. wraps dependencies together in a single unit.

## SpringBoot Architecture:
O/p => jsp page
^
|
===============Presentation Layer
View - client -  (handle http request)
===============Business logic
Controller (just call the service layer ) => To map the http request and handle it
Service layer ( which extends CRUDRepository)
===============Model layer
Model layer maps fields with table column
===============Persistence layer
using JPA/Spring Data/ hibernate
CrudRepository/PagingAndSortingRepository/JPARepository, which defines CRUD, Spring JPA internally generates a JPQL (Java Persistence Query Language) query based on the method name
==============Data layer
DB

Spring Boot Application Properties(application.properties/YAML)
1. for external configuration, to specify to connect to database details

### SpringBoot web appln:

##### To create a home page:
=======================
On running the spring boot app, it hit the controller, controller return jsp page(sb knows that jsp would be present under src/main/webapp folder)(controller that maps the url with a function that return jsp page).

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


##### To accept data from client:
===========================
in url : http://localhost:8080/home?name=gafsg

###### using httpsession:
========================
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
###### using ModelAndView:
=========================
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

why do we go for ModelAndView: we can get multiple data from client

##### To accept multiple data from client:
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

##### To store client data:
=========================
url: http://localhost:8080/home?id=1&username=bbhj
page will have text box to capture data, on submit it will get saved in the db.
<body>
<form action="addUser">
ID :<br />
<input type="text" name="id"><br />
User name :<br />
<input type="text" name="username"><br />
<input type="submit" value="Add">
</form>

model that map table using Spring persistence (@Entity, @Table(name="userdata"))

Repository Interface that simply extends CrudRepository
public interface UserRepo extends CrudRepository< User, Integer>{}

And a controller which autowires that Repository Interface, and map url and call the CRUD in functions.
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

to connect to the db(postgres), in appln.properties (under src/main/resources)
spring.datasource.url = jdbc:postgresql://localhost:5432/mylocaldb
spring.datasource.username  = postgres
spring.datasource.password  = password
spring.datasource.schema  = mylocaldb

spring.jpa.properties.hibernate.default_schema  = mylocaldb
spring.flyway.schemas =  mylocaldb
