public class Mage extends Character {
    private int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    private void doMagic(Character target, int manaCost, int healthEffect) {
        if (this.mana - manaCost >= 0) {
            this.mana -= manaCost;
            // If we increase heal it means it is a mage attack so status changes to POISONED
            if (healthEffect < 0) {
                target.receiveDamage(Math.abs(healthEffect));
                target.status = Status.POISONED;
            } else {
                target.health += healthEffect;
            }
        } else {
            System.out.println("No hay suficiente mana para hacer la magia");
        }
    }

    public void castSpell(Character target) {
        this.doMagic(target, 10, -20);
    }

    public void heal(Character target) {
        this.doMagic(target, 15, 20);
    }

    public int getMana() {
        return this.mana;
    }
}
