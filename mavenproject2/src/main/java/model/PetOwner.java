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
@DatabaseTable(tableName = "petowner")
public class PetOwner {

@DatabaseField(generatedId = true)
    private int idPetOwner;
    
    @DatabaseField(canBeNull = false)
    private String username;
    
    @DatabaseField(canBeNull = false)
    private String password;
    
    public PetOwner() {
    }

    public PetOwner(int idPetOwner, String username, String password) {
        this.idPetOwner = idPetOwner;
        this.username = username;
        this.password = password;
    }

    public int getIdPetOwner() {
        return idPetOwner;
    }

    public void setIdPetOwner(int idPetOwner) {
        this.idPetOwner = idPetOwner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    
}
