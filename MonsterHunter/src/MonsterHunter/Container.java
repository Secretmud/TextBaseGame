package MonsterHunter;


public class Container {
    private  double capacity;
    private double gold;
    private double weigth;
    private int potion;
    Container(double gold, double capacity) {
        this.gold = gold;
        this.capacity = capacity;
        this.weigth = 0;
        this.potion = 1;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getGold() {
        return gold;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public double getWeigth() {
        return weigth;
    }

    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }
}
