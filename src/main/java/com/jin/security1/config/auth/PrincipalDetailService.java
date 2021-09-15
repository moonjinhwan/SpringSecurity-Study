package com.jin.security1.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jin.security1.model.User;
import com.jin.security1.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User UserEntity = userRepository.findByUsername(username);
		if(UserEntity != null) {
			return new PrincipalDetail(UserEntity);
		}
		return null;
	}

}
