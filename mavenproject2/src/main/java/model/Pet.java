/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Fabian
 */
@DatabaseTable(tableName = "pet")
public class Pet {
    @DatabaseField(generatedId = true)
    private int idpet;
    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private String color;
    @DatabaseField(canBeNull = false)
    private int age;
    @DatabaseField(canBeNull = false)
    private String type;
    //canbenull ==  true, not sure if we gonna use it
    @DatabaseField(canBeNull = true)
    private int longitude;
    //canbenull ==  true, not sure if we gonna use it
    @DatabaseField(canBeNull = true)
    private int latitude;    
    // set lost to true or false;
    @DatabaseField(canBeNull = false)
    private Boolean lost;

    public Pet() {
    }

    public Pet(int idpet, String name, String color, int age, String type, int longitude, int latitude, Boolean lost) {
        this.idpet = idpet;
        this.name = name;
        this.color = color;
        this.age = age;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.lost = lost;
    }

    public int getIdpet() {
        return idpet;
    }

    public void setIdpet(int idpet) {
        this.idpet = idpet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public Boolean isLost() {
        return lost;
    }

    public void setLost(Boolean lost) {
        this.lost = lost;
    }
    
    
   
    
    
}
