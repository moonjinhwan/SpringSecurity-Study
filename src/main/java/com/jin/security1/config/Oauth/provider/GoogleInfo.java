package com.jin.security1.config.Oauth.provider;

import java.util.Map;

public class GoogleInfo implements OAuth2UserInfo{
	
	private Map<String, Object> attributes;
	
	public GoogleInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getProvider() {
		// TODO Auto-generated method stub
		return "google";
	}

	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		return (String)attributes.get("sub");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return (String)attributes.get("name");
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return (String)attributes.get("email");
	}
	
	
}
