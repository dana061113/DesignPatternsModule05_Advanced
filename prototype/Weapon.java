package prototype;

public class Weapon implements CloneableEntity<Weapon> {
    public String name;
    public int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public Weapon clone() {
        return new Weapon(name, damage);
    }
}
