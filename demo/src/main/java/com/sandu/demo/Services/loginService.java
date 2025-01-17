package com.sandu.demo.Services;

import com.sandu.demo.dto.AppUserDto;
import com.sandu.demo.dto.LoginDto;
import com.sandu.demo.response.LoginResponse;

public interface loginService {
   String addUser(AppUserDto user);
   LoginResponse loginUser(LoginDto loginDto);
}
