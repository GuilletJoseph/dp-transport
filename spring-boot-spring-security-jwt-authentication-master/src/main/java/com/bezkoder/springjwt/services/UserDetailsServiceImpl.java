package com.bezkoder.springjwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.springjwt.exceptions.UserNotFoundException;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }
  
  
  public User addUser(User user) {
      return userRepository.save(user);
  }

  public List<User> findAllUsers() {
      return (List<User>) userRepository.findAll();
  }

  public User updateUser(User user) {
      return userRepository.save(user);
  }

  public User findUserById(Long id) throws UserNotFoundException {	
      return userRepository.findUserById(id)
              .orElseThrow(() -> new UserNotFoundException("User de id " + id + " ete pas trouve"));
 }

  public void deleteUser(Long id){
      userRepository.deleteById(id);
  }
  
  
  
  
  
  
  
  
  
  
  
  

}
