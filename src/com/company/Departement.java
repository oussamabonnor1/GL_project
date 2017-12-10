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

    public void afficherChefDepartement() {
        for (int i = 0; i < enseignants.length; i++) {
            if (enseignants[i].isResponsableDepartement()) {
                System.out.println("Mr." + enseignants[i].getNom() + " est Responsable du departement " + getNom());
                break;
            }
        }
    }

    public void afficherCours(String teacher){
        Enseignant enseignant = null;
        for (int i = 0; i < enseignants.length; i++) {
            if(enseignants[i].getNom().matches(teacher)){
                enseignant = enseignants[i];
                break;
            }
        }
        if(enseignant == null) {
            System.out.println("Warning: Cette enseignant n'est pas listé !");
        }else {
            System.out.println("Les Cours dispensés pour Mr."+enseignant.getNom());
            for (int i = 0; i < matieres.length; i++) {
                for (int j = 0; j < enseignant.getMatieres().size(); j++) {
                    if(enseignant.getMatieres().get(j).getNom().matches(matieres[i].getNom())){
                        System.out.println("-" +matieres[i].getNom());
                    }
                }
            }
        }
    }

    public void afficherEnseigants() {
        Enseignant[] save = enseignants.clone();
        Enseignant[] temp = new Enseignant[enseignants.length];
        int minYear = enseignants[0].getDateDebut();
        int j;
        for (int k = 0; k < save.length; k++) {
            j = 0;
            for (int i = 0; i < save.length; i++) {
                if (save[i].getDateDebut() < minYear) {
                    minYear = save[i].getDateDebut();
                    j = i;
                }
            }
            temp[k] = save[j];
            save[j].setDateDebut(Integer.MAX_VALUE);
        }
    }
}
