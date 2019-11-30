package MonsterHunter;

public class Player {
    private int health;
    private int speed;
    private int attack;
    private String name;
    private int xp;
    private int level;
    private int totalHealth;
    Player(int hp, int speed, String name) {
        this.totalHealth = hp;
        this.speed = speed;
        this.attack = 4;
        this.name = name;
        this.xp = 0;
        this.level = 1;
        this.health = this.totalHealth;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int attack() {
        return (int) (Math.random() * (Math.floor(this.attack*this.speed)) + 1);
    }

    public int getHealth() {
        return this.health;
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }
}
