//WishMessageGeneratorController.java(29.03.2025)
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageGeneratorMgmtService;

@Controller
public class WishMessageGeneratorController {
	@Autowired
    private IWishMessageGeneratorMgmtService wishService;

    @RequestMapping("/")
    public String showHomePage() {
        return "welcome"; // LVN
    }

    @RequestMapping("/wish")
    public String showWishMessage(Map<String, Object> map) {
        // Use Service
        String msg = wishService.generateWishMessage();
        // Keep Results In Model Attribute
        map.put("resultMsg", msg);
        // Return LVN
        return "show_result";
    }
}
