package ir.company.tourengine.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
 public class BaseController  {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView visitHome() {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public ModelAndView visitAdmin() {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("title", "Admministrator Control Panel");
        model.addObject("message", "Admin Page");
        model.addObject("setting1", "Enable/Disable  Version");
        model.addObject("setting2", "Enable/Disable  Service");
        model.addObject("setting3", "Show/Create");



        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error() {

        ModelAndView model = new ModelAndView();

        model.addObject("error", "Invalid username and password!");
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {

        ModelAndView model = new ModelAndView();

        model.addObject("about", "Invalid username and password!");
        model.setViewName("about");

        return model;

    }

}
