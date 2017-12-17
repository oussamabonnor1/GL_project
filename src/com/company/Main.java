package com.company;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialisation:
        Random r = new Random();
        SalleCours[] salleCours = new SalleCours[5];
        for (int i = 0; i < 5; i++) {
            salleCours[i] = new SalleCours((200 + i), r.nextInt(10) + 20);
        }
        salleCours[3].setCapacity(100);

        Matiere[] matieres = new Matiere[5];
        matieres[0] = new Matiere("Math", salleCours[0]);
        matieres[1] = new Matiere("Info", salleCours[1]);
        matieres[2] = new Matiere("Physique", salleCours[2]);
        matieres[3] = new Matiere("Chimie", salleCours[3]);
        matieres[4] = new Matiere("Biologie", salleCours[4]);

        Etudiant[] etudiants = new Etudiant[5];
        //section etudiant
        etudiants[0] = new Etudiant("moh 1", "mih 1", "055115155", "emil@moh1", 2002);
        etudiants[1] = new Etudiant("moh 2", "mih 2", "055115177", "emil@moh2", 1999);
        etudiants[2] = new Etudiant("moh 3", "mih 3", "055115158", "emil@moh3", 2008);
        etudiants[3] = new Etudiant("moh 4", "mih 4", "055115159", "emil@moh4", 2009);
        etudiants[4] = new Etudiant("moh 5", "mih 5", "0551151511", "emil@moh5", 2011);

        etudiants[0].addMatieres(matieres[0]);
        etudiants[0].addMatieres(matieres[1]);
        etudiants[0].addMatieres(matieres[3]);
        etudiants[0].setNote(15);
        etudiants[1].addMatieres(matieres[0]);
        etudiants[1].setNote(20);
        etudiants[2].addMatieres(matieres[2]);
        etudiants[2].setNote(3);
        etudiants[3].addMatieres(matieres[3]);
        etudiants[4].addMatieres(matieres[4]);
        etudiants[4].setNote(11);
        etudiants[4].addMatieres(matieres[3]);
        etudiants[4].setNote(17);


        Enseignant[] enseignants = new Enseignant[7];
        String[] grade = {"Assistant", "Maitre assistant", "Chargé de cours", "Maire de conference A", "Maire de conference B", "Proffesseur"};

        //Section enseignant
        enseignants[0] = new Enseignant("prof " + 1, "pref", "05550511", "emil@moh1", 1975,12,1, grade[0]);
        enseignants[1] = new Enseignant("prof " + 2, "pref", "05550512", "emil@moh2", 2015,7,8, grade[0]);
        enseignants[2] = new Enseignant("prof " + 3, "pref", "05550513", "emil@moh3", 2012,9,17, grade[1]);
        enseignants[3] = new Enseignant("prof " + 4, "pref", "05550514", "emil@moh4", 2010,5,15, grade[2]);
        enseignants[4] = new Enseignant("prof " + 5, "pref", "05550515", "emil@moh5", 1999,4,12, grade[3]);
        enseignants[5] = new Enseignant("prof " + 6, "pref", "05550515", "emil@moh5", 1999,6,8, grade[4]);
        enseignants[6] = new Enseignant("prof " + 7, "pref", "05550515", "emil@moh5", 1999,6,7, grade[5]);

        enseignants[0].addMatieres(matieres[0]);
        enseignants[0].addMatieres(matieres[1]);
        enseignants[1].addMatieres(matieres[2]);
        enseignants[2].addMatieres(matieres[0]);
        enseignants[2].addMatieres(matieres[1]);
        enseignants[2].addMatieres(matieres[2]);
        enseignants[3].addMatieres(matieres[4]);
        enseignants[3].addMatieres(matieres[3]);
        enseignants[3].addMatieres(matieres[2]);
        enseignants[4].addMatieres(matieres[1]);
        enseignants[4].addMatieres(matieres[0]);
        enseignants[4].addMatieres(matieres[3]);
        //End section

        Departement d = new Departement("MI", enseignants, matieres, salleCours, etudiants);
        Departement d2 = new Departement("Physique", enseignants, matieres, salleCours, etudiants);
        Ecole ecole = new Ecole("IGMO", new Departement[]{d, d2});
        afficherMenuEcole(ecole);
    }

    public static void afficherMenuEcole(Ecole e) {
        System.out.println("Menu De l'ecole (Choix d'option par choix de numero)");
        e.afficherDepartemens();
        System.out.println("Pour Quitter clickez sur 0");
        System.out.println("Veillez choissir un departement: ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        if (index == 0) {
            System.out.println("Bye !");
            System.exit(0);
        }
        afficherMenu(e.departements[index - 1], e);
    }

    public static void afficherMenu(Departement d, Ecole ecole) {
        System.out.println("Menu Du Departement (Choix d'option par choix de numero)");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (i != 13) {
            System.out.println();
            System.out.println("1)-Afficher les Enseignants par Grade");
            System.out.println("2)-Afficher un Chef de Departement");
            System.out.println("3)-Afficher les cours dispensé par un enseignant");
            System.out.println("4)-Afficher les Enseignants par ancienté");
            System.out.println("5)-Afficher les Salles par Capacité");
            System.out.println("6)-Afficher les Notes/Moyenne d'un étudiant");
            System.out.println("7)-Afficher le classement des étudiants");
            System.out.println("8)-Afficher la moyenne d'un cours");
            System.out.println("9)-Afficher les matiéres pour un étudiant");
            System.out.println("10)-Afficher le Grade pour un enseigant");
            System.out.println("11)-Résever une salle pour un enseigant");
            System.out.println("12)-Annuler la reservation d'une salle pour un enseigant");
            System.out.println("13)-Afficher des infos sur ce departement");
            System.out.println("14)-Quitter...");
            System.out.println();
            i = sc.nextInt();
            switch (i) {
                case 1:
                    d.affficherEnseignantGrade();
                    break;
                case 2:
                    d.afficherChefDepartement();
                    break;
                case 3:
                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index = sc.nextInt();
                    d.afficherCours(d.enseignants[index - 1]);
                    break;
                case 4:
                    d.afficherEnseigantsAncienté();
                    break;
                case 5:
                    d.afficherSalles();
                    break;
                case 6:
                    System.out.println("Veillez selectionner un étudiant:");
                    for (int e = 0; e < d.etudiants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.etudiants[e].getNom());
                    }
                    int n = sc.nextInt();
                    d.etudiants[n - 1].afficherNoteEtMoyenne();
                    break;
                case 7:
                    d.afficherEtudiantParMoyenne();
                    break;
                case 8:
                    System.out.println("Veillez selectionner une Matiére:");
                    for (int e = 0; e < d.matieres.length; e++) {
                        System.out.println((e + 1) + ")-" + d.matieres[e].getNom());
                    }
                    int n2 = sc.nextInt();
                    d.matieres[n2 - 1].moyenneMatiere();
                    break;
                case 10:
                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index6 = sc.nextInt();
                    d.enseignants[index6 - 1].afficherGrade();
                    break;
                case 9:
                    System.out.println("Veillez selectionner un étudiant:");
                    for (int e = 0; e < d.etudiants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.etudiants[e].getNom());
                    }
                    int n3 = sc.nextInt();
                    d.etudiants[n3 - 1].afficherMatieresSansNotes();
                    break;
                case 11:
                    System.out.println("Veillez Choissir une Salle: ");
                    for (int e = 0; e < d.salleCours.length; e++) {
                        System.out.println((e + 1) + ")-" + d.salleCours[e].getNumSalle());
                    }
                    int index3 = sc.nextInt();
                    System.out.println("Veillez entrer une date");
                    System.out.print("jour:");
                    int day = sc.nextInt();
                    System.out.print("mois:");
                    int month = sc.nextInt();

                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index7 = sc.nextInt();
                    d.salleCours[index3 - 1].reserverSalle(d.enseignants[index7 - 1], new Date(2017, month, day));
                    break;
                case 12:
                    System.out.println("Veillez entrer une date");
                    System.out.print("jour:");
                    int day2 = sc.nextInt();
                    System.out.print("mois:");
                    int month2 = sc.nextInt();
                    System.out.println("Veillez Choissir une Salle: ");
                    for (int e = 0; e < d.salleCours.length; e++) {
                        System.out.println((e + 1) + ")-" + d.salleCours[e].getNumSalle());
                    }
                    int index5 = sc.nextInt();

                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index8 = sc.nextInt();

                    d.salleCours[index5 - 1].annulerReservation(d.enseignants[index8 - 1], new Date(2017, month2, day2));
                    break;
                case 13:
                    infoDesObjets(d, ecole);
                    break;
                case 14:
                    afficherMenuEcole(ecole);
                    break;
                default:
                    System.out.println("Bye !");
                    System.exit(0);
                    break;
            }

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void infoDesObjets(Departement d, Ecole ecole) {

        int i = 0;
        while (i < 6) {
            System.out.println("---Menu Des infos des enseigants (Choix d'option par choix de numero)---");
            System.out.println("Veillez choisir quelq'un pour inspecter");
            System.out.println("1)-Enseignants\n)2-Etudiants\n3)-Salles\n4)-Matieres\n5)-Retour...");
            Scanner sc = new Scanner(System.in);
            i = sc.nextInt();
            int index;
            switch (i) {
                case 1:
                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    index = sc.nextInt();
                    d.enseignants[index - 1].imprimerFiche();
                    break;
                case 2:
                    System.out.println("Veillez Choissir un Etudiant: ");
                    for (int e = 0; e < d.etudiants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.etudiants[e].getNom());
                    }
                    index = sc.nextInt();
                    d.etudiants[index - 1].imprimerFiche();
                    break;
                case 3:
                    System.out.println("Veillez Choissir une Salle: ");
                    for (int e = 0; e < d.salleCours.length; e++) {
                        System.out.println((e + 1) + ")-" + d.salleCours[e].getNumSalle());
                    }
                    index = sc.nextInt();
                    d.salleCours[index - 1].imprimerFiche();
                    break;
                case 4:
                    System.out.println("Veillez Choissir une Matiére: ");
                    for (int e = 0; e < d.matieres.length; e++) {
                        System.out.println((e + 1) + ")-" + d.matieres[e].getNom());
                    }
                    index = sc.nextInt();
                    d.matieres[index - 1].imprimerFiche();
                    break;
                case 5:
                    afficherMenuEcole(ecole);
                    break;
            }
        }
    }
}