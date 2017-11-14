package com.fredericboisguerin.insa;

import groovy.ui.Console;
import groovy.ui.SystemOutputInterceptor;

import java.util.ArrayList;

public class ContactsManager {

    private ArrayList<Contact> contacts;

    public ContactsManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException {
        if (name==null)
            throw new InvalidContactNameException();

        if (name.equals(""))
            throw new InvalidContactNameException();

        Contact c = new Contact();

        c.name = name;
        c.email = email;
        c.phoneNumber = phoneNumber;


        contacts.add(c);
    }

    public void printAllContacts() {
        System.out.print(contacts.toString());
    }

    public void searchContactByName(String name) {
        for (Contact c : contacts){
            if(c.name.toLowerCase().contains(name.toLowerCase())){
                System.out.println(c);
            }
        }
    }
}
