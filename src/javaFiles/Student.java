/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFiles;

/**
 *
 * @author Syed Areeb
 */
public class Student {
   
   int id;
   String  sname;String fname; String cast ; String age; String gender;String dob; int sclass; String rollno; String address; String contact;

    public Student(int id, String sname, String fname, String cast, String age, String gender, String dob, int sclass, String rollno, String address, String contact) {
        this.id = id;
        this.sname = sname;
        this.fname = fname;
        this.cast = cast;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.sclass = sclass;
        this.rollno = rollno;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public String getFname() {
        return fname;
    }

    public String getCast() {
        return cast;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public int getSclass() {
        return sclass;
    }

    public String getRollno() {
        return rollno;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setSclass(int sclass) {
        this.sclass = sclass;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


}