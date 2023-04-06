//package com.codeup.codeupspringblog.services;
//
//import com.codeup.codeupspringblog.repositories.UserRepository;
//import com.codeup.codeupspringblog.repositories.models.User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsLoader implements UserDetailsService {
//    private final UserRepository users;
//
//    public UserDetailsLoader(UserRepository users) {
//        this.users = users;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = users.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("No user found for " + username);
//        }
//
//        return new UserWithRoles(user);
//    }
//}