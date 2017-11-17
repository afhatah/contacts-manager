package com.fredericboisguerin.insa;

import groovy.ui.Console;
import groovy.ui.SystemOutputInterceptor;

import java.util.ArrayList;

public class ContactsManager {

    private ArrayList<Contact> contacts;

    public ContactsManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException {
        if (name==null)
            throw new InvalidContactNameException();

        if (name.equals(""))
            throw new InvalidContactNameException();

        if (email!=null && !email.contains("@"))
            throw new  InvalidEmailException();

        Contact c = new Contact();

        c.name = name;

        c.email = email;
        c.phoneNumber = phoneNumber;


        contacts.add(c);
    }

    public void printAllContacts() {
        for (Contact c : contacts)
            System.out.println(c);
    }

    public void searchContactByName(String name) {
        for (Contact c : contacts){
            if(c.name.toLowerCase().contains(name.toLowerCase())){
                System.out.println(c);
            }
        }
    }

    public String[] getAllContactsForCSV() {
        String[] ch = new String[contacts.size()];
        for (int i=0; i < ch.length ; i++) {
            ch[i] = contacts.get(i).toStringforCSV();
        }
        return ch;
    }

    public String[] getAllContacts() {
        String[] ch = new String[contacts.size()];
        for (int i=0; i < ch.length ; i++) {
            ch[i] = contacts.get(i).toString();
        }
        return ch;
    }


}
