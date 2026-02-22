package prototype;

public class Skill implements CloneableEntity<Skill> {
    public String name;
    public int power;

    public Skill(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public Skill clone() {
        return new Skill(name, power);
    }
}
