package com.example.pernsonalDictionary.service;

import com.example.pernsonalDictionary.model.User;
import com.example.pernsonalDictionary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustonUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );

       List<GrantedAuthority> grantedAuthorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
       List<GrantedAuthority> grantedAuthorityListUser = AuthorityUtils.createAuthorityList( "ROLE_USER");
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                user.isAdmin() ? grantedAuthorityListAdmin : grantedAuthorityListUser
        );
    }
}
