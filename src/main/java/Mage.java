public class Mage extends Character {
    //Nuevas propiedades solo para MAGE
    private int mana;

    //Contructor
    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public void castSpell(Character target) {

        if (this.mana - 10 < 0) {
            return;
        }
        this.mana -= 10;
        target.health -= 10;
        target.status = Status.POISONED;

    }

    public void heal(Character target) {
        this.mana -= 15;
        target.health += 20;
    }

    public int getMana() {
        return this.mana;
    }
}
