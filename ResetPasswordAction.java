package com.internousdev.mars.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	private String userId;
	private Map<String,Object> session;
	public String execute(){
		//セッションタイムアウト確認
		if(session.isEmpty()){
			return "sessionError";
		}
		return SUCCESS;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
