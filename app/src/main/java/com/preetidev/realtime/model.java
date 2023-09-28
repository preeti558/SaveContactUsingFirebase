package com.preetidev.realtime;

public class model {
//1-Variables
   String username;
   String phoneNumber;
   String group;

   //2-default constructor
    public model() {

    }
    //3-constructor

    public model(String group ,String username, String phoneNumber) {
        this.group = group;
        this.phoneNumber=phoneNumber;
        this.username=username;

    }
  //4-getters and setters
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String password) {
        this.phoneNumber = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
