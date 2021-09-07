package com.example.retrofitmodel.modelusers;

public class Users {
    String name;
    String id;
    String email;

    public Users(String name, String email, String id) {
        this.name= name;
        this.email= email;
        this.id= id;
    }

    public Users() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

