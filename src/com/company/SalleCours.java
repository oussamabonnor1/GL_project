package com.company;


import java.util.ArrayList;
import java.util.Date;

public class SalleCours {
    private int numSalle;
    private int capacity;
    private ArrayList<Date> filsAttente;
    private ArrayList<Enseignant> enseignants;

    public SalleCours(int numSalle, int capacity) {
        this.numSalle = numSalle;
        this.capacity = capacity;
        filsAttente = new ArrayList<>();
        enseignants = new ArrayList<>();
    }

    public int getNumSalle() {
        return numSalle;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void reserverSalle(Enseignant enseignant, Date date) {
        if (!dateTaken(date)) {
            enseignants.add(enseignant);
            filsAttente.add(date);
            imprimerFiche();
        } else System.out.println("Liste saturé pour cette date");
    }

    private boolean dateTaken(Date date) {
        int index = 0;
        for (int i = 0; i < filsAttente.size(); i++) {
            if (filsAttente.get(i).getDay() == date.getDay() &&
                    filsAttente.get(i).getMonth() == date.getMonth()) {
                index++;
            }
        }
        return index > 2;
    }

    public void annulerReservation(Enseignant enseignant, Date date) {
        if (filsAttente.size() > 0) {
            filsAttente.remove(date);
            enseignants.remove(enseignant);
            imprimerFiche();
        } else {
            System.out.println("fils de reservation de de la salle " + getNumSalle() + " est VIDE !");
        }
    }

    public void imprimerFiche() {
        System.out.println("Fiche Signalitique de la salle " + getNumSalle());
        System.out.println("Capacité: " + getCapacity());
        System.out.print("la File d'attente est: ");
        for (int i = 0; i < filsAttente.size(); i++) {
            System.out.print(",(" + String.format("%02d", filsAttente.get(i).getDate()) + "/" + String.format("%02d", filsAttente.get(i).getMonth()) + "/2017)");
            System.out.println(", (" + enseignants.get(i).getNom() + ")");
        }
        System.out.println();
    }
}
