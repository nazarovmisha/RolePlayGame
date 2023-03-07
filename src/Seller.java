import java.io.BufferedReader;
import java.io.IOException;

public class Seller extends Entity {
    private static BufferedReader br;
    public Seller(String name, int health, int gold, int dexterity, int experience, int powerAttack) {
        super(name, health, gold, dexterity, experience, powerAttack);
    }




    public static void sell(Entity player) throws IOException {
        if (player.getGold() >= 30) {
            player.setHealth(player.getHealth() + 50);
            player.setGold(player.getGold()-30);
            System.out.printf("");
            System.out.println();
        }
        else {
            System.out.printf("У тебя только %d золота, не хватает %n", player.getGold());
            Realm.printNavigation();
            Realm.command(br.readLine());
        }
    }

    enum Goods {
        POTIONS("Зелье");

        Goods(String enumSeller) {
        }
    }
}


