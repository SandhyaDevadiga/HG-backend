package com.sandu.demo.response;

public class LoginResponse {
String message;
Boolean status;
public LoginResponse(String message, Boolean status)
{
  this.message=message;
  this.status=status;
}
public String getMessage() {
    return message;
}

public Boolean getStatus() {
    return status;
}

// Setters
public void setMessage(String message) {
    this.message = message;
}

public void setStatus(Boolean status) {
    this.status = status;
}

// toString method
@Override
public String toString() {
    return "LoginResponse{" +
            "message='" + message + '\'' +
            ", status=" + status +
            '}';
}
}
