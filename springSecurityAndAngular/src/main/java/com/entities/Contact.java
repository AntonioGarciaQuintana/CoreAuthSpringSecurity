package com.entities;

import javax.persistence.*;

/**
 * Created by fagarcia on 06/10/2018.
 */
@Entity
@Table(name = "tbl_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Contact() {
    }

    public Contact(long id, String name, int age, String nickName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, int age, String nickName, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
