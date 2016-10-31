package com.websystique.springmvc.controller;

import com.websystique.springmvc.service.DetailService;
import com.websystique.springmvc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yaroslav on 31.10.2016.
 */
@RestController
public class DetailsController {

    @Autowired
    DetailService detailService;
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/api/getUserInfo", method = RequestMethod.GET)
    public Map<String,String> userDetails(@RequestParam("access_token") String accessToken){
        Map<String, String> model = new HashMap<>();
        String login = loginService.getUserLogin(accessToken);
         model.put("Name",  detailService.getPassportsByName(login).getName());
         model.put("Surname",  detailService.getPassportsByName(login).getSurname());
        return model;
    }




}
