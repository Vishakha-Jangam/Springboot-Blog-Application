package com.masai.springboot_blogApp.DTO;

public class JwtAuthResponse {

	private String accessToken;
	private String tokenType = "Bearer";
	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtAuthResponse(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
	
}
