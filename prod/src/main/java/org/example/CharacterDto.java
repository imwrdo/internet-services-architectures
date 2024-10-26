package org.example;

public class CharacterDto {
    private String name;
    private int level;
    private String profession;
    public CharacterDto(String name, int level, String profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }
    @Override
    public String toString() {
        return "Character DTO: name"
                + name
                + ", level"
                + level
                + ", profession"
                + profession;
    }
}
