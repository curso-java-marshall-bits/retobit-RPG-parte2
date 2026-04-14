public class Warrior extends Character{
    int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void performHeavyAttack(Character target){
        target.receiveDamage(this.strength);

    }
    public void enterBerserkMode(){
        this.status = Status.FURIOUS;
    }
}
