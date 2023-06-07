package com.example.miprimerprojecto.models;

public class People {
    private Integer id;
    private String names;
    private String last_names;
    private Integer age;
    private String email;

    public People(Integer id, String names, String last_names, Integer age, String email) {
        this.id = id;
        this.names = names;
        this.last_names = last_names;
        this.age = age;
        this.email = email;
    }
    public People() {
        

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLast_names() {
        return last_names;
    }

    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
