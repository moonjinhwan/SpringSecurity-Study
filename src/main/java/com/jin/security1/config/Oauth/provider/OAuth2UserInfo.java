package com.jin.security1.config.Oauth.provider;

public interface OAuth2UserInfo {
	public String getProvider();
	public String getProviderId();
	public String getName();
	public String getEmail();
}