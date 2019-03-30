package com.internousdev.mars.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.mars.dao.UserInfoDAO;
import com.internousdev.mars.util.CommonUtility;
import com.internousdev.mars.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware{
	private String userId;
	private String password;
	private String newPassword;
	private String newConfirmPassword;
	private List<String> userIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reNewPasswordErrorMessageList = new ArrayList<String>();
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	private List<String> newAndReNewPasswordNotMatchErrorMessageList = new ArrayList<String>();
	private Map<String,Object> session;

	public String execute() {
		//セッションタイムアウト確認
		if(session.isEmpty()){
			return "sessionError";
		}
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		userIdErrorMessageList = inputChecker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false, false, false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true, false, false, false);
		reNewPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード（再確認）", newConfirmPassword, 1, 16, true, false, false, true, false, false, false);

		UserInfoDAO userInfoDao = new UserInfoDAO();
		if(userIdErrorMessageList.size()==0 && passwordErrorMessageList.size()==0 && newPasswordErrorMessageList.size()==0 && reNewPasswordErrorMessageList.size()==0){
			if(userInfoDao.checkUserRegistration(userId, password)){
				if(newPassword.equals(newConfirmPassword)){
					CommonUtility commonUtility = new CommonUtility();
					String concealPassword = commonUtility.concealPassword(newPassword);
					session.put("userId", userId);
					session.put("newPassword", newPassword);
					session.put("concealPassword", concealPassword);
					result = SUCCESS;
				}else{
					String newAndReNewPasswordNotMatchErrorMessage = "新しいパスワードと新しいパスワード（再確認）が一致しません。";
					newAndReNewPasswordNotMatchErrorMessageList.add(newAndReNewPasswordNotMatchErrorMessage);
				}
			}else{
				String passwordIncorrectErrorMessage = "ユーザーIDまたは現在のパスワードが異なります。";
				passwordIncorrectErrorMessageList.add(passwordIncorrectErrorMessage);
			}
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewConfirmPassword() {
		return newConfirmPassword;
	}

	public void setNewConfirmPassword(String newConfirmPassword) {
		this.newConfirmPassword = newConfirmPassword;
	}
	public List<String> getUserIdErrorMessageList() {
		return userIdErrorMessageList;
	}

	public void setUserIdErrorMessageList(List<String> userIdErrorMessageList) {
		this.userIdErrorMessageList = userIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReNewPasswordErrorMessageList() {
		return reNewPasswordErrorMessageList;
	}

	public void setReNewPasswordErrorMessageList(List<String> reNewPasswordErrorMessageList) {
		this.reNewPasswordErrorMessageList = reNewPasswordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList() {
		return passwordIncorrectErrorMessageList;
	}

	public void setPasswordIncorrectErrorMessageList(List<String> passwordIncorrectErrorMessageList) {
		this.passwordIncorrectErrorMessageList = passwordIncorrectErrorMessageList;
	}

	public List<String> getNewAndReNewPasswordNotMatchErrorMessageList() {
		return newAndReNewPasswordNotMatchErrorMessageList;
	}

	public void setNewAndReNewPasswordNotMatchErrorMessageList(List<String> newAndReNewPasswordNotMatchErrorMessageList) {
		this.newAndReNewPasswordNotMatchErrorMessageList = newAndReNewPasswordNotMatchErrorMessageList;
	}
}
