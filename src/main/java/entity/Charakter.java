package entity;

import lombok.Getter;

@Getter
public class Charakter {
    int id;
    String name;
    String playerName;
    Race race;
    Clasz clasz;
    int level;
    int strength;
    int intelligence;
    int wisdom;
    int charisma;
    int dexterity;
    int constitution;
    int speed;
    int armorClass;
    int initiative;
    int hitPoints;
    int temporaryHitPoints;
    int hitDice;
    int gold;
    int silver;
    int copper;

    public Charakter(int id, String name, String playerName, Race race, Clasz clasz, int level, int strength, int intelligence, int wisdom, int charisma, int dexterity, int constitution, int speed, int armorClass, int initiative, int hitPoints, int temporaryHitPoints, int hitDice, int gold, int silver, int copper) {
        this.id = id;
        this.name = name;
        this.playerName = playerName;
        this.race = race;
        this.clasz = clasz;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.speed = speed;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.hitPoints = hitPoints;
        this.temporaryHitPoints = temporaryHitPoints;
        this.hitDice = hitDice;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
    }
}
