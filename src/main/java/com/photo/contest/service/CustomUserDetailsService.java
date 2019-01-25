package com.photo.contest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.photo.contest.dao.UsersDAO;
import com.photo.contest.model.Users;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
     
    @Autowired
    private UsersDAO usersDAO;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	Users user = usersDAO.findByEmail(email);
        logger.info("User : {}", user);
        if(user==null){
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(user));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(Users user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        logger.info("authorities/roles : {}", authorities);
        return authorities;
    }
     
}
