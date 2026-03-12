public class Warrior extends Character{

    int strength;

    protected Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public void performHeavyAttack(Character target){
        target.receiveDamage(this.strength);
    }

    public void enterBerserkMode(){
        this.status = Status.FURIOUS;
    }

    public int getStrength(){
        return this.strength;
    }
}
