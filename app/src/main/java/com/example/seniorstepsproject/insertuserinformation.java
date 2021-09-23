package com.example.seniorstepsproject;

public class insertuserinformation {
    String email;
    String fname;
    String lname;
    String phone;
    String address;
    String passport;

    public insertuserinformation() {
    }

    public insertuserinformation(String email, String fname, String lname, String phone, String address, String passport) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}