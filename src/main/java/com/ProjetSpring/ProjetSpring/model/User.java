package com.ProjetSpring.ProjetSpring.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name =  "User", uniqueConstraints = @UniqueConstraint(columnNames = "idUser"))
public class User{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idUser;
    private String username;
    private String CIN;
    private String password;
    private String nom;
    private String prenom;
    private String role;



    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + username + '\'' +
                ", CIN='" + CIN + '\'' +
                ", motPasse='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void setRole(String role) {
        this.role=role;
    }
    public String getRole() {
        return role;
    }

    public User() {

    }
    /*
    public User(String email, String cIN, String motPasse, String nom, String prenom, ) {
        super();
        this.email = email;
        CIN = cIN;
        this.motPasse = motPasse;
        this.nom = nom;
        this.prenom = prenom;
    }*/

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCIN() {
        return CIN;
    }
    public void setCIN(String cIN) {
        CIN = cIN;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}