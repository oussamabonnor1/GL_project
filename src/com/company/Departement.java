package com.company;

import java.util.ArrayList;

public class Departement {
    private String nom;
    private Enseignant[] enseignants;
    private Matiere[] matieres;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void afficherChefDepartement(){
        for (int i = 0; i < enseignants.length; i++) {
            if (enseignants[i].isResponsableDepartement()){
                System.out.println("Mr."+enseignants[i].getNom()+" est Responsable du departement "+getNom());
                break;
            }
        }
    }
}
