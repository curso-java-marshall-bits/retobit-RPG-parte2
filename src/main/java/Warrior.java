public class Warrior extends Character {

    protected int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);          // reutiliza el constructor de Character
        this.strength = strength;     // lo nuevo, propio del guerrero
    }


    public void performHeavyAttack(Character target) {
        target.health = target.health - this.strength;
    }

    public void enterBerserkMode() {
        this.status = Status.FURIOUS;

    }

    public int getStrength() {
        return this.strength;
    }
}