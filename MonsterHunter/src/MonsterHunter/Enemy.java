package MonsterHunter;

public class Enemy {
    private int health;
    private int speed;
    private int attack;
    private String type;
    Enemy(int hp, int speed, String type) {
        this.health = hp;
        this.speed = speed;
        this.attack = 3;
        this.type = type;
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
        return (int) (Math.random() * this.attack + 1);
    }

    public int getHealth() {
        return this.health;
    }
}
