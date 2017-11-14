package com.fredericboisguerin.insa;

public class Contact {
    String name;
    String email;
    String phoneNumber;

    public String toString() {
        if (email!= null)
            return name + ", " + email + ", " + phoneNumber;
        else
            return name + ", " + phoneNumber;
    }
}
