package com.company;


import java.util.ArrayList;
import java.util.Date;

public class SalleCours {
    private int numSalle;
    private int capacity;
    private ArrayList<Date> filsAttente;

    public SalleCours(int numSalle, int capacity) {
        this.numSalle = numSalle;
        this.capacity = capacity;
        filsAttente = new ArrayList<>();
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

    public void reserverSalle(Date date) {
        if (filsAttente.size() < 4) {
            if (!dateTaken(date)) filsAttente.add(date);
            else System.out.println("Liste saturé pour cette date");
        } else {
            System.out.println("fils de reservation de de la salle " + getNumSalle() + " est saturée.");
        }
    }

    private boolean dateTaken(Date date) {
        int index = 0;
        for (int i = 0; i < filsAttente.size(); i++) {
            if (filsAttente.get(i).getDay() == date.getDay() &&
                    filsAttente.get(i).getMonth() == date.getMonth()) {
                index++;
            }
        }
        return index > 4;
    }

    public void annulerReservation(Date date) {
        if (filsAttente.size() > 0) {
            filsAttente.remove(date);
        } else {
            System.out.println("fils de reservation de de la salle " + getNumSalle() + " est VIDE !");
        }
    }

    public void imprimerFiche(){
        System.out.println("Fiche Signalitique de la salle "+getNumSalle());
        System.out.println("Capacité: "+getCapacity());
        System.out.println("La file d'attente est: "+filsAttente.toString());
    }
}
