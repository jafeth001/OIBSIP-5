package com.infobyte.library.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gender;
    @Column(unique = true,nullable = false)
    private String regNo;
    @JsonIgnore
    @OneToMany(mappedBy = "borrowedBy")
    private List<Book> books;

    public User() {
    }

    public User(Long id, String name, String gender, String regNo, List<Book> books) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.regNo = regNo;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRegNo() {
        return regNo;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}