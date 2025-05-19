package com.example.attendance.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.attendance.form.LoginForm;

import jp.co.future.uroborosql.SqlAgent;

@Service
public class LoginService extends AbstractService {
	
	/**
	 * ログイン情報が存在するか確認
	 * @param loginForm
	 * @return
	 */
	public int loginCheck(LoginForm loginForm) {
		
		SqlAgent agent = sqlConfig.agent();

		Map<String, Object> result = agent.query("login/selectLoginCheck")
				.param("userId", loginForm.getUserId())
				.param("password",loginForm.getPassword())
				.param("companyId", loginForm.getCompanyId())
				.one();
		
		agent.close();
		
		return Integer.parseInt(result.get("COUNT").toString());
	}

}
