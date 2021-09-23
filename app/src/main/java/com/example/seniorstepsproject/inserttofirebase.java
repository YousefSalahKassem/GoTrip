package com.example.seniorstepsproject;

public class inserttofirebase {
    String typetravel;
    String chooseclass;
    String date;
    String email;
    String name;
    String phone;
    String address;
    String from;
    String to;
    String timefrom;
    String timeto;
    String duration;

    String kid;
    String passport;
    String price;
    public inserttofirebase() {
    }

    public inserttofirebase(String typetravel, String chooseclass, String date, String email, String name, String phone, String address, String from, String to, String timefrom, String timeto, String duration, String kid, String passport, String price) {
        this.typetravel = typetravel;
        this.chooseclass = chooseclass;
        this.date = date;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.from = from;
        this.to = to;
        this.timefrom = timefrom;
        this.timeto = timeto;
        this.duration = duration;
        this.kid = kid;
        this.passport = passport;
        this.price = price;
    }

    public String getTypetravel() {
        return typetravel;
    }

    public void setTypetravel(String typetravel) {
        this.typetravel = typetravel;
    }

    public String getChooseclass() {
        return chooseclass;
    }

    public void setChooseclass(String chooseclass) {
        this.chooseclass = chooseclass;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(String timefrom) {
        this.timefrom = timefrom;
    }

    public String getTimeto() {
        return timeto;
    }

    public void setTimeto(String timeto) {
        this.timeto = timeto;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }



    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
