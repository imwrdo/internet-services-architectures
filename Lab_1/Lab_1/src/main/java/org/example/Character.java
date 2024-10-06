package org.example;

import javax.persistence.*;

@Entity
public class Character {
    @Id
    private String name;
    private int level;
    @ManyToOne
    private Profession profession;

    public Character(String name, int level, Profession profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }
    public Character() {

    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public Profession getProfession() {
        return profession;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    @Override
    public String toString() {
        return "Character: "+name+" Level: "+level;
    }
}
