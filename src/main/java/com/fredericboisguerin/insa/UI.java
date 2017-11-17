package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UI {

    public static void askInfoForContact() {
        Scanner sc = new Scanner(System.in);
        ContactsManager cm = new ContactsManager();
        System.out.println("Nom :");
        String name;
        String email;
        String phoneNumber;

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
    }

}
