package com.sduiBackend.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Location\"")
public class User {
    @Column(name = "\"Name\"")
    private String name;
    @Id
    @Column(name = "\"id\"")
    private Long id;
    @Column(name = "\"Country\"")
    private String country;
    @Column(name = "\"State\"")
    private String state;

    public User(){}

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public String getState(){
        return state;
    }

}
