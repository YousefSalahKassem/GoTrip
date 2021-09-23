package com.example.seniorstepsproject;

public  class  insertmydata implements Comparable<insertmydata> {
    String chooseclass;
    String planename;
    String from;
    String to;
    String timego;
    String timere;
    String price;
    String totaltime;
    String date;

    public insertmydata() {
    }

    public insertmydata(String chooseclass, String planename, String from, String to, String timego, String timere, String price, String totaltime, String date) {
        this.chooseclass = chooseclass;
        this.planename = planename;
        this.from = from;
        this.to = to;
        this.timego = timego;
        this.timere = timere;
        this.price = price;
        this.totaltime = totaltime;
        this.date = date;
    }

    public String getChooseclass() {
        return chooseclass;
    }

    public void setChooseclass(String chooseclass) {
        this.chooseclass = chooseclass;
    }

    public String getPlanename() {
        return planename;
    }

    public void setPlanename(String planename) {
        this.planename = planename;
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

    public String getTimego() {
        return timego;
    }

    public void setTimego(String timego) {
        this.timego = timego;
    }

    public String getTimere() {
        return timere;
    }

    public void setTimere(String timere) {
        this.timere = timere;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(String totaltime) {
        this.totaltime = totaltime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public int compareTo(insertmydata o) {
        return Integer.parseInt(this.price)-Integer.parseInt(o.getPrice());
    }
}