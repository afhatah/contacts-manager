package com.fredericboisguerin.insa;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.util.List;

public class GUITest {

    private List mockedList;
    private ContactsManager mockedContactsManager;

    @Before
    public void setUp() {
        mockedContactsManager = mock(ContactsManager.class);
    }

    @Test
    public void add_one_contact() throws InvalidEmailException, InvalidContactNameException {
        String input = "Tehema - -";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // on simule les entrées utilisateurs (on contrôle le flux d'entrée)
        UI.askInfoForContact(); // affiche "entrer le nom du contact
        verify(mockedContactsManager).addContact("Tehema",null,null);

    }

}