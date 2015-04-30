package com.mobilebulletin.request.security;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class CheckUserRequest extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private String username;
public void setUsername(String username) {
	this.username = username;
}
public String getUsername() {
	return username;
}

}