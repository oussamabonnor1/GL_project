package com.company;

import java.util.Random;

public class Departement {
    private String nom;
    public Enseignant[] enseignants;
    public Matiere[] matieres;
    public SalleCours[] salleCours;
    public Etudiant[] etudiants;

    public Departement(String nom, Enseignant[] enseignants, Matiere[] matieres, SalleCours[] salleCours, Etudiant[] etudiants) {
        this.nom = nom;
        this.enseignants = enseignants;
        this.matieres = matieres;
        this.salleCours = salleCours;
        this.etudiants = etudiants;
        enseignants[new Random().nextInt(enseignants.length)].setResponsableDepartement(true);
    }

    public String getNom() {
        return nom;
    }

    public void affficherEnseignantGrade() {
        System.out.println("---Les Enseignants du departement " + getNom() + "---");
        String[] grade = {"Assistant", "Maitre assistant", "Chargé de cours", "Maire de conference A", "Maire de conference B", "Proffesseur"};
        for (int i = 0; i < grade.length; i++) {
            System.out.print("Les " + grade[i] + ": ");
            boolean found = false;
            for (int j = 0; j < enseignants.length; j++) {
                if (grade[i].matches(enseignants[j].getGrade())) {
                    found = true;
                    System.out.print(enseignants[j].getNom() + ", ");
                }
            }
            if (!found) System.out.println("Aucun.");
            else System.out.println();
        }
    }

    public void afficherChefDepartement() {
        for (int i = 0; i < enseignants.length; i++) {
            if (enseignants[i].isResponsableDepartement()) {
                System.out.println("Mr." + enseignants[i].getNom() + " est Responsable du departement " + getNom());
                break;
            }
        }
    }

    public void afficherCours(Enseignant enseignant) {
        System.out.println("Les Cours dispensés pour Mr." + enseignant.getNom());
        for (int j = 0; j < enseignant.getMatieres().size(); j++) {
            System.out.println("-" + enseignant.getMatieres().get(j).getNom());
        }
    }

    public void afficherEnseigantsAncienté() {
        System.out.println("Les enseignants du departement: " + getNom());
        Enseignant[] save = enseignants;
        int minYear;
        int j;
        for (int k = 0; k < save.length; k++) {
            j = 0;
            minYear = Integer.MAX_VALUE - 1;
            for (int i = 0; i < save.length; i++) {
                if (save[i].getDateDebut() < minYear) {
                    minYear = save[i].getDateDebut();
                    j = i;
                } else if (save[i].getDateDebut() == minYear) {
                    if (save[j].getMois() > save[i].getMois()) {
                        minYear = save[i].getDateDebut();
                        j = i;
                    } else if (save[j].getMois() == save[i].getMois()) {
                        if (save[j].getJour() > save[i].getJour()) {
                            minYear = save[i].getDateDebut();
                            j = i;
                        }
                    }
                }
            }
            System.out.println("-" + save[j].getNom() + " (" + save[j].getDateDebut() + "/" + save[j].getMois() + "/" + save[j].getJour() + ")");
            save[j].setDateDebut(Integer.MAX_VALUE);
        }
    }

    public void afficherSalles() {
        System.out.println("Les salles du departement: " + getNom());
        SalleCours[] save = salleCours;
        int minYear;
        int j;
        for (int k = 0; k < save.length; k++) {
            j = 0;
            minYear = Integer.MAX_VALUE - 1;
            for (int i = 0; i < save.length; i++) {
                if (save[i].getCapacity() < minYear) {
                    minYear = save[i].getCapacity();
                    j = i;
                }
            }
            System.out.println("-" + save[j].getNumSalle() + " (" + save[j].getCapacity() + ")");
            save[j].setCapacity(Integer.MAX_VALUE);
        }
    }

    public void afficherEtudiantParMoyenne() {
        System.out.println("Le Classement dans le departement: " + getNom());
        float[] moyenne = new float[etudiants.length];
        for (int k = 0; k < moyenne.length; k++) {
            moyenne[k] = etudiants[k].moyenneEtudiant();
        }

        for (int k = 0; k < moyenne.length; k++) {
            float max = 0;
            int index = 0;
            for (int i = 0; i < moyenne.length; i++) {
                if (moyenne[i] > max) {
                    index = i;
                    max = moyenne[i];
                }
            }
            System.out.println("-" + etudiants[index].getNom() + " Avec " + moyenne[index]);
            moyenne[index] = Float.MIN_VALUE;
        }
    }
}