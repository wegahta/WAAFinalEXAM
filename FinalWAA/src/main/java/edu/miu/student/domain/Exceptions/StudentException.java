package edu.miu.student.domain.Exceptions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@ControllerAdvice
public class StudentException  {

       @ExceptionHandler(UserPrincipalNotFoundException.class) 
       public String userPrincipalNotFoundException(UserPrincipalNotFoundException e, Model model){
        model.addAttribute("o",e.getMessage());
        return "error";
    }
         @ExceptionHandler(Exception.class)
          public String exception(Exception e, Model model){
        model.addAttribute("msg",e.getMessage());
        return "error";
    }


}
