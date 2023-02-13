package com.ProjetSpring.ProjetSpring.model;

import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
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
    private String tel;
    private String pays;
    private String genre;
    private String birth;
    private String image;



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
                ", tel='" + tel + '\'' +
                ", pays='" + pays + '\'' +
                ", genre='" + genre + '\'' +
                ", role='" + birth + '\'' +
                ", image='" + image + '\'' +
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

    public void setTel(String tel) {
        tel = tel;
    }
    public String getTel() {
        return tel;
    }

    public void setBirth(String birth) {
        birth = birth ;
    }
    public String getBirth () {
        return birth ;
    }

    public void setGenre(String genre) {
        genre = genre ;
    }
    public String getGenre () {
        return genre ;
    }

    public void setPays(String pays) {
        pays = pays ;
    }
    public String getImage () {
        return image ;
    }

    public void setImage(String image) {
        image = image ;
    }
    public String getPays () {
        return pays ;
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