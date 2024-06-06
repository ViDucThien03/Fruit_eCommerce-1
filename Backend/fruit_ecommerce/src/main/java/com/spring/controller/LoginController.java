package com.spring.controller;

import com.spring.Service.AuthServiceImpl;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    public AuthServiceImpl authService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("auth/login");
        mv.addObject("user", new User());
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpSession session, @ModelAttribute("user") User user){
        ModelAndView mv = new ModelAndView();
        user = authService.login(user);
        if(user != null){
            mv.setViewName("redirect:/home");
            session.setAttribute("loginInfo", user);
        } else {
            mv.addObject("statuslogin","Tài khoản hoặc mật khẩu không đúng");
            mv.setViewName("redirect:/login");
        }
        return mv;
    }
    @RequestMapping(value = "/setup_user",method = RequestMethod.GET)
    public ModelAndView setupUser(HttpSession session) {
        ModelAndView mv = new ModelAndView("auth/setup_user");
        mv.addObject("userInfo", new User());

        User loginInfo = (User) session.getAttribute("loginInfo");
        if(loginInfo != null)
        {

        }
        return mv;
    }
    @RequestMapping(value = "/setup_user",method = RequestMethod.POST)
    public ModelAndView setupUser(HttpSession session, @ModelAttribute("userInfo") User userInfo){
        ModelAndView mv = new ModelAndView();
        User loginInfo = (User) session.getAttribute("loginInfo");
        authService.setupUser(loginInfo.getId(), userInfo);
        mv.setViewName("redirect:/home");
        return mv;
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("loginInfo");
        return "redirect:"+request.getHeader("Referer");
    }
}
