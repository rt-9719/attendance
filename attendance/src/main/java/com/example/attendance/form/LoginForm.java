package com.example.attendance.form;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@Data
@SessionScope
public class LoginForm {

	/** ユーザーID */
	private String userId;
	
	/** パスワード */
	private String password;
	
	/** 企業ID */
	private String companyId;
}
