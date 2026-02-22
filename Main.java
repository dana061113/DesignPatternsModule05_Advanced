import singleton.*;
import builder.*;
import prototype.*;

public class Main {

    public static void main(String[] args) {

        // SINGLETON TEST (Multithread)
        Logger logger = Logger.getInstance();
        logger.setLogLevel(LogLevel.INFO);

        Runnable task = () -> {
            Logger.getInstance().log("Thread message", LogLevel.INFO);
        };

        new Thread(task).start();
        new Thread(task).start();

        // BUILDER TEST
        ReportStyle style = new ReportStyle("White", "Black", 14);
        IReportBuilder builder = new TextReportBuilder();
        builder.setHeader("Game Report");
        builder.addSection("Stats", "Player statistics...");
        builder.setFooter("End of Report");
        builder.setStyle(style);
        builder.getReport().export();

        // PROTOTYPE TEST
        Character hero = new Character();
        hero.health = 100;
        hero.weapon = new Weapon("Sword", 50);
        hero.armor = new Armor("Steel Armor", 30);
        hero.skills.add(new Skill("Fireball", 70));

        Character cloneHero = hero.clone();
        cloneHero.weapon.name = "Magic Sword";

        System.out.println("Original Weapon: " + hero.weapon.name);
        System.out.println("Cloned Weapon: " + cloneHero.weapon.name);
    }
}
