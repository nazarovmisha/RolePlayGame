public class Entity implements Fighter {
  private String name;
  private int health;
  private int gold;
  private int dexterity;
  private int experience;
  private int powerAttack;

    public Entity(String name, int health, int gold, int dexterity, int experience, int powerAttack) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.experience = experience;
        this.powerAttack = powerAttack;
    }

    @Override
    public void fight() {

    }
}
