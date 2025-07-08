public class Warrior extends Character{
    int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void performHeavyAttack(Character target){
        target.health -= this.strength;
    }

    public void enterBerserkMode(){
        this.status = Status.FURIOUS;
    }
}
