package com.example.Spring_JPA.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_category")
    private String nameCategory;
    @Column(name = "location")
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Category() {
    }

    public Category(String nameCategory, String location) {
        this.nameCategory = nameCategory;
        this.location = location;
    }
}
