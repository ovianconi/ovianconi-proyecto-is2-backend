package com.project.is2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.is2.entity.User;
import com.project.is2.repository.UserRepository;

@RestController

public class MainRESTController {
     
    @Autowired
    private UserRepository userRepository;
 
//    @RequestMapping("/")
//    @ResponseBody
//    public String welcome() {
//        return "Bienvenidos";
//    }
 
    // URL:
    // http://localhost:8080/usuarios
    // http://localhost:8080/usuarios.xml
    // http://localhost:8080/usuarios.json
    @RequestMapping(value = "/usuarios", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<User> getUser() {
        List<User> list = userRepository.findAll();
        return list;
    }
 
    // URL:
    // http://localhost:8080/usuario/{id}
    // http://localhost:8080/usuario/{id}.xml
    // http://localhost:8080/usuario/{id}.json
    @RequestMapping(value = "/usuario/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findByUserId(id);
    }
}