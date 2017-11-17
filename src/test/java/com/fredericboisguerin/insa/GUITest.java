package com.fredericboisguerin.insa;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;

public class GUITest {

    private ContactsManager mockedContactsManager;

    @Before
    public void setUp() {
        mockedContactsManager = mock(ContactsManager.class);
    }

    @Test
    public void add_one_contact_without_email_nor_phone_number() throws InvalidEmailException, InvalidContactNameException {
        String input = "Tehema\n-\n-";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // on simule les entrées utilisateurs (on contrôle le flux d'entrée)
        UI.askInfoForContact(mockedContactsManager); // affiche "entrer le nom du contact
        verify(mockedContactsManager).addContact("Tehema",null,null);
    }

    @Test
    public void add_one_contact_without_email() throws InvalidContactNameException,InvalidEmailException {
        String input = "Tehema\n-\n0102030405";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // on simule les entrées utilisateurs (on contrôle le flux d'entrée)
        UI.askInfoForContact(mockedContactsManager); // affiche "entrer le nom du contact
        verify(mockedContactsManager).addContact("Tehema",null,"0102030405");
    }

    @Test
    public void add_one_contact_without_phone_number() throws InvalidContactNameException , InvalidEmailException{
        String input = "Tehema\ntehema@gmail.com\n-";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UI.askInfoForContact(mockedContactsManager);
        verify(mockedContactsManager).addContact("Tehema","tehema@gmail.com",null);
    }

    @Test
    public void list_contacts() throws InvalidContactNameException,InvalidEmailException {
        UI.askForListContacts(mockedContactsManager);
        verify(mockedContactsManager).printAllContacts();
    }

    @Test
    public void search_contact_by_name() throws InvalidContactNameException,InvalidEmailException {
        String input = "Tehema";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UI.askForSearchingByName(mockedContactsManager);
        verify(mockedContactsManager).searchContactByName("Tehema");
    }

    @Test
    public void save_in_csv() throws InvalidContactNameException,InvalidEmailException {
        String input = "contactTest";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UI.askForSaveInCSV(mockedContactsManager);
        verify(mockedContactsManager).searchContactByName("Tehema");
    }

}