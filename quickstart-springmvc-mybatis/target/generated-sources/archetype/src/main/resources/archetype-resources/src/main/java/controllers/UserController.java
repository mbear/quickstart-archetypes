#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${package}.dtos.User;
import ${package}.services.UserService;

/**
 * @author muzongyan
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        List<User> blogs = userService.findAllUsers();
        model.addAttribute("USERS", blogs);
        return "welcome";
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        return userService.findAllUsers();
    }
}
