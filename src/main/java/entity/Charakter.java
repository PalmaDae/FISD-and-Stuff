package entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Charakter {
    long id;
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
}
