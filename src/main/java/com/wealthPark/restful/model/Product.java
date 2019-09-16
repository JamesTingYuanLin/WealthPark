package com.wealthPark.restful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    public Product(String name) {
        this.name = name;
        this.createdDate = new Date();
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Date createdDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
