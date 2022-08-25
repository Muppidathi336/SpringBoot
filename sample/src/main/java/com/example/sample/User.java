package com.example.sample;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userdata")
public class User 
{
@Id
private int id;
private char username;


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public char getUsername() {
	return username;
}


public void setUsername(char username) {
	this.username = username;
}


@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + "]";
}

}
