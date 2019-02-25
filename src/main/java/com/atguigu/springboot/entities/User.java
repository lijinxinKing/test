package com.atguigu.springboot.entities;

public class User {
    private Integer Id;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(Integer id, String username, String password) {
        this.Id = id;
        this.username = username;
        this.password = password;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

}
