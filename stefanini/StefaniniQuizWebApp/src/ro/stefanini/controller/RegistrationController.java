package ro.stefanini.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.stefanini.dataOperation.UserDAO;
import ro.stefanini.data.User;


@Controller
public class RegistrationController {
 
	@Autowired
	private UserDAO userDaoImpl;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	  System.out.println("Show register");
    ModelAndView mav = new ModelAndView("signUp");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {
	  System.out.println("Add user "  + user.getUsername());
	  
	  userDaoImpl.register(user);
	  
	  return new ModelAndView("welcome", "username", user.getUsername());
  }
}
