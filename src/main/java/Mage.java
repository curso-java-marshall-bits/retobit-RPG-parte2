public class Mage extends Character {
    private int mana;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) {
        if(this.mana - 10 >= 0){
            this.mana -= 10;
            target.receiveDamage(20);
            target.status = Status.POISONED;
        }
    }

    public void heal(Character target) {
        this.mana -= 15;
        target.health += 20;
    }

}
