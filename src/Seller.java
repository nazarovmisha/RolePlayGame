public class Seller extends Entity {
    public Seller(String name, int health, int gold, int dexterity, int experience, int powerAttack) {
        super(name, health, gold, dexterity, experience, powerAttack);
    }

    public static void sellGoods(String string) {
        System.out.println("Нападем на торговца или будем что-то покупать? да/нет?");

        switch (string) {
            case "нет" -> sell();

        }
    }

    public static void sell() {
        System.out.println("Что будум покупать?");
    }
}

enum Goods {
    POTIONS("Зелье");

    Goods(String enumSeller) {
    }
}


