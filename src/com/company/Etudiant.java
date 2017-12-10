package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Etudiant extends Personne{
    private Note note;
    private ArrayList<Matiere> matieres;
    private Date debutAnnee;

    public Etudiant(String nom, String preNom, String tel, String mail, Date debutAnnee) {
        super(nom, preNom, tel, mail, "Etudiant");
        this.debutAnnee = debutAnnee;
    }

}
