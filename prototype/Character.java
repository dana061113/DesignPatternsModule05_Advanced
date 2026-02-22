package prototype;

import java.util.*;

public class Character implements CloneableEntity<Character> {

    public int health, strength, agility, intelligence;
    public Weapon weapon;
    public Armor armor;
    public List<Skill> skills = new ArrayList<>();

    public Character clone() {
        Character copy = new Character();
        copy.health = health;
        copy.strength = strength;
        copy.agility = agility;
        copy.intelligence = intelligence;
        copy.weapon = weapon.clone();
        copy.armor = armor.clone();
        for (Skill s : skills) {
            copy.skills.add(s.clone());
        }
        return copy;
    }
}
