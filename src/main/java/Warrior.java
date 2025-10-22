public class Warrior extends Character{
    private int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public void performHeavyAttack (Character character){
        if (character.health - strength > 0){
            character.health -= strength;
        } else {
            character.status = Status.DEAD;
        }
    }

    public void enterBerserkMode (){
        this.status = Status.FURIOUS;
    }

    public int getStrength(){
        return strength;
    }
}
