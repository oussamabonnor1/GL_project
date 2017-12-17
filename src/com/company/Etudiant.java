package com.company;

import java.util.ArrayList;

public class Etudiant extends Personne {
    private ArrayList<Matiere> matieres;
    private int debutAnnee;

    public Etudiant(String nom, String preNom, String tel, String mail, int debutAnnee) {
        super(nom, preNom, tel, mail, "Etudiant");
        this.debutAnnee = debutAnnee;
        matieres = new ArrayList<>();
    }

    public ArrayList<Matiere> getMatieres() {
        return matieres;
    }

    public int getDebutAnnee() {
        return debutAnnee;
    }

    public void addMatieres(Matiere matieres) {
        matieres.getEtudiants().add(this);
        this.matieres.add(new Matiere(matieres.getNom(), matieres.salleCours));
    }

    public void setNote(float note) {
        matieres.get(matieres.size() - 1).setNote(new Note(note));
    }

    public float moyenneEtudiant() {
        float s = 0;
        int d = 0;
        for (int i = 0; i < matieres.size(); i++) {
            if (matieres.get(i).getNote() != null) {
                d++;
                s += matieres.get(i).getNote().getNote();
            }
        }
        return s / (float) d;
    }

    public void afficherNoteEtMoyenne() {
        System.out.print("Les notes de l'etudiant: " + getNom() + " sont: ");
        for (int i = 0; i < matieres.size(); i++) {
            if (matieres.get(i).getNote() != null)
                System.out.print(", " + matieres.get(i).getNote().getNote() + " (" + matieres.get(i).getNom() + ")");
            else System.out.print(",Pas Noté " + " (" + matieres.get(i).getNom() + ")");
        }
        System.out.println();
        System.out.println("La moyenne est: " + String.format("%.2f", moyenneEtudiant()));
    }

    public void afficherMatieresSansNotes() {
        System.out.println("Les matiere de l'etudiant: " + getNom());
        for (int i = 0; i < matieres.size(); i++) {
            if (matieres.get(i).getNote() == null) System.out.println("-" + matieres.get(i).getNom());
        }
    }
}
