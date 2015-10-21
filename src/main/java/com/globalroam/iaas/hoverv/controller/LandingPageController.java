package com.globalroam.iaas.hoverv.controller;

import com.globalroam.iaas.hoverv.domain.Menu;
import com.globalroam.iaas.hoverv.service.ContentMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by chenglong on 2015/10/20.
 */
@Controller
@RequestMapping("/index")
public class LandingPageController {
    @Resource
    private ContentMenuService contentMenuService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        Menu contentMenu = contentMenuService.getContentMenu();
        model.addAttribute(contentMenu);
        return "index";
    }
}
