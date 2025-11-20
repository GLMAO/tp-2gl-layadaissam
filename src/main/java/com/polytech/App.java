package com.polytech;

import com.polytech.tp.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Démonstration des Patrons de Conception");

        // Exercice 1: Pattern Builder
        System.out.println("\n--- Pattern Builder ---");
        CoursBuilder builder = new CoursBuilder();
        Cours coursBase = builder
                .setMatiere("Génie Logiciel")
                .setEnseignant("Dr Mazari")
                .setSalle("D23")
                .setDate("Lundi")
                .setHeureDebut("8h00")
                .setEstOptionnel(false)
                .setNiveau("2A")
                .setNecessiteProjecteur(true)
                .build();
        System.out.println("Cours créé avec Builder : " + coursBase.getDescription());

        // Exercice 3: Pattern Decorator
        System.out.println("\n--- Pattern Decorator ---");
        ICours coursDecore = new CoursEnLigne(coursBase);
        System.out.println("Description du cours décoré : " + coursDecore.getDescription());

        // Exercice 2: Pattern Observer
        System.out.println("\n--- Pattern Observer ---");
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
        Etudiant etudiant1 = new Etudiant("Issam");
        Responsable responsable1 = new Responsable("Ayoub");
        gestionnaire.attach(etudiant1);
        gestionnaire.attach(responsable1);

        // Ajout d'un cours (déclenche notification)
        gestionnaire.ajouterCours(coursDecore);

        // Modification d'un cours (déclenche notification)
        gestionnaire.modifierCours(coursDecore, "Changement de salle pour Génie Logiciel");

        // Changement d'état (déclenche notification)
        gestionnaire.setChangement("Emploi du temps mis à jour");
    }
}