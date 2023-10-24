//package com.example.mcqgroupbe.config;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.LockedException;
//
//import com.example.mcqgroupbe.entity.Attempts;
//import com.example.mcqgroupbe.entity.User;
//import com.example.mcqgroupbe.repository.security.AttemptsRepository;
//import com.example.mcqgroupbe.repository.security.UserRepository;
//import com.example.mcqgroupbe.service.SecurityUserDetailsService;
//
//public class AuthProvider implements AuthenticationProvider  {
//	private static final int ATTEMPTS_LIMIT = 3; 
//	   @Autowired
//	   private SecurityUserDetailsService userDetailsService; 
//	   @Autowired
//	   private PasswordEncoder passwordEncoder; 
//	   @Autowired
//	   private AttemptsRepository attemptsRepository; 
//	   @Autowired
//	   private UserRepository userRepository; 
//	   @Override 
//	   public Authentication authenticate(Authentication authentication) 
//	   throws AuthenticationException { 
//	      String username = authentication.getName();
//	      Optional<Attempts> 
//	      userAttempts = attemptsRepository.findAttemptsByUsername(username); 
//	      if (userAttempts.isPresent()) { 
//	         Attempts attempts = userAttempts.get();
//	         attempts.setAttempts(0); attemptsRepository.save(attempts); 
//	      } 
//	   } 
//	   private void processFailedAttempts(String username, User user) { 
//	      Optional<Attempts> 
//	      userAttempts = attemptsRepository.findAttemptsByUsername(username); 
//	      if (userAttempts.isEmpty()) { 
//	         Attempts attempts = new Attempts(); 
//	         attempts.setUsername(username); 
//	         attempts.setAttempts(1); 
//	         attemptsRepository.save(attempts); 
//	      } else {
//	         Attempts attempts = userAttempts.get(); 
//	         attempts.setAttempts(attempts.getAttempts() + 1); 
//	         attemptsRepository.save(attempts);
//	      
//	         if (attempts.getAttempts() + 1 > 
//	         ATTEMPTS_LIMIT) {
//	            user.setAccountNonLocked(false); 
//	            userRepository.save(user); 
//	            throw new LockedException("Too many invalid attempts. Account is locked!!"); 
//	         } 
//	      }
//	   }
//	   @Override public boolean supports(Class<?> authentication) { 
//	      return true; 
//	   }
//}
