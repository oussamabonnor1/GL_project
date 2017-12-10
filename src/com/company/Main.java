package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialisation:
        Random r = new Random();
        SalleCours[] salleCours = new SalleCours[3];
        for (int i = 0; i < 3; i++) {
            salleCours[i] = new SalleCours((200 + i), r.nextInt(10) + 20);
        }

        Matiere[] matieres = new Matiere[3];
        matieres[0] = new Matiere("Math", salleCours[0]);
        matieres[1] = new Matiere("Info", salleCours[1]);
        matieres[2] = new Matiere("Something else", salleCours[2]);

        Etudiant[] etudiants = new Etudiant[3];
        for (int i = 0; i < 3; i++) {
            etudiants[i] = new Etudiant("moh " + (i + 1), "mih", "055115" + r.nextInt(100), "emil@moh" + (i + 1), 2017 - r.nextInt(10));
            int n = r.nextInt(3) + 1;
            for (int j = 0; j < n; j++) {
                etudiants[i].addMatieres(matieres[j]);
            }
        }

        Enseignant[] enseignants = new Enseignant[3];
        String[] grade = {"Assistant", "Maitre assistant", "Chargé de cours", "Maire de conference A", "Maire de conference B", "Proffesseur"};

        for (int i = 0; i < 3; i++) {
            enseignants[i] = new Enseignant("prof " + (i + 1), "pref", "0555051" + r.nextInt(100), "emil@moh" + (i + 1), 2017 - r.nextInt(20), grade[r.nextInt(6)]);
            int n = r.nextInt(3) + 1;
            for (int j = 0; j < n; j++) {
                enseignants[i].addMatieres(matieres[j]);
            }
        }

        Departement d = new Departement("MI", enseignants, matieres, salleCours, etudiants);
        afficherMenu(d);
    }

    public static void afficherMenu(Departement d) {
        System.out.println("Menu Du Departement (Choix d'option par choix de numero)");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (i != 13) {
            System.out.println("1)-Afficher les Enseignants par Grade");
            System.out.println("2)-Afficher les Departements d'une ecole");
            System.out.println("3)-Afficher un Chef de Departement");
            System.out.println("4)-Afficher les cours dispensé par un enseignant");
            System.out.println("5)-Afficher les Enseignants par ancienté");
            System.out.println("6)-Afficher les Salles par Capacité");
            System.out.println("7)-Afficher les Notes/Moyenne d'un étudiant");
            System.out.println("8)-Afficher le classement des étudiants");
            System.out.println("9)-Afficher la moyenne d'un cours");
            System.out.println("10)-Afficher les matiéres pour un étudiant");
            System.out.println("11)-Résever une salle pour un enseigant");
            System.out.println("12)-Annuler la reservation d'une salle pour un enseigant");
            System.out.println("13)-Quitter...");
            i = sc.nextInt();
            switch (i) {
                case 1:
                    d.affficherEnseignantGrade();
                    break;
                case 2:

                    break;
                case 3:
                    d.afficherChefDepartement();
                    break;
                case 4:
                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index = sc.nextInt();
                    d.afficherCours(d.enseignants[index - 1]);
                    break;
                case 5:
                    d.afficherEnseigantsAncienté();
                    break;
                case 6:
                    d.afficherSalles();
                    break;
                case 7:
                    System.out.println("Veillez selectionner un étudiant:");
                    for (int e = 0; e < d.etudiants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.etudiants[e].getNom());
                    }
                    int n = sc.nextInt();
                    d.etudiants[n - 1].afficherNoteEtMoyenne();
                    break;
                case 8:
                    d.afficherEtudiantParMoyenne();
                    break;
                case 9:
                    System.out.println("Veillez selectionner une Matiére:");
                    for (int e = 0; e < d.matieres.length; e++) {
                        System.out.println((e + 1) + ")-" + d.matieres[e].getNom());
                    }
                    int n2 = sc.nextInt();
                    d.matieres[n2 - 1].moyenneMatiere();
                    break;
                case 10:
                    System.out.println("Veillez selectionner un étudiant:");
                    for (int e = 0; e < d.etudiants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.etudiants[e].getNom());
                    }
                    int n3 = sc.nextInt();
                    d.etudiants[n3 - 1].afficherMatieresSansNotes();
                    break;
                case 11:
                    System.out.println("Veillez Choissir un prof: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index2 = sc.nextInt();

                    System.out.println("Veillez Choissir une Salle: ");
                    for (int e = 0; e < d.enseignants.length; e++) {
                        System.out.println((e + 1) + ")-" + d.enseignants[e].getNom());
                    }
                    int index2 = sc.nextInt();

                    break;
                case 12:
                    break;
                default:
                    System.out.println("Bye !");
                    System.exit(0);
                    break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
