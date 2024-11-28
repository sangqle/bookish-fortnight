package com.sangle.example;

class UserInfo {
    String name;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class BuilderUser {
    public void build (UserInfo userInfo) {
        userInfo.setName("Sang le 2");
        userInfo.setAge(20);
    }
}
public class DemoNull {


    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Sangle");
        userInfo.setAge(27);

        BuilderUser builderUser = new BuilderUser();
        builderUser.build(userInfo);

        System.err.println("Name: " + userInfo.name);
        System.err.println("Age: " + userInfo.age);


    }
}
