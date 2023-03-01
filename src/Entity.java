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
    public int fight() {
        if ((dexterity * 2) > (int) (Math.random() * 100)) {
            return powerAttack;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public Entity setName(String name) {
        this.name = name;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public Entity setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getGold() {
        return gold;
    }

    public Entity setGold(int gold) {
        this.gold = gold;
        return this;
    }

    public int getDexterity() {
        return dexterity;
    }

    public Entity setDexterity(int dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public int getExperience() {
        return experience;
    }

    public Entity setExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public int getPowerAttack() {
        return powerAttack;
    }

    public Entity setPowerAttack(int powerAttack) {
        this.powerAttack = powerAttack;
        return this;
    }
}
