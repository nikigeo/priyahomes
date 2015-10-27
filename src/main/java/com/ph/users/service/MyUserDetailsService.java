package com.ph.users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ph.users.dao.UserDao;

public class MyUserDetailsService implements UserDetailsService {

	private UserDao userDao;

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		com.ph.users.model.User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority();
		return buildUserForAuthentication(user, authorities);


	}

	// Converts com.ph.users.model.User user to
	private User buildUserForAuthentication(com.ph.users.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority() {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}