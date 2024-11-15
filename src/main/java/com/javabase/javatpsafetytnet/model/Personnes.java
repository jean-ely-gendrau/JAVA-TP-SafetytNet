package com.javabase.javatpsafetytnet.model;

import java.util.ArrayList;
import java.util.List;

public class Personnes {

    List<Personnes> personnes = new ArrayList<Personnes>();

    public Personnes() {
    }

    public Personnes(List<Personnes> personnes) {
        this.personnes = personnes;
    }

    // Getter

    public List<Personnes> getPersonnes() {
        return personnes;
    }

    // Setter

    public void setPersonnes(List<Personnes> personnes) {
        this.personnes = personnes;
    }
}
