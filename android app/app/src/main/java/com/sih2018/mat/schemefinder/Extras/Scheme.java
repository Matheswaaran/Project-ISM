package com.sih2018.mat.schemefinder.Extras;

/**
 * Created by mat on 31/03/18.
 */

public class Scheme {

    String name, minAge, maxAge, minIncome, maxIncome, division, profession, gender, community;

    public Scheme(){

    }

    public Scheme(String name, String minAge, String maxAge, String minIncome, String maxIncome, String division, String profession, String gender, String community){
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.division = division;
        this.profession = profession;
        this.gender = gender;
        this.community = community;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    public String getIncome() {
        return minIncome + " - " + maxIncome;
    }

    public String getMinIncome() {
        return minIncome;
    }

    public void setMinIncome(String minIncome) {
        this.minIncome = minIncome;
    }

    public String getMaxIncome() {
        return maxIncome;
    }

    public void setMaxIncome(String maxIncome) {
        this.maxIncome = maxIncome;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGender() {
        String g;
        if (gender == "male"){
            g = "M";
        } else if (gender == "female"){
            g = "F";
        }else{
            g = "all";
        }
        return g;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }
}
