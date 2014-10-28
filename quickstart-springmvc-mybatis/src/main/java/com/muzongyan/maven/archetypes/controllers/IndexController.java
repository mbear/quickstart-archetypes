/**
 * 
 */
package com.muzongyan.maven.archetypes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author muzongyan
 *
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(Model model) {
        return "redirect:/welcome";
    }
}
