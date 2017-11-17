package com.fredericboisguerin.insa;

public class Contact {
    String name;
    String email;
    String phoneNumber;

    public String toStringforCSV() {
        String ch = name+",";
        if (email!= null)
            ch += email;
        ch += ",";
        if (phoneNumber!=null)
            ch += phoneNumber;
        return ch;
    }

    public String toString() {
        String ch = name;
        if (email!= null)
            ch += ", " + email;
        if (phoneNumber!=null)
            ch += ", " + phoneNumber;
        return ch;
    }
}
