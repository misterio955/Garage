/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.example.garage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Basian
 */
@Entity
@Table(name = "tools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    @Min(0)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull
    @Size(min = 1, message = "Name must not be empty")
    private String name;

    @Column(name = "damaged", nullable = false)
    @NotNull
    @Min(0)
    @Max(100)
    private int damaged;

    @Column(name = "price", nullable = false)
    @Min(0)
    @Digits(integer = 5, fraction = 2, message = "Wrong format of price")
    private float price;

    public Tool() {
    }

    public Tool(String name, int damaged, float price) {
        super();
        this.name = name;
        this.damaged = damaged;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamaged() {
        return damaged;
    }

    public void setDamaged(int damaged) {
        this.damaged = damaged;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void update(Tool tool) {
        this.setDamaged(tool.getDamaged());
        this.setName(tool.getName());
        this.setPrice(tool.getPrice());

    }

    @Override
    public String toString() {
        return "Tool{" + "id=" + id + ", name=" + name + ", damaged=" + damaged + '}';
    }

}
