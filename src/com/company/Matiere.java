package com.company;

import java.util.ArrayList;

public class Matiere {
    private String nom;
    private ArrayList<Enseignant> enseignants;
    private SalleCours salleCours;
    private ArrayList<Etudiant> etudiants;
    private Note note;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void moyenneMatiere() {
        System.out.print("La moyenne de la matiere: " + getNom() + " est: ");
        float s = 0;
        for (int i = 0; i < etudiants.size(); i++) {
            int index = 0;
            for (int j = 0; j < etudiants.get(i).getMatieres().size(); j++) {
                if (getNom().matches(etudiants.get(i).getMatieres().get(j).getNom())) {
                    index = j;
                }
            }
            s += etudiants.get(i).getMatieres().get(index).getNote().getNote();
        }
        System.out.println(s);
    }

}
