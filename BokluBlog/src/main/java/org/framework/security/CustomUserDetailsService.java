package org.framework.security;

import java.util.Arrays;
import java.util.Collection;

import org.framework.model.UserRegistration;
import org.framework.persistence.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
		
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		final UserRegistration userRegistration = userRepository.findByEmail(email);
		
		if(userRegistration == null) {
			throw new UsernameNotFoundException("No username found with this email: "+email);
		}
		
		return new  User(userRegistration.getEmail(), userRegistration.getPassword(),userRegistration.isEnabled(),true, true,true,getAuthorities(userRegistration.getRole()));
	}
	private  Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
		
	}

}
