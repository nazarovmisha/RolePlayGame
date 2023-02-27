public class Battle {
    public void fight(Entity monster,Entity hero){
        int turn=1;
        boolean isFightEnded=false;
        while (!isFightEnded){
            System.out.println("Ход" + turn + "!!!");

            if (turn++%2!=0){
                isFightEnded=makeHit(monster,hero);
            }else {
                isFightEnded=makeHit(hero,monster);
            }
        }
    }

    public boolean makeHit(Entity attacker, Entity defender){
int hit = attacker.fight();
int defenderHealth = defender.getHealth()-hit;
if (hit !=0){
    System.out.println(String.format("%s атаковал, удар %d единиц здоровья!", attacker.getName(), hit));
    System.out.println(String.format("У %d осталось %s единиц здоровья!", defender.getName(), defenderHealth));
}
        return false;
    }
}
