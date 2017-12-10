package com.company;

public class Personne {
    private String nom;
    private String preNom;
    private String tel;
    private String mail;
    private String grade;

    public Personne(String nom, String preNom, String tel, String mail, String grade) {
        this.nom = nom;
        this.preNom = preNom;
        this.tel = tel;
        this.mail = mail;
        this.grade = grade;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreNom() {
        return preNom;
    }

    public void setPreNom(String preNom) {
        this.preNom = preNom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void imprimerFiche(){
        System.out.println("Fiche Signalitique de Mr."+getNom());
        System.out.println("Nom complet: "+getNom()+" "+getPreNom());
        System.out.println("Telephone: "+getTel());
        System.out.println("Email: "+getMail());
    }
}
