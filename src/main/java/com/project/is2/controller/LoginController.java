package com.project.is2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.is2.entity.User;
import com.project.is2.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

//    @GetMapping(value={"/", "/login"})
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//
//    @GetMapping(value="/admin/home")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByUserName(auth.getName());
//        modelAndView.addObject("userName", "Bienvenido " + user.getUserName() + "/" + user.getNombre() + " " + user.getApellido() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage","Contenido visible solo para administradores");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }


}
