package com.company;

import java.util.ArrayList;

public class Etudiant extends Personne {
    private ArrayList<Matiere> matieres;
    private int debutAnnee;

    public Etudiant(String nom, String preNom, String tel, String mail, int debutAnnee) {
        super(nom, preNom, tel, mail, "Etudiant");
        this.debutAnnee = debutAnnee;
    }

    public ArrayList<Matiere> getMatieres() {
        return matieres;
    }

    public int getDebutAnnee() {
        return debutAnnee;
    }

    public void addMatieres(Matiere matieres) {
        matieres.getEtudiants().add(this);
        this.matieres.add(matieres);
    }

    public float moyenneEtudiant() {
        float s = 0;
        for (int i = 0; i < matieres.size(); i++) {
            s += matieres.get(i).getNote().getNote();
        }
        return s / matieres.size();
    }

    public void afficherNoteEtMoyenne() {
        System.out.print("Les notes de l'etudiant: " + getNom() + " sont: ");
        for (int i = 0; i < matieres.size(); i++) {
            System.out.print(", " + matieres.get(i).getNote().getNote());
        }
        System.out.println();
        System.out.println(moyenneEtudiant());
    }

    public void afficherMatieresSansNotes() {
        System.out.println("Les matiere de l'etudiant: " + getNom());
        for (int i = 0; i < matieres.size(); i++) {
            System.out.println("-" + matieres.get(i).getNom());
        }
    }
}
