package MonsterHunter;

import java.util.ArrayList;

public class Game {
    private Container bag = new Container(0, 10);
    private Enemy en = new Enemy(10, 2,"Skeleton");
    private Player hero = new Player(20, 4, "Henry The Hero");
    private Item gold = new Item(0.03, 1, "currency", 0);
    private Item silver = new Item(0.02,0.5,"currency", 0);
    private Item copper = new Item(0.01, 0.1, "currency", 0);
    private Item lesser_health_potion  = new Item(0.2, 2, "potion", 0);
    private Item minor_health_potion = new Item(0.2, 3, "potion", 0);
    private Item superior_health_potion = new Item(0.2, 6, "potion", 0);
    private Item small_bag = new Item(0.0, 10, "inventory", 15);

    private ArrayList<Item> consumable = new ArrayList<>();
    private ArrayList<Item> weapons = new ArrayList<>();
    private int rounds = 0;
    Game() {
        this.consumable.add(gold);
        this.consumable.add(silver);
        this.consumable.add(copper);
        this.consumable.add(lesser_health_potion);
        this.consumable.add(minor_health_potion);
        this.consumable.add(superior_health_potion);
        this.consumable.add(small_bag);
        //this.weapons.add();
    }

    public boolean play() {
        int hero_attack = hero.attack();
        int en_attack = en.attack();
        System.out.printf("Hero HP:\t %d\t Enemy HP:\t %d\n", hero.getHealth(), en.getHealth());
        en.setHealth(en.getHealth() - hero_attack);
        hero.setHealth(hero.getHealth() - en_attack);

        if (hero.getHealth() <= 0 || en.getHealth() <= 0) {
            System.out.printf("Hero HP:\t %d\t Enemy HP:\t %d\n", hero.getHealth(), en.getHealth());
            drop();
            if (this.rounds < 10) {
                hero.setXp(hero.getXp() + hero.getLevel()*2);
                if (hero.getXp() >= hero.getLevel()*10) {
                    hero.setLevel(hero.getLevel() + 1);
                    hero.setHealth((int) Math.floor(hero.getTotalHealth()*1.25));
                    hero.setTotalHealth((int) Math.floor(hero.getTotalHealth()*1.25));
                    hero.setXp(0);
                }
                if (hero.getHealth() <= 3) {
                    hero.setHealth(hero.getHealth() + (int)this.consumable.get(4).worth);
                }
                System.out.printf("\nCurrent XP: %d\nCurrent level: %d\n",hero.getXp(), hero.getLevel());
                en.setHealth(10);
                this.rounds++;
                System.out.print("\033[H\033[2J");
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private void drop() {
        int pick = (int) (Math.random() * this.consumable.size());
        if (bag.getWeigth() >= bag.getCapacity() && this.consumable.get(pick).type == "inventory") {
            System.out.println("You can't carry anymore...");
        } else {
            bag.setWeigth(bag.getWeigth() + this.consumable.get(pick).weight);
            switch(this.consumable.get(pick).type)
            {
                case "currency":
                    bag.setGold(bag.getGold() + this.consumable.get(pick).worth);
                    System.out.printf("Dropped %.2f gold!\nYou now have:\t%.2f\n",
                            this.consumable.get(pick).worth, bag.getGold());
                    break;
                case "potion":
                    bag.setPotion((int) (bag.getPotion() + 1));
                    System.out.printf("Dropped a potion, you have %d now\n", bag.getPotion());
                    break;
                case "inventory":
                    bag.setCapacity(this.consumable.get(pick).capacity);
                    System.out.printf("You've increased the slots in your bag now! new size %.2f\n", bag.getCapacity());
                    break;
            }
            System.out.printf("Total weight is:	%.2f/%.2f\n",  bag.getWeigth(), bag.getCapacity());
        }
    }

	/*
		Checks if you've gathered enough XP to level up. if not it does nothing
	 */

    private void level() {

    }

}
