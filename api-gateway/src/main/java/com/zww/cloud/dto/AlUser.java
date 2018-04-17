package com.zww.cloud.dto;

import java.util.Random;

/**
 * Created by RogueZww on 2018/4/12.
 */
public class AlUser {

    private static Random random = new Random();

    private String name;
    private int gender;
    private int age;
    private String description;

    public AlUser() {
        this.name = "Alex_" + random.nextLong();
        this.gender = random.nextInt(2);
        this.age = random.nextInt(60);
        this.description = "";
    }

    public AlUser(String name, int gender, int age, String description) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AlUser{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
