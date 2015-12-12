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
@DatabaseTable(tableName = "petkind")
public class PetKind {
    @DatabaseField(generatedId = true)
    private int idkind;
    @DatabaseField(canBeNull = false)
    private String kind;


    public PetKind() {
    }

    public PetKind(int idkind, String kind) {
        this.idkind = idkind;
        this.kind = kind;
    }

    public int getIdkind() {
        return idkind;
    }

    public void setIdkind(int idkind) {
        this.idkind = idkind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
