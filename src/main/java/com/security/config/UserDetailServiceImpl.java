package com.security.config;

import com.security.model.UserDtls;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDtls user = this.userRepository.findByEmail(email);
        if(user != null){
            return new CustomUserDetails(user);
        }
         throw new UsernameNotFoundException("USER NOT AVAILABLE");
    }

}
