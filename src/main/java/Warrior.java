public class Warrior extends Character{
    private int strength;

    Warrior(String name, int health, int strength){
        super(name, health);
        this.strength = strength;
    }

    public void performHeavyAttack(Character target){
        target.health -= 30;

    }

    public void enterBerserkMode(){
        this.status = Status.FURIOUS;
    }

    public int getStrength() {
        return strength;
    }

}
