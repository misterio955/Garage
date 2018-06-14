/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.example.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.example.garage.model.Tool;
import pl.example.garage.service.ToolService;

/**
 *
 * @author Basian
 */
@Controller
public class WebController {
   @Autowired
    private ToolService toolService;
   
//    @RequestMapping(value = "tools",method = RequestMethod.GET)
//    public String allTools(  ModelMap model) {
//        model.put("tools", toolService.findAll());
//        return "index";
//    }
//
//     @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String addTool(ModelMap map) {
//        map.put("tool", new Tool());
//        return "add"; 
//    }
//    
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String addTool(@RequestBody Tool tool, Model model) {
//        toolService.addTool(tool); 
//        return "redirect:../tools";    
//    }
//    
//    public String updateTool(){
//        return "update-tool";
//    }
//    
//    public String deleteTool(){
//        return "delete-tool";
//    }
    
}
