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

    public boolean makeHit(Entity attacker, Entity defender, Entity){
int hit = attacker.fight();
int defenderHealth = defender.getHealth()-hit;
    }
}
