import java.io.IOException;

public class Seller extends Entity {

    public Seller(String name, int health, int gold, int dexterity, int experience, int powerAttack) {
        super(name, health, gold, dexterity, experience, powerAttack);
    }

    public static void sell(Entity player) throws IOException {
        player.setHealth(player.getHealth() + 50);
        player.setGold(player.getGold() - 30);
        System.out.printf("");
        System.out.println();
    }


    enum Goods {
        POTIONS("Зелье");
        Goods(String enumSeller) {
        }
    }
}



