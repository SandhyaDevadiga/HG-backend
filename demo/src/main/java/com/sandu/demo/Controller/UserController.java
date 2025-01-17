package com.sandu.demo.Controller;
import com.sandu.demo.Services.UserService;
import com.sandu.demo.dto.AppUserDto;
import com.sandu.demo.dto.LoginDto;
import com.sandu.demo.response.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Handle user signup
    @PostMapping("/signup")
    public String signup(@RequestBody AppUserDto user) {
       String id=userService.addUser(user);
       return id;
    }

    // Handle user login (Spring Security will manage session automatically)
    @PostMapping("/login")
    public ResponseEntity<?> loginPage(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse=userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

    // // Handle logout (Spring Security will handle this automatically)
    // @RequestMapping("/logout")
    // public String logout() {
    //     return "redirect:/login";  // Redirect to login after logout
    // }

    // // Handle home page after successful login
    // @RequestMapping("/home")
    // public String homePage(Model model) {
    //     // Get user from session context
    //     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //     if (principal instanceof org.springframework.security.core.userdetails.User) {
    //         String username = ((org.springframework.security.core.userdetails.User) principal).getUsername();
    //         model.addAttribute("username", username);
    //     }
    //     return "home";  // Display home page
    // }
}
