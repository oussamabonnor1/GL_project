package com.company;

import java.util.ArrayList;

public class Enseignant extends Personne{
    private boolean responsableDepartement;
    private ArrayList<Matiere> matieres;
    private int dateDebut;

    public Enseignant(String nom, String preNom, String tel, String mail,int dateDebut, String grade) {
        super(nom, preNom, tel, mail, grade);
        this.dateDebut = dateDebut;
    }

    public void afficherGrade(){
        System.out.println("Grade de Mr."+getNom()+" est "+getGrade());
    }

    public boolean isResponsableDepartement() {
        return responsableDepartement;
    }

    public void setResponsableDepartement(boolean responsableDepartement) {
        this.responsableDepartement = responsableDepartement;
    }
}
