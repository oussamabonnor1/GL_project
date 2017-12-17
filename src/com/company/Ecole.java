package com.company;

public class Ecole {
    public String nom;
    public String SiteWeb;
    public Departement[] departements;

    public Ecole(String nom, String SiteWeb, Departement[] departements) {
        this.nom = nom;
        this.SiteWeb = SiteWeb;
        this.departements = departements;
    }

    public void afficherDepartemens() {
        System.out.println("Les départements de l'ecole " + nom + " sont: ");
        for (int i = 0; i < departements.length; i++) {
            System.out.println((i + 1) + ")-" + departements[i].getNom());
        }
        System.out.println();
    }
}
