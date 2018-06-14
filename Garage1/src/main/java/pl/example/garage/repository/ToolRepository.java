/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.example.garage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.garage.model.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long> {

 
}
