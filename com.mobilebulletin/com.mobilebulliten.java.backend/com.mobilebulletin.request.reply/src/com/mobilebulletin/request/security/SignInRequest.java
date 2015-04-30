package com.mobilebulletin.request.security;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class SignInRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String password;
private String username;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPassword() {
	return password;
}

}