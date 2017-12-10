package com.company;

import java.util.ArrayList;

public class Enseignant extends Personne{
    private boolean responsableDepartement;
    private ArrayList<Matiere> matieres;

    public Enseignant(String nom, String preNom, String tel, String mail, String grade) {
        super(nom, preNom, tel, mail, grade);
    }
}
