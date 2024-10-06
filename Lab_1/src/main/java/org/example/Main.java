package org.example;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.lang.System;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static EntityManagerFactory entities = Persistence.createEntityManagerFactory("jpa-hibernate-example");
    public static void main(String[] args) {
        //Creating workspace for JPA
        EntityManager entityManager = entities.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        //Creating objects
        Profession p1 = new Profession("Proffesion_1",2);
        Profession p2 = new Profession("Proffesion_2",3);
        Character c1 = new Character("Character_1",1,p1);
        Character c2 = new Character("Character_2",2,p2);
        Character c3 = new Character("Character_3",3,p2);

        Profession[] profession_list = {p1,p2};
        Character[] character_list = {c1,c2,c3};
        // Inserting data into database
        for (Profession profession:profession_list) {
            entityManager.persist(profession);
        }

        for (Character character:character_list) {
            entityManager.persist(character);
            character.getProfession().getCharacters().add(character);
        }
        for (Profession profession:profession_list) {
            entityManager.merge(profession);
        }
        entityTransaction.commit();

        //Printing all data in original order (Task 2)

        entityTransaction.begin();
        System.out.println("All Professions:");
        List<Profession> professions = entityManager.createQuery("SELECT p FROM Profession p", Profession.class).getResultList();
        for (Profession profession:profession_list) {
            System.out.println("Profession:"+profession.getName()+" base armor: "+profession.getBaseArmor()+", characters:");
            for (Character character:profession.getCharacters()) {
                System.out.println("- "+character.getName()+" Level: "+character.getLevel());
            }
        }
        entityTransaction.commit();
        // Stream API playtime (Task 3)
        // professions
        Set<Profession> allProfessions = professions.stream()
                .collect(Collectors.toSet());

        // Print all professions
        System.out.println("\nAll Professions( Stream api):");
        allProfessions.forEach(profession ->
                System.out.println("Profession: " + profession.getName() + ", Base Armor: " + profession.getBaseArmor())
        );

        //characters
        Set<Character> allCharacters  = professions.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .collect(Collectors.toSet());
        // print all characters
        System.out.println("\nAll characters (Stream api):");
        allCharacters.forEach(character -> System.out.println("- " + character.getName() + " Level: " + character.getLevel()));

        // Stream API filtering (Task 4)
        System.out.println("All characters with level >1 and reverse sorted");
        professions.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .filter(character -> character.getLevel() > 1)
                .sorted(Comparator.comparingInt(Character::getLevel).reversed())
                .forEach(character -> System.out.println("- " + character.getName() + " Level: " + character.getLevel()));

        //end
        entityManager.close();
        entities.close();
    }

}