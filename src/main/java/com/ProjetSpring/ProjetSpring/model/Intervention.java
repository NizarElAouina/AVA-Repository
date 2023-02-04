package com.ProjetSpring.ProjetSpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name =  "Intervention", uniqueConstraints = @UniqueConstraint(columnNames = "idIntervention"))
public class Intervention {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idIntervention;
    private String nomIntervention;

    public Intervention() {

    }

    public Intervention(String nomIntervention) {
        super();
        this.nomIntervention = nomIntervention;
    }
    public int getIdIntervention() {
        return idIntervention;
    }
    public void setIdIntervention(int idIntervention) {
        this.idIntervention = idIntervention;
    }
    public String getNomIntervention() {
        return nomIntervention;
    }
    public void setNomIntervention(String nomIntervention) {
        this.nomIntervention = nomIntervention;
    }



}
