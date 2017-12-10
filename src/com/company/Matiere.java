package com.company;

import java.util.ArrayList;

public class Matiere {
    private String nom;
    private ArrayList<Enseignant> enseignants;
    private SalleCours salleCours;
    private ArrayList<Etudiant> etudiants;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
