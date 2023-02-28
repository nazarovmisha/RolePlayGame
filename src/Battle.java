public class Battle {
    public void fight(Entity monster, Entity hero, Game game) {
        int turn = 1;
        boolean isFightEnded = false;
        while (!isFightEnded) {
            System.out.println("Ход" + turn + "!!!");

            if (turn++ % 2 != 0) {
                isFightEnded = makeHit(monster, hero);
            } else {
                isFightEnded = makeHit(hero, monster);
            }
        }
    }

    public boolean makeHit(Entity attacker, Entity defender) {
        int hit = attacker.fight();
        int defenderHealth = defender.getHealth() - hit;
        if (hit != 0) {
            System.out.printf("%s атаковал, удар %d единиц здоровья!%n", attacker.getName(), hit);
            System.out.printf("У %s осталось %d единиц здоровья!%n", defender.getName(), defenderHealth);
        } else {
            System.out.printf("%s промахнулся, урона нет!", attacker.getName());
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {
            System.out.println("Вы пали в бою!Враг победил!!!");
            return true;
        } else if (defenderHealth <= 0) {
            System.out.println("Враг повержен! Пир на весь мир!!!");
            System.out.printf("Вы получаете %d единиц опыта и %d единиц золота%n", defender.getExperience(), defender.getGold());
           attacker.setGold(attacker.getGold()+defender.getGold());
           attacker.setExperience(attacker.getExperience()+attacker.getExperience());
            return true;
        } else {
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}
