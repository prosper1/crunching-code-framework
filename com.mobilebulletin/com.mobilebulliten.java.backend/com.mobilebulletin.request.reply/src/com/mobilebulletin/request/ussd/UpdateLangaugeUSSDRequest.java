package com.mobilebulletin.request.ussd;

import java.io.Serializable;

import com.mobilebulletin.request.util.CommonRequest;


public class UpdateLangaugeUSSDRequest   extends CommonRequest implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;
private String langauge;
public String getLangauge() {
	return langauge;
}
public void setLangauge(String langauge) {
	this.langauge = langauge;
}



}