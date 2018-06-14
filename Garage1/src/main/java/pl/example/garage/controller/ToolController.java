/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.example.garage.controller;

import pl.example.garage.exceptions.NotFoundException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.example.garage.model.Tool;
import pl.example.garage.service.ToolService;

@RestController

public class ToolController {

    @Autowired
    private ToolService toolService;

    @RequestMapping("tools")
    public List<Tool> getAll() {
        return toolService.findAll();

    }

    @RequestMapping("tools/{id}")
    public Tool getByID(@PathVariable @Valid Long id) throws NotFoundException {
        return toolService.findTool(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tools")
    public void addTool(@RequestBody Tool tool) {
        toolService.addTool(tool);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tools/{id}")
    public void updateTool(@RequestBody Tool tool, @Valid @PathVariable Long id) {
        toolService.updateTool(id, tool);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tools/{id}")
    public void deleteTool(@PathVariable @Valid Long id) throws NotFoundException {
        toolService.deleteTool(id);
    }

    @RequestMapping("tools/sort")
    public List<Tool> getAllByName() {
        return toolService.sortTools();
    }
}
