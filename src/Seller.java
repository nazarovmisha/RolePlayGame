import java.io.IOException;

public class Seller extends Entity {

    public Seller(String name, int health, int gold, int dexterity, int experience, int powerAttack) {
        super(name, health, gold, dexterity, experience, powerAttack);
    }

    public static void sell(Entity player) throws IOException {
        player.setHealth(player.getHealth() + 50);
        player.setGold(player.getGold() - 30);
        System.out.printf("Ты выпил зелье, у тебя %S единиц здоровья и %S монет%n", player.getHealth(), player.getGold());
    }

    enum Goods {
       POTIONS("Зелье");


        private final String textRepresentation;

        private Goods(String textRepresentation) {
            this.textRepresentation = textRepresentation;
        }

        @Override public String toString() {
            return textRepresentation;
        }

    }
}



