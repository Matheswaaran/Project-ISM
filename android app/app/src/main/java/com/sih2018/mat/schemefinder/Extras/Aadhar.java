package com.sih2018.mat.schemefinder.Extras;

/**
 * Created by mat on 31/03/18.
 */

public class Aadhar {
    public String uid;
    public String name;
    public String gender;
    public String yob;
    public String careof;
    public String gname;
    public String house;
    public String street;
    public String landmark;
    public String vtc;
    public String postoffice;
    public String dist;
    public String subdist;
    public String state;
    public String pincode;

    public Aadhar(){

    }

    public Aadhar(String uid, String name, String gender, String yob, String careof, String gname, String house, String street, String landmark, String vtc, String postoffice, String dist, String subdist,String state, String pincode){
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.yob = yob;
        this.careof = careof;
        this.gname = gname;
        this.house = house;
        this.street = street;
        this.landmark = landmark;
        this.vtc = vtc;
        this.postoffice = postoffice;
        this.dist = dist;
        this.subdist = subdist;
        this.state = state;
        this.pincode = pincode;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYob() {
        return yob;
    }

    public void setYob(String yob) {
        this.yob = yob;
    }

    public String getCareof() {
        return careof;
    }

    public void setCareof(String careof) {
        this.careof = careof;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getVtc() {
        return vtc;
    }

    public void setVtc(String vtc) {
        this.vtc = vtc;
    }

    public String getPostoffice() {
        return postoffice;
    }

    public void setPostoffice(String postoffice) {
        this.postoffice = postoffice;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getSubdist() {
        return subdist;
    }

    public void setSubdist(String subdist) {
        this.subdist = subdist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
