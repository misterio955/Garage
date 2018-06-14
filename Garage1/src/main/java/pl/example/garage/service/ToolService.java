/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.example.garage.service;

import pl.example.garage.exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import pl.example.garage.model.Tool;
import pl.example.garage.repository.ToolRepository;

@Service
@Transactional
public class ToolService {

    private final ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    public List<Tool> findAll() {
        List<Tool> tools = new ArrayList<>();
        toolRepository.findAll().stream().forEach((tool) -> {
            tools.add(tool);
        });
        return tools;
    }
    @NotFound(action = NotFoundAction.EXCEPTION)
    public Tool findTool(Long id) throws NotFoundException{
        
        Tool tool = toolRepository.getOne(id);
        
        if (tool == null) throw new NotFoundException("Tool not found");
        else return tool;
    }

    public void addTool(Tool tool) {
        toolRepository.save(tool);
    }

    public void deleteTool(Long id) throws NotFoundException {
        Tool tool = toolRepository.getOne(id);
        if (tool == null) throw new NotFoundException("Tool not found");
        else toolRepository.delete(tool);
        
    }

    public void updateTool(Long id, Tool tool) {
        toolRepository.findAll().stream().filter((aTool) -> (Objects.equals(aTool.getId(), id))).forEach((aTool) -> {
            aTool.update(tool);
        });
    }
    
    public List<Tool> sortTools(){
        List<Tool> tools = toolRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
       return tools;
}
   

}
