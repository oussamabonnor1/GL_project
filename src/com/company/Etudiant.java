package com.company;

import java.util.ArrayList;

public class Etudiant extends Personne{
    private Note note;
    private ArrayList<Matiere> matieres;
    private int debutAnnee;

    public Etudiant(String nom, String preNom, String tel, String mail, int debutAnnee) {
        super(nom, preNom, tel, mail, "Etudiant");
        this.debutAnnee = debutAnnee;
    }

}
