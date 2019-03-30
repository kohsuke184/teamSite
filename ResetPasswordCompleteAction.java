package com.internousdev.mars.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mars.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{
	private String userId;
	private String newPassword;
	private Map<String,Object> session;

	public String execute(){
		//セッションタイムアウト確認
		if(session.isEmpty()){
			return "sessionError";
		}
		userId = session.get("userId").toString();
		newPassword = session.get("newPassword").toString();

		String result = ERROR;
		UserInfoDAO userInfoDao = new UserInfoDAO();
		int i=0;
		i= userInfoDao.resetPassword(userId, newPassword);
		if(i > 0){
			result = SUCCESS;
		}
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
