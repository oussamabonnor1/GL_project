package com.company;

import java.util.ArrayList;

public class Matiere {
    private String nom;
    private ArrayList<Enseignant> enseignants;
    public SalleCours salleCours;
    private ArrayList<Etudiant> etudiants;
    private Note note;

    public Matiere(String nom, SalleCours salleCours) {
        this.nom = nom;
        this.salleCours = salleCours;
        etudiants = new ArrayList<>();
        enseignants = new ArrayList<>();
        note = null;
    }

    public ArrayList<Enseignant> getEnseignants() {
        return enseignants;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

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
        int d = 0;
        for (int i = 0; i < etudiants.size(); i++) {
            int index = 0;
            for (int j = 0; j < etudiants.get(i).getMatieres().size(); j++) {
                if (getNom().matches(etudiants.get(i).getMatieres().get(j).getNom())) {
                    index = j;
                }
            }
            if (etudiants.get(i).getMatieres().get(index).getNote() != null) {
                System.out.println("Etudiant: "+etudiants.get(i).getNom() + " avec la note: "+etudiants.get(i).getMatieres().get(index).getNote().getNote());
                s += etudiants.get(i).getMatieres().get(index).getNote().getNote();
                d++;
            }
        }
        System.out.println(String.format("%.2f", s / (float) d));
    }

    public void imprimerFiche() {
        System.out.println("Fiche Signalitique de la Matiere: " + getNom());
        //System.out.println("Capacité: "+getCapacity());
        //System.out.println("La file d'attente est: "+filsAttente.toString());
    }
}
