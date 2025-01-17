package com.sandu.demo.Services.Impl;

import com.sandu.demo.Model.AppUser;
// import com.sandu.demo.Model.AppUser;
import com.sandu.demo.Repository.AppUserRepo;
import com.sandu.demo.Services.UserService;
import com.sandu.demo.Services.loginService;
import com.sandu.demo.dto.AppUserDto;
import com.sandu.demo.dto.LoginDto;
import com.sandu.demo.response.LoginResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Service
@Lazy
public class UserServiceImpl implements UserService, loginService {
    
  @Autowired
  private PasswordEncoder passwordEncoder;
    @Autowired
    private AppUserRepo userRepository;
    @Override
    public String addUser(AppUserDto user){
      AppUser newUser = new AppUser(
        user.getId(),
        user.getUsername(),
        this.passwordEncoder.encode(user.getPassword())
      );
      userRepository.save(newUser);
      return newUser.getUsername();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto){
      // String msg="";
      AppUser user1=userRepository.findByUsername(loginDto.getUsername());
      if(user1!=null){
        String encodedPassword = user1.getPassword();
        String password=loginDto.getPassword();
        Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
        if(isPwdRight){
           Optional<AppUser> user=userRepository.findByUsernameAndPassword(loginDto.getUsername(), encodedPassword);
           if(user.isPresent()){
            return new LoginResponse("login success", true);

           }
           else{
            return new LoginResponse("login Failed", false);

           }
        }
        else{
          return new LoginResponse("Password not Match", false);

        }

      }
      else{
        return new LoginResponse("username not exist", false);

      }
    }
}
