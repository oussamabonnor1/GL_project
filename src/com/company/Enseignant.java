package com.company;

import java.util.ArrayList;

public class Enseignant extends Personne{
    private boolean responsableDepartement;
    private ArrayList<Matiere> matieres;
    private int dateDebut;

    public Enseignant(String nom, String preNom, String tel, String mail,int dateDebut, String grade) {
        super(nom, preNom, tel, mail, grade);
        this.dateDebut = dateDebut;
        matieres = new ArrayList<>();
    }

    public int getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(int dateDebut) {
        this.dateDebut = dateDebut;
    }

    public ArrayList<Matiere> getMatieres() {
        return matieres;
    }

    public void addMatieres(Matiere matieres) {
        matieres.getEnseignants().add(this);
        this.matieres.add(matieres);
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
