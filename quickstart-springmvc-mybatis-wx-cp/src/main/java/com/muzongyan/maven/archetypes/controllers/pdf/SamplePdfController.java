/**
 * 
 */
package com.muzongyan.maven.archetypes.controllers.pdf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.muzongyan.maven.archetypes.dtos.User;
import com.muzongyan.maven.archetypes.services.UserService;

/**
 * @author muzongyan
 *
 */
@Controller
@RequestMapping("/pdf")
public class SamplePdfController {

    @Autowired
    private UserService userService;

    /**
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "sample", method = RequestMethod.GET)
    public ModelAndView showUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> blogs = userService.findAllUsers();
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(blogs);
        modelMap.put("sample", jrDataSource);

        return new ModelAndView("samplePdfReport", modelMap);
    }
}
