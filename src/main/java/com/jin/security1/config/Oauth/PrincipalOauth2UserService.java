package com.jin.security1.config.Oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.jin.security1.config.auth.PrincipalDetail;
import com.jin.security1.model.User;
import com.jin.security1.repository.UserRepository;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oauth2User = super.loadUser(userRequest);
//		System.out.println(super.loadUser(userRequest));
//		System.out.println(oauth2User);
		String provider = userRequest.getClientRegistration().getClientId();//google
		String providerId = oauth2User.getAttribute("sub");
		String username = provider+"_"+providerId;
		String password = bCryptPasswordEncoder.encode("jin");
		String email = oauth2User.getAttribute("email");
		String role = "USER_ROLE";
		
		User userEntity = userRepository.findByUsername(username);
		if(userEntity == null) {
			System.out.println("최초 회원 입니다.");
			userEntity = User.builder()
					.provider(provider)
					.providerId(providerId)
					.username(username)
					.password(password)
					.email(email)
					.role(role)
					.build();
			userRepository.save(userEntity);
			System.out.println(userEntity.toString());
		}else {
			System.out.println("이미 존재하는 회원입니다.");
		}
		return new PrincipalDetail(userEntity, oauth2User.getAttributes());
	}
}
