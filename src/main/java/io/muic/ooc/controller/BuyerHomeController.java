package io.muic.ooc.controller;

import io.muic.ooc.model.User;
import io.muic.ooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by joakimnilfjord on 3/13/2017 AD.
 */
@Controller
public class BuyerHomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/buyer/home", method = RequestMethod.GET)
    public ModelAndView sellerHome(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getUsername() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("/buyer/home");
        return modelAndView;
    }



}
