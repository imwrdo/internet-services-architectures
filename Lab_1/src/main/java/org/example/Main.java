package org.example;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.lang.System;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
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

        // Stream API and DTO (Task 5)
        List<CharacterDto> allCharactersDto = professions.stream()
                .flatMap(profession ->profession.getCharacters().stream())
                        .map(character -> new CharacterDto(
                                character.getName(),
                                character.getLevel(),
                                character.getProfession().getName()
                        ))
                .collect(Collectors.toList());
        // printing
        System.out.println("Character DTO collection:");
        allCharactersDto.stream()
                .forEach(dto-> System.out.println(dto));

        // Serialization (Task 6)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("professions.dat"))) {
            oos.writeObject(profession_list);  // Serialize the collection of professions
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization (reading categories from a binary file)
        Profession[] deserializedProfessions;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("professions.dat"))) {
            deserializedProfessions = (Profession[]) ois.readObject();  // Deserialize the collection
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Printing deserialized professions
        System.out.println("Deserialized Professions and their Characters:");
        for (Profession profession : deserializedProfessions) {
            System.out.println("Profession: " + profession.getName() + " Base Armor: " + profession.getBaseArmor());
            for (Character character : profession.getCharacters()) {
                System.out.println("- " + character.getName() + " Level: " + character.getLevel());
            }
        }
        // Task 7

        ForkJoinPool customThreadPool = new ForkJoinPool(4);  // Custom thread pool with 4 threads

        try {
            customThreadPool.submit(() -> {
                Set<Profession> professionSet = Set.of(deserializedProfessions);

                professionSet.parallelStream()
                        .forEach(profession -> {
                            System.out.println("Processing Profession: " + profession.getName());
                            profession.getCharacters().forEach(character -> {
                                try {
                                    Thread.sleep(500);  // Simulate workload with delay
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Character: " + character.getName() + " Level: " + character.getLevel());
                            });
                        });
            }).get();  // Wait for all tasks to complete
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();  // Ensure thread pool is properly shut down
        }
        //end
        entityManager.close();
        entities.close();
    }

}