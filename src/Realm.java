import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(string, 100, 0, 20, 0, 20);
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s!" +
                    " Да будет его броня крепка и бицепс кругл!", player.getName()));
            printNavigation();
            switch (string) {
                case "1": {
                    System.out.println("Нет его!");
                    command(br.readLine());
                }
                break;

                case "2": {
                    goAndFight();
                }
                break;
                case "3": {
                    System.exit(1);
                }
                break;
                case "да": {
                    command("2");
                }
                break;
                case "нет": {
                    printNavigation();
                    command(br.readLine());
                }
            }
        }
        command(br.readLine());
    }

    private void goAndFight() {
        battle.fight(createMonster(), player, new FightCallback() {
            @Override
            public  void winFight() {
                System.out.printf("%s победил!!! Ты получаешь %d золота, %d опыта. У тебя осталось %s здоровья!%n",
                        player.getName(), player.getGold(), player.getHealth());
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
