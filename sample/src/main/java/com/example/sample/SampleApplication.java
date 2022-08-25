package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner
{
	

@Autowired
private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
	
	@Override
	public void run(String ...arg) throws Exception{

	String ss= "INSERT INTO mylocaldb.userdata(\n"
			+ "	id, username)\n"
			+ "	VALUES (?, ?)";
	int result = jdbcTemplate.update(ss, 5, "p");
	if(result > 0)
	{
	System.out.println("success");
	}
	else
	{
		System.out.println("not");
	}
	}

}
