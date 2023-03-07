import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;

public class Realm {
    private static BufferedReader br;
    private static Battle battle = null;
    private static Entity player = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Как зовут нашего героя?");
        try {
            command(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void command(String string) {
        if (player == null) {
            player = new Hero(string, 100, 0, 30, 0, 37);
            System.out.printf("Спасти наш мир от драконов вызвался %s!" +
                    " Да будет его броня крепка и бицепс кругл!%n", player.getName());
            printNavigation();
        }
        switch (string) {
            case "1" -> {
                System.out.println(Seller.Goods.POTIONS + " стоит 30 монет, дает 50 Xp или нападаем?(купим/нападаем)");
            System.out.println("У тебя " + player.getGold() + " монет и " + player.getHealth() + " единиц здоровья"); }
            case "купим" -> {
                if (player.getGold() >= 30) {
                    try {
                        Seller.sell(player);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    printNavigation();
                    try {
                        command(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.printf("У тебя %s монет, для покупки не хватает %n" + (30 - player.getGold()) + "  монет%n", player.getGold());
                    System.out.println("В город или нападем(в город/нападем)?");
                }
            }
            case "в город", "нет" -> {
                printNavigation();
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "нападаем" -> {
                goAndFight(createFightSeller());
            }
            case "2" -> goAndFight(createMonster());
            case "3" -> System.exit(1);
            case "да" -> command("2");
        }
        try {
            command(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void goAndFight(Entity create) {
        battle.fight(create, player, new FightCallback() {
            @Override
            public void winFight() {
                System.out.printf("%s победил!!! Ты получаешь %d золота, %d опыта. У тебя осталось %s здоровья!",
                        player.getName(), player.getGold(), player.getExperience(), player.getHealth());
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void lostFight() {
            }
        });
    }

    public static Entity createFightSeller() {
        return new Seller("Торговец", 200, 500, 50, 100, 100);
    }

    public static Entity createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 10 == 0) {
            return new Goblin("Гоблин", 95, 25, 20, 20, 25);
        } else {
            return new Skeleton("Скелет!", 75, 30, 20, 20, 20);
        }
    }

    public static void printNavigation() {
        System.out.println("Чем займемся?");
        System.out.println("1. К торговцу");
        System.out.println("2. В бой");
        System.out.println("3. Выходим");
    }

    public interface FightCallback {
        void winFight();

        void lostFight();
    }
}
