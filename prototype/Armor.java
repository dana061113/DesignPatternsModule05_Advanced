package prototype;

public class Armor implements CloneableEntity<Armor> {
    public String name;
    public int defense;

    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public Armor clone() {
        return new Armor(name, defense);
    }
}
