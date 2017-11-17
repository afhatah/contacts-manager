package com.fredericboisguerin.insa;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.Scanner;

public class UI {

    public static void askInfoForContact(ContactsManager cm) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom :");
        String name;
        String email;
        String phoneNumber;

        name = sc.nextLine();

        System.out.println("Email[optionnel] ('-' pour passer):");
        email = sc.nextLine();
        if(email.equals("-"))
            email = null;

        System.out.println("Téléphone[optionnel]('-' pour passer) :");
        phoneNumber = sc.nextLine();
        if(phoneNumber.equals("-"))
            phoneNumber = null;

        try {
            cm.addContact(name, email, phoneNumber);
        } catch (InvalidContactNameException e) {
            e.printStackTrace();
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        }
    }

    public static void askForListContacts(ContactsManager cm) {
        System.out.println("Liste des contacts :\n");
        cm.printAllContacts();
    }


    public static void askForSearchingByName(ContactsManager cm) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer un nom :\n");
        String name = sc.nextLine();
        cm.searchContactByName(name);
    }

    public static void go() {
        Scanner sc = new Scanner(System.in);
        ContactsManager cm = new ContactsManager();
        String res = "";

        while (!res.equals("0")) {

            System.out.println("\nMENU\n" +
                    "1 - Ajouter un nouveau contact\n" +
                    "2 - Chercher un contact\n" +
                    "3 - Afficher tous les contacts\n" +
                    "4 - Sauvegarder la liste de contact\n" +
                    "0 - Fermer l'application\n");
            res = sc.next();

            switch (res) {
                case "1":
                    askInfoForContact(cm);

                    break;
                case "2":
                    askForSearchingByName(cm);
                    break;
                case "3":
                    askForListContacts(cm);
                    break;
                case "4":
                    askForSaveInCSV(cm);

                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erreur : valeur incorrecte. Veuillez réessayer");
            }
        }
    }


    public static void askForSaveInCSV(ContactsManager cm) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du fichier : ");
        String nameFile = sc.next();
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(nameFile + ".csv"), '\t');
            String[] contacts = cm.getAllContactsForCSV();
            for (int i = 0; i < contacts.length; i++) {
                String[] entries = contacts[i].split(",");
                writer.writeNext(entries);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

