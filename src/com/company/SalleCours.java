package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SalleCours {
    private int numSalle;
    private int capacity;
    private Map<String, Date> filsAttente;

    public SalleCours(int numSalle, int capacity) {
        this.numSalle = numSalle;
        this.capacity = capacity;
        filsAttente = new HashMap<>();
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
        if (filsAttente.size() < 4) {
            if (!filsAttente.containsValue(date)) filsAttente.put(enseignant.getNom(), date);
            else System.out.println("Cette date est deja prise !");
        } else {
            System.out.println("fils de reservation de de la salle " + getNumSalle() + " est saturée.");
        }
    }

    public void annulerReservation(Enseignant enseignant) {
        if (filsAttente.size() > 0) {
            filsAttente.remove(enseignant.getNom());
        } else {
            System.out.println("fils de reservation de de la salle " + getNumSalle() + " est VIDE !");
        }
    }
}
