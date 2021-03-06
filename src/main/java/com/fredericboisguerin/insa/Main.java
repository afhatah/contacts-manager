package com.fredericboisguerin.insa;

import com.intellij.execution.console.ConsoleFoldingSettings;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactsManager cm = new ContactsManager();
        String res = "";

        while(!res.equals("0")) {
            String name = null;
            String email = null;
            String phoneNumber = null;

            System.out.println("\nMENU\n" +
            "1 - Ajouter un nouveau contact\n" +
            "2 - Chercher un contact\n" +
            "3 - Afficher tous les contacts\n" +
                    "4 - Sauvegarder la liste de contact\n" +
                    "0 - Fermer l'application\n");
            res = sc.next();

            switch(res) {
                case "1" :
                    System.out.println("Nom :");
                    name = sc.next();

                    System.out.println("Email[optionnel] ('-' pour passer):");
                    email = sc.next();
                    if(email.equals("-"))
                        email = null;

                    System.out.println("Téléphone[optionnel]('-' pour passer) :");
                    phoneNumber = sc.next();
                    if(phoneNumber.equals("-"))
                        phoneNumber = null;

                    try {
                        cm.addContact(name, email, phoneNumber);
                    } catch (InvalidContactNameException e) {
                        e.printStackTrace();
                    } catch (InvalidEmailException e) {
                        e.printStackTrace();
                    }

                    break;
                case "2" :
                    System.out.println("Entrez un nom : ");
                    name = sc.next();
                    cm.searchContactByName(name);
                    break;
                case "3" :
                    System.out.println("Liste des contacts");
                    cm.printAllContacts();
                    break;
                case "4" :
                    System.out.println("Entrez le nom du fichier : ");
                    String nameFile = sc.next();

                    try {
                        CSVWriter writer = new CSVWriter(new FileWriter(nameFile+".csv"), '\t');
                        String[] contacts = cm.getAllContactsForCSV();
                        for (int i=0; i<contacts.length;i++) {
                            String[] entries = contacts[i].split(",");
                            writer.writeNext(entries);
                        }
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case "0" :
                    System.exit(0);
                    break;
                default :
                    System.out.println("Erreur : valeur incorrecte. Veuillez réessayer");
            }
        }
    }

}
